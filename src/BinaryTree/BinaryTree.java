package BinaryTree;

public class BinaryTree {
    Node node;

    public BinaryTree() {
        this.node = null;
    }

    public void preOrder(){
         preOrderR(node);
    }
    public void preOrderR(Node node){
        if(node!=null){
            System.out.println(node.data+" ");
            preOrderR(node.l);
            preOrderR(node.r);
        }
    }

    public void inOrder(){
        inOrderR(node);
    }
    public void inOrderR(Node node){
        if(node!=null){
            inOrderR(node.l);
            System.out.println(node.data+" ");
            inOrderR(node.r);
        }
    }

    public void delete(int deleteData){
       node= deleteR(node, deleteData);
    }

    public Node deleteR(Node node, int deleteData){
        if(node==null)return node;
        if(node.data<deleteData) node.r=deleteR(node.r,deleteData);
        if(node.data>deleteData) node.l=deleteR(node.l,deleteData);
        else {
            if(node.l==null)return node.r;
            if(node.r==null)return node.l;
            int leftMax=findMax(node.l);
            node.data=leftMax;
            node.l=deleteR(node.l,leftMax);
        }
        return node;
    }

    public int findMax(Node node){
        int maxValue=node.data;
        while (node.r!=null){
            maxValue=node.r.data;
            node=node.r;
        }
        return maxValue;
    }

    public void postOrder(){
        postOrderR(node);
    }
    public void postOrderR(Node node){
        if(node!=null){
            postOrderR(node.l);
            postOrderR(node.r);
            System.out.println(node.data+" ");
        }
    }




    public void add(int data){
       node= addNodeR(node, data);
    }

    public Node addNodeR(Node current,int data){
        if(current == null){
            current=new Node(data);
            return current;
        }else if(current.data>data){
            current.l=addNodeR(current.l,data);
        }else if(current.data<data){
            current.r=addNodeR(current.r,data);
        }
        return current;
    }

    public Node search(int searchData){
        return searchR(node,searchData);
    }

    public Node searchR(Node node,int searchData){
        if(node==null||node.data==searchData) return node;
        if(node.data<searchData){
            return searchR(node.r,searchData);
        }
        return searchR(node.l, searchData);
    }


    public void print() {
        print("", node, false);
    }

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.l, true);
            print(prefix + (isLeft ? "|   " : "    "), n.r, false);
        }
    }
}

