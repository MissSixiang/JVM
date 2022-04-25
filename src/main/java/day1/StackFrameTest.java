package day1;

/**
 * 测试栈帧
 *
 * Author yianmou
 */
public class StackFrameTest {
    public static void main(String[] args) {
        StackFrameTest stackFrameTest = new StackFrameTest();
        stackFrameTest.method1(1);
    }
    public void method1(int i) {
        int num1 = 2;
        System.out.println("method1 i=" + i);
        method2(i, num1);
    }
    public void method2(int i, int j) {
        int num2 = 3;
        System.out.println("method2 i=" + i + ",j=" + j);
        method3(i, j, num2);
    }
    public void method3(int i, int j, int x) {
        int num3 = 4;
        System.out.println("method3 i=" + i + ",j=" + j + ",x=" + x);
        method4(i, j, x, num3);
    }
    public void method4(int i, int j, int x, int y) {
        System.out.println("method4 i=" + i + ",j=" + j + ",x=" + x + ",y=" + y);
    }
}
