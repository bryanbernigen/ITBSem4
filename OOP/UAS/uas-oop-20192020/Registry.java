import java.util.*;

class Registry {
  private ArrayList<Pemilik> listPemilik;
  private HashMap<String, ArrayList<Properti>> mapPropertiTereservasi;

  public Registry() {
    this.listPemilik = new ArrayList<Pemilik>();
    this.mapPropertiTereservasi = new HashMap<String, ArrayList<Properti>>();
  }

  public void add(Pemilik p) {
    this.listPemilik.add(p);
  }

  public void cariPropertiTersedia(String tanggal) {
    System.out.println("Properti yang tersedia pada tanggal " + tanggal + ":");
    /* Loop setiap pemilik ... */
    for (Pemilik p : listPemilik) {
      /* Loop propertinya */
      for (Properti prop : p.getListProperti()) {
        /* Cek apakah tanggal ada list propertinya */
        if (mapPropertiTereservasi.containsKey(tanggal)) {
          /* Cek apakah ada properti tersebut */
          if (!mapPropertiTereservasi.get(tanggal).contains(prop)) {
            /* Belum ada, properti ini tersedia */
            System.out.println(prop);
          }
        } else {
          /* Pada tanggal tersebut tidak ada yang sudah tereservasi; properti ini tersedia */
          System.out.println(prop);
        }
      }
    }
  }

  public void reservasiProperti(Pengguna p, String tanggal, int id) throws Exception {
    /* Cari pemilik dari properti tersebut */
    Pemilik pemilik = null;
    Properti properti = null;
    for (Pemilik pem : listPemilik) {
      for (Properti prop : pem.getListProperti()) {
        if (prop.getID() == id) {
          pemilik = pem;
          properti = prop;
          break;
        }
      }
      if (pemilik != null) {
        break;
      }
    }
    if (pemilik == null) {
      throw new Exception("Properti tidak ada pemiliknya!");
    }
    /* Cek apakah properti tersebut sudah digunakan */
    if (!mapPropertiTereservasi.containsKey(tanggal)) {
      /* Belum digunakan; reservasi berhasil */
      ArrayList<Properti> tmp = new ArrayList<Properti>();
      tmp.add(properti);
      mapPropertiTereservasi.put(tanggal, tmp);
      pemilik.addPengguna(p);
    } else {
      /* Cari properti yang bersangkutan */
      if (!mapPropertiTereservasi.get(tanggal).contains(properti)) {
        /* Reservasi berhasil */
        mapPropertiTereservasi.get(tanggal).add(properti);
        pemilik.addPengguna(p);
      } else {
        throw new Exception("Properti sudah direservasi!");
      }
    }
  }
}
