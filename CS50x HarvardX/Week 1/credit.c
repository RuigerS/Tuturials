#include <stdio.h>
//#include <cs50.h>

int main(void)
{
    long number = get_long("Number: ");
    //check_luhn
    long luhn_temp = number;
    long luhn_total = 0;
    int multiplier = 1;
    while (luhn_temp > 0)
    {
        if (luhn_temp % 10 * multiplier > 9)
        {
            luhn_total += 1;
            luhn_total += (luhn_temp % 10 * multiplier) % 10;
        }
        else
        {
            luhn_total += luhn_temp % 10 * multiplier;
        }
        multiplier += 1;
        if (multiplier > 2)
        {
            multiplier = 1;
        }
        luhn_temp = luhn_temp / 10;
    }
    if (luhn_total % 10 == 0)
    {
        //luhn correct, get first figures
        luhn_temp = number;
        while (luhn_temp > 100)
        {
            luhn_temp = luhn_temp / 10;
        }
        // AMEX starts with 34 or 37 + 15 digit numbers
        if ((luhn_temp == 34 || luhn_temp == 37) && (number > 99999999999999 && number < 1000000000000000))
        {
            printf("AMEX\n");
        }
        // MASTERCARD starts with 51-55, and 15 digit numbers
        else if ((luhn_temp > 50 && luhn_temp < 56) && (number > 999999999999999 && number < 10000000000000000))
        {
            printf("MASTERCARD\n");
        }
        // VISA starts with a 4 and 13 or 16 digit numbers
        else if ((luhn_temp >= 40 && luhn_temp < 50) && ((number > 999999999999999 && number < 10000000000000000) || 
                 (number > 999999999999 && number < 10000000000000)))
        {
            printf("VISA\n");
        }
        else
        {
            //not legit start number
            printf("INVALID\n");
        }
    }
    else
    {
        //not legit luhn
        printf("INVALID\n");
    }
}

