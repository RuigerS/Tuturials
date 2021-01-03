f=open("./CoA/2020/data/12a.txt","r")
# f=open("./CoA/2020/data/test.txt","r")

# N0, E1, S2, W3
windstreek=[[0,-1],[1,0],[0,1],[-1,0]]
windstreekturn=[[1,-1],[1,1],[1,1],[-1,1]]
position=[0,0]
waypoint=[10,-1]
richting=1

for line in f:
    line=line.strip()
    print(line, end=" ")
    print("pos:",position, end=" ")
    print("wayp:",waypoint, end=" -->> \n")
    if line[0]=='N':
        waypoint[0]+=windstreek[0][0]*int(line[1:])
        waypoint[1]+=windstreek[0][1]*int(line[1:])
    elif line[0]=='E':
        waypoint[0]+=windstreek[1][0]*int(line[1:])
        waypoint[1]+=windstreek[1][1]*int(line[1:])
    elif line[0]=='S':
        waypoint[0]+=windstreek[2][0]*int(line[1:])
        waypoint[1]+=windstreek[2][1]*int(line[1:])
    elif line[0]=='W':
        waypoint[0]+=windstreek[3][0]*int(line[1:])
        waypoint[1]+=windstreek[3][1]*int(line[1:])
    elif line[0]=='F':
        position[0]+=waypoint[0]*int(line[1:])
        position[1]+=waypoint[1]*int(line[1:])
    elif line=='L90' or line=='R270':
        richting-=1
        if richting==-1:
            richting=3
        if richting==0:
            tmp=waypoint[0]
            waypoint[0]=waypoint[1]
            waypoint[1]=-tmp
        if richting==1:
            tmp=waypoint[0]
            waypoint[0]=waypoint[1]
            waypoint[1]=-tmp
        if richting==2:
            tmp=waypoint[0]
            waypoint[0]=waypoint[1]
            waypoint[1]=-tmp
        if richting==3:
            tmp=waypoint[0]
            waypoint[0]=waypoint[1]
            waypoint[1]=-tmp
    elif line=='L180' or line=='R180':
        richting-=2
        if richting<0:
            richting+=4
        waypoint[0]=-waypoint[0]
        waypoint[1]=-waypoint[1]
    elif line=='L270' or line=='R90':
        richting+=1
        if richting==4:
            richting=0
        if richting==0:
            tmp=waypoint[0]
            waypoint[0]=-waypoint[1]
            waypoint[1]=tmp
        if richting==1:
            tmp=waypoint[0]
            waypoint[0]=-waypoint[1]
            waypoint[1]=tmp
        if richting==2:
            tmp=waypoint[0]
            waypoint[0]=-waypoint[1]
            waypoint[1]=tmp
        if richting==3:
            tmp=waypoint[0]
            waypoint[0]=-waypoint[1]
            waypoint[1]=tmp
    else:
        print(line)
    


print("positie:",position)
print("waypoint:",waypoint)
print("positief:",abs(position[0]),abs(position[1]))
print("Manhattan:",int(abs(position[0])+abs(position[1])))