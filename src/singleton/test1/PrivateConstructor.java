package singleton.test1;

public class PrivateConstructor {

    static {
        new PrivateConstructor();
    }

    private PrivateConstructor() {
        System.out.println("private constructor");
    }

    public static void testStaticMethod() {
        System.out.println("testStaticMethod");
    }
}
