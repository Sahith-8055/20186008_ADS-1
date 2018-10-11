import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * {Name of book}.
     */
    private String name;
    /**
     * {Author name}.
     */
    private String author;
    /**
     * {Price of the book}.
     */
    private float price;
    /**
     * Constructs the object.
     * Time complexity of this method is O(1).
     * @param      name1    The name1
     * @param      author1  The author1
     * @param      p        {Price of the book}
     */
    Book(final String name1, final String author1, final float p) {
        this.name = name1;
        this.author = author1;
        this.price = p;
    }
    /**
     * Gets the name.
     * Time complexity of this method is O(1).
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Sets the name.
     * Time complexity of this method is O(1).
     * @param      n     {String Name}
     */
    public void setName(final String n) {
        this.name = n;
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
     * @param      a     {Name of the author}
     */
    public void setAuthor(final String a) {
        this.author = a;
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
     * @param      p     {Price of the book}
     */
    public void setPrice(final int p) {
        this.price = p;
    }
    /**
     * {Compare two objects}.
     * Time complexity of this method is O(1).
     * @param      that  The that
     *
     * @return     {Integer}
     */
    public int compareTo(final Book that) {
        return this.getName().compareTo(that.getName());
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
     * {Node root}.
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
        private Value val;
        /**
         * {Left link}.
         */
        private Node left;
        /**
         * {Right link}.
         */
        private Node right;
        /**
         * Constructs the object.
         * Time complexity of this method is O(1).
         * @param      key1   The key1
         * @param      val1   The value1
         */
        Node(final Key key1, final Value val1) {
            this.key = key1;
            this.val = val1;
            //this.size = size;
        }
    }
    /**
     * Initializes an empty symbol table.
     */
    BST() {
        //Unused Constructor.
    }
    /**
     * Returns the value associated with the given key.
     * Time complexity of this method is O(1).
     * @param  key the key
     * @return the value associated with the given key
     * if the key is in the symbol table
     * and {@code null} if the key is not in the symbol table
     */
    public Value get(final Key key) {
        return get(root, key);
    }
    /**
     * {Private method to get the value}.
     * Time complexity of this method is O(log(N)).
     * @param      x     {Node}
     * @param      key   The key
     *
     * @return     {Value}
     */
    private Value get(final Node x, final Key key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "calls get() with a null key");
        }
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }
    /**
     * Inserts the specified key-value pair into the symbol table,
     * overwriting the old
     * value with the new value if the symbol table
     * already contains the specified key.
     * Deletes the specified key (and its associated value)
     * from this symbol table
     * if the specified value is {@code null}.
     * Time complexity of this method is O(1).
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException(
                "calls put() with a null key");
        }
        root = put(root, key, val);
    }
    /**
     * {Private method to put the value}
     * Time complexity of this method is O(N).
     * @param      x     {Node}
     * @param      key   The key
     * @param      val   The value
     *
     * @return     {Node}
     */
    private Node put(final Node x,
        final Key key, final Value val) {
        if (x == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left  = put(x.left,  key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
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
     * {Main method}.
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
            default:
                break;
            }
        }
    }
}
