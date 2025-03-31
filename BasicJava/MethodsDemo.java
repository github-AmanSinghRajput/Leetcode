package BasicJava;

public class MethodsDemo {
    // 🔹 A method that prints a message
    public static  void greetUser(){
        System.out.println("Hello I am ASR! You're leveling up your coding skills!");
    }
    // 🔹 A method that adds two numbers and returns the result
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        greetUser(); // Call the greet method

        int sum = add(5,7); // Call add method with 5 and 7
        System.out.println("Sum is: " +sum);

    }
}
