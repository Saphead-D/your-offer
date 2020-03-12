package algorithm;

/**
 * @author: duke
 * @date: 2019/7/11 12:46 AM
 */
public class LinkPrint {

    public static void main(String[] args) {
        Node head = new LinkPrint().new Node();
        head.setCode(1);

        Node n2 = new LinkPrint().new Node();
        n2.setCode(2);
        head.setNext(n2);

        Node n3 = new LinkPrint().new Node();
        n3.setCode(3);
        n2.setNext(n3);

        Node n4 = new LinkPrint().new Node();
        n4.setCode(4);
        n3.setNext(n4);
        print(head);
    }

    public static void print(Node head){
        if (head != null){
            Node next = head.getNext();
            if (next != null){
                print(next);
            }
            System.out.print(head.getCode() + " ");
        }
    }

    class Node {
        private int code;
        private Node next;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
