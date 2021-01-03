f=open("./2015/data/02a.txt","r")
totaal=0
for line in f:
    l = int(line[:line.index("x")])
    line=line[line.index("x")+1:]
    w =int(line[:line.index("x")])
    line=line[line.index("x")+1:]
    h = int(line)
    # print("l: ",l," w: ",w," h: ",h)
    side1=l*w
    side2=w*h
    side3=h*l
    smallside=side1
    if side2<smallside:
        smallside=side2
    if side3<smallside:
        smallside=side3
    totaal+=2*side1 + 2*side2 + 2*side3 +smallside
print(totaal)
