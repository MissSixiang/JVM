package day1;

/**
 * 设置最大栈内存为-Xss160K，造成StackOverflowError异常
 * 设置最大栈内存为-Xss256K，造成StackOverflowError异常
 */
public class StackOverflowTest {
    // 为了记录方法调用层级数的
    private static int count=0;

    public static void main(String[] args) {
        try {
            while (true) {
                count();
            }
        } catch (Throwable e) {
            System.out.println("count = " + count);
            throw e;
        }
    }

    private static void count() {
        count++;
        count();
    }
}


