package de.voomdoon.projecttime.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
class ProjectTest extends TestBase {

	/**
	 * @since 0.1.0
	 */
	private static final String ANY_NAME = "test-project";

	/**
	 * DOCME add JavaDoc for method testAddGroup
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testAddGroup() throws Exception {
		logTestStart();

		Project project = new Project(ANY_NAME);

		project.addGroup(new ProjectGroup("test-group"));

		List<ProjectGroup> actuals = project.getGroups();

		assertThat(actuals).hasSize(1);
	}

	/**
	 * DOCME add JavaDoc for method testAddGroup
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testAddGroup_error_duplicateName() throws Exception {
		logTestStart();

		Project project = new Project(ANY_NAME);

		project.addGroup(new ProjectGroup("test-group"));

		assertThrows(IllegalArgumentException.class, () -> project.addGroup(new ProjectGroup("test-group")));
	}

	/**
	 * DOCME add JavaDoc for method testGetProjects_empty
	 * 
	 * @since 0.1.0
	 */
	@Test
	void testAddGroup2() throws Exception {
		logTestStart();

		Project project = new Project(ANY_NAME);

		project.addGroup(new ProjectGroup("test-group1"));
		project.addGroup(new ProjectGroup("test-group2"));

		List<ProjectGroup> actuals = project.getGroups();

		assertThat(actuals).hasSize(2);
	}

	/**
	 * @since 0.1.0
	 */
	@Test
	void testGetGroups_empty() throws Exception {
		logTestStart();

		Project project = new Project(ANY_NAME);

		List<ProjectGroup> actuals = project.getGroups();

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

		Project project = new Project(ANY_NAME);

		String actual = project.getName();

		assertThat(actual).isEqualTo(ANY_NAME);
	}
}
