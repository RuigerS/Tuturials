import os 
#clear the screen
os.system('cls')
###################################################

print ("'String' within a string")
print ('"String" within a string')
print ("\"String\" within \na string")

my_string="my Name is SOME name"
print (my_string.upper())
print (my_string.lower())
print (my_string.capitalize())
print (my_string.title())
print (my_string.swapcase())
print (len(my_string))
print (my_string[0])
print (my_string[3:7])
print (my_string[3:len(my_string)])
print (my_string.split(" "))
print (my_string.split(" ")[3])

###################################################
input ('Press ENTER to exit')
