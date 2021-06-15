package com.epam.tat.exceptions;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.client.impl.PlayroomBaseClient;
import com.epam.tat.exceptions.exception.InitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GetAllToysTests extends AbstractBaseTests {

    @Test
    void shouldReturnAllToys() {
        List<Toy> actualListOfToys = playroom.getAllToys();
        List<Toy> expectedListOfToys = getAllToys();

        Assertions.assertEquals(actualListOfToys, expectedListOfToys,
                getErrorMsg(actualListOfToys, expectedListOfToys));

        Assertions.assertTrue(Arrays.deepEquals(actualListOfToys.toArray(), expectedListOfToys.toArray()),
                getErrorMsg(actualListOfToys, expectedListOfToys));
    }

    @Test
    void shouldThrowExceptionForGetAllToysMethodWhenNullValue() {
        Assertions.assertThrows(InitializationException.class, () -> new PlayroomBaseClient(null));
    }
}
