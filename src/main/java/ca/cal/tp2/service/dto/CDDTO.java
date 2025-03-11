package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.Document;

public record CDDTO(
        long id,
        String titre,
        String anneePublication,
        String atiste,
        int duure,
        String duree
) {

    public static CDDTO toDTO(Document cd) {
        return new CDDTO(
                cd.getId(),
                cd.getTitre(),
                cd.getAnneePublication(),
                ((CD) cd).getArtiste(),
                ((CD) cd).getDuree(),
                ((CD) cd).getGenre()

        );
    }
}
