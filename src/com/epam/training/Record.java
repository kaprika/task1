package com.epam.training;

/**
 * <p>
 * Класс описывает запись блокнота со свойством <b>item</b>
 * </p>
 * 
 * @author Elena
 * @version 1.0
 */
public class Record {
	/**
	 * <p>
	 * Свойство - значение записи
	 * </p>
	 */
	private String item;

	/**
	 * <p>
	 * Функция для получения значения поля {@link Record#item}
	 * </p>
	 * 
	 * @return Возвращает запись
	 */
	public String getItem() {
		return item;
	}

	/**
	 * <p>
	 * Функция устанавливает значения поля {@link Record#item}
	 * </p>
	 *
	 */
	public void setItem(String item) {
		this.item = item;
	}

}
