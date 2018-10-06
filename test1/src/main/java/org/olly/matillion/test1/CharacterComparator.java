package org.olly.matillion.test1;

import java.util.stream.IntStream;

public class CharacterComparator {

    public long calculateDifferences(String one, String two) {

        return IntStream.range(0, one.length())
                .filter(i -> !characterMatch(i, one, two))
                .count();
    }

    private boolean characterMatch(int index, String one, String two){
        return one.charAt(index) == two.charAt(index);
    }
}
