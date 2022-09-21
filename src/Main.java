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


        List<Bog> bogList = new LinkedList<>();


        while (true) {

            switch (BrugerInput.getString("hvad ønsker du")) {

                case "opret bog":
                    Bog bog = new Bog(BrugerInput.getString("angiv title"), BrugerInput.getString("angiv forfatter"));
                    System.out.println("du har nu oprettet bogen : " + Facade.opretBog(bog).toString());
                    break;
                case "hent bøger":
                    bogList = Facade.HentBøger();
                    udskriv(bogList);


            }


        }

    }


    public static void udskriv (List<Bog> objectList ) {

        for (Bog bog : objectList) {

            System.out.println(bog.toString());
        }



    }
}
