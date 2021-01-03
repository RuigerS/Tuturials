f=open("./2015/data/03a.txt","r")
input=f.read()
x1=1000
x2=1000
x=1000
xmax=x
xmin=x
y1=1000
y2=1000
y=1000
ymax=y
ymin=y
map=[[0 for i in range(2000)] for j in range(2000)]
map[x1][y1]+=1
counterstep=0
for ch in input:
    if counterstep%2==0:
        x=x1
        y=y1
    else:
        x=x2
        y=y2
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
    if counterstep%2==0:
        x1=x
        y1=y
    else:
        x2=x
        y2=y
    counterstep+=1
print(xmin," ", xmax," ",ymin," ",ymax)
count=0
for i in range(2000):
    for j in range(2000):
        if map[i][j]>0:
            count+=1
print(count)