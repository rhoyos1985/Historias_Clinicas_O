/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ricsoft.userclass;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author RCHRDHYSBQR
 */
public class ResulsettoDataStructure {
    
    public HashMap resultSetToHashMap(ResultSet rs) throws SQLException{
        
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        
        HashMap row = new HashMap();
        
        while (rs.next()){
           
            for(int i=1; i<=columns; i++){
             
                row.put(md.getColumnName(i),rs.getObject(i));
                
            }
        }
        
        return row;
    }
    
    public ArrayList resultSetToArrayList(ResultSet rs) throws SQLException{  
        
        ResultSetMetaData md = rs.getMetaData();  
        int columns = md.getColumnCount();  
        ArrayList results = new ArrayList();  

        while (rs.next()) {  
            HashMap row = new HashMap();  
            results.add(row);  

            for(int i=1; i<=columns; i++){  
              row.put(md.getColumnName(i),rs.getObject(i));  
            }  
        }  
        return results;  
    }

}
