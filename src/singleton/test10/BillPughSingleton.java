package singleton.test10;

public class BillPughSingleton {
    private static int count;
    private String name;

    private BillPughSingleton() {
        name = "BillPughSingleton" + count;
        count++;
    }

    public String getName() {
        return name;
    }


    /**
     * Since JVM has stingy structure (like lazy-loading),
     * it does not load classes unless necessary.
     * SingletonHelper is loaded when the first call is done.
     *
     * This class provides thread-safe environment by nature.
     */
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public void printName() {
        System.out.println(name);
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }


}
