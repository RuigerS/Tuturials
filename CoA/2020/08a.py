f=open("./2020/data/08a.txt","r")
# f=open("./2020/data/test.txt","r")
instructions=[]
trynext=0
for line in f:
    instructions.append(line)
while(trynext<100):
    trynext+=1
    commandsjmpplusnop=0
    index=0
    accumulate=0
    been_there=[0]
    found=False
    while(found==False):
        line=instructions[index]
        # print(index," ", line)
        action=line[:3]
        if commandsjmpplusnop==trynext:
            if action=="jmp":
                action="nop"
                print("Changed action ",index,"jmp to nop")
            elif action=="nop":
                action="jmp"
                print("Changed action ",index,"nop to jmp")
        if action=="acc":
            accumulate+=int(line[4:])
            index+=1
        if action=="jmp":
            index+=int(line[4:])
            commandsjmpplusnop+=1
        if action=="nop":
            index+=1 
            commandsjmpplusnop+=1
        if index in been_there:
            print("Second time to index: ", index)
            print(accumulate)
            print("Total commands jmp | nop ",commandsjmpplusnop)
            found=True
        if index>=len(instructions):
            found=True
            print("Terminating with 0")
            print(accumulate)
            trynext=102
        been_there.append(index)   
        # print(index)
        # print(accumulate)