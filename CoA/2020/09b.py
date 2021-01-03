numbers=[]
f=open("./2020/data/09a.txt","r")
# f=open("./2020/data/test.txt","r")
# tofind=127
tofind=133015568
# preamble=5
preamble=25
for line in f:
    numbers.append(int(line))
    if len(numbers)>preamble:
        for i in range(len(numbers)-1):
            count=0
            smallest=-1
            largest=-1
            for j in range(i,len(numbers)):
                count+=numbers[j]
                if numbers[j]<smallest or smallest<0:
                    smallest=numbers[j]
                if numbers[j]>largest or largest<0:
                    largest=numbers[j]
                if count==tofind:
                    print("Smallest: ",smallest)
                    print("Largest: ",largest)
                    print("Sum: ",smallest+largest)
                    exit()
                if count>tofind:
                    break    
        numbers.pop(0)    