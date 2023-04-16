package get_requests;

public class Project {

    public static void main(String[] args) {

        /*

        Write a Java program that prints the sum, product, difference, division of num1 and num2.

num1=100;

num2=25;

Sample Output:

125

2500

75

4
         */

        int num1 = 100;
        int num2 = 25;

        int total = num1 + num2;
        int product = num1 * num2;
        int difference = num1 - num2;
        int division = num1/num2;

        System.out.println(total + "\n\n" + product + "\n\n" + difference + "\n\n" + division );
    }
}
