//#question 4 a
#include <iostream>
using namespace std;

struct node{
	int data;
	node* next;
};
int getLength(node* head,int len){
	
	if(head==NULL){
		return len;
	}
	getLength(head->next,len+1);	
}

//part B
void addNode(node* head, int val){
	if(head->next==NULL){
		head->next=new node;
		head->next->data= val;
		head->next->next= NULL;
		return;
	}
	addNode(head->next,val);
}

int main(){
	node* head = new node;
	head->data =1;
	head->next=NULL;
	addNode(head,2);
	addNode(head,3);
	
	cout<<getLength(head,0);
}
