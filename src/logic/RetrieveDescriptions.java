/*
 	@author David Ågren
 */
package logic;


import java.util.ArrayList;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.msg.ModbusResponse;
import com.serotonin.modbus4j.msg.ReadResponse;

import model.DescriptionModel;


/**
 * @author David Ågren
 */

public class RetrieveDescriptions {
	
    public ArrayList<DescriptionModel> getDescriptions(IpParameters ipParam, int node, int offset, int length) throws Exception {
    	ArrayList<DescriptionModel> descriptions = new ArrayList<>();

        ModbusFactory modbusFactory = new ModbusFactory();
        ModbusMaster master = modbusFactory.createTcpMaster(ipParam, false);
        master.setTimeout(8000);
        master.setRetries(0);
        master.init();
        
        for (int address = offset; address <= offset + length; address++ ) {
        	ModbusResponse message = master.getSlaveDescription(node, address);
        	ReadResponse response = (ReadResponse) message;
        	//printData(message);
        	if (validateData(response.getData())) {
        		ConvertDescriptionModel cdm = new ConvertDescriptionModel();
        		descriptions.add(cdm.mapByteArrayToDescriptionModel(response.getData()));
        		// printData(message);
        	} else break;
        }

        master.destroy();
        
        return descriptions;
    }
    
    private boolean validateData(byte[] data) {
    	
    	if (data == null || data.length < 7){
    		return false;
    	}
    	return true;
    }
    
    void printData(ModbusResponse response) {
    	ReadResponse message = (ReadResponse) response;
        System.out.println("length is: " + message.getData().length);

        StringBuilder sb = new StringBuilder();
        for (byte b : message.getData()) {
            sb.append(String.format("%02X ", b));
        }
        System.out.println(sb.toString());
    }
    
}
