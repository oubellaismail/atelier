import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Ecole ecole = new Ecole();

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Modifier un étudiant");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Rechercher un étudiant");
            System.out.println("5. Afficher les étudiants d'une filière");
            System.out.println("6. Changer la filière d'un étudiant");
            System.out.println("7. Ajouter une filière");
            System.out.println("8. Afficher les filières");
            System.out.println("9. Afficher les informations d'une filiere ");
            System.out.println("10. Quitter");
            System.out.print("Votre choix: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    addStudent(ecole, scanner, sdf);
                    break;
                case 2: 
                    updateStudent(ecole, scanner, sdf);
                    break;
                case 3: 
                    deleteStudent(ecole, scanner);
                    break;
                case 4: 
                    findStudent(ecole, scanner);
                    break;
                case 5: 
                    displayStudents(ecole, scanner);
                    break;
                case 6: 
                    changeFiliere(ecole, scanner);
                    break;
                case 7: 
                   addFiliere(ecole, scanner);
                    break;
                case 8: 
                    displayFilieres(ecole);
                    break;
                case 9: 
                    displayFiliereDetails(ecole, scanner);
                    break;
                case 10: 
                    System.out.println("Good bye!");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
                    break;
            }
        }
    }

    private static void displayFilieres(Ecole ecole) {
        System.out.println("\n--- Liste des Filières ---");
        ecole.afficherFilieres();
    }
    
    private static void addFiliere(Ecole ecole, Scanner scanner) {
        System.out.print("Nom de la nouvelle filière: ");
        scanner.nextLine(); 
        String nomFiliere = scanner.nextLine();

        if (findFiliere(ecole, nomFiliere) != null) {
            System.out.println("La filière existe déjà !");
            return;
        }

        Filiere newFiliere = new Filiere(nomFiliere);
        ecole.ajouterFiliere(newFiliere);
        System.out.println("Filière ajoutée avec succès !");
    }

    private static void addStudent(Ecole ecole, Scanner scanner, SimpleDateFormat sdf) throws Exception {
        System.out.print("Nom du filière: ");
        scanner.nextLine(); 
        String filiereName = scanner.nextLine();
        Filiere filiere = findFiliere(ecole, filiereName);
        if (filiere == null) {
            System.out.println("Filière introuvable !");
            return;
        }

        System.out.print("CNE: ");
        String cne = scanner.nextLine();
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Date de naissance (dd/MM/yyyy): ");
        String dateStr = scanner.nextLine();
        Etudiant etudiant = new Etudiant(cne, nom, prenom, sdf.parse(dateStr));
        filiere.ajouterEtudiant(etudiant);
        System.out.println("Étudiant ajouté avec succès !");
    }

    private static void updateStudent(Ecole ecole, Scanner scanner, SimpleDateFormat sdf) throws Exception {
        System.out.print("Nom du filière: ");
        scanner.nextLine(); 
        String filiereName = scanner.nextLine();
        Filiere filiere = findFiliere(ecole, filiereName);
        if (filiere == null) {
            System.out.println("Filière introuvable !");
            return;
        }

        System.out.print("CNE de l'étudiant à modifier: ");
        String cne = scanner.nextLine();
        Etudiant etudiant = filiere.rechercherEtudiant(cne);
        if (etudiant == null) {
            System.out.println("Étudiant introuvable !");
            return;
        }

        System.out.print("Nouveau nom: ");
        String nom = scanner.nextLine();
        System.out.print("Nouveau prénom: ");
        String prenom = scanner.nextLine();
        System.out.print("Nouvelle date de naissance (dd/MM/yyyy): ");
        String dateStr = scanner.nextLine();
        Etudiant updatedEtudiant = new Etudiant(cne, nom, prenom, sdf.parse(dateStr));
        filiere.modifierEtudiant(cne, updatedEtudiant);
        System.out.println("Étudiant modifié avec succès !");
    }

    private static void deleteStudent(Ecole ecole, Scanner scanner) {
        System.out.print("Nom du filière: ");
        scanner.nextLine(); 
        String filiereName = scanner.nextLine();
        Filiere filiere = findFiliere(ecole, filiereName);
        if (filiere == null) {
            System.out.println("Filière introuvable !");
            return;
        }

        System.out.print("CNE de l'étudiant à supprimer: ");
        String cne = scanner.nextLine();
        filiere.supprimerEtudiant(cne);
        System.out.println("Étudiant supprimé avec succès !");
    }

    private static void findStudent(Ecole ecole, Scanner scanner) {
        System.out.print("Nom du filière: ");
        scanner.nextLine(); 
        String filiereName = scanner.nextLine();
        Filiere filiere = findFiliere(ecole, filiereName);
        if (filiere == null) {
            System.out.println("Filière introuvable !");
            return;
        }

        System.out.print("CNE de l'étudiant à rechercher: ");
        String cne = scanner.nextLine();
        Etudiant etudiant = filiere.rechercherEtudiant(cne);
        if (etudiant == null) {
            System.out.println("Étudiant introuvable !");
        } else {
            System.out.println(etudiant);
        }
    }

    private static void displayStudents(Ecole ecole, Scanner scanner) {
        System.out.print("Nom du filière: ");
        scanner.nextLine(); 
        String filiereName = scanner.nextLine();
        Filiere filiere = findFiliere(ecole, filiereName);
        if (filiere == null) {
            System.out.println("Filière introuvable !");
            return;
        }
        if(filiere.getEtudiants().size() == 0){
            System.out.println("Liste des étudiants est vide ");
            return;
        }

        System.out.println("Liste des étudiants:");
        filiere.afficherEtudiants();
    }

    private static void changeFiliere(Ecole ecole, Scanner scanner) {
        System.out.print("CNE de l'étudiant: ");
        scanner.nextLine(); 
        String cne = scanner.nextLine();
        System.out.print("Filière actuelle: ");
        String ancienneFiliere = scanner.nextLine();
        System.out.print("Nouvelle filière: ");
        String nouvelleFiliere = scanner.nextLine();
        ecole.changeFiliere(cne, ancienneFiliere, nouvelleFiliere);
    }

    private static Filiere findFiliere(Ecole ecole, String nomFiliere) {
        for (Filiere filiere : ecole.getFilieres()) {
            if (filiere.getNomFiliere().equalsIgnoreCase(nomFiliere)) {
                return filiere;
            }
        }
        return null;
    }

    private static void displayFiliereDetails(Ecole ecole, Scanner scanner) {
        System.out.print("Entrez le nom de la filière: ");
        scanner.nextLine(); 
        String nomFiliere = scanner.nextLine();
        
        System.out.println("\n--- Informations sur la filière ---");
        ecole.afficherInformationsFiliere(nomFiliere);
    }
}
