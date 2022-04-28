public abstract class Kendaraan {
    protected int nomor;
    protected String merk;
    protected int tahun;
    
    public static void main(String[] args) {
        Mobil m = new Mobil(1,"BryanCar",1990,"Bryan");
        MiniBus mb = new MiniBus(2, "BusBersama", 2000);
        Bus b = new Bus(3,"Tayo", 20001,10);
        KoleksiKendaraan koleksiBryan = new KoleksiKendaraan();
        koleksiBryan.add(m);
        koleksiBryan.add(mb);
        koleksiBryan.add(b);
        koleksiBryan.printAll();
    }

    public Kendaraan(){
        this.nomor = 0;
        this.merk = "XXX";
        this.tahun = 0;
    }
    public Kendaraan(int nomor, String merk, int tahun){
        this.nomor = nomor;
        this.merk = merk;
        this.tahun = tahun;
    }
    public void printInfo(){
         System.out.println("Nomor Kendaraan : " + this.nomor);
         System.out.println("Tahun Kendaraan : " + this.tahun);
         System.out.println("Merk Kendaraan  : " + this.merk);
    }
    abstract long sewa(int lamasewa);
    
}

class Mobil extends Kendaraan{
    protected String supir;
    public Mobil(){
        super();
        this.supir = "XXX";
    }
    public Mobil(int nomor, String merk, int tahun, String supir){
        super(nomor, merk, tahun);
        this.supir = supir;
    }
    public void printInfo(){
        super.printInfo();
        System.out.println("Nama Supir       : " + this.supir);
    }
    public long sewa(int lamasewa){
        return (lamasewa * 500000);
    }
    
}

class Bus extends Kendaraan{
    protected int kapasitas;
    public Bus(){
        super();
        this.kapasitas = 0;
    }
    public Bus(int nomor, String merk, int tahun, int kapasitas){
        super(nomor, merk, tahun);
        this.kapasitas = kapasitas;
    }
    public void printInfo(){
        super.printInfo();
        System.out.println("Kapasitas Bus   : " + this.kapasitas);
    }
    public long sewa(int lamasewa){
        return (lamasewa * 200000);
    }
}

class MiniBus extends Kendaraan{
    public MiniBus(){
        super();
    }
    public MiniBus(int nomor, String merk, int tahun){
        super(nomor, merk, tahun);
    }
    public void printInfo(){
        super.printInfo();
    }
    public long sewa(int lamaSewa){
        if (lamaSewa <= 5) {
            return 5000000;
        }
        else {
            return 5000000 + 500000 * (lamaSewa - 5);
        }
    }
    public double diskon(int lamaSewa){
        if (lamaSewa > 10) {
            return (sewa(lamaSewa) - sewa(lamaSewa)*0.1);
        }
        else {
            return sewa(lamaSewa);
        }
    }
}

class KoleksiKendaraan{
    private Kendaraan[] koleksi;
    private int neff;
    private int size;

    public KoleksiKendaraan(){
        neff = 0;
        size = 100;
        koleksi = new Kendaraan[100];
    }
    public KoleksiKendaraan(int size){
        neff = 0;
        this.size = size;
        koleksi = new Kendaraan[size];
    }
    
    public void add(Kendaraan k){
        if(neff != size){
            koleksi[neff] = k;
            neff++; 
        }
    }
    public void remove(){
        if(neff>0){
            this.neff--;
            for (int i = 0; i < this.neff; i++) {
                this.koleksi[i]= this.koleksi[i+1];
            }
        }
    }

    public void printAll(){
        for (int i = 0 ; i < neff ; i++){
            System.out.println("Kendaraan ke-" +  (i+1) );
            koleksi[i].printInfo();
        }
    }
    
}