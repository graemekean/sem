import com.napier.sem.App;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class MyTest
{
    @Test
    void unitTest()
    {
        //assertEquals(5, 5;

        //TESTING THE INTEGRITY OF OUR ARGUMENTS AND FEEDING THEM INCORRECT VALUES



        App a = new App();

        // Connect to database
        a.connect();




        //
        a.CountryReport("Continent", "Asia", 10);


    }
}






//    Select code,
//ctr.name,
//        ctr.continent,
//        ctr.region,
//        ctr.population,
//        cty.name as Capital
//        from country ctr
//        LEFT OUTER JOIN city cty
//        ON ctr.capital = cty.ID WHERE continent = Asia ORDER BY 3, 5 DESC;
//





//        -- All the countries in the world organised by largest population to smallest.
//        desc country;
//        desc city;
//
//        -- Code.
//        -- Name.
//        -- Continent.
//        -- Region.
//        -- Population.
//        -- Capital.
//        -- City Report
//
//        SELECT COUNT(*) FROM COUNTRY;
//
//        -- SELECT COUNT(*) FROM (
//        Select Code
//        , ctr.Name
//        , ctr.Continent
//        , ctr.Region
//        , ctr.Population
//        , cty.Name as Capital
//        from COUNTRY ctr
//        LEFT OUTER JOIN CITY cty
//        ON ctr.Capital = cty.ID
//        ORDER BY 5 DESC;
//        -- LIMIT NVL(null, 10);
//        -- ) as COUNTRY;
//
//
//        -- All the countries in a continent organised by largest population to smallest.
//
//
//        Select Code
//        , ctr.Name
//        , ctr.Continent
//        , ctr.Region
//        , ctr.Population
//        , cty.Name as Capital
//        from COUNTRY ctr
//        LEFT OUTER JOIN CITY cty
//        ON ctr.Capital = cty.ID
//        ORDER BY 3, 5 DESC;
//
//        -- All the countries in a region organised by largest population to smallest.
//
//        Select Code
//        , ctr.Name
//        , ctr.Continent
//        , ctr.Region
//        , ctr.Population
//        , cty.Name as Capital
//        from COUNTRY ctr
//        LEFT OUTER JOIN CITY cty
//        ON ctr.Capital = cty.ID
//        ORDER BY 4, 5 DESC;
//
//        -- The top N populated countries in the world where N is provided by the user.
//
//        Select Code
//        , ctr.Name
//        , ctr.Continent
//        , ctr.Region
//        , ctr.Population
//        , cty.Name as Capital
//        from COUNTRY ctr
//        LEFT OUTER JOIN CITY cty
//        ON ctr.Capital = cty.ID
//        ORDER BY 5 DESC
//        LIMIT 10 ;
//
//        -- The top N populated countries in a continent where N is provided by the user.
//
//        Select Code
//        , ctr.Name
//        , ctr.Continent
//        , ctr.Region
//        , ctr.Population
//        , cty.Name as Capital
//        from COUNTRY ctr
//        LEFT OUTER JOIN CITY cty
//        ON ctr.Capital = cty.ID
//        WHERE CONTINENT = 'Asia'
//        ORDER BY 3, 5 DESC
//        LIMIT 10 ;
//
//        -- The top N populated countries in a region where N is provided by the user.
//
//
//
//        -- All the cities in the world organised by largest population to smallest.
//
//
//        -- All the cities in a continent organised by largest population to smallest.
//
//
//        -- All the cities in a region organised by largest population to smallest.
//
//
//        -- All the cities in a country organised by largest population to smallest.
//        -- All the cities in a district organised by largest population to smallest.
//        -- The top N populated cities in the world where N is provided by the user.
//        -- The top N populated cities in a continent where N is provided by the user.
//        -- The top N populated cities in a region where N is provided by the user.
//        -- The top N populated cities in a country where N is provided by the user.
//        -- The top N populated cities in a district where N is provided by the user.
//        -- All the capital cities in the world organised by largest population to smallest.
//        -- All the capital cities in a continent organised by largest population to smallest.
//        -- All the capital cities in a region organised by largest to smallest.
//        -- The top N populated capital cities in the world where N is provided by the user.
//        -- The top N populated capital cities in a continent where N is provided by the user.
//        -- The top N populated capital cities in a region where N is provided by the user.
//        -- The population of people, people living in cities, and people not living in cities in each continent.
//        -- The population of people, people living in cities, and people not living in cities in each region.
//        -- The population of people, people living in cities, and people not living in cities in each country.
//        -- Additionally, the following information should be accessible to the organisation:
//
//        -- The population of the world.
//        -- The population of a continent.
//        -- The population of a region.
//        -- The population of a country.
//        -- The population of a district.
//        -- The population of a city.
//        -- Finally, the organisation has asked if it is possible to provide the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:
//
//        -- Chinese.
//        -- English.
//        -- Hindi.
//        -- Spanish.
//        -- Arabic.
//        -- Country Report
//
//        -- A country report requires the following columns:
//
//        -- Code.
//        -- Name.
//        -- Continent.
//        -- Region.
//        -- Population.
//        -- Capital.
//        -- City Report
//
//        -- A city report requires the following columns:
//
//        -- Name.
//        -- Country.
//        -- District.
//        -- Population.
//        -- Capital City Report
//
//        -- A capital city report requires the following columns:
//
//        -- Name.
//        -- Country.
//        -- Population.
//        -- Population Report
//
//        -- For the population reports, the following information is requested:
//
//        -- The name of the continent/region/country.
//        -- The total population of the continent/region/country.
//        -- The total population of the continent/region/country living in cities (including a %).
//        -- The total population of the continent/region/country not living in cities (including a %).