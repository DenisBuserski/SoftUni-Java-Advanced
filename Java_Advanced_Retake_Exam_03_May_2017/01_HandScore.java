package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_03_May_2017;

import java.util.Scanner;

public class HandScore_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cards = scanner.nextLine().split("\\s+");
        int totalSum = 0;
        int count = 1;

        int currentValue = 0;
        String currentSuit = "";

        for (int i = 0; i < cards.length; i++) {
            String card = cards[i];
            int cardPower = getCardPower(card);
            String suit = getCardSuit(card);

            if (i == 0) {
                currentValue = cardPower;
                currentSuit = suit;
            } else if (i == cards.length - 1) {
                if (count > 1) {
                    count++;
                    currentValue += cardPower;
                    currentValue *= count;
                    totalSum += currentValue;
                } else {
                    totalSum += currentValue + cardPower;
                }
            } else {
                if (currentSuit.equals(suit)) {
                    currentValue += cardPower;
                    count++;
                } else {
                    if (count > 1) {
                        currentValue *= count;
                        count = 1;
                    }
                    totalSum += currentValue;
                    currentValue = cardPower;
                    currentSuit = suit;
                }
            }
        }
        System.out.println(totalSum);
    }

    public static String getCardSuit(String card) {
        String suit = "";
        String[] tokens = card.split("");
        if (tokens.length == 2) {
            switch (tokens[1]) {
                case "S":
                    suit = "S";
                    break;
                case "H":
                    suit = "H";
                    break;
                case "D":
                    suit = "D";
                    break;
                case "C":
                    suit = "C";
                    break;
            }
        } else {
            switch (tokens[2]) {
                case "S":
                    suit = "S";
                    break;
                case "H":
                    suit = "H";
                    break;
                case "D":
                    suit = "D";
                    break;
                case "C":
                    suit = "C";
                    break;
            }
        }
        return suit;
    }

    public static int getCardPower(String card) {
        String[] tokens = card.split("");
        int cardPower = 0;

        if (tokens.length == 2) {
            switch (tokens[0]) {
                case "J":
                    cardPower = 12;
                    break;
                case "Q":
                    cardPower = 13;
                    break;
                case "K":
                    cardPower = 14;
                    break;
                case "A":
                    cardPower = 15;
                    break;
                default:
                    cardPower = Integer.parseInt(tokens[0]);
                    break;
            }
        } else {
            switch (tokens[0] + tokens[1]) {
                case "J":
                    cardPower = 12;
                    break;
                case "Q":
                    cardPower = 13;
                    break;
                case "K":
                    cardPower = 14;
                    break;
                case "A":
                    cardPower = 15;
                    break;
                default:
                    cardPower = Integer.parseInt(tokens[0] + tokens[1]);
                    break;
            }
        }


        return cardPower;
    }

}
