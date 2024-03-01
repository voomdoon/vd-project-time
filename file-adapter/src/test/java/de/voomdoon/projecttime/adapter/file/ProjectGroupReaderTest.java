package de.voomdoon.projecttime.adapter.file;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import java.time.LocalDate;

import org.assertj.core.api.InstanceOfAssertFactories;
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
class ProjectGroupReaderTest extends TestBase {

	/**
	 * @since 0.1.0
	 */
	private static final LocalDate ANY_DATE = LocalDate.of(2024, 3, 1);

	/**
	 * @since 0.1.0
	 */
	private static final String ANY_GROUP_NAME = "test-group";

	/**
	 * DOCME add JavaDoc for method testRead
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testRead() throws Exception {
		logTestStart();

		ProjectGroupReader reader = new ProjectGroupReader();

		ProjectGroup actual = reader.read(Path.of("src/test/resources/group/1day/test-group.group.vdpt"));

		assertThat(actual).extracting(ProjectGroup::getName).isEqualTo(ANY_GROUP_NAME);
		assertThat(actual).extracting(ProjectGroup::getDays).asInstanceOf(InstanceOfAssertFactories.LIST)
				.satisfiesExactly(day -> {
					assertThat((ProjectDay) day).extracting(ProjectDay::getDate).isEqualTo(ANY_DATE);
					assertThat((ProjectDay) day).extracting(ProjectDay::getHours).isEqualTo(constructHours1());
				});
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
