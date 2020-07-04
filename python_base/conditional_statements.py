import os 
#clear the screen
os.system('cls')
###################################################
#   if else elif


num=10
if(num>10):
    print("Num gt 10")

elif(num==10):
    print("Num = 10") 

else:
    print("Num lt 10")


###################################################
# Logical operators:
#   and or not
num=30
if(num>20) and (num<100):
    print("between 20 & 100")

elif (num<20) and (num>0):
    print("between 0 and 20")

if(num>20) or (num<100):
    print("Ja, duh")

