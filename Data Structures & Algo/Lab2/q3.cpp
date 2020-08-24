//Question 3 dsa lab2
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
			return -1111;
		}
		else{
			top--;
			return stack[top+1];
		}
	}
void partA(){
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

int factorial(int n){
	if(n==0) return 1;
	return n*factorial(n-1);
}

void partB(){
	int input;
	for(int i=0;i<5;i++){
		cout<<"Enter Element : ";
		cin>>input;
		push(input);
	}
	
	for(int i=0;i<5;i++){
		cout<<factorial(pop())<<endl;
	}
}

void calculator(){
			
}

int main(){
	partB();
}
