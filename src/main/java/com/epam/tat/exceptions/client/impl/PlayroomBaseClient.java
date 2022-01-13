package com.epam.tat.exceptions.client.impl;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.client.IPlayroom;
import com.epam.tat.exceptions.constants.*;
import com.epam.tat.exceptions.exception.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayroomBaseClient implements IPlayroom {

	private List<Toy> toyList;

	public PlayroomBaseClient(){
		toyList = new ArrayList<>();
		toyList.add(new Toy(1L, "Doll", GameType.STORY, Gender.FEMALE, 6, Size.MEDIUM, Material.PLASTIC, 150));
		toyList.add(new Toy(2L, "Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70));
		toyList.add(new Toy(3L, "Car", GameType.SPORTS, Gender.FEMALE, 4, Size.LARGE, Material.METAL, 70));
		toyList.add(new Toy(5L, "Toy kitchen", GameType.STORY, Gender.FEMALE, 7, Size.LARGE, Material.PLASTIC, 1170));
		toyList.add(new Toy(8L, "Car", GameType.SPORTS, Gender.FEMALE, 3, Size.SMALL, Material.PLUSH, 330));
		toyList.add(new Toy(13L, "Bug", GameType.PUZZLES, Gender.MALE, 5, Size.SMALL, Material.WOODEN, 220));
		toyList.add(new Toy(21L, "Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70));
	}

	public PlayroomBaseClient(List<Toy> toyList) {
		if (toyList == null) {
			throw new InitializationException("null as toy collection");
		}
		if (toyList.isEmpty()) {
			throw new InitializationException("toy collection is empty");
		}
		this.toyList = toyList;
	}

	@Override
	public List<Toy> getAllToys() {
		return this.toyList;
	}

	private List<Toy> getToysById(String value) {
		return toyList.stream()
				.filter((toyInList) -> toyInList.getId().equals(Long.valueOf(value)))
				.collect(Collectors.toList());
	}

	private List<Toy> getToysByToyName(String value) {
		return toyList.stream()
				.filter((toyInList) -> toyInList.getToyName().equals(value))
				.collect(Collectors.toList());
	}

	private List<Toy> getToysByGameType(String value) {
		return toyList.stream()
				.filter((toyInList) -> toyInList.getGameType().equals(GameType.valueOf(value)))
				.collect(Collectors.toList());
	}

	private List<Toy> getToysByGender(String value) {
		return toyList.stream()
				.filter((toyInList) -> toyInList.getGender().equals(Gender.valueOf(value)))
				.collect(Collectors.toList());
	}

	private List<Toy> getToysByAge(String value) {
		return toyList.stream()
				.filter((toyInList) -> toyInList.getAge() == Integer.parseInt(value))
				.collect(Collectors.toList());
	}

	private List<Toy> getToysBySize(String value) {
		return toyList.stream()
				.filter((toyInList) -> toyInList.getSize().equals(Size.valueOf(value)))
				.collect(Collectors.toList());
	}

	private List<Toy> getToysByMaterial(String value) {
		return toyList.stream()
				.filter((toyInList) -> toyInList.getMaterial().equals(Material.valueOf(value)))
				.collect(Collectors.toList());
	}

	private List<Toy> getToysByPrice(String value) {
		return toyList.stream()
				.filter((toyInList) -> toyInList.getPrice()== Double.parseDouble(value))
				.collect(Collectors.toList());
	}

	@Override
	public List<Toy> getToysByParameter(String parameter, String value) {
		if (parameter == null) {
			throw new GetToysByParameterException("null as parameter");
		}
		if (value == null) {
			throw new GetToysByParameterException("value as parameter");
		}
		switch (Parameter.valueOf(parameter.toUpperCase())) {
			case ID: return getToysById(value);
			case TOY_NAME: return getToysByToyName(value);
			case GAME_TYPE: return getToysByGameType(value);
			case GENDER: return getToysByGender(value);
			case AGE: return getToysByAge(value);
			case SIZE: return getToysBySize(value);
			case MATERIAL: return getToysByMaterial(value);
			case PRICE: return getToysByPrice(value);
			default: throw new GetToysByParameterException("unknown parameter");
		}
	}

	@Override
	public boolean addToy(Toy toy) {
		if (toy == null) {
			throw new AddToyException("null as toy");
		}
		if (toyList.stream().anyMatch((toyInList) -> toyInList.getId().equals(toy.getId()))) {
			throw new AddToyException("toy with the ID is present already");
		}
		if (toy.getId() == null || toy.getAge() < 0 || toy.getToyName() == null
				|| toy.getGameType() == null || toy.getGender() == null || toy.getMaterial() == null
				|| toy.getPrice() < 0 || toy.getSize() == null) {
			return false;
		}
		return toyList.add(toy);
	}

	@Override
	public boolean removeToy(Toy toy) {
		if (toy == null) {
			throw new RemoveToyException("null as toy");
		}
		return toyList.remove(toy);
	}

	@Override
	public boolean updateToy(Long id, Toy toy) {
		if (id == null) {
			throw new UpdateToyException("null as id");
		}
		if (toy == null) {
			throw new UpdateToyException("null as toy");
		}
		if (toyList.stream().noneMatch((toyInList) -> toyInList.getId().equals(toy.getId()))) {
			throw new UpdateToyException("there is no toy with the id");
		}
		if (toy.getId() == null || toy.getAge() < 0 || toy.getToyName() == null
				|| toy.getGameType() == null || toy.getGender() == null || toy.getMaterial() == null
				|| toy.getPrice() < 0 || toy.getSize() == null) {
			return false;
		}
		if (id != toy.getId() && toyList.stream().anyMatch((toyInList) -> toyInList.getId().equals(toy.getId()))) {
			return false;
		}
		Optional<Toy> optionalToy = toyList.stream().filter((toyInList) -> toyInList.getId().equals(id)).findFirst();
		toyList.set(toyList.indexOf(optionalToy.orElseThrow(UpdateToyException::new)), toy);
		return true;
	}

}
