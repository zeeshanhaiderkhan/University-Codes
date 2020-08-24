	//assign 2 =lab q1
	#include <iostream>
	using namespace std;
	int stack[5],size=5;
	int topA=-1,topB=size;
	int li=size/2,ri=size/2;
	int input_count=1;
	bool C_once;
	
	void pushA(int ele){
		
		if(topA== size-1 or topA+1==topB or topA== li ){
			cout<<"FULL!"<<endl;
			return;
		}
		else{
			topA++;
			stack[topA]=ele;
		}
	}
	
	void pushB(int ele){
		//if full
		if(topB==0 or topB-1==topA or topB==ri){
			cout<<"FULL"<<endl;
			return;
		}
		else{
			
			topB=topB-1;
			stack[topB]=ele;
		}
	}
	
	int popA(){
		if(topA==-1){
			cout<<"Empty";
			return -1111;
		}
		else{
			topA--;
			return stack[topA+1];
		}
	}
	
	void insert_left(int ele){
	if( li != -1){
		stack[li]=ele;
		li--;
	}
	else{
		cout<<"Left Full"<<endl;
	}
}

void insert_right(int ele){
	if(ri != size){
		stack[ri]=ele;
		ri++;
	}
	else{
		cout<<"Right Full"<<endl;
	
		
	}
}

void pushC(int ele){	//this methods starts inserting elements in middle of the list
						//in the form of zig zag
	if(li==ri && topA!=li && topB!=li){
		stack[li]=ele;
		li--;ri++;
		C_once=true;
	}
	else if(li == -1 && ri == size ||  (ri==topB && li==topA) ){
		cout<<"stack Full"<<endl;
	}
	else{
		if(input_count%2 != 0){
			insert_left(ele);
		}
		else{
			insert_right(ele);
		}
		input_count++;
	}
}

int popC(){
	
	if(C_once && li==ri){
		C_once= false;
		return stack[li];
	}
	else if(C_once && (input_count+1)%2 != 0){
			ri--;
			return stack[ri+1];	
		}
	else if(C_once){
			li++;
			return stack[li];
		}
	
	return -1;
		

}

int popB(){
		if(topB == size){
			cout<<"Empty";
			return -1111;//default value
		}
		else{
			topB++;
			return stack[topB-1];
		}
	}

int main(){

}
