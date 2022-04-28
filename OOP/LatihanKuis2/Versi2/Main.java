import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        AntrianGold antrianGold = new AntrianGold();
        AntrianMember antrianMember = new AntrianMember();
        Kasir kasirGold = new Kasir(antrianGold, LocalTime.of(10, 0));
        Kasir kasirMember = new Kasir(antrianMember, LocalTime.of(12, 0));
        for (int i = 0; i < 50; i++) {
            if (i % 4 == 0) {
                antrianGold.tambahAntrian(new MemberGold("Budi " + i));
            } else if (i % 2 == 0) {
                antrianMember.tambahAntrian(new MemberGold("Lucy " + i));
            } else {
                antrianMember.tambahAntrian(new MemberSilver("Andi " + i));
            }
        }
        System.out.println("Antrian kasir gold, isEnd = " + kasirGold.isEndShift());
        System.out.println("Member antrian kasir gold:");
        for (Member m: antrianGold.antrian) {
            System.out.println(m.getNama() + " " + m.getType());
        }
        System.out.println("Antrian kasir member, isEnd = " + kasirMember.isEndShift());
        System.out.println("Member antrian kasir member:");
        for (Member m: antrianMember.antrian) {
            System.out.println(m.getNama() + " " + m.getType());
        }
        System.out.println("Memindahkan member gold ke antrian gold.");
        antrianMember.pindahAntrian(antrianGold);
        System.out.println("Member antrian kasir gold:");
        for (Member m: antrianGold.antrian) {
            System.out.println(m.getNama() + " " + m.getType());
        }
        
        System.out.println("Member antrian kasir member:");
        for (Member m: antrianMember.antrian) {
            System.out.println(m.getNama() + " " + m.getType());
        }
    }
}
