package day1;

/**
 * 死去活来的对象
 * <p>
 * Author yianmou
 */
public class DieAliveObject {
    private static DieAliveObject dieAliveObject;

    public static void main(String[] args) {
        dieAliveObject = new DieAliveObject();

        for (int i = 0; i <= 1; i++) {
            System.out.println(String.format("----------GC nums=%d----------", i));
            dieAliveObject = null; // 将dieAliveObject对象置为"垃圾对象"
            System.gc(); // 通知JVM可以执行GC了
            try {
                Thread.sleep(100); // 等待GC执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (dieAliveObject == null) {
                System.out.println("dieAliveObject is null");
            } else {
                System.out.println("dieAliveObject is not null");
            }
        }
    }

    /**
     * finalize只会被调用一次，给对象唯一一次重生的机会
     */
    @Override
    protected void finalize() {
        System.out.println("finalize is called！");
        dieAliveObject = this; // 使对象复生，添加引用
    }
}

