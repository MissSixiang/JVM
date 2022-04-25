package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用Demo
 * 虚引用必须和引用队列一起使用
 *
 * @author: yianmou
 **/
public class PhantomReferenceDemo {
    private static PhantomReferenceDemo obj;

    public static void main(String[] args) {
        /** 创建引用队列 */
        ReferenceQueue<PhantomReferenceDemo> phantomRefQueue = new ReferenceQueue<>();

        /** 创建虚引用 */
        obj = new PhantomReferenceDemo();
        PhantomReference<PhantomReferenceDemo> phantomReference = new PhantomReference<>(obj, phantomRefQueue);
        System.out.println("phantomReference = " + phantomReference.get()); // 总会返回null

        /** 创建后台线程 */
        Thread thread = new CheckRefQueueThread(phantomRefQueue);
        thread.setDaemon(true);
        thread.start();

        /** 执行两次GC，一次被finalize复活，一次真正被回收 */
        for (int i = 1; i <=2 ; i++) {
            gc(i);
        }
    }

    private static void gc(int nums) {
        obj = null;
        System.gc();
        System.out.println("---------第" + nums + "次GC----------");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (obj == null) {
            System.out.println("obj is null");
        } else {
            System.out.println("obj is not null");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize() is called!");
        obj = this; // 复活对象
    }
}

/**
 * 从引用队列中获得被回收的对象
 */
class CheckRefQueueThread extends Thread {
    private ReferenceQueue<PhantomReferenceDemo> phantomRefQueue;

    public CheckRefQueueThread(ReferenceQueue<PhantomReferenceDemo> phantomRefQueue ) {
        this.phantomRefQueue = phantomRefQueue;
    }

    @Override
    public void run() {
        while (true) {
            if (phantomRefQueue != null) {
                PhantomReference<PhantomReferenceDemo> phantomReference = null;
                try {
                    /**
                     * 当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会在回收对象后，将这个虚引用加入到引用队列，以通知应用程序对象
                     * 的回收情况
                     */
                    phantomReference = (PhantomReference<PhantomReferenceDemo>) phantomRefQueue.remove();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                if (phantomReference != null) {
                    System.out.println("Object is delete by GC");
                }
            }
        }
    }
}



