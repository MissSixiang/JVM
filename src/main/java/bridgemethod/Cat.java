package bridgemethod;

/**
 * @description 类型擦除
 * @author: yianmou
 **/
public class Cat implements Animal<String> {
    @Override
    public void eat(String s) {
        System.out.println("cat eat " + s);
    }
}


