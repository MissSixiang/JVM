package bridgemethod;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @description
 * @author: yianmou
 **/
public class MethodFactory {
    public static void main(String[] args) {
        // 我們看一下，Cat里有多少方法
        Method[] methods = Cat.class.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.println(name + "(" + Arrays.toString(parameterTypes) + ")");
        }
    }
}
