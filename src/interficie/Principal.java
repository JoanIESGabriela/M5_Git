// MARIO NANÍN MARTÍNEZ

package interficie;

import java.util.Scanner;
import logica.Agenda;
import logica.Contacte;

public class Principal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Agenda ag = new Agenda("Agenda 1:");
        ag.carregarAgenda();
        int opcio = 0;
        do{
            mostrarMenu(ag);
        boolean dadaCorrecta;
        do{
            System.out.println("\n");
            dadaCorrecta=scan.hasNextInt();
            if(!dadaCorrecta){
                scan.next();
                System.err.println("Has d'introduïr una opció (valor enter)");
            }
        }while(!dadaCorrecta);
       opcio = scan.nextInt();  

            switch (opcio) {
                
                // 1. Añadir contacto:
                case 1: 
                    System.out.println("Introdueix el nom del contacte:");
                    String nouNom = scan.next();
                    System.out.println("Introdueix el cognom del contacte:");
                    String nouCognom = scan.next();
                    System.out.println("Introdueix el telèfon del contacte:");
                    String nouTel = scan.next();
                    System.out.println("Introdueix el correu electrònic del contacte:");
                    String nouEmail = scan.next();
                    System.out.println("Introdueix la ciutat del contacte:");
                    String nouCiutat = scan.next();

                    Contacte n = new Contacte(nouNom, nouCognom, nouTel, nouEmail, nouCiutat);
                    ag.afegirContacte(n);
                    n.imprimir();
                    break;

                // Buscar contacto:
                case 2:
                    System.out.println("Introdueix el telèfon del contacte:");
                    String nouTelefon = scan.next();
                    int posicio = ag.buscarContacteTelefon(nouTelefon);
                    Contacte contacte = ag.getContacte(posicio);
                    if (posicio == -1) {
                        System.err.println("No s'ha trobat el telèfon introduït.");
                    } else {
                        contacte.imprimir();
                    }
                    System.out.println("\nPer sortir, prém 5");
                    System.out.println("\nPer tornar al menú, qualsevol altre número");
                    int resposta = scan.nextInt();
                    if (resposta == 5) {
                        opcio = 5;

                    }
                    break;

                // Mostrar contactos por pantalla:
                case 3:
                    System.out.println("Contactes de l'agenda " + ag.getNom());
                    System.out.println("____________________________________________");
                    ag.imprimirAgenda();
                    System.out.println("\nPer sortir, prém 5");
                    System.out.println("\nPer tornar al menú, qualsevol altre número");
                    resposta = scan.nextInt();
                    if (resposta == 5) {
                        opcio = 5;
                    }
                    break;
                    
                // Eliminar contacto:
                case 4:
                    System.out.println("Introdueix el telèfon del contacte que vols eliminar:");
                    String telefonEliminar = scan.next();
                    posicio = ag.buscarContacteTelefon(telefonEliminar);
                    if (posicio == -1) {
                        System.err.println("No s'ha trobat el telèfon introduït.");
                    } else {
                        ag.eliminarContacte(posicio);
                        ag.imprimirAgenda();
                    }
            }

        } while (opcio != 5);
        ag.guardarAgenda();
    }

    // Método para mostrar el menú:
    public static void mostrarMenu(Agenda ag) {
        System.out.println("Agenda de contctes: " + ag.getNom());
        System.out.println("____________________________________________");
        System.out.println("\nTria una opció: \n");
        System.out.println("      Afegir contacte                   [1] \n");
        System.out.println("      Buscar contacte                   [2] \n");
        System.out.println("      Mostrar tots els contactes        [3] \n");
        System.out.println("      Eliminar contacte                 [4] \n");
        System.out.println("      Sortir                            [5] \n");
        System.out.println("____________________________________________");

    }
}
