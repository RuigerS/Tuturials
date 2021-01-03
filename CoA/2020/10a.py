f=open("./2020/data/10a.txt","r")
# f=open("./2020/data/test.txt","r")
adapters=[]
for line in f:
    line=line.strip()
    adapters.append(int(line))
adapters.sort()
joltages=[0]
go_looking=True
while go_looking:
    go_looking=False
    for i in joltages:
        for j in adapters:
            for k in range(3):
                if j==i+k+1 and j not in joltages:
                    go_looking=True
                    joltages.append(j)
                    joltages.sort()
joltages.append(joltages[len(joltages)-1]+3)
diflist=[0,0,0]
for i in range(len(joltages)-1):
    dif=joltages[i+1]-joltages[i]
    diflist[dif-1]=diflist[dif-1]+1
print("1 diff: ", diflist[0],"\n2 diff: ", diflist[1],"\n3 diff: ", diflist[2])
print(diflist[0]*diflist[2])