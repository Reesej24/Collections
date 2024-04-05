import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Collections {
    public static void main(String[] args) {
        Boolean sameSame;       // while-loop variable
        char first;             // variable for first element in deque
        char last;              // varialbe for last element in deque
        char userChar;          // variable for characters from input String
        int j;                  // for-loop variable
        String input;           // Input String from user

        // Create Deque object to intake characters as a linked list
        // Create Scanner object
        Deque<Character> palindrome = new LinkedList<>();
        Scanner scnr = new Scanner(System.in);

        // Prompt user to input a line of text
        // I chose to use .nextLine() method so user can enter more than one word
        System.out.println("Please enter a line of text: ");
        input = scnr.nextLine();

        /*
        This block of code processes the entire length of the input String from
        user element-by-element, ignores spacing and punctuation, and converts
        all characters to lowercase by:
        1: for-loop processes line of text starting at index 0 and incrementing
        2: userChar is initialized as each contiguous element of the line of text
        3: userChar is checked to see if element is a letter using .isLetter() method
        4: if userChar is a letter, it is then converted to lowercase using
           .toLowercase() method,
        5: now that the letter has been converted to lowercase, it is added to the
           Deque.
         */
        for(j = 0; j < input.length(); j++) {
            userChar = input.charAt(j);
            if(Character.isLetter(userChar)) {
                palindrome.add(Character.toLowerCase(userChar));
            }
        }

        // Initialize 'sameSame' to true as default
        sameSame = true;

        /*
        This block of code will remove the first and last element of the Deque
        and check if they match by:
        1: while-loop will repeat as long as Deque size is greater than 1
        2: Remove first element from Deque and initialize it to 'first'
        3: Remove last element from Deque and initialize it to 'last'
        4: use if statement to compare 'first' and 'last'
        5: If they do not match, 'sameSame' will be changed to false and the
           while-loop will break
         */
        while(palindrome.size() > 1) {
            first = palindrome.removeFirst();
            last = palindrome.removeLast();
            if(first != last) {
                sameSame = false;
                break;
            }
        }

        // Output if all characters match
        if(sameSame) {
            System.out.println("Yes, \"" + input + "\" is a palindrome.");
        }
        // Output if not all characters match
        else {
            System.out.println("No, \"" + input + "\" is not a palindrome.");
        }
    }
}
