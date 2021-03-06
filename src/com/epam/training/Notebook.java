package com.epam.training;

import java.util.Scanner;

/**
 * <p>
 * ????? ?????? ??? ???????? ???????? ???? {@link Record}
 * </p>
 * 
 * @author Elena
 * @version 1.0
 */
public class Notebook {
	/**
	 * <p>
	 * ?????? ??????? ???? {@link Record}
	 * </p>
	 */
	private Record[] records;
	/**
	 * <p>
	 * ????????-?????????, ?????? ??????????? ????????? ?????????? ??????? ?
	 * ????????.
	 * </p>
	 */
	public final static int maxRecordsNumber = 15;
	/**
	 * ????????-?????? ????????? ?????? ? ????????. ????? -1, ???? ??????? ?
	 * ???????? ???.
	 */
	public static int currentRecordsNumber = -1;

	/**
	 * ??????? ????? ??????.
	 */
	public Notebook() {
		records = new Record[maxRecordsNumber];
	}

	/**
	 * ????? ??? ?????????? ?????? ? ???????.
	 * 
	 * @param record
	 *            - ?????? {@see Record}
	 */
	public void addRecord(Record record) {
		currentRecordsNumber++;
		records[currentRecordsNumber] = record;
	}

	/**
	 * ????? ??? ???????? ?????? ?? ????????.
	 * 
	 * @param index
	 *            - ?????? ??????, ??????? ?????????? ???????.
	 */
	public void deleteRecord(int index) {
		for (int i = 0; i < records.length; i++) {
			if (i == index) {
				for (int j = i; j < records.length - 1; j++)
					records[j] = records[j + 1];
				records[records.length - 1] = null;
				currentRecordsNumber--;
				break;
			}
		}
	}

	/**
	 * ????? ??? ?????????????? ?????? ? ????????.
	 * 
	 * @param index
	 *            - ?????? ??????, ??????? ?????????? ?????????????.
	 */
	public void editRecord(int index) {
		System.out.println("New record: ");
		Scanner in = new Scanner(System.in);
		String item = in.next();
		records[index].setItem(item);
	}

	/**
	 * ????? ??? ??????????? ???? ??????? ????????.
	 */
	public void showAllRecords() {
		for (int i = 0; i <= currentRecordsNumber; i++) {
			System.out.println(i + " " + records[i].getItem());
		}
	}

}
