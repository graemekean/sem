package com.napier.sem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;

public class App
{

    private JButton button1;
    private JPanel panelMain;

    public App() {
        button1.addActionListener(e -> JOptionPane.showMessageDialog(null, "Hello there."));
    }

    public static void main(String[] args)
    {
        // INSTANTIATE APPLICATION
        App a = new App();
        // Connect to database
        a.connect();

        //Welcome loaded message for user

        System.out.println("Welcome to the SEM World Report Builder.");


        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



        System.out.println("Display info for China.");

        Country ctr = a.getCountry("CHN");
        // Display results
        a.displayCountry(ctr);




        // Disconnect from database
        a.disconnect();
        System.exit(0);
    }

    /////////////////////////////////////////// CLASSES AND METHODS  /////////////////////////////////////////
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

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

    public Employee getEmployee(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT emp_no, first_name, last_name "
                            + "FROM employees "
                            + "WHERE emp_no = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("emp_no");
                emp.first_name = rset.getString("first_name");
                emp.last_name = rset.getString("last_name");
                return emp;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }

    public void displayEmployee(Employee emp)
    {
        if (emp != null)
        {
            System.out.println(
                    emp.emp_no + " "
                            + emp.first_name + " "
                            + emp.last_name + "\n"
                            + emp.title + "\n"
                            + "Salary:" + emp.salary + "\n"
                            + emp.dept_name + "\n"
                            + "Manager: " + emp.manager + "\n");
        }
    }

    // WORLD SECTION


    public Country getCountry(String Code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, continent, capital, population "
                            + "FROM country "
                            + "WHERE Code = 'CHN'";         // + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            if (rset.next())
            {
                Country ctr = new Country();
                ctr.Name = rset.getString("name");
                ctr.Continent = rset.getString("continent");
                ctr.Capital = rset.getInt("capital");
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



    /////////////////////////////  ADD LOOP TO RETURN

//    public ArrayList<Country> getAllCountries()
//    {
//        try
//        {
//            // Create an SQL statement
//            Statement stmt = con.createStatement();
//            // Create string for SQL statement
//            String strSelect =
//                    "SELECT ctr.Name, ctr.capital, ctr.continent, cty.Name,  "
//                            + "FROM country ctr  , city cty "
//                            + " "
//                            + "ORDER BY employees.emp_no ASC";
//            // Execute SQL statement
//            ResultSet rset = stmt.executeQuery(strSelect);
//            // Extract employee information
//            ArrayList<Employee> employees = new ArrayList<Employee>();
//            while (rset.next())
//            {
//                Employee emp = new Employee();
//                emp.emp_no = rset.getInt("employees.emp_no");
//                emp.first_name = rset.getString("employees.first_name");
//                emp.last_name = rset.getString("employees.last_name");
//                emp.salary = rset.getInt("salaries.salary");
//                employees.add(emp);
//            }
//            return employees;
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//            System.out.println("Failed to get salary details");
//            return null;
//        }
//    }


//    public void input (String) {
//
//            Scanner input = new Scanner(System.in);
//
//            System.out.print("Enter an integer: ");
//            int number = input.nextInt();
//            System.out.println("You entered " + number);
//    }




}