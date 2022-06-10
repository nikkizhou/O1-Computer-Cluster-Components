import java.util.ArrayList;
import javax.xml.crypto.Data;

public class Node {
    private int minneStr;
    private int antPro;

    public Node(int minneStroerrelse, int antProcessor) {
        minneStr = minneStroerrelse;
        antPro = antProcessor;
    }

    public int antProINode() {
        return antPro; 
    }

    public int minneStrINode() {
        return minneStr;
    }
}
