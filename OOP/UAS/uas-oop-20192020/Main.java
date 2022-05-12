public class Main {
  public static void main(String args[]) {
    Pemilik p1 = new Pemilik();
    for (int i = 0; i < 10; i ++) {
      /* p1 punya 10 hotel bertipe standard */
      p1.addProperti(new StandardHotel("Standard Hotel"));
    }
    for (int i = 0; i < 3; i ++) {
      /* p1 punya 3 hotel bertipe deluxe */
      DeluxeHotel dh = new DeluxeHotel("Deluxe Hotel");
      /* Hotel tersebut punya fasilitas kolam renang dan sarapan 80 ribu per hari */
      try {
        dh.addFasilitas("KolamRenang");
        dh.addFasilitas("Sarapan80");
      } catch (Exception e) {
        System.out.println("Terjadi kesalahan saat menambahkan fasilitas");
      }
      p1.addProperti(dh);
    }

    Pemilik p2 = new Pemilik();
    for (int i = 0; i < 3; i ++) {
      /* p2 punya 3 unit apartemen */
      UnitApartemen ua = new UnitApartemen("Unit Apartemen", 700000, 2);
      /* Punya fasilitas sarapan 60 ribu per hari */
      try {
        ua.addFasilitas("Sarapan60");
      } catch (Exception e) {
        System.out.println("Terjadi kesalahan saat menambahkan fasilitas");
      }
      p2.addProperti(ua);
    }
    for (int i = 0; i < 5; i ++) {
      Homestay h = new Homestay("Homestay", 150000);
      p2.addProperti(h);
    }

    /* Masukkan pemilik ke registry */
    Registry r = new Registry();
    r.add(p1);
    r.add(p2);

    /* Ada dua pelanggan */
    Pengguna pe1 = new Pengguna("Marcho", "marcho@gmail.com", "0812123123123");
    Pengguna pe2 = new Pengguna("Tridyo", "tridyo@gmail.com", "0812456456456");

    /* Menampilkan semua properti yang tersedia di tanggal 29 April 2020 */
    r.cariPropertiTersedia("29 April 2020");

    /* Reservasi hotel ID 1 dan homestay ID 17 */
    try {
      pe1.reservasi(r, "29 April 2020", 1);
      pe1.reservasi(r, "29 April 2020", 7);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    /* Menampilkan lagi ... */
    r.cariPropertiTersedia("29 April 2020");

    /* Reservasi apartemen ID 14 */
    try {
      pe2.reservasi(r, "29 April 2020", 14);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    /* Menampilkan lagi ... */
    r.cariPropertiTersedia("29 April 2020");

    /* Pemilik 1 mengirim broadcast */
    p1.kirimPesan("Dari pemilik 1!!!");

    /* Pemilik 2 pengirim broadcast */
    p2.kirimPesan("Dari pemilik 2!!!");
  }
}
