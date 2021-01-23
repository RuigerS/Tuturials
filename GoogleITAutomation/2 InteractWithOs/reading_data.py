#!usr/bin/env python 
import os
import sys
######################################
# Command-line arguments
######################################
print(sys.argv)
#  python reading_data.py first,second,3 ==> ['reading_data.py', 'first,second,3']
#  python reading_data.py first, second, 3 ==> ['reading_data.py', 'first,', 'second,', '3']
#  python reading_data.py first second 3 ==> ['reading_data.py', 'first', 'second', '3']
######################################
# Exit status
######################################
filename=sys.argv[1]
if not os.path.exists(filename):
    with open(filename,"w") as f:
        f.write("New file created\n")
else:
    print("Error: file {} already exists".format(filename))
    sys.exit(1)
######################################
# Environment variables
######################################
print("HOME:",os.environ.get("HOME",""))  # dictionary.get() ==> if None then return 2nd parameter
print("SHELL:",os.environ.get("SHELL",""))
print("FRUIT:",os.environ.get("FRUIT",""))

######################################
# input()
######################################
name=input("Please enter name: ")
getal=int(input("Please enter number: "))
print("Hello,",name, "number:",getal)
# In Python2: use raw_input() instead of input(). input() == eval(raw_input(x))
######################################
# STD streams
######################################
data=input("This is STDIN: ")
print("Write to STDOUT: "+data)
print("Generate error to STDERR: "+ data +1)  # Concatenate string + int raises Type error

