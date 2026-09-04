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
    public static void main(String[] args) {

        Ansatt a1 = new Ansatt("Jan", "Mayen", Kjonn.MANN, "Øy", 1000000);
        Ansatt a2 = new Ansatt("Tone", "Fanta", Kjonn.KVINNE, "Brus", 123433);
        Ansatt a3 = new Ansatt("Granny", "Smith", Kjonn.KVINNE, "Eple", 9000000);
        Ansatt a4 = new Ansatt("Tore", "Paa_sporet", Kjonn.MANN, "Sjef", 100);

        List<Ansatt> ansatte = List.of(a1, a2, a3, a4);

        List<String> etternavn = ansatte.stream()
                .map(Ansatt::getEtternavn)
                .toList();

        System.out.print(etternavn+"\n");

        long kvinner = ansatte.stream()
                .map(Ansatt::getKjonn)
                .filter(kjonn -> kjonn.equals(Kjonn.KVINNE)).count();

        System.out.print(kvinner+"\n");

        OptionalDouble snittlisteKvinner = ansatte.stream()
                .filter(Ansatt -> Ansatt.getKjonn() == Kjonn.KVINNE)
                .mapToDouble(Ansatt::getAarslonn)
                .average();
        System.out.print(snittlisteKvinner+"\n");

        List<Ansatt> sjef = ansatte.stream()
                .filter(ansatt -> "Sjef".equals(ansatt.getStilling()))
                .peek(ansatt -> ansatt.setAarslonn(ansatt.getAarslonn() * 1.07))
                .toList();

        System.out.print(sjef+"\n");

        boolean godtbetalt = ansatte.stream()
                .anyMatch(ansatt -> ansatt.getAarslonn() > 800000);

        System.out.print(godtbetalt+"\n");

        System.out.println(ansatte+"\n");

        Ansatt daarligBetalt = ansatte.stream()
                .min(Comparator.comparingDouble(Ansatt::getAarslonn))
                .get();
        System.out.print(daarligBetalt+"\n");

        int delelig = IntStream.rangeClosed(1, 1000)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();

        System.out.print("\n"+delelig);
    }
}

