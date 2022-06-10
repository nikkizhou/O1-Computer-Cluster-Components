import java.io.File;
import java.util.Scanner;

public class Hovedprogram {
    private static String filnavn;

    public Hovedprogram(String fil) {
        filnavn = fil;
    }


    public static void main(String[] args) throws Exception {
        String filnavn = args[0];

        // opprett en Scanner objekt fil til aa aapne og lese filen.
        Scanner fil = new Scanner(new File(filnavn));

        // opprett et nytt Dataklynge objekt dataklynge.
        Dataklynge dataklynge = new Dataklynge();

        // hvis det er flere linje i filen
        while (fil.hasNextLine()) {
            // opprett en array viariabel linje
            String[] linje = fil.nextLine().split(" ");
            int antNoder = Integer.parseInt(linje[0]);
            int antProcessor = Integer.parseInt(linje[1]);
            int minneStr = Integer.parseInt(linje[2]);

            // kontroller at antall processor ikke er flere enn 16.
            if (antProcessor > 16) {
                System.out.println("Klarer ikke aa legge " + antProcessor + " processor til noden. Maks antall Processor er 16.");
            }
            // kontroller at minne stoerrelse ikke er mer enn 4TB.
            if (minneStr > 4096) {
                System.out.println(
                        "Klarer ikke aa legge " + minneStr + "GB minne til noden. Maks minne stoerrelse er 4096GB.");
            }

            
            for (int i = 0; i < antNoder; i++) {
                if (antProcessor <= 16 && minneStr <= 4096) {
                    // opprett node objekt basert paa antall noder, antall processor og minne stoerrelse.
                    Node node = new Node(minneStr, antProcessor);
                    // legg 
                    dataklynge.leggNodeIDatalynge(node);
                }
            }
        }

        System.out.println("Noder med minst 128 GB: " + dataklynge.noderMedNokMinne(128));
        System.out.println("Noder med minst 512 GB: " + dataklynge.noderMedNokMinne(512));
        System.out.println("Noder med minst 1024 GB: " + dataklynge.noderMedNokMinne(1024));
        System.out.println("Antall prosessorer: " + dataklynge.antProIDatalyngen());
        System.out.println("Antall rack: " + dataklynge.antRack());
    }
}
