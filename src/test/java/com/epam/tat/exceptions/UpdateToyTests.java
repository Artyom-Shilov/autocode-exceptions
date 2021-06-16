package com.epam.tat.exceptions;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.client.IPlayroom;
import com.epam.tat.exceptions.client.impl.PlayroomBaseClient;
import com.epam.tat.exceptions.constants.GameType;
import com.epam.tat.exceptions.constants.Gender;
import com.epam.tat.exceptions.constants.Material;
import com.epam.tat.exceptions.constants.Size;
import com.epam.tat.exceptions.exception.InitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UpdateToyTests extends AbstractBaseTests {

    @Test
    void shouldUpdateToy() {
        Toy replacementToy = new Toy(1L, "Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70);
        Toy toyToReplace = new Toy(1L, "Doll", GameType.STORY, Gender.FEMALE, 6, Size.MEDIUM, Material.PLASTIC, 150);

        Assertions.assertAll("Toy updated successfully!",
                () -> Assertions.assertTrue(playroom.updateToy(1L, replacementToy), "Check return value"),
                () -> Assertions.assertTrue(playroom.getAllToys().contains(replacementToy), "Check that list contains updated toy!"),
                () -> Assertions.assertFalse(playroom.getAllToys().contains(toyToReplace), "Check that list does not contain old toy!"));
    }

    @Test
    void shouldThrowExceptionForUpdateToyMethodWhenNullValue() {
        Assertions.assertThrows(InitializationException.class, () -> new PlayroomBaseClient(null));
    }
}
