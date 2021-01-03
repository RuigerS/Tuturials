f=open("./CoA/2020/data/03a.txt","r")
count=0
position=0
for line in f:
    line=line.strip()
    relpos=position%(len(line)) 
    #print(str(relpos) +" "+ str(len(line)))
    #print(relpos)
    if line[relpos]=="#":
        #print(line)
        print(line[:relpos]+"X"+line[relpos+1:], end='')
        count+=1
    else:
        print(line[:relpos]+"O"+line[relpos+1:], end='')
        
    position+=3
print(count)