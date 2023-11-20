package TaskTwo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TaskTwo {
    public static boolean saveClassTextContainer(Class<?> ... classes){
        try{
            for(Class<?> cl : classes){
                if(cl.isAnnotationPresent(SaveTo.class)){
                    String path = cl.getAnnotation(SaveTo.class).path();

                    Method[] methods = cl.getDeclaredMethods();
                    for(Method method : methods){
                        if(method.isAnnotationPresent(Saver.class)){

                            Object instance = cl.getDeclaredConstructor().newInstance();
                            method.invoke(instance, path);
                            return true;

                        }
                    }
                }
            }
        }catch (NoSuchMethodException  | IllegalAccessException | InvocationTargetException | InstantiationException e){
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[]  args ){
        System.out.println(saveClassTextContainer(TextContainer.class));
    }
}
