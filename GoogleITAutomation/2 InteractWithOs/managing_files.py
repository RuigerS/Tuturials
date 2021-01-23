#!usr/bin/env python3
import os
import datetime
# Remove a file or FileNotFoundError
os.remove("filename.ext")
# Rename
os.rename("old_name.ext","new_name.ext")
# check for Boolean file exists
boolean =  os.path.exists("filename.ext")
boolean = os.path.isfile("may_be_filename.ext")
size =  os.path.getsize("filename.ext")
epoch_modified =  os.path.getmtime("filename.ext")
print(datetime.datetime.fromtimestamp(epoch_modified))
absolute_path = os.path.abspath("filename.txt")

# vvv directories
# get current working directory
pwd=os.getcwd()
os.mkdir("nieuwe_directory")
os.chdir("relative_path_ dir_to_change_to")
os.rmdir("dir_to_remove") # error if not empty
listfiles=os.listdir("dir_to_list_contents")
boolean = os.path.isdir("may_be_directory")

dir="CoA"
for name in os.listdir("CoA"):
    fullname=os.path.join(dir,name) # OS generic way to add / or \ in path
    print(fullname)
