import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ecole {
    private List<Filiere> filieres;

    public Ecole() {
        this.filieres = new ArrayList<>();
    }

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void ajouterFiliere(Filiere filiere) {
        filieres.add(filiere);
    }

    public void afficherInformationsFiliere(String nomFiliere) {
        for (Filiere filiere : filieres) {
            if (filiere.getNomFiliere().equals(nomFiliere)) {
                System.out.println(filiere);
                return;
            }
        }
        System.out.println("Filiere non trouvée !");
    }

    public void changeFiliere(String cne, String ancienneFiliere, String nouvelleFiliere) {
        Filiere source = null;
        Filiere destination = null;
        Etudiant etudiant = null;

        for (Filiere filiere : filieres) {
            if (filiere.getNomFiliere().equals(ancienneFiliere)) {
                source = filiere;
                etudiant = filiere.rechercherEtudiant(cne);
            }
            if (filiere.getNomFiliere().equals(nouvelleFiliere)) {
                destination = filiere;
            }
        }

        if (source == null || destination == null) {
            System.out.println("Une ou les deux filieres spécifiées n'existent pas !");
            return;
        }

        if (etudiant == null) {
            System.out.println("L'étudiant avec le CNE " + cne + " n'existe pas dans la filiere " + ancienneFiliere);
            return;
        }

        if (destination.rechercherEtudiant(cne) != null) {
            System.out.println("L'étudiant est déjà inscrit dans la nouvelle filiere !");
            return;
        }

        source.supprimerEtudiant(cne);
        destination.ajouterEtudiant(etudiant);
        System.out.println("L'étudiant a été transféré avec succès de " + ancienneFiliere + " à " + nouvelleFiliere);
    }

    public void afficherFilieres() {
        if (filieres.isEmpty()) {
            System.out.println("Aucune filière disponible.");
            return;
        }
        System.out.println("Liste des filières:");
        for (Filiere filiere : filieres) {
            System.out.println("- " + filiere.getNomFiliere());
        }
    }

    public boolean verifierConflit(String jour, String creneau, String salle) {
        for (Filiere filiere : filieres) {
            Map<String, Cours> daySchedule = filiere.getEmploiDuTemps().getEmploi().get(jour);
            
            if (daySchedule == null) {
                continue; 
            }

            Cours cours = daySchedule.get(creneau);
            if (cours != null && cours.getSalle().equals(salle)) {
                System.out.println("Conflit détecté : Salle " + salle + " déjà utilisée à ce créneau.");
                return true;
            }
        }
        return false;
    }
}
