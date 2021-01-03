hexa_code=0
count_valid=0

def reset():
    print("RESET")
    global hexa_code
    hexa_code=0

def set(var):
    global hexa_code
    if var=="byr":
        hexa_code+=1
    if var=="iyr":
        hexa_code+=2
    if var=="eyr":
        hexa_code+=4
    if var=="hgt":
        hexa_code+=8
    if var=="hcl":
        hexa_code+=16
    if var=="ecl":
        hexa_code+=32
    if var=="pid":
        hexa_code+=64
    #if var=="cid":
    #    hexa_code+=128
    

f=open("./CoA/2020/data/04a.txt","r")
print("START START START")
for line in f:
    print("New line")
    if line.count(":")==0:
        print("Empty line")
        print(hexa_code)
        if(hexa_code==127):
            print("Found valid")
            count_valid+=1
        reset()
    else:
        index=0
        for i in range(line.count(":")):
            index=line.index(":")
            print(line[index-3:index], end=' ')
            set(line[index-3:index])
            line=line[index+1:]
print(count_valid)