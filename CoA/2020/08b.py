f=open("./2020/data/08a.txt","r")
# f=open("./2020/data/test.txt","r")
instructions=[]
for line in f:
    instructions.append(line)
index=0
accumulate=0
been_there=[0]
found=False
while(found==False):
    line=instructions[index]
    # print(index," ", line)
    action=line[:3]
    if action=="acc":
        accumulate+=int(line[4:])
        index+=1
    if action=="jmp":
        index+=int(line[4:])
    if action=="nop":
        index+=1 
    if index in been_there:
        print("Second time to index: ", index)
        print(accumulate)
        found=True
    been_there.append(index)   
    # print(index)
    # print(accumulate)