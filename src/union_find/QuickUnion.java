package union_find;

public class QuickUnion implements UF{
    private int[] newArray;

    public QuickUnion(int n) {
        if (n > 1) {
            newArray = new int[n];

            for (int i = 0; i < n; i++) {
                newArray[i] = i;
            }
        }
    }
    @Override
    public void union(int p, int q) {
        int baseRootOfFirstElement = findBaseRoot(p);
        if (baseRootOfFirstElement != q) {
            newArray[baseRootOfFirstElement] = q;
        }
    }

    private int findBaseRoot(int x){
        int root = newArray[x];
        while (newArray[root] != root){
            root = newArray[root];
        }
        return root;
    }

    @Override
    public boolean connected(int p, int q) {
        return findBaseRoot(p) == findBaseRoot(q);
    }
}
