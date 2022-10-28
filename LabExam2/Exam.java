
import java.util.Scanner;

public class Exam {

    ///// Write your Method Here /////
    public static void reverseProuctType(LinkedQueue<Character> reversedQ) {
        if (reversedQ.isEmpty())
            System.out.println("your Queue is Empty !");
        else {
            int numberOfLetters = 0;
            for (int i = 0; i < reversedQ.length(); i++) {
                Character val = reversedQ.dequeue();
                reversedQ.enqueue(val);

                if (val == '-' || Character.isDigit(val))
                    continue;
                else
                    numberOfLetters++;
            }
            LinkedStack<Character> stack = new LinkedStack<>();
            for (int i = 0; i < numberOfLetters; i++) {
                Character Qvalue = reversedQ.dequeue();
                stack.push(Qvalue);
            }
            while (!stack.isEmpty()) {
                Character Svalue = stack.pop();
                reversedQ.enqueue(Svalue);
            }
            for (int i = 0; i < reversedQ.length() - numberOfLetters; i++) {
                reversedQ.enqueue(reversedQ.dequeue());
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the product code before correcting : ");
        String x = input.next();

        // storing the product code to the Queue
        LinkedQueue<Character> ProductCode = new LinkedQueue<Character>();
        for (int i = 0; i < x.length(); i++)
            ProductCode.enqueue(x.charAt(i));

        ///// Complete the code /////
        System.out.println("\nthe product code after correcting:  ");
        //wedwefreverseProuctType(ProductCode); // Koob-1000234 //licnep-1000972
        ProductCode.print();
    }

}
