#include <ctype.h>
//#include <cs50.h>
#include <stdio.h>
#include <string.h>

// because CS50.h
typedef char *string;

int main(int argc, string argv[])
{
    // Needs (only) one argument
    if (argc != 2)
    {
        printf("Usage: ./substitution key\n");
        return 1;
    }
    // Argument must be 26 chars len
    if (strlen(argv[1]) != 26)
    {
        printf("Key must contain 26 characters.\n");
        return 1;
    }
    // Key must be only alphabetic
    for (int i = 0; i < 26; i++)
    {
        if (! isalpha(argv[1][i]))
        {
            printf("Key must contain alphabetic characters only\n");
            return 1;
        }
    }
    // Key must contain all 26 characters once
    string control = "abcdefghijklmnopqrstuvwxyz";
    for (int i = 0, n = strlen(control); i < n; i++)
    {
        if (strchr(argv[1], control[i]) == NULL && strchr(argv[1], toupper(control[i])) == NULL)
        {
            printf("Missed alphabetic characters\n");
            return 1;
        }
    }
    // Substitute plaintext chars to ciphertext
    string text = get_string("plaintext: ");
    for (int i = 0, n = strlen(text); i < n; i++)
    {
        // Only letters
        if (isalpha(text[i]))
        {
            char tmpch = text[i];
            // Keep case info
            int lcase = 1;
            if (islower(tmpch))
            {
                lcase = 0;
            }
            text[i] = toupper(argv[1][(int)(toupper(tmpch)) - 65]);
            if (lcase == 0)
            {
                text[i] = tolower(text[i]);
            }
        }
    }
    // print result and exit(0)
    printf("ciphertext: %s\n", text);
    return 0;
}