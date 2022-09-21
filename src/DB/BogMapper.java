package DB;

import Entitet.Bog;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BogMapper
{


    public static Bog opretBog(Bog bog) throws SQLException
    {
        String sql = "INSERT INTO BogTabel (Forfatter , Title ) VALUES (?, ?)";

        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            try {

                ps.setString(1, bog.getForfatter());
                ps.setString(2, bog.getTitle());
                ps.executeUpdate();

                ResultSet resultSet = ps.getGeneratedKeys();
                resultSet.next();

                bog.setBogId(resultSet.getInt(1));
//                System.out.println(bog.toString());


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return bog;

        }


    }

    public static List<Bog> hentBøger() throws SQLException
    {
        List<Bog> bogList = new LinkedList<>();

        String sql = "select *  from BogTabel";

        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int idBog = resultSet.getInt("idBogTabel");
                String forfatter = resultSet.getString("Forfatter");
                String title = resultSet.getString("title");

                bogList.add(new Bog(idBog, title, forfatter));


            }


            return bogList;
        }
    }


}
