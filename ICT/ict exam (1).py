def nearestNeighbor(myList, queryPoint):
    comparison=(((queryPoint[0]-myList[0][0])**2+(queryPoint[1]-(myList[1][1]))**2)**0.5)
    for i in myList:
                distance=((i[0]-queryPoint[0])**2+(i[1]-queryPoint[1])**2)**0.5
                if comparison>=distance:
                          comparison=distance
                          point=i
    return point
a=[(3,5),(-5,4),(2,0),(1,-8),(-2,-7),(4,9),(8,0)]
b=(4,-3)
print(nearestNeighbor(a,b))
