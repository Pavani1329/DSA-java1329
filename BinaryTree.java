class Node{
     int key;
     Node left,right;
     public Node(int item){
        key=item;
        left=right=null;
     }
}
class BinaryTree{
    Node root;
    //System.out.println("Inorder:")
    void traverseTree(Node node){
    if(node!=null){
        traverseTree(node.left);
        System.out.println(" "+node.key);
        traverseTree(node.right);
     }
    }
    void traverseTree1(Node node){
    if(node!=null){
        System.out.println(" "+node.key);
        traverseTree1(node.left);
        traverseTree1(node.right);
    }
    }
    void traverseTree2(Node node){
    if(node!=null){
        traverseTree2(node.left);
        traverseTree2(node.right);
        System.out.println(" "+node.key);
    }
}
public static void main(String[] args){
    BinaryTree tree=new BinaryTree();
    tree.root=new Node(1);
    tree.root.left=new Node(2);
    tree.root.right=new Node(3);
    tree.root.left.left=new Node(4);
    System.out.print("Binary Tree (Inorder):");
        tree.traverseTree(tree.root);
        System.out.print("Binary Tree (preorder):");
        tree.traverseTree1(tree.root);
System.out.print("Binary Tree (postorder):");
        tree.traverseTree2(tree.root);
}
}
