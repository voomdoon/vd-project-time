package de.voomdoon.projecttime.adapter.file;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import de.voomdoon.projecttime.model.ProjectDay;
import de.voomdoon.projecttime.model.ProjectGroup;
import de.voomdoon.testing.tests.TestBase;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
class ProjectGroupWriterTest extends TestBase {

	/**
	 * @since 0.1.0
	 */
	private static final LocalDate ANY_DATE = LocalDate.of(2024, 3, 1);

	/**
	 * @since 0.1.0
	 */
	private static final String ANY_NAME = "test-group";

	/**
	 * DOCME add JavaDoc for method testWrite
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testWrite_createsCorrectFile() throws Exception {
		logTestStart();

		ProjectGroup group = new ProjectGroup(ANY_NAME);
		group.addDay(constructDay1());

		Path file = new ProjectGroupWriter().write(group, getTempDirectory());

		assertThat(file).isRegularFile();
	}

	/**
	 * DOCME add JavaDoc for method testWrite
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testWrite_producesCorrectContent() throws Exception {
		logTestStart();

		ProjectGroup group = new ProjectGroup(ANY_NAME);
		group.addDay(constructDay1());

		Path file = new ProjectGroupWriter().write(group, getTempDirectory());

		assumeThat(file).isRegularFile();

		List<String> actuals = Files.readAllLines(file, StandardCharsets.UTF_8);

		assertThat(actuals).containsExactly(
				"date\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\t16\t17\t18\t19\t20\t21\t22\t23",
				"2024-03-01\t1\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0");
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
	 * DOCME add JavaDoc for method constructHours1
	 * 
	 * @return
	 * @since 0.1.0
	 */
	private int[] constructHours1() {
		return new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	}
}
