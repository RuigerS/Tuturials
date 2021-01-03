def findadjacent(y,x):
    global horizontal
    global vertical
    global map
    countlocal=0
    for richtingy in range(-1,2):
        for richtingx in range(-1,2):
            if richtingx!=0 or richtingy!=0:
                offsetcounter=0
                found=0
                while found==0:
                    found=1
                    offsetcounter+=1
                    if richtingy*offsetcounter+y>=0 and richtingy*offsetcounter+y<vertical:
                        if richtingx*offsetcounter+x>=0 and richtingx*offsetcounter+x<horizontal:
                            if map[richtingy*offsetcounter+y][richtingx*offsetcounter+x]=="#":
                                countlocal+=1
                            elif map[richtingy*offsetcounter+y][richtingx*offsetcounter+x]==".":
                                found=0
    return countlocal
        

f=open("./CoA/2020/data/11a.txt","r")
#f=open("./CoA/2020/data/test.txt","r")
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
            #print(i,j,tmp)
            if map[i][j]=="L":
                if tmp==0:
                    line=tmpmap[i][:j]+"#"+tmpmap[i][j+1:]
                    go_looking=True
                    tmpmap[i]=line
            elif map[i][j]=="#":
                if tmp>=5:
                    line=tmpmap[i][:j]+"L"+tmpmap[i][j+1:]
                    go_looking=True
                    tmpmap[i]=line
    #print(tmpmap)
    map=tmpmap.copy()
count=0
for i in range(vertical):
    for j in range(horizontal):
        if map[i][j]=="#":
            count+=1
print(count)

