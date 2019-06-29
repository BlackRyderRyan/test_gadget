import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ExperimentalTest {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Experimental");

        Object obj = cls.newInstance();

        Method[] methods = cls.getDeclaredMethods();


        for (Method method : methods) {
            if (method.getName() == "fun_1") {
                Method currentMethod = cls.getMethod(method.getName(), int.class, int.class, int.class);

                System.out.println(int.class);

                Parameter[] parameters = currentMethod.getParameters();

                for (final Parameter parameter : parameters) {
                    if (parameter.isNamePresent()) {
                        System.out.print(parameter.getName() + ' ');
                    }
                }

                System.out.println("参数列表: " + currentMethod.getParameterTypes());

                currentMethod.invoke(obj, 0, 0, 0);
            }
        }

//        System.out.println(methods[1].getName());
//
//        System.out.println(methods[1].getParameterTypes());



//        Method addMethod = cls.getMethod("fun_1", int.class, int.class, int.class);
    }
}
