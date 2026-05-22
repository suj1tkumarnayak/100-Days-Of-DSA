package day_053_date_2026_05_22.disjointsetunion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node{
    int val;
    List<Node> neighbors;
    Node(){
        val = 0;
        neighbors = new ArrayList<>();
    }
    Node(int val){
        this.val = val;
        neighbors = new ArrayList<>();
    }
    Node(int val, List<Node> neighbors){
        this.val = val;
        this.neighbors = neighbors;
    }
}
public class CloneGraph {
    public static void main(String[] args) {
        // Example 1 Input: [[2,4],[1,3],[2,4],[1,3]]
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};

        System.out.println("Building original graph...");
        Node graph = buildGraph(adjList);

        System.out.println("Cloning graph...");
        Node clonedGraph = cloneGraph(graph);

        System.out.println("Verifying cloned graph structure:");
        printGraph(clonedGraph, new HashMap<>());
    }

    // Helper method to construct a graph from an adjacency list matrix
    public static Node buildGraph(int[][] adjList) {
        if (adjList == null || adjList.length == 0) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();

        // Step 1: Initialize all graph nodes
        for (int i = 1; i <= adjList.length; i++) {
            map.put(i, new Node(i));
        }

        // Step 2: Establish connection links (neighbors)
        for (int i = 0; i < adjList.length; i++) {
            Node currentNode = map.get(i + 1);
            for (int neighborVal : adjList[i]) {
                currentNode.neighbors.add(map.get(neighborVal));
            }
        }

        return map.get(1);
    }

    // Helper method to display graph connections safely without infinite loops
    public static void printGraph(Node node, Map<Integer, Boolean> visited) {
        if (node == null || visited.containsKey(node.val)) {
            return;
        }

        visited.put(node.val, true);
        System.out.print("Node " + node.val + " neighbors: [");
        for (int i = 0; i < node.neighbors.size(); i++) {
            System.out.print(node.neighbors.get(i).val);
            if (i < node.neighbors.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }
    public static Node cloneGraph(Node graph){
        return null;
    }
}
