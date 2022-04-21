package Soal1;

import java.util.ArrayList;

// DISCLAIMER: Ini hanya gambaran kasar untuk menggambarkan penggunaan setiap kelas, bukan untuk run test
public class Main {
   public static void main(String[] args) {
       int nOrchidSpecies = 10;
       ArrayList<OrchidMeanDatum> meanData = new ArrayList<OrchidMeanDatum>();
       for (int i = 0; i < nOrchidSpecies; i++) {
           meanData.add(new OrchidMeanDatum(i));
       }
       int nChunk = 10;
       // Load setiap jenis anggrek dengan thread berbeda 
       for (int i = 0; i < nChunk; i++) {
            OrchidDataAvgProcessor processor = new OrchidDataAvgProcessor(meanData.get(i), "orchidspecies-" + i + ".txt");
            Thread t = new Thread(processor);
            t.start();
       }
       System.out.println("done");
   }
}