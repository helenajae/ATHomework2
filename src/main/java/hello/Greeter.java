package hello;

public class Greeter {
    Counter counter = new Counter();

    public String sayHello(String name) {
        int length;
        try {
            length = counter.count(name);
        } catch (Exception x) {
            return "ups";
        }

        if (length == 1) {
            return "Wow that's a short name, " + name + ", welcome!";
        } else if (length > 1 && length < 20) {
            //return "Hello, " + name + ", welcome! Your name is " + length + " long";
            return String.format("Hello, %s, welcome! Your name is %d characters long", name, length);
        } else {
            return "Who are you?";
        }
    }
}