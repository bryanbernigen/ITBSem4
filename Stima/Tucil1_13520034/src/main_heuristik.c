#include <stdlib.h>
#include <stdio.h>
#include <string.h> //concate directory path
#include "readfile.h"
#include "ADTColor/pcolor.h"
#include "boolean.h"
#include <time.h>

int main()
{
    FILE *ptr;
    char chr;
    char input_nama_file[256];
    char nama_file[256] = "test/";
    int row = 0;
    int col = 0;
    char warna = 'A';
    int ukuran_matrix;
    int jumlah_kata = 1; // bernilai 1 jika pada akhir file tidak diikuti enter,
                         // bernilai 0 jika pada akhir file diikuti enter.
    int jumlah_huruf = 0;
    int jumlah_perbandingan = 0;
    int jumlah_ditemukan = 0;
    boolean found;
    boolean cocok;
    int panjang_all_kata_yang_sudah_ditemukan = 0;
    int i;
    int j;
    int k;
    // perhitungan waktu
    clock_t elapsed_time;

    // Bikin matrix
    printf("Input Nama File yang akan di buka di folder test: ");
    scanf("%s", &input_nama_file);
    strcat(nama_file, input_nama_file);
    elapsed_time = clock();
    readfile(&row, &col, &jumlah_kata, &jumlah_huruf, nama_file);
    char *matrix = malloc((col * row) * sizeof(char));
    ptr = fopen(nama_file, "r");
    for (i = 0; i < row * col; i++)
    {
        chr = fgetc(ptr);
        while (chr == '\n' || chr == ' ')
        {
            chr = fgetc(ptr);
        }
        matrix[i] = chr;
    }
    ukuran_matrix = row * col;

    // bikin kata
    int *array_panjang_tiap_kata = malloc(jumlah_kata * sizeof(int));
    char *array_all_kata = malloc(jumlah_huruf * sizeof(char));
    make_kata(array_panjang_tiap_kata, array_all_kata, jumlah_huruf, nama_file);

    // main
    printf("ukuran matrix: %d\n", ukuran_matrix);
    printf("baris x kolom: %d x %d\n", row, col);
    printf("jumlah kata  : %d\n", jumlah_kata);
    printf("jumlah huruf : %d\n", jumlah_huruf);
    char *pewarnaan = malloc((col * row) * sizeof(char));
    for (i = 0; i < col * row; i++)
    {
        pewarnaan[i] = '0';
    }

    // mulai iterasi

    for (i = 0; i < jumlah_kata; i++)
    {
        found = false;
        j = 0;
        while (!found && j < ukuran_matrix)
        {
            jumlah_perbandingan++;
            if (matrix[j] == array_all_kata[panjang_all_kata_yang_sudah_ditemukan])
            {
                // atas
                jumlah_perbandingan++;
                if (array_panjang_tiap_kata[i] <= (j / col) + 1)
                {
                    cocok = true;
                    k = 1;
                    while (cocok && k < array_panjang_tiap_kata[i])
                    {
                        jumlah_perbandingan++;
                        if (matrix[j - k * col] != array_all_kata[panjang_all_kata_yang_sudah_ditemukan + k])
                        {
                            cocok = false;
                        }
                        k++;
                    }
                    jumlah_perbandingan++;
                    if (cocok)
                    {
                        jumlah_ditemukan++;

                        found = true;
                        panjang_all_kata_yang_sudah_ditemukan += array_panjang_tiap_kata[i];
                        for (k = 0; k < array_panjang_tiap_kata[i]; k++)
                        {
                            pewarnaan[j - k * col] = warna + i;
                        }
                    }
                }
                // serong kanan atas
                jumlah_perbandingan++;
                if (!found && array_panjang_tiap_kata[i] <= (j / col) + 1 && (j - ((j / col)) * col) + array_panjang_tiap_kata[i] <= col)
                {
                    cocok = true;
                    k = 1;
                    while (cocok && k < array_panjang_tiap_kata[i])
                    {
                        jumlah_perbandingan++;
                        if (matrix[j - k * col + k] != array_all_kata[panjang_all_kata_yang_sudah_ditemukan + k])
                        {
                            cocok = false;
                        }
                        k++;
                    }
                    jumlah_perbandingan++;
                    if (cocok)
                    {
                        jumlah_ditemukan++;
                        found = true;
                        panjang_all_kata_yang_sudah_ditemukan += array_panjang_tiap_kata[i];
                        for (k = 0; k < array_panjang_tiap_kata[i]; k++)
                        {
                            pewarnaan[j - k * col + k] = warna + i;
                        }
                    }
                }

                // kanan
                jumlah_perbandingan++;
                if (!found && (j - ((j / col)) * col) + array_panjang_tiap_kata[i] <= col)
                {
                    cocok = true;
                    k = 1;
                    while (cocok && k < array_panjang_tiap_kata[i])
                    {
                        jumlah_perbandingan++;
                        if (matrix[j + k] != array_all_kata[panjang_all_kata_yang_sudah_ditemukan + k])
                        {
                            cocok = false;
                        }
                        k++;
                    }
                    jumlah_perbandingan++;
                    if (cocok)
                    {
                        jumlah_ditemukan++;
                        found = true;
                        panjang_all_kata_yang_sudah_ditemukan += array_panjang_tiap_kata[i];
                        for (k = 0; k < array_panjang_tiap_kata[i]; k++)
                        {
                            pewarnaan[j + k] = warna + i;
                        }
                    }
                }

                // serong kanan bawah
                jumlah_perbandingan++;
                if (!found && (j - ((j / col)) * col) + array_panjang_tiap_kata[i] <= col && (j / col) + array_panjang_tiap_kata[i] <= row)
                {
                    cocok = true;
                    k = 1;
                    while (cocok && k < array_panjang_tiap_kata[i])
                    {
                        jumlah_perbandingan++;
                        if (matrix[j + k * col + k] != array_all_kata[panjang_all_kata_yang_sudah_ditemukan + k])
                        {
                            cocok = false;
                        }
                        k++;
                    }
                    jumlah_perbandingan++;
                    if (cocok)
                    {
                        jumlah_ditemukan++;
                        found = true;
                        panjang_all_kata_yang_sudah_ditemukan += array_panjang_tiap_kata[i];
                        for (k = 0; k < array_panjang_tiap_kata[i]; k++)
                        {
                            pewarnaan[j + k * col + k] = warna + i;
                        }
                    }
                }

                // bawah
                jumlah_perbandingan++;
                if (!found && (j / col) + array_panjang_tiap_kata[i] <= row)
                {
                    cocok = true;
                    k = 1;
                    while (cocok && k < array_panjang_tiap_kata[i])
                    {
                        jumlah_perbandingan++;
                        if (matrix[j + k * col] != array_all_kata[panjang_all_kata_yang_sudah_ditemukan + k])
                        {
                            cocok = false;
                        }
                        k++;
                    }
                    jumlah_perbandingan++;
                    if (cocok)
                    {
                        jumlah_ditemukan++;
                        found = true;
                        panjang_all_kata_yang_sudah_ditemukan += array_panjang_tiap_kata[i];
                        for (k = 0; k < array_panjang_tiap_kata[i]; k++)
                        {
                            pewarnaan[j + k * col] = warna + i;
                        }
                    }
                }

                // serang kiri bawah
                jumlah_perbandingan++;
                if (!found && (j / col) + array_panjang_tiap_kata[i] <= row && (j - ((j / col) * col) + 1 - array_panjang_tiap_kata[i]) >= 0)
                {
                    cocok = true;
                    k = 1;
                    while (cocok && k < array_panjang_tiap_kata[i])
                    {
                        jumlah_perbandingan++;
                        if (matrix[j + k * col - k] != array_all_kata[panjang_all_kata_yang_sudah_ditemukan + k])
                        {
                            cocok = false;
                        }
                        k++;
                    }
                    jumlah_perbandingan++;
                    if (cocok)
                    {
                        jumlah_ditemukan++;
                        found = true;
                        panjang_all_kata_yang_sudah_ditemukan += array_panjang_tiap_kata[i];
                        for (k = 0; k < array_panjang_tiap_kata[i]; k++)
                        {
                            pewarnaan[j + k * col - k] = warna + i;
                        }
                    }
                }

                // kiri
                jumlah_perbandingan++;
                if (!found && (j - ((j / col) * col) + 1 - array_panjang_tiap_kata[i]) >= 0)
                {
                    cocok = true;
                    k = 1;
                    while (cocok && k < array_panjang_tiap_kata[i])
                    {
                        jumlah_perbandingan++;
                        if (matrix[j - k] != array_all_kata[panjang_all_kata_yang_sudah_ditemukan + k])
                        {
                            cocok = false;
                        }
                        k++;
                    }
                    jumlah_perbandingan++;
                    if (cocok)
                    {
                        jumlah_ditemukan++;
                        found = true;
                        panjang_all_kata_yang_sudah_ditemukan += array_panjang_tiap_kata[i];
                        for (k = 0; k < array_panjang_tiap_kata[i]; k++)
                        {
                            pewarnaan[j - k] = warna + i;
                        }
                    }
                }

                // serong kiri atas
                jumlah_perbandingan++;
                if (!found && (j - ((j / col) * col) + 1 - array_panjang_tiap_kata[i]) >= 0 && array_panjang_tiap_kata[i] <= (j / col) + 1)
                {
                    cocok = true;
                    k = 1;
                    while (cocok && k < array_panjang_tiap_kata[i])
                    {
                        jumlah_perbandingan++;
                        if (matrix[j - k * col - k] != array_all_kata[panjang_all_kata_yang_sudah_ditemukan + k])
                        {
                            cocok = false;
                        }
                        k++;
                    }
                    jumlah_perbandingan++;
                    if (cocok)
                    {
                        jumlah_ditemukan++;
                        found = true;
                        panjang_all_kata_yang_sudah_ditemukan += array_panjang_tiap_kata[i];
                        for (k = 0; k < array_panjang_tiap_kata[i]; k++)
                        {
                            pewarnaan[j - k * col - k] = warna + i;
                        }
                    }
                }
            }
            j++;
        }
        // Menampilkan kata yang tidak berhasil ditemukan
        jumlah_perbandingan++;
        if (!found)
        {
            for (k = 0; k < array_panjang_tiap_kata[i]; k++)
            {
                printf("%c", array_all_kata[k + panjang_all_kata_yang_sudah_ditemukan]);
            }
            printf("\n");
            panjang_all_kata_yang_sudah_ditemukan += array_panjang_tiap_kata[i];
        }
    }
    elapsed_time = clock() - elapsed_time;
    printf("Jumlah Perbandingan: %d\n", jumlah_perbandingan);
    printf("Jumlah Kata Ditemukan: %d\n", jumlah_ditemukan);
    double time_taken = ((double)elapsed_time) / CLOCKS_PER_SEC; // calculate the elapsed time
    printf("Lama program: %lf detik\n", time_taken);
    print_warna_matrix(matrix, pewarnaan, row, col);
    // penutup
    free(pewarnaan);
    free(array_panjang_tiap_kata);
    free(array_all_kata);
    free(matrix);
    return 0;
}