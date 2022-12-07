package FindMaxBandwidth_Q;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Show s1 = new Show(1, LocalTime.of(9, 0), LocalTime.of(10, 0), 10);
        Show s2 = new Show(1, LocalTime.of(10, 0), LocalTime.of(11, 0), 10);
        Show s3 = new Show(1, LocalTime.of(10, 0), LocalTime.of(11, 30), 3000);

        Show[] array = {s2, s1, s3};
        int ans = fun(array);
        if (ans == 3010) {
            System.out.println("correct");
        } else {
            System.out.println("wrong");
        }

    }

    public static int fun(Show[] arr) {
        int max = 0;
        int agr = 0;
        ArrayList<st> ls = new ArrayList<st>();
        for (Show element : arr) {
            ls.add(new st(element.getShowStartTime(), element.getBandwidthRequired()));
            ls.add(new st(element.getShowStartTime(), -element.getBandwidthRequired()));
        }
        Collections.sort(ls, Comparator.comparing(st::getTime)
                .thenComparing(Comparator.comparingInt(st::getBandwidth).reversed()));
        for (st el : ls) {
            agr += el.getBandwidth();
            if (max < agr) {
                max = agr;
            }
        }
        return max;
    }
}