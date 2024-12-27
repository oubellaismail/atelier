public class Cours {
    private String nomCours;
    private String salle;
    private String enseignant;

    public Cours(String nomCours, String salle, String enseignant) {
        this.nomCours = nomCours;
        this.salle = salle;
        this.enseignant = enseignant;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(String enseignant) {
        this.enseignant = enseignant;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "Nom='" + nomCours + '\'' +
                ", Salle='" + salle + '\'' +
                ", Enseignant='" + enseignant + '\'' +
                '}';
    }
}
