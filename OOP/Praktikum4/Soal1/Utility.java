package Soal1;

/*
Buatlah sebuah kelas dengan nama Utility. 
Di dalam kelas tersebut terdapat berbagai method generic yang bersifat statik yang dapat digunakan untuk mengelola sebuah array satu dimensi. 
Method-method tersebut adalah:
swap, digunakan untuk menukar 2 elemen pada sebuah array (tidak menghasilkan array baru). Terdapat 3 parameter yaitu array generik, index i, dan index j. Apabila index yang ingin ditukar tidak terdapat pada array, maka array tidak berubah.
repeat, digunakan untuk membuat array baru yang merupakan pengulangan sebuah array sebanyak N kali. Terdapat 2 parameter yaitu array generik dan integer positif N.
join, digunakan untuk menggabungkan seluruh elemen pada array menjadi sebuah string dengan delimeter ",". Terdapat 1 parameter yaitu array generik. Contoh: [1,2,3] menjadi "1,2,3". Perhatikan bahwa tipe data lainnya akan berubah menjadi string yang sesuai, misal true menjadi "true", null menjadi "null", dst.
sum, digunakan untuk menghasilkan jumlah dari seluruh elemen array dengan tipe double. Terdapat 1 parameter yaitu array generik. Method hanya bisa digunakan untuk array dengan tipe elemen berupa Number.
*/

class Utility<T>{

    public static <T> void swap(T[] arr, int i, int j) {
        if(i < arr.length && j < arr.length && i>=0 && j>=0){
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static <T> T[] repeat(T[] arr, int n) {
        int i;
        int j;
        T[] newArr = (T[]) new Object[arr.length * n];
        for( i = 0; i < n; i++){
            for( j = 0; j < arr.length; j++){
                newArr[i*arr.length+j] = arr[j];
            }
        }
        return newArr;
    }

    public static <T> String join(T[] arr) {
        int i;
        String result = "";
        for(i = 0; i < arr.length-1; i++){
            result += arr[i] + ",";
        }
        result += arr[i];
        return result;
    }

    public static <T extends Number> double sum(T[] arr) {
        int i;
        double result = 0;
        for(i = 0; i < arr.length; i++){
            result += arr[i].doubleValue();
        }
        return result;
    }
}