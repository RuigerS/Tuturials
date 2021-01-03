f=open("./2015/data/05a.txt","r")
nices=0
for line in f:
    line.strip()
    twicepair=False
    for i in range(len(line)-3):
        tmp=line[i]+line[i+1]
        if line[i+2:].count(tmp)>0:
            twicepair=True
    letterrepeat=False
    for i in range(len(line)-2):
        if line[i]==line[i+2]:
            letterrepeat=True
    if twicepair and letterrepeat:
        nices+=1
print(nices)