n=tuple(input())
sum1=0
tup=()
for i in range(len(n)):
    if n[i]=='.':
        tup=tup+(sum1,)
        sum1=0
    else:
        sum1+=1
tup=tup+(sum1,)
print(tup)

    
