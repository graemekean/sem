package com.napier.sem;

//----------IMPORT DEPENDENCIES ---------------------------------

import com.mysql.jdbc.log.NullLogger;

import java.sql.*;


public class App
{


    public static void main(String[] args)
    {
        // INSTANTIATE APPLICATION
        App a = new App();

        // Connect to database
        a.connect();

        //Welcome loaded message for user

        System.out.println("Welcome to the SEM World Report Builder.");



    // MAIN PROGRAM CODE GOES HERE ---------------------



















        a.CountryReport("Continent", "Asia", 10);
        System.out.println("");
        System.out.println("");
        a.CountryReport("Region", "Northern Africa" , 10);



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

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
                //Deal with exceptions
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

    public void CountryReport(String v_where, String v_equals, int Limit ) {

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

                if (v_where == "Continent") {
                    strSelect = strSelect + " WHERE ctr." + v_where + " = '" + v_equals +
                            "' ORDER BY ctr." + v_where + ", ctr.population DESC ";
                }

                if (v_where == "Region") {
                    strSelect = strSelect + " WHERE ctr." + v_where + " = '" + v_equals +
                            "' ORDER BY ctr." + v_where + ", ctr.population DESC ";
                }

                    if (Limit > 0) {
                        strSelect = strSelect + " LIMIT " + Limit + ";";

                    }
                    else
                    {
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


}