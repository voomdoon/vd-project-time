package de.voomdoon.projecttime.adapter.file;

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
public class ProjectWriter {

	/**
	 * @since 0.1.0
	 */
	private final ProjectGroupWriter groupWriter = new ProjectGroupWriter();

	/**
	 * DOCME add JavaDoc for method write
	 * 
	 * @param project
	 * @param directory
	 * @throws IOException
	 * @since 0.1.0
	 */
	public void write(Project project, Path directory) throws IOException {
		directory.toFile().mkdirs();

		for (ProjectGroup group : project.getGroups()) {
			groupWriter.write(group, directory);
		}
	}
}
