package de.voomdoon.projecttime.model;

import java.time.LocalDate;

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
	 * DOCME add JavaDoc for constructor ProjectDay
	 * 
	 * @param date
	 * @since 0.1.0
	 */
	public ProjectDay(LocalDate date) {
		this.date = date;
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
}
