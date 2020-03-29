package export;

import java.util.ArrayList;

import model.DescriptionModel;

public interface ExportToFile {
	public WriteStatus writeToFile(String fileName, ArrayList<DescriptionModel> descList) throws Exception;
}
