package processes;

import java.util.Scanner;

//Read Data from file
public class ReadData {
	public String colA = " ";
	public String colB = " ";
	public String colC = " ";
  public void readLine(Scanner input) {
  			colA = "";
  			String line;
  			line = input.nextLine();
  			
  			try(Scanner data = new Scanner(line)){
  				String[] parts = line.split("\\,");
  				
  				if(parts[0].length()>0 && parts[0].charAt(0) == '"') {
  					int i = 0;
  					do { 
  						i++;
  						parts[0] = parts[0] + parts[i];
  					}while(parts[i].charAt(parts[i].length()-1) != '"');
  					colA = parts[0];
					colB = parts[i+1];
					colC = parts[i+2];
  				}else {
  					colA = parts[0];
					colB = parts[1];
					colC = parts[2];
  				}
  			}
  			//System.out.println(colA+"\t"+colB+"\t"+colC);
  }
}