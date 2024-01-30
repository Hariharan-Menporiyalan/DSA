import java.util.Collections;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new java.util.HashSet<>(Set.of(1, 2, 3));
        Set<Integer> set2 = new java.util.HashSet<>(Set.of(1, 2, 3, 4, 5));
        System.out.println(!Collections.disjoint(set1, set2));
    }
}