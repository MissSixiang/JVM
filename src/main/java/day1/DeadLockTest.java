package day1;

/**
 * 线程死锁
 * <p>
 * Author yianmou
 */
public class DeadLockTest {

    private static final String ACTION_ONE = "拿起碗";
    private static final String ACTION_TWO = "拿起筷子";

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized(ACTION_ONE) {
                try {
                    Thread.sleep(1000);
                    synchronized(ACTION_TWO) {
                        System.out.println("小明开始吃饭");
                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized(ACTION_TWO) {
                try {
                    Thread.sleep(1000);
                    synchronized(ACTION_ONE) {
                        System.out.println("小丽开始吃饭");
                    }

                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
