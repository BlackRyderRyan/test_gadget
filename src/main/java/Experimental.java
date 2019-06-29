public class Experimental {
    public static void main(String[] args) {
        fun_1(1, 2, 6);
        fun_2(2, 2, 2);
    }

    public static int[] fun_1(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0)
            System.out.println("yes it is 0, 0, 0");
        else
            System.out.println("oh no!");

        int[] value = new int[3];
        value[0] = a;
        value[1] = b;
        value[2] = c;
        return value;
    }

    public static int fun_2(int a, int b, int c) {
        if (a == 1 && b == 1 && c == 1)
            System.out.println("yes it is 1, 1, 1");
        else
            System.out.println("oh no!");

        return a * b * c;
    }
}
