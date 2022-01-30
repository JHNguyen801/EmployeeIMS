package model;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Ranking<T extends Comparable<? super T>>{
    public static <T extends Comparable<? super T>> void rank(ArrayList<T> arr) {
        Collections.sort(arr, Collections.reverseOrder());
    }// Method end
}
