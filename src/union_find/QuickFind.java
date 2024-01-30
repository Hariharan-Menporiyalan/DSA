package union_find;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFind {
    private int[] newArray;
    public QuickFind(int n) {
        if (n > 1) {
            newArray = new int[n];

            for (int i = 0; i < n ; i++) {
                newArray[i] = i;
            }
        }
    }

    public boolean connected(int p, int q){
        return newArray[p] == newArray[q];
    }

    public void union(int p, int q){
        for (int i = 0; i <= newArray.length; i++){
            if (newArray[i] == p) newArray[i] = q;
        }
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
