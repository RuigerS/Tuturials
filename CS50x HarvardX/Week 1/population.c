//#include <cs50.h>
#include <stdio.h>

int main(void)
{
    // Purpose: Prompt for start size
    int size;
    do
    {
        size = get_int("Start size: ");
    }
    while (size < 9);
    // Purpose: prompt for end size
    int end_size;
    do
    {
        end_size = get_int("End size: ");
    }
    while (end_size < size);
    // Purpose: Calculate number of years until we reach threshold
    int years = 0;
    while (size < end_size)
    {
        years++;
        size = size + size / 3 - size / 4;
    }

    // Purpose: Print number of years
    printf("Years: %i\n", years);
}
