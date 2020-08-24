class LinkedList():
	def __init__(self,data,next=None):
		self.data=data
		self.next=next
	def __repr__(self):
		return str(self.data)
	def __sum__(self,other):
		return self.data+other.data
	def set_next(self,next):
		self.next=next
	def __str__(self):
		return str(self.data)
	def print_list(self):
		temp=self
		while temp != None:
			print(temp,end=" ")
			temp=temp.next
		print()
	def append(self,data):
		temp=self
		while temp.next != None:
			temp=temp.next
		temp.next=LinkedList(data)
class BST():
	def __init__(self,data,left=None,right=None):
		self.data=data
		self.left=left
		self.right=right
	def append(self,data):
		temp=self
		if left
		if data > left.data:
			self.append
if __name__=="__main__":
	headNode = LinkedList(1)
	headNode.append(2)
	headNode.append(3)
	headNode.append(4)
	headNode.append(5)
	headNode.print_list()