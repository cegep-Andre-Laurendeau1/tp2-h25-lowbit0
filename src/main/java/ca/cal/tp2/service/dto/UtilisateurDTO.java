package ca.cal.tp2.service.dto;


import ca.cal.tp2.modele.Adresse;
import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.Embedded;

import java.time.LocalDate;

public record UtilisateurDTO(
        long id,
        String nom,
        String email,
        String phoneNumber,
        Adresse adresse,
        String password
) {}









