import os 
#clear the screen
os.system('cls')
###################################################
# fizzbuzz
# print 1 to 100
# if / 3 then print fizz
# if / 5 then print buzz
# if divisable 15 print fizzbuzz

counter=1
while(counter<=100):
    output=""
    if(counter%3==0):
        output+="fizz"
    if(counter%5==0):
        output+="buzz"
    if(len(output)>0):
        print("%s - %s" % (counter, output)) 
    else:
        print (counter) 
    counter+=1




###################################################
