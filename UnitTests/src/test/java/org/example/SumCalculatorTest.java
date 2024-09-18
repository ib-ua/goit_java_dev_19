package org.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class SumCalculatorTest {

    SumCalculator sumCalculator;

    static Stream<Arguments> blankStrings() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(3, 6)
        );
    }

    @BeforeEach
    void beforeEach() {
        sumCalculator = new SumCalculator();
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    void testThatSumWorksCorrect(int number, int expected) {
        //When
        int actual = sumCalculator.sum(number);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testSumThrowsError() {
        //Given
        int number = 0;

        //Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> sumCalculator.sum(number));
    }
}