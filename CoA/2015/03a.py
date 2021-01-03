f=open("./2015/data/03a.txt","r")
input=f.read()
x=1000
xmax=x
xmin=x
y=1000
ymax=y
ymin=y
map=[[0 for i in range(2000)] for j in range(2000)]
map[x][y]+=1
for ch in input:
    if ch=="<":
        x-=1
        if x<xmin:
            xmin=x
    if ch==">":
        x+=1
        if x>xmax:
            xmax=x
    if ch=="^":
        y-=1
        if y<ymin:
            ymin=y
    if ch=="v":
        y+=1
        if y>ymax:
            ymax=y
    map[x][y]+=1
print(xmin," ", xmax," ",ymin," ",ymax)
count=0
for i in range(2000):
    for j in range(2000):
        if map[i][j]>0:
            count+=1
print(count)