package ca.cal.tp2.service.dto;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;


public record DocumentDTO(
            long id,
            String titre,
            String anneePublication,
            String genre,
            String typeDocument,
            String auteur,
            String editeur,
            Integer nbPages,
            String artiste,
            Integer duree,
            String director
    ) {

        public static DocumentDTO toDTO(Document document) {
            if (document instanceof Livre livre) {
                return new DocumentDTO(
                        livre.getId(),
                        livre.getTitre(),
                        livre.getAnneePublication(),
                        livre.getGenre(),
                        "Livre",
                        livre.getAuteur(),
                        livre.getEditeur(),
                        livre.getNbPages(),
                        null,
                        null,
                        null
                );
            } else if (document instanceof CD cd) {
                return new DocumentDTO(
                        cd.getId(),
                        cd.getTitre(),
                        cd.getAnneePublication(),
                        null,
                        "CD",
                        null,
                        null,
                        null,
                        cd.getArtiste(),
                        cd.getDuree(),
                        null
                );
            } else if (document instanceof DVD dvd) {
                return new DocumentDTO(
                        dvd.getId(),
                        dvd.getTitre(),
                        dvd.getAnneePublication(),
                        dvd.getGenre(),
                        "DVD",
                        null,
                        null,
                        null,
                        null,
                        dvd.getDuree(),
                        dvd.getDirector()
                );
            } else {
                throw new IllegalArgumentException("Type de document non supporté : " + document.getClass().getSimpleName());
            }
        }
}

