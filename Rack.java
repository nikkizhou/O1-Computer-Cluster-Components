public class Rack {
    // deklare konstant rackKapasitet for aa vise at det er maks 12 noder i en rack.
    private final int rackKapasitet = 12;

    // operett en array for å inneholde Noder i Racket
    private Node[] nodeArr = new Node[rackKapasitet];

    //legger til en ny node i racket.
    public void leggNodeIRack(Node node) {
        // hvis det fortsatt er plass, legg noden til foerste ledige plass.
        for (int i = 0; i < nodeArr.length; i++) {
            if (nodeArr[i] == null) {
                nodeArr[i] = node;
                return;
            }
        }
        // hvis racket er fult, skriv en melding.
        System.out.println("Rack er fult. Kan ikke legge til node.");
    }

    // kjekk om det er ledig plass i racket
    public boolean erLedigPlassIRack() {
        // hvis det finnes en node som er null i nodeArr, da er det ledig plass i racket.
        for (Node node : nodeArr) {
            if (node == null) {
                return true;
            }
        }
        // ellers er det ikke noen ledig plass.
        return false;
    }

    // hent antall Processor i racket
    public int antProIRack() {
        int total = 0;
        for (Node node : nodeArr) {
            if (node != null) {
                total += node.antProINode();
            }
        }
        return total;
    }

    // hent Arrayen som inneholde noder.
    public Node[] hentNodeListen() {
        return nodeArr;
    }

    // hent antall noder i racket.
    public int antNoder(){
        int total = 0;
        for (Node node : nodeArr) {
            if (node != null) {
                total++; 
            }
        }
        return total;
    }
    
}
