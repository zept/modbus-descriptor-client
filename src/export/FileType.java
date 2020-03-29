package export;

public enum FileType {
	CSV("Comma-separated values [CSV]"),
	XML("Extensible Markup Language [XML]"),
	JSON("JavaScript Object Notation [JSON]");
	
	private String fileType;
	
	private FileType(String fileType) {
		this.fileType = fileType;
	}
	
	@Override
	public String toString() {
		return fileType;
	}
}
