package model;

public class DescriptionModel {
	private Integer functionCode;
	private Integer address;
	private Integer unit;
	private Integer format;
	private Integer scaling;
	private String tagName;
	private String description;
	private float minValue;
	private float maxValue;
	private float defaultValue;
	
	public Integer getFunctionCode() {
		return functionCode;
	}
	public void setFunctionCode(Integer functionCode) {
		this.functionCode = functionCode;
	}
	public Integer getAddress() {
		return address;
	}
	public void setAddress(Integer address) {
		this.address = address;
	}
	public Integer getUnit() {
		return unit;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
	}
	public Integer getFormat() {
		return format;
	}
	public void setFormat(Integer format) {
		this.format = format;
	}
	public Integer getScaling() {
		return scaling;
	}
	public void setScaling(Integer scaling) {
		this.scaling = scaling;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getMinValue() {
		return minValue;
	}
	public void setMinValue(float minValue) {
		this.minValue = minValue;
	}
	public float getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}
	public float getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(float defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String toString() {
    	return getColumnNames()[0] + " " + this.getFunctionCode() 
    			+ getColumnNames()[1] + " " + this.getAddress() 
    			+ getColumnNames()[2] + " " + this.getUnit() 
    			+ getColumnNames()[3] + " " + this.getFormat() 
    			+ getColumnNames()[4] + " " + this.getScaling() 
    			+ getColumnNames()[5] + " " + this.getTagName() 
    			+ getColumnNames()[6] + " " + this.getDescription()
    			+ getColumnNames()[7] + " " + this.getMinValue()
    			+ getColumnNames()[8] + " " + this.getMaxValue()
    			+ getColumnNames()[9] + " " + this.getDefaultValue();

	}
	public Object[] getAsObjectArray() {
		return new Object[] {
				this.getFunctionCode(),
				this.getAddress(),
				this.getUnit(),
				this.getFormat(),
				this.getScaling(),
				this.getTagName(),
				this.getDescription(),
				this.getMinValue(),
				this.getMaxValue(),
				this.getDefaultValue()};
	}
	
	public String[] getColumnNames() {
		return new String[] {"Function code", "Address", "Unit", "Format", "Scaling", "Tag-name", "Description", "Min.value", "Max.value", "Default value"};
	}
}
