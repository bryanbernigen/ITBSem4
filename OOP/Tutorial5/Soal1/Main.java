public class Main {
    public static void main(String[] args) {
        Dompet<Integer> dompet = new Dompet<Integer>();
        dompet.addMoney(100);
        dompet.addMoney(200);
        dompet.takeMoney(50);
        dompet.printTransactions();
    }
}
