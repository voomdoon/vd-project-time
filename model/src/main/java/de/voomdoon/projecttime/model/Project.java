package de.voomdoon.projecttime.model;

import java.util.ArrayList;
import java.util.List;

/**
 * DOCME add JavaDoc for
 *
 * @author André Schulz
 *
 * @since 0.1.0
 */
public class Project {

	/**
	 * @since 0.1.0
	 */
	private List<ProjectGroup> groups = new ArrayList<>();

	/**
	 * @since 0.1.0
	 */
	private String name;

	/**
	 * DOCME add JavaDoc for constructor Project
	 * 
	 * @param name
	 * @since 0.1.0
	 */
	public Project(String name) {
		this.name = name;
	}

	/**
	 * DOCME add JavaDoc for method addGroup
	 * 
	 * @param group
	 * @since 0.1.0
	 */
	public void addGroup(ProjectGroup group) {
		ProjectGroup existingGroup = groups.stream().filter(g -> g.getName().equals(group.getName())).findAny()
				.orElse(null);

		if (existingGroup != null) {
			throw new IllegalArgumentException("Group with name " + group.getName() + " already exists!");
		}

		groups.add(group);
	}

	/**
	 * DOCME add JavaDoc for method getGroups
	 * 
	 * @return
	 * 
	 * @since 0.1.0
	 */
	public List<ProjectGroup> getGroups() {
		return List.copyOf(groups);
	}

	/**
	 * DOCME add JavaDoc for method getName
	 * 
	 * @return
	 * @since 0.1.0
	 */
	public String getName() {
		return name;
	}
}
