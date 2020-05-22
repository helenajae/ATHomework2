package hello;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello! It's beautiful day to test this code :)" );
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello("Maria"));
    }
}