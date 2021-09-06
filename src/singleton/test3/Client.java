package singleton.test3;

public class Client {
    public static void main(String[] args) {
        showCase0();
        showCase1();
        showCase2();
    }

    private static void showCase0() {
        System.out.println(SimpleSingleton.getStatic());
        System.out.println("----------------------------");
    }


    private static void showCase1() {
        for (int i = 0; i < 100 ; i++) {
            SimpleSingleton simpleSingleton = SimpleSingleton.getInstance();
            simpleSingleton.printName();
        }

        System.out.println("----------------------------");
    }

    private static void showCase2() {
        SimpleSingleton simpleSingleton1 = SimpleSingleton.getInstance();
        SimpleSingleton simpleSingleton2 = SimpleSingleton.getInstance();
        System.out.println(simpleSingleton1 == simpleSingleton2);
        System.out.println(simpleSingleton1.equals(simpleSingleton2));
        System.out.println(simpleSingleton1.hashCode()  == simpleSingleton2.hashCode());
    }


}
