package com.napier.sem;

//----------IMPORT DEPENDENCIES ---------------------------------

//import com.mysql.jdbc.log.NullLogger;

import java.sql.*;


public class App
{


    public static void main(String[] args)
    {
        // INSTANTIATE APPLICATION
        App a = new App();

        // Connect to database
        if (args.length < 1)
        {
            a.connect("localhost:3306");
        }
        else
        {
            a.connect(args[0]);
        }

        //Welcome loaded message for user

        System.out.println("Welcome to the SEM World Report Builder.");
        System.out.println("");
        System.out.println("");
        System.out.println("");

   //----------------------------------------------     -------------------










    // MAIN PROGRAM CODE GOES HERE ---------------------

    //All the countries in the world organised by largest population to smallest.
        a.loadCountryReport("World");
        a.loadCountryReport( "World", 10);
       // a.loadCountryReport("Continent", 20, "Asia");

        System.out.println("");
        System.out.println("");

        //All the countries in a continent organised by largest population to smallest.

//        a.CountryReport("Continent", "Asia", 0);
//        a.CountryReport("Continent", "Europe", 10);
//        a.CountryReport("Continent", "Africa", 10);

        System.out.println("");
        System.out.println("");

        //All the countries in a region organised by largest population to smallest.

//        a.CountryReport("Region", "Eastern Europe", 0);
//        a.CountryReport("Region", "Polynesia", 10);

        System.out.println("");
        System.out.println("");

        //The top N populated countries in the world where N is provided by the user.

//        a.CountryReport("World", "", 13);

        System.out.println("");
        System.out.println("");

        //The top N populated countries in a continent where N is provided by the user.

//        a.CountryReport("Continent", "Asia", 13);

        System.out.println("");
        System.out.println("");

        //The top N populated countries in a region where N is provided by the user.

//        a.CountryReport("Region", "Southern Europe", 13);


        System.out.println("");
        System.out.println("");

        //CITIES REPORTS

//        All the cities in the world organised by largest population to smallest.



//        All the cities in a continent organised by largest population to smallest.
//        All the cities in a region organised by largest population to smallest.
//        All the cities in a country organised by largest population to smallest.
//        All the cities in a district organised by largest population to smallest.
//        The top N populated cities in the world where N is provided by the user.
//            The top N populated cities in a continent where N is provided by the user.
//        The top N populated cities in a region where N is provided by the user.
//            The top N populated cities in a country where N is provided by the user.
//        The top N populated cities in a district where N is provided by the user.
//            All the capital cities in the world organised by largest population to smallest.
//        All the capital cities in a continent organised by largest population to smallest.
//            All the capital cities in a region organised by largest to smallest.
//            The top N populated capital cities in the world where N is provided by the user.
//            The top N populated capital cities in a continent where N is provided by the user.
//            The top N populated capital cities in a region where N is provided by the user.
//            The population of people, people living in cities, and people not living in cities in each continent.
//        The population of people, people living in cities, and people not living in cities in each region.
//        The population of people, people living in cities, and people not living in cities in each country.
//        Additionally, the following information should be accessible to the organisation:
//
//        The population of the world.
//            The population of a continent.
//        The population of a region.
//            The population of a country.
//        The population of a district.
//            The population of a city.
//        Finally, the organisation has asked if it is possible to provide the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:
//
//        Chinese.
//                English.
//                Hindi.
//                Spanish.
//                Arabic.
//                Country Report
//
//        A country report requires the following columns:
//
//    Code.
//            Name.
//            Continent.
//            Region.
//            Population.
//            Capital.
//            City Report
//
//        A city report requires the following columns:
//
//            Name.
//            Country.
//            District.
//            Population.
//            Capital
//            City Report
//
//        A capital city report requires the following columns:
//
//        Name.
//                Country.
//                Population.
//                Population Report
//
//        For the population reports, the following information is requested:
//
//        The name of the continent/region/country.
//            The total population of the continent/region/country.
//            The total population of the continent/region/country living in cities (including a %).
//            The total population of the continent/region/country not living in cities (including a %).









//        a.CountryReport("Continent", "Asia", 10);
//        System.out.println("");
//        System.out.println("");
//        a.CountryReport("Region", "Northern Africa" , 10);



     // DISCONNECT AND EXIT APPLICATION ------------------------

        // Disconnect from database
        a.disconnect();
        System.exit(0);
    }

    /////////////////////////////////////////// CLASSES AND METHODS  /////////////////////////////////////////
    /**
     * Connection to MySQL database.
     */
    public Connection con = null;


    public void loadCountryReport (String v_where){

        App b = new App();

        // Connect to database
        b.connect("localhost:33060");

        b.CountryReport( v_where , 0, "");

    }

    public void loadCountryReport (String v_where, int limit){
        App b = new App();

        // Connect to database
        b.connect("localhost:33060");

        b.CountryReport( v_where , limit , "");

    }

    public void loadCountryReport (String v_where, int limit, String v_equals){
        App b = new App();

        // Connect to database
        b.connect("localhost:33060");

        b.CountryReport( v_where , limit, v_equals);

    }

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 3;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }




    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }


    // WORLD SECTION ----------------------------------------------------------

    // GWT COUNTRY DATA

    public Country getCountry(String Code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement - CHN HARD CODED FOR TEST PURPOSES
            String strSelect =
                    "SELECT name, continent, capital, population "
                            + "FROM country "
                            + "WHERE Code = '"+Code+"'";         // + ID;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);


            // Return new country if valid.
            // Check one is returned
            if (rset.next())
            {
                Country ctr = new Country();
                ctr.Name = rset.getString("name");
                ctr.Continent = rset.getString("continent");
                ctr.Capital = rset.getString("capital");
                ctr.Population = rset.getInt("population");
                return ctr;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    // DISPLAY COUNTRY DATA

    public void displayCountry(Country ctr)
    {
        if (ctr != null)
        {
            System.out.println(

                         "Country: " +  ctr.Name + "\n"
                       + "Capital: "  + ctr.Capital + "\n"
                       + "Continent: " + ctr.Continent + "\n"
                       + "Population: " + ctr.Population + "\n");
        }
    }

    public void CountryReport(String v_where, int Limit, String v_equals ) {

        {
            try {
                // Create an SQL statement
                Statement stmt1 = con.createStatement();
                System.out.println("Showing top " + Limit + " results by population where " + v_where + " equals " + v_equals + ".");
                // Create string for SQL statement - CHN HARD CODED FOR TEST PURPOSES
                String strSelect =
                        "Select code" +
                                ", ctr.name" +
                                ", ctr.continent" +
                                ", ctr.region" +
                                ", ctr.population" +
                                ", cty.name as capital " +
                                "from country ctr " +
                                "LEFT OUTER JOIN city cty " +
                                "ON ctr.capital = cty.ID ";

                if (v_where == "Continent" && v_equals != "") {
                    strSelect = strSelect + " WHERE ctr." + v_where + " = '" + v_equals +
                            "' ORDER BY ctr." + v_where + ", ctr.population DESC ";
                }

                if (v_where == "Region") {
                    strSelect = strSelect + " WHERE ctr." + v_where + " = '" + v_equals +
                            "' ORDER BY ctr." + v_where + ", ctr.population DESC ";
                }
                if(v_where == "World") {
                    strSelect = strSelect  +
                            " ORDER BY ctr.population DESC ";
                }

                    if (Limit > 0) {
                        strSelect = strSelect + " LIMIT " + Limit + ";";

                    }



                    System.out.println(strSelect);


                    // Execute SQL statement
                    ResultSet rset = stmt1.executeQuery(strSelect);


                    // Return new country if valid.
                    // Check one is returned
                    while (rset.next()) {
                        Country ctr = new Country();
                        City cty = new City();
                        ctr.Name = rset.getString("name");
                        ctr.Continent = rset.getString("continent");
                        cty.Name = rset.getString("capital");
                        ctr.Population = rset.getInt("population");
                        ctr.Region = rset.getString("region");

                        System.out.println(ctr.Name + "\t" + ctr.Continent +
                                "\t" + cty.Name + "\t" + ctr.Population +
                                "\t" + ctr.Region);
                    }

                }
            catch(Exception e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Failed to get country details");
                    // return null;
                }
                //System.out.println(strSelect);
            }

        }


    private void CityReport(String v_where, String v_equals, int Limit ) {

        {
            try {
                // Create an SQL statement
                Statement stmt = con.createStatement();
                System.out.println("Showing top " + Limit + " results by population where " + v_where + " equals " + v_equals + ".");
                // Create string for SQL statement - CHN HARD CODED FOR TEST PURPOSES
                String strSelect =
                        "Select code" +
                                ", ctr.name" +
                                ", ctr.continent" +
                                ", ctr.region" +
                                ", ctr.population" +
                                ", cty.name as capital " +
                                "from country ctr " +
                                "LEFT OUTER JOIN city cty " +
                                "ON ctr.capital = cty.ID ";

                if (v_where == "Continent" && v_equals != "") {
                    strSelect = strSelect + " WHERE ctr." + v_where + " = '" + v_equals +
                            "' ORDER BY ctr." + v_where + ", ctr.population DESC ";
                }

                if (v_where == "Region") {
                    strSelect = strSelect + " WHERE ctr." + v_where + " = '" + v_equals +
                            "' ORDER BY ctr." + v_where + ", ctr.population DESC ";
                }
                if(v_where == "World") {
                    strSelect = strSelect  +
                            " ORDER BY ctr.population DESC ";
                }

                if (Limit > 0) {
                    strSelect = strSelect + " LIMIT " + Limit + ";";

                }



                System.out.println(strSelect);


                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);


                // Return new country if valid.
                // Check one is returned
                while (rset.next()) {
                    Country ctr = new Country();
                    City cty = new City();
                    ctr.Name = rset.getString("name");
                    ctr.Continent = rset.getString("continent");
                    cty.Name = rset.getString("capital");
                    ctr.Population = rset.getInt("population");
                    ctr.Region = rset.getString("region");

                    System.out.println(ctr.Name + "\t" + ctr.Continent +
                            "\t" + cty.Name + "\t" + ctr.Population +
                            "\t" + ctr.Region);
                }

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get country details");
                // return null;
            }
            //System.out.println(strSelect);
        }

    }





}