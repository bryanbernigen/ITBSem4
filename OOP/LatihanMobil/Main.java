public class Main {
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
}
