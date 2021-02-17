#include <stdio.h>
#include <stdbool.h> // bool is not a default in C

int function(int i); // declare prototype

int main(void)
{
  //comment single line
  printf("Hello world!\n");
  /* multiple 
  lines
  comment */
  bool b = true; // true false
  char c = 'a';
  printf("%c\n", c);
  double d = 1.0;
  float f = 1.1;
  printf("%f %f\n", d, f);
  printf("%.10f\n",d);
  int i = 10;
  printf("%i\n", i);
  long l = 100;
  printf("%li\n", l);
  char string[] = "Hello";
  char string2[] = {'H','e','l','l','o','\0'};
  printf("%s %s\n", string, string2);
  
  // Casting
  int x;
  int y;
  float z1 = x / y;
  float z2 = (float) x / (float) y;
  printf("%f %f\n", z1, z2);

  // Conditions
  if(z1 < z2)
  {
    //nothing...
  }
  else if(z1 == z2)
  {
    //nothing...
  }
  else
  {
    // unconditional if not above, must be z1 > z2
  }

  // loops
  i = 0;
  while(i < 10)
  {
    i++;
  }
  
  do
  {
    i++;
  } while (i < 20);
  
  for(i = 0; i < 10; i++)
  {
    //Any line
  }

  function(10);

  return 0;
}


int function(int i)  // define function, previously declared
{
  printf("%i", i);
  return i;
}