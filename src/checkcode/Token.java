package checkcode;

public class Token {
	
	private String name;
	private String type;
	private String value;
	private String detail;
	
	
	public Token(String name,String detail, String type, String value) {
		this.name = name;
		this.type = type;
		this.value = value;
		this.detail = detail;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	

}
