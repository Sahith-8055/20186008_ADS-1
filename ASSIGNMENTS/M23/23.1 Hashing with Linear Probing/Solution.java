import java.util.Scanner;
class LinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;
    private int n;
    private int m;
    private Key[] keys;
    private Value[] vals;
    LinearProbingHashST() {
        this(INIT_CAPACITY);
    }
    LinearProbingHashST(final int capacity) {
        this.m = capacity;
        this.n = 0;
        this.keys = (Key[]) new Object[m];
        this.vals = (Value[]) new Object[m];
    }
    public int hashCode() {
        int hash = 0;
        int h = hash;
        if (h != 0) {
            return h;
        }
        for (int i = 0; i < keys.length; i++) {
            h = ((11 * (int)keys[i]) % m);
        }
        hash = h;
        return h;
    }
    private void resize(final int capacity) {
        LinearProbingHashST<Key, Value> temp;
        temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }
    public int size() {
        return n;
    }
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= m / 2) {
            resize(2 * m);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    Value get(Key k) {
        for (int i = hash(k); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(k)) {
                return vals[i];
            }
        }
        return null;
    }
    boolean contains(Key key) {
        return get(key) != null;
    }
    void delete(Key key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
    }
    void display() {
        String str = "{";
        int i;
        for (i = 0; i < keys.length - 1; i++) {
            if (keys[i] != null) {
                str += keys[i] + ":" + vals[i] + ", ";
            }
            str += keys[i] + ":" + vals[i];
        }
        str += "}";
        System.out.println(str);
    }
}
public class Solution {
    public Solution() {
        // Constructor.
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        LinearProbingHashST<String, Integer> hash;
        int n = scan.nextInt();
        hash = new LinearProbingHashST<String, Integer>(n);
        while (n > 0) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "put":
                hash.put(tokens[1], Integer.parseInt(tokens[2]));
                break;
            case "get":
                hash.get(tokens[1]);
                break;
            case "delete":
                hash.delete(tokens[1]);
                break;
            case "display":
                hash.display();
                break;
            default:
                break;
            }
            n--;
        }
    }
}