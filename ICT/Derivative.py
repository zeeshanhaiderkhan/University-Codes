from math import pi
from math import sin
from math import cos
from math import radians
from math import degrees
h=0.001
x=eval(input("Enter a Number"))
x=radians(x)
derivative = (sin(x+h)-sin(x))/h
a=round(derivative,3)
b=round(cos(x),3)
x = x+h
print ("At x ",)
print ("L.H.S= ",b,"\tR.H.S= ",a)

