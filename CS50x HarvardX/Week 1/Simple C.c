#include <stdio.h>
#include <stdbool.h> // bool is not a default in C
#include <string.h> // strlen()

int function(int i); // declare prototype

const int VOORBEELD = 3;

/* int main(int argc, string argv[])
{
  if(argc >= 2)  // argument count
  {
    prinft("First argument besides program name: %s\n", argv[1]);  // argument vector or argument list, array of strings
    printf("first letter of first argument: %c\n", argv[1][0])
  }
  else
  {
    printf("No arguments given\n");
  }
}
*/
int main(void)
{
  //comment single line
  printf("Hello world!\n");
  /* multiple 
  lines
  comment */
  bool b = true; // true false
  char c = 'a'; // 1byte
  printf("%c\n", c);
  double d = 1.0; // 8 bytes
  float f = 1.1;  // 4 bytes
  printf("%f %f\n", d, f);
  printf("%.10f\n",d);
  int i = 10; // 4 bytes
  printf("%i\n", i);
  long l = 100;  // 8 bytes
  printf("%li\n", l);
  char string[] = "Hello";
  char string2[] = {'H','e','l','l','o','\0'}; // \0 => NULL character, or NUL, EOS, End OF String
  printf("%s %s\n", string, string2);
  
  //for(int i = 0; i < strlen(string); i++)
  for (int i = 0, n = strlen(string); i < n; i++)
  {
    printf(string[i]);
  }

  // Casting
  int x;
  int y;
  float z1 = x / y;
  float z2 = (float) x / (float) y;
  printf("%f %f\n", z1, z2);

  int voorbeeld_int[3];
  
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

  return 0;  // default "All OK" exit code 0.
}


int function(int i)  // define function, previously declared
{
  printf("%i", i);
  return i;
}