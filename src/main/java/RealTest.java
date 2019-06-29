import org.junit.Test;

public class RealTest {

    @Test
    public void test_experimental() {
        int[] a, b, c;
        a = new int[5];
        b = new int[5];
        c = new int[5];

        for(int i = 0; i < 5; i++) {
            a[i] = i;
            b[i] = i;
            c[i] = i;
        }

        for(int i = 0; i < 5; i++) {
            Experimental.fun_1(a[i], b[i], c[i]);
        }
    }
}