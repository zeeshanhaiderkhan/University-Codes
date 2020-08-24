//#question 4 a
#include <iostream>
using namespace std;

struct node{
	int data;
	node* next;
};
int getLength(node* head){
	
	if(head==NULL){
		return 0;
	}
	return 1+getLength(head->next);	
}
int main(){
	
}
