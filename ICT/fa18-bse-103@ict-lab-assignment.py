# a+b+c=1000 then c=100-a-b-c
a=1
while a<=1000:
    b=a+1
    while b<=1000:
        c=1000-a-b
        if a**2+b**2==c**2:
            print("a=",a,"b=",b,"c=",c)
        b=b+1
    a=a+1
