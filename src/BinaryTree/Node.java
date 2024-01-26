package BinaryTree;

public class Node {
    int data;
    Node l;
    Node r;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", l=" + l +
                ", r=" + r +
                '}';
    }

    public Node(int data) {
        this.data = data;
        this.l = null;
        this.r =null;
    }

}
