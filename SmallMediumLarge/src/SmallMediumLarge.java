/**
 * Created by Rafael on 4/1/2016.
 */

class AssociationList<Key,Value>{
    private class Node {
        private Key key;
        private Value value;
        private Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    private Node head;
        public AssociationList(){
            head = new Node(null,null,null);
        }
        public boolean isEmpty(){
            return head.next==null;
        }
        public void put(Key key,Value value){
            Node right = head.next;
            if (key==null){
                throw new IllegalArgumentException("key can't be NULL");
            }
            else {
                while(right !=null) {
                    if (key.equals(right.key)) {
                        right.value = value;
                        return;
                    }
                    else{
                        right = right.next;
                    }
                }
                head.next = new Node(key, value, head.next); // adding new node after the head node
            }
        }

        public Value get(Key key){
            Node right = head.next;
            if (isEmpty()){
                throw new IllegalArgumentException("Your Association List is empty");
            }
            else{
                while (right != null){
                    if(right.key.equals(key)){
                        return right.value;
                    }
                    else{
                        right = right.next;
                    }
                }
                throw new IllegalArgumentException("Key doesn't exist");
            }
        }
        public void remove(Key key){
            Node left = head;
            Node right = head.next;
            while (right!=null){
                if (key.equals(right.key)){
                    left.next = right.next;
                    return;
                }
                else{
                    left = right;
                    right = right.next;
                }
            }
            throw new IllegalArgumentException("Key doesn't exist");
        }
}


public class SmallMediumLarge {
        public static void main(String [] args)
        {
            AssociationList<String, Integer> a = new AssociationList<String, Integer>();

            a.put("small",  0);
            a.put("medium", 1);
            a.put("large",  2);

            System.out.println(a.get("small"));   //  0
            System.out.println(a.get("medium"));  //  1
            System.out.println(a.get("large"));   //  2

            a.put("large", 1000);

            System.out.println(a.get("small"));   //  0
            System.out.println(a.get("medium"));  //  1
            System.out.println(a.get("large"));   //  1000

            a.remove("large");

            System.out.println(a.get("small"));   //  0
            System.out.println(a.get("medium"));  //  1
            System.out.println(a.get("large"));   //  Throw an exception.
        }
    }
