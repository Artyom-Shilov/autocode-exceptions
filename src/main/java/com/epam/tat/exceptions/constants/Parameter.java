package com.epam.tat.exceptions.constants;

public enum Parameter {
	ID("id"),
	TOY_NAME("toyName"),
	GAME_TYPE("gameType"),
	GENDER("gender"),
	AGE("age"),
	SIZE("size"),
	MATERIAL("material"),
	PRICE("price");

	private final String name;

	Parameter(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
