import java.util.Date;

public class Etudiant implements Comparable<Etudiant>{
    private String cne;
    private String nom;
    private String prenom;
    private Date dateNaissance;

    public Etudiant(String cne, String nom, String prenom, Date dateNaissance) {
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public int compareTo(Etudiant o) {
        return this.getNom().compareTo(o.getNom());
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "CNE='" + cne + '\'' +
                ", Nom='" + nom + '\'' +
                ", Prenom='" + prenom + '\'' +
                ", Date de naissance=" + dateNaissance +
                '}';
    }
}
