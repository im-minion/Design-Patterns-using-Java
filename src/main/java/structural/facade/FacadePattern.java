/*
 * Structural patterns provide different ways to create a class structure,
 * for example using inheritance and composition to create a large object from small objects.
 * */
package structural.facade;

import java.sql.Connection;

/*
 * Facade Pattern is used to help client applications to easily interact with the system.
 * Suppose we have an application with a set of interfaces to use MySql/Oracle database and to generate
 * different types of reports, such as HTML report, PDF report, etc.
 * So we will have a different set of interfaces to work with different types of databases.
 * Now a client application can use these interfaces to get the required database connection and generate reports.
 * But when the complexity increases or the interface behavior names are confusing,
 * the client application will find it difficult to manage it.
 * So we can apply Facade pattern here and
 * provide a wrapper interface on top of the existing interface to help client application
 * */
public class FacadePattern {
    public static void main(String[] args) {
        String tableName = "Employee";

        //generating MySql HTML report and Oracle PDF report WITHOUT USING Facade
        Connection con = MySqlHelper.getMySqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHTMLReport(tableName, con);

        Connection con1 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName, con1);

        //generating MySql HTML report and Oracle PDF report USING Facade
        HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
        HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
    }
}

// two helper interfaces viz MySqlHelper and OracleHelper.
class MySqlHelper {

    public static Connection getMySqlDBConnection() {
        //get MySql DB connection using connection parameters
        return null;
    }

    public void generateMySqlPDFReport(String tableName, Connection con) {
        //get data from table and generate pdf report
    }

    public void generateMySqlHTMLReport(String tableName, Connection con) {
        //get data from table and generate html report
    }
}

class OracleHelper {

    public static Connection getOracleDBConnection() {
        //get Oracle DB connection using connection parameters
        return null;
    }

    public void generateOraclePDFReport(String tableName, Connection con) {
        //get data from table and generate pdf report
    }

    public void generateOracleHTMLReport(String tableName, Connection con) {
        //get data from table and generate html report
    }

}

// Facade pattern interface
class HelperFacade {
    public static void generateReport(DBTypes dbType, ReportTypes reportType, String tableName) {
        Connection con;
        switch (dbType) {
            case MYSQL:
                con = MySqlHelper.getMySqlDBConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();
                switch (reportType) {
                    case HTML:
                        mySqlHelper.generateMySqlHTMLReport(tableName, con);
                        break;
                    case PDF:
                        mySqlHelper.generateMySqlPDFReport(tableName, con);
                        break;
                }
                break;
            case ORACLE:
                con = OracleHelper.getOracleDBConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType) {
                    case HTML:
                        oracleHelper.generateOracleHTMLReport(tableName, con);
                        break;
                    case PDF:
                        oracleHelper.generateOraclePDFReport(tableName, con);
                        break;
                }
                break;
        }
    }

    public enum DBTypes {
        MYSQL, ORACLE
    }

    public enum ReportTypes {
        HTML, PDF
    }
}