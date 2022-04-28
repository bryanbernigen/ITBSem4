public class AntrianMember extends Antrian<Member> {
    public AntrianMember() {
        super();
    }

    public void pindahAntrian(AntrianGold antrianGold) {
        Member m;
        for (int i = 0; i < antrian.size(); i++) {
            m = antrian.get(i);
            if (m instanceof MemberGold) {
                antrian.remove(m);
                antrianGold.tambahAntrian((MemberGold) m);
                i--;
            }
        }
    }
}
