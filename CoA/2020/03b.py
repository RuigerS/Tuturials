f=open("./CoA/2020/data/03a.txt","r")
count1=0
positionr1=0
count3=0
positionr3=0
count5=0
positionr5=0
count7=0
positionr7=0
countdouble=0
positionrdouble=0
line_count=0
for line in f:
    line=line.strip()
    relpos1=positionr1%(len(line)) 
    relpos3=positionr3%(len(line)) 
    relpos5=positionr5%(len(line)) 
    relpos7=positionr7%(len(line)) 
    relposdouble=positionrdouble%(len(line)) 
    if line[relpos1]=="#":
        count1+=1
    if line[relpos3]=="#":
        count3+=1
    if line[relpos5]=="#":
        count5+=1
    if line[relpos7]=="#":
        count7+=1
    if line_count%2==0:
            if line[relposdouble]=="#":
                countdouble+=1
            positionrdouble+=1
    positionr1+=1
    positionr3+=3
    positionr5+=5
    positionr7+=7
    line_count+=1
print(count1)
print(count3)
print(count5)
print(count7)
print(countdouble)
print(count1*count3*count5*count7*countdouble)