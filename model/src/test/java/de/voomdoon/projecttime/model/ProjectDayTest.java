package de.voomdoon.projecttime.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
class ProjectDayTest extends TestBase {

	/**
	 * DOCME add JavaDoc for method testGetDate
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testGetDate() throws Exception {
		logTestStart();

		ProjectDay projectDay = new ProjectDay(LocalDate.of(2024, 3, 1));

		LocalDate actual = projectDay.getDate();

		assertThat(actual).isEqualTo(LocalDate.of(2024, 3, 1));
	}
}
