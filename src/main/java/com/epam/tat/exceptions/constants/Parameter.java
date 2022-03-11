package com.epam.tat.exceptions.constants;

import com.epam.tat.exceptions.bean.Toy;
import java.util.List;
import java.util.stream.Collectors;

public enum Parameter {
    ID("id") {
        @Override
        public List<Toy> getToysByParameter(List<Toy> toyList, String value) {
            return toyList.stream()
                    .filter(toyInList -> toyInList.getId().equals(Long.valueOf(value)))
                    .collect(Collectors.toList());
        }
    },
    TOY_NAME("toyName") {
        public List<Toy> getToysByParameter(List<Toy> toyList, String value) {
            return toyList.stream()
                    .filter(toyInList -> toyInList.getToyName().equals(value))
                    .collect(Collectors.toList());
        }
    },
    GAME_TYPE("gameType") {
        public List<Toy> getToysByParameter(List<Toy> toyList, String value) {
            return toyList.stream()
                    .filter(toyInList -> toyInList.getGameType().equals(GameType.valueOf(value)))
                    .collect(Collectors.toList());
        }
    },
    GENDER("gender") {
        public List<Toy> getToysByParameter(List<Toy> toyList, String value) {
            return toyList.stream()
                    .filter(toyInList -> toyInList.getGender().equals(Gender.valueOf(value)))
                    .collect(Collectors.toList());
        }
    },
    AGE("age") {
        public List<Toy> getToysByParameter(List<Toy> toyList, String value) {
            return toyList.stream()
                    .filter(toyInList -> toyInList.getAge() == Integer.parseInt(value))
                    .collect(Collectors.toList());
        }
    },
    SIZE("size") {
        public List<Toy> getToysByParameter(List<Toy> toyList, String value) {
            return toyList.stream()
                    .filter(toyInList -> toyInList.getSize().equals(Size.valueOf(value)))
                    .collect(Collectors.toList());
        }
    },
    MATERIAL("material") {
        public List<Toy> getToysByParameter(List<Toy> toyList, String value) {
            return toyList.stream()
                    .filter(toyInList -> toyInList.getMaterial().equals(Material.valueOf(value)))
                    .collect(Collectors.toList());
        }
    },
    PRICE("price") {
        public List<Toy> getToysByParameter(List<Toy> toyList, String value) {
            return toyList.stream()
                    .filter(toyInList -> toyInList.getPrice() == Double.parseDouble(value))
                    .collect(Collectors.toList());
        }
    };

    private final String name;

    Parameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract List<Toy> getToysByParameter(List<Toy> toyList, String value);
}
