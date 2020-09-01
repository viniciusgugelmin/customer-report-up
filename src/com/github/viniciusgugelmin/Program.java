package com.github.viniciusgugelmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// Change the input file
		File fileIn = new File("D:\\www\\customer-report-up\\files\\clientes.txt");
		Scanner in = new Scanner(fileIn);
		in.nextLine();
		
		List<Customer> list = new ArrayList<>();

		while (in.hasNext()) {
			
			String i = in.nextLine();
			String[] div = i.split(";");

			Customer customer = new Customer();
			customer.setId(div[0]);
			customer.setName(div[1]);
			customer.setCode(div[2]);
			customer.setCredit(div[3]);
			
			list.add(customer);
		}

		int oldestCustomer = 0, count = 0;
		double biggestCredit = 0, totalCredit = 0;
		String nameOldestCustomer = "", nameBiggestCredit = "";
		
		for (Customer customer : list) {
			
			if (count == 0) {
				
				oldestCustomer = customer.getCode();
				biggestCredit = customer.getCredit();
				count++;
			} else {
				
				if (oldestCustomer < customer.getCode()) {
					
					oldestCustomer = customer.getCode();
					nameOldestCustomer = customer.getName();
				}
				
				if (biggestCredit < customer.getCredit()) {
					
					biggestCredit = customer.getCredit();
					nameBiggestCredit = customer.getName();
				}
			}
			
			totalCredit += customer.getCredit();
		}
		
		in.close();
		
		// Change the output file
		File fileOut = new File("D:\\www\\customer-report-up\\files\\data.txt");
		PrintWriter printer = new PrintWriter(fileOut);
		
		printer.println("The oldest customer: " + nameOldestCustomer + "; Code: " + oldestCustomer);
		printer.println("The customer with biggest credit: " + nameBiggestCredit + "; Credit: " + biggestCredit);
		printer.println("The total of credit: " + totalCredit);

		printer.close();
	}
}
