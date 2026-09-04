package no.paszkiewicz;

import java.util.function.BiFunction;

public class Oppg1b {
    public static void main(String[] args) {
        System.out.println("Oppgave 1b:");
        int sum = beregn(12, 13, (a, b) -> a + b);
        System.out.println(sum);

        int largest = beregn(-5, 3, (a, b) -> Math.max(a, b));
        System.out.println(largest);

        int absolute = beregn(54, 45, (a, b) -> Math.abs(a - b));
        System.out.println(absolute + "\n");
    }

    public static int beregn(int a, int b, BiFunction<Integer,Integer,Integer> operasjon) {
        return operasjon.apply(a, b);
    }
}
