public class Kereta extends Kendaraan implements MajuMundur, Berhenti, Comfortable, KeluarMasukJalur{
    public static int jumlahkereta;

    Kereta(string identifier){
        this.identifier = identifier;
    }

    public void Maju(){
        System.out.println("Kereta Maju");
    };
    public void Mundur(){
        System.out.println("Kereta Mundur");
    };

    public void berhenti(){
        System.out.println("Kereta berhenti di stasitun");
    }

    public void comfortable(){
        System.out.println("Kereta Comfortable");
    }

    public void KeluarJalur(){
        jumlahkereta+=1;
    }

    public int getJumlah(){
        return jumlahkereta;
    }
}
