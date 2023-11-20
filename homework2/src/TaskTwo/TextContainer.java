package TaskTwo;


import java.io.*;

@SaveTo(path = "/Users/malchikmac/Desktop/folder/Homework Prog_Academy_Java_Pro/homework2/src/TaskTwo/test1.txt")
public class TextContainer {

    private String text = "Hello World";

    public TextContainer() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Saver
    public void saveToTXT(String path){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)));
            bufferedWriter.write(text);
            bufferedWriter.close();
            System.out.println("Saving successfull");


        }catch (IOException e){
            System.out.println("Saving failed");
        }
    }
}
