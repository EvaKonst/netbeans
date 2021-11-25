/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;
import javax.swing.*;

public class CheckConnection 
{

    public static String url="jdbc:sqlserver://DESKTOP-S3C9AEB:1433;databaseName=dlab1;user=admin1;password=EvaeisaiGTP*;encrypt=true;trustServerCertificate=true;loginTimeout=30;";
    // Connect to your database.
    // Replace server name, username, and password with your credentials

    
    public CheckConnection()
    {
	try
	{
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");       
	    
	}
	catch(Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }    
    
    
    
}
