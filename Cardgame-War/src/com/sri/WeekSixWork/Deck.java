package com.sri.WeekSixWork;

import java.util.ArrayList; //Imports ArrayList
import java.util.Random; //Imports Random

public class Deck {
	
	Random random = new Random();
	//Initialize instance variables using ArrayList for the card deck
	private ArrayList <Card> Deck = new ArrayList <Card>(52);
	private ArrayList <Card> Shuffled = new ArrayList <Card>(52);

	//Initialize Deck constructor
	public Deck()	{
	//Initialize the string to blank values to avoid errors
		String suit = "";
		String rank = "";

		//The lines below assigns the card suit
		for(int x = 0; x < 4; x++)	{
			if(x == 0){
				suit = "Clubs";
			}
			else if(x == 1)	{
				suit = "Hearts";
			}
			else if(x == 2)	{
				suit = "Spades";
			}
			else if(x == 3)	{
				suit = "Diamonds";
			}
			
			//The lines below assigns the card values
			for(int y = 1; y <= 13; y++)	{
				if(y == 1)	{
					rank = "Ace";
				}
				else if(y > 1 && y < 11)	{		//rank gets the value of the card between 2 & 10
					rank = "" + y;
				}
				else if(y == 11)	{
					rank = "Jack";
				}
				else if(y == 12)	{
					rank = "Queen";
				}
				else if(y == 13)	{
					rank = "King";
				}
				//Gets the deck of cards ready
				Card card = new Card(suit, rank);
				Deck.add(card);
			}
		}
	}

	
	//This method is used to draw a Card from the shuffled 52 card deck
	public Card drawFromShuffledDeck(int x)		{ 
		if(!Shuffled.isEmpty()){
			return Shuffled.get(x);
		}
		return null;
	}

	//This method that takes all cards from the deck and shuffles them in a random order
	public void shuffle()	{ 
		
		//usedIndexCount is an integer Array List that collects the used indexes
		ArrayList<Integer> usedIndexCount = new ArrayList<>(52); 
		int cardCounter = 0;

		//	This nested while-loop loops through all 52 Card objects in the Deck and keeps 
		//	adding Card objects to the Shuffled deck in a random order
		while (cardCounter < 52){ 
			int cardnum = random.nextInt((51 - 0) + 1);
			while (usedIndexCount.indexOf(cardnum) == -1){
				usedIndexCount.add(cardCounter, cardnum); //Gets added to the usedIndexCount Array List
				Shuffled.add(cardCounter, Deck.get(cardnum)); //Gets added to the Shuffled Array List
				cardCounter++; //Increments the counter
			}
		}
	}
}
