package application;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		//<tag "Exemplo de Covariância">
		List<Integer> intList = new ArrayList<Integer>(); 
		
		intList.add(10);
		intList.add(5);
		
		// o extends é o segredo da Covariância, pois ele extende a classe referenciada
		List<? extends Number> list = intList;
		Number x = list.get(0);
		// list.add(20);  erro de compilacao
		//</tag É permitido o GET mas não é permitido o PUT, ou seja n pode inserir>
		
		//<tag Exemplo de Contravariância>
		List<Object> myObjs = new ArrayList<Object>();
		
		myObjs.add("Maria");
		myObjs.add("Alex");
		
		// o super é o segredo da Contravariância, pois ela informa q pode ser um supertipo da Classe em questão
		List<? super Number> myNums = myObjs;
		myNums.add(10);
		myNums.add(3.14);
		// Number x = myNums.get(0);  erro de compilacao
		//</tag É permitido o PUT mas não é permitido o GET, ou seja n pode inserir>
	}

}
