package devices;

public class ConcreteScanner extends Device implements Scanner{

	public ConcreteScanner(String serialNumber) {
		super(serialNumber);
	}

	@Override
	public String scan() {
		return "Scanned Content.";
	}

	@Override
	public void processDoc(String doc) {

		System.out.println("Scanner Processign: " + doc);
	}

	
}
