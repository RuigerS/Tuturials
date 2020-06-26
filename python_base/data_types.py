import os 
#clear the screen
os.system('cls')
###################################################

#Data types:
#-Strings
string = "String"
print(string)
print("")
#-Numbers
number = 39
print(number)
print("")
#-Lists (mutable; aka arrays)
list = [23, 53, 64, 89]
print(list[0],list[1],list[2],list[3])
print(list)
print("")
#-Tuples (immutable lists)
tuple = (23, 53, 64, 89)
print(tuple[0],tuple[1],tuple[2],tuple[3])
print(tuple)
print("")
#-Dictionaries (sets of key:value pairs; aka hashes)
dictionary={
    "One":"First",
    "Two":"Second",
    "Three":"Third"
}
print(dictionary["One"],dictionary["Two"],dictionary["Three"])
print(dictionary)
print("")


###################################################
input ('Press ENTER to exit')