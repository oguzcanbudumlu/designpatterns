package singleton.test11;


/**
 * best solution
 * with enumeration
 * it is not allowed to do serialization and reflection on enumeration objects in java jvm and c# clr
 */
public class Client {

    public static void main(String[] args) {
        EnumSingleton instance1 = EnumSingleton.SINGLETON;
        EnumSingleton instance2 = EnumSingleton.getInstance();

        if(instance1 == instance2) {
            System.out.println("same");
        } else {
            System.out.println("different");
        }
    }
}
