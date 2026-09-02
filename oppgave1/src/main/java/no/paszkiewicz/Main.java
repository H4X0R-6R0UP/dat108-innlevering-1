package no.paszkiewicz;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.Collections;

import java.lang.Math;

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

        // Oppgave 1b - Input
        int sum = beregn(12, 13, (a, b) -> a + b);
        System.out.println(sum);

        int largest = beregn(-5, 3, (a, b) -> Math.max(a, b));
        System.out.println(largest);

        int absolute = beregn(54, 45, (a, b) -> Math.abs(a - b));
        System.out.println(absolute);
    }

    // Oppgave 1b
    // --------------------------------------------------------------------------
    public static int beregn(int a, int b, BiFunction<Integer,Integer,Integer> operasjon) {
        return operasjon.apply(a, b);
    }
}