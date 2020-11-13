package com.sri.WeekSixWork;

import java.util.Scanner;

public class Player {
	
	static String getPlayer1(String firstPlayer) {
		
	Scanner scan = new Scanner(System.in); //Creates a new Scanner called 'scan' for user input of name
	
	while (firstPlayer.isEmpty())	{
		System.out.print("Enter the first player's name: ");
		firstPlayer = scan.nextLine();

		if (firstPlayer.isEmpty())	{
			System.out.println("Please enter a valid name for the firstplayer!");
			}	else	{
					break;
			}
		}
		return firstPlayer;
	}
	
	static String getPlayer2(String secondPlayer) {
	Scanner scan = new Scanner(System.in); //Creates a new Scanner called 'scan' & import Scanner util

	while (secondPlayer.isEmpty())	{
		System.out.print("Enter the second player's name: ");
		secondPlayer = scan.nextLine();

		if (secondPlayer.isEmpty())	{
			System.out.println("Please enter a valid name for the second player!");
			}	else	{
					break;
			}
		}
		return secondPlayer;
	}

	static String getDifferentPlayer2(String secondPlayer) {

	Scanner scan = new Scanner(System.in); //Creates a new Scanner called 'scan' & import Scanner util

	while (secondPlayer.isEmpty())	{
		System.out.println("You have entered the same name for the Second Player.  Please enter a different name:");
		secondPlayer = scan.nextLine();

		if (secondPlayer.isEmpty())	{
			System.out.println("Please enter a valid name for the second player!");
			}	else	{
					break;
			}
		}
		return secondPlayer;
	}

	

	public static Integer incrementScore(Integer scoreID, Integer playerTally) {
		
		if (scoreID == 1)	{
			playerTally = 1;
		}
		if (scoreID == 2)	{
			playerTally = 1;
		}
		if (scoreID == 3)	{
			playerTally = 1;
		}
		return playerTally;
	}
	
}
