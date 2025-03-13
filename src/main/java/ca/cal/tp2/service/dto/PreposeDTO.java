package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.Adresse;
import ca.cal.tp2.modele.Prepose;
import ca.cal.tp2.modele.Utilisateur;

import java.time.LocalDate;

public record PreposeDTO(
        long id,
        String nom,
        String email,
        String phoneNumber,
        Adresse adresse,
        String poste,
        LocalDate dateEmbauche
) {
    public static PreposeDTO toDTO(Utilisateur prepose) {
        return new PreposeDTO(
                prepose.getId(),
                prepose.getNom(),
                prepose.getEmail(),
                prepose.getPhoneNumber(),
                prepose.getAdresse(),
                ((Prepose) prepose).getPoste(),
                ((Prepose) prepose).getDateEmbauche()

        );}
}
