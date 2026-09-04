package no.paszkiewicz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Oppg1a {

    public static void main(String[] args) {
        List<String> list_unsorted = Arrays.asList("10", "1", "20", "110", "21", "12");
        List<String> list_sorted = new ArrayList<>(list_unsorted);

        Collections.sort(list_sorted, (a,b) -> {
            return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
        });

        System.out.println("Oppgave 1a:\n" + list_sorted + "\n");
    }

}
