/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg233final2.pkg0;

import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public abstract class Service {
//changed private to protected in order to use it in child class

    protected DataOutputStream responseWriter;

    public Service(DataOutputStream responseWriter) {
        this.responseWriter = responseWriter;
    }

    public abstract void doWork();
}

class SQLSelectService extends Service {

    private String requestString;
    private String SQLCommand;
    private String queryResult;

    public SQLSelectService(DataOutputStream responseWriter, String requestString) {

        super(responseWriter);
        this.requestString = requestString;
    }

    public void setSQLCommand() {

        String criteria = "";
        String fieldName = "";
        //pick up the criteria and fieldname
        String trimForCriteria = requestString.replace("WebRoot\\doSERVICE?Criteria=", "#").replace("&F", "#");
        String[] arr = trimForCriteria.split("#");
        criteria = "'" + arr[1] + "'";
        String trimForField = requestString.replace("Field=", "#").replace("&Sub", "#");
        String[] arr2 = trimForField.split("#");
        fieldName = arr2[1];

        SQLCommand = "SELECT * FROM EMPLOYEE WHERE " + fieldName + "=" + criteria + "";
        printOutLog("SQL command-->" + SQLCommand);
    }

    public void doWork() {
        //Get connection to sql and get data
        //calls setSQLCommand

        setSQLCommand();
        //This method connects to an Oracle Database
        Statement stmt = null;
        ResultSet rset = null;
        ResultSetMetaData rsmd = null;
        Connection conn = null;
        Account myAccount = new Account();
        //promp a option for choosing location
        String location = JOptionPane.showInputDialog("1. school \n2.home");
        int optCon = Integer.parseInt(location);
        //get account name and password from account class
        myAccount.getCon(optCon);
        String conString = myAccount.getConStr();
        String strPassword = myAccount.getPassWord();
        String accountName = myAccount.getAccountName();

        String outputPage = "";
        String errorMessage = "";
        String queryRawResults = "";
        String HTMLHeader = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
                + "    <title>Document</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <h1 style=\"text-align: center\">EMLOYEE TABLE</h1>"
                + "    <table border=\"1\" cellspacing=\"0\">\n"
                + "            <tr>"
                + "            <td>Employee ID</td>\n"
                + "            <td>SIN Number</td>\n"
                + "            <td>Last Name</td>\n"
                + "            <td>First Name</td>\n"
                + "            <td>Street</td>\n"
                + "            <td>City</td>\n"
                + "            <td>Province</td>\n"
                + "            <td>Postal Code</td>\n"
                + "            <td>Job Code</td>\n"
                + "            <td>Income tax</td>\n"
                + "            <td>Birth Date</td>\n"
                + "            <td>Hire Date</td>\n"
                + "            <td>Job Code Date</td>"
                + "            </tr>";
        String HTMLFooter = " </table>\n"
                + "\n"
                + "</body>\n"
                + "</html>";
        try {
            //connect to sql
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(conString, accountName, strPassword);
            stmt = conn.createStatement();
            rset = stmt.executeQuery(SQLCommand);
            rsmd = rset.getMetaData();
            //since we probably will have several rows of query results, so I use a list to collect the results
            List<String> resultRowList = new ArrayList<>();

            int columnCount = rsmd.getColumnCount();
            String resultByRow = "";
            queryResult = "";

            while (rset.next()) {
                for (int i = 0; i < columnCount; i++) {
                    //this is the raw data from database without html styling
                    queryRawResults += rset.getString(i + 1);
                    //get query result by colomn and add them together into several rows through loop
                    resultByRow += "<td>" + (rset.getString(i + 1) + "</td>");
                }
                //add all the rows into the row list
                resultRowList.add("<tr>" + resultByRow + "</tr>");
                resultByRow = "";

            }
            //assign all the rows into one string.
            for (String st : resultRowList) {
                queryResult += st;
            }

            //if no result was found, print out error message
            if (queryRawResults.equals("")) {
                errorMessage = "No information was found in Database! Please enter valid information!";
                printOutLog("Error Message (SQL no information)-->");
                outputPage = HTMLHeader + "</table><p>" + errorMessage + "<p></body></html>";
            } else {
                //if reults were found, print out the result into table
                printOutLog("\r\nQuery Result-->" + queryRawResults + "\r\n");
                outputPage = HTMLHeader + queryResult + HTMLFooter;
            }
            //use responseWriter which is pagewriter to write out the result page
            responseWriter.writeBytes(outputPage);
            GuiServer.closeAll(responseWriter);

        } catch (SQLException sqle) {
             //if data not valid, print out error message
            errorMessage = "No information was found in Database! Please enter valid information!";
            printOutLog("Error Message (SQL no information)-->");
            outputPage = HTMLHeader + "</table><p>" + errorMessage + "<p></body></html>";
            try {
                responseWriter.writeBytes(outputPage);
            } catch (IOException ex) {
                printOutLog(ex.toString());
            }
            GuiServer.closeAll(responseWriter);
            System.out.println("A SQL error has occurred.");
            printOutLog(sqle.toString());
        } catch (Exception E) {
             //if any other error hapened, print out error message
            errorMessage = "No information was found in Database! Please enter valid information!";
            printOutLog("Error Message (SQL no information)-->");
            outputPage = HTMLHeader + "</table><p>" + errorMessage + "<p></body></html>";
            try {
                responseWriter.writeBytes(outputPage);
            } catch (IOException ex) {
                printOutLog(ex.toString());
            }
            GuiServer.closeAll(responseWriter);
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!" + E);
            printOutLog(E.toString());
            try {
                rset.close();
                stmt.close();
                conn.close();
            } catch (Exception E2) {
                System.out.println("Warning.");
                System.out.println("Failed to free up system resources");
                printOutLog(E2.toString());
            }

        }

    }

//this printout function is for printing out the log to file
    public void printOutLog(String outputRequest) {
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            GuiServer.getRequestOutput().append("\r\n" + timeStamp + "\n" + outputRequest + "\n");
            GuiServer.requestOutput.setCaretPosition(GuiServer.requestOutput.getText().length());
            FileWriter fw = new FileWriter("WebRoot\\SQLLog.txt", true);
            fw.write("\r\n" + timeStamp + "\n" + outputRequest + "\n");
            GuiServer.closeAll(fw);

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

}
