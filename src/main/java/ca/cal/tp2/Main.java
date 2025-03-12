package ca.cal.tp2;


import ca.cal.tp2.exception.DataBaseException;
import ca.cal.tp2.modele.*;
import ca.cal.tp2.repo.DocumentRepositoryJPA;
import ca.cal.tp2.repo.EmpruntDetailRepositoryJPA;
import ca.cal.tp2.repo.EmpruntRepositoryJPA;
import ca.cal.tp2.repo.UtilisateurRepositoryJPA;
import ca.cal.tp2.service.EmprunteurService;
import ca.cal.tp2.service.PreposeService;
import ca.cal.tp2.service.dto.DocumentDTO;
import ca.cal.tp2.service.dto.DocumentEmprunteDTO;
import ca.cal.tp2.service.dto.EmprunteurDTO;
import ca.cal.tp2.service.dto.PreposeDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException, DataBaseException {
        TcpServer.startTcpServer();

        UtilisateurRepositoryJPA utilisateurRepositoryJPA = new UtilisateurRepositoryJPA();
        EmpruntDetailRepositoryJPA empruntDetailRepositoryJPA = new EmpruntDetailRepositoryJPA();
        EmpruntRepositoryJPA empruntRepositoryJPA = new EmpruntRepositoryJPA(empruntDetailRepositoryJPA);

      //EmprunteurService emprunteurService = new EmprunteurService(new UtilisateurRepositoryJDBC());
      EmprunteurService emprunteurService = new EmprunteurService(
             utilisateurRepositoryJPA,
             empruntRepositoryJPA,
             empruntDetailRepositoryJPA
      );

      PreposeService preposeService = new PreposeService(new UtilisateurRepositoryJPA(), new DocumentRepositoryJPA());

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
            EmprunteurDTO emprunteurDTO = emprunteurService.getEmprunteurByMail("john.doe@example.com");
            System.out.println(emprunteurDTO);
        } catch (DataBaseException e) {
          System.out.println("Erreu bd: " + e.getMessage());
        }







        adresse = new Adresse("louis-parre, 2974, h8n 2J4, Lachine , Qc, Ca");
        Prepose prepose = Prepose.builder()
                .nom("jean jaque")
                .email("jj123@gmail.com")
                .phoneNumber("514-999-9999")
                .adresse(adresse)
                .password("12345678")
                .poste("bibliothequaire").dateEmbauche(LocalDate.now())
                .build();

        try {
            preposeService.createPrepose(prepose);
            PreposeDTO monPreopose = preposeService.getPreposeById(2);
            System.out.println("Prepose created!!!!!!!!!!!!!!!!!!!!!!!!   le voici: ");
            System.out.println(monPreopose.toString());
        } catch (DataBaseException e) {
            System.out.println("Erreu bd: " + e.getMessage());
        }


        Livre livre1 = Livre.builder()
                .titre("Le seigneur des anneaux")
                .anneePublication("1954")
                .auteur("J.R.R. Tolkien")
                .genre("Fantaisie")
                .editeur("Houghton Mifflin")
                .ISBN("978-2-226-10768-9")
                .nbPages(423)
                .build();

        preposeService.createDocument(livre1);
        System.out.println("Document created!!!!!!!!!!!!!!!!!!!!!!!!");
        List<DocumentDTO> monLivre = preposeService.getDocumentsByTitle("Le seigneu");
        System.out.println("Voici les livres avec un titre qui contient 'Le seigneu': ");
        for (DocumentDTO doc : monLivre) {
            System.out.println(doc.toString());
        }

        CD cd1 = CD.builder()
                .titre("Thriller")
                .anneePublication("1982")
                .genre("Pop")
                .auteur("Michael Jackson")
                .dureeMinutes(42)
                .nbMusiques(12)
                .build();

        CD cd2 = CD.builder()
                .titre("Thriller")
                .anneePublication("1982")
                .genre("Pop")
                .auteur("Michael Jackson")
                .dureeMinutes(42)
                .nbMusiques(12)
                .build();

        CD cd3 = CD.builder()
                .titre("A Night at the Opera")
                .anneePublication("1975")
                .genre("Rock")
                .auteur("Queen")
                .dureeMinutes(43)
                .nbMusiques(12)
                .build();

        preposeService.createDocument(cd1);
        preposeService.createDocument(cd2);
        preposeService.createDocument(cd3);

        System.out.println("Document created!!!!!!!!!!!!!!!!!!!!!!!!   le voici: ");

        List<DocumentDTO> monCD = preposeService.getDocumentsByTitle("Thrill");
        for (DocumentDTO doc : monCD) {
            System.out.println(doc.toString());
        }



        List<DocumentDTO>monCD2 = preposeService.getDocumentByAuteur("Michael");
        for (DocumentDTO doc : monCD2){
            System.out.println(doc.toString());
        }

        List<Document> mesDocumentsaEmprunter = new ArrayList<>();
        mesDocumentsaEmprunter.add(cd2);
        mesDocumentsaEmprunter.add(livre1);

        //    ------------------------ section Emprunt ----------------------

        emprunteurService.createEmprunt(mesDocumentsaEmprunter,emprunteur);


        List<DocumentEmprunteDTO> documentEmprunte = emprunteurService.getDocumentEmprunte(emprunteur);
        System.out.println("Voici les documents empruntés par: " + emprunteur.getNom());
        for (DocumentEmprunteDTO doc : documentEmprunte) {
            System.out.println(doc.toString());
        }

        Thread.currentThread().join();
    }
}