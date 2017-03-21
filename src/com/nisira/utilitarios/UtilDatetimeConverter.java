package com.nisira.utilitarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nisira.core.CoreUtil;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

public class UtilDatetimeConverter extends AbstractSingleValueConverter{

	@Override
    public boolean canConvert(Class type) {
        return type.equals(Date.class);
    }
 
    @Override
    public Object fromString(String string) {
    	//2016-07-26T17:28:55.090
    	/*ALGORITMO*/
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    	if(string!=null){
//    		string=CoreUtil.fechaEspaniol(string);
    		if(string.length()<20){
    			string = string+".000";
    		}
    		try {
				return sdf.parse(string.substring(0, 10)+" "+string.substring(11,23));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
    	}else{
    		return null;
    	}
    }
 
    @Override
    public String toString(Object obj) {
    	Date date = (Date) obj;
        return CoreUtil.fechaEspaniol(date.toGMTString());
    }
    
    public static void main(String[] args) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String dateInString = "2016-07-26";
    	Date date;
		try {
			date = sdf.parse(dateInString);
			System.out.println(date); //Tue Aug 31 10:20:56 SGT 1982
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}

}
