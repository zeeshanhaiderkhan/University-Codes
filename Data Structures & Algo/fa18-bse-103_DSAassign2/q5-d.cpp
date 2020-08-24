#include <iostream>
using namespace std;
//declaring queues
int Q[10],front=-1,rear=-1,size=10;
int cQ1[5],fQ1=-1,rQ1=-1,size_cQ1=5;
int cQ2[5],fQ2=-1,rQ2=-1,size_cQ2=5;

void enqueue_Q(int ele){
	if((front==0 && rear==size-1) || rear+1==front){
		cout<<"FULL"<<endl;
		return;
	}
	else if(front==size || front==-1){
		front=0;
	}
	rear++;
	Q[rear%size]=ele;
	
}
void enqueue_cQ1(int ele){
	if((fQ1==0 && rQ1==size_cQ1-1) || rQ1+1==fQ1){
		cout<<"FULL"<<endl;
		return;
	}
	else if(fQ1 ==size_cQ1 || fQ1==-1){
		fQ1=0;
	}
	rQ1++;
	cQ1[rQ1%size_cQ1]=ele;
	
}

void enqueue_cQ2(int ele){
	if((fQ2==0 && rQ2==size_cQ2-1) || rQ2+1==fQ2){
		cout<<"FULL"<<endl;
		return;
	}
	else if(fQ2==size_cQ2 || fQ2==-1){
		fQ2=0;
	}
	rQ2++;
	cQ2[rQ2%size_cQ2]=ele;
	
}


int dequeue_Q(){
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

int dequeue_cQ1(){
	if(fQ1>rQ1 || fQ1 == -1 ){
		cout<<"Empty!"<<endl;
	}
	else{
		fQ1++;
		if(fQ1 == size_cQ1+1){
			fQ1 =0;
		}
		return cQ1[fQ1-1];
	}
}
int dequeue_cQ2(){
	if(fQ2>rQ2 || fQ2 == -1 ){
		cout<<"Empty!"<<endl;
	}
	else{
		fQ2++;
		if(fQ2 == size_cQ2+1){
			fQ2 =0;
		}
		return cQ2[fQ2-1];
	}
}
//set of question values
void input_vals(){
	enqueue_Q(3);
	enqueue_Q(5);
	enqueue_Q(6);
	enqueue_Q(7);
	enqueue_Q(2);
	enqueue_Q(1);
	enqueue_Q(9);
	enqueue_Q(8);
	enqueue_Q(12);
	//enqueue_Q(10);
}

void partD(){
	input_vals();
	int loop_cond=rear-front;
	if(rear<front){
		loop_cond=rear+front;
	}
	for(int i=0;i<=loop_cond;i++){
		if(i%2==0){
			enqueue_cQ1(dequeue_Q());
		}
		else{
			enqueue_cQ2(dequeue_Q());
		}
	}
	
}

int main(){
	partD();
	
}
