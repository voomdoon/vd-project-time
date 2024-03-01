package de.voomdoon.projecttime.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
class ProjectGroupTest extends TestBase {

	/**
	 * @since 0.1.0
	 */
	private static final LocalDate ANY_DATE = LocalDate.of(2024, 3, 1);

	/**
	 * @since 0.1.0
	 */
	private static final String ANY_NAME = "test-group";

	/**
	 * @since 0.1.0
	 */
	private static final LocalDate ANY_OTHER_DATE = LocalDate.of(2024, 3, 2);

	/**
	 * DOCME add JavaDoc for method testAddDay
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testAddDay_1() throws Exception {
		logTestStart();

		ProjectGroup group = new ProjectGroup(ANY_NAME);
		group.addDay(constructDay1());

		List<ProjectDay> actuals = group.getDays();

		assertThat(actuals).satisfiesExactly(day -> {
			assertThat(day).extracting(ProjectDay::getDate).isEqualTo(ANY_DATE);
			assertThat(day).extracting(ProjectDay::getHours).isEqualTo(constructHours1());
		});
	}

	/**
	 * DOCME add JavaDoc for method testAddDay
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testAddDay_1_add() throws Exception {
		logTestStart();

		ProjectGroup group = new ProjectGroup(ANY_NAME);
		group.addDay(constructDay1());
		group.addDay(constructDay1());

		List<ProjectDay> actuals = group.getDays();

		assertThat(actuals).satisfiesExactly(day -> {
			assertThat(day).extracting(ProjectDay::getDate).isEqualTo(ANY_DATE);
			assertThat(day).extracting(ProjectDay::getHours)
					.isEqualTo(new int[] { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
		});
	}

	/**
	 * DOCME add JavaDoc for method testAddDay
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testAddDay_2() throws Exception {
		logTestStart();

		ProjectGroup group = new ProjectGroup(ANY_NAME);
		group.addDay(constructDay1());
		group.addDay(constructDay2());

		List<ProjectDay> actuals = group.getDays();

		assertThat(actuals).hasSize(2);
	}

	/**
	 * DOCME add JavaDoc for method testGetDays
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testGetDays() throws Exception {
		logTestStart();

		ProjectGroup group = new ProjectGroup(ANY_NAME);

		List<ProjectDay> actuals = group.getDays();

		assertThat(actuals).isEmpty();
	}

	/**
	 * DOCME add JavaDoc for method testGetName
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testGetName() throws Exception {
		logTestStart();

		ProjectGroup group = new ProjectGroup(ANY_NAME);

		String actual = group.getName();

		assertThat(actual).isEqualTo(ANY_NAME);
	}

	/**
	 * DOCME add JavaDoc for method constructDay1
	 * 
	 * @return
	 * @since 0.1.0
	 */
	private ProjectDay constructDay1() {
		ProjectDay result = new ProjectDay(ANY_DATE);
		result.addHours(constructHours1());

		return result;
	}

	/**
	 * DOCME add JavaDoc for method constructDay2
	 * 
	 * @return
	 * @since 0.1.0
	 */
	private ProjectDay constructDay2() {
		ProjectDay result = new ProjectDay(ANY_OTHER_DATE);
		result.addHours(constructHours1());

		return result;
	}

	/**
	 * DOCME add JavaDoc for method constructHours1
	 * 
	 * @return
	 * @since 0.1.0
	 */
	private int[] constructHours1() {
		return new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	}
}
