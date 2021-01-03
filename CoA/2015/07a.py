def dobinary(var):
    stringbin=""
    for i in range(15,-1,-1):
        if(var>=2**i):
            stringbin=stringbin+"1"
            var-=2**i
        else:
            stringbin=stringbin+"0"
    return stringbin

def binary(stringbin):
    newval=0
    for i in range(15,-1,-1):
        if stringbin[15-i]=="1":
            newval+=2**i
    return newval
    
def donot(var):
    notval=int(var)
    stringbin=dobinary(notval)
    newval=0
    for i in range(15,-1,-1):
        if stringbin[15-i]=="0":
            newval+=2**i
    return newval

def doleft(val,var):
    leftval=int(val)
    shift=int(var)
    stringbin=dobinary(leftval)
    for i in range(shift):
        stringbin=stringbin[1:]+"0"
    return binary(stringbin)

def doright(val,var):
    rightval=int(val)
    shift=int(var)
    stringbin=dobinary(rightval)
    for i in range(shift):
        stringbin="0"+stringbin[:-1]
    return binary(stringbin)

def doand(val1,val2):
    stringbin1=dobinary(int(val1))
    stringbin2=dobinary(int(val2))
    stringbin=""
    for i in range(16):
        if stringbin1[i]==stringbin2[i]:
            stringbin=stringbin+stringbin1[i]
        else:
            stringbin=stringbin+"0"
    return binary(stringbin)

def door(val1,val2):
    stringbin1=dobinary(int(val1))
    stringbin2=dobinary(int(val2))
    stringbin=""
    for i in range(16):
        if stringbin1[i]=="1" or stringbin2[i]=="1":
            stringbin=stringbin+"1"
        else:
            stringbin=stringbin+"0"
    return binary(stringbin)


f=open("./2015/data/07a.txt","r")
#f=open("./2015/data/test.txt","r")
wires={}
extraround=5
for line in f:
    line=line.strip()
    wire=line[line.index("->")+3:]
    # print(wire)
    wires[wire]=line[:line.index(" ->")]
# print(wires)
afound=False
while afound==False:
    for key,value in wires.items():
        if not value.isnumeric():
            # te ontleden
            if value.count("NOT")>0:
                notvalue=wires[value[4:]]
                if notvalue.isnumeric():
                    wires[key]=str(donot(notvalue))
                    print("NOT",notvalue,wires[key])
            elif value.count("LSHIFT")>0:
                var1=value[:value.index(" ")]
                var2=value[len(var1)+8:]
                lsvalue=wires[var1]
                if lsvalue.isnumeric():
                    # wires[key]=str(int(lsvalue)<<int(var2))
                    wires[key]=str(doleft(lsvalue,var2))
                    print("LS",var1,lsvalue,var2,wires[key])
            elif value.count("RSHIFT")>0:
                var1=value[:value.index(" ")]
                var2=value[len(var1)+8:]
                rsvalue=wires[var1]
                if rsvalue.isnumeric():
                    wires[key]=str(doright(rsvalue,var2))
                    # wires[key]=str(int(rsvalue)>>int(var2))
                    print("RS",var1,rsvalue,var2,wires[key])
            elif value.count("AND")>0:
                var1=value[:value.index(" ")]
                var2=value[len(var1)+5:]
                if not var1.isnumeric():
                    var1=wires[var1]
                if not var2.isnumeric():
                    var2=wires[var2]
                if var1.isnumeric() and var2.isnumeric():
                    wires[key]=str(doand(var1,var2))
                    # wires[key]=str(int(var1) & int(var2))
                    print("&",key,var1,var2,wires[key])
            elif value.count("OR")>0:
                var1=value[:value.index(" ")]
                var2=value[len(var1)+4:]
                if not var1.isnumeric():
                    var1=wires[var1]
                if not var2.isnumeric():
                    var2=wires[var2]
                if var1.isnumeric() and var2.isnumeric():
                    wires[key]=str(door(var1,var2))
                    # wires[key]=str(int(var1) | int(var2))
                    print("|",key,var1,var2,wires[key]) 
            else:
                if wires[value].isnumeric():
                    wires[key]=wires[value]       
                    print("->",key,value,wires[key])           
    if wires["lx"].isnumeric():
        extraround-=1
        if extraround<0:
            afound=True
    print(extraround)
    print("wire a:",wires["a"])
    print("wire lx:",wires["lx"])
    # print("wire d:",wires["d"])
    # print("wire e:",wires["e"])
    # print("wire f:",wires["f"])
    # print("wire g:",wires["g"])
    # print("wire h:",wires["h"])
    # print("wire i:",wires["i"])
    # print("wire x:",wires["x"])
    # print("wire y:",wires["y"])
    # afound=True