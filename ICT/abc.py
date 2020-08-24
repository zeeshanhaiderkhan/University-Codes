from math import sqrt
def nearestNeighbour(myList,querypoint):
    (x1,y1)=querypoint
    (x2,y2)=myList[0]
    dist = sqrt((x2-x1)**2+(y2-y1)**2)
    nearestPoint=(x2,y2)
    for i in myList:
        (x2,y2)=i
        if (sqrt((x2-x1)**2+(y2-y1)**2))<dist:
            nearestPoint=(x2,y2)
        return nearestPoint
listofPoints=[(3,5),(-5,4),(2,0),(1,-8),(-2,-7),(4,9),(8,0),(2,5),(1,2),(5,2),(0,8),(7,-1),(3,4)]
newPoint=(4,-3)
print(nearestNeighbour(listofPoints,newPoint))
