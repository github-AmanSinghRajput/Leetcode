package BasicJava;

public class ConditionsDemo {
    public static void main(String[] args) {
        int age = 20;
        // 👇 IF-ELSE BLOCK
        if (age < 13) {
            System.out.println("You're a kid.");
        } else if (age < 20) {
            System.out.println("You're a teenager.");
        } else if (age < 60) {
            System.out.println("You're an adult.");
        } else {
            System.out.println("You're a senior citizen.");
        }

        // 👇 SWITCH CASE BLOCK
        int day = 3;
        switch (day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend!");
        }

    }
}
