f=open("./CoA/2020/data/02a.txt","r")
#f=open("test.txt","w+")
#f.write("line 1\r\n")
#f.write("line 2\r\n")
valid=0
for line in f:
    minimum=int(line[:line.index("-")])
    print(minimum)
    maximum=int(line[line.index("-")+1:line.index(" ")])
    print(maximum)
    rule = line[line.index(" ")+1:line.index(":")]
    print(rule)
    code = line[line.index(":")+2:]
    print(code)
    aantal=code.count(rule)
    if aantal>=minimum and aantal<=maximum:
        valid+=1
    print(valid)
f.close()