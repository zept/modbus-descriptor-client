package export;

public class ExportFactory {
	
	public static ExportToFile getExporter(FileType fileType) {
		ExportToFile exporter = null;
		switch (fileType) {
		case CSV:
			exporter = new ExportToCsv();
			break;
		case XML: 
			// Not yet implemented
			break;
		case JSON: 
			// Not yet implemented
			break;
		}
		return exporter;
		
	}
}
