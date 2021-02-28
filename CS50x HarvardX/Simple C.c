#include <stdio.h>
#include <stdlib.h>
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

  typedef struct 
  {
    char name[50];
    char phone[13];
  } person;
  person people[2];
  strcpy(people[0].name, "Naam Persoon");
  strcpy(people[0].phone,"Telefoon");

  int m = 50;
  printf("%i/n",m);  // just 50
  printf("%p/n",&m);  // %p pointer; & refers to the adress of m (%p 8 bytes)
  printf("%i/n",*&m);  // * prints the contents (dereference operator) @ address of m: 50 again
  
  // Very confusing:
  int *p = &m;  // Create a pointer to the address of m 
  printf("%p\n", p);  // print the address
  printf("%i\n", *p);  // print the value
  
  char *s = "HI!";
  printf("%c\n", s[0]);
  printf("%c\n", s[1]);
  printf("%c\n", s[2]);
  //AKA
  printf("%c\n", *s);
  printf("%c\n", *(s+1));
  printf("%c\n", *(s+2));


  char *s = getstring("s: ");
  char *t = malloc(strlen(s)+1);  // reserve number of bytes
  for (int i = 0, n = strlen(s); i <= n; i++)  // i <= n because extra '\0'
  {
    *(t+i) = *(s+i);  // aka t[i]=s[i];
  }
  free(t);  // release memory asked with malloc()


  return 0;  // default "All OK" exit code 0.
}


int function(int i)  // define function, previously declared
{
  printf("%i", i);
  return i;
}