package ca.cal.tp2.repo;

import ca.cal.tp2.modele.Emprunteur;

import java.sql.*;

public abstract class RepoParentJDBC {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:tp2luiscqv;DB_CLOSE_DELAY=-1";
    static final String USER = "admin";
    static final String PASS = "";
    static Connection conn = null;


    static {

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE EMPRUNTEUR " +
                    "(id INTEGER NOT NULL, " +
                    "nom VARCHAR(255) NOT NULL, " +
                    "email VARCHAR(255) NOT NULL, " +
                    "phoneNumber VARCHAR(20), " +
                    "adresse VARCHAR(255), " +
                    "password VARCHAR(255) NOT NULL, " +
                    "dateInscription DATE, " +
                    "DureeInscription INT, " +
                    "PRIMARY KEY (id))";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    protected <T> void executePreparedStatmentInsert(T t) {
        try (PreparedStatement preparedStatement = conn.prepareStatement(getSqlInsert())) {
            prepareStatmentInsertObject(preparedStatement, t);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    protected Emprunteur executePreparedStatmentSelect(long id) {
        try (PreparedStatement preparedStatement = conn.prepareStatement(getsqlSelect())) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Emprunteur emprunteur = resultSetGetObject(resultSet);
                return emprunteur;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    protected abstract <T> void prepareStatmentInsertObject(PreparedStatement pStatment, T t) throws SQLException;

    protected abstract String getSqlInsert();

    protected abstract <T> T resultSetGetObject(ResultSet resultSet) throws SQLException;

    protected abstract String getsqlSelect();
}
