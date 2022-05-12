class SuiteHotel extends KamarHotel {
  public SuiteHotel(String deskripsi) {
    this.setDeskripsi(deskripsi);
    this.setTipe("deluxe");
    this.setHargaDasar(800000); /* Asumsi */
  }
}