package de.voomdoon.projecttime.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class ProjectGroup {

	/**
	 * @since 0.1.0
	 */
	private List<ProjectDay> days = new ArrayList<>();

	/**
	 * @since 0.1.0
	 */
	private String name;

	/**
	 * DOCME add JavaDoc for constructor ProjectGroup
	 * 
	 * @param name
	 * @since 0.1.0
	 */
	public ProjectGroup(String name) {
		this.name = name;
	}

	/**
	 * DOCME add JavaDoc for method addDay
	 * 
	 * @param day
	 * @since 0.1.0
	 */
	public void addDay(ProjectDay day) {
		Optional<ProjectDay> existing = getDay(day.getDate());

		existing.ifPresentOrElse(addHoursToExistingDay(day), addNewDay(day));
	}

	/**
	 * DOCME add JavaDoc for method getDays
	 * 
	 * @return
	 * 
	 * @since 0.1.0
	 */
	public List<ProjectDay> getDays() {
		return List.copyOf(days);
	}

	/**
	 * DOCME add JavaDoc for method getName
	 * 
	 * @return
	 * @since 0.1.0
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param day
	 * @return
	 * @since 0.1.0
	 */
	private Consumer<? super ProjectDay> addHoursToExistingDay(ProjectDay day) {
		return d -> d.addHours(day.getHours());
	}

	/**
	 * DOCME add JavaDoc for method addNewDay
	 * 
	 * @param day
	 * @return
	 * @since 0.1.0
	 */
	private Runnable addNewDay(ProjectDay day) {
		return () -> days.add(day);
	}

	/**
	 * DOCME add JavaDoc for method getDay
	 * 
	 * @param date
	 * @return
	 * @since 0.1.0
	 */
	private Optional<ProjectDay> getDay(LocalDate date) {
		return days.stream().filter(day -> day.getDate().equals(date)).findFirst();
	}
}
