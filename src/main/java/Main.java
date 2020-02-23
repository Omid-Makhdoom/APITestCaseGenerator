import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Parser parser=new Parser();
		
		System.out.println("enter swagger localpath or url:");
		
		Scanner in = new Scanner(System.in);
		String swaggerpath = in. nextLine();
		in.close();		
		
		ArrayList<HttpRequest> reqList =  parser.pares(swaggerpath);
		for(HttpRequest req: reqList) {
			
		//	req.printrequest();
			
			RequestGenerator reqgenerator=new RequestGenerator(req);
					System.out.println(reqgenerator.validRequest()+"\n-----------------------\n"+
					reqgenerator.invalidinputParameters()+"\n-----------------------\n"+
					reqgenerator.invalidHeaderRequests()+"\n-----------------------\n"+
					reqgenerator.invalidParametersRequests()+"\n-----------------------\n"	);
		
			
		}
		
	}

}
