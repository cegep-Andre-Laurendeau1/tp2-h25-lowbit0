package ca.cal.tp2.service.dto;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;


public record DocumentDTO(
            long id,
            String typeDocument,
            String titre,
            String anneePublication,
            String genre,
            String auteur,
            String editeur,
            Integer nbPages,
            Integer dureEmprunt,
            Integer dureMinutes,
            Integer nbMusique
    ) {

        public static DocumentDTO toDTO(Document document) {
            if (document instanceof Livre livre) {
                return new DocumentDTO(
                        livre.getId(),
                        "Livre",
                        livre.getTitre(),
                        livre.getAnneePublication(),
                        livre.getGenre(),
                        livre.getAuteur(),
                        livre.getEditeur(),
                        livre.getNbPages(),
                        livre.getDureEmprunt(),
                        null,
                        null
                );
            } else if (document instanceof CD cd) {
                return new DocumentDTO(
                        cd.getId(),
                        "CD",
                        cd.getTitre(),
                        cd.getAnneePublication(),
                        cd.getGenre(),
                        cd.getAuteur(),
                        null,
                        null,
                        cd.getDureEmprunt(),
                        cd.getDureeMinutes(),
                        cd.getNbMusiques()
                );

            } else if (document instanceof DVD dvd) {
                return new DocumentDTO(
                        dvd.getId(),
                        "DVD",
                        dvd.getTitre(),
                        dvd.getAnneePublication(),
                        dvd.getGenre(),
                        dvd.getAuteur(),
                        null,
                        null,
                        dvd.getDureEmprunt(),
                        dvd.getDureeMinutes(),
                        null


                );
            } else {
                throw new IllegalArgumentException("Type de document non supporté : " + document.getClass().getSimpleName());
            }
        }




}





