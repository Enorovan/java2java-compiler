package checkcode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Tokenizer {

	public List<String> stringTokenizer(File file) throws FileNotFoundException {
		List<String> tokens = new ArrayList<String>();
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		try {
			while ((line = buffer.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line); /*Fonction java qui permet de diviser en Tokens chaque élément du fichier
				(à voir ce qu'on peut en faire) */
			    while (st.hasMoreTokens()) {
			    	String currentString = st.nextToken();
			        tokens.add(currentString);
			    }
			}
			buffer.close();
			return tokens;
		} catch (IOException e) {
			e.printStackTrace();
			return tokens;
		}
	}

	private boolean isVisibility(String visibility) {
		for(String visibilityElem: Keywords.visibilitiesList) {
			if(visibility.equals(visibilityElem))  return true;
		}
		return false;
	}
	
	private boolean isType(String type) {
		for(String typeElem: Keywords.typesList) {
			if(type.equals(typeElem)) return true;
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	private boolean isOperator(String operator) {
		for(String operatorElem: Keywords.operatorsList) {
			if(operator.equals(operatorElem)) return true;
		}
		return false;
	}

	
	public List<Token> tokenizer(File file) throws FileNotFoundException {
		List<Token> tokens = new ArrayList<Token>();
		List<String> strings = stringTokenizer(file);
		for(int i = 0; i < strings.size(); i++) {

			if(strings.get(i).equals("package")){
				Token token = new Token(strings.get(i + 1),"Package","", strings.get(i + 1));
				tokens.add(token);
				Token SEMICOLON_TOKEN = new Token("SEMICOLON ","EndInstruct", "Operator",Keywords.SEMICOLON);
				tokens.add(SEMICOLON_TOKEN);
			}

			if(strings.get(i).equals("import")){
				Token token = new Token(strings.get(i + 1),"Import","", strings.get(i + 1));
				tokens.add(token);
				Token SEMICOLON_TOKEN = new Token("SEMICOLON ","EndInstruct", "Operator",Keywords.SEMICOLON);
				tokens.add(SEMICOLON_TOKEN);
			}

			/*On regarde si c'est :
			 * Une déclaration d'attribut de classe
			 * Une déclaration de variable
			 * Une classe
			 * */
			boolean isVisibility = isVisibility(strings.get(i));
			if(isVisibility) {
				boolean isStringType = isType(strings.get(i + 1));
				if(isStringType) {
					 if (strings.get(i + 3).equals(Keywords.SEMICOLON)) {
						Token token = new Token(strings.get(i + 2), "ClassAttribute", strings.get(i + 1), strings.get(i + 2));
						Token SEMICOLON_TOKEN = new Token("SEMICOLON ", "EndInstruct", "Operator", Keywords.SEMICOLON);
						tokens.add(token);
						tokens.add(SEMICOLON_TOKEN);
					}

					else {					
						if(strings.get(i + 2).contains(Keywords.SEMICOLON)) {
							int length = strings.get(i + 2).length();
							String nomVariable = strings.get(i+2).substring(0, length - 1);
							Token token = new Token(nomVariable,"ClassAttribute",strings.get(i + 1), strings.get(i + 2));
							Token SEMICOLON_TOKEN = new Token("SEMICOLON ","EndInstruct", "Operator",Keywords.SEMICOLON);
							tokens.add(token);
							tokens.add(SEMICOLON_TOKEN);	
						}
						else {
							if(!strings.get(i + 3).contains(Keywords.PARENTHESIS_OPEN)) {
								Token token = new Token(strings.get(i + 2),"ClassAttribute",strings.get(i + 1), strings.get(i + 2));
								tokens.add(token);
							}
						}
					}	
					if(strings.get(i + 3).equals(Keywords.EQUAL)) {
						if(strings.get(i + 4).contains(Keywords.SEMICOLON)) {
							int length  = strings.get(i + 4).length();
							String valeurVariable = strings.get(i + 4).substring(0, length - 1);
							Token token = new Token(strings.get(i + 2),"ClassAttribute",strings.get(i + 1),valeurVariable);
							tokens.add(token);
							Token SEMICOLON_TOKEN = new Token("SEMICOLON ","EndInstruct", "Operator",Keywords.SEMICOLON);
							tokens.add(SEMICOLON_TOKEN);
						}
						else {
							if(strings.get(i + 5).equals(Keywords.SEMICOLON)) {
								int length  = strings.get(i + 4).length();
								String valeurVariable = strings.get(i + 4).substring(0, length - 1);
								Token token = new Token(strings.get(i + 2),"ClassAttribute",strings.get(i + 1),valeurVariable);
								tokens.add(token);
								Token SEMICOLON_TOKEN = new Token("SEMICOLON ","EndInstruct", "Operator",Keywords.SEMICOLON);
								tokens.add(SEMICOLON_TOKEN);
							}
							else {
								Token token = new Token(strings.get(i + 2),"ClassAttribute",strings.get(i + 1),strings.get(i + 4));
								tokens.add(token);
							}
						}
					}				
				}
				else {
					if(strings.get(i+1).equals("class")) {
						Token token = new Token(strings.get(i + 2), "ClassName","",strings.get(i + 2));
						tokens.add(token);
						if(strings.get(i + 3).equals(Keywords.CURLY_OPEN)) {
							Token CURLY_OPEN_TOKEN = new Token("CURLY_OPEN", "OpenClass", "Operator",Keywords.CURLY_OPEN);
							tokens.add(CURLY_OPEN_TOKEN);
						}
					}
				}
			}
			//Regarde si c'est : Une variable de methode initialisé, Une variable de methode non initialisée	 
			boolean isType = isType(strings.get(i));
			if(isType && !isVisibility(strings.get(i - 1))) {
				
				if(strings.get(i+2).equals(Keywords.EQUAL)) {
					
					Token variableMethodToken = new Token(strings.get(i + 1), "MethodVariable", strings.get(i), strings.get(i + 3));
					
					tokens.add(variableMethodToken);
					if(strings.get(i + 3).contains(Keywords.SEMICOLON)) {
						Token SEMICOLON_TOKEN= new Token("SEMICOLON ","EndInstruct", "Operator",Keywords.SEMICOLON);
						tokens.add(SEMICOLON_TOKEN);
					}
				}
				else {
					Token variableMethodToken = new Token(strings.get(i + 1), "MethodVariable", strings.get(i),strings.get(i + 3));
					tokens.add(variableMethodToken);
					if(strings.get(i + 3).contains(Keywords.SEMICOLON)) {
						Token SEMICOLON_TOKEN = new Token("SEMICOLON ","EndInstruct", "Operator",Keywords.SEMICOLON);
						tokens.add(SEMICOLON_TOKEN);
					}
				}	
			}
			if(isType){
				if(strings.get(i+2).contains(Keywords.PARENTHESIS_OPEN)) {
					Token methodName = new Token(strings.get(i + 1),"MethodName","",strings.get(i + 1));
					tokens.add(methodName);
					i+=2;
					int j = i;
					while(!strings.get(i+1).contains(Keywords.PARENTHESIS_CLOSE)) {
						Token parameter = new Token(strings.get(i + 1),"Parameter","",strings.get(i + 1));
						tokens.add(parameter);
						i += 2;
						j = i;
					}
					if(strings.get(j+1).contains(Keywords.PARENTHESIS_CLOSE)) {
						Token parameter = new Token(strings.get(j + 1),"Parameter","",strings.get(j + 1));
						tokens.add(parameter);
					}
				}
			}
			
			//Regarde si : on a une methode avec accolade ouverte, la méthode a bien été fermée, Si on a une classe avec accolade fermée
			if (strings.get(i).equals(Keywords.CURLY_OPEN) && strings.get(i - 1).contains(Keywords.PARENTHESIS_CLOSE)) {
				if(strings.get(i).equals(Keywords.CURLY_OPEN) && i != strings.size() - 1) {
					Token CURLY_OPEN_TOKEN = new Token("CURLY_OPEN", "OpenMethod", "Operator", Keywords.CURLY_OPEN);
					tokens.add(CURLY_OPEN_TOKEN);
				}
			}
			if(strings.get(i).equals("return")) {
				Token returnToken = new Token(strings.get(i + 1), "Return", "", strings.get(i + 1));
				tokens.add(returnToken);
			}
			if(strings.get(i).equals(Keywords.CURLY_CLOSE) && i != strings.size() - 1) {
				Token CURLY_CLOSE_TOKEN = new Token("CURLY_CLOSE", "EndMethod", "Operator", Keywords.CURLY_CLOSE);
				tokens.add(CURLY_CLOSE_TOKEN);
				i++;
			}
			if(i == strings.size()-1) {
				if(strings.get(i).equals(Keywords.CURLY_CLOSE)) {
					Token CURLY_CLOSE_TOKEN = new Token("CURLY_CLOSE", "EndClass", "Operator", Keywords.CURLY_CLOSE);
					tokens.add(CURLY_CLOSE_TOKEN);
				}
			}
		}	return tokens;
	}
}