class DeluxeHotel extends KamarHotel {
  public DeluxeHotel(String deskripsi) {
    this.setDeskripsi(deskripsi);
    this.setTipe("deluxe");
    this.setHargaDasar(600000);
  }
}