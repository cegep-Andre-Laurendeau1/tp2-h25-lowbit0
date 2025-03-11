package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;

public record LivreDTO(
        long id,
        String titre,
        String anneePublication,
        String genre,
        String auteur,
        String editeur,
        int nbPages
) {
    public static LivreDTO toDTO(Document livre) {
        return new LivreDTO(
                livre.getId(),
                livre.getTitre(),
                livre.getAnneePublication(),
                livre.getGenre(),
                ((Livre) livre).getAuteur(),
                ((Livre) livre).getEditeur(),
                ((Livre) livre).getNbPages()
        );
    }
}
