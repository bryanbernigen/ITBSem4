import java.util.ArrayList;

public class Kendaraan{
    protected int lawawaktu=0; 
    protected ArrayList<penunjang> listpenunjang;
    protected Jalur jalur;
    protected string identifier;

    Kendaraan(){
        this.listpenunjang = new ArrayList<penunjang>();
        this.identifier = "mobil illegal";
    }
    
    void setLama(int lama){
        this.lamawaktu = lama;
    }

    void setJalur(Jalur jalur){
        this.jalur=jalur; 
    }

    string getIdentifier(){
        return this.identifier;
    }

    public void addPenunjang(string penunjang) throws Exception {
        Class c = Class.forName(penunjang);
        List<Class> interfaces = Arrays.asList(c.getInterfaces());
        interfaces.forEach(itf -> {
            try {
                if (itf.getName().equals("penunjang")) {
                    this.listpenunjnag.add((penunjang) c.newInstance());
                }
            } catch (Exception e) {
                System.out.println("Gagal menambahkan penunjang!!!");
            }
        });
    }

    public void getPesan(int jumlahkendaraan){
        System.out.println("Jumlah Kendaraan Saat ini: ", jumlahkendaraan);
    }

    public void getPesanTotalLewat(int jumlahkereta, int jumlahmobil){
        System.out.println("jumlah kereta: ", jumlahkereta);
        System.out.println("jumlah mobil :", jumlahmobil);
            }

    public int getTotalHarga(){
        int total=0;
        for (penunjang penunjang : listpenunjang) {
            total += penunjang.getHarga();
        }
        total += this.jalur.getHarga() * this.lawawaktu;
    }
}
