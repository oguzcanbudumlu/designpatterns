package singleton.test4;

/**
 * it causes issues in multithreaded environments
 * because the fact that multiple threads check for null
 * can cause to create more than one singleton object.
 * In other words, we make matters worse while trying to
 * be helpful.
 */
public class LazyLoading {
    private static LazyLoading lazyLoading;

    private static int count = 0;
    private String name;

    private LazyLoading() {
        count++;
        name = "SimpleSingleton" + count;
    }

    public static LazyLoading getInstance() {
        if(lazyLoading == null) {
            System.out.println("lazyLoading is null and it will be created");
            lazyLoading = new LazyLoading();
        }
        return lazyLoading;
    }

    public void printName() {
        System.out.println(this.name);
    }

    public static LazyLoading getStatic() {
        return lazyLoading;
    }

    @Override
    public String toString() {
        return name;
    }
}
