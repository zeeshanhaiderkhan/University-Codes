//question5 C
	#include <iostream>
	using namespace std;
	int Q[10],size=10;
	int frontA=-1,frontB=size;
	int rearA=-1,rearB=size;
	
	void enqueueA(int ele){
		if(frontA ==-1 && rearB != 0){
			frontA++;
		}
		else if((frontA==0 && rearA==size-1) || rearA+1==rearB){
			cout<<"Queue Overflow"<<endl;
			return;
		}
		rearA++;
		Q[rearA]=ele;
	}
	
	void enqueueB(int ele){
		//if full
		if(frontB == size && rearA != size-1){
			frontB--;
		}
		else if((rearB==0 && frontB==size-1) || rearB-1 == rearA){
			cout<<"Queue Overflow"<<endl;
		}
		rearB--;
		Q[rearB]=ele;
		
	}
	
	int dequeueA(){
		if(rearA==-1 || frontA>rearA){
			cout<<"Queue Underflow";
			rearA=-1;frontA=-1;
		}
		else{
			frontA++;
			return Q[frontA-1];
		}
	}
	int dequeueB(){
		if(rearB == size || frontB<rearB){
			cout<<"Queue Underflow";
			rearB=size;frontB=size;
			//default value
		}
		else{
			frontB--;
			return Q[frontB+1];
		}
	}
int main(){
	
		for(int i=1;i<=5;i++){
			enqueueA(i);
		}
		
		for(int i=6;i<=10;i++){
				enqueueB(i);
		}
		cout<<"Queue A"<<endl;
		while(rearA != frontA-1){
			cout<<dequeueA()<<" ";
		}
		cout<<"\nQueue B"<<endl;
		while(rearB-1 != frontB ){
			cout<<dequeueB()<<" ";
		}
		
	}
