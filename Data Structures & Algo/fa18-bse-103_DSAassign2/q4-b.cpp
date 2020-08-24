//q4-b

#include <iostream>
using namespace std;
struct node{
	int data;
	node* next;
};

node* a=NULL;
node* b= NULL;

void compare(node* a,node* b){
	if(a==NULL && b==NULL){
		return;
	}
	cout<<a->data<<"   "<<b->data<<endl;
	compare(a->next,b->next);
}

int main(){

}
