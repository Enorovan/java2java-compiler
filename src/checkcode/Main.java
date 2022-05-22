package checkcode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        System.out.println(Keywords.visibilitiesList);
        System.out.println(Keywords.typesList);
        System.out.println(Keywords.operatorsList);
        /*Le chemin pour aller dans chaque fichier (différent pour chacun).*/
        File file = new File("D:\\workspace\\checkcode\\src\\checkcode\\Test.java");
        Tokenizer tokens = new Tokenizer();
        try {
        	List <String> stringTokenizer = tokens.stringTokenizer(file);
        	for(String s: stringTokenizer) {
        		System.out.println(s);
        	}
        	List<Token> tokenList = tokens.tokenizer(file);
			List<ExpressionsFactory> expr = new ArrayList<ExpressionsFactory>();
			ExpressionsFactory e = new ExpressionsFactory();
			for(Token t : tokenList) {
				expr.add(e.factoriseToken(t));
			}
			System.out.println("\n------ Tokens ------");
			for (ExpressionsFactory elem: expr) {
				System.out.println(elem.toString());
			}

			Scoring score = new Scoring();
			score.score(file);
			score.resultat();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
        
    }
}