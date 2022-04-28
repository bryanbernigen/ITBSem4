package Soal1;

public class Mobil extends KendaraanRental{
    protected float ratesupir;
    Mobil(){
        super();
        this.ratesupir = 5;
    }

    Mobil(String merek, int tahun, int lamaSewa, Float ratesupir){
        super(merek, tahun, lamaSewa);
        this.ratesupir = ratesupir;
    }

    public void printInfo(){
        System.out.println("nomorUnikKendaraan: " + nomorUnikKendaraan);
        System.out.println("biaya sewa: " + sewa(lamaSewa));
    }

    public long sewa(int lamaSewa){
        int hargaNormal = 100000;
        return (long)(hargaNormal * (5-ratesupir));
    }

}
