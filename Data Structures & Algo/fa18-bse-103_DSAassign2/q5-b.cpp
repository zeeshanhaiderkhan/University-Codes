//Question 5 (B)
#include <iostream>
using namespace std;

int Q[10],front=-1,rear=-1,size=10;
int stack[10],top=-1;
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

void enqueue(int ele){
	if(rear==-1){
		front++;
	}
	else if( (rear+1 == size && front ==0 ) || rear+1 == front ) {
		cout<<"Full!"<<endl;
		return;
	}
	
	rear++;
	if(rear == size){
		rear =0;
	}
	Q[rear]=ele;
}

int dequeue(){
	if(front>rear || front == -1 ){
		cout<<"Empty!"<<endl;
	}
	else{
		front++;
		if(front == size+1){
			front =0;
		}
		return Q[front-1];
	}
}

void partB(){
	for(int i=1;i<=10;i++){
		enqueue(i);
	}
	for(int i=0;i<10;i++){
		push(dequeue());
	}
		
	rear=-1;front=-1;
	for(int i=0;i<10;i++){
		enqueue(pop());
	}
	for(int i=0;i<10;i++){
		cout<<dequeue()<<" ";
	}
}


int main(){
	partB();
}
