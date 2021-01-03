f=open("./2020/data/10a.txt","r")
#f=open("./2020/data/test.txt","r")
adapters=[]
for line in f:
    line=line.strip()
    adapters.append(int(line))
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
print(joltages)
print(adapters)
index=0
total=1
while index<len(joltages)-1:
    count=0
    while joltages[index]==joltages[index+1]-1:
        count+=1
        index+=1
    print(count)
    if count==2:
        total=total*2
    if count==3:
        total=total*4
    if count>3:
        total=total*(4+((count-3)*3))
    index+=1
print(total)