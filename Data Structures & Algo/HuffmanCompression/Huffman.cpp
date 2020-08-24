/////////////////////////////////////////
///////HUFFMAN COMPRESSION//////////////
///////////////////////////////////////

#include <iostream>
#include <fstream>
#include <bits/stdc++.h> 

using namespace std;



struct huffNode{	//Node for huffman tree
	int pixel;
	int frequency;
	huffNode* left;
	huffNode* right;
};

//node for storing frequencies and other elements into array
struct pixNode{
	int pixel;
	int freq;
	
	huffNode* node;		//huffman node stored in this >> mentioned above
	string bitString;	//
};

pixNode heap[256];
int si=0,li=255;	//list



////////////////////////////////////
//////All Methods//////////////////
//////////////////////////////////

int calcHeapLen();
huffNode*  compression();
huffNode* create_huffNode(int pixel,huffNode* left, huffNode* right);
pixNode create_pixNode(int pixel,int freq,huffNode* node);
void decompression(huffNode* tree,string filename);
void discard_zeros();
void fillHeap_blank();
pixNode getMin();
void heapify_up();
void insert(pixNode newNode);
bool isLeaf(huffNode* node);
void minHeapify();
int parent(int i);
void readImageBMP(string filename);
void readTextFile(string filename);
huffNode* toHUffmanTree();

///////////////////////////////////
////////////////////////////////////
///////////////////////////////////



int parent(int i){
	return (i-1)/2;
}

void heapify_up(int i){								//i for index
	if(heap[i].freq<heap[parent(i)].freq){			//less than for min heap ,, greater than for max heap
		swap(heap[i],heap[parent(i)]);
		heapify_up(parent(i));
		
	}
}

void minHeapify(){
	for(int i=si;i<=li;i++){	//from start to end
		heapify_up(i);
	}
}

pixNode getMin(){
	swap(heap[li],heap[si]);
	li--;
	minHeapify();
	return heap[li+1];
}
void insert(pixNode newNode){
	if(li==255){
		cout<<"No more Space"<<endl;
		return;
	}
	
	li++;
	heap[li]=newNode;
	heapify_up(li);
	//minHeapify();	//to get in correct position

}


//heap code ends here


bool isLeaf(huffNode* node){
	return !node->left && !node->right;
}


huffNode* create_huffNode(int pixel, huffNode* left,huffNode* right){
	huffNode* newNode = new huffNode;
	newNode->pixel = pixel;
	newNode->left=left;
	newNode->right=right;
	
	return newNode;
}

pixNode create_pixNode(int pixel,int freq,huffNode* node){
	pixNode newNode;
	newNode.freq=freq;
	newNode.node = node;
	newNode.pixel = pixel;
	newNode.bitString="";
	return newNode;
}

//discard zeros of frequency in array

void discard_zeros(){
	while(heap[si].freq == 0){
		getMin();	//discard zeros and shrinks the array and helps in building the tree without zero frequency items in array
	}
}

int totalNoOfPixels;
huffNode* toHuffmanTree(){	//from heap to huffman tree
	pixNode sumPixNode;
	for(int i=0; si!=li ;i++){	//si is not equl to li
		//get two minimums
		pixNode min_1 = getMin();	
		pixNode min_2 = getMin();
		huffNode* huffNode1;
		huffNode* huffNode2;
		
		if(min_1.node == NULL){
			huffNode1 = create_huffNode(min_1.pixel,NULL,NULL);
			huffNode1->frequency=min_1.freq;
				
		}
		else{
			huffNode1=min_1.node;
			huffNode1->pixel = -1;
		
		}
		if(min_2.node == NULL){
			huffNode2 = create_huffNode(min_2.pixel,NULL,NULL);
			huffNode2->frequency=min_2.freq;
		}
		else{
			huffNode2= min_2.node;
			huffNode2->pixel = -1;
			
		}
		
		
		huffNode* sumHuffNode = create_huffNode(-1,huffNode1,huffNode2);
		
		
		sumPixNode = create_pixNode(-1,min_1.freq+min_2.freq,sumHuffNode);
		insert(sumPixNode);			
	}
	totalNoOfPixels=heap[li].freq;
	return heap[li].node;
	
}

int overall_bitString=0;	//for total length of table bitstrings

void printArr(int arr[], int n) 
{ 
    int i; 
    for (i = 0; i < n; ++i) 
		cout<< arr[i]; 
  
    cout<<"\n"; 
} 
  

void printHuffmanCodes(huffNode* root, int arr[], int top) 
{ 
  
    // 0 to left 
    if(root==NULL){
    	return;
	}
    if (root->left) { 
        arr[top] = 0; 
        printHuffmanCodes(root->left, arr, top + 1); 
    } 
  
    // 1 to right 
    if (root->right) { 
  
        arr[top] = 1; 
        printHuffmanCodes(root->right, arr, top + 1); 
    } 
  
    
    if (isLeaf(root)) { 
  
  	    string toAppend="";
        for (int i = 0; i < top; i++) {
        	
			if(arr[i]==1){
        			toAppend+="1";
			}
			else{
				toAppend+="0";
			}
			
        	overall_bitString++;
		}
		heap[root->pixel].bitString=(toAppend);
 		heap[root->pixel].freq=root->frequency;
	
    }

} 

	void encode(huffNode* root,string str)
{
	if (root == NULL)
	
		return;

	// found a leaf node
	if (!root->left && !root->right) {
		//cout<<root->pixel<<endl;		
		heap[root->pixel].bitString = str;
		//cout<<root->pixel<<": ";
		//cout<<str<<endl;
	}
	
	encode(root->left, str + "0");
	encode(root->right, str + "1");
}


//blank items into heap
void fillHeap_blank(){
	for(int i=0;i<256;i++){
	
	heap[i].node=NULL;
	heap[i].pixel=i;
	heap[i].freq=0;
	heap[i].bitString="";

	}
}

//calculating frequencies of textfile such as pgm
void readTextFile(string filename){
	ifstream inFile;
    inFile.open(filename.c_str(),ios::binary);	//image name		ios::binary
    int data=0;
    while(data != -1){
    	data=inFile.get();
		try{
			heap[data].freq++;	//fill heap
						
		}
		catch(exception e){
		}
	}
}

int calcHeapLen(){	//for calculating table height
	return li-si+1;
}

//reads image bmp file
void readImageBMP(string filename){ 
  
    int n = filename.length(); 
    char filename_array[n + 1];
    strcpy(filename_array, filename.c_str()); 
    
    
		FILE* f = fopen(filename_array, "rb");
		
		unsigned char info[54];
  	  	fread(info, sizeof(unsigned char), 54, f); // read the 54-byte header
		
		int width = *(int*)&info[18];
    	int height = *(int*)&info[22];
    	
    	int row_padded = (width*3 + 3) & (~3);
   	 	unsigned char* data = new unsigned char[row_padded];
    	unsigned char tmp;

	    for(int i = 0; i < height; i++)
	    {
	        fread(data, sizeof(unsigned char), row_padded, f);
	        for(int j = 0; j < width*3; j += 3)
	        {
	            int pixel = (data[j]+data[j+1]+data[j+2])/3;//converting rgb to greyscale (r+g+b)/3
	   			heap[pixel].freq++;
	   		   
	        }
	}
}


int noOfBits=0;
int totalNoOfBits=0;
int tableHeight;

huffNode* compression(){
	fillHeap_blank();	//assigning blank items to every heap item
	
	int option;
	cout<<"1. Compress Text File\n2. Compress Image BMP File\n";
	cout<<"Select: ";
	cin>>option;
	

	//filename ="screws.pgm";	//here the filename
	string filename;

	if(option==1){
		cout<<"Enter FileName test.txt\n";
		cin>>filename;
		cout<<"Opening Text File for Compression"<<endl<<endl;
		cout<<"Reading File..."<<endl<<endl;
		readTextFile(filename);//reading into array heap
	}
	else if(option==2){
		cout<<"Enter FileName.i.e test.bmp\n";
		cin>>filename;
		cout<<"Opening Image File for Compression"<<endl<<endl;
		cout<<"Reading File..."<<endl<<endl;
		readImageBMP(filename);
	}
	else{
		cout<<"Wrong Option\n Exiting...";
		exit(0);
	}
	//////////////////////////
	//Encoding the file//////
	////////////////////////
	//deletes non frequency item from heap//////	
	discard_zeros();	//discard the zero frequency items and within discard_zeros there is call to minHeapify

	cout<<"Encoding...."<<endl<<endl;
	minHeapify();
	tableHeight = calcHeapLen();	//calculates maximum number of items in table
	
	
	huffNode* tree = toHuffmanTree();	//creates the tree and returns the root node to tree
	
	int arr[10],top=0;
	
	//	printing and encoding
	cout<<"Printing Encoded Data: "<<endl;
	//printHuffmanCodes(tree, arr, top);
	encode(tree,"");
	readTextFile(filename);

   
   	//OPEN File AGAIN
	//Compressing and writing to file by getting and transferring encoded text to file
	
	ifstream inFile;
	inFile.open(filename.c_str(),ios::binary);	//image name		ios::binary
    
    cout<<"Building File for Compression..."<<endl<<endl;
	ofstream outfile;
    outfile.open("compressed.chuf");	//saves data into {compressed}.chuf >>compressed huffman file
    /////////////
    //FOR TEXT//
    ///////////
    cout<<"Compressed Data is: \n"; 
	if(option==1){
			int data=0;
    		while(true){
    		data=inFile.get();
	    	if(data == -1){
	    		break;
			}
			try{
				string bitString = heap[data].bitString;
				
				noOfBits+=bitString.length();	//calculates compressed total bits
				totalNoOfBits++;	//calculates total number of bits
				
				outfile<< bitString;	//stores to file the bitstring
			//	cout<<bitString;
			}
			catch(exception e){
				
			}
		}
		cout<<"\n\nFile Compressed Successfully!"<<endl<<endl;
		
		inFile.close();
		outfile.close();
	}
	/////////////////
	//FOR IMAGE/////
	///////////////
	else if(option==2){
		int n = filename.length(); 
    	char filename_array[n + 1];
    	strcpy(filename_array, filename.c_str()); 
    
		FILE* f = fopen(filename_array, "rb");
		
		unsigned char info[54];
  	  	fread(info, sizeof(unsigned char), 54, f); // read the 54-byte header
		
		int width = *(int*)&info[18];
    	int height = *(int*)&info[22];
    	
    	int row_padded = (width*3 + 3) & (~3);
   	 	unsigned char* data = new unsigned char[row_padded];
    	unsigned char tmp;

	    for(int i = 0; i < height; i++)
	    {
	        fread(data, sizeof(unsigned char), row_padded, f);
	        for(int j = 0; j < width*3; j += 3)
	        {
	            int pixel = (data[j]+data[j+1]+data[j+2])/3;//converting rgb to greyscale
	   		    string bitString = heap[pixel].bitString;
				
			    noOfBits+=bitString.length();	//calculates compressed total bits
				totalNoOfBits++;	//calculates total number of bits
			//	cout<<bitString;	//prints the file
				outfile<< bitString;	//stores to file the bitstring
	   		   
	        }
	        
    }
	cout<<"\n\nFile Compressed Successfully!"<<endl<<endl;
    fclose(f);
    
		
	}
	
/*	
	cout<<"Total Number of Bits: "<<totalNoOfBits*8<<endl;
	cout<<"Bits after Compresssion: "<<noOfBits<<endl;
	cout<<"Table Length(distinct items): "<<tableHeight<<endl;
	cout<<"Bits+Table after Compression: "<<tableHeight*8+overall_bitString +noOfBits<<endl<<endl;
*/
	decompression(tree,"compressed.chuf");	//decompress the data
	return tree;	//returns the root of the tree
	
}

void decompression(huffNode* tree,string filename){	//root node of tree
	cout<<"Opening Compressed File..."<<endl;
	
	ifstream inFile;
	inFile.open(filename.c_str(),ios::binary);	//image name		ios::binary
    huffNode* root =tree;
    
    cout<<"Building File for Decompression..."<<endl<<endl;
    ofstream outfile;
    outfile.open("decompressed.txt");
    
	char bin;
    while(true){
    	huffNode* codeNode=tree;
		while(!isLeaf(codeNode) ){
			bin = inFile.get();
	    	if(bin==EOF){	//for null
	    		break;
			}
	    	if(bin == '0'){	//move right
	    		codeNode = codeNode->left;
			}
			else{
				codeNode = codeNode->right;
			}
			
		}
		if(bin == EOF){
			break;
		}
		
    	outfile<<(char)codeNode->pixel;
	}
	cout<<"Decompressed Successfully!"<<endl<<endl;
	
}

int getMinCodeLength(){
	int min;
	int i=0;
	for(;i<256;i++){//for first no zero int
		if(heap[i].bitString.length() != 0){
			min=heap[i].bitString.length();
			break;
		}
	}
	for(;i<256;i++){
		if(heap[i].bitString.length()==0){
			continue;
		}
		if(heap[i].bitString.length() < min){
			min=heap[i].bitString.length();
		}
	
	}
	return min;
}


int getMaxCodeLength(){
	int max=heap[0].bitString.length();
	for(int i=0;i<256;i++){
		if(heap[i].bitString.length()==0){
			continue;
		}
		if(heap[i].bitString.length() > max){
			max=heap[i].bitString.length();
		}
	
	}
	return max;
}


void printTable(){
	cout<<"Pixel\tFrequency\tCode\tLength";
	cout<<"===================================================================\n";
	int bitLength=0;
	for(int i=0;i<256;i++){
		if(heap[i].freq==0 || heap[i].bitString.length()==0){
			continue;
		}
		else{
			cout<<i<<"\t"<<heap[i].freq<<"\t\t"<<heap[i].bitString<<"\t"<<heap[i].bitString.length()<<endl;
			bitLength+=heap[i].bitString.length()*heap[i].freq;
		}
	}
	cout<<"================\nAnalysis:\n============\n";
	cout<<"Average Code Length  : "<<(double)bitLength/totalNoOfPixels<<endl;
	cout<<"Minimum Code Length  : "<<getMinCodeLength()<<endl;
	cout<<"Maximum Code Length  : "<<getMaxCodeLength()<<endl;
	cout<<"Total Num  of  Bits  : "<<totalNoOfBits*8<<endl;
	cout<<"Bits aft Compression : "<<noOfBits<<endl;
	cout<<"Distinct Pixels      : "<<tableHeight<<endl;
	cout<<"% of Compression     : "<<(double)(totalNoOfBits*8 - noOfBits)*100/(totalNoOfBits*8)<<" %"<<endl;

}

int main(){
	cout<<"/////////////////////////////////////////\n///////HUFFMAN COMPRESSION//////////////\n///////////////////////////////////////\n\n";
	huffNode* compress= compression();	//performs all the necessary work to do
	cout<<compress->frequency<<endl;
	printTable();
}
