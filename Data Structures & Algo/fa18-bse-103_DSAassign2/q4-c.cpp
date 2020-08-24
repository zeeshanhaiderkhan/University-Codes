//q4-c
#include <iostream>
using namespace std;


struct node{
	int data;
	node* next;
};
node* head=NULL;

//this method returns a node //creates a node
node* create_node(int val,node* next){
	node* newNode = new node;
	newNode->data=val;
	newNode->next=next;
	return newNode;
}

//add node method for any node
void addNode(node* head, int val){
	if(head->next==NULL){
		head->next=create_node(val,NULL);
		return;
	}
	addNode(head->next,val);
}

//add node method for global defined node
void addNode(int val){
	if(head==NULL){
		head=create_node(val,NULL);
		return;
	}
	if(head->next==NULL){
		head->next=create_node(val,NULL);
		return;
	}
	addNode(head->next,val);
}



int main(){
	
}
