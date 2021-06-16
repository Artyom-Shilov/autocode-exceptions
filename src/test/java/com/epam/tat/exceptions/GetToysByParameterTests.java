package com.epam.tat.exceptions;

import com.epam.tat.exceptions.exception.GetToysByParameterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetToysByParameterTests extends AbstractBaseTests {

    @Test
    void shouldNotThrowExceptionDueToNoSuchId() {
        Assertions.assertTrue(playroom.getToysByParameter("id", "465").isEmpty());
    }

    @Test
    void shouldThrowExceptionForGetToysByParameterMethodWhenNullValue() {
        Assertions.assertThrows(GetToysByParameterException.class, () -> playroom.getToysByParameter(null, "1"));
    }
}
