package oops.day2;
import java.util.Scanner;                    //package for input from user
import java.util.Random;                     //package for getting a Random number

class Guess_the_number
{
    Scanner userInput = new Scanner(System.in);
    private int target;               //the target is stored which must matches the number guessed by player
    private int g_num;                //the number guessed by the player is stored here
    private int score=0;              //the number of turns in which player can guess the correct score

    Guess_the_number()                //taking a random number as target
    {
        Random rand=new Random();
        int max=100;
        int min=1;
        target=rand.nextInt(max - min + 1) + min;             //a random number is being stored
        System.out.println("🎮GUESS THE NUMBER");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("📜Guidelines:");                         //Guidelines for the game
        System.out.println("📄1. Welcome to the World of Guess The Number.");
        System.out.println("📄2. Enter a number between '1 to 100'.");
        System.out.println("📄3. Guess the correct number to win the Game.");
        System.out.println("📄4. For each turn your score increases by '1'.");
        System.out.println("📄5. You can view the current score by giving input '-1'.");
        System.out.println("📄6. Your score will not increase for input '-1'.");
    }

    public int input()                    //taking input from user if guess is correct print the score
    {
        System.out.println("🔢Enter a number");
        g_num=userInput.nextInt();
        if (g_num==-1)                    //telling the score
        {
            System.out.println("📊Current Score: "+score);
        }
        else
        {
            score=check(g_num, target, score);       //checking if the number is matching or not with target
        }
        if (target==g_num)
        {
            System.out.println("📊Your Score:" +score);                 //telling the score when game is over
            return score;
        }
        return input();
    }

    public int check(int g_num, int target, int score)           //number is checked with the target
    {
        if (g_num==target)
        {
            System.out.println("🏆Congrats! You won the game.🎉");
            score+=1;
        }
        else if(g_num>target)
        {
            System.out.println("❌Wrong Choice! Guess a smaller number");
            score+=1;
        }
        else if(g_num<target)
        {
            System.out.println("❌Wrong Choice! Guess a larger number");
            score+=1;
        }
        else
        {
            System.out.println("❌Invalid Input! Choose a correct option");
        }
        return score;
    }
}

public class guess_game
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Guess_the_number g1=new Guess_the_number();
        g1.input();
        char ch;
        System.out.println("Game Ends!");
    }
}