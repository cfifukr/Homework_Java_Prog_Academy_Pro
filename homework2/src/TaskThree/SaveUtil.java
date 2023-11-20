package TaskThree;


import java.io.*;
import java.lang.reflect.Field;
import java.util.NoSuchElementException;
import java.util.Scanner;

class SaveUtil {

    public static String objectToString(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder result = new StringBuilder();


        for (Field field : fields) {

            if(field.isAnnotationPresent(Save.class)) {
                field.setAccessible(true);
                Object fieldValue;

                try {
                    fieldValue = field.get(obj);
                } catch (IllegalAccessException e) {
                    fieldValue = "N/A";
                }

                result.append(fieldValue).append(", ");
            }

        }
        if (result.length() > 1) {
            result.setLength(result.length() - 2);
        }


        return result.toString();

    }


    public static Object objectFromString(String line, Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");


        for (Field field : fields) {

            if (field.isAnnotationPresent(Save.class)) {
                try {
                    field.setAccessible(true);
                    field.set(obj, scanner.next());
                } catch (IllegalAccessException | NoSuchElementException e) {
                }

            }
        }
        return obj;




    }
    public static void annotatedFieldsToSVCFromObject(String path, Object obj){
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(new File(path)));
            bf.write(objectToString(obj));
            bf.close();
        }catch(IOException e){
            System.out.println("Mistake - " + e  );
        }
    }

    public static Object objectFromSVC(String path, Object obj){
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line = br.readLine();
            br.close();
            return objectFromString(line, obj);

        }catch(IOException e){
            System.out.println("Mistake - " + e  );
            return null;
        }

    }

}