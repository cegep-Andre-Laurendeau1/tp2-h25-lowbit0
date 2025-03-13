    package ca.cal.tp2.repo;

    import ca.cal.tp2.exception.DataBaseException;
    import ca.cal.tp2.modele.Adresse;
    import ca.cal.tp2.modele.Emprunteur;
    import ca.cal.tp2.modele.Utilisateur;

    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.time.LocalDate;

    public class UtilisateurRepositoryJDBC extends RepoParentJDBC implements UtilisateurRepository {

        @Override
        protected <T> void prepareStatmentInsertObject(PreparedStatement pStatment, T t) throws SQLException {
            if (t instanceof Emprunteur) {
                Emprunteur emprunteur = (Emprunteur) t;
                pStatment.setLong(1, emprunteur.getId());
                pStatment.setString(2, emprunteur.getNom());
                pStatment.setString(3, emprunteur.getEmail());
                pStatment.setString(4, emprunteur.getPhoneNumber());
                pStatment.setString(5, emprunteur.getAdresse().toSingleString());
                pStatment.setString(6, emprunteur.getPassword());
                pStatment.setDate(7, java.sql.Date.valueOf(emprunteur.getDateInscription()));
                pStatment.setInt(8, emprunteur.getDureeInscription());
            }
            else {
                throw new IllegalArgumentException("Mauvais type: " + t.getClass().getSimpleName());
            }

        }

        @Override
        protected String getSqlInsert() {
                return "INSERT INTO EMPRUNTEUR VALUES(?,?,?,?,?,?,?,?)";
        }

        @Override
        protected Emprunteur resultSetGetObject(ResultSet resultSet) throws SQLException {

            String adresseString = resultSet.getString("adresse");
            Adresse adresse = new Adresse(adresseString);
            LocalDate dateInscription = resultSet.getDate("dateInscription").toLocalDate();

            return  Emprunteur. builder()
                    .id(resultSet.getLong("id"))
                    .nom(resultSet.getString("nom"))
                    .email(resultSet.getString("email"))
                    .phoneNumber(resultSet.getString("phoneNumber"))
                    .adresse(adresse)
                    .password(resultSet.getString("password"))
                    .dateInscription(dateInscription)
                    .dureeInscription(resultSet.getInt("DureeInscription"))
                    .build();
        }

        @Override
        protected String getsqlSelect() {
            return "SELECT * FROM EMPRUNTEUR WHERE ID = ?";
        }

        @Override
        public void save(Utilisateur utilisateur) {
            executePreparedStatmentInsert(utilisateur );
        }

        @Override
        public Utilisateur getUtilisateurById(int id) {
            return executePreparedStatmentSelect(id);
        }

        @Override
        public Utilisateur getUtilisateurByMail(String email) throws DataBaseException {
            return null;
        }
    }
