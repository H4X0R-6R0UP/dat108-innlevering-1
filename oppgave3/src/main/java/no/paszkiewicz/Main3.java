import java.util.Comparator;
import java.util.List;

import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main3 {


    public enum Kjonn {
        MANN,
        KVINNE,
        ANNET
    }

    public static class Ansatt {

        String fornavn;
        String etternavn;
        Kjonn kjonn;
        String stilling;
        double aarslonn;

        public Ansatt(String fornavn, String etternavn, Kjonn kjonn, String stilling, double aarslonn) {
            this.fornavn = fornavn;
            this.etternavn = etternavn;
            this.kjonn = kjonn;
            this.stilling = stilling;
            this.aarslonn = aarslonn;
        }

        public Ansatt() {
        }

        public String getFornavn() {
            return fornavn;
        }

        public void setFornavn(String fornavn) {
            this.fornavn = fornavn;
        }

        public String getEtternavn() {
            return etternavn;
        }

        public void setEtternavn(String etternavn) {
            this.etternavn = etternavn;
        }

        public Kjonn getKjonn() {
            return kjonn;
        }

        public void setKjonn(Kjonn kjonn) {
            this.kjonn = kjonn;
        }

        public String getStilling() {
            return stilling;
        }

        public void setStililng(String stilling) {
            this.stilling = stilling;
        }

        public double getAarslonn() {
            return aarslonn;
        }

        public void setAarslonn(double aarslonn) {
            this.aarslonn = aarslonn;
        }

        @Override
        public String toString() {

            return "\n"+getFornavn()+" "+getEtternavn()+", "+getKjonn()+", "+getStilling()+", "+getAarslonn();
        }
    }

    public static void lonnsoppgjor(List<Ansatt> ansatte, int tall) {
        for (Ansatt ansatt : ansatte) {
            ansatt.setAarslonn(tall);
        }
    }

    public static List<String> filterEtternavn(List<Ansatt> ansatte) {

        return ansatte.stream()
                .map(Ansatt::getEtternavn)
                .collect(Collectors.toList());
    }

    public static long antallKvinner(List<Ansatt> ansatte) {

        return ansatte.stream()
                .map(Ansatt::getKjonn)
                .filter(kjonn -> kjonn.equals(Kjonn.KVINNE)).count();
    }

    public static void snittlonnKvinner(List<Ansatt> ansatte) {

        OptionalDouble dameliste = ansatte.stream()
                .filter(Ansatt -> Ansatt.getKjonn() == Kjonn.KVINNE)
                .mapToDouble(Ansatt::getAarslonn)
                .average();

        System.out.print(dameliste);
    }

    public static void sjeflonn(List<Ansatt> ansatte) {

        ansatte.stream()
                .filter(ansatt -> "Sjef".equals(ansatt.getStilling()))
                .forEach(ansatt -> ansatt.setAarslonn(ansatt.getAarslonn() * 1.07));
    }

    public static boolean lonnSjekk(List<Ansatt> ansatte) {

        return ansatte.stream()
                .anyMatch(ansatt -> ansatt.getAarslonn() > 800000);


    }

    public static Ansatt lavestLonn(List<Ansatt> ansatte) {

        return ansatte.stream()
                .min(Comparator.comparingDouble(Ansatt::getAarslonn))
                .get();
    }


    public static void main(String[] args) {

        Ansatt a1 = new Ansatt("Jan", "Mayen", Kjonn.MANN, "Øy", 1000000);
        Ansatt a2 = new Ansatt("Tone", "Fanta", Kjonn.KVINNE, "Brus", 123433);
        Ansatt a3 = new Ansatt("Granny", "Smith", Kjonn.KVINNE, "Eple", 9000000);
        Ansatt a4 = new Ansatt("Tore", "Paa_sporet", Kjonn.MANN, "Sjef", 100);

        List<Ansatt> ansatte = List.of(a1, a2, a3, a4);

        System.out.print(filterEtternavn(ansatte)+"\n");
        System.out.print(antallKvinner(ansatte)+"\n");
        snittlonnKvinner(ansatte);
        sjeflonn(ansatte);
        System.out.println("\n"+ansatte);
        System.out.print(lonnSjekk(ansatte));
        System.out.print(lavestLonn(ansatte));

        int delelig = IntStream.rangeClosed(1, 1000)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();

        System.out.print("\n"+delelig);
    }
}

