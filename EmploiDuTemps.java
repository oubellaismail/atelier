import java.util.HashMap;
import java.util.Map;

public class EmploiDuTemps {
    private Map<String, Map<String, Cours>> emploi;

    public EmploiDuTemps() {
        emploi = new HashMap<>();
        for (String day : new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}) {
            emploi.put(day, new HashMap<>());
        }
    }

    public Map<String, Map<String, Cours>> getEmploi() {
        return emploi;
    }

    public boolean ajouterSeance(String jour, String creneau, Cours cours) {
        Map<String, Cours> daySchedule = emploi.get(jour);

        if (daySchedule.containsKey(creneau)) {
            System.out.println("Conflit : Une séance est déjà programmée pour ce créneau !");
            return false;
        }

        daySchedule.put(creneau, cours);
        return true;
    }

    public void afficherEmploi() {
        for (String jour : emploi.keySet()) {
            System.out.println(jour + ":");
            Map<String, Cours> daySchedule = emploi.get(jour);
            for (String creneau : daySchedule.keySet()) {
                System.out.println("  " + creneau + " -> " + daySchedule.get(creneau));
            }
        }
    }

    public void modifierSeance(String jour, String creneau, Cours nouveauCours) {
        Map<String, Cours> daySchedule = emploi.get(jour);
        if (daySchedule.containsKey(creneau)) {
            daySchedule.put(creneau, nouveauCours);
            System.out.println("Séance modifiée avec succès.");
        } else {
            System.out.println("Aucune séance n'est programmée pour ce créneau !");
        }
    }
}
