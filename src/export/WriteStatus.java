package export;

public class WriteStatus {
	private int linesWritten;
	private String fileName;
	private int error;
	private String errorText;
	
	
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}
	public int getLinesWritten() {
		return linesWritten;
	}
	public void setLinesWritten(int linesWritten) {
		this.linesWritten = linesWritten;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
