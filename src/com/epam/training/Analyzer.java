package com.epam.training;

import java.util.Scanner;

/**
 *  ласс дл€ демонстрации работы методов класса {@link Notebook}.
 * 
 * @author Elena
 * @version 1.0
 */
public class Analyzer {
	public static void main(String[] args) {
		Notebook notebook = new Notebook();
		int answer = 1;
		Scanner in = new Scanner(System.in);
		while (answer != 0) {
			System.out
					.println(" Press 1 to add record \n Press 2 to delete record \n Press 3 to edit record \n Press 4 to show all records \n Press 0 to exit");
			answer = in.nextInt();
			switch (answer) {
			case 0:
				break;
			case 1:
				if (notebook.currentRecordsNumber == notebook.maxRecordsNumber - 1)
					System.out.println("Notebook is filled.");
				else {
					System.out.println("Input your record:");
					String item = in.next();
					Record record = new Record();
					record.setItem(item);
					notebook.addRecord(record);
				}
				break;
			case 2:
				if (notebook.currentRecordsNumber != -1) {
					System.out.println("Input index of record to delete:");
					int index = in.nextInt();
					if (index >= 0 && index <= notebook.currentRecordsNumber)
						notebook.deleteRecord(index);
					else
						System.out.println("Invalid index.");
				} else
					System.out.println("Notebook is empty.");
				break;
			case 3:
				if (notebook.currentRecordsNumber != -1) {
					System.out.println("Input index of record to edit:");
					int index = in.nextInt();
					if (index >= 0 && index <= notebook.currentRecordsNumber)
						notebook.editRecord(index);
					else
						System.out.println("Invalid index.");
				} else
					System.out.println("Notebook is empty.");
				break;
			case 4:
				if (notebook.currentRecordsNumber != -1)
					notebook.showAllRecords();
				else
					System.out.println("Notebook is empty.");
				break;
			default:
				System.out.println("Invalid input.");
			}
		}

	}

}
