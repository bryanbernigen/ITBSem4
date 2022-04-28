package Soal1;

public class Bus extends KendaraanRental{
    protected int kapasitasKendaraan;
    Bus(){
        super();
        this.kapasitasKendaraan = 0;
    }

    Bus(String merek, int tahun, int lamaSewa, int kapasitasKendaraan){
        super(merek, tahun, lamaSewa);
        this.kapasitasKendaraan = kapasitasKendaraan;
    }

    public void printInfo(){
        System.out.println("nomorUnikKendaraan: " + nomorUnikKendaraan);
        System.out.println("biaya sewa: " + sewa(lamaSewa));
    }

    public long sewa(int lamaSewa){
        int hargaNormal = 100000;
        return hargaNormal;
    }

}
