package ca.cal.tp2;


import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.*;
import ca.cal.tp2.repo.UtilisateurRepositoryJPA;
import ca.cal.tp2.service.EmprunteurService;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException, DataBaseException {
        TcpServer.startTcpServer();


        //EmprunteurService emprunteurService = new EmprunteurService(new UtilisateurRepositoryJDBC());
      EmprunteurService emprunteurService = new EmprunteurService(new UtilisateurRepositoryJPA());
        Adresse adresse = new Adresse("La pierre, 1111, H8N 2J4, lassalle , Qc, Ca");

        Emprunteur emprunteur = Emprunteur.builder()
                .nom("John Doe")
                .email("john.doe@example.com")
                .phoneNumber("123-456-7890")
                .adresse(adresse)
                .password("securepassword")
                .dateInscription(LocalDate.now())
                .dureeInscription(12)
                .build();

        try {
            emprunteurService.createEmprunteur(emprunteur);
            System.out.println("Emprunteur created");
            System.out.println(emprunteurService.getEmprunteurByMail("john.doe@example.com"));
        } catch (DataBaseException e) {
          System.out.println("Erreu bd: " + e.getMessage());
        }





        /*
        PreposeService preposeService = new PreposeService(new UtilisateurRepositoryJPA(), new DocumentRepositoryJPA());
        adresse = new Adresse("louis-parre, 2974, h8n 2J4, Lachine , Qc, Ca");
        Prepose prepose = Prepose.builder()
                .nom("jean jaque")
                .email("jj123@gmail.com")
                .phoneNumber("514-999-9999")
                .adresse(adresse)
                .password("12345678")
                .poste("bibliothequaire").dateEmbauche(LocalDate.now())
                .build();
        preposeService.createPrepose(prepose);

        Utilisateur monPreopose = preposeService.getPreposeById(2);
        System.out.println("Prepose created!!!!!!!!!!!!!!!!!!!!!!!!   le voici: ");
        System.out.println(monPreopose.toString());
        */



        /*
        Livre livre1 = Livre.builder()
                .titre("Le seigneur des anneaux")
                .anneePublication("1954")
                .auteur("J.R.R. Tolkien")
                .categorie("Fantaisie")
                .editeur("Houghton Mifflin")
                .ISBN("978-2-226-10768-9")
                .nombrePages(423)
                .build();

        preposeService.createDocument(livre1);
        System.out.println("Document created!!!!!!!!!!!!!!!!!!!!!!!!   le voici: ");
        System.out.println(preposeService.getDocumentById(0).toString());
        */

        Thread.currentThread().join();
    }
}