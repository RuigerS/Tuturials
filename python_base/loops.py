import os 
#clear the screen
os.system('cls')
###################################################

counter=0

while (counter<10):
    print("Counter is: %s" % counter)
    counter+=1
###################################################

name="John"
for x in name:
    print(x)

name=["John","Bob","Tina"]
for x in name:
    print(x)

name={
    "1":"First",
    "John":"001",
    "Pete":"002",
    "Tina":"005",
    "James":"007"
}
for x in name:
    print(x)
for key, value in name.items():
    print(key)
    print(value)
for x, y in name.items():
    print(x)
    print(y)

