package org.olly.matillion.charactercomparator;

import java.util.stream.IntStream;

public class CharacterComparator {

    public long calculateDifferences(String one, String two) throws CharacterComparatorException {
        if(argumentsSameLength(one, two)){
            return IntStream.range(0, one.length())
                    .filter(i -> !characterMatch(i, one, two))
                    .count();
        }else{
            throw new CharacterComparatorException("Arguments must be same length");
        }

    }

    private boolean characterMatch(int index, String one, String two){
        return one.charAt(index) == two.charAt(index);
    }

    private boolean argumentsSameLength(String one, String two){
        return one.length() == two.length();
    }
}
