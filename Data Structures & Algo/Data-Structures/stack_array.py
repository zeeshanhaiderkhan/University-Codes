class Stack():
	def __init__(self):
		self.array=[]
	def push(self,data):
		self.array.append(data)
	def pop(self):
		try:				
			item_toReturn = self.array[-1]	
			del self.array[-1]
			return item_toReturn
		except IndexError:
			print("Stack Underflow!")
			return -1
def toPush_Func():
	return "This function is Pushed"		
if __name__=="__main__":
	stack = Stack()
	for i in range(0,11):
		stack.push(toPush_Func)
		