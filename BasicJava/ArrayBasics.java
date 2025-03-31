package BasicJava;

public class ArrayBasics {
    public static void main(String[] args) {
        // 🔹 Declare and Initialize an Array
        int[] scores = {90, 85, 100, 67, 88};

        // 🔹 Access Elements
        System.out.println("First score: " + scores[0]);
        System.out.println("Last score: " + scores[scores.length - 1]);

        // 🔹 Loop through the array using FOR loop
        System.out.println("\nAll Scores (using for loop):");
        for(int i=0; i<scores.length; i++){
            System.out.println("Index "+ i + " : "+ scores[i]);
        }
        // 🔹 Loop through using ENHANCED for-each loop
        System.out.println("\nAll Scores (using for-each loop):");
        for(int score: scores){
            System.out.println(score);
        }

        // 🔹 Change a value in array
        scores[2] = 99;
        System.out.println("\nUpdated score at index 2: " + scores[2]);
    }

}
