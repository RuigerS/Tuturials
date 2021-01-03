def got_pair(findgetal,listnums):
    for i in range(len(listnums)-1):
        for j in range(i+1,len(listnums)):
            if listnums[i]+listnums[j]==findgetal:
                return True
    return False

f=open("./2020/data/09a.txt","r")
numbers=[]
preamble=25
for line in f:
    numbers.append(int(line))
    if len(numbers)>preamble:
        if not got_pair(numbers[preamble],numbers[:preamble]):
            print(numbers[preamble])
            exit()
        numbers.pop(0)    