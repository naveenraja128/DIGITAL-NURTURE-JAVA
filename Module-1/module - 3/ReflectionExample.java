import java.lang.reflect.Method;

class Student {

    public void display() {
        System.out.println("Hello from Student Class");
    }
}

public class ReflectionExample {

    public static void main(String[] args) throws Exception {

        Class<?> cls = Class.forName("Student");

        System.out.println("Methods in Student class:");

        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());

            for (Class<?> param : method.getParameterTypes()) {
                System.out.println("Parameter: " + param.getName());
            }
        }

        Object obj = cls.getDeclaredConstructor().newInstance();

        Method m = cls.getDeclaredMethod("display");

        m.invoke(obj);
    }
}