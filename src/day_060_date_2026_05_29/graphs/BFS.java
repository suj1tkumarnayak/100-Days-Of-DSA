package day_060_date_2026_05_29.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

        bfs(0);
    }

    static void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u); // remove for directed graph
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;

        queue.offer(start);

        while (!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node+" ");
            for (int neighbour : graph.get(node)) {
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }

        }
    }
}