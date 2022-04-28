package Soal1;

public abstract class KendaraanRental {
    static int nomorUnikKendaraan;
    protected String merk;
    protected int tahun;
    protected int lamaSewa;

    KendaraanRental(){
        nomorUnikKendaraan++;
        this.merk = "";
        this.tahun = 0;
        this.lamaSewa = 0;
    }

    KendaraanRental(String merek, int tahun, int lamaSewa){
        nomorUnikKendaraan++;
        this.merk = merek;
        this.tahun = tahun;
        this.lamaSewa = lamaSewa;
    }

    abstract void printInfo();
    abstract long sewa(int lamasewa);
}
