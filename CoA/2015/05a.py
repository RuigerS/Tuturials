f=open("./2015/data/05a.txt","r")
nices=0
for line in f:
    line.strip()
    numvowels=line.count("a")+line.count("e")+line.count("i")+line.count("o")+line.count("u")
    twiceinrow=False
    for i in range(len(line)-1):
        if line[i]==line[i+1]:
            twiceinrow=True
    forbiddenstrings=line.count("ab")+line.count("cd")+line.count("pq")+line.count("xy")
    if numvowels>=3 and twiceinrow and forbiddenstrings==0:
        nices+=1
print(nices)