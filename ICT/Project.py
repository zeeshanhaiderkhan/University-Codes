def nereastPoint(newPoint,searchPoints):
    magnitude = []
    for i in searchPoints:
        distance = ((newPoint[0] - i[0])**2+(newPoint[1] - i[1])**2)**0.5
        magnitude.append(distance)
    temp = min(magnitude)
    count = -1
    for i in magnitude:
        count+=1
        if i==temp:
            reference = count
            break
    
    return reference    

searchPoints = [(3,5),(-5,4),(2,0),(1,-8),(-2,-7),(4,9),(8,0)]
newPoint = (4,-3)
answer = nereastPoint(newPoint,searchPoints)
print("The Least Distance of ",newPoint," From all given points is ", searchPoints[answer])
