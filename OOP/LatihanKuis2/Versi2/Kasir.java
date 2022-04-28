import java.time.LocalTime;
import java.time.Duration;

public class Kasir {
    private LocalTime akhirShift;
    private Antrian<? extends Member> antrian;

    public Kasir(LocalTime akhirShift) {
        this(null, akhirShift);
    }

    public Kasir(Antrian<? extends Member> antrian, LocalTime akhirShift) {
        this.antrian = antrian;
        this.akhirShift = akhirShift;
    }

    public Antrian<? extends Member> getAntrian() {
        return antrian;
    }

    public boolean isEndShift() {
        return Duration.between(LocalTime.now(), akhirShift).toMinutes() <= 0;
    }
}
