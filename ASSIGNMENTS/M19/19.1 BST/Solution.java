import java.util.Scanner;
class Book implements Comparable<Book> {
    private String bookName;
    private String author;
    private float price;
    Book(final String name, final String a, final float p) {
        this.bookName = name;
        this.author = a;
        this.price = p;
    }
    public String getBookName() {
        return this.bookName;
    }
    public void setBookName(final String s) {
        this.bookName = s;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(final String a1) {
        this.author = a1;
    }
    public float getPrice() {
        return this.price;
    }
    public void setPrice(final float p1) {
        this.price = p1;
    }
    public int compareTo(final Book that) {
        return this.getBookName().compareTo(that.getBookName());
    }
    public String toString() {
        return getBookName() + ", " + getAuthor() + ", " + getPrice();
    }
}
class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;
        Node(final Key key1, final Value val1) {
            this.key = key1;
            this.value = val1;
            this.size = 0;
        }
    }
    BST() {
        //Unused Constructor.
    }
    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    public void put(final Key key, final Value val) {
        root = put(root, key, val);
    }
    private Node put(final Node x, final Key key, final Value val) {
        if (x == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.value = val;
        }
        return x;
    }
    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }
    public Key min() {
        return min(root).key;
    }
    private Node min(Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    public Key max() {
        return max(root).key;
    }
    private Node max(Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    private Node floor(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return floor(x.left, key);
        }
        if (cmp == 0) {
            return x;
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
    public Key select(int k) {
        Node x = select(root, k);
        return x.key;
    }
    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    public int rank(Key key) {
        return rank(key, root);
    }
    private int rank(Key key, Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }
}
public class Solution {
    private Solution() {
        //Unused Constructor.
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BST<Book, Integer> b = new BST<Book, Integer>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
                case "put":
                    Book books = new Book(tokens[1], tokens[2],
                        Float.parseFloat(tokens[2 + 1]));
                    b.put(books, Integer.parseInt(tokens[2 + 2]));
                break;
                case "get":
                    books = new Book(tokens[1], tokens[2],
                        Float.parseFloat(tokens[2 + 1]));
                    System.out.println(b.get(books));
                break;
                case "max":
                    System.out.println(b.max());
                break;
                case "min":
                    System.out.println(b.min());
                break;
                case "select":
                    System.out.println(b.select(
                        Integer.parseInt(tokens[1])));
                break;
                case "floor":
                    books = new Book(tokens[1], tokens[2],
                        Float.parseFloat(tokens[2 + 1]));
                    System.out.println(b.floor(books));
                break;
                case "ceiling":
                    books = new Book(tokens[1], tokens[2],
                        Float.parseFloat(tokens[2 + 1]));
                    System.out.println(b.ceiling(books));
                break;
                default:
                break;
            }
        }
    }
}