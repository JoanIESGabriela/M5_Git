// MARIO NANÍN MARTÍNEZ

package logica;

public class Contacte {
    
    // Variables:
    private String nom;
    private String cognom;
    private String telefon;
    private String email;
    private String ciutat;
    
    // Constructores:
    public Contacte (String nom, String cognom, String telefon, String email, String ciutat) {
        this.nom = nom;
        this.cognom = cognom;
        this.telefon = telefon;
        this.email = email;
        this.ciutat = ciutat;  
    }
    
    public Contacte (String nom, String cognom, String telefon){
            this(nom, cognom, telefon, "-----", "-----");
    }
    
    public Contacte (String nom, String cognom){
        this(nom, cognom, "-----", "-----", "-----");
    }
    
    // Getters:
    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public String getCiutat() {
        return ciutat;
        
    }
    
    // Setters:
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }
    
    // Método para imprimir por pantalla:
    public void imprimir (){
        System.out.println(nom + " | " + cognom + " | " + telefon + " | " + email + " | " + ciutat);
        System.out.println("____________________________________________\n");
        
    }
    
    
}
