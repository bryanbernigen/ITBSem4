package Soal1;

public class Minibus extends Bus implements Diskon{
    Minibus(){
        super();
    }

    Minibus(String merek, int tahun, int lamaSewa, int kapasitasKendaraan){
        super(merek, tahun, lamaSewa, kapasitasKendaraan);
    }

    public void printInfo(){
        System.out.println("nomorUnikKendaraan: " + nomorUnikKendaraan);
        System.out.println("biaya sewa: " + sewa(lamaSewa));
    }

    public long sewa(int lamaSewa){
        int hargaNormal = 10000 * this.kapasitasKendaraan;
        return hargaNormal - diskon(hargaNormal);
    }

    public long diskon(int hargaNormal){
        return (long)(hargaNormal*(0.1 * lamaSewa));
    }
}
