package TaskOne;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TaskOne {


    private static void runAnnotatedMethods(Class<?> ... classes) {
        try {
            for (Class<?> cl : classes){
                Method[] methods = cl.getDeclaredMethods();
                for (Method method : methods) {
                    Object instance = cl.getDeclaredConstructor().newInstance();
                    if (method.isAnnotationPresent(ValuesAnnotation.class)) {
                        System.out.println("Running method: " + method.getName());
                        ValuesAnnotation an =  method.getAnnotation(ValuesAnnotation.class);
                        System.out.println(method.invoke(instance, an.a(), an.b() ));

                        System.out.println();
                    }
                }
            }

        }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e){
            System.out.println(e);
        }

    }

    public static void main(String[] args){

        runAnnotatedMethods(ClassTestOne.class, ClassTestTwo.class);


    }
}
