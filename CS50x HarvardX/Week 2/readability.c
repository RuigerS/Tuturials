#include <ctype.h>
//#include <cs50.h>
#include <stdio.h>
#include <string.h>

// because CS50.h
typedef char *string;

int main(void)
{
    // get the input to examine
    string input = get_string("Text: ");    
    double letters = 0.0, words = 1.0, sentences = 0.0;
    for (int i = 0, n = strlen(input); i < n; i++)
    {
        // count letters
        if (isalpha(input[i]))
        {
            letters += 1.0;
        }
        // count words
        else if (input[i] == ' ')
        {
            words += 1.0;
            // last word will not be counted: start with 1, not zero
        }
        // count sentences
        else if (input[i] == '.' || input[i] == '!' || input[i] == '?')
        {
            sentences += 1.0;
        }
    }
    // L = average number of letters per 100 words
    double L = letters / words * 100.0;
    // S = average number of sentences per 100 words
    double S = sentences / words * 100.0;
    int index = (int)((0.0588 * L) - (0.296 * S) - 15.8 + 0.5);
    if (index >= 16)
    {
        printf("Grade 16+\n");
    }
    else if (index < 1)
    {
        printf("Before Grade 1\n");
    }
    else
    {
        printf("Grade %i\n", index);
    }
}