package com.sri.WeekSixWork;

import java.util.ArrayList; //Imports Array Lists

public class App {

	public static void main(String[] args) {
		
		//Initialize the String variables for players, and results
		String firstPlayer = "";
		String secondPlayer = "";

		String winnerOfRound = "";
		String winnerOfGame = "";
	
		//The lines below create 2 Array Lists of type Card for both players' Deck
		ArrayList<Card> Deck1 = new ArrayList<>(56);
		ArrayList<Card> Deck2 = new ArrayList<>(56);
		  
		//Initialize the integer variables:
		int play = 1;
		  
		while (play != 0)	{ //This while-loop will run as long as the user decides to play (play value = 1)
			System.out.println("play value is play = " + play);

			Deck deck = new Deck();	//	Instantiating the Deck
			deck.shuffle();			//	Calls the method shuffle for the deck

			divideDeck(Deck1, Deck2, deck); //Uses the method divideDeck to Divide the deck between the two players
	
			System.out.println("Welcome to the card game of WAR! Let's Play!\n");

			String player1 = Player.getPlayer1(firstPlayer);
			String player2 = Player.getPlayer2(secondPlayer);
			
			//this loop ensures player 2 name is not same as player1 and calls method for re-entry of name
			while (player1.compareToIgnoreCase(player2) == 0)	{
				player2 = "";
				String differentPlayer2 = Player.getDifferentPlayer2(player2);
				player2 = differentPlayer2;
			}

			int player1Tally = 0;
			int player2Tally = 0;
			int drawTally = 0;

			
			System.out.println("-----------------------------------------------------------------------------------------");

			System.out.printf("%6s %25s %25s %25s", "Round", player1,  player2, "Winner");
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------");

			//Starting the limited 26 iterations here
			
			for (int i = 0; i < 26; i++)	{
				int x = Deck1.get(0).isGreater(Deck2.get(0));

				if (x == 1)	{ //When player 1 card has more value than player 2 card
					//The lines below moves the first cards of both decks to the end while removing them from top of the deck:
					Deck1.add(Deck2.get(0));
					Deck1.add(Deck1.get(0));
					Deck1.remove(0);
					Deck2.remove(0);
					winnerOfRound = player1;
					//incrementScore here ----------------
					int player1Score = Player.incrementScore(1, player1Tally);
					player1Tally = player1Tally + player1Score;
				}

				if (x == 2)	{ //When player 2 card has more value than player 1 card
					//The lines below moves the first cards of both decks to the end while removing them from top of the deck:
					Deck2.add(Deck1.get(0));
					Deck2.add(Deck2.get(0));
					Deck2.remove(Deck2.get(0));
					Deck1.remove(0);
					winnerOfRound = player2;
					//incrementScore here ----------------
					int player2Score = Player.incrementScore(1, player1Tally);
					player2Tally = player2Tally + player2Score;
				}

				if (x == 3)	{ ////When player 1 card has same value as player 2 card, result of round is "DRAW"
					Deck1.add(Deck1.get(0));
					Deck2.add(Deck2.get(0));
					Deck2.remove(0);
					Deck1.remove(0);
					winnerOfRound = "DRAW";
					//incrementScore here ----------------
					int drawScore = Player.incrementScore(1, player1Tally);
					drawTally = drawTally + drawScore;
				}
				//Prints the result table for the round
				System.out.printf("%6s %25s %25s %25s\n", (i+1), Deck1.get(0), Deck2.get(0), winnerOfRound); 
			}
			
			//Analyzing the results and then print results.
			if (player1Tally == player2Tally && player1Tally > drawTally) winnerOfGame = "It is a TIE between Both Players";
			if (player1Tally == player2Tally && drawTally > player1Tally) winnerOfGame = "There were more DRAW rounds than Player Wins";
			
			if (player1Tally > player2Tally && player1Tally > drawTally) winnerOfGame = player1;
			if (player2Tally > player1Tally && player2Tally > drawTally) winnerOfGame = player2;
			if (drawTally > player1Tally && drawTally > player2Tally) winnerOfGame = "There were more DRAW rounds in this game!";

			if (drawTally > player1Tally && drawTally == player2Tally) winnerOfGame = "It is a TIE between Drawn ROUNDS and " + player2;
			if (drawTally > player2Tally && drawTally == player1Tally) winnerOfGame = "It is a TIE between Drawn ROUNDS and " + player1;			
				

			System.out.println("Total score for Player 1 (" + player1 + ") is: " + player1Tally);
			System.out.println("Total score for Player 2 (" + player2 + ") is: " + player2Tally);
			System.out.println("Total score for Drawn rounds: " + drawTally);
			
			System.out.println("************************************************************************************");
			System.out.println("***  Congratulations!");
			System.out.println("***  Winner of the game is: " + winnerOfGame);
			System.out.println("************************************************************************************");
			
			play = 0;		//THIS will terminate the game

		}//while loop ends when play is set to 0
	}
	//This method will divide the Deck evenly for both players
	public static void divideDeck(ArrayList<Card> Deck1, ArrayList<Card> Deck2, Deck deck)	{ 
		for (int x = 0; x < 52; x++){
			if (x % 2 != 0)		{
				Deck1.add(deck.drawFromShuffledDeck(x));
				}	else	{
					Deck2.add(deck.drawFromShuffledDeck(x));				
			}
		}
	}


}
