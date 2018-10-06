package org.olly.matillion.test1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StringComparatorTest {

    CharacterComparator characterComparator;

    @BeforeEach
    private void setup(){
        characterComparator = new CharacterComparator();
    }

    @Test
    public void givenTwoStringsSharing5Characters_whenCompared_expect5(){

        String one = "ABCDEFGHIJ";
        String two = "AXCXEXGXIX";
        assertNotNull(characterComparator);

        long numberOfDifferences = characterComparator.calculateDifferences(one, two);
        assertEquals(5l, numberOfDifferences);
    }

    @Test
    public void givenTwoEqualStrings_whenCompared_expect0(){
        String one = "TESTstring";
        String two = "TESTstring";
        assertEquals(one, two);

        long numberOfDifferences = characterComparator.calculateDifferences(one, two);
        assertEquals(0l, numberOfDifferences);
    }

    @Test
    public void givenTwoStringsSharingNoCharacters_whenCompared_expectStringLength(){
        String one = "12345A";
        String two = "67890B";

        long numberOfDifferences = characterComparator.calculateDifferences(one, two);
        assertEquals(one.length(), numberOfDifferences);
    }
}
