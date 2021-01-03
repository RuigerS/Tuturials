f=open("./CoA/2020/data/02a.txt","r")
valid=0
for line in f:
    first=int(line[:line.index("-")])
    print(first)
    second=int(line[line.index("-")+1:line.index(" ")])
    print(second)
    rule = line[line.index(" ")+1:line.index(":")]
    print(rule)
    code = line[line.index(":")+2:]
    print(code)
    if code[first-1]==rule and code[second-1]!=rule:
        valid+=1
        print("found 1st "+code[first-1]+code[second-1] ) 
    elif code[second-1]==rule and code[first-1]!=rule:
    #elif code[second-1]==rule: #FOUT!! want sluit niet dubbeling uit
        valid+=1
        print("found 2nd "+code[first-1]+code[second-1] )
    print(valid)
f.close()