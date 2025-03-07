package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate dateEmprunt;
    private String status;

    @OneToMany(mappedBy = "emprunt")
    private List<EmpruntDetail> empruntDetail;

    @ManyToOne
    private Emprunteur emprunteur;


    public  Emprunt getEmprunt(){
        return null;
    };

}
