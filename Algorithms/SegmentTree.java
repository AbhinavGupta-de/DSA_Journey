import java.util.*;

public class SegmentTree {

    ArrayList<Integer> tree;
    int identityElement;
    int N;

    int merge(int a, int b) {
        return Math.min(a, b);
    }

    public SegmentTree(int n, int identityElement) {
        this.identityElement = identityElement;
        N = n;
        tree = new ArrayList<>(Collections.nCopies(4 * N, identityElement));
    }

    public void update(int index, int val) {
        update(0, 0, N - 1, index, val);
    }

    private void update(int tIndex, int tL, int tR, int uIndex, int val) {

        if (tL == tR) {
            tree.set(tIndex, val);
            return;
        }

        int tM = (tL + tR) / 2;

        if (uIndex <= tM) {
            update(2 * tIndex + 1, tL, tM, uIndex, val);
        } else {
            update(2 * tIndex + 2, tM + 1, tR, uIndex, val);
        }

        tree.set(tIndex, merge(tree.get(2 * tIndex + 1), tree.get(2 * tIndex + 2)));

    }

    public int query(int l, int r) {
        return query(0, 0, N - 1, l, r);
    }

    private int query(int tIndex, int tL, int tR, int qL, int qR) {

        if (qL > tR || qR < tL) {
            return identityElement;
        }

        if (qL <= tL && qR >= tR) {
            return tree.get(tIndex);
        }

        int tM = (tL + tR) / 2;

        return merge(query(2 * tIndex + 1, tL, tM, qL, qR), query(2 * tIndex + 2, tM + 1, tR, qL, qR));
    }

    public static void main(String[] args) {
        SegmentTree st = new SegmentTree(10, Integer.MAX_VALUE);
        st.update(0, 1);
        st.update(1, 2);
        st.update(2, 3);
        st.update(3, 4);
        st.update(4, 5);
        st.update(5, 6);
        st.update(6, 7);
        st.update(7, 8);
        st.update(8, 9);
        st.update(9, 10);

        System.out.println(st.query(0, 9)); // Should print 1
        System.out.println(st.query(1, 4)); // Should print 2
        System.out.println(st.query(5, 7)); // Should print 6
    }
}
