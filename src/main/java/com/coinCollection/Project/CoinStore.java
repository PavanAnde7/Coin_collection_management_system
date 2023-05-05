package com.coinCollection.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CoinStore{
	private List<Coin> Coins = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
    public void addCoin() {
    	Coin coin = new Coin();
    	
    	System.out.print("Enter country name: ");
        coin.setCountry(scanner.nextLine());
        System.out.print("Enter denomination: ");
        coin.setDenomination(scanner.nextInt());
        System.out.print("Enter year of Minting: ");
        coin.setYearOfMinting(scanner.nextInt());
        System.out.print("Enter current Value: ");
        coin.setCurrentValue(scanner.nextDouble());
        coin.setAccuiredDate(new Date()); 
        Coins.add(coin);
        Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(coin);
		tx.commit();
		session.close();
        System.out.println("Coin added successfully.");
    }
    
    public void removeCoin() {
        System.out.print("Enter Coin country to remove: ");
        String country = scanner.nextLine();
        System.out.print("Enter Coin srNo to remove: ");
        int srNo = scanner.nextInt();
        int r=0;
        Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query q= session.createQuery("delete from Coin where country=:c and srNo=:s");
		q.setParameter("c", country);
		q.setParameter("s",srNo);
		r=q.executeUpdate();
		tx.commit();
		session.close();
        if (r!=0) {
            System.out.println("country removed successfully.");
        } else {
            System.out.println("country not found.");
        }
    }

    public void searchCoins() {
        System.out.println("Search by:\n1. country\n2. denomination\n3. yearOfMinting\n4. currentValue");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline character
        List<Coin> result = new ArrayList<>();
        Session s = factory.openSession();
        
        switch (choice) {
            case 1:
                System.out.print("Enter country to search: ");
                String country = scanner.nextLine();
                Query q=s.createQuery("FROM Coin where country=:c");
                q.setParameter("c", country);
                result = q.list();
                break;
            case 2:
                System.out.print("Enter denomination to search: ");
                int denomination = scanner.nextInt();
                Query p=s.createQuery("FROM Coin where denomination=:d");
                p.setParameter("d", denomination);
                result = p.list();
                break;
            case 3:
                System.out.print("Enter year of minting to search: ");
                int yearOfMinting = scanner.nextInt();
                q=s.createQuery("FROM Coin where yearOfMinting=:y");
                q.setParameter("y", yearOfMinting);
                result = q.list();
                break;
            case 4:
                System.out.print("Enter current Value to search: ");
                double currentValue = scanner.nextDouble();
                q=s.createQuery("FROM Coin where currentValue=:cu");
                q.setParameter("cu", currentValue);
                result = q.list();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (result.isEmpty()) {
            System.out.println("No Coins found.");
        } else {
            System.out.println("Search results:");
            System.out.printf("%-7s%-20s%-15s%-18s%-15s%-15s\n","Sr.No.","Country","Denomination","YearOfMinting","CurrentValue","AccuiredDate");
            for (Coin Coin : result) {
            	Coin.display();
            }
        }
       s.close();
    }

    public void displayAllCoins() {
        Session s = factory.openSession();
        List li = s.createQuery("FROM Coin").list();
        Iterator it = li.iterator();
        System.out.printf("%-7s%-20s%-15s%-18s%-15s%-15s\n","Sr.No.","Country","Denomination","YearOfMinting","CurrentValue","AccuiredDate");
        
        while(it.hasNext()) {
        	Object o = (Object)it.next();
        	Coin c = (Coin)o;
        	c.display();
        }
        s.close();
        System.out.println("\nDisplayed Successfully");
    }

    public void exit() {
        System.out.println("Exiting the system.");
    }       
}
