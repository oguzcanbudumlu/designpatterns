package singleton.test4;

public class Client {
    public static void main(String[] args) {
        showCase0();
        showCase1();
        showCase2();

    }

    private static void showCase0() {
        System.out.println(LazyLoading.getStatic());
        System.out.println("--------------------");
    }


    private static void showCase1() {
        for (int i = 0; i < 100 ; i++) {
            LazyLoading lazyLoading = LazyLoading.getInstance();
            lazyLoading.printName();
        }

        System.out.println("----------------------------");
    }

    private static void showCase2() {
        LazyLoading lazyLoading1 = LazyLoading.getInstance();
        LazyLoading lazyLoading2 = LazyLoading.getInstance();
        System.out.println(lazyLoading1 == lazyLoading2);
        System.out.println(lazyLoading1.equals(lazyLoading2));
        System.out.println(lazyLoading1.hashCode()  == lazyLoading2.hashCode());
    }


}
