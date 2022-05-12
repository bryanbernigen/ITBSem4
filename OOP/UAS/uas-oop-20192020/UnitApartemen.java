class UnitApartemen extends Properti {
  private int jumlahKamar;

  public UnitApartemen(String deskripsi, int hargaDasar, int jumlahKamar) {
    this.setDeskripsi(deskripsi);
    this.setHargaDasar(hargaDasar);
    this.jumlahKamar = jumlahKamar;
  }

  public int getJumlahKamar() {
    return this.jumlahKamar;
  }
}