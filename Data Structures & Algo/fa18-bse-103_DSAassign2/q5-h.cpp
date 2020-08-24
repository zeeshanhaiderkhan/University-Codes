
#include <iostream>

using namespace std;

struct node{
	string element;
	int priority;
	int place;
};

node queue[10];    
int rear=0,front=-1,priority=0;;

void display(){
	cout<< "Name"<<endl<<"Place"<<endl<<"Priority"<<endl;
	for(int i=0;i<10;i++){
		if(queue[i].priority==priority){
		cout<<queue[i].element<<"\t  "<<queue[i].place<<"\t  "<< queue[i].priority<<"\n";
		}	
	}    	
}

int main(){
	int item;
	string name;
	cout<<"Enter priority number";
		cin>>item;
		priority=item;
	for(;rear!=9;rear++){   
		cout<<"Enter Name: ";
		cin>>name;
		queue[rear].element=name;
		queue[rear].priority=item;
		queue[rear].place=rear;
		if(item<priority){
			priority=item;
		}
		cout<<"Enter priority number";
		cin>>item;
	}
	display();
}
    



