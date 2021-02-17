#include <stdio.h>
//#include <cs50.h>

int main(void)
{
    //Get number for height inclusive 1-8
    int height = 0;
    do
    {
        height = get_int("Height: ");
    }
    while (height < 1 || height > 8);
    // print out the result from height to 0
    for (int i = 1; i <= height; i++)
    {
        //first row of spaces
        for (int j = 1; j <= height - i; j++)
        {
            printf(" ");
        }
        //building the first row of blocks
        for (int j = height - i; j < height; j++)
        {
            printf("#");
        }
        printf("  ");
        //building the second row of blocks
        for (int j = height - i; j < height; j++)
        {
            printf("#");
        }
        printf("\n");
    }
}