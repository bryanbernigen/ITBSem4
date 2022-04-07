package Soal1;

public class Main {
    public static void main(String[] args) {
        double d;
        Integer arrint[];
        Utility<Integer> util = new Utility<Integer>();
        Integer[] arr = {1,2,3};
        util.swap(arr, 0, 1);
        d = util.sum(arr);
        System.out.println(util.join(arr));
        System.out.println(d);
    }
}
