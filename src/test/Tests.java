package test;

import java.util.ArrayList;

import logic.ConfigureIpParameters;
import logic.RetrieveDescriptions;
import model.DescriptionModel;

public class Tests {

	public static void main(String[] args) {
		ConfigureIpParameters cip = new ConfigureIpParameters("localhost", 502);
		RetrieveDescriptions rd = new RetrieveDescriptions();
		try {
			ArrayList<DescriptionModel> dml = rd.getDescriptions(cip.getIpParameters(), 1, 1, 99);
			for (DescriptionModel dm : dml) {
				System.out.println(dm.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
