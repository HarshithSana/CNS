#include <stdio.h>
#include <string.h>

int main()
{
    char str[12] = "Hello World";
    char and[12], or[12], xor[12];
    int i, len;

    len = strlen(str);

    printf("AND OF STRING WITH 127: ");

    for(i = 0; i < len; i++)
    {
        and[i] = str[i] & 127;
        printf("%c", and[i]);
    }

    printf("\nOR OF STRING WITH 127: ");

    for(i = 0; i < len; i++)
    {
        or[i] = str[i] | 127;
        printf("%c", or[i]);
    }

    printf("\nXOR OF STRING WITH 127: ");

    for(i = 0; i < len; i++)
    {
        xor[i] = str[i] ^ 127;
        printf("%c", xor[i]);
    }

    printf("\n");

    return 0;
}