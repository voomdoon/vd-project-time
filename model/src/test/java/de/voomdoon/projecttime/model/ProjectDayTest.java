package de.voomdoon.projecttime.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	 * @since 0.1.0
	 */
	private static final LocalDate ANY_DATE = LocalDate.of(2024, 3, 1);

	/**
	 * @since 0.1.0
	 */
	@Test
	void getGetHours() throws Exception {
		logTestStart();

		ProjectDay projectDay = new ProjectDay(ANY_DATE);
		projectDay.addHours(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });

		int[] actuals = projectDay.getHours();

		assertThat(actuals)
				.isEqualTo(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void getGetHours_resultIsNotInternal() throws Exception {
		logTestStart();

		ProjectDay projectDay = new ProjectDay(ANY_DATE);
		projectDay.addHours(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });

		int[] actuals = projectDay.getHours();
		actuals[1] = 1;

		actuals = projectDay.getHours();

		assertThat(actuals)
				.isEqualTo(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testAddHours() throws Exception {
		logTestStart();

		ProjectDay projectDay = new ProjectDay(ANY_DATE);
		projectDay.addHours(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
		projectDay.addHours(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });

		int[] actuals = projectDay.getHours();

		assertThat(actuals)
				.isEqualTo(new int[] { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testAddHours_error_forLimit() throws Exception {
		logTestStart();

		ProjectDay projectDay = new ProjectDay(ANY_DATE);

		projectDay.addHours(new int[] { 3600, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });

		assertThrows(IllegalArgumentException.class, () -> projectDay
				.addHours(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
	}

	/**
	 * DOCME add JavaDoc for method testAddHours
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testAddHours_error_forNegativeValue() throws Exception {
		logTestStart();

		ProjectDay projectDay = new ProjectDay(ANY_DATE);

		assertThrows(IllegalArgumentException.class, () -> projectDay
				.addHours(new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testAddHours_error_forTooHugheValue() throws Exception {
		logTestStart();

		ProjectDay projectDay = new ProjectDay(ANY_DATE);

		assertThrows(IllegalArgumentException.class, () -> projectDay
				.addHours(new int[] { 3601, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testAddHours_retunrsDay() throws Exception {
		logTestStart();

		ProjectDay projectDay = new ProjectDay(ANY_DATE);
		ProjectDay actual = projectDay
				.addHours(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });

		assertThat(actual).isSameAs(projectDay);
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testGetDate() throws Exception {
		logTestStart();

		ProjectDay projectDay = new ProjectDay(ANY_DATE);

		LocalDate actual = projectDay.getDate();

		assertThat(actual).isEqualTo(ANY_DATE);
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testToString_isNotBlank() throws Exception {
		logTestStart();

		ProjectDay projectDay = new ProjectDay(ANY_DATE);
		projectDay.addHours(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });

		String actual = projectDay.toString();

		logger.debug("actual: " + actual);

		assertThat(actual).isNotBlank();
	}
}
