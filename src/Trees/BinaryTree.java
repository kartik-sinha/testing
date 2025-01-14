package Trees;


//        ******************** Binary Tree ********************


import java.util.*;

class Node{
    //points to left child of the Node
    Node left;

    //points to right child of the Node
    Node right;

    //stores the value of the node
    int value;

    //No args constructor
    public Node(int value) {
        this.value = value;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
    public void setRight(Node right) {
        this.right = right;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        createTree();
    }



    //        ******************** Creating a Binary Tree ********************



    static void createTree(){
        //To store the address of the nodes
        Queue<Node> queue=new LinkedList<>();

        //To point at a node
        Node pointer;

        System.out.print("Enter root value: ");
        Scanner sc=new Scanner(System.in);
        int val=sc.nextInt();
        Node root=new Node(val);
        queue.add(root);

        while(!(queue.isEmpty())){
            pointer=queue.poll();

            //Creating node for the left child
            System.out.print("Enter left child value of "+pointer.value+": ");
            int left_val=sc.nextInt();
            if(left_val!=-1){
                Node lChild=new Node(left_val);
                pointer.left=lChild;
                queue.add(lChild);
            }
            //Creating node for the right child
            System.out.print("Enter right child value of "+pointer.value+": ");
            int right_val=sc.nextInt();
            if(right_val!=-1){
                Node rChild=new Node(right_val);
                pointer.right=rChild;
                queue.add(rChild);
            }
        }

            System.out.println(Leaf_Nodes(root));;
//        //Recursive
//        PreOrder_Traversal(root);
//        System.out.println();
//        PostOrder_Traversal(root);
//        System.out.println();
        System.out.println(new BinaryTree().isSymmetric(root));
        System.out.println();
//
//        //Iterative
//        PreOrder(root);
//        System.out.println();
//        InOrder(root);
//        System.out.println();

//        Level Order mode of traversal
//        LevelOrder(root);
    }





    //        ******************** Traversal in a Binary Tree ********************






    public boolean isSymmetric(Node root) {
        int[] arr=InOrder2(root);
        if(arr.length%2 != 0)
            return false;

        for(int i=0, j=arr.length-1; i<arr.length/2 -1; i++, j--){
            if(arr[i]!=arr[j])
                return false;
        }
        return true;

    }
    static int[] InOrder2(Node pointer){
        ArrayList<Integer> list=new ArrayList<Integer>();

        if(pointer!=null){
            InOrder2(pointer.left);
            list.add(pointer.value);
            InOrder2(pointer.right);
        }
        int[]arr=new int[list.size()];
        for(int i=0; i<arr.length; i++){
            arr[i]=list.get(i);
        }
        return arr;
    }






    //Recursive Pre-Order mode of traversal in a tree.
    static void PreOrder_Traversal(Node pointer){
        if(pointer!=null){
            System.out.print(pointer.value+" ");
            PreOrder_Traversal(pointer.left);
            PreOrder_Traversal(pointer.right);
        }
    }

    //Recursive In-Order mode of traversal in a tree.
    static void InOrder_Traversal(Node pointer){
        if(pointer!=null){
            InOrder_Traversal(pointer.left);
            System.out.print(pointer.value+" ");
            InOrder_Traversal(pointer.right);
        }
    }
    //Recursive Post-Order mode of traversal in a tree.
    static void PostOrder_Traversal(Node pointer){
        if(pointer!=null){
            PostOrder_Traversal(pointer.left);
            PostOrder_Traversal(pointer.right);
            System.out.print(pointer.value+" ");
        }
    }

    //Iterative Pre-Order mode of traversal in a tree.
    static void PreOrder(Node pointer){
        Stack<Node> s=new Stack<Node>();

        while(pointer!=null || !(s.isEmpty())){
            if(pointer!=null){
                System.out.print(pointer.value+" ");
                s.push(pointer);
                pointer=pointer.left;
            }else{
                pointer=s.pop();
                pointer=pointer.right;
            }
        }
    }

    //Iterative In-Order mode of traversal in a tree.
    static void InOrder(Node pointer){
        List<Integer> l=new ArrayList<>();
        for(Integer i : l){

        }
        Stack<Node> s=new Stack<Node>();

        while(pointer!=null || !(s.isEmpty())){
            if(pointer!=null){
                s.push(pointer);
                pointer=pointer.left;
            }else{
                pointer=s.pop();
                System.out.print(pointer.value+" ");
                pointer=pointer.right;
            }
        }
    }

    //Level Order mode of traversal
    static void LevelOrder(Node pointer){
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(pointer);
        System.out.print(pointer.value+" ");

        while(!(queue.isEmpty())){
            pointer=queue.poll();

            if(pointer.left!=null){
                System.out.print(pointer.left.value+" ");
                queue.add(pointer.left);
            }
            if(pointer.right!=null){
                System.out.print(pointer.right.value+" ");
                queue.add(pointer.right);
            }
        }
    }





    //        ******************** Count,Leaf Nodes and Height of a Binary Tree ********************




    //Count of nodes in a binary tree
    static int count(Node pointer){
        int x, y;
        if(pointer!=null){
            return count(pointer.left)+count(pointer.right)+1;
        }
        return 0;
    }

    //Height of a binary tree
    static int height(Node pointer){
        int x, y;

        if(pointer==null)
            return 0;
        x=height(pointer.left);
        y=height(pointer.right);
        if(x>y)
            return x+1;
        return y+1;
    }

    //Count of leaf nodes in a binary tree
    static int Leaf_Nodes(Node pointer){
        int x,y;
        int count=0;

        if(pointer!=null){
            x=Leaf_Nodes(pointer.left);
            y=Leaf_Nodes(pointer.right);
            if(pointer.left==null && pointer.right==null){
                 count++;
                 return count;
            }
            return x+y;

        }
        return 0;
    }
}





