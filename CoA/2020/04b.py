hexa_code=0
count_valid=0

def reset():
    print("RESET")
    global hexa_code
    hexa_code=0

def set(var, val):
    global hexa_code
    val=val.strip()
    if var=="byr":
        if int(val)>=1920 and int(val)<= 2002:
            hexa_code+=1
    if var=="iyr":
        if int(val)>=2010 and int(val)<= 2020:
            hexa_code+=2
    if var=="eyr":
        if int(val)>=2020 and int(val)<= 2030:
            hexa_code+=4
    if var=="hgt":
        if val.count("cm")>0:
            val=val[:val.index("cm")]
            if int(val)>=150 and int(val)<=193:
                hexa_code+=8
        elif val.count("in")>0:
            val=val[:val.index("in")]
            if int(val)>=59 and int(val)<=76:
                hexa_code+=8
    if var=="hcl":
        if(val[0]=="#"):
            if len(val)==7:
                val=val[1:]
                try:
                    int(val,16)
                except:
                    print(val+"INVALID HEXA")
                else:
                    hexa_code+=16
    if var=="ecl":
        if val=="amb" or val=="blu" or val=="brn" or val=="gry" or val=="grn" or val=="hzl" or val=="oth":
            hexa_code+=32
    if var=="pid":
        if len(val)==9:
            try:
                int(val)
            except:
                print(val+" NOT A NUMBER")
            else:
                hexa_code+=64
    #if var=="cid":
    #    hexa_code+=128
    
f=open("./CoA/2020/data/04a.txt","r")
print("START START START")
for line in f:
    #print("New line")
    if line.count(":")==0:
        #print("Empty line")
        print(hexa_code)
        if(hexa_code==127):
            #print("Found valid")
            count_valid+=1
        reset()
    else:
        index=0
        for i in range(line.count(":")):
            index=line.index(":")
            #print(line[index-3:index], end=' ')
            var=line[index-3:index]
            line=line[index+1:]
            if(line.count(" ")>0):
                index=line.index(" ")
                #print(line[:index], end=' ')
                val=line[:index]
            else:
                #print(line)
                val=line
            set(var,val)
            line=line[index+1:]
            
print(count_valid)