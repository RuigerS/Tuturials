f=open("./2015/data/06a.txt","r")
action=0
map=[[0 for i in range(1000)] for j in range(1000)]
for line in f:
    line.strip()
    if line.startswith("toggle "):
        line=line[7:]
        action=2
    elif line.startswith("turn off "):
        line=line[9:]
        action=-1
    else:
        line=line[8:]
        action=1
    x1=int(line[:line.index(",")])
    line=line[line.index(",")+1:]
    y1=int(line[:line.index(" ")])
    line=line[line.index(" ")+1:]
    line=line[line.index(" ")+1:]
    x2=int(line[:line.index(",")])
    line=line[line.index(",")+1:]
    y2=int(line)
    for i in range(x1,x2+1): #INCLUSIVE!!
        for j in range(y1,y2+1): #INCLUSIVE
            map[i][j]+=action
            if map[i][j] < 0:
                map[i][j]=0
# count them
count=0
for i in range(1000):
    for j in range(1000):
        count+=map[i][j]
print(count)