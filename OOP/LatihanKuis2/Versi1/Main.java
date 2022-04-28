import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        GoldenQueue goldenQueue = new GoldenQueue();
        SilverQueue silverQueue = new SilverQueue();
        for (int i = 0; i < 10; i++) {
            SilverMember sMember = new SilverMember(Integer.toString(i));
            silverQueue.enqueue(sMember);
        }
        for (int i = 10; i < 20; i++) {
            GoldMember sMember = new GoldMember(Integer.toString(i));
            silverQueue.enqueue(sMember);
        }
        for (Member member : silverQueue.queue) {
            System.out.println(member);
        }
        silverQueue.moveGold(goldenQueue);
        for (Member member : silverQueue.queue) {
            System.out.println(member);
        }
        for (Member member : goldenQueue.queue) {
            System.out.println(member);
        }

    }
}
