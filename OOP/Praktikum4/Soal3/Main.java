package Soal3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> durations = new ArrayList<Integer>();
        durations.add(5);
        durations.add(1);
        durations.add(3);
        durations.add(2);
        durations.add(4);
        int machineCount = 1;
        int a = Worker.run(durations, machineCount);
        System.out.println(a);
    }
}
