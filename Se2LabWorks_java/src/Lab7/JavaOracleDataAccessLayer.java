
package Lab7;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntArrayData;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;



public class JavaOracleDataAccessLayer {
    static String conString;
    static String strPassword;
    static String schoolAccount;
    static Account myAccount = new Account();
   
    static Scanner k = new Scanner(System.in);
    static int[] emptyArray;
    static JavaOracleDataAccessLayer instLayer = new JavaOracleDataAccessLayer();
    public static void main(String[] args) {
        getCon();
        conString = myAccount.getConStr();
        strPassword = myAccount.getPassWord();
        schoolAccount = myAccount.getAccountName();
        int choice = 0;
        while (choice != 6) {
            choice =instLayer.showMenu();
            instLayer.executeChoice(choice);
        }
     
    }
    public int showMenu() {
        int choice;
        System.out.println("1.Display Job IDs, descriptions and pay rates.\n"
                + "2.Display employee IDs, first name, last name, and job description\n"
                + "3.Add a Job\n"
                + "4.Edit a job by list number\n"
                + "5.Edit a person by list number\n"
                + "6. Exit\n"
                + "Choice:");
         System.out.println("------------------------------");
        choice = k.nextInt();
        return choice;
    }

    public void executeChoice(int choice) {

        switch (choice) {
            case 1:
                instLayer.excuteQuery("select jobcode, description, payrate from job order by jobcode");
                break;
            case 2:
                instLayer.excuteQuery("select employee.empId, employee.firstName, employee.lastName, "
                                + "job.description from employee inner join job on employee.jobcode = job.jobcode order by employee.empId");
                break;
            case 3:
                instLayer.menuOption3();
                break;
            case 4:
                instLayer.menuOption4();
                break;
            case 5:
                instLayer.menuOption5();
                break;
            case 6:
                break;
        }
    }
    
  public void menuOption3(){
      System.out.println("Please enter a new job code: ");
      int newCode = k.nextInt();
      System.out.println("Please enter a new job description: ");
      String newDescription = null;
      k.nextLine();
      newDescription = k.nextLine();
      System.out.println("Please enter a new pay rate: ");
      float newPayrate = k.nextFloat();
      System.out.println("Please enter a new pay class: ");
      String newPayClass = k.next();
      instLayer.excecuteUpdate("insert into job (JobCode, Description, PayRate, PayClass)"
                                + "VALUES ("+newCode+",'"+newDescription+"', "+newPayrate+", '"+newPayClass+"')");
  }
    //test
   public void menuOption4(){
       instLayer.excuteQuery("select * from job order by jobcode");
       System.out.println("Please choose a list number for editing: ");
       int opt = k.nextInt();
       Statement stmt=null; 
        ResultSet rset=null; 
        ResultSetMetaData rsmd=null;
        Connection conn=null;
        try{
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(conString, schoolAccount, strPassword); //your username and password here
            stmt = conn.createStatement();
            rset = stmt.executeQuery("select count(*) from job");
            rset.next();
            int size = rset.getInt(1);
            int[] jobCodes = new int[size];
            
            rset = stmt.executeQuery("select jobcode from job order by jobcode");
            rsmd = rset.getMetaData();
            int recordNum =0;
             while (rset.next()){
//                System.out.print((recordNum) + " ");
                jobCodes[recordNum] = Integer.valueOf(rset.getString("jobcode"));
                recordNum++;
                }     
             emptyArray = jobCodes;
             for (int i = 1; i <= emptyArray.length; i++) {
             if(opt == i){
                System.out.println("1. Job description\n2. Pay rate\nPlease choose which one you want to edit: ");
                int opt2 = k.nextInt();
                if(opt2==1){
                    System.out.println("Please enter a new description: ");
                    String newDescription = k.next();
                    instLayer.excecuteUpdate("update job set Description = '"+newDescription+"' where jobcode = "+emptyArray[i-1]+"");
                }
                 if (opt2 ==2) {
                     System.out.println("Please enter a new pay rate: ");
                     float newPay = k.nextFloat();
                     instLayer.excecuteUpdate("update job set payrate = "+newPay+" where jobcode = "+emptyArray[i-1]+"");
                 }
            }
       }
            stmt.close();
        }
        catch(SQLException sqle){
            System.out.println("A SQL error has occurred.");
            System.out.println(sqle.toString());
        }
        catch(Exception E){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!"+E);	
            try
	{
            rset.close();
            stmt.close();
            conn.close();
	}
	catch(Exception E2)
	{
            System.out.println("Warning.");
            System.out.println("Failed to free up system resources");
        }
        }   
   }
   
   public void menuOption5(){
       instLayer.excuteQuery("select * from employee order by empId");
       System.out.println("Please choose a list number for editing: ");
       int opt = k.nextInt();
       Statement stmt=null; 
        ResultSet rset=null; 
        ResultSetMetaData rsmd=null;
        Connection conn=null;
        try{
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(conString, schoolAccount, strPassword); //your username and password here
            stmt = conn.createStatement();
            rset = stmt.executeQuery("select count(*) from employee");
            rset.next();
            int size = rset.getInt(1);
            int[] empIds = new int[size];
            
            rset = stmt.executeQuery("select empId from employee order by empId");
            rsmd = rset.getMetaData();
            
            int recordNum =0;
             while (rset.next()){
                empIds[recordNum] = Integer.valueOf(rset.getString("empId"));
                recordNum++;
                }     
             emptyArray = empIds;
             for (int i = 1; i <= emptyArray.length; i++) {
             if(opt == i){
                System.out.println("1. first name\n2. last name\n3. Job description\nPlease choose which one you want to edit: ");
                int opt2 = k.nextInt();
                if(opt2==1){
                    System.out.println("Please enter a new first name: ");
                    String newFirstname = k.next();
                    instLayer.excecuteUpdate("update employee set firstname = '"+newFirstname+"' where empId = "+emptyArray[i-1]+"");
                }
                 if (opt2 ==2) {
                    System.out.println("Please enter a new last name: ");
                    String newLastname = k.next();
                    instLayer.excecuteUpdate("update employee set lastname = '"+newLastname+"' where empId = "+emptyArray[i-1]+"");
                 }
                 if (opt2 ==3) {
                     instLayer.excuteQuery("select jobcode, description from job order by jobcode");
                     rset = stmt.executeQuery("select count(*) from job");
                    rset.next();
                    int sizeJob = rset.getInt(1);
                    int[] jobCodes = new int[sizeJob];

                    rset = stmt.executeQuery("select jobcode from job order by jobcode");
                    rsmd = rset.getMetaData();
                    System.out.println("Please choose a list number for the job description: ");
                        int optDe = k.nextInt();
                    int recordNum2 =0;
                     while (rset.next()){
                        jobCodes[recordNum2] = Integer.valueOf(rset.getString("jobcode"));
                        recordNum2++;
                        }     
                     for (int j = 1; j <= jobCodes.length; j++) {
                          if(optDe == j){
                              instLayer.excecuteUpdate("update employee set jobcode = "+jobCodes[j-1]+" where empId = "+emptyArray[i-1]+"");
                          }
                        }
//                    System.out.println("Please enter a new job description: ");
//                    String newDescription = k.next();
//                    instLayer.excecuteUpdate("update job set job.Description = '"+newDescription+"' where employee.empId = "+emptyArray[i-1]+" inner join employee on employee.jobcode = job.jobcode");
                 }
            }
       }
            stmt.close();
        }
        catch(SQLException sqle){
            System.out.println("A SQL error has occurred.");
            System.out.println(sqle.toString());
        }
        catch(Exception E){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!"+E);	
            try
	{
            rset.close();
            stmt.close();
            conn.close();
	}
	catch(Exception E2)
	{
            System.out.println("Warning.");
            System.out.println("Failed to free up system resources");
        }
        }   
       
   }
   
   
   public void excecuteUpdate(String sql){
       Statement stmt = null;
       ResultSet rset = null;
//       ResultSetMetaData rsmd = null;
       Connection conn = null;
       try{
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(conString, schoolAccount, strPassword); //your username and password here
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
            rset.next();
            stmt.close();
        }
        catch(SQLException sqle){
            System.out.println("A SQL error has occurred.");
            System.out.println(sqle.toString());
        }
        catch(Exception E){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!"+E);	}
        
        finally{
            try
	{
            rset.close();
            stmt.close();
            conn.close();
	}
	catch(Exception E2)
	{
            System.out.println("Warning.");
            System.out.println("Failed to free up system resources");
        }
        }
        }
       
   
   public void getJobTable(){
        Statement stmt=null; 
        ResultSet rset=null; 
        ResultSetMetaData rsmd=null;
        Connection conn=null;
        try{
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(conString, schoolAccount, strPassword); //your username and password here
            stmt = conn.createStatement();
            rset = stmt.executeQuery("select jobcode, description, payrate from job order by jobcode");
            rset.next();
            rsmd = rset.getMetaData();
            int columnCount = rsmd.getColumnCount();
            int recordNum =1;
             while (rset.next()){
                 System.out.print(recordNum);
                 recordNum++;
                for(int i = 0; i< columnCount; i++ )
                {
                    System.out.print(" "+rset.getString(i+1));    
                }
                System.out.println ("\n===");  
                } 
            stmt.close();
        }
        catch(SQLException sqle){
            System.out.println("A SQL error has occurred.");
            System.out.println(sqle.toString());
        }
        catch(Exception E){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!"+E);	
            try
	{
            rset.close();
            stmt.close();
            conn.close();
	}
	catch(Exception E2)
	{
            System.out.println("Warning.");
            System.out.println("Failed to free up system resources");
        }
        }
   } 

   public void employeeArray(){
       System.out.println("Employee Number: ");
        Statement stmt=null; 
        ResultSet rset=null; 
        ResultSetMetaData rsmd=null;
        Connection conn=null;
        try{
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(conString, schoolAccount, "bekind"); //your username and password here
            stmt = conn.createStatement();
            rset = stmt.executeQuery("select count(*) from employee");
            rset.next();
            int size = rset.getInt(1);
            int[] empIds = new int[size];
            
            rset = stmt.executeQuery("select empId from employee order by empId");
            rsmd = rset.getMetaData();
            
            int recordNum =0;
             while (rset.next()){
                System.out.print((recordNum+1) + " ");
                empIds[recordNum] = Integer.valueOf(rset.getString("empId"));
                System.out.println (empIds[recordNum]);  
                recordNum++;
               
                }   
            stmt.close();
        }
        catch(SQLException sqle){
            System.out.println("A SQL error has occurred.");
            System.out.println(sqle.toString());
        }
        catch(Exception E){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!"+E);	
            try
	{
            rset.close();
            stmt.close();
            conn.close();
	}
	catch(Exception E2)
	{
            System.out.println("Warning.");
            System.out.println("Failed to free up system resources");
        }
        }
   }
    public void excuteQuery(String sql) {
        Statement stmt=null; 
        ResultSet rset=null; 
        ResultSetMetaData rsmd=null;
        Connection conn=null;
        try{
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(conString, schoolAccount, strPassword); //your username and password here
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
            rsmd = rset.getMetaData();
            int columnCount = rsmd.getColumnCount();
            int recordNum =1;
             while (rset.next()){
                 System.out.print(recordNum);
                 recordNum++;
                for(int i = 0; i< columnCount; i++ )
                {
                    System.out.print(" "+rset.getString(i+1));    
                }
                System.out.println ("\n===");  
                }      
        stmt.close();
        }
        catch(SQLException sqle){
            System.out.println("A SQL error has occurred.");
            System.out.println(sqle.toString());
        }
        catch(Exception E){
            System.out.println("Unknown error has occurred.");
            System.out.println("Exception!"+E);	
            try
	{
            rset.close();
            stmt.close();
            conn.close();
	}
	catch(Exception E2)
	{
            System.out.println("Warning.");
            System.out.println("Failed to free up system resources");
        }

		
}

    }
    public static String getPassword() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter a password:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "The title",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);

        if (option == 0) // pressing OK button
        {
            char[] password = pass.getPassword();
            
            strPassword = new String(password);
        }

        return strPassword;
    }
    
    public static void getCon(){
        System.out.println("1 school\n2 home");
        int optCon = k.nextInt();
        if(optCon==1){
            myAccount.setConStr("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD");
            myAccount.setAccountName("cistu024");
        }
        else if(optCon ==2){
            myAccount.setConStr("jdbc:oracle:thin:@localhost:1521:orcl");
            myAccount.setAccountName("c##nancy");
        }
    }
    
    public static String getAccount() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter an account:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "The title",
                JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[1]);

        if (option == 0) // pressing OK button
        {
            char[] password = pass.getPassword();
            schoolAccount = new String(password);
        }

        return schoolAccount;
    }
    //   public void createIntArray(String selectSize, String selectInt, String arrayValue){
//       Statement stmt=null; 
//        ResultSet rset=null; 
//        ResultSetMetaData rsmd=null;
//        Connection conn=null;
//        try{
//            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@bisoracle.siast.sk.ca:1521:ACAD", "cistu024", "bekind"); //your username and password here
//            stmt = conn.createStatement();
//            rset = stmt.executeQuery(selectSize);
//            rset.next();
//            int size = rset.getInt(1);
//            int[] arrayInt = new int[size];
//            
//            rset = stmt.executeQuery(selectInt);
//            rsmd = rset.getMetaData();
//            
//            int recordNum =0;
//             while (rset.next()){
//                System.out.print((recordNum+1) + " ");
//                arrayInt[recordNum] = Integer.valueOf(rset.getString(arrayValue));
////                System.out.println (arrayInt[recordNum]);  
//                recordNum++;
//               
//                }   
//            stmt.close();
//
//        }
//        catch(SQLException sqle){
//            System.out.println("A SQL error has occurred.");
//            System.out.println(sqle.toString());
//        }
//        catch(Exception E){
//            System.out.println("Unknown error has occurred.");
//            System.out.println("Exception!"+E);	
//            try
//	{
//            rset.close();
//            stmt.close();
//            conn.close();
//	}
//	catch(Exception E2)
//	{
//            System.out.println("Warning.");
//            System.out.println("Failed to free up system resources");
//        }
//        }
//   }
}
