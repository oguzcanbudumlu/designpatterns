package singleton.test4;

import singleton.test3.SimpleSingleton;

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
