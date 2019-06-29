public class Experimental {
    public static void main(String[] args) {
        fun_1(1, 2, 6);
        fun_2(2, 2, 2);
    }

    public static void fun_1(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0)
            System.out.println("yes it is 0, 0, 0");
        else
            System.out.println("oh no!");
    }

    public static void fun_2(int a, int b, int c) {
        if (a == 1 && b == 1 && c == 1)
            System.out.println("yes it is 1, 1, 1");
        else
            System.out.println("oh no!");
    }
}
