package Soal1;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class OrchidDataAvgProcessor implements Runnable {
    // Tambahkan atribut sesuai kebutuhan
    private OrchidMeanDatum meanDatum;
    private String filename;

    public OrchidDataAvgProcessor(OrchidMeanDatum meanDatum, String rawDataFilename) {
        // Konstruktor
        this.meanDatum = meanDatum;
        this.filename = rawDataFilename;
    }

    @Override
    public void run() {
        // Menghitung rata-rata dari data yang dibaca dengan CSVReader, lalu update
        // meanDatum dengan rata-rata dari setiap aspek data

        // Apabila muncul IOException, maka hasil pembacaan data adalah kosong
        // dan meanDatum tidak di-update (tidak di throw lagi)
        try {
            CSVReader reader = new CSVReader(filename, ",");
            List<String[]> data = reader.read();
            float petalLengthSum = 0;
            float petalWidthSum = 0;
            float stemLengthSum = 0;
            int jumlahData = 0;
            for (String[] row : data) {
                petalLengthSum += Float.parseFloat(row[0]);
                petalWidthSum += Float.parseFloat(row[1]);
                stemLengthSum += Float.parseFloat(row[2]);
                jumlahData++;
            }
            meanDatum.setMean(petalLengthSum / jumlahData, petalWidthSum / jumlahData, stemLengthSum / jumlahData);
        } catch (IOException e) {
            // Do nothing
        }
    }
}