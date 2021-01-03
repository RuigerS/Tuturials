f=open("./2015/data/01a.txt","r")
input=f.read()
floor=0
count=0
for ch in input:
    count+=1
    if ch=="(":
        floor+=1
    if ch==")":
        floor-=1
print(floor)