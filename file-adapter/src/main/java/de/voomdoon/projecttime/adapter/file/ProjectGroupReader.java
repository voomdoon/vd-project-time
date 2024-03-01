package de.voomdoon.projecttime.adapter.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

import de.voomdoon.projecttime.model.ProjectDay;
import de.voomdoon.projecttime.model.ProjectGroup;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class ProjectGroupReader {

	/**
	 * DOCME add JavaDoc for method read
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @since 0.1.0
	 */
	public ProjectGroup read(Path file) throws IOException {
		ProjectGroup result = new ProjectGroup(getName(file));

		readDays(file, result);

		return result;
	}

	/**
	 * DOCME add JavaDoc for method getName
	 * 
	 * @param file
	 * @return
	 * @since 0.1.0
	 */
	private String getName(Path file) {
		String name = file.getName(file.getNameCount() - 1).toFile().getName();

		return name.substring(0, name.indexOf(".group.vdpt"));
	}

	/**
	 * DOCME add JavaDoc for method parseDay
	 * 
	 * @param line
	 * @return
	 * @since 0.1.0
	 */
	private ProjectDay parseDay(String line) {
		String[] split = line.split("\t");

		ProjectDay result = new ProjectDay(LocalDate.parse(split[0]));

		int[] hours = new int[24];

		for (int i = 0; i < hours.length; i++) {
			hours[i] = Integer.parseInt(split[i + 1]);
		}

		result.addHours(hours);

		return result;
	}

	/**
	 * DOCME add JavaDoc for method readDays
	 * 
	 * @param file
	 * @param group
	 * @throws IOException
	 * @since 0.1.0
	 */
	private void readDays(Path file, ProjectGroup group) throws IOException {
		Queue<String> lines = new LinkedList<>(Files.readAllLines(file));

		lines.poll();// headline

		while (!lines.isEmpty()) {
			group.addDay(parseDay(lines.poll()));
		}
	}
}
