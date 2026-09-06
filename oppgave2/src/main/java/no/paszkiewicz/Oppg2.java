package no.paszkiewicz;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {
    public static void main(String[] args) {
        List<Ansatt> ansatte = new ArrayList<>(List.of(
            new Ansatt("Bartosz","Paszkiewicz", Kjonn.MANN, "Student", 50000),
            new Ansatt("Jason", "Arrey", Kjonn.MANN, "Student", 60000),
            new Ansatt("Daniel", "Aarsand", Kjonn.MANN, "Student", 70000),
            new Ansatt("Marius", "Hansen", Kjonn.MANN, "Student", 80000),
            new Ansatt("Perius", "Sen", Kjonn.MANN, "Student", 80000)
        ));
        
        lonnsoppgjor(ansatte, (a) -> (int) (a.getAarslonn() * 1.02));

        for (Ansatt ansatt : ansatte) {
            System.out.println(ansatt);
        }
    }

    public static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> oppgjor) {
        for (Ansatt ansatt : ansatte) {
            ansatt.setAarslonn(oppgjor.apply(ansatt));
        }
    }
}