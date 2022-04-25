package day1;

/**
 * 增加局部变量表对栈空间占用的验证
 * 设置最大栈内存为-Xss160K，造成StackOverflowError异常
 * 设置最大栈内存为-Xss256K，造成StackOverflowError异常
 */
public class StackOverflow2Test {
    private static int count=0;

    public static void main(String[] args) {
        try {
            while (true) {
                count(1L, 2L, 3L, 4L, 5L);
            }
        } catch (Throwable e) {
            System.out.println("count = " + count);
            throw e;
        }
    }

    private static void count(long arg1, long arg2, long arg3, long arg4, long arg5) {
        long num1 = 1;
        long num2 = 2;
        long num3 = 3;
        long num4 = 4;
        long num5 = 5;
        long num6 = 6;
        long num7 = 7;
        long num8 = 8;
        count++;
        count(arg1, arg2, arg3, arg4, arg5);
    }
}


