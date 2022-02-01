/**
Filename: pcolor.h
Description: Print character with some color in terminal
Prepared by: Asisten IF2110
Created at: 17/10/2019
**/

/**
Details

print_xxx(c) will print c with xxx color. Import this header to use the declared functions.
We only provide 8 colors. Feel free to modify/add colors if you want to.
**/

#define NORMAL "\x1B[0m"
#define RED "\x1B[31m"
#define GREEN "\x1B[32m"
#define YELLOW "\x1B[33m"
#define BLUE "\x1B[34m"
#define MAGENTA "\x1B[35m"
#define CYAN "\x1B[36m"
#define BACKGROUND_RED "\x1B[41m"
#define BACKGROUND_GREEN "\x1B[42m"
#define BACKGROUND_YELLOW "\x1B[43m"
#define BACKGROUND_BLUE "\x1B[44m"
#define BACKGROUND_MAGENTA "\x1B[45m"
#define BACKGROUND_CYAN "\x1B[46m"

void print_red(char c);
void print_green(char c);
void print_yellow(char c);
void print_blue(char c);
void print_magenta(char c);
void print_cyan(char c);
void print_bg_red(char c);
void print_bg_grean(char c);
void print_bg_yellow(char c);
void print_bg_blue(char c);
void print_bg_magenta(char c);
void print_bg_cyan(char c);

void print_warna(char c, char x);

void print_warna_matrix(char *matrix, char *pewarnaan, int row, int col);

void print_matrix(char *matrix, int row, int col);