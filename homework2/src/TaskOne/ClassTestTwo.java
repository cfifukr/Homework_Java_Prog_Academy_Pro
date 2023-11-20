package TaskOne;

public class ClassTestTwo {
    public ClassTestTwo() {
    }

    public void helloWorld(){
        System.out.println("Hello World; Class - TestTwo");
    }

    @ValuesAnnotation(a = 10, b = 5)
    public int sum(int c, int d){

        return  c + d;
    }

    @ValuesAnnotation(a = 1557, b = 25)
    public int dividing(int c, int d){

        return  c / d;
    }


}
