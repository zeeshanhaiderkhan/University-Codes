//q3-D
#include <iostream>
using namespace std;
int stack[10],top=-1,size=10;

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
		}
		else{
			top--;
			return stack[top+1];
		}
}

void display_fifo(int ele){
	if(top==-1){
		return;
	}
	display_fifo(ele=pop());
	cout<<ele<<" ";
}

int main(){
	for(int i=0;i<size;i++){
		push(i);
	}
	display_fifo(0);
}
