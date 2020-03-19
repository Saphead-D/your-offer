package problem.offer;

import problem.offer.node.BTreeNode;

public class Problem19 {

    public static BTreeNode  mirror(BTreeNode root) {
        if (root == null){
            return null;
        }
        if (root.leftChild != null || root.rightChild != null){
            BTreeNode tmp = root.leftChild;
            root.leftChild = root.rightChild;
            root.rightChild = tmp;
        }
        mirror(root.leftChild);
        mirror(root.rightChild);
        return root;
    }

    public static void main(String[] args) {
        BTreeNode node1 = new BTreeNode();
        BTreeNode node2 = new BTreeNode();
        BTreeNode node3 = new BTreeNode();
        BTreeNode node4 = new BTreeNode();
        BTreeNode node5 = new BTreeNode();
        BTreeNode node6 = new BTreeNode();
        BTreeNode node7 = new BTreeNode();
        BTreeNode node8 = new BTreeNode();
        node1.leftChild = node2;
        node1.rightChild = node3;
        node2.leftChild = node4;
        node4.rightChild= node7;
        node3.leftChild = node5;
        node3.rightChild = node6;
        node6.leftChild = node8;

        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node4.data = 4;
        node5.data = 5;
        node6.data = 6;
        node7.data = 7;
        node8.data = 8;
        BTreeNode mirror = mirror(node1);
        System.out.println(mirror.data);
    }
}
