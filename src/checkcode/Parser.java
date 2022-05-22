package checkcode;


import java.util.ArrayList;
import java.util.List;

public class Parser {
	
	public Parser() {}
	
	// on procéde à l'analyse syntaxique des jetons avec l'aide de l'arbre syntaxique
	public List<ExpressionsFactory> parser(List<Token> tokens){	

		List<ExpressionsFactory> parser = createAST(tokens);
			
		return parser;
	}

	// génération de l'arbre abstrait syntaxique
	public List<ExpressionsFactory> createAST(List<Token> tokens){
		
		List<ExpressionsFactory> parserAST = new ArrayList<ExpressionsFactory>();
		ExpressionsFactory e = new ExpressionsFactory();
		for(Token t : tokens ) {
			parserAST.add(e.factoriseToken(t));
		}
		return parserAST;	
	}
}
