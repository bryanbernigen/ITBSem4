/**
Filename: pcolor.c (implementation of pcolor.h)
Description: Print character with some color in terminal
Prepared by: Asisten IF2110
Created at: 17/10/2019
**/

#include <stdio.h>
#include "pcolor.h"

void print_red(char c)
{
    printf("%s%c", RED, c);
    printf("%s", NORMAL);
}

void print_green(char c)
{
    printf("%s%c", GREEN, c);
    printf("%s", NORMAL);
}

void print_yellow(char c)
{
    printf("%s%c", YELLOW, c);
    printf("%s", NORMAL);
}

void print_blue(char c)
{
    printf("%s%c", BLUE, c);
    printf("%s", NORMAL);
}

void print_magenta(char c)
{
    printf("%s%c", MAGENTA, c);
    printf("%s", NORMAL);
}

void print_cyan(char c)
{
    printf("%s%c", CYAN, c);
    printf("%s", NORMAL);
}

void print_bg_red(char c)
{
    printf("%s%c", BACKGROUND_RED, c);
    printf("%s", NORMAL);
}

void print_bg_green(char c)
{
    printf("%s%c", BACKGROUND_GREEN, c);
    printf("%s", NORMAL);
}

void print_bg_blue(char c)
{
    printf("%s%c", BACKGROUND_BLUE, c);
    printf("%s", NORMAL);
}

void print_bg_magenta(char c)
{
    printf("%s%c", BACKGROUND_MAGENTA, c);
    printf("%s", NORMAL);
}

void print_bg_cyan(char c)
{
    printf("%s%c", BACKGROUND_CYAN, c);
    printf("%s", NORMAL);
}

void print_warna(char c, char x)
{
    while (x > 'K')
    {
        x -= 11;
    }

    switch (x)
    {
    case 'A':
        print_red(c);
        break;
    case 'B':
        print_green(c);
        break;
    case 'C':
        print_yellow(c);
        break;
    case 'D':
        print_blue(c);
        break;
    case 'E':
        print_magenta(c);
        break;
    case 'F':
        print_cyan(c);
        break;
    case 'G':
        print_bg_red(c);
        break;
    case 'H':
        print_bg_green(c);
        break;
    case 'I':
        print_bg_blue(c);
        break;
    case 'J':
        print_bg_magenta(c);
        break;
    case 'K':
        print_bg_cyan(c);
        break;
    default:
        break;
    }
}

void print_warna_matrix(char *matrix, char *pewarnaan, int row, int col)
{
    int i;
    int j;
    for (i = 0; i < row; i++)
    {
        for (j = 0; j < col; j++)
            if (pewarnaan[i * col + j] == '0')
            {
                printf("%c ", matrix[i * col + j]);
            }
            else
            {
                print_warna(matrix[i * col + j], pewarnaan[i * col + j]);
                printf(" ");
            }
        printf("\n");
    }
}

void print_matrix(char *matrix, int row, int col)
{
    int i;
    int j;
    for (i = 0; i < row; i++)
    {
        for (j = 0; j < col; j++)
            printf("%c ", matrix[i * col + j]);

        printf("\n");
    }
}