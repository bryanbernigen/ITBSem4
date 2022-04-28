package Soal2;

import java.util.ArrayList;

public class a {
    public static void main(String[] args) {
        ArrayList chart = new ArrayList();
        chart.add(new Lagu("Lagu 1",10));
        chart.add(new Lagu("Lagu 2",20));
        chart.sort(//Buat sort berdasarkan popularity);
        chart.remove(//remove index ke-x yaitu lagu yang keluar dari top 100)
    }   
}

class Lagu{
    String nama_lagu;
    int popularity;

    Lagu(String nama_lagu, int popularity){
        this.nama_lagu = nama_lagu;
        this.popularity = popularity;
    }
}
