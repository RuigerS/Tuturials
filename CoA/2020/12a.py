f=open("./CoA/2020/data/12a.txt","r")
# f=open("./CoA/2020/data/test.txt","r")

# N0, E1, S2, W3
windstreek=[[0,-1],[1,0],[0,1],[-1,0]]
position=[0,0]
richting=1

for line in f:
    if line[0]=='N':
        position[0]+=windstreek[0][0]*int(line[1:])
        position[1]+=windstreek[0][1]*int(line[1:])
    elif line[0]=='E':
        position[0]+=windstreek[1][0]*int(line[1:])
        position[1]+=windstreek[1][1]*int(line[1:])
    elif line[0]=='S':
        position[0]+=windstreek[2][0]*int(line[1:])
        position[1]+=windstreek[2][1]*int(line[1:])
    elif line[0]=='W':
        position[0]+=windstreek[3][0]*int(line[1:])
        position[1]+=windstreek[3][1]*int(line[1:])
    elif line[0]=='F':
        position[0]+=windstreek[richting][0]*int(line[1:])
        position[1]+=windstreek[richting][1]*int(line[1:])
    elif line[0]=='L':
        richting=richting-int(int(line[1:])/90)
        while(richting<0):
            richting+=4
    elif line[0]=='R':
        richting=richting+int(int(line[1:])/90)
        while(richting>3):
            richting-=4



print("positie:",position)
print("positief:",abs(position[0]),abs(position[1]))
print("Manhattan:",int(abs(position[0])+abs(position[1])))