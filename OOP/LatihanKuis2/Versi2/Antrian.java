import java.util.ArrayList;

public abstract class Antrian<T extends Member> {
    protected ArrayList<T> antrian;
    public Antrian() {
        antrian = new ArrayList<>();
    }

    public T prosesAntrian() {
        return antrian.remove(0);
    }

    public void tambahAntrian(T member) {
        antrian.add(member);
    }
}
