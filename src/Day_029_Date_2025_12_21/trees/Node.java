package Day_029_Date_2025_12_21.trees;

public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
