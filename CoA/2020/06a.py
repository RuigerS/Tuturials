f=open("./CoA/2020/data/06a.txt","r")
list=[]
sum=0
for line in f:
    line.strip()
    if line=="\n":
        print("Empty Line")
        sum+=len(list)
        print(len(list))
        list=[]
    else:
        for x in range(len(line)):
            if line[x].isalpha() and line[x] not in list:
                print(line[x])
                list.append(line[x])
print(sum)