package TaskThree;

import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args){
        Person clear1 = new Person("", "", -999);
        Person clear2 = new Person("", "", -999);
        Person testOne = new Person("Fake", "User", 19);
        System.out.println(SaveUtil.objectToString(testOne));

        SaveUtil.annotatedFieldsToSVCFromObject("/Users/malchikmac/Desktop/folder/Homework Prog_Academy_Java_Pro/homework2/src/TaskThree/Test1.txt",
                testOne);






        SaveUtil.objectFromSVC("/Users/malchikmac/Desktop/folder/Homework Prog_Academy_Java_Pro/homework2/src/TaskThree/inputTest.txt",
                clear1);
        System.out.println(clear1);

        SaveUtil.objectFromSVC("/Users/malchikmac/Desktop/folder/Homework Prog_Academy_Java_Pro/homework2/src/TaskThree/inputTest2.txt",
                clear2);
        System.out.println(clear2);
    }
}
