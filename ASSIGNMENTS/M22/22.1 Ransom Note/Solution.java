import java.util.Scanner;
/**
 * Class for sequential search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SequentialSearchST<Key, Value> {
    /**
     * { var_description }.
     */
    private int n;
    /**
     * { var_description }.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * { var_description }.
         */
        private Key key;
        /**
         * { var_description }.
         */
        private Value val;
        /**
         * { var_description }.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      key1   The key
         * @param      val1   The value
         * @param      next1  The next
         */
        Node(final Key key1, final Value val1, final Node next1)  {
            this.key  = key1;
            this.val  = val1;
            this.next = next1;
        }
    }
    /**
     * Initializes an empty symbol table.
     */
    SequentialSearchST() {
    }
    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }
    /**
     *
     * Is this symbol table empty?
     * @return {@code true} if this symbol table is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * Does this symbol table contain the given key?
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *     {@code false} otherwise
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * Returns the value associated with the given key.
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table
     */
    public Value get(final Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }
    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table.
     * If the value is {@code null}, this effectively deletes the key from the symbol table.
     * @param key the key
     * @param val the value
     */
    public void put(final Key key, final Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }
    /**
     * Removes the key and associated value from the symbol table
     * (if the key is in the symbol table).
     * @param key the key
     */
    public void delete(final Key key) {
        first = delete(first, key);
    }
    /**
     * delete key in linked list beginning at Node x.
     * warning: function call stack too large if table is large.
     *
     * @param      x     {Node}.
     * @param      key   The key
     *
     * @return     {Node}
     */
    private Node delete(final Node x, final Key key) {
        if (x == null) {
            return null;
        }
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
    /**
     * {Method to get all the keys}.
     *
     * @return     {Iterable}
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }
}
/**
 * Class for separate chaining hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class SeparateChainingHashST<Key, Value> {
    /**
     * { var_description }.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * { var_description }.
     */
    private int n;
    /**
     * { var_description }.
     */
    private int m;
    /**
     * { var_description }.
     */
    private SequentialSearchST<Key, Value>[] st;
    /**
     * Initializes an empty symbol table.
     */
    SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }
    /**
     * Initializes an empty symbol table with {@code m} chains.
     * @param m the initial number of chains
     */
    SeparateChainingHashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }
    /**
     * resize the hash table to have the given number of chains,
     * rehashing all of the keys.
     *
     * @param      chains  The chains
     */
    private void resize(final int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }
    /**
     * hash value between 0 and m-1.
     *
     * @param      key   The key
     *
     * @return     {Integer}
     */
    private int hash(final Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }
    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     * {@code null} if no such value
     */
    public Value get(final Key key) {
        int i = hash(key);
        return st[i].get(key);
    }
    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     */
    public void put(final Key key, final Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= 10 * m) {
            resize(2 * m);
        }
        int i = hash(key);
        if (!st[i].contains(key)) {
            n++;
        }
        st[i].put(key, val);
    }
    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param  key the key
     */
    public void delete(final Key key) {
        int i = hash(key);
        if (st[i].contains(key)) {
            n--;
        }
        st[i].delete(key);
        if (m > INIT_CAPACITY && n <= 2 * m) {
            resize(m / 2);
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    public Solution() {
        // Unused constructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        SeparateChainingHashST<String, Integer> chaining;
        chaining = new SeparateChainingHashST<String, Integer>();
        String tokens = scan.nextLine();
        String[] magazine = scan.nextLine().split(" ");
        for (int i = 0; i < magazine.length; i++) {
            if (chaining.contains(magazine[i])) {
                chaining.put(magazine[i], chaining.get(magazine[i]) + 1);
            } else {
                chaining.put(magazine[i], 1);
            }
        }
        String[] tobeSearched = scan.nextLine().split(" ");
        for (int i = 0; i < tobeSearched.length; i++) {
            if (chaining.contains(tobeSearched[i]) ) {
                if (chaining.get(tobeSearched[i]) == 0) {
                    System.out.print("No");
                    return;
                } else {
                    chaining.put(tobeSearched[i], chaining.get(tobeSearched[i]) - 1);
                }
            } else {
                System.out.print("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
