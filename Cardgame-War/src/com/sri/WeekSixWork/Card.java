package com.sri.WeekSixWork;

public class Card {
	
	//Initialize instance variables:
	private int value;
	private String cardSuit;
	private String cardValue;

	//Initialize constructor
	public Card()	{
		
	}

	//Constructor that creates a 'Card' object with Suit and Value
	public Card(String cardSuit, String cardValue){
		this.cardSuit = cardSuit;
		this.cardValue = cardValue;
	  
		//The following if-statements below will determine the value of the card based on the card's cardValue:
		// value ranges from 2-14.
		if(cardValue.equals("2"))	{
			value = 2;
		}
		else	if(cardValue.equals("3"))	{
			value = 3;
		}
		else 	if(cardValue.equals("4"))	{
			value = 4;
		}
		else 	if(cardValue.equals("5"))	{
			value = 5;
		}
		else 	if(cardValue.equals("6"))	{
			value = 6;
		}
		else	 if(cardValue.equals("7"))	{
			value = 7;
		}
		else 	if(cardValue.equals("8"))	{
			value = 8;
		}
		else 	if(cardValue.equals("9"))	{
			value = 9;
		}
		else 	if(cardValue.equals("10"))	{
			value = 10;
		}
		else 	if(cardValue.equals("Jack"))	{
			value = 11;
		}
		else 	if(cardValue.equals("Queen"))	{
			value = 12;
		}
		else 	if(cardValue.equals("King"))	{
			value = 13;
		}
		else 	if(cardValue.equals("Ace"))		{
			value = 14;
		}
	
	}

	//Initialize getter methods:
	public String getcardSuit(){
		return cardSuit;
	}

	public String getcardValue(){
		return cardValue;
	}

	public int getValue(){
		return value;
	}

	//Initialize setter methods:
	public void setcardSuit(String cardSuit){
		this.cardSuit = cardSuit;
	}

	public void setcardValue(String cardValue){
		this.cardValue = cardValue;
	}

	public void setValue(int value){
		this.value = value;
	}

	public String toString(){ //toString method is used to print out a Card object's attributes
		return cardValue + " of " + cardSuit;
	}

	public Card copy(Card card){ //copying attributes of a Card object to another created Card object
		Card temp = new Card (card.getcardSuit(), card.getcardValue());
	return temp;
	}

	public int isGreater(Card card){ //isGreater method compares value of 2 Card objects used to determine winner of round.
		int temp;
		if (value > card.getValue()){ //If the current Card's value is greater than the Card being compared then temp is set to 1
			temp = 1;
		}
		else if (value < card.getValue()){ //else, if the Card that is being compared has a greater value than the current Card then temp is set to 2
			temp = 2;
		}
		else { //else, both Cards have the same value
			temp = 3;
		}
		return temp; //Returns the value of temp after using the method isGreater
	}
}
