//Q5-i
#include <iostream>
using namespace std;

int deque[10],front=-1,rear=-1,size=10;

bool isEmpty(){
	if((front==-1 && rear==-1) || (!(front < rear))) return true;
	return false;
}

void shift_right(int si,int li){
	for(int i=li;i>=si;i--){
		deque[i+1]=deque[i];
	}
}

void shift_left(int si,int li){
	for(int i=si-1;i<li;i++){
		deque[i]=deque[i+1];
	}
}

void push(int x){
	if(isEmpty()){
		front=0;rear=0;
		deque[0]=x;
	}
	else if(rear != size-1){
		shift_right(front,rear);
		front--;
		deque[front]=x;
	}	
	else{
		cout<<"IS FULL"<<endl;
	}
}
int pop(){
	if(isEmpty()){
		cout<<"Empty"<<endl;
	}
	else{
	front++;
	return deque[front-1];
	}
}
void inject(int x){
	if(isEmpty()){
		front=0;rear=0;
		deque[0]=x;
	}
	else if(rear != size-1){
		rear++;
		deque[rear]=x;
	}
	else{
		cout<<"Is FULL"<<endl;
	}
}
int eject(){
	if(isEmpty()){
		cout<<"empty"<<endl;
	}
	else{
		rear--;
		return deque[rear+1];
	}
}
	
int main(){
	
}
