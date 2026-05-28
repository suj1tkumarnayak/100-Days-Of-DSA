package day_060_date_2026_05_29.graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {

        int vertices = 5;

        // initialize graph
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // add edges
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(1, 4);

        visited = new boolean[vertices];

        // call DFS
        dfs(0);
    }

    static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u); // remove this line for directed graph
    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node+" ");

//        List<Integer> edgeList = graph.get(node);
//        for (int i = 0; i < edgeList.size(); i++) {
//            if(!visited[])
//        }

        for (int neighbour : graph.get(node)) {
            if(!visited[neighbour]){
                dfs(neighbour);
            }
        }
    }
}