###Using List method and For Loop//
from math import * #importing math library for pi sine and cosine
h=0.01
n=-pi
list_pi=[]
while n>=(-(pi)) and n<=(pi): #making list from -pi to pi
    list_pi.append(n)
    n+=h
list_pi.append(pi)
    
sin_der=[]
for i in list_pi: # calculating derivative and cosine of each value 
    sin_der1=(sin(i+h)-sin(i))/h
    print("derivative of sin~",sin_der1,"cos=",cos(i))
    sin_der.append(sin_der1)
    i+=h
##Question
#####If we use h=0.001, the result will be more acurate.
#####Similarly, if we use h=0.1, the result will be less precise and accurate.

#####Using simpler and while loop method##

#
#from math import *
#h=0.001
#i=-pi
#while i<=(pi):
    #x=(sin(i+h)-sin(i))/h
    #print("derivative of sin=",x,"cos=",cos(i))
    #i+=0.01

   
    
