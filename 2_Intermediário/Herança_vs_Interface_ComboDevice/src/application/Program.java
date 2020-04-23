package application;

import devices.ComboDevice;
import devices.ConcretePrinter;
import devices.ConcreteScanner;

public class Program {
	
	public static void main(String[] args) {
		ConcretePrinter p = new ConcretePrinter("5541");
		p.processDoc("My Example");
		p.print("My Example 2");
		
		System.out.println();
		ConcreteScanner s = new ConcreteScanner("1248");
		s.processDoc("My Little");
		System.out.println("Scan result " + s.scan());
		
		System.out.println();
		ComboDevice c = new ComboDevice("7412");
		c.processDoc("My Poney");
		c.print("My Dissertation");
		System.out.println("Scan result " + c.scan());
	}

}
