import java.lang.Comparable;

class Mahasiswa implements Comparable<Mahasiswa> {
    private float ipk;
    private int kodeJurusan;
    private int angkatan;

    public Mahasiswa(int kodeJurusan, int angkatan, float ipk) {
        this.ipk = ipk;
        this.kodeJurusan = kodeJurusan;
        this.angkatan = angkatan;
    }

    public int getKodeJurusan() {
        return this.kodeJurusan;
    }

    public int getAngkatan() {
        return this.angkatan;
    }

    public float getIpk() {
        return this.ipk;
    }

    public int compareTo(Mahasiswa m) {
        // compareTo mengembalikan:
        // 0 bila this sama dengan m
        // 1 bila this lebih dari m
        // -1 bila this kurang dari m
        if (this.ipk == m.ipk && this.kodeJurusan == m.kodeJurusan && this.angkatan == m.angkatan) {
            return 0;
        }
        if (this.kodeJurusan < m.kodeJurusan) {
            return -1;
        }
        if (this.kodeJurusan > m.kodeJurusan) {
            return 1;
        }
        if (this.angkatan > m.angkatan) {
            return -1;
        }
        if (this.angkatan < m.angkatan) {
            return 1;
        }
        if (this.ipk > m.ipk) {
            return -1;
        } else {
            return 1;
        }
    }
}