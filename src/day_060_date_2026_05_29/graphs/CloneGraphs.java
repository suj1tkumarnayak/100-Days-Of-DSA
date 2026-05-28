package day_060_date_2026_05_29.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraphs {

    static class Node {

        int val;
        ArrayList<Node> neighbors;

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        // create nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // connect graph
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // clone graph
        Node clonedGraph = cloneGraph(node1);

        System.out.println(clonedGraph.val);
    }

    static Node cloneGraph(Node node) {

        HashMap<Node, Node> map = new HashMap<>();

        return dfs(node, map);
    }

    static Node dfs(Node node, HashMap<Node, Node> map) {

        map.put(node, new Node(node.val));
        Queue<Node> q = new LinkedList<>();

        q.offer(node);

        while (!q.isEmpty()){
            Node curr = q.poll();
            for (Node neighbour : curr.neighbors) {
                if(!map.containsKey(neighbour)){
                    map.put(neighbour, new Node(neighbour.val));
                    q.offer(neighbour);
                }
                map.get(curr).neighbors.add(map.get(neighbour));
            }
            
        }

        return map.get(node);
    }
}