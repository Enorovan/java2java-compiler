package checkcode;

import java.util.ArrayList;
import java.util.List;

public class Keywords {
	//Visibilities
	public static final String PUBLIC = "public";
	public static final String PROTECTED = "protected";
	public static final String PRIVATE = "private";
	public static final String STATIC = "static";
	public static final String FINAL = "final";
		
	//Types
	public static final String VOID = "void";
	public static final String BOOLEAN = "boolean";
	public static final String INT = "int";
	public static final String FLOAT = "float";
	public static final String DOUBLE = "double";
	public static final String CHAR = "char";
	public static final String STRING = "String";

	//Operators
	public static final String ASSIGNMENT = "=";
	public static final String ADDITION_ASSIGNMENT = "+";
	public static final String SUBTRACTION_ASSIGNMENT = "-";
	public static final String MULTIPLICATION_ASSIGNMENT = "*";
	public static final String DIVISION_ASSIGNMENT = "/";
	public static final String MODULUS_ASSIGNMENT = "%";
	
	public static final String EQUAL = "==";
	public static final String NOT_EQUAL = "!=";
	public static final String LESS = "<";
	public static final String LESS_EQUAL = "<=";
	public static final String GREATER = ">";
	public static final String GREATER_EQUAL = ">=";
	
	public static final String NOT = "!";
	public static final String AND = "&&";
	public static final String OR = "||";
	public static final String BITWISE_AND = "&";
	public static final String BITWISE_OR = "|";
	
	public static final String ADDITION = "+";
	public static final String SUBTRACTION = "-";
	public static final String MULTIPLICATION = "*";
	public static final String DIVISION = "/";
	public static final String MODULUS = "%";
	
	public static final String INCREMENT = "++";
	public static final String DECREMENT = "--";
	
	public static final String COMMA = ",";
	public static final String SEMICOLON = ";";
	public static final String COLON = ":";
	public static final String CONDITIONAL = "?";
	public static final String PARENTHESIS_OPEN = "(";
	public static final String PARENTHESIS_CLOSE = ")";
	public static final String BRACKET_OPEN = "[";
	public static final String BRACKET_CLOSE = "]";
	public static final String CURLY_OPEN = "{";
	public static final String CURLY_CLOSE = "}";
	
	public static final String SINGLE_QUOTE = "'";
	public static final String DOUBLE_QUOTE = "\"";
	
	public static final String BACKSLASH = "\\";
	
	public static List<String> visibilitiesList = createVisibilitiesList();
	public static List<String> typesList= createTypesList();
	public static List<String> operatorsList = createOperatorsList();
	
	public static List<String> createVisibilitiesList() {
		List<String> visibilitiesList = new ArrayList<String>();
		visibilitiesList.add(PUBLIC);
		visibilitiesList.add(PROTECTED);
		visibilitiesList.add(PRIVATE);
		visibilitiesList.add(STATIC);
		visibilitiesList.add(FINAL);
		
		return visibilitiesList;
	}
	
	public static List<String> createTypesList() {
		List<String> typesList = new ArrayList<String>();
		typesList.add(VOID);
		typesList.add(BOOLEAN);
		typesList.add(INT);
		typesList.add(FLOAT);
		typesList.add(DOUBLE);
		typesList.add(CHAR);
		typesList.add(STRING);
		
		return typesList;
	}
	
	public static List<String> createOperatorsList() {
		List<String> operatorsList = new ArrayList<String>();
		operatorsList.add(ASSIGNMENT);
		operatorsList.add(ADDITION_ASSIGNMENT);
		operatorsList.add(SUBTRACTION_ASSIGNMENT);
		operatorsList.add(MULTIPLICATION_ASSIGNMENT);
		operatorsList.add(DIVISION_ASSIGNMENT);
		operatorsList.add(MODULUS_ASSIGNMENT);
		
		operatorsList.add(EQUAL);
		operatorsList.add(NOT_EQUAL);
		operatorsList.add(LESS);
		operatorsList.add(LESS_EQUAL);
		operatorsList.add(GREATER);
		operatorsList.add(GREATER_EQUAL);
		
		operatorsList.add(NOT);
		operatorsList.add(AND);
		operatorsList.add(OR);
		operatorsList.add(BITWISE_AND);
		operatorsList.add(BITWISE_OR);
		
		operatorsList.add(ADDITION);
		operatorsList.add(SUBTRACTION);
		operatorsList.add(MULTIPLICATION);
		operatorsList.add(DIVISION);
		operatorsList.add(MODULUS);
		
		operatorsList.add(INCREMENT);
		operatorsList.add(DECREMENT);
		
		operatorsList.add(COMMA);
		operatorsList.add(SEMICOLON);
		operatorsList.add(COLON);
		operatorsList.add(CONDITIONAL);
		operatorsList.add(PARENTHESIS_OPEN);
		operatorsList.add(PARENTHESIS_CLOSE);
		operatorsList.add(BRACKET_OPEN);
		operatorsList.add(BRACKET_CLOSE);
		operatorsList.add(CURLY_OPEN);
		operatorsList.add(CURLY_CLOSE);
		
		operatorsList.add(SINGLE_QUOTE);
		operatorsList.add(DOUBLE_QUOTE);
		
		operatorsList.add(BACKSLASH);
		
		return operatorsList;
	}
}
