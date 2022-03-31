import java.util.*;

public class Dompet<T extends Number> {
    private ArrayList<Transaction> transactions;


     public Dompet() {
        // Constructor tanpa parameter, transactions diinisialisasi dengan array list baru
        this.transactions = new ArrayList<Transaction>();
    }


    public Dompet(T initialBalance) {
        // Constructor dengan parameter T initialBalance, inisialisasi transactions dengan array list baru dan tambahkan transaksi tambah dengan value initial balance
        /* contoh transaksi tambah: new Transaction<T>('+', initialBalance) */
        this.transactions = new ArrayList<Transaction>();
        this.transactions.add(new Transaction('+', initialBalance));
    }

    public void addMoney(T money) {
        // Buat prosedur addMoney dengan parameter T money, tambahkan transaksi tambah dengan senilai money
        this.transactions.add(new Transaction('+',money));
    }

    public boolean takeMoney(T money) {
        // Tambahkan transaksi kurang sebesar money (perlu ada pengecekan apakah balance cukup atau tidak)
        // false bila transaksi gagal, true bila berhasil
        Double balance=0.0;
        for (Transaction transaction : transactions) {
            if(transaction.getType() == '+'){
                balance += transaction.getAmount().doubleValue();
            }
            else{
                balance -= transaction.getAmount().doubleValue();
            }
        }
        if(balance >= money.doubleValue()){
            this.transactions.add(new Transaction('-',money));
            return true;
        }
        else{
            return false;
        }
    }

    public void setBalance(T balance) {
        // Mengganti transaksi agar bernilai sama dengan balance
        // Tips: inisialisasi ulang transactions, lalu tambahkan transaksi tambah sebanyak balance
        this.transactions.clear();
        this.addMoney(balance);
    }

    // Akses nilai Double dilakukan dengan .doubleValue()
    // Contoh: amount.doubleValue()

    public Double getBalance(){
        // Mencari balance dompet dari transaksi dengan cara menghitung total transaksi
        Double balance=0.0;
        for (Transaction transaction : transactions) {
            if(transaction.getType() == '+'){
                balance += transaction.getAmount().doubleValue();
            }
            else{
                balance -= transaction.getAmount().doubleValue();
            }
        }
        return balance;
    }

    public void printTransactions() {
        // Print seluruh transaksi yang ada pada array
        // Format: Transactions [indeks + 1]: [tipe transaksi] [amount]
        // Contoh: Transactions 3: + 500
        int i = 0;
        for (Transaction transaction : transactions) {
            i++;
            System.out.printf("Transactions %d: %c ", i, transaction.getType());
            System.out.println(transaction.getAmount());
        }
    }

    public Double getAverageTransaction() {
        // Mencari rata-rata transaksi (jika tidak ada transaksi, berikan hasil null)
        if(this.transactions.size() == 0){
            return null;
        }
        else{
            Double balance=0.0;
            for (Transaction transaction : transactions) {
                if(transaction.getType() == '+'){
                    balance += transaction.getAmount().doubleValue();
                }
                else{
                    balance -= transaction.getAmount().doubleValue();
                }
            }
            return balance/this.transactions.size();
        }
    }

    public Double getMinimumTransaction() {
        // Mencari nilai minimum transaksi (jika tidak ada transaksi, berikan hasil null; hanya perlu membandingkan nilainya saja tanpa peduli type)
        if(this.transactions.size() == 0){
            return null;
        }
        else{
            Double balance = 999999.0;
            for (Transaction transaction : transactions) {
                if(balance>transaction.getAmount().doubleValue()){
                    balance = transaction.getAmount().doubleValue();
                }
            }
            return balance;
        }
    }

    public Double getMaximumTransaction() {
        // Mencari nilai maksimum transaksi (jika tidak ada transaksi, berikan hasil null; hanya perlu membandingkan nilainya saja tanpa peduli type)
        if(this.transactions.size() == 0){
            return null;
        }
        else{
            Double balance = 0.0;
            for (Transaction transaction : transactions) {
                if(balance<transaction.getAmount().doubleValue()){
                    balance = transaction.getAmount().doubleValue();
                }
            }
            return balance;
        }
    }
}