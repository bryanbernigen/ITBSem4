class StandardHotel extends KamarHotel {
  public StandardHotel(String deskripsi) {
    this.setDeskripsi(deskripsi);
    this.setTipe("standard");
    this.setHargaDasar(400000);
  }
}