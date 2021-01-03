# testcase1="BFFFBBFRRR"
# testcase2="FFFBBBFRRR"
# testcase3="BBFFBBFRLL"

def get_seat_id(var):
    row=0
    column=0
    if var[0]=="B":
        row+=64
    if var[1]=="B":
        row+=32
    if var[2]=="B":
        row+=16
    if var[3]=="B":
        row+=8
    if var[4]=="B":
        row+=4
    if var[5]=="B":
        row+=2
    if var[6]=="B":
        row+=1
    if var[7]=="R":
        column+=4
    if var[8]=="R":
        column+=2
    if var[9]=="R":
        column+=1
    seat_id=row*8+column
    # return("Rij: "+str(row)+ " Column: "+str(column)+" Seat ID: "+str(seat_id))
    return seat_id
    
# print(get_seat_id(testcase1))
# print(get_seat_id(testcase2))
# print(get_seat_id(testcase3))

f=open("./CoA/2020/data/05a.txt","r")
highest=0
for line in f:
    line=line.strip()
    x=get_seat_id(line)
    if x>highest:
        print(str(x)+">"+str(highest))
        highest=x
print(highest)        