import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: duke
 * @date: 2019/7/11 1:28 AM
 */
public class ErTree {

    public static void main(String[] args) throws Exception {
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,8,6};
        BinaryNode root = buildTree(preOrder, inOrder);
        List<Integer> list = preOrderPrint(root, new ArrayList<>());
        System.out.println("前序序遍历=" + Arrays.toString(list.toArray()));

        List<Integer> list2 = inOrderPrint(root, new ArrayList<>());
        System.out.println("中序遍历=" + Arrays.toString(list2.toArray()));

        List<Integer> list3 = aftOrderPrint(root, new ArrayList<>());
        System.out.println("后序序遍历=" + Arrays.toString(list3.toArray()));
    }

    private static BinaryNode buildTree(int[] preOrder, int[] inOrder) throws Exception {
        if (preOrder == null || inOrder == null){
            throw new Exception("invalid data");
        }
        //前序遍历首个元素是根节点
        int rootValue = preOrder[0];
        BinaryNode root = new BinaryNode();
        root.setValue(rootValue);

        //在中序遍历中找到跟节点的位置
        int rootIndex = 0;
        while (rootIndex <= inOrder.length && inOrder[rootIndex] != rootValue){
            rootIndex++;
        }
        //叶子节点
        if (inOrder.length == 1 && preOrder.length == 1 && preOrder[0] == inOrder[0]){
            return root;
        }
        //左子树的元数长度
        int leftLen = rootIndex;
        //构建左子树
        if (leftLen > 0){
            //左子树 中序遍历
            int[] newInorder = copyArray(inOrder, 0, leftLen);
            //左子树 前序遍历
            int[] newPreOrder = copyArray(preOrder, 1, leftLen);
            root.setLeftNode(buildTree(newPreOrder, newInorder));
        }
        //构建右子树
        if (leftLen < preOrder.length - 1){
            //右子树 中序遍历
            int[] newInorder = copyArray(inOrder, rootIndex + 1, inOrder.length - leftLen - 1);
            //右子树 前序遍历
            int[] newPreOrder = copyArray(preOrder, leftLen + 1, preOrder.length - leftLen - 1);
            root.setRightNode(buildTree(newPreOrder, newInorder));
        }
        return root;
    }

    private static List<Integer> preOrderPrint(BinaryNode root, List<Integer> list){
        int value = root.getValue();
        list.add(value);
        if (root.getLeftNode() != null){
            preOrderPrint(root.getLeftNode(), list);
        }
        if (root.getRightNode() != null){
            preOrderPrint(root.getRightNode(), list);
        }
        return list;
    }

    private static List<Integer> inOrderPrint(BinaryNode root, List<Integer> list){
        int value = root.getValue();
        if (root.getLeftNode() != null){
            inOrderPrint(root.getLeftNode(), list);
        }
        list.add(value);
        if (root.getRightNode() != null){
            inOrderPrint(root.getRightNode(), list);
        }
        return list;
    }

    private static List<Integer> aftOrderPrint(BinaryNode root, List<Integer> list){
        int value = root.getValue();
        if (root.getLeftNode() != null){
            aftOrderPrint(root.getLeftNode(), list);
        }
        if (root.getRightNode() != null){
            aftOrderPrint(root.getRightNode(), list);
        }
        list.add(value);
        return list;
    }

    /**
     * 复制数组
     * @param array
     * @param start
     * @param len
     * @return
     */
    private static int[] copyArray(int[] array, int start, int len) {
        int[] newArray = new int[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            newArray[index] = array[i + start];
            index++;
        }
        return newArray;
    }

    static class BinaryNode {
        private int value;
        private BinaryNode leftNode;
        private BinaryNode rightNode;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public BinaryNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(BinaryNode leftNode) {
            this.leftNode = leftNode;
        }

        public BinaryNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(BinaryNode rightNode) {
            this.rightNode = rightNode;
        }
    }
}
