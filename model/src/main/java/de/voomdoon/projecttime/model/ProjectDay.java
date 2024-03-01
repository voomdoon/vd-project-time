package de.voomdoon.projecttime.model;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class ProjectDay {

	/**
	 * @since 0.1.0
	 */
	private LocalDate date;

	/**
	 * @since 0.1.0
	 */
	private int[] hours = new int[24];

	/**
	 * DOCME add JavaDoc for constructor ProjectDay
	 * 
	 * @param date
	 * @since 0.1.0
	 */
	public ProjectDay(LocalDate date) {
		this.date = date;
	}

	/**
	 * DOCME add JavaDoc for method addHours
	 * 
	 * @param hours
	 * @since 0.1.0
	 */
	public void addHours(int[] hours) {
		for (int i = 0; i < hours.length; i++) {
			validateAddHours(hours, i);

			this.hours[i] += hours[i];
		}
	}

	/**
	 * DOCME add JavaDoc for method getDate
	 * 
	 * @return
	 * @since 0.1.0
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * DOCME add JavaDoc for method getHours
	 * 
	 * @return
	 * @since 0.1.0
	 */
	public int[] getHours() {
		return Arrays.copyOf(hours, hours.length);
	}

	/**
	 * @since 0.1.0
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProjectDay(date: ");
		builder.append(date);
		builder.append(", hours: ");
		builder.append(Arrays.toString(hours));
		builder.append(")");

		return builder.toString();
	}

	/**
	 * DOCME add JavaDoc for method validateAddHours
	 * 
	 * @param hours
	 * @param index
	 * @since 0.1.0
	 */
	private void validateAddHours(int[] hours, int index) {
		if (hours[index] < 0) {
			throw new IllegalArgumentException("Elements must not be negative!");
		} else if (hours[index] > 3600) {
			throw new IllegalArgumentException("Elements must not be greater than 3600!");
		} else if (hours[index] + this.hours[index] > 3600) {
			throw new IllegalArgumentException("Element at index " + index + " would exceed 3600!");
		}
	}
}
