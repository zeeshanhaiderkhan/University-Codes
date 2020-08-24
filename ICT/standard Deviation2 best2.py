i=1
squareSUM=0
averageX=0
while i<6:
    print("enter number",i)
    n=int(input())
    averageX=(averageX+n)
    squareSUM+=(n)**2
    i=i+1
averageX=averageX/(i-1)
print("the mean value is",averageX)
standardDEV=((squareSUM/(i-1))-(averageX)**2)**0.5
print("the standard-Deviation is",standardDEV)

