package singleton.test11;

import java.lang.reflect.Constructor;

public class ReflectionAndSerializableClient {
    public static void main(String[] args) {
        checkReflection();
    }

    public static void checkReflection() {
        Class<EnumSingleton> singletonClass = EnumSingleton.class;
        Constructor<EnumSingleton> defaultConstructor = null;
        try {
            defaultConstructor = singletonClass.getDeclaredConstructor(null);
            System.out.println("Default construtor " + defaultConstructor);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }
}
