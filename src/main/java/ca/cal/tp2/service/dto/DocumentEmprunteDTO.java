package ca.cal.tp2.service.dto;

import java.time.LocalDate;

public record DocumentEmprunteDTO (
        String titre,
        LocalDate dateEmprunt,
        LocalDate dateRetour
){


    public DocumentEmprunteDTO(String titre, LocalDate dateEmprunt, LocalDate dateRetour) {
        this.titre = titre;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }


}
