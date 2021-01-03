import hashlib
print(hashlib.md5("abcdef609043".encode()).hexdigest())
key="bgvyzdsv"
found=False
counter=0
while found==False:
    tmpkey=key+str(counter)
    hashed=hashlib.md5(tmpkey.encode()).hexdigest()
    if hashed[:6]=="000000":
        found=True
        print("Count ",counter)
        print("Tmpkey ",tmpkey)
        print("Hashed ",hashed)
    counter+=1