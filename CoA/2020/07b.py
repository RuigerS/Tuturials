# f=open("./CoA/2020/data/test.txt","r")
f=open("./CoA/2020/data/07a.txt","r")
my_dict={}
check=["1 shiny gold"]
result=0
for line in f:
    #parsing
    onderwerp=line[:line.index(" bags contain ")]
    # print(onderwerp)
    tmp=[]
    line=line[line.index(" bags contain ")+14:]
    # start parsing rechts
    # print(line)
    while line.count(",")>0:
        tmpline=line[:line.index(" bag")]
        # print(tmpline)
        tmp.append(tmpline)
        line=line[line.index(",")+2:]
        # print(line)
    if line[0].isnumeric():
        tmpline=line[:line.index(" bag")]
        # print(tmpline)
        tmp.append(tmpline)
    my_dict[onderwerp]=tmp
# print(my_dict)
while len(check)>0:
    check_tmp=check.pop(0)
    # print(check_tmp)
    for key,values in my_dict.items():
        if key==check_tmp[2:]:
            # print("Found")
            for val in values:
                aantal=int(val[0])
                result+=aantal
                for x in range(aantal):
                    check.append(val)

# print(my_dict)
# print(check)
# print(result)    
print(result)    