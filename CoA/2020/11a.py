def findadjacent(y,x):
    global horizontal
    global vertical
    global map
    countlocal=0
    for i in range(-1,2):
        if i+y>=0 and i+y<vertical:
            for j in range(-1,2):
                if j+x>=0 and j+x<horizontal:
                    if map[i+y][j+x]=="#":
                        countlocal+=1
    if map[y][x]=="#":
        countlocal-=1
    return countlocal
        

f=open("./2020/data/11a.txt","r")
# f=open("./2020/data/test.txt","r")
count=0
horizontal=0
vertical=0
map=[]
tmpmap=[]
go_looking=True
while go_looking:
    go_looking=False
    for line in f:
        # line=line.strip()
        map.append(line)
        count+=1
        horizontal=len(line)
        vertical=count
    tmpmap=map.copy()
    for i in range(vertical):
        for j in range(horizontal):
            tmp=findadjacent(i,j)
            print(i,j,tmp)
            if map[i][j]=="L":
                if tmp==0:
                    line=tmpmap[i][:j]+"#"+tmpmap[i][j+1:]
                    go_looking=True
                    tmpmap[i]=line
            elif map[i][j]=="#":
                if tmp>=4:
                    line=tmpmap[i][:j]+"L"+tmpmap[i][j+1:]
                    go_looking=True
                    tmpmap[i]=line
    print(tmpmap)
    map=tmpmap.copy()
count=0
for i in range(vertical):
    for j in range(horizontal):
        if map[i][j]=="#":
            count+=1
print(count)

