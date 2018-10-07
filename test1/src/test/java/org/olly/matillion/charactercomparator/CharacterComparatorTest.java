package org.olly.matillion.charactercomparator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharacterComparatorTest {

    CharacterComparator characterComparator;

    @BeforeEach
    private void setup(){
        characterComparator = new CharacterComparator();
    }

    @Test
    public void givenTwoStringsSharing5Characters_whenCompared_expect5() throws CharacterComparatorException {

        String one = "ABCDEFGHIJ";
        String two = "AXCXEXGXIX";
        assertNotNull(characterComparator);

        long numberOfDifferences = characterComparator.calculateDifferences(one, two);
        assertEquals(5l, numberOfDifferences);
    }

    @Test
    public void givenTwoEqualStrings_whenCompared_expect0() throws CharacterComparatorException {
        String one = "TESTstring";
        String two = "TESTstring";
        assertEquals(one, two);

        long numberOfDifferences = characterComparator.calculateDifferences(one, two);
        assertEquals(0l, numberOfDifferences);
    }

    @Test
    public void givenTwoStringsSharingNoCharacters_whenCompared_expectStringLength() throws CharacterComparatorException {
        String one = "12345A";
        String two = "67890B";

        long numberOfDifferences = characterComparator.calculateDifferences(one, two);
        assertEquals(one.length(), numberOfDifferences);
    }

    @Test
    public void givenTwoStringsWithDifferentLengths_whenCompared_expectException(){
        String one = "one";
        String two = "one plus one";

        assertThrows(CharacterComparatorException.class, () -> characterComparator.calculateDifferences(one, two));
    }
}
