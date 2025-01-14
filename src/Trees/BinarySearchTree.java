package Trees;

public class BinarySearchTree {
    public static void main(String[] args) {
        Node root=new Node(20);
        Node l=new Node(17);
        Node r=new Node(23);
        Node ll=new Node(13);
        Node lr=new Node(19);
        Node rl=new Node(22);
        Node rr=new Node(25);

        root.setLeft(l);
        root.setRight(r);
        l.setLeft(ll);
        l.setRight(lr);
        r.setLeft(rl);
        r.setRight(rr);

        //                      20
        //                    /    \
        //                  17      23
        //                 /  \    /   \
        //               13    19 22   25

        R_Insert(root, 23);
        BinaryTree.InOrder(root);



    }


    //                  ***********************     Searching in a Binary Tree     ***********************

    private static Node R_searchTree(Node pointer, int i) {
        if(pointer==null)
            return null;
        if(pointer.value==i)
            return pointer;
        if(pointer.value<i)
            return R_searchTree(pointer.right, i);
        return R_searchTree(pointer.left, i);

    }

    private static Node I_searchTree(Node pointer, int i) {
        if(pointer==null)
            return null;
        while(pointer!=null){
            if(pointer.value==i)
                return pointer;
            else if(i>pointer.value){
                pointer=pointer.right;
                continue;
            }
            else {
                pointer=pointer.left;
                continue;
            }
        }
        return null;
    }



    //                  ***********************     Inserting in a Binary Tree     ***********************


    static void I_Insert(Node pointer, int val){
        Node temp=null;
        if(pointer==null){
            System.out.println("Insertion successful");
            return;
        }
        Node t=new Node(val);
        while(pointer!=null){
            temp=pointer;
            if (val==pointer.value){
                System.out.println("Element already present in the array");
                return;
            }else if(val>pointer.value)
                pointer=pointer.right;
            else
                pointer=pointer.left;
        }
        if(temp.value>val)
            temp.setLeft(t);
        else
            temp.setRight(t);
    }

    static Node R_Insert(Node pointer, int val){
        Node temp;
        if(pointer==null){
            temp= new Node(val);
            return temp;
        }
        if(pointer.value>val){
            pointer.left=R_Insert(pointer.left, val);
        }
        else{
            pointer.right=R_Insert(pointer.right, val);
        }
        return pointer;
    }



    //                  ***********************     Creating in a Binary Tree     ***********************




    static Node createTree(int[]arr){
        if(arr.length==0)
            return null;
        Node root=new Node(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            I_Insert(root, arr[i]); // Insert remaining elements
        }
        return root;

    }
}

