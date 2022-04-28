public abstract class Member {
    private String nama;

    public Member(String nama) {
        this.nama = nama;
    }

    public abstract String getType();

    public String getNama() {
        return nama;
    }
}
