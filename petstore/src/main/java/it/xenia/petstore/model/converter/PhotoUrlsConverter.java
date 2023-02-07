package it.xenia.petstore.model.converter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PhotoUrlsConverter implements AttributeConverter<List<String>,String> {
	
	private static final String SEPARATOR = ";";

    @Override
    public String convertToDatabaseColumn(List<String> photoUrls) {
        if (photoUrls == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        if (!photoUrls.isEmpty()) {
        	for(String s : photoUrls) {
        		sb.append(s);
        		sb.append(SEPARATOR);
        	}
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Override
    public List<String> convertToEntityAttribute(String dbPhotoUrls) {
        String[] pieces = dbPhotoUrls.split(SEPARATOR);

        if (pieces == null || pieces.length == 0) {
            return null;
        }
        
        List<String> ret = new ArrayList<String>();
        for(String s : pieces) ret.add(s);
        return ret;
    }
}
