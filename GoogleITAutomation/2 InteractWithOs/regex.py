#!/usr/bin/env python3
import re

log='July 31 07:51:48 mycomputer bad_proces[12345]: ERROR Performing package upgrade'
start=log.index("[")
end=log.index("]")
print(log[start+1:end])

#############################################
# With RegEx
#############################################
regex=r"\[(\d+)\]"
result=re.search(regex,log)
print(result)
print(result[1])

#############################################
# Simple exampls
#############################################
result = re.search(r"aza","plaza")  # r indicates rawstring: python will not try interpret
print(result)
result = re.search(r"aza","playa")  
print(result)  # None (Python NULL)
print(re.search(r"^x","xenon"))

print(re.search(r"p.ng","penguin"))
print(re.search(r"p.ng","clapping"))
print(re.search(r"p.ng","sponge"))
print(re.search(r"p.ng","Pangaea",re.IGNORECASE))

print(re.search(r"[Pp]ython","Python"))

print(re.search(r"[a-z]way","The end of the highway"))
print(re.search(r"[a-z]way","What a way to go"))

print(re.search(r"cloud[a-zA-Z0-9]","cloudy"))
print(re.search(r"cloud[a-zA-Z0-9]","cloud9"))

print(re.search(r"[,\.:;\?!]","cloud!"))

print(re.search(r"[^a-zA-Z]","Sentence with spaces."))
print(re.search(r"[^a-zA-Z ]","Sentence with spaces."))

print(re.search(r"cat|dog","I like cats."))
print(re.search(r"cat|dog","I like dogs."))
print(re.search(r"cat|dog","I like both cats and dogs."))
print(re.findall(r"cat|dog","I like both cats and dogs."))

print(re.search(r"Py.*n","Pygmalion"))
print(re.search(r"Py.*n","Python programming"))  # * as many a possible: match='Python programmin'
print(re.search(r"Py.*n","Pyn"))  # * includes 0 instances

print(re.search(r"[aA].*[aA]", "banana"))
print(re.search(r"[aA].*[aA]", "pineapple"))
print(re.search(r"[aA].*[aA]", "Animal kingdom"))
print(re.search(r"[aA].*[aA]", "A is for apple"))

print(re.search(r"o+l+","Goldfish"))  # + == * with a minimum of 1 instance
print(re.search(r"o+l+","Woolly")) 
print(re.search(r"o+l+","Boil")) 

print(re.search(r"p?each","each")) #
print(re.search(r"p?each","peach"))

print(re.search(r".com","welcome.com"))  # first: lcom
print(re.search(r"\.com","welcome.com"))  # truly looking fo dot

print(re.search(r"\w*","This_is_an_example_ok_123%$#678^ No no"))  # alphanumeric (letters & numbers) & _
print(re.search(r"\d+","This_is_an_example_ok_123%$#678^ No no"))  # matching digits
print(re.search(r"\s+","This_is_an_example_ok_123%$#678^ No no"))  # whitespace (space, tab, newline)

print(re.search(r"A.*a","Australian"))  
print(re.search(r"^A.*a$","Australian")) 
print(re.search(r"^A.*a$","Australia")) 

#############################################
# Advanced exampls
#############################################
result=re.search(r"^(\w*), (\w*)$","Lovelace, Ada")
print(result)
print(result.groups())
print(result[0], result[1],result[2]) # Match 0, group 1, group 2
print("{} {}".format(result[2],result[1]))

print(re.search(r"[a-zA-Z]{5}", "one two three four five six seven eight nine ten eleven"))
print(re.findall(r"[a-zA-Z]{5}", "one two three four five six seven eight nine ten eleven"))
print(re.findall(r"\b[a-zA-Z]{5}\b", "one two three four five six seven eight nine ten eleven"))
print(re.findall(r"[a-zA-Z]{5,7}", "one two three four five six seven eight nine ten eleven twelve thirteen"))
print(re.findall(r"\b[a-zA-Z]{5,7}\b", "one two three four five six seven eight nine ten eleven twelve thirteen"))
print(re.findall(r"[a-zA-Z]{5,}", "one two three four five six seven eight nine ten eleven twelve thirteen"))
print(re.findall(r"[a-zA-Z]{,5}", "one two three four five six seven eight nine ten eleven twelve thirteen"))
print(re.findall(r"\b[a-zA-Z]{,5}\b", "one two three four five six seven eight nine ten eleven twelve thirteen"))

print(re.split(r"[.!?]", "One sentence. Another one? And the last one!"))  # inside square brackets: literal, not special meaning (eg . or \.)
print(re.split(r"([.!?])", "One sentence. Another one? And the last one!"))  

print(re.sub(r"[\w.%+-]+@[\w.-]+","[REDACTED]","Received and email for go_nuts95@my.example.com"))

result=re.sub(r"^([\w .-]*), ([\w .-]*)$",r"\2 \1","Lovelace, Ada")  # r"\2 \1" translates to "result[2] result[1]"
print(result)
