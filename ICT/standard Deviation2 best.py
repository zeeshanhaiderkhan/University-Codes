i=0
squareSUM=0
averageX=0
while i<=8:
    n=int(input())
    averageX=(averageX+n)
    squareSUM+=(n)**2
    i=i+1
averageX=averageX/8
print(averageX)
standardDEV=((squareSUM/i)-(averageX)**2)**0.5
print(standardDEV)

