package module4.bst;

public class BinarySearchTree<T extends Comparable<T>> {

    private class Node {
        T value;
        Node left, right;

        public Node(T value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    private void makeBSTBySortArray(T [] array, int left, int right) {
        if (left > right) return;
        int mid = (left + right) / 2;
        add(root, array[mid]);
        makeBSTBySortArray(array, left, mid-1);
        makeBSTBySortArray(array, mid+1, right);
    }

    public void makeBSTBySortArray(T [] array) {
        root = null;
        makeBSTBySortArray(array, 0, array.length-1);
    }

    private int depth(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    public int size() {
        return size;
    }

    public int depth() {
        return depth(root);
    }

    public void print(){
        System.out.println("depth: " + depth());

        if(root!=null) {
            print(root.left, "", root.value.toString().length(), true);
            System.out.println(root.value);
            print(root.right, "", root.value.toString().length(), false);
        }
    }

    private void print(Node node, String pref, int sufLen, boolean up){
        if(node!=null){

            StringBuilder mid = new StringBuilder();
            for (int i = 0; i < sufLen - 1; i++) {
                mid.append(" ");
            }
            String sep = "";
            if(sufLen > 0) {
                sep = up ? "┌" : "└";
            }

            String suf = "-> " + node.value;
            print(node.left, pref + mid + (!up ? "|" : " "), suf.length(), true);
            System.out.println(pref + mid + sep + suf);
            print(node.right, pref + mid + (up ? "|" : " "), suf.length(), false);
        }
    }

    private boolean find(Node node, T value) {
        if (node == null) {
            return false;
        } else {
            if (node.value.compareTo(value) == 0) {
                return true;
            } else if (node.value.compareTo(value) > 0) {
                return find(node.left, value);
            } else {
                return find(node.right, value);
            }
        }
    }

    public boolean find(T value) {
        return find(root, value);
    }
    //bad O(depth)
    private void add(Node node, T value) {
        if (root == null) {
            root = new Node(value);
            size++;
        } else {
            if (value.compareTo(node.value) < 0) {
                if (node.left == null) {
                    node.left = new Node(value);
                    size++;
                } else {
                    add(node.left, value);
                }
            } else if (value.compareTo(node.value) > 0) {
                if (node.right == null) {
                    node.right = new Node(value);
                    size++;
                } else {
                    add(node.right, value);
                }
            }
        }
    }

    public void add(T value) {
        add(root, value);
    }
}
