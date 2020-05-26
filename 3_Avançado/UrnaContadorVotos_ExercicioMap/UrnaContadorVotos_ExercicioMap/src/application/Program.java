package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a file path source: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			
			Map<String, Integer> mapReport = new TreeMap<>();
			
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int votes = Integer.parseInt(fields[1]);
				
				if (mapReport.containsKey(name)) {
					int votesAux = mapReport.get(name);
					mapReport.put(name, votes + votesAux);
					
				} else {
					mapReport.put(name, votes);
				
				}
				
				line = br.readLine();
			}
			for (String key : mapReport.keySet()) {
				System.out.println(key + ": " + mapReport.get(key));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
