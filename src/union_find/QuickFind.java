package union_find;

public class QuickFind implements UF{
    private int[] newArray;

    public QuickFind(int n) {
        if (n > 1) {
            newArray = new int[n];

            for (int i = 0; i < n; i++) {
                newArray[i] = i;
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return newArray[p] == newArray[q];
    }

    @Override
    public void union(int p, int q) {
        for (int i = 0; i <= newArray.length; i++) {
            if (newArray[i] == p) newArray[i] = q;
        }
    }
}

