
import java.util.ArrayList;
public class Dataklynge {
    private ArrayList<Rack> rackListe = new ArrayList<>();

    public Rack leggRackIDatalynge() {
        Rack rack = new Rack();
        rackListe.add(new Rack());
        return rack;
    }

    public void leggNodeIDatalynge(Node node) {
        // hvis det ikke er noe ledig rack i Datalynge, skal et nytt rack legges til Datalynge
        if (!this.erLedigRackIDatalynge()) {
            this.leggRackIDatalynge();
        }
        // legge noden til den foerste ledige racket i Datalyngen.
        for (Rack rack : rackListe) {
            if (rack.erLedigPlassIRack()) {
                rack.leggNodeIRack(node);
            }
        }
    }

    // kjekke om det er noe Rack som er ledig i Datalyngen.
    public boolean erLedigRackIDatalynge() {
        // hvis det er et rack som er ledig, da returnere det true.
        for (Rack rack : rackListe) {
            if (rack.erLedigPlassIRack()) {
                return true;
            }
        }
        // ellers returnere false.
        return false;
    }

    // få antall processor datalyngen.
    public int antProIDatalyngen() {
        int total = 0;
        for (Rack rack : rackListe) {
            total += rack.antProIRack();
        }
        return total;
    }

    // kjekk hvor mange noder som har nok minnestoerrelse
    public int noderMedNokMinne(int paakrevdMinne) {
        int antNode = 0;
        for (Rack rack : rackListe) {
            for (Node node : rack.hentNodeListen()) {
                if (node != null) {
                    if (node.minneStrINode() >= paakrevdMinne) {
                        antNode++;
                    }
                }
            }
        }
        return antNode;
    }

    // hent antall rack.
    public int antRack() {
        return rackListe.size();
    }
        
}
