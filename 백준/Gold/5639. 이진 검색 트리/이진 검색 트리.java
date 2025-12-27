import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static class Node{
        int v;

        Node left;
        Node right;

        public Node(int v) {
            this.v = v;
        }

        public int getV() {
            return v;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    //LRRoot
    static void postOrder(Node root){
        if(root.getLeft() != null){
            postOrder(root.getLeft());
        }
        if(root.getRight() != null){
            postOrder(root.getRight());
        }
        System.out.println(root.getV());
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = new ArrayList<>();

        while (true){
            String node = br.readLine();
            if(node == null){
                break;
            }
            else{
                arr.add(Integer.parseInt(node));
            }
        }

        Node root = new Node(arr.get(0));

        for (int i = 1 ; i < arr.size() ; i ++ ){
            int value = arr.get(i);
            Node cur = root;
            while (true){
                if(cur.getV() > value){
                    if(cur.getLeft() == null){
                        cur.setLeft(new Node(value));
                        break;
                    }
                    cur = cur.getLeft();
                }
                else if(cur.getV() < value){
                    if(cur.getRight() == null){
                        cur.setRight(new Node(value));
                        break;
                    }
                    cur = cur.getRight();
                }
            }
        }

        postOrder(root);
    }
}
