f=open("./2015/data/02a.txt","r")
totaal=0
for line in f:
    kanten=[]
    kanten.append(int(line[:line.index("x")]))
    line=line[line.index("x")+1:]
    kanten.append(int(line[:line.index("x")]))
    line=line[line.index("x")+1:]
    kanten.append(int(line))
    kanten.sort()
    # print(kanten)
    totaal+=kanten[0]*2+kanten[1]*2+kanten[0]*kanten[1]*kanten[2]
print(totaal)