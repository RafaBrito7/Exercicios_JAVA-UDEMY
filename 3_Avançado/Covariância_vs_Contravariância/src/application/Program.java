package application;

import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		//<tag "Exemplo de Covari�ncia">
		List<Integer> intList = new ArrayList<Integer>(); 
		
		intList.add(10);
		intList.add(5);
		
		// o extends � o segredo da Covari�ncia, pois ele extende a classe referenciada
		List<? extends Number> list = intList;
		Number x = list.get(0);
		// list.add(20);  erro de compilacao
		//</tag � permitido o GET mas n�o � permitido o PUT, ou seja n pode inserir>
		
		//<tag Exemplo de Contravari�ncia>
		List<Object> myObjs = new ArrayList<Object>();
		
		myObjs.add("Maria");
		myObjs.add("Alex");
		
		// o super � o segredo da Contravari�ncia, pois ela informa q pode ser um supertipo da Classe em quest�o
		List<? super Number> myNums = myObjs;
		myNums.add(10);
		myNums.add(3.14);
		// Number x = myNums.get(0);  erro de compilacao
		//</tag � permitido o PUT mas n�o � permitido o GET, ou seja n pode inserir>
	}

}
