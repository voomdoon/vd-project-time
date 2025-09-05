package de.voomdoon.projecttime.adapter.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import de.voomdoon.logging.LogManager;
import de.voomdoon.logging.Logger;
import de.voomdoon.projecttime.model.ProjectDay;
import de.voomdoon.projecttime.model.ProjectGroup;

/**
 * Writer for {@link ProjectGroup}.
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class ProjectGroupWriter {

	/**
	 * @since 0.1.0
	 */
	private static final String HEADLINE = "date\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10\t11\t12\t13\t14\t15\t16\t17\t18\t19\t20\t21\t22\t23";

	/**
	 * @since 0.1.0
	 */
	private final Logger logger = LogManager.getLogger(getClass());

	/**
	 * DOCME add JavaDoc for method write
	 * 
	 * @param group
	 * @param directory
	 * @return
	 * @throws IOException
	 * @since 0.1.0
	 */
	public Path write(ProjectGroup group, Path directory) throws IOException {
		Path file = getFile(group, directory);
		logger.trace("writing to " + file);
		Files.writeString(file, getContent(group));

		return file;
	}

	/**
	 * DOCME add JavaDoc for method getContent
	 * 
	 * @param group
	 * @return
	 * @since 0.1.0
	 */
	private String getContent(ProjectGroup group) {
		StringBuilder sb = new StringBuilder();
		sb.append(HEADLINE);

		for (ProjectDay day : group.getDays()) {
			sb.append("\n");
			sb.append(day.getDate());

			for (int hour : day.getHours()) {
				sb.append("\t");
				sb.append(hour);
			}
		}

		return sb.toString();
	}

	/**
	 * DOCME add JavaDoc for method getFile
	 * 
	 * @param group
	 * @param directory
	 * @return
	 * @since 0.1.0
	 */
	private Path getFile(ProjectGroup group, Path directory) {
		return Path.of(directory.toString(), group.getName() + ".group.vdpt");
	}
}
