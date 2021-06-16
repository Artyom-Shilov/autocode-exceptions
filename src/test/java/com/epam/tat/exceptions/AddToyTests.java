package com.epam.tat.exceptions;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.constants.GameType;
import com.epam.tat.exceptions.constants.Gender;
import com.epam.tat.exceptions.constants.Material;
import com.epam.tat.exceptions.constants.Size;
import com.epam.tat.exceptions.exception.AddToyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddToyTests extends AbstractBaseTests {

    @Test
    void shouldAddToy() {
        Toy toy = new Toy(4L, "Car4", GameType.SPORTS, Gender.FEMALE, 4, Size.SMALL, Material.PLASTIC, 71);
        Assertions.assertAll("Toy added successfully!",
                () -> Assertions.assertTrue(playroom.addToy(toy), "Check toy added successfully!"),
                () -> Assertions.assertTrue(playroom.getAllToys().contains(toy), "Check that list contains added toy!"));
    }

    @Test
    void shouldThrowExceptionForAddToyMethodWhenNullValue() {
        Assertions.assertThrows(AddToyException.class, () -> playroom.addToy(null));
    }
}
