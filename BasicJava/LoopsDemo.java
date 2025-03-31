package BasicJava;

public class LoopsDemo {
    public static void main(String[] args) {
        // 🔁 FOR LOOP – Perfect when you know how many times to loop
        System.out.println("Counting 1 to 5 using for loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
        // 🔁 WHILE LOOP – Use when you don’t know how many times you'll loop
        System.out.println("\nCounting 5 to 1 using while loop:");
        int j = 5;
        while( j >= 1){
            System.out.println("j = " + j);
            j--;
        }

        // 🔁 DO-WHILE LOOP – Runs at least once even if condition is false
        System.out.println("\nRunning do-while at least once:");
        int k = 0;
        do {
            System.out.println("K = "+k);
            k++;
        }while(k<=5);
    }
}
