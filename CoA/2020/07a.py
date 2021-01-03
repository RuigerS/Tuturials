# f=open("./CoA/2020/data/test.txt","r")
f=open("./CoA/2020/data/07a.txt","r")
my_dict={}
check=["shiny gold"]
result=[]
for line in f:
    #parsing
    onderwerp=line[:line.index(" bags contain ")]
    # print(onderwerp)
    tmp=[]
    line=line[line.index(" bags contain ")+14:]
    # start parsing rechts
    # print(line)
    while line.count(",")>0:
        tmpline=line[2:line.index(" bag")]
        # print(tmpline)
        tmp.append(tmpline)
        line=line[line.index(",")+2:]
        # print(line)
    if line[0].isnumeric():
        tmpline=line[2:line.index(" bag")]
        # print(tmpline)
        tmp.append(tmpline)
    my_dict[onderwerp]=tmp
# print(my_dict)
while len(check)>0:
    check_tmp=check.pop(0)
    for key,values in my_dict.items():
        if check_tmp in values:
            if key not in check:
                check.append(key)
            if key not in result:
                result.append(key)
# print(my_dict)
# print(check)
# print(result)    
print(len(result))    