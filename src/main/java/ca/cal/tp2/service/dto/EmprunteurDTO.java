package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.Adresse;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Utilisateur;

import java.time.LocalDate;

public record EmprunteurDTO(
        long id,
        String nom,
        String email,
        String phoneNumber,
        Adresse adresse,
        LocalDate dateInscription,
        int dureeInscription
) {
    public static EmprunteurDTO toDTO(Utilisateur emprunteur) {
        return new EmprunteurDTO(
                emprunteur.getId(),
                emprunteur.getNom(),
                emprunteur.getEmail(),
                emprunteur.getPhoneNumber(),
                emprunteur.getAdresse(),
                ((Emprunteur) emprunteur).getDateInscription(),
                ((Emprunteur) emprunteur).getDureeInscription()

        );
    }
}
