package com.pucrs.devsys.tf.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class JsonDateDeserializerYYYYMMDD extends JsonDeserializer<Date>
{


	@Override
	public Date deserialize(JsonParser jsonparser, DeserializationContext arg1) throws IOException, JsonProcessingException {
		 try 
	        {
	        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	            String date = jsonparser.getText();
				return format.parse(date);
				
			} catch (ParseException e) { e.printStackTrace(); }
	        
	        return null;
	}
	

}
