package day_053_date_2026_05_22.disjointsetunion;

public class Main {
    public static void main(String[] args) {
        DSU dsu = new DSU(7);
        dsu.union(0,1);
        dsu.union(4,5);
        dsu.union(5, 6);
        dsu.union(2, 3);
        System.out.println(dsu.connected(0, 2));
        System.out.println(dsu.connected(4, 6));
        dsu.union(1, 2);
        System.out.println(dsu.connected(0, 2));
    }
}
