package Day_029_Date_2025_12_21.trees;

public class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data){
        this.data = data;
    }

    public Tree(int data, Tree left){
        this.data = data;
        this.left = left;
    }
    public Tree(int data,Tree left, Tree right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
