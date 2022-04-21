package Soal3;

import java.util.Timer;
import java.util.TimerTask;

public class Player {
    protected Timer timer;
    protected long timeout;
    protected long lastActive;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            checkLastActive();
        }
    };

    public Player(Timer timer, long timeout) {
        this.timer = timer;
        this.timeout = timeout;
        this.lastActive = System.nanoTime();
        // TODO: Me-set timer untuk menginvoke checkLastActive
        // dengen delay {timeout} ms
        // dan diinvoke tiap {timeout} ms.
        this.timer.schedule(task, this.timeout, this.timeout);
    }

    public void checkLastActive() {
        // TODO: Membandingkan apakah lastActive < waktu sekarang - timeout
        // Jika ya, panggil logout dan cancel timer agar timer berhenti.
        // Gunakan System.nanoTIme() untuk mendapat waktu sekarang.
        if (lastActive < System.nanoTime() - timeout) {
            logout();
            timer.cancel();
        }
    }

    public void logout() {
        System.out.println("logout");
    }

    public void click() {
        // TODO: Update lastActive menjadi waktu sekarang
        this.lastActive = System.nanoTime();
    }
}
