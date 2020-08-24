//q3A
#include <iostream>
using namespace std;
//part a -> print even values
int stack[10],top=-1,size=10;

void push(int ele){
		
	if(top== size-1 ){
			cout<<"FULL!"<<endl;
			return;
		}
		else{
			top++;
			stack[top]=ele;
		}
}
int pop(){
		if(top==-1){
			cout<<"Empty";
		}
		else{
			top--;
			return stack[top+1];
		}
	}


int main(){
		int input;
	for(int i=0;i<10;i++){
		cout<<"Enter Element : ";
		cin>>input;
		push(input);
	}
	for(int i=0;i<10;i++){
		input = pop();
		if(input%2 == 0){
			cout<<input<<" ";
		}
	}
}
