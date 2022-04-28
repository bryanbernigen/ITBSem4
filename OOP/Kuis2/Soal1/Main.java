package Soal1;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus("buskeren", 2000, 5, 20);
        bus.printInfo();
        System.out.println("");
        Mobil mobil = new Mobil("mobilkeren", 2000, 5, 5.0f);
        mobil.printInfo();
        System.out.println("");
        Minibus minibus = new Minibus("minibuskeren", 2000, 5, 20);
        minibus.printInfo();
        System.out.println("");
        KoleksiKendaraanRental koleksi = new KoleksiKendaraanRental();
        koleksi.add(bus);
        koleksi.add(mobil);
        koleksi.add(minibus);
        koleksi.printAll();
    }

}
