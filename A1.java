import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1 {
	String beginCity;
	String endCity;
	int visitCount = 0;
	static String depart;
	static String dest;
	static String[] cityNames = {"ORADEA", "ZERIND", "ARAD", "TIMISOARA", "LUGOJ", "MEHADIA", 
		"DROBETA", "CRAIOVA","SIBIU", "FAGARAS", "RIMNICU VILCEA", "PITESTI",
		"BUCHAREST", "GIURGIU", "URZICENI", "HIRSOVA", "EFORIE", "VASLUI", "IASI", "NEAMT"};
	
	static int[][] adjacencyMatrix = {
			{0, 71, 0, 0, 0, 0, 0, 0, 151, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //Oradea
			{71, 0, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //Zerind
			{0, 75, 0, 118, 0, 0, 0, 0, 140, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //Arad
			{0, 0, 118, 0, 111, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //Timisoara 
			{0, 0, 0, 111, 0, 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //Lugoj
			{0, 0, 0, 0, 70, 0, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //Mehadia
			{0, 0, 0, 0, 0, 75, 0, 120, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //Drobeta
			{0, 0, 0, 0, 0, 0, 120, 0, 0, 0, 146, 138, 0, 0, 0, 0, 0, 0, 0, 0}, //Craiova
			{151, 0, 140, 0, 0, 0, 0, 0, 0, 99, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //Sibiu
			{0, 0, 0, 0, 0, 0, 0, 0, 99, 0, 0, 0, 211, 0, 0, 0, 0, 0, 0, 0}, //Fagaras
			{0, 0, 0, 0, 0, 0, 0, 146, 80, 0, 0, 97, 0, 0, 0, 0, 0, 0, 0, 0}, //RV
			{0, 0, 0, 0, 0, 0, 0, 138, 0, 0, 97, 0, 101, 0, 0, 0, 0, 0, 0, 0}, //Pitesti
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 211, 0, 101, 0, 90, 85, 0, 0, 0, 0, 0}, //Bucharest
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 90, 0, 0, 0, 0, 0, 0, 0}, //Giurgiu
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 85, 0, 0, 98, 0, 142, 0, 0}, //Urziceni
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 98, 0, 86, 0, 0, 0}, //Hirsova
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 86, 0, 0, 0, 0}, //Eforie
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 142, 0, 0, 0, 92, 0}, //Vaslui
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 92, 0, 87}, //Iasi
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 87, 0} //Neamt
	};

	public static void main(String [] args) throws IOException {
		String algo;
		int depCityInd, destCityInd;
		// Ask user to end start city and end city
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter departure city (in all CAPS)");
		getBegCity(br.readLine());

		System.out.println("Enter destination city (in all CAPS)");
		getDestCity(br.readLine());

		// Ask user what search strategy to use
		System.out.println("Choose a search strategy:");
		System.out.println("Enter 1 for Breadth First Search, 2 for Depth First Search, and 3 for Uniform Cost Search");
		
		 algo = br.readLine();
		 
		depCityInd = getCityIndex(depart);
		destCityInd = getCityIndex(dest);
		
		if(algo.equals("1")){ //Breadth first search
			System.out.println(BFS.bfs(depCityInd, destCityInd));
		}
		else if(algo.equals("2")){ // Depth first search
			System.out.println(DFS.dfs(depCityInd, destCityInd));
		}
		else if(algo.equals("3")){ // Uniform cost search
			System.out.println(UCS.ucs(depCityInd, destCityInd));
		}
		else
			System.out.println("Please try again");
		
	} // end main

	public static String getBegCity(String input1){
		for(int i=0;i<20;i++){
			if(cityNames[i].equals(input1)){
				depart = input1;
			}
		}
		return depart;
	}

	public static String getDestCity(String input2){
		for(int x=0;x<20;x++){
			if(cityNames[x].equals(input2)){
				dest = input2;
			}
		}
		return dest;
	}

	public static int getCityIndex(String cityName){
		int index1 = -1;
		for(int y=0;y<20;y++){
			if(cityNames[y].equals(cityName)){
				index1 = y;
			}
		}
		return index1;
	}
	
	public static String getCityName(int cityIndex){
		return cityNames[cityIndex];
		
	}

}// end class
