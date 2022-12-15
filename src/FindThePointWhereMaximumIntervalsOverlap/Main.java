package FindThePointWhereMaximumIntervalsOverlap;

import FindMaxBandwidth_Q.Show;
import FindMaxBandwidth_Q.st;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        int[] entries = {1, 2, 9, 5, 5};
        int[] exits = {4, 5, 12, 9, 12};
        int ans = findMaxIntervalsTime(entries, exits);
        if (ans == 5) {
            System.out.println("correct");
        } else {
            System.out.println("wrong -> " + ans);
        }

    }

    //-------------------------------O(n*log(n))----------------------------------
    public static int findMaxIntervalsTime(int[] entries, int[] exits) {
        int time = 0;
        int maxPeopleTime = 0;
        int cuurMaxPeopleTime = 0;
        Time[] times = new Time[2 * entries.length];
        int i = 0;
        ArrayList<Time> ls = new ArrayList<Time>();
        for (int element : entries) {
            ls.add(new Time(element, 1));
        }
        for (int element : exits) {
            ls.add(new Time(element, 0));
        }
        Collections.sort(ls, Comparator.comparing(Time::getTime)
                .thenComparing(Comparator.comparingInt(Time::getEntry).reversed()));

        for (Time el : ls) {
            if (el.entry == 1) {
                cuurMaxPeopleTime++;
            } else {
                cuurMaxPeopleTime--;
            }
           if (maxPeopleTime < cuurMaxPeopleTime){
               maxPeopleTime=cuurMaxPeopleTime;
               time = el.time;
           }
        }
        return time;
    }


    //-------------------------------O(n^2)----------------------------------
    public static int findMaxIntervalsTime1(int[] entries, int[] exits) {
        int maxPeopleTime = 0;
        int maxTime = Math.max(Arrays.stream(entries).max().getAsInt(), Arrays.stream(exits).max().getAsInt());
        Arrays.sort(entries);
        for (int i = 0; i < exits.length; i++) {
            maxPeopleTime = Math.max(maxPeopleTime, countOfElementsLessThenOEqualsTOKey(entries, exits[i]));
        }
        return maxPeopleTime;
    }

    public static int countOfElementsLessThenOEqualsTOKey(int arr[], int key) {
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > key)
                break;
        }
        return i;
    }
}
