import os 
#clear the screen
os.system('cls')
###################################################

my_name="Tim"
nums=[1,2,3,4]
first_names=["John","Bob",nums,my_name, "Mary", 41]
print(first_names)
print(first_names[3])
print(first_names[2][2])

first_names[0]="Tina"
print(first_names[0])

del first_names[0]
del first_names[1]
del first_names[3]
print(first_names)

first_names.append("John")
print(first_names)
print(len(first_names))
print(first_names[len(first_names)-1])


###################################################
#input ('Press ENTER to exit')