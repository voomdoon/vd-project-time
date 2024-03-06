package de.voomdoon.projecttime.adapter.file;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import java.time.LocalDate;

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
class ProjectWriterTest extends TestBase {

	/**
	 * @since 0.1.0
	 */
	private static final LocalDate ANY_DATE = LocalDate.of(2024, 3, 1);

	/**
	 * @since 0.1.0
	 */
	private final ProjectWriter writer = new ProjectWriter();

	/**
	 * @since 0.1.0
	 */
	@Test
	void testWrite_existing_createsExpectedFiles() throws Exception {
		logTestStart();

		Project project = new Project("test-project");
		ProjectGroup group = new ProjectGroup("test-group");
		group.addDay(new ProjectDay(ANY_DATE).addHours(constructHours1()));
		project.addGroup(group);

		Path output = Path.of(getTempDirectory().toString(), "output");

		writer.write(project, output);
		writer.write(project, output);

		assertThat(output).isDirectory();
		assertThat(output.toFile().list()).containsExactly("test-group.group.vdpt");
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testWrite_new_createsExpectedFiles() throws Exception {
		logTestStart();

		Project project = new Project("test-project");
		ProjectGroup group = new ProjectGroup("test-group");
		group.addDay(new ProjectDay(ANY_DATE).addHours(constructHours1()));
		project.addGroup(group);

		Path output = Path.of(getTempDirectory().toString(), "output");

		writer.write(project, output);

		assertThat(output).isDirectory();
		assertThat(output.toFile().list()).containsExactly("test-group.group.vdpt");
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
