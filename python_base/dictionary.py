import os 
#clear the screen
os.system('cls')
###################################################

fav={
    "John":"001",
    "Pete":"002",
    "Tina":"005",
    "James":"007"
}

print(fav)
print(fav["John"])

del fav["Pete"]
print(fav)

fav["John"]="003"
print(fav)

fav.update({"Mary":"008"})
print(fav)

###################################################
#input ('Press ENTER to exit')