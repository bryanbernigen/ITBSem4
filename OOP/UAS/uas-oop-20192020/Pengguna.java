class Pengguna {
  private String nama;
  private String email;
  private String noTelepon;

  public Pengguna(String nama, String email, String noTelepon) {
    this.nama = nama;
    this.email = email;
    this.noTelepon = noTelepon;
  }

  public String getNama() {
    return this.nama;
  }

  public String getEmail() {
    return this.email;
  }

  public String noTelepeon() {
    return this.noTelepon;
  }

  public void cariPropertiTersedia(Registry r, String tanggal) {
    r.cariPropertiTersedia(tanggal);
  }

  public void reservasi(Registry r, String tanggal, int idProperti) throws Exception {
    r.reservasiProperti(this, tanggal, idProperti);
  }

  public void terimaPesan(String pesan) {
    System.out.println("Pesan kepada pengguna: " + this.getNama() + " " + pesan);
  }
}