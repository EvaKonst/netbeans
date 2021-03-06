/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;
import java.sql.*;
import javax.swing.*;
import static mainpackage.CheckConnection.url;
//import org.openqa.selenium.support.ui.Select;
//import org.apache.commons.dbutils.DbUtils;
//import ktanx.jdbc.dbutils;
//import com.ktanx.common.*;


/**
 *
 * @author Vasilis
 */
public class seeArticle extends javax.swing.JFrame
{

    /**
     * Creates new form seeArticle
     */
    public seeArticle()
    {
	initComponents();
	FillCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        seeBack = new javax.swing.JButton();
        articleSelectDB = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        AcceptArticle = new javax.swing.JButton();
        RejectArticle = new javax.swing.JButton();
        reviseArticle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ArticleTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        seeBack.setText("Back");
        seeBack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                seeBackActionPerformed(evt);
            }
        });

        articleSelectDB.setToolTipText("");
        articleSelectDB.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                articleSelectDBActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Article");

        AcceptArticle.setText("Accept");
        AcceptArticle.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AcceptArticleActionPerformed(evt);
            }
        });

        RejectArticle.setText("Reject");
        RejectArticle.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                RejectArticleActionPerformed(evt);
            }
        });

        reviseArticle.setText("Revise");
        reviseArticle.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                reviseArticleActionPerformed(evt);
            }
        });

        ArticleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String []
            {
                "Path", "Title", "Summary", "Pages", "Status", "Key Word", "Chief Editor Email", "Category ID", "Issue Number"
            }
        ));
        jScrollPane2.setViewportView(ArticleTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AcceptArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                                .addComponent(RejectArticle)
                                .addGap(143, 143, 143)
                                .addComponent(reviseArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seeBack, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(articleSelectDB, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seeBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(articleSelectDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AcceptArticle)
                    .addComponent(RejectArticle)
                    .addComponent(reviseArticle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seeBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_seeBackActionPerformed
    {//GEN-HEADEREND:event_seeBackActionPerformed
        new chief_editor().setVisible(true); //Go back to the previous window.
	this.dispose(); // Close previous window.
    }//GEN-LAST:event_seeBackActionPerformed

    private void FillTable()
    {
	try
	{
	    Connection con = DriverManager.getConnection(url);
	    String sql ="SELECT * FROM article";
	    //PreparedStatement pst = con.prepareStatement(sql);
	    //ResultSet rs = pst.executeQuery();
	    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    ResultSet rs = stmt.executeQuery(sql);
	    //ArticleTable.setModel(DbUtils.resultSetToTableModel(rs));
	    
	    
	}
	catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }    
    
    private void FillCombo()
    {
	try
	{
	    Connection con = DriverManager.getConnection(url);
	    String sql = "SELECT title FROM article";
	    PreparedStatement pst = con.prepareStatement(sql);
	    ResultSet rs = pst.executeQuery();
	    while(rs.next())
	    {
		String name = rs.getString("title");
		articleSelectDB.addItem(name);		
	    }
	    con.close();
	}
	catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }   
    
    
    private void articleSelectDBActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_articleSelectDBActionPerformed
    {//GEN-HEADEREND:event_articleSelectDBActionPerformed
        //
    }//GEN-LAST:event_articleSelectDBActionPerformed

    private void AcceptArticleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_AcceptArticleActionPerformed
    {//GEN-HEADEREND:event_AcceptArticleActionPerformed
        try
	{
	    Connection con = DriverManager.getConnection(url);
	    String sql = "SET NOCOUNT ON UPDATE article SET status='accepted' WHERE title='"; //Initial SQL query to update a column
	    Object varName = (Object)articleSelectDB.getSelectedItem(); //Get the text from the ComboBox
	    String value = articleSelectDB.getSelectedItem().toString(); // And pass it to a string.
	    String sql1 = sql.concat(value);   // Combining Initial query with the text from comboBox
	    String sql2 ="';";                //  Adding the final elements of the query
	    String sql3 = sql1.concat(sql2); //
	    //System.out.println(sql3); //Troubleshooting print to eastablish if concat is working as intended
	    PreparedStatement pst = con.prepareStatement(sql3);
	    ResultSet rs = pst.executeQuery();
	    con.close();
	}
	catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_AcceptArticleActionPerformed

    private void RejectArticleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_RejectArticleActionPerformed
    {//GEN-HEADEREND:event_RejectArticleActionPerformed
       try
	{
	    Connection con = DriverManager.getConnection(url);
	    String sql = "SET NOCOUNT ON UPDATE article SET status='rejected' WHERE title='"; //Initial SQL query to update a column
	    Object varName = (Object)articleSelectDB.getSelectedItem(); //Get the text from the ComboBox
	    String value = articleSelectDB.getSelectedItem().toString(); // And pass it to a string.
	    String sql1 = sql.concat(value);   // Combining Initial query with the text from comboBox
	    String sql2 ="';";                //  Adding the final elements of the query
	    String sql3 = sql1.concat(sql2); //
	    //System.out.println(sql3); //Troubleshooting print to eastablish if concat is working as intended
	    PreparedStatement pst = con.prepareStatement(sql3);
	    ResultSet rs = pst.executeQuery();
	    con.close();
	}
	catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_RejectArticleActionPerformed

    private void reviseArticleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_reviseArticleActionPerformed
    {//GEN-HEADEREND:event_reviseArticleActionPerformed
        try// Revise Button Press Action
	{
	    Connection con = DriverManager.getConnection(url);
	    String sql = "SET NOCOUNT ON UPDATE article SET status='revise' WHERE title='"; //Initial SQL query to update a column
	    Object varName = (Object)articleSelectDB.getSelectedItem(); //Get the text from the ComboBox
	    String value = articleSelectDB.getSelectedItem().toString(); // And pass it to a string.
	    String sql1 = sql.concat(value);   // Combining Initial query with the text from comboBox
	    String sql2 ="';";                //  Adding the final elements of the query
	    String sql3 = sql1.concat(sql2); //
	    //System.out.println(sql3); //Troubleshooting print to eastablish if concat is working as intended
	    PreparedStatement pst = con.prepareStatement(sql3);
	    ResultSet rs = pst.executeQuery();
	    con.close();
	}
	catch(Exception e)
        {
            //JOptionPane.showMessageDialog(null,e);
        }
	
    }//GEN-LAST:event_reviseArticleActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try
	{
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
	    {
		if ("Nimbus".equals(info.getName()))
		{
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex)
	{
	    java.util.logging.Logger.getLogger(seeArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex)
	{
	    java.util.logging.Logger.getLogger(seeArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex)
	{
	    java.util.logging.Logger.getLogger(seeArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex)
	{
	    java.util.logging.Logger.getLogger(seeArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		new seeArticle().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptArticle;
    private javax.swing.JTable ArticleTable;
    private javax.swing.JButton RejectArticle;
    private javax.swing.JComboBox<String> articleSelectDB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton reviseArticle;
    private javax.swing.JButton seeBack;
    // End of variables declaration//GEN-END:variables
}
