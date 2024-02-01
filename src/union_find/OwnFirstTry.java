package union_find;

import java.util.*;

import static algorithms.BinarySearchForIntegerArray.binarySearch;

public class OwnFirstTry implements UF{
    private int[] newArray;

    List<Set<Integer>> setList = new LinkedList<>();

    public OwnFirstTry(int n) {
        if (n > 1) {
            newArray = new int[n];

            for (int i = 0; i < n ; i++) {
                newArray[i] = i;
            }
        }
    }

    @Override
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

    @Override
    public boolean connected(int p, int q){
        if (setList.isEmpty()) {
            return false;
        }
        for (Set<Integer> s : setList) {
            return s.contains(p) && s.contains(q);
        }
        return false;
    }

}
