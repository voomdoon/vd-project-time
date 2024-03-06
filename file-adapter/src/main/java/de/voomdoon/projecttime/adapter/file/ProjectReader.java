package de.voomdoon.projecttime.adapter.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import de.voomdoon.projecttime.model.Project;
import de.voomdoon.projecttime.model.ProjectGroup;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class ProjectReader {

	/**
	 * @since 0.1.0
	 */
	private final ProjectGroupReader groupReader = new ProjectGroupReader();

	/**
	 * DOCME add JavaDoc for method read
	 * 
	 * @param directory
	 * @return
	 * @throws IOException
	 * @since 0.1.0
	 */
	public Project read(Path directory) throws IOException {
		Project result = new Project(getName(directory));

		readGroups(directory, result);

		return result;
	}

	/**
	 * DOCME add JavaDoc for method getName
	 * 
	 * @param directory
	 * @return
	 * @since 0.1.0
	 */
	private String getName(Path directory) {
		return directory.getFileName().toString();
	}

	/**
	 * DOCME add JavaDoc for method readGroups
	 * 
	 * @param directory
	 * @param result
	 * @throws IOException
	 * @since 0.1.0
	 */
	private void readGroups(Path directory, Project result) throws IOException {
		for (File file : directory.toFile().listFiles()) {
			if (file.getName().endsWith(".group.vdpt")) {
				ProjectGroup group = groupReader.read(file.toPath());
				result.addGroup(group);
			}
		}
	}
}
