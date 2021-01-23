#!usr/bin/env python3
file=open("filename.ext")
print(file.readline()) # Fresh first line, from index 0 to EOL
print(file.readline()) # Second line, from index to EOL
print(file.read()) # rest of file, from current index to EOF

file.close()  # OPEN - USE - CLOSE

# with for single block of code using file, automaticly closing it:
with open("filename.ext") as file:
    print(file.readline())
    print(file.readline())
    print(file.read())

# rpint line for line
with open("filename.ext") as file:
    for line in file:
        print(line.strip().upper())

# using a list to read a file
file = open("filename.ext")
lines = file.readlines()
file.close()
lines.sort()
print(lines)

# Modes: 
# default r: readonly, 
# default t: textmode,
# b: binary mode,
# w: writing only + create or overwrite/truncate !!! OPENING MEANS EMPTY FILE, 
# x: open for exclusive creation (fails if file exists),
# a: append, 
# +: open for updating, read & write
with open("filename.ext","w") as file:
    file.write("Hello World!")
# returns (when succesfull) the number of chars it wrote
