package union_find;

public interface UF {
    public void union(int p, int q);

    public boolean connected(int p, int q);
}
