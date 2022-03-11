package com.epam.tat.exceptions.client.impl;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.client.IPlayroom;
import com.epam.tat.exceptions.constants.*;
import com.epam.tat.exceptions.exception.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class PlayroomBaseClient implements IPlayroom {

    private List<Toy> toyList;

    private final String TOY_IS_NULL_EXCEPTION_MESSAGE = "toy is null";

    public PlayroomBaseClient() {
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

    @Override
    public List<Toy> getToysByParameter(String parameter, String value) {
        if (parameter == null) {
            throw new GetToysByParameterException("null as parameter");
        }
        if (value == null) {
            throw new GetToysByParameterException("value is null");
        }
        try {
            for (Parameter enumParameter : Parameter.values()) {
                if (enumParameter.getName().toUpperCase().equals(parameter.trim().toUpperCase(Locale.ROOT))) {
                    return enumParameter.getToysByParameter(toyList, value);
                }
            }
            throw new GetToysByParameterException("unknown parameter");
        } catch (NumberFormatException e) {
            throw new GetToysByParameterException(e);
        }
    }

    @Override
    public boolean removeToy(Toy toy) {
        if (toy == null) {
            throw new RemoveToyException(TOY_IS_NULL_EXCEPTION_MESSAGE);
        }
        return toyList.remove(toy);
    }

    @Override
    public boolean addToy(Toy toy) {
        if (toy == null) {
            throw new AddToyException(TOY_IS_NULL_EXCEPTION_MESSAGE);
        }
        if (toyList.stream().anyMatch(toyInList -> toyInList.getId().equals(toy.getId()))) {
            throw new AddToyException("toy with the id is present already");
        }
        if (toy.getId() == null || toy.getAge() < 0 || toy.getToyName() == null
                || toy.getGameType() == null || toy.getGender() == null || toy.getMaterial() == null
                || toy.getPrice() < 0 || toy.getSize() == null) {
            return false;
        }
        return toyList.add(toy);
    }

    @Override
    public boolean updateToy(Long id, Toy toy) {
        if (id == null) {
            throw new UpdateToyException("null as id");
        }
        if (toy == null) {
            throw new UpdateToyException(TOY_IS_NULL_EXCEPTION_MESSAGE);
        }
        if (toyList.stream().noneMatch(toyInList -> toyInList.getId().equals(toy.getId()))) {
            throw new UpdateToyException("there is no toy with the id");
        }
        if (toy.getId() == null || toy.getAge() < 0 || toy.getToyName() == null
                || toy.getGameType() == null || toy.getGender() == null || toy.getMaterial() == null
                || toy.getPrice() < 0 || toy.getSize() == null) {
            return false;
        }
        if (!id.equals(toy.getId()) && toyList.stream().anyMatch(toyInList -> toyInList.getId().equals(toy.getId()))) {
            return false;
        }
        Optional<Toy> optionalToy = toyList.stream().filter(toyInList -> toyInList.getId().equals(id)).findFirst();
        toyList.set(toyList.indexOf(optionalToy.orElseThrow(UpdateToyException::new)), toy);
        return true;
    }
}