package union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

import static algorithms.BinarySearchForIntegerArray.binarySearch;

public class UF {
    private int[] newArray;

    List<Set<Integer>> setList = new LinkedList<>();

    public UF(int n) {
        if (n > 1) {
            newArray = new int[n];

            for (int i = 0; i < n ; i++) {
                newArray[i] = i;
            }
        }
    }

    public void union(int p, int q){
        if(binarySearch(newArray, p) && binarySearch(newArray, q)){
            Set<Integer> integerSet = new HashSet<>();
            integerSet.add(p);
            integerSet.add(q);
            if (setList.isEmpty()) {
                setList.add(integerSet);
            }
            else {
                Set<Integer> tempSet = new HashSet<>();
                for (Set<Integer> s : setList){
                    if(s.contains(p) && s.contains(q)) return;
                    else if (!s.contains(p) && !s.contains(q)){
                        setList.add(integerSet);
                        return;
                    }
                    else if(s.contains(p) || s.contains(q)){
                        if (!tempSet.isEmpty() && !Collections.disjoint(tempSet, s)){
                                tempSet.addAll(s);
                                setList.remove(s);
                                return;
                        }
                        s.add(q);
                        s.add(p);
                    }
                    tempSet = s;
                }
                setList.add(tempSet);
            }
        }
        else throw new IllegalArgumentException("The provided pair of numbers must be between 0 and the size of the array - 1");
    }

    public boolean connected(int p, int q){
        if (setList.isEmpty()) {
            return false;
        }
        for (Set<Integer> s : setList) {
            return s.contains(p) && s.contains(q);
        }
        return false;
    }

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
}
