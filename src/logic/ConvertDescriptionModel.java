package logic;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import model.DescriptionModel;
import model.FormatDataType;

public class ConvertDescriptionModel {

    public DescriptionModel mapByteArrayToDescriptionModel(byte[] bytes) {
    	DescriptionModel dm = new DescriptionModel();
    	dm.setFunctionCode(Byte.toUnsignedInt(bytes[0]));
    	dm.setAddress(((bytes[1] & 0xff) << 8) | (bytes[2] & 0xff));
    	
    	
    	// Remove sign and set correct divisor / multiplier
    	Integer scaling = (short) ((bytes[4] & 0xff) << 8) | (bytes[5] & 0xff);
    	int signum = Integer.signum(scaling);
    	String textScale = "Unknown";
    	
    	switch (signum) {
    		case -1:
    			textScale = ("/ " + Math.abs(scaling));
    			break;
    		case 0:
    			textScale = ("* " + 1);
    			break;
    		case 1:
    			textScale = ("* " + scaling);
    			break;
    	}
    	
    	dm.setScaling(textScale);
    	
    	// Get description from lookup table
    	dm.setFormat(FormatDataType.getDescription(Byte.toUnsignedInt(bytes[3])));
    	
    	// Handle textfields
    	int asciiStartPosition = 6;
    	ArrayList<Integer> delimiterPosition = new ArrayList<>();
    	int stopPosition = bytes.length;
    	
    	for (int i = asciiStartPosition; i < stopPosition; i++) {
    		if (bytes[i] == 124) {
    			delimiterPosition.add(i);
    		}
    	}
    	
    	byte[] unit = Arrays.copyOfRange(bytes, asciiStartPosition, delimiterPosition.get(0));
    	byte[] tagName = Arrays.copyOfRange(bytes, delimiterPosition.get(0) + 1, delimiterPosition.get(1));
    	byte[] description = Arrays.copyOfRange(bytes, delimiterPosition.get(1) + 1, stopPosition);
    	
    	
    	dm.setUnit(new String(unit, StandardCharsets.US_ASCII));
    	dm.setTagName(new String(tagName, StandardCharsets.US_ASCII));
    	dm.setDescription(new String(description, StandardCharsets.US_ASCII));
    	
		return dm;
    	
    }
    
    public DescriptionModel createDescriptionModel(Vector row) {
    	DescriptionModel dm = new DescriptionModel();
    	
    	try {
        	dm.setFunctionCode((Integer) row.elementAt(0));
        	dm.setAddress((Integer) row.elementAt(1));
        	dm.setUnit((String) row.elementAt(2));
        	dm.setFormat((String) row.elementAt(3));
        	dm.setScaling((String) row.elementAt(4)); 
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
