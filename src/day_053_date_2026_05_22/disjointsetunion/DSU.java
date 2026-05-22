package day_053_date_2026_05_22.disjointsetunion;

public class DSU {
    int[] parent;
    int[] size;

    public DSU(int n){
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // find the root //path compression
    public int find(int x){
        if(parent[x]==x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    //union by size
    public void union(int a, int b){
        int rootA = find(a);
        int rootB= find(b);

        // already connected
        if(rootA==rootB){
            return;
        }

        // attach smaller root under bigger
        if(size[rootA]<size[rootB]){
            parent[rootA] = parent[rootB];
            size[rootB] += size[rootA];
        }else{
            parent[rootB] = parent[rootA];
            size[rootA] += size[rootB];
        }
    }
    // check if the same component
    public boolean connected(int a, int b){
        return find(a) == find(b);
    }
}
