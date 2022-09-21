import DB.Facade;
import Entitet.Bog;
import MineUtil.BrugerInput;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws SQLException
    {
        // write your code here


        List<Bog> bogList = null;


        while (true) {

            switch (BrugerInput.getString("hvad ønsker du")) {

                case "opret bog":
                    Bog bog = new Bog(BrugerInput.getString("angiv title"), BrugerInput.getString("angiv forfatter"));
//                    System.out.println("du har nu oprettet bogen : " + Facade.opretBog(bog).toString());
                    bogList.add(Facade.opretBog(bog));
                    break;

                case "hent bøger":
                    bogList = Facade.HentBøger();
                    udskriv(bogList);
                    break;
                case "slet bog":
                    System.out.println(Facade.sletBog(BrugerInput.getInt("angiv bog id")));
                    break;
                case "vis bogliste":
                    if (bogList == null) {
                        System.out.println("du skal hente bogliste fra database først");
                        break;
                    }
                    udskriv(bogList);
                    break;


            }


        }

    }


    public static void udskriv (List<Bog> objectList ) {

        for (Bog bog : objectList) {

            System.out.println(bog.toString());
        }



    }
}
