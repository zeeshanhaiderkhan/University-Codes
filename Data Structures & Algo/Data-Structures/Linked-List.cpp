#include <iostream>
using namespace std;
class LinkedList(){
	
struct Node{
	int data;
	Node* next;
};

private:
	Node* head;
public:
	
	LinkedList(int data, Node* next){	//constructor
		head = new Node;
		head->data=data;
		head->next=next;	
	}
	
	void insert_node_atStart(int data);
	void insert_node_atEnd(int data);
	void insert_node_atSpecific(int data, int pos);	//pos is index
	
	void delete_node_atStart();
	void delete_node_atEnd();
	void delete_node_atSpecific(int pos); // pos is index
	void delete_node_atMatch(int data);	//first matching data will be deleted
	
	Node* create_node(int data, Node* next); // create stand-alone node
	
	int search_node(int data);	// returns position, if not found will return == -1
	
	void display_nodes_specific(int start, int end);	// for reverse use python reverse indexing method
	void display_nodes_all();
	void display_nodes_reverse();
	
	//////////////////////
	// Stack Operations//
	////////////////////
	void push(int data);
	int pop();
	
	//////////////////////
	// Queue Operations//
	////////////////////
	//Implement using two stacks
	
	//insert data in array or linked list in zig zag 
	
	//add two polynomials
	//create,add
	
	//Implement Priority Queue
	// also using two stacks
	
	//implemenet bubble sort algorithm on linked-list and as well as array
	//implement selection sort
	//implement insertion sort
	//quick sort
	

int main(){
	
}

};

