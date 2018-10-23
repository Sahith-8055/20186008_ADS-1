import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * {Name of the book}.
     */
    private String bookName;
    /**
     * {Name of the author}.
     */
    private String author;
    /**
     * {Price of the book}.
     */
    private float price;
    /**
     * Constructs the object.
     * Time complexity of this method is O(1).
     * @param      name  The name
     * @param      a     {Author name}
     * @param      p     {Price}
     */
    Book(final String name, final String a, final float p) {
        this.bookName = name;
        this.author = a;
        this.price = p;
    }
    /**
     * Gets the book name.
     * Time complexity of this method is O(1).
     * @return     The book name.
     */
    public String getBookName() {
        return this.bookName;
    }
    /**
     * Sets the book name.
     * Time complexity of this method is O(1).
     * @param      s     {Name of the book}
     */
    public void setBookName(final String s) {
        this.bookName = s;
    }
    /**
     * Gets the author.
     * Time complexity of this method is O(1).
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Sets the author.
     * Time complexity of this method is O(1).
     * @param      a1    A1
     */
    public void setAuthor(final String a1) {
        this.author = a1;
    }
    /**
     * Gets the price.
     * Time complexity of this method is O(1).
     * @return     The price.
     */
    public float getPrice() {
        return this.price;
    }
    /**
     * Sets the price.
     * Time complexity of this method is O(1).
     * @param      p1    The p 1
     */
    public void setPrice(final float p1) {
        this.price = p1;
    }
    /**
     * {Method to compare two objects}.
     * Time complexity of this method is O(1).
     * @param      that  The that
     *
     * @return     {Integer}
     */
    public int compareTo(final Book that) {
        return this.getBookName().compareTo(that.getBookName());
    }
    /**
     * Returns a string representation of the object.
     * Time complexity of this method is O(1).
     * @return     String representation of the object.
     */
    public String toString() {
        return getBookName() + ", " + getAuthor() + ", " + getPrice();
    }
}
/**
 * Class for bst.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BST<Key extends Comparable<Key>, Value> {
    /**
     * {Root node}.
     */
    private Node root;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * {Key}.
         */
        private Key key;
        /**
         * {Value}.
         */
        private Value value;
        /**
         * {Left link}.
         */
        private Node left;
        /**
         * {Right link}.
         */
        private Node right;
        /**
         * {Size of BST}.
         */
        private int size;
        /**
         * Constructs the object.
         * Time complexity of this method is O(1).
         * @param      key1  The key1
         * @param      val1  The value1
         * @param      s     {Size of the BST}
         */
        Node(final Key key1, final Value val1,
            final int s) {
            this.key = key1;
            this.value = val1;
            this.left = null;
            this.right = null;
            this.size = s;
        }
    }
    /**
     * Constructs the object.
     * Time complexity of this method is O(1).
     */
    BST() {
        //Unused Constructor.
    }
    /**
     * {Method to get the size}.
     * Time complexity of this method is O(1).
     * @return     {Integer}
     */
    public int size() {
        return size(root);
    }
    /**
     * {Private method of size}.
     * Time complexity of this method is O(1).
     * @param      x     {Node}
     *
     * @return     {Integer}
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**
     * {Method to put a key into a tree}.
     * Time complexity of this method is O(1).
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        root = put(root, key, val);
    }
    /**
     * {Private method to put a key}.
     * Time complexity of this method is O(log(N)).
     * @param      x     {Node}
     * @param      key   The key
     * @param      val   The value
     *
     * @return     {Node}
     */
    private Node put(final Node x, final Key key, final Value val) {
        if (x == null) {
            return new Node(key, val, 1);
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
    /**
     * {Method to retreive a value from BST}.
     * Time complexity of this method is O(1).
     * @param      key   The key
     *
     * @return     {Value}
     */
    public Value get(final Key key) {
        return get(root, key);
    }
    /**
     * {Private method to retreive a value from BST}.
     * Time complexity of this method is O(log(N)).
     * @param      x     {Node}
     * @param      key   The key
     *
     * @return     {Value}
     */
    private Value get(final Node x, final Key key) {
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
    /**
     * {Method to get the minimum of the BST}.
     * Time complexity of this method is O(1).
     * @return     {Key}
     */
    public Key min() {
        return min(root).key;
    }
    /**
     * {Private method to get the minimum of the BST}.
     * Time complexity of this method is O(log(N)).
     * @param      x     {Node}
     *
     * @return     {Node}
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * {Method to get the maximum of the BST}.
     * Time complexity of this method is O(1).
     * @return     {Key}
     */
    public Key max() {
        return max(root).key;
    }
    /**
     * {Private method to get the maximum of the BST}.
     * Time complexity of this method is O(log(N)).
     * @param      x     {Node}
     *
     * @return     {Node}
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * {Method to get the floor for a particular key}.
     * Time complexity of this method is O(1).
     * @param      key   The key
     *
     * @return     {Key}
     */
    public Key floor(final Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * {Private method to get the floor for a particular key}.
     * Time complexity of this method is O(log(N)).
     * @param      x     {Node}
     * @param      key   The key
     *
     * @return     {Node}
     */
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
    /**
     * {Method to get the ceiling for a particular key}.
     * Time complexity of this method is O(1).
     * @param      key   The key
     *
     * @return     {Key}
     */
    public Key ceiling(final Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * {Private method to get the ceiling for a particular key}.
     * Time complexity of this method is O(log(N)).
     * @param      x     {Node}
     * @param      key   The key
     *
     * @return     {Node}
     */
    private Node ceiling(final Node x, final Key key) {
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
    /**
     * {Method to get the selected value}.
     * Time complexity of this method is O(1).
     * @param      k     {Integer}
     *
     * @return     {Key}
     */
    public Key select(final int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * {Private method to get the selected value}.
     * Time complexity of this method is O(log(N)).
     * @param      x     {Node}
     * @param      k     {Integer}
     *
     * @return     {Node}
     */
    private Node select(final Node x, final int k) {
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
    /**
     * {Method to delete the node}.
     * Time complexity of this method is O(1).
     * @param      key   The key
     */
    public void delete(final Key key) {
        root = delete(root, key);
    }
    /**
     * {Private method to delete the node}.
     * Time complexity of this method is O(log(N)).
     * @param      x     {Node}
     * @param      key   The key
     *
     * @return     {Node}
     */
    private Node delete(final Node x, final Key key) {
        Node x1 = x;
        if (x1 == null) {
            return null;
        }
        int cmp = key.compareTo(x1.key);
        if (cmp < 0) {
            x1.left = delete(x1.left, key);
        } else if (cmp > 0) {
            x1.right = delete(x1.right, key);
        } else {
            if (x1.right == null) {
                return x1.left;
            }
            if (x1.left == null) {
                return x1.right;
            }
            Node t = x1;
            x1 = min(t.right);
            x1.right = deleteMin(t.right);
            x1.left = t.left;
        }
        x1.size = size(x.left) + size(x.right) + 1;
        return x1;
    }
    /**
     * {Method to delete the node with minimum value}.
     * Time complexity of this method is O(1).
     */
    public void deleteMin() {
        root = deleteMin(root);
    }
    /**
     * {Private method to delete the node with minimum value}.
     * Time complexity of this method is O(log(N)).
     * @param      x     {Node}
     *
     * @return     {Node}
     */
    private Node deleteMin(final Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    /**
     * {Method to delete the node with maximum value}.
     * Time complexity of this method is O(1).
     */
    public void deleteMax() {
        root = deleteMax(root);
    }
    /**
     * {Private method to delete the node with maximum value}.
     * Time complexity of this method is O(log(N)).
     * @param      x     {Node}
     *
     * @return     {Node}
     */
    private Node deleteMax(final Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Unused Constructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
                case "delete":
                    books = new Book(tokens[1], tokens[2],
                        Float.parseFloat(tokens[2 + 1]));
                    b.delete(books);
                break;
                case "deleteMin":
                    b.deleteMin();
                break;
                case "deleteMax":
                    b.deleteMax();
                break;
                default:
                break;
            }
        }
    }
}
