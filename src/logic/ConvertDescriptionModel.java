package logic;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Vector;

import model.DescriptionModel;

public class ConvertDescriptionModel {

    public DescriptionModel mapByteArrayToDescriptionModel(byte[] bytes) {
    	DescriptionModel dm = new DescriptionModel();
    	dm.setFunctionCode(Byte.toUnsignedInt(bytes[0]));
    	dm.setAddress(((bytes[1] & 0xff) << 8) | (bytes[2] & 0xff));
    	dm.setUnit(Byte.toUnsignedInt(bytes[3]));
    	dm.setFormat(Byte.toUnsignedInt(bytes[4]));
    	dm.setScaling((short)((bytes[5] & 0xff) << 8) | (bytes[6] & 0xff));
    	
    	int asciiStartPosition = 7;
    	int delimiterPosition = -1;
    	int stopPosition = bytes.length;
    	
    	for (int i = asciiStartPosition; i < stopPosition; i++) {
    		if (bytes[i] == 124) {
    			delimiterPosition = i;
    		}
    	}
    	
    	byte[] tagName = Arrays.copyOfRange(bytes, asciiStartPosition, delimiterPosition);
    	byte[] description = Arrays.copyOfRange(bytes, delimiterPosition + 1, stopPosition);
    	
    	dm.setTagName(new String(tagName, StandardCharsets.US_ASCII));
    	dm.setDescription(new String(description, StandardCharsets.US_ASCII));
    	
		return dm;
    	
    }
    
    public DescriptionModel createDescriptionModel(Vector row) {
    	DescriptionModel dm = new DescriptionModel();
    	
    	try {
        	dm.setFunctionCode((Integer) row.elementAt(0));
        	dm.setAddress((Integer) row.elementAt(1));
        	dm.setUnit((Integer) row.elementAt(2));
        	dm.setFormat((Integer) row.elementAt(3));
        	dm.setScaling((Integer) row.elementAt(4)); 
        	dm.setTagName((String) row.elementAt(5));
        	dm.setDescription((String) row.elementAt(6));
        	dm.setMinValue((float) row.elementAt(7));
        	dm.setMaxValue((float) row.elementAt(8)); 
        	dm.setDefaultValue((float) row.elementAt(9)); 
        
    	} catch (Exception e) {
    		return new DescriptionModel();
    	}
    	return dm;

    	
    }
}
