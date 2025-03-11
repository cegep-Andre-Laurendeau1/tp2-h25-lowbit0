package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Document;

public record DVDDTO(
        long id,
        String titre,
        String anneePublication,
        String genre,
        String director,
        int duree


) {
    public static DVDDTO toDTO(Document dvd) {
        return new DVDDTO(
                dvd.getId(),
                dvd.getTitre(),
                dvd.getAnneePublication(),
                dvd.getGenre(),
                ((DVD) dvd).getDirector(),
                ((DVD) dvd).getDuree()
        );
    }
}
