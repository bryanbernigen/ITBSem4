package Soal3;

import java.time.chrono.MinguoChronology;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Worker {
	public static int run(List<Integer> durations, int machineCount) {
		// implementation here
        int totalTime = 0;
        int i;
        int min;
        int mindur;
        if(durations.size()<machineCount) {
            return Collections.max(durations);
        }
        if(machineCount==1) {
            totalTime = durations.stream()
            .reduce(0, Integer::sum);
            return totalTime;
        }
        while(!durations.isEmpty()){
            min = Math.min(durations.size(), machineCount);
            mindur = 1000000;
            for ( i = 0; i < min ; i++) {
                if(durations.get(i)<mindur) {
                    mindur = durations.get(i);
                }
            }
            for ( i = 0; i < min ; i++) {
                durations.set(i, durations.get(i)-mindur);
            }
            durations.removeIf(x -> x <= 0);
            totalTime += mindur;
        }
		return totalTime;
	}
}
