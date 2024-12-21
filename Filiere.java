import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filiere {
    private String nomFiliere;
    private List<Etudiant> etudiants;

    public Filiere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
        this.etudiants = new ArrayList<>();
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public void supprimerEtudiant(String cne){
        for(Etudiant etd: etudiants){
            if(etd.getCne().equalsIgnoreCase(cne)){
                etudiants.remove(etd);
                return;
            }
        }
        System.out.println("Non etudiant with this cne ...!");
    }



    public Etudiant rechercherEtudiant(String cne) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getCne().equalsIgnoreCase(cne)) {
                return etudiant;
            }
        }
        return null;
    }

    public void modifierEtudiant(String cne, Etudiant etd) {
        for (int i = 0; i < etudiants.size(); i++) {
            if (etudiants.get(i).getCne().equals(cne)) {
                etudiants.set(i, etd);
                return;
            }
        }
    }

    public void afficherEtudiants() {
        Collections.sort(etudiants);
        for (Etudiant etudiant : etudiants) {
            System.out.println(etudiant);
        }
    }

    @Override
    public String toString() {
        return "Filiere{" +
                "Nom Filiere='" + nomFiliere + '\'' +
                ", Etudiants=" + etudiants +
                '}';
    }
}
