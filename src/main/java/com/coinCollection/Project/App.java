package com.coinCollection.Project;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		CoinStore c = new CoinStore();
		int ch=1;
		while (ch!=0) {
			System.out.println("-----Coin Collection Management-----");
			System.out.println("\n1.Add Coin\n2.Remove Coins\n3.Search Coin\n4.Display Coin\n0.Exit\nEnter your Choice : ");
			ch = input.nextInt();
			
			switch (ch) {
			case 1:
				c.addCoin();
				break;
			case 2:
				c.removeCoin();
				break;
			case 3:
				c.searchCoins();
				break;
			case 4:
				c.displayAllCoins();
				break;
			case 0:
				break;
	
			default:
				System.out.println("Wrong choice");
			}
		}
			
	}
}