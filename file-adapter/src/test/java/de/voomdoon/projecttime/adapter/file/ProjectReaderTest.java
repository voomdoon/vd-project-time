package de.voomdoon.projecttime.adapter.file;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import java.time.LocalDate;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import de.voomdoon.projecttime.model.Project;
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
class ProjectReaderTest extends TestBase {

	/**
	 * @since 0.1.0
	 */
	private static final LocalDate ANY_DATE = LocalDate.of(2024, 3, 1);

	/**
	 * @since 0.1.0
	 */
	private final ProjectReader reader = new ProjectReader();

	/**
	 * @since 0.1.0
	 */
	@Test
	void testRead_groups() throws Exception {
		logTestStart();

		Project actual = reader.read(Path.of("src/test/resources/project/1group"));

		assertOneGroup(actual);
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testRead_groups_ignoreOtherFiles() throws Exception {
		logTestStart();

		Project actual = reader.read(Path.of("src/test/resources/project/otherFiles"));

		assertOneGroup(actual);
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testRead_projectName() throws Exception {
		logTestStart();

		Project actual = reader.read(Path.of("src/test/resources/project/1group"));

		assertThat(actual).extracting(Project::getName).isEqualTo("1group");
	}

	/**
	 * DOCME add JavaDoc for method assertOneGroup
	 * 
	 * @param actual
	 * @since 0.1.0
	 */
	private void assertOneGroup(Project actual) {
		assertThat(actual).extracting(Project::getGroups).asInstanceOf(InstanceOfAssertFactories.LIST)
				.satisfiesExactly(group -> {
					assertThat((ProjectGroup) group).extracting(ProjectGroup::getDays)
							.asInstanceOf(InstanceOfAssertFactories.LIST).satisfiesExactly(day -> {
								assertThat((ProjectDay) day).extracting(ProjectDay::getDate).isEqualTo(ANY_DATE);
								assertThat((ProjectDay) day).extracting(ProjectDay::getHours)
										.isEqualTo(constructHours1());
							});
				});
	}

	/**
	 * @return
	 * @since 0.1.0
	 */
	private int[] constructHours1() {
		return new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	}
}
