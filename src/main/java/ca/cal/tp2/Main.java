package ca.cal.tp2;


import ca.cal.tp2.modele.Adresse;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.repo.UtilisateurRepositoryJDBC;
import ca.cal.tp2.repo.UtilisateurRepositoryJPA;
import ca.cal.tp2.service.EmprunteurService;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.startTcpServer();

        EmprunteurService emprunteurService = new EmprunteurService(new UtilisateurRepositoryJDBC());
        EmprunteurService emprunteurService2 = new EmprunteurService(new UtilisateurRepositoryJPA());
        Adresse adresse = new Adresse("La pierre, 1111, H8N 2J4, Lachine , Qc, Ca");

        Emprunteur emprunteur = Emprunteur.builder()
                .id(1)
                .nom("John Doe")
                .email("john.doe@example.com")
                .phoneNumber("123-456-7890")
                .adresse(adresse)
                .password("securepassword")
                .dateInscription(LocalDate.now())
                .DureeInscription(12)
                .build();

        emprunteurService.createEmprunteur(emprunteur);

        System.out.println(emprunteurService.getEmprunteur(1).getNom());

        Thread.currentThread().join();
    }
}