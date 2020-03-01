package municipal;

import java.util.LinkedList;
import java.util.Scanner;

class Main {
    static class AVLRope<T extends Number & Comparable<T>> {

        private Node<T> root;

        private static class Node<T extends Number> {
            Node<T> left;
            Node<T> right;
            T value;
            int size;
            int height;
            long sum;

            Node(T value) {
                this.value = value;
                this.height = 1;
                this.sum = value.longValue();
                this.size = 1;
            }
        }

        public void add(T value) {
            if (value == null) {
                throw new NullPointerException();
            }
            Node<T> newNode = new Node<>(value);
            merge(newNode);
        }

        public void cutAndReplace(int i, int j, int k) {
            if (j < i) {
                throw new IllegalArgumentException();
            }
            AVLRope<T> center = split(i - 1);
            AVLRope<T> right = center.split(j - i);
            merge(right);

            right = split(k - 1);
            merge(center);
            merge(right);
        }

        public String toPlainString() {
            StringBuilder sb = new StringBuilder();
            LinkedList<Node<T>> stack = new LinkedList<>();
            Node<T> node = root;
            while (node != null || !stack.isEmpty()) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    sb.append(node.value);
                    node = node.right;
                }
            }
            return sb.toString();
        }

        private void merge(AVLRope<T> rope) {
            merge(rope.root);
        }

        private void merge(Node<T> v2) {
            if (root == null) {
                root = v2;
                return;
            }
            if (v2 == null) {
                return;
            }
            RemoveMinMaxResult<T> removeMaxResult = removeMax(root);
            root = avlMergeWithRoot(removeMaxResult.next, v2, removeMaxResult.result);
        }

        /**
         * @return дерево с элементами, индексы которых > index
         * в искомом дереве остаются элементы с индексами <= index
         */
        private AVLRope<T> split(int index) {
            Node[] roots = new Node[2];
            split(root, index, roots);
            this.root = roots[0];
            AVLRope<T> secondTree = new AVLRope<>();
            secondTree.root = roots[1];
            return secondTree;
        }

        public long getRSQ(int l, int r) {
            Node [] roots = new Node[2];
            split(root, l - 1, roots);
            Node [] root2 = new Node[2];
            split(roots[1], r, root2);
            Node<T> mode = mergeWithRoot(roots[1], root2[0], root);
            return sum(mode);
        }

        private Node<T> balance(Node<T> node) {
            fixHeight(node);
            fixSum(node);
            int balanceFactor = balanceFactor(node);
            if (balanceFactor == 2) {
                if (balanceFactor(node.right) < 0) {
                    node.right = rotateRight(node.right);
                }
                return rotateLeft(node);
            }
            if (balanceFactor == -2) {
                if (balanceFactor(node.left) > 0) {
                    node.left = rotateLeft(node.left);
                }
                return rotateRight(node);
            }
            return node;
        }

        private Node<T> rotateRight(Node<T> node) {
            Node<T> q = node.left;
            node.left = q.right;
            q.right = node;
            fixHeight(node);
            fixSum(node);
            fixHeight(q);
            fixSum(q);
            return q;
        }

        private Node<T> rotateLeft(Node<T> node) {
            Node<T> p = node.right;
            node.right = p.left;
            p.left = node;
            fixHeight(node);
            fixSum(node);
            fixHeight(p);
            fixSum(p);
            return p;
        }
        private static class RemoveMinMaxResult<T extends Number> {
            private Node<T> next;

            private final Node<T> result;
            RemoveMinMaxResult(Node<T> next, Node<T> result) {
                this.next = next;
                this.result = result;
            }

        }

        private RemoveMinMaxResult<T> removeMax(Node<T> node) {
            if (node.right == null) {
                return new RemoveMinMaxResult<T>(node.left, node);
            }
            RemoveMinMaxResult<T> removeMaxResult = removeMax(node.right);
            node.right = removeMaxResult.next;
            removeMaxResult.next = balance(node);
            return removeMaxResult;
        }

        private Node<T> avlMergeWithRoot(Node<T> v1, Node<T> v2, Node<T> root) {
            if (root == null) {
                throw new IllegalArgumentException();
            }
            int heightDiff = height(v1) - height(v2);
            if (heightDiff >= -1 && heightDiff <= 1) {
                mergeWithRoot(v1, v2, root);
                fixHeight(root);
                fixSum(root);
                return root;
            } else if (heightDiff > 0) {
                v1.right = avlMergeWithRoot(v1.right, v2, root);
                return balance(v1);
            } else {
                v2.left = avlMergeWithRoot(v1, v2.left, root);
                return balance(v2);
            }
        }

        private static <T extends Number & Comparable<T>> Node<T> mergeWithRoot(Node<T> v1, Node<T> v2, Node<T> root) {
            root.left = v1;
            root.right = v2;
            return root;
        }

        private void split(Node<T> node, int index, Node<T>[] roots) {
            if (node == null) {
                roots[0] = null;
                roots[1] = null;
                return;
            }
            int currentIndex = currentIndex(node);
            if (index < currentIndex) {
                split(node.left, index, roots);
                roots[1] = avlMergeWithRoot(roots[1], node.right, node);
            } else {
                split(node.right, indexInRight(node, index), roots);
                roots[0] = avlMergeWithRoot(node.left, roots[0], node);
            }
        }

        private static int balanceFactor(Node node) {
            if (node == null) {
                throw new IllegalArgumentException();
            }
            return height(node.right) - height(node.left);
        }

        private static int size(Node node) {
            return node == null ? 0 : node.size;
        }

        private static int height(Node node) {
            return node == null ? 0 : node.height;
        }

        private static long sum(Node node) {
            return node == null ? 0 : node.sum;
        }


        private static int currentIndex(Node node) {
            return size(node.left);
        }

        private static int indexInRight(Node node, int index) {
            return index - size(node.left) - 1;
        }

        private void fixSum(Node<T> node) {
            if (node == null) {
                throw new IllegalArgumentException();
            }
            node.sum = sum(node.left) + sum(node.right) + node.value.longValue();
        }

        private void fixHeight(Node<T> node) {
            if (node == null) {
                throw new IllegalArgumentException();
            }
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            node.size = size(node.left) + size(node.right) + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLRope<Integer> tree = new AVLRope<>();
        for (int i = 0; i < 10; i++) {
            tree.add(i+1);
        }
        System.out.println(tree.getRSQ(2, 7));
        System.out.println(tree.getRSQ(2, 7));
        System.out.println(tree.getRSQ(2, 7));
        System.out.println(tree.getRSQ(2, 7));
    }
}