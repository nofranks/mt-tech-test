package org.olly.matillion.charactercomparator;

public class Application {


    public static void main(String[] args){
        CharacterComparator comparator = new CharacterComparator();
        String sampleOne;
        String sampleTwo;

        if(args.length == 2){
            sampleOne = args[0];
            sampleTwo = args[1];
        }else{
            sampleOne = "Matillion Tech Test ..n";
            sampleTwo = "Techtest from Matillion";
        }

        System.out.println("Running character comparator");
        System.out.printf("String one %s ", sampleOne);
        System.out.printf("String two %s\n", sampleTwo);

        try{
            long numberOfDifferences = comparator.calculateDifferences(sampleOne, sampleTwo);
            System.out.printf("%s character differences detected\n", numberOfDifferences);
        }catch(CharacterComparatorException e){
            System.err.println(e.getMessage());
        }

    }
}
