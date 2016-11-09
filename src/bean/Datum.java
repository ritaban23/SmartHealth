package bean;

public class Datum {

	//private static int currentdatum_id = 1;
	private String username;
	private int property_id;
	private String value;
	private int datum_id;
	
	public Datum(String username, int property_id, String value) {
		super();
		datum_id = (int)((new java.util.Date()).getTime());
		this.username = username;
		this.property_id = property_id;
		this.value = value;
	}
	public int getDatum_id() {
		return datum_id;
	}
	public void setDatum_id(int datum_id) {
		this.datum_id = datum_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProperty_id() {
		return property_id;
	}
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	 
} 
