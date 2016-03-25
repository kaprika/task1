package com.epam.training;

import java.util.Scanner;

/**
 * <p>
 * Класс служит для хранения объектов типа {@link Record}
 * </p>
 * 
 * @author Elena
 * @version 1.0
 */
public class Notebook {
	/**
	 * <p>
	 * Массив записей типа {@link Record}
	 * </p>
	 */
	private Record[] records;
	/**
	 * <p>
	 * Свойство-константа, задаёт максимально возможное количество записей в
	 * блокноте.
	 * </p>
	 */
	public final static int maxRecordsNumber = 15;
	/**
	 * Свойство-индекс последней записи в блокноте. Равно -1, если записей в
	 * блокноте нет.
	 */
	public static int currentRecordsNumber = -1;

	/**
	 * Создаёт новый объект.
	 */
	public Notebook() {
		records = new Record[maxRecordsNumber];
	}

	/**
	 * Метод для добавления записи в блокнот.
	 * 
	 * @param record
	 *            - запись {@see Record}
	 */
	public void addRecord(Record record) {
		currentRecordsNumber++;
		records[currentRecordsNumber] = record;
	}

	/**
	 * Метод для удаления записи из блокнота.
	 * 
	 * @param index
	 *            - индекс записи, которую необходимо удалить.
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
	 * Метод для редактирования записи в блокноте.
	 * 
	 * @param index
	 *            - индекс записи, которую необходимо редактировать.
	 */
	public void editRecord(int index) {
		System.out.println("New record: ");
		Scanner in = new Scanner(System.in);
		String item = in.next();
		records[index].setItem(item);
	}

	/**
	 * Метод для отображения всех записей блокнота.
	 */
	public void showAllRecords() {
		for (int i = 0; i <= currentRecordsNumber; i++) {
			System.out.println(i + " " + records[i].getItem());
		}
	}

}
