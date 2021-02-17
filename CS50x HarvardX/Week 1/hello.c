#include <stdio.h>
//#include <cs50.h>

// because CS50.h
typedef char *string;

int main(void)
{
    // Ask for name
    string name = get_string("What is your name?\n");
    // Print hello + name
    printf("hello, %s\n", name);
}

// make hello