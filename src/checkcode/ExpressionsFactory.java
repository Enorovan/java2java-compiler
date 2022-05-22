package checkcode;

public class ExpressionsFactory {

	private String name;
	private String tokenType;
	private String value;
	private String variableType;
	

	public ExpressionsFactory() {
		name = "";
		tokenType = "";
		value = ""; 
		variableType="";
	}
	

	public String getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getVariableType() {
		return variableType;
	}

	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}

	public ExpressionsFactory factoriseToken(Token t) {
		ExpressionsFactory e = new ExpressionsFactory();
		e.setType(t.getDetail());
		e.setName(t.getName());
		e.setVariableType(t.getType());
		
		switch(e.tokenType) {
		
		case "EndInstruct":
			e.setValue(t.getValue());
			break;
		
		case "ClassName":
			e.setValue(t.getValue());
			break;
			
		case "OpenClass":
			e.setValue(t.getValue());
			break;
			
		case "ClassAttribute":
			e.setValue(t.getValue());
			break;
			
		case "MethodVariable":
			e.setValue(t.getValue());
			break;
			
		case "OpenMethod":
			e.setValue(t.getValue());
			break;
			
		case "EndMethod":
			e.setValue(t.getValue());
			break;

		case "Package":
			e.setValue(t.getValue());
			break;
			
		case "Import":
			e.setValue(t.getValue());
			break;

		case "Return":
			e.setValue(t.getValue());
			break;
		
		case "MethodName":
			e.setValue(t.getValue());
			break;

		case "Parameter":
			e.setValue(t.getValue());
			break;
			
		case "EndClass":
			e.setValue(t.getValue());
			break;
		default:
			 e.setValue("nothing");
			 break;
		}
		
		return e;
	}
	
	
	public void setType(String detail) {
		this.tokenType = detail;
	}
	
	public String getType() {
		return tokenType;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	public String toString() {
		switch (this.getType()) {
		
		case "EndInstruct":
			return "{ Type :" + this.getType() +", value : " + "'"+this.getValue()+"' },";

		case "ClassName":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +" },";
			return "{ Type :" + this.getType() +", value : " + "'"+this.getValue()+"' },";
		
		case "OpenClass":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +" },";
			return "{ Type :" + this.getType() +", value : " + "'"+this.getValue()+"' },";
			
		case "ClassAttribute":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +" },";
			return "{ Type :" + this.getType() +", value : '" +this.getValue()+"' },";
			
		case "MethodVariable":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +"},";
			return "{ Type :" + this.getType() +", value : " +this.getValue()+ " },";

		case "OpenMethod":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +" },";
			return "{ Type :" + this.getType() +", value : " + "'"+this.getValue()+"' },";
			
		case "EndMethod":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +" },";
			return "{ Type :" + this.getType() +", value : " + "'"+this.getValue()+"' },";

		case "Package":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +" },";
			return "{ Type :" + this.getType() +", value : " + "'"+this.getValue()+"' },";
		
		case "Import":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +" },";
			return "{ Type :" + this.getType() +", value : " + "'"+this.getValue()+"' },";

		case "Return":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +" },";
			return "{ Type :" + this.getType() +", value : " + "'"+this.getValue()+"' },";

		case "MethodName":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +" },";
			return "{ Type :" + this.getType() +", value : " + "'"+this.getValue()+"' },";

		case "Parameter":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +" },";
			return "{ Type :" + this.getType() +", value : " + "'"+this.getValue()+"' },";

		case "EndClass":
			if (this.getValue().equals("Empty"))
				return "{ Type :" + this.getType() +" },";
			return "{ Type :" + this.getType() +", value : " + "'"+this.getValue()+"' },\n END OF FILE ";

		default:
			return "nothing";
		}
	}
}
