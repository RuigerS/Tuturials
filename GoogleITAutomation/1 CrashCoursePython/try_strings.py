def votes(params):
    for vote in params:
        print("Possible option: "+vote)

#votes("yes","no","maybe") <- 3 params where 1 expected
votes(['yes','no','maybe'])

string="1234"
print (string*3)

a="String"
print(a[2]) # starting count at 0, 2nd char (makes it the 3rd)
print(a[-2]) # 2nd char from the end

message = "a kong line"
message = message[0:2]+"l"+message[3:]
print(message)
if "f" in message: # True/False
    message.index("f") #index of

"string".upper()
"STRing".lower()

" String   ".strip()
" String   ".rstrip()
" String   ".lstrip()

print("String string String".count("in"))
"Forest".endswith("rest") #True

"12345".isnumeric()

"...".join(['this','is','seperated'])

"1 2 3 ok".split()

var1ecurlies=1
var2ecurlies=2
print("Hello {} en nog een {}".format(var1ecurlies,var2ecurlies))
print("Hello {var2} {var1ecurlies} en nog een {var2}".format(var1ecurlies=var1ecurlies,var2=var2ecurlies))

print("Prijs: {:.2f}".format(23.974562873))
print("Test: {:>9}|nog een: {:>9}|{:>9.2f}".format(23,1,57.397846873687))
# Formatting: integer {:d}, float with 2 decimals {:.2f}, string with 4 chars {:.4s}
# string align left 6 spaces column {:<6s} string align right 3 spaces cool {:>3s}, str centered 5 spaces col {:^5s} 