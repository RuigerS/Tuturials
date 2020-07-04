import os 
#clear the screen
os.system('cls')
###################################################

class Square:
    def __init__(self, side_length):
        self.side_length=side_length

    def area(self):
        return self.side_length*self.side_length

    def perimeter(self):
        return 4*self.side_length

###################################################

my_square = Square(10)

print(my_square.side_length)
print (my_square.area())
print (my_square.perimeter())


###################################################
