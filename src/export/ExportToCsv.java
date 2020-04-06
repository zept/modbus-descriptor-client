package export;

import java.io.FileWriter;
import java.util.ArrayList;

import model.DescriptionModel;

public class ExportToCsv implements ExportToFile{
	private final String delimiter = new String(";");
	private final String newRow = new String("\n");
	private final String fileType = new String(".csv");

	@Override
	public WriteStatus writeToFile(String fileName, ArrayList<DescriptionModel> descList) throws Exception {
		WriteStatus status = new WriteStatus();
		status.setFileName(fileName + fileType);
		
		System.out.println(fileName);
		System.out.println(fileType);
		System.out.println(status.getFileName());
		
		// Check the list
		if (descList == null || descList.isEmpty()) {
			status.setLinesWritten(0);
			status.setError(1);
			status.setErrorText("List is empty or uninitiated");
			return status;
		}
		
		// Instantiate the filewriter
		FileWriter writer = new FileWriter(fileName + fileType);
		
		// Write the column names
		for (String s : descList.get(0).getColumnNames()) {
			writer.append(s);
			writer.append(delimiter);
		}
		writer.append(newRow);
		
		// Write the contents from list
		for (DescriptionModel descModel : descList) {
			writer.append(descModel.getFunctionCode().toString());
			writer.append(delimiter);
			writer.append(descModel.getAddress().toString());
			writer.append(delimiter);
			writer.append(descModel.getUnit());
			writer.append(delimiter);
			writer.append(descModel.getFormat().toString());
			writer.append(delimiter);
			writer.append(descModel.getScaling().toString());
			writer.append(delimiter);
			writer.append(descModel.getTagName());
			writer.append(delimiter);
			writer.append(descModel.getDescription());
			writer.append(delimiter);
			writer.append(String.valueOf(descModel.getMinValue()));
			writer.append(delimiter);
			writer.append(String.valueOf(descModel.getMinValue()));
			writer.append(delimiter);
			writer.append(String.valueOf(descModel.getDefaultValue()));
			writer.append(delimiter);
			writer.append(newRow);
			status.setLinesWritten(status.getLinesWritten() +1 );
		}
		
		// Close the writer.
		writer.flush();
		writer.close();
		
		return status; 
	}
}
