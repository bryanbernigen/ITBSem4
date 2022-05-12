import java.util.ArrayList;

public class Mobil extends Kendaraan implements MajuMundur, Putarbalik, Comfortable, KeluarMasukJalur {
    public static int jumlahmobil;

    Mobil(string identifier){
        this.identifier = identifier;
    }

    public void Maju(){
        System.out.println("Mobil Maju");
    };
    public void Mundur(){
        System.out.println("Mobil Mundur");
    };
    public void berhenti(){
        System.out.println("Mobil Berhenti");
    }
    public void Putarbalik(){
        System.out.println("Mobil Putarbalik");
    };
    public void comfortable(){
        System.out.println("Mobil Comfortable");
    };
    public void KeluarJalur(){
        jumlahmobil+=1;
    }
    public int getjumlah(){
        return jumlahmobil;
    }
}
