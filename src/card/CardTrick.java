package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier Valmir Muratovski , Student id: 991732872
 */
public class CardTrick {

    public static void main(String[] args) {

        Card[] magicHand = new Card[7];
        Random rand = new Random();

        // Fill the magic hand with 7 random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1); // Value from 1 to 13
            c.setSuit(Card.SUITS[rand.nextInt(4)]); // Random suit
            magicHand[i] = c;
        }

        // Lucky card: 2 of Clubs
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");

        // Ask user for card
        Scanner input = new Scanner(System.in);
        System.out.print("Enter card value (1-13): ");
        int userValue = input.nextInt();
        input.nextLine(); // Clear the newline
        System.out.print("Enter card suit (Hearts, Diamonds, Spades, Clubs): ");
        String userSuit = input.nextLine();

        // Search for user's card
        boolean found = false;
        for (Card c : magicHand) {
            if (c.getValue() == userValue && c.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }

        // Show result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is NOT in the magic hand.");
        }
    }
}
