package day1;

/**
 * 输出内存信息
 *
 * Author yianmou
 */
public class HeapAlloc {
    public static void main(String[] args) {
        System.out.println("最大可用内存：" + Runtime.getRuntime().maxMemory()/1024/1024 + "M " + Runtime.getRuntime().maxMemory() + "k");
        System.out.println("当前空闲内存：" + Runtime.getRuntime().freeMemory()/1024/1024 + "M " + Runtime.getRuntime().freeMemory() + "k");
        System.out.println("当前总内存：" + Runtime.getRuntime().totalMemory()/1024/1024 + "M " + Runtime.getRuntime().totalMemory() + "k");

        System.out.println("--------------------------------------------");
        byte[] b = new byte[1*1024*1024];
        System.out.println("分配了1M空间");
        System.out.println("最大可用内存：" + Runtime.getRuntime().maxMemory()/1024/1024 + "M " + Runtime.getRuntime().maxMemory() + "k");
        System.out.println("当前空闲内存：" + Runtime.getRuntime().freeMemory()/1024/1024 + "M " + Runtime.getRuntime().freeMemory() + "k");
        System.out.println("当前总内存：" + Runtime.getRuntime().totalMemory()/1024/1024 + "M " + Runtime.getRuntime().totalMemory() + "k");

        System.out.println("--------------------------------------------");
        b = new byte[6*1024*1024];
        System.out.println("分配了6M空间");
        System.out.println("最大可用内存：" + Runtime.getRuntime().maxMemory()/1024/1024 + "M " + Runtime.getRuntime().maxMemory() + "k");
        System.out.println("当前空闲内存：" + Runtime.getRuntime().freeMemory()/1024/1024 + "M " + Runtime.getRuntime().freeMemory() + "k");
        System.out.println("当前总内存：" + Runtime.getRuntime().totalMemory()/1024/1024 + "M " + Runtime.getRuntime().totalMemory() + "k");

    }
}
