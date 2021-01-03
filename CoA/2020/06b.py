f=open("./CoA/2020/data/06a.txt","r")
list=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
sum=0
for line in f:
    line.strip()
    if line=="\n":
        print("Empty Line")
        for x in range(len(list)):
            if list[x] !='0':
                sum+=1
        print(sum)
        list=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    else:
        for x in range(len(list)):
            if line.count(list[x])<1:
                # print(list[x])
                list[x]='0'
print(sum)