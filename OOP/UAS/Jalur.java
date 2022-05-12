import java.util.*;

public class Jalur{
    protected int jumlahkendaraan;
    protected int kapasitasjalur;
    Jalur nextjalur;
    protected ArrayList<Kendaraan> listkendaraan;
    protected int harga;

    Jalur(){
        this.listkendaraan = new ArrayList<Kendaraan>();
    }

    public void setHarga(int harga){
        this.harga = harga;
    }

    public void addKendaraan(Kendaraan kendaraan) {
        listkendaraan.add(kendaraan);
        kendaraan.setJalur(this.getClass());
        jumlahkendaraan+=1;
    }

    public void removeKendaraan(string identifier){
        for (Kendaraan kendaraan : listkendaraan) {
            if(kendaraan.getIdentifier.equals(identifier)){
                listkendaraan.remove(kendaraan);
                this.jumlahkendaraan -= 1;
                kendaraan.KeluarJalur();
            }
        }
    }

    public void sendPesan(){
        for (Kendaraan kendaraan : listkendaraan) {
            kendaraan.getPesan(this.jumlahkendaraan);
        }
    }

    public void sendPesanJumlahLewat(){
        Kereta k;
        Mobil m;
        for (Kendaraan kendaraan : listkendaraan) {
            kendaraan.getPesanTotalLewat(k.getJumlah(), m.getJumlah());
        }
    }

    public boolean isFull(){
        return this.jumlahkendaraan >= this.kapasitasjalur;
    }

    public void setNext(Jalur j){
        this.nextjalur = j;
    }

    public Jalur getNextJalur(){
        return this.nextjalur;
    }
}
