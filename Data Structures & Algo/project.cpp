// C++ program to encode and decode a string using 
// Huffman Coding. 
#include <bits/stdc++.h> 
#define MAX_TREE_HT 256 
using namespace std; 


// for storing hex values
struct Node  
{  
    public: 
    string data;  
    Node *next;  
};  

Node* head = NULL;
  
// insert method
void push(Node** head_ref, string new_data)  
{  
	// simple things we did daily in lab needs not to be explained
    Node* new_node = new Node(); 
    new_node->data = new_data;  
    new_node->next = (*head_ref);  
    (*head_ref) = new_node;  
}  
  
void printList(Node *node)  {
	
	//print while node is not null   
    while (node != NULL)  
    {  
        cout<<" "<<node->data;  
        node = node->next;  
    }  
}  

// c++ has no method like .concat 
// so used simple + operator to concatinate 
string compile_list(Node*node){
	string dta="";
    while (node->next != NULL)  
    {  
        dta=dta+(node->data);
        node = node->next;  
    } 	
    return dta;
}

// data read from file is is in RGB we need to convert into hex value 
// this hex value is fead to huffman algorithm to process it.
// the decoded value is put online to convert into image back

string rgb_to_hex(int r, int g, int b)
{   
	/*	Logic:
		rgb values from image are like (240,200,15) for orange 
		hex color is #F0C80F for the same...
		we need to convert into hex co that we can recompile into image
	*/
	char buffer[128]; // buffer array for storing intermediate data
	// printf prints values depending upon  %s %d %x(hex) 
	// snprintf simply stores that value into a variable
	// purpose was to return a string 
	snprintf(buffer, sizeof(buffer), "#%X%X%X.", r,g,b);
    string str(buffer);
    return str;
}


Node* ReadBMP(char* filename, Node *head)
{
	// details of lower opening file taken from c++ dev site "fopen.com -- this is not internet copied"
	
	/*
		Let me explain a bit about it:
		With the mode specifiers above the file is open as a text file.
		In order to open a file as a binary file, a "b" character has
		to be included in the mode string. This additional "b" character
		can either be appended at the end of the string 
		(examples: "rb", "wb", "ab", "r+b", "w+b", "a+b")
		 or be inserted between the letter and the "+" sign 
		 for the mixed modes ("rb+", "wb+", "ab+").
	
		// rb means read binary
		// wb for write binary
	
	*/
	
    int i;
    
    // fopen is for opeining stream in c++ like BufferReader and ObjectStreams in java
  
    //  we also have following options:
    
    	// freopen  for reopening buffer IO stream 
    			// need to use it if image in multi-colored
    	// fclose for closing buffered stream
    	
    FILE* f = fopen(filename, "rb"); 

    if(f == NULL)
        throw "Argument Exception";		
		// Generate exception- Like throws nullpointerexception in java

    unsigned char info[54];
    fread(info, sizeof(unsigned char), 54, f); 	// fread for reading // fput for writing
    
	// read the 54-byte header
	// Note: putting a 64-byte header will give wrong output on big images.
	// made an image by using online tools

    // extract image height and width from file's header
	// int width = *(int*)&info[18];
	// int height = *(int*)&info[22];

	// manually defining output image dimensions
	// Because using upper commented code will keep the original image size
	
	int width = 23;		
	int height = 23;

    cout << endl;
    cout << "  Name: " << filename << endl;
    cout << " Width: " << width << endl;
    cout << "Height: " << height << endl;

    int row_padded = (width*3 + 3) & (~3);
    // found upper line on stackoverflow
    unsigned char* data = new unsigned char[row_padded];
    unsigned char tmp;
    
    // setting image padding to avoid missing \0 (new line)
    // causes blank image output if not used


	int pixel_count=0;
    for(int i = 0; i<10; i++)
    {
        fread(data, sizeof(unsigned char), row_padded, f);
        for(int j = 0; j < width*3; j += 3)
        {
            //  Read data by default in in BGR form we need to convert in RGB
            // so make temp variables and do simple swap as we do in class
            
            tmp = data[j];
            data[j] = data[j+2];
            data[j+2] = tmp;
            
		//	pixel_count+=1; // part of lower commented if block

			// For debugging output... This stricks in multi color images
           // cout << "R: "<< (int)data[j] << " G: " << (int)data[j+1]<< " B: " << (int)data[j+2]<< endl;
            char symbol = 219;
            
			//---- We can un comment this code part
			// to generate string type data from char array
			// un comment if block to increase compression rate.
			// its alreadt compressing to just 23x23 pixels
			
			
          // if(pixel_count<=10){
			//	string r (data[j]);
			//	std::string r((char*) data[j]);
			//	std::string b((char*) data[j+1]);
			//	std::string g((char*) data[j+2]);	
			
			int r = data[j]	;	
			int b = data[j+1];
			int g = data[j+2];
				
			// push in linked list
			push(&head,rgb_to_hex(r,g,b));
		//}
        }
    }
    
    fclose(f);	// closing stream
    return head;
}


//c++ doesn't have ArrayList for storing large input data. 
//Making Linked Lists was complex too. Decided to go for hashmaps 

// to map character to its huffman value 
map<char, string> codes; 
// to map frequency to its huffman value
map<char, int> freq; 

// Creating a Huffman tree code.. 
struct MinHeapNode 
{ 
	char data;			 // key value of type char
	int freq;			 // To store no of repetition of a character
	MinHeapNode *left, *right; // Making Left and right child can also use top and bottom 

	MinHeapNode(char data, int freq) 
	{ 
		left = right = NULL; 
		this->data = data; 
		this->freq = freq; 
	} 
}; 

// comparing in priority queue generated
struct compare 
{ 
	bool operator()(MinHeapNode* l, MinHeapNode* r) 
	{ 
		return (l->freq > r->freq); // comparinf left and right
	} 
}; 


// printing left and right nodes
void printCodes(struct MinHeapNode* root, string str) 
{ 
	if (!root) 
		return; 
	if (root->data != '$') // avoids letting last $ character can also use !-NULL 
		cout << root->data << ": " << str << "\n"; 
	printCodes(root->left, str + "0"); 
	printCodes(root->right, str + "1"); 
} 

// Here, the data consits of special characters especially # and , so, 
// we need this to handel special characters 

void storeCodes(struct MinHeapNode* root, string str) 
{ 
	if (root==NULL) 
		return; 
	if (root->data != '$') 
		codes[root->data]=str; 
	storeCodes(root->left, str + "0");  // write in method above, already explained
	storeCodes(root->right, str + "1"); 
} 


// A priority queue to store heap tree by comparing parent (top node value) 
priority_queue<MinHeapNode*, vector<MinHeapNode*>, compare> minHeap; 



// Next Step :  Build huffman tree and store data in min heap node 
void HuffmanCodes(int size) 
{ 
	struct MinHeapNode *left, *right, *top; 
	for (map<char, int>::iterator v=freq.begin(); v!=freq.end(); v++) 
		minHeap.push(new MinHeapNode(v->first, v->second)); 
	while (minHeap.size() != 1) 
	{ 
		left = minHeap.top(); 
		minHeap.pop(); 
		right = minHeap.top(); 
		minHeap.pop(); 
		top = new MinHeapNode('$', left->freq + right->freq); 
		top->left = left; 
		top->right = right; 
		minHeap.push(top); 
	} 
	storeCodes(minHeap.top(), ""); 
} 


void calcFreq(string str, int n) 
{ 
	for (int i=0; i<str.size(); i++) 
		freq[str[i]]++; 
} 


string decode_file(struct MinHeapNode* root, string s) 
{ 
	string ans = ""; 
	struct MinHeapNode* curr = root; 
	for (int i=0;i<s.size();i++) 
	{ 
		if (s[i] == '0') 
		curr = curr->left; 
		else
		curr = curr->right; 

		// check the left node
		if (curr->left==NULL and curr->right==NULL) 
		{ 
			ans += curr->data; 
			curr = root; 
		} 
	} 

	return ans+'\0'; 
} 

// Main method
int main() 
{ 
	char name[20];
	cin>>name;
	head = ReadBMP(name, head);
	string str = compile_list(head);
	string encodedString, decodedString; 
	calcFreq(str, str.length()); 
	HuffmanCodes(str.length()); 
	cout << "Frequencies:\n"; 
	
	/*for (auto v=codes.begin(); v!=codes.end(); v++) 
		cout << v->first <<' ' << v->second << endl; 
*/
	for (int i=0;i<str.length();i++) 
		encodedString+=codes[i]; 

	cout << "\nHuffman data:\n" << encodedString << endl; 

	decodedString = decode_file(minHeap.top(), encodedString); 
	cout << "\nDecoded data:\n" << decodedString << endl; 
	return 0; 
} 

