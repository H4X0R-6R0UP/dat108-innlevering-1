package no.paszkiewicz;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        // Oppgave 1a
        // --------------------------------------------------------------------------
        List<String> list_unsorted = Arrays.asList("10", "1", "20", "110", "21", "12");
        List<String> list_sorted = new ArrayList<>(list_unsorted);

        Collections.sort(list_sorted, (a,b) -> {
            return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
        });

        System.out.println("Oppgave 1 - Sortert liste: " + list_sorted);
    }

    public static int beregn(int a, int b) {
        return a + b;
    }
}