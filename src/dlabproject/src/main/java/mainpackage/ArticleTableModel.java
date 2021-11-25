
package mainpackage;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author konst
 */
public class ArticleTableModel extends AbstractTableModel {
    
    private int colnum=9;
    private int rownum;
    private String[] colNames = {"path","Title","Pages","Status","Summary","Key words","Chief Editor e-mail","Category ID","Page number"};
    
    private ArrayList<String[]> ResultSets;
    
    public ArticleTableModel(ResultSet rs){
        ResultSets = new ArrayList<>();  
    
      try{
        while(rs.next()){
      
              String[] row={
                rs.getString("article_path"),rs.getString("title"), rs.getString("pages"),rs.getString("status"),rs.getString("summary"),rs.getString("key_word"),rs.getString("chief_editor_email"),rs.getString("category_id"),rs.getString("page_number")
          
            };
            ResultSets.add(row);
      
         }   
      }
      catch(Exception e){
          System.out.println("Exception in ArticleTableModel");
            }
        
    }
    @Override
    public Object getValueAt(int rowindex, int columnindex) {
        
       String[] row=ResultSets.get(rowindex);
       return row[columnindex];
        
    }

    @Override
    public int getRowCount() {
        return ResultSets.size();
    }
     @Override
    public int getColumnCount() {
        return colnum;
    }
   @Override
    public String getColumnName(int param) {

       return colNames[param];
    }
}
