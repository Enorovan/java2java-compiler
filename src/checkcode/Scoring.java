package checkcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Scoring {

    private int methodVariables;
    private int classVariables;
	private ArrayList<ExpressionsFactory> expr;


    public Scoring() {
    	this.expr = new ArrayList<ExpressionsFactory>();
    }

    public void score(File f) throws FileNotFoundException {
        Tokenizer t = new Tokenizer();

        t.tokenizer(f);
        List<Token> tokens = new ArrayList<Token>();
        tokens = t.tokenizer(f);

        Parser parser = new Parser();
        ArrayList<ExpressionsFactory> listAST = (ArrayList<ExpressionsFactory>) parser.createAST(tokens);
        System.out.println("\n------ AST ------");
        for (ExpressionsFactory e : listAST) {
            if (e.getValue() != "Empty")
                System.out.println("{ nom : '" + e.getName() + "',\n" + " type : '" + e.getType() + "',\n" + " type_variable : '" + e.getVariableType() + "',\n" + " valeur : '" + e.getValue() + "'\n}");
            else
                System.out.println("{nom : '" + e.getName() + "',\n" + " type : '" + e.getType() + "',\n" + " type_variable : '" + e.getVariableType() + "'" + "\n}");
        }
        this.expr = listAST;
03+
    }

    public void resultat() {
        System.out.println("\n------ Result ------");

        int lignes = reportLines();
        int classPresent = reportClass();
        int curly = reportCurly();
        int variablesClass = reportSemiColonClass();
        int variablesMethod = reportSemiColonMethod();

        int resultat = lignes + variablesClass + variablesMethod + curly + classPresent;
        System.out.println("\nNombre de lignes : " + expr.size());
        System.out.println("Variables de méthodes : " + this.methodVariables);
        System.out.println("Attributs de classe : " + this.classVariables);
        System.out.println("La note de votre code est de " + resultat + "/5");
    }

    public int reportLines() {
        if(expr.size() < 200) {
            System.out.println("Le fichier fait moins de 200 lignes : 1 point");
            return 1;
        } else {
            System.out.println("Le fichier fait plus de 200 lignes et cela n'est pas conforme a la bonne pratique de programmation en java : 0 point");
            return 0;
        }
    }

    public int reportClass() {
    	for(ExpressionsFactory e: expr) { 
			if(e.getType().equals("OpenClass")) {
				System.out.println("Le fichier est bien une classe : 1 point");
				return 1;
			}
		}
		System.out.println("Le fichier n'est pas une classe : 0 point");
		return 0;
    }

    public int  reportSemiColonClass() {
    	int correct = 0;
		int nbr = 0;
		for(int i = 0; i < expr.size(); i++) {
			if(expr.get(i).getType().equals("ClassAttribute")) {
				nbr++;
				classVariables++;
				if(expr.get(i+1).getType().equals("EndInstruct")) {
					correct++;
				}
			}
		}
        if(correct == nbr) {
            System.out.println("Les fins d'instruction pour les déclarations des attributs de classe sont bien respectés : 1 point");
            return 1;
        }
        else {
            System.out.println("Il manque un ou plusieurs points virgule après declaration des attributs de classe : 0 point");
            return 0;
        }
    }

    public int reportSemiColonMethod() {
    	int correct = 0;
		int nbr = 0;
		for(int i = 0; i < expr.size(); i++) {
			if(expr.get(i).getType().equals("MethodVariable")) {
				nbr++;
				if(expr.get(i + 1).getType().equals("EndInstruct")) {
					correct++;
				}
			}
		}
        if(correct == nbr) {
            System.out.println("Les fins d'instruction pour les déclarations des attributs de methode sont bien respectés : 1 point");
            return 1;
        }
        else {
            System.out.println("Il manque un ou plusieurs points virgule après declaration de variables de methodes : 0 point");
            return 0;
        }
    }

    public int reportCurly() {
        int correct = 0;
        int nbr = 0;
		for(ExpressionsFactory e : expr) { 
			if(e.getType().equals("OpenClass")) {
				nbr++;
			}
			if(e.getType().equals("EndClass")) {
				correct++;
			}
			if(e.getType().equals("OpenMethod")) {
				methodVariables++;
				nbr++;
			}
			if(e.getType().equals("EndMethod")) {
				correct++;
			}
		}
		if(correct == nbr) {
			System.out.println("Toutes les méthodes et classe ouvertes ont bien été fermées : 1 point");
			return 1;
		}
		else {
			System.out.println("une classe ou une methode n'est pas fermée : 0 point");
			return 0;
		}
    }
}
