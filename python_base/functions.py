import os 
#clear the screen
os.system('cls')
###################################################

# function(arguments)
# declare before call
# Python runs top-down
def namer(name):
    print("Hello %s" % name)

namer("John")

def namer2(first_name,last_name):
    print("Hello %s %s" % (first_name, last_name))

namer2("John", "Last")

###################################################

def namer3(first_name,last_name):
    return (first_name+" "+last_name)

print(namer3("pietje","puk"))

###################################################
