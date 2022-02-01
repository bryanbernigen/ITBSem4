#include <stdlib.h>
#include <stdio.h>
#include "readfile.h"

void readfile(int *row, int *col, int *jumlah_kata, int *jumlah_huruf, char *nama_file)
{
    // Kamus
    FILE *ptr;
    char chr;

    // Reading File
    ptr = fopen(nama_file, "r");
    chr = fgetc(ptr);
    if (ptr == NULL)
    {
        printf("ERROR");
    }
    else
    {
        while (chr != '\n')
        {
            if (chr != ' ')
            {
                *col += 1;
            }
            chr = fgetc(ptr);
        }
        *row += 1;
        while (1)
        {
            if (chr == '\n')
            {
                chr = fgetc(ptr);
                if (chr == '\n')
                {
                    break;
                }
                else
                {
                    *row += 1;
                }
            }
            chr = fgetc(ptr);
        }

        while (chr != EOF)
        {
            chr = fgetc(ptr);
            *jumlah_huruf += 1;
            if (chr == '\n')
            {
                *jumlah_kata += 1;
                *jumlah_huruf -= 1;
            }
        }
        *jumlah_huruf -= 1;
    }
}

void make_kata(int *array_panjang_tiap_kata, char *array_all_kata, int jumlah_huruf, char *nama_file)
{
    FILE *ptr;
    char chr;
    int jumlah_perkata = 0;
    int i = 0;
    int j = 0;
    ptr = fopen(nama_file, "r");
    while (1)
    {
        chr = fgetc(ptr);
        if (chr == '\n')
        {
            chr = fgetc(ptr);
            if (chr == '\n')
            {
                break;
            }
        }
    }
    chr = fgetc(ptr);
    j = 0;
    for (i = 0; i < jumlah_huruf; i++)
    {
        if (chr != '\n')
        {
            jumlah_perkata++;
            array_all_kata[i] = chr;
            chr = fgetc(ptr);
        }
        else
        {
            array_panjang_tiap_kata[j] = jumlah_perkata;
            jumlah_perkata = 0;
            j++;
            i--;
            chr = fgetc(ptr);
        }
    }
    array_panjang_tiap_kata[j] = jumlah_perkata;
}