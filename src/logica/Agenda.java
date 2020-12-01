// MARIO NANÍN MARTÍNEZ

package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Agenda {

    // Constructores:
    private String nom;
    private int comptador;
    private int nombre;
    public Contacte[] llistat;
    public File fitxer;

    public Agenda(String nom) {
        this.nom = nom;
        this.comptador = 0;
        this.llistat = new Contacte[20];
        this.fitxer = new File ("contactesGuardats.txt");
    }

    // Método para añadir un contacto:
    public boolean afegirContacte(Contacte c) {
        llistat[comptador] = c;
        comptador++;
        return true;
    }

    // Método para buscar contacto por su teléfono:
    public int buscarContacteTelefon(String telefon) {
        int pos = -1;
        for (int i = 0; i < comptador; i++) {
            if (llistat[i].getTelefon().equals(telefon)) {
                pos = i;
            }
        }
        return pos;
    }

    // Método para buscar un contacto por su nombre (No utilizado):
    public int buscarContacteNom(String nom) {
        int pos = -1;
        for (int i = 0; i < comptador; i++) {
            if (llistat[i].getNom().equals(nom)) {
                pos = i;
            }
        }
        return pos;
    }

    public String getNom() {
        return nom;
    }
    
    public Contacte getContacte(int pos) {
        return llistat[pos];
    }

    // Método para mostrar la agenda por pantalla:
    public void imprimirAgenda() {
        for (int i = 0; i < comptador; i++) {
            llistat[i].imprimir();
        }
    }

    // Método para eliminar un contacto:
    public void eliminarContacte(int posicio) {
        for (int i = posicio; i <= comptador; i++) {
            llistat[posicio] = llistat[posicio + 1];
        }
        comptador--;
        System.out.println("Contacte eliminat correctament");
    }
    
    // Método para almacenar los contactos en un archivo .txt:
    public void guardarAgenda() {
        try (PrintStream ps = new PrintStream(fitxer)) {
            if (comptador > 0) {
                for (int i=0; i<comptador; i++) {
                    ps.println(llistat[i].getNom() +
                            "|" + llistat[i].getCognom() + 
                            "|" + llistat[i].getTelefon() +
                            "|" + llistat[i].getEmail() +
                            "|" + llistat[i].getCiutat());
                }
                System.out.println("S'ha desat correctament l'agenda de contactes");
            }
        } catch (Exception ex) {
            System.err.println("No s'ha pogut desar");
        }
    }
    
    // Método para cargar los contactos almacenados en un archivo .txt:
    public void carregarAgenda() {
        try (FileReader fr = new FileReader(fitxer);
                BufferedReader br = new BufferedReader(fr);) {
            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                String contacte[] = linea.split("[|]");
                llistat[i] = new Contacte(contacte[0], contacte[1], contacte[2], contacte[3], contacte[4]);
                i++;
            }
            this.comptador = i;
        } catch (IOException ex) {
            System.err.println("No es pot obrir el fitxer");
        }
    }
}
