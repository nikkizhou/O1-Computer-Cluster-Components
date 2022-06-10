import java.io.File;
import java.util.Scanner;

public class Hovedprogram {

    public static void main(String[] args) {

        Node n1 = new Node(128, 2);
        Node n2 = new Node(1024, 8);
        Node n3 = new Node(512, 2);


        Dataklynge saga = new Dataklynge();

        saga.leggNodeIDatalynge(n1);
        saga.leggNodeIDatalynge(n2);
        saga.leggNodeIDatalynge(n3);


        System.out.println("Noder med minst 128 GB: " + saga.noderMedNokMinne(128));
        System.out.println("Noder med minst 512 GB: " + saga.noderMedNokMinne(512));
        System.out.println("Noder med minst 1024 GB: " + saga.noderMedNokMinne(1024));
        System.out.println("Antall prosessorer: " + saga.antProIDatalyngen());
        System.out.println("Antall rack: " + saga.antRack());
    }
}
