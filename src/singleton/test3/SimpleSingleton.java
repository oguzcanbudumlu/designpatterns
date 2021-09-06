package singleton.test3;

public class SimpleSingleton {
    private static SimpleSingleton simpleSingleton = new SimpleSingleton();

    private static int count = 0;
    private String name;

    private SimpleSingleton() {
        count++;
        name = "SimpleSingleton" + count;
    }

    public static SimpleSingleton getInstance() {
        return simpleSingleton;
    }

    public void printName() {
        System.out.println(this.name);
    }


    public static SimpleSingleton getStatic() {
        return simpleSingleton;
    }

    @Override
    public String toString() {
        return name;
    }
}
