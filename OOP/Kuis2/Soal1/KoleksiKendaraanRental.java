package Soal1;

class KoleksiKendaraanRental{
    private KendaraanRental[] koleksi;
    private int kapasitasRentalSaatIni;
    private int kapasitasRentalMaksimum;

    public KoleksiKendaraanRental(){
        kapasitasRentalSaatIni = 0;
        kapasitasRentalMaksimum = 5;
        koleksi = new KendaraanRental[5];
    }
    public KoleksiKendaraanRental(int kapasitasRentalMaksimum){
        kapasitasRentalSaatIni = 0;
        this.kapasitasRentalMaksimum = kapasitasRentalMaksimum;
        koleksi = new KendaraanRental[kapasitasRentalMaksimum];
    }
    
    public void add(KendaraanRental k){
        if(kapasitasRentalSaatIni != kapasitasRentalMaksimum){
            koleksi[kapasitasRentalSaatIni] = k;
            kapasitasRentalSaatIni++; 
        }
    }
    public void remove(){
        if(kapasitasRentalSaatIni>0){
            this.kapasitasRentalSaatIni--;
            for (int i = 0; i < this.kapasitasRentalSaatIni; i++) {
                this.koleksi[i]= this.koleksi[i+1];
            }
        }
    }

    public void printAll(){
        for (int i = 0 ; i < kapasitasRentalSaatIni ; i++){
            System.out.println("KendaraanRental ke-" +  (i+1) );
            koleksi[i].printInfo();
        }
    }
    
}
