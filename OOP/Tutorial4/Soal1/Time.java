public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        // Set seluruh atribut dengan nilai 0
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time(Time t) {
        // Set atribut dengan atribut milik t
        this.hour = t.hour;
        this.minute = t.minute;
        this.second = t.second;
    }

    public int getHour() {
        return this.hour;

    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int convertToSecond() {
        return this.hour * 3600 + this.minute * 60 + this.second;
    }

    public Time add(Time t) {
        // Return penjumlahan dua objek jam, yaitu this dan t.
        // Apabila hasil penjumlahan melebihi 23:59:59, maka Anda harus mengonversinya
        // seperti tampilan jam digital asli.
        // Contoh : 24:00:00 dituliskan 00:00:00, 25:00:00 dituliskan 01:00:00, dst.
        int sec = this.convertToSecond() + t.convertToSecond();
        int hour = (sec / 3600) % 24;
        sec = sec % 3600;
        int min = (sec / 60);
        sec = sec % 60;
        Time retTime = new Time(hour, min, sec);
        return retTime;
    }

    public Time minus(Time t) {
        // Return selisih antara dua objek jam, yaitu this dan t.
        // Perhitungan selisih hanya dapat dilakukan jika objek ruas kiri lebih akhir
        // dari atau sama dengan objek ruas kanan.
        // Jika objek ruas kiri lebih awal, maka kembalikan nilai objek ruas kiri.
        // Contoh: 00:00:01 - 00:00:02 = 00:00:01
        int sec = this.convertToSecond() - t.convertToSecond();
        if (sec < 0) {
            return new Time(this);
        } else {
            int hour = sec / 3600;
            sec = sec % 3600;
            int min = (sec / 60);
            sec = sec % 60;
            return new Time(hour, min, sec);
            
        }
    }

    public boolean lessThan(Time t) {
        // Returns true jika this < t menurut definisi waktu
        return (this.convertToSecond() < t.convertToSecond());
    }

    public boolean greaterThan(Time t) {
        // Returns true jika this > t menurut definisi waktu
        return (this.convertToSecond() > t.convertToSecond());
    }

    public void printTime() {
        // Menuliskan jam dalam format hh:mm:ss diakhiri dengan newline. Perhatikan
        // bahwa setiap parameter harus dituliskan 2 digit.
        System.out.printf("%02d:%02d:%02d\n", this.hour, this.minute, this.second);
    }
}