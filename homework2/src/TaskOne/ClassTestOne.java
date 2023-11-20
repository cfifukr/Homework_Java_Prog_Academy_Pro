package TaskOne;

public class ClassTestOne {

    public ClassTestOne() {
    }

    @ValuesAnnotation(a = 17, b = 5)
    public int mod(int c, int d){

        return c % d;

    }

    public String helloWorld(){
        return "Hello World";
    }

    @ValuesAnnotation(a = 10, b = 5)
    public int multi(int c, int d){

        return c * d;

    }
}
