import java.util.*;

class Properti {
  public static int propertyCount = 0;
  private int id;
  private String deskripsi;
  private int hargaDasar;
  private ArrayList<Fasilitas> listFasilitas;

  public Properti() {
    Properti.propertyCount ++;
    this.id = propertyCount;
    listFasilitas = new ArrayList<Fasilitas>();
  }

  public void setDeskripsi(String deskripsi) {
    this.deskripsi = deskripsi;
  }

  public void setHargaDasar(int hargaDasar) {
    this.hargaDasar = hargaDasar;
  }

  public String getDeskripsi() {
    return this.deskripsi;
  }

  public int getHargaDasar() {
    return this.hargaDasar;
  }

  public void addFasilitas(String namaFasilitas) throws Exception {
    Class c = Class.forName(namaFasilitas);
    List<Class> interfaces = Arrays.asList(c.getInterfaces());
    interfaces.forEach(itf -> {
      try {
        if (itf.getName().equals("Fasilitas")) {
          this.listFasilitas.add((Fasilitas) c.newInstance());
        }
      } catch (Exception e) {
        System.out.println("Gagal menambahkan fasilitas.");
      }
    });
  }

  public int getHargaFasilitas() {
    int harga = 0;
    for (Fasilitas f : this.listFasilitas) {
      harga += f.getHarga();
    }
    return harga;
  }

  public int getHargaTotal() {
    return this.getHargaDasar() + getHargaFasilitas();
  }

  public int getID() {
    return this.id;
  }

  public String toString() {
    return String.format("INFO PROPERTI:\nID: %d\nDeskripsi: %s\nTotal harga perhari: %d", this.getID(), this.getDeskripsi(), this.getHargaTotal());
  }
}