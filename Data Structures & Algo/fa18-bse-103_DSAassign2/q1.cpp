	//assign 2 =lab q1
	#include <iostream>
	using namespace std;
	int stack[5],size=5;
	int topA=-1,topB=size;
	
	void pushA(int ele){
		
		if(topA== size-1 or topA+1==topB){
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
		if(topB==0 or topB-1==topA){
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
		pushA(1);
		pushA(2);
		pushA(3);
		pushB(5);
		pushB(4);
		pushB(3);
		for(int i=0;i<5;i++){
			cout<<stack[i]<<" ";
		}
	}
