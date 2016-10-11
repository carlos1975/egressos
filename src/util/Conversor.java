package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Conversor {
	
    public static java.util.Date toDate(Object valor) throws ParseException{
        
        if(valor == null || valor.toString().equals(""))
            return null;
        
        if(valor instanceof java.util.Date)
            return (java.util.Date)valor;
        
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        
        return sd.parse(valor.toString());
    }
    
    public static java.sql.Date toDateSQL(Object valor) throws ParseException{
        
        if(valor == null || valor.toString().equals(""))
            return null;
        
        if(valor instanceof java.util.Date)
            return (java.sql.Date)valor;
        
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        
        return (java.sql.Date) sd.parse(valor.toString());
    }
    
    public static java.sql.Date dateToSQLDate(
            java.util.Date javaDate) {
        java.sql.Date sqlDate = null;
        if (javaDate != null) {
            sqlDate = new Date(javaDate.getTime());
        }
        return sqlDate;
    }
}
