import os 
#clear the screen
os.system('cls')
###################################################

my_name="Tim"
nums=(1,2,3,4)
tuple_1=("John","Bob",nums,my_name, "Mary", 41)
print(tuple_1)
print(tuple_1[2])

# why not a list? because it is faster

# immutable, but work around
tuple_2=("Tina",) # !!! even with only one parameter, the comma is obligatory
tuple_3=tuple_1+tuple_2
print(tuple_3)
print(len(tuple_3))
print(tuple_3[0:2])

tuple_4=tuple_3[0:2]+tuple_3[3:5]+(tuple_3[len(tuple_3)-1:len(tuple_3)])
print(tuple_4)
###################################################
#input ('Press ENTER to exit')