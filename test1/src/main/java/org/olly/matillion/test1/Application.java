package org.olly.matillion.test1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        CharacterComparator comparator = new CharacterComparator();
        String sampleOne = "Matillion Tech Test ..n";
        String sampleTwo = "Techtest from Matillion";
        log.info("Running character comparator");
        log.info("String one {}", sampleOne);
        log.info("String two {}", sampleTwo);

        long mismatches = comparator.calculateDifferences(sampleOne, sampleTwo);
        log.info("{} character mismatches found", mismatches);

    }
}
