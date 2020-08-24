//Question 5 (a)
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
	else if(rear+1 == size){
		cout<<"Full!"<<endl;
		return;
	}
	
	rear++;
	Q[rear]=ele;
}
int dequeue(){
	if(front>rear ){
		cout<<"Empty!"<<endl;
	}
	else{
		front++;
		return Q[front-1];
	}
}

void partA(){
	for(int i=1;i<=10;i++){
		enqueue(i);
	}
	for(int i=0;i<10;i++){
		push(dequeue());
	}
	for(int i=0;i<10;i++){
		cout<<pop()<<" ";
	}
}


int main(){
	partA();
}
