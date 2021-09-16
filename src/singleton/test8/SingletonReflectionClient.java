package singleton.test8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * private constructor does not prevent client
 * from creating a new object.
 */
public class SingletonReflectionClient {
    public static void main(String[] args) {
        SimpleSingleton simpleSingleton = null;
        for(int i = 0; i <10; i++) {
            simpleSingleton = SimpleSingleton.getInstance();
            simpleSingleton.printName();
        }


        Class<SimpleSingleton> singletonClass = SimpleSingleton.class;
        Constructor<SimpleSingleton> defaultConstructor = null;
        try {
            defaultConstructor = singletonClass.getDeclaredConstructor(null);
        } catch (NoSuchMethodException e) {
            System.out.println("Problem with security: " + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            System.out.println("Problem with calling method: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Name: " + defaultConstructor.getName());
        System.out.println("Modifier: " + defaultConstructor.getModifiers());
        System.out.println("is accessible: " + defaultConstructor.isAccessible());
        defaultConstructor.setAccessible(true);
        System.out.println("is accessible: " + defaultConstructor.isAccessible());

        System.out.println();
        System.out.println("Creating new singleton objects");

        SimpleSingleton newSimpleSingleton = null;


        try {
            for(int i = 0; i <10; i++) {
                newSimpleSingleton = defaultConstructor.newInstance(null);
                newSimpleSingleton.printName();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
