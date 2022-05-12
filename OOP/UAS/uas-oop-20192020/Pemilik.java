import java.util.*;

class Pemilik {
  private ArrayList<Pengguna> listPengguna;
  private ArrayList<Properti> listProperti;

  public Pemilik() {
    listPengguna = new ArrayList<Pengguna>();
    listProperti = new ArrayList<Properti>();
  }

  public void addPengguna(Pengguna p) {
    if (!this.listPengguna.contains(p)) {
      /* Ditambahkan hanya jika belum ada */
      this.listPengguna.add(p);
    }
  }

  public void addProperti(Properti p) {
    this.listProperti.add(p);
  }

  public ArrayList<Properti> getListProperti() {
    return this.listProperti;
  }

  public void kirimPesan(String p) {
    System.out.println("Mengirim pesan dari pemilik.");
    for (Pengguna pengguna : this.listPengguna) {
      pengguna.terimaPesan(p);
    }
  }
}
