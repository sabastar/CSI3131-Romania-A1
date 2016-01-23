import java.util.Comparator;
import java.util.PriorityQueue;

public class UCS extends A1{
	
	public UCS(int [][] adjacencyMatrix ){
		super();
	}
	
	static class shortestDist implements Comparator<int[]> {

		public int compare(int[] o1, int[] o2) {

			return o1[1]-o2[1];
		}
	}
	
	public static String ucs(int dep, int dest){
		boolean[] expanded = new boolean[20];
		int[] parent = new int[20];
		int[] pointer;
		int maxCities = 0;
		shortestDist dist = new shortestDist();
		int d;
		int visited = 0;
		int cost;
		PriorityQueue<int[]> prioQ = new PriorityQueue<int[]>(dist); // lowest path cost queue (using comparator)

		System.out.println("*** Uniform Cost Search ***");
		System.out.println("Below is the path");

		for(int i=0; i<20; i++){
			parent[i] = -1;
		}

		int [] origin= new int[]{dep, 0};
		expanded[dep] = true;

		prioQ.add(origin);

		if(dep == dest){ // already at destination city
			return ("Already at destination city");
		}

		while(!prioQ.isEmpty()){
			pointer = prioQ.poll();
			visited++;

			if(pointer[0]== dest){
				System.out.println("Reached " + A1.getCityName(dest));
				System.out.println("Visited: " + visited);
				return "Number of cities expanded is (max number of nodes generated): " + maxCities;

			}

			for(d=0; d<20; d++){
				cost = adjacencyMatrix[pointer[0]][d];
				if(cost != 0 && expanded[d] == false){
					expanded[d] = true;
					parent[d] = pointer[0];
					int[] next = new int[] {d, pointer[0]+cost};
					prioQ.add(next);
				}
			}

				if(prioQ.size() >0){
					System.out.println(A1.getCityName(pointer[0]));

				}
			
			if(prioQ.size()>maxCities){
				maxCities = prioQ.size();

			}
		}

		return "No cities traversed";
	}// end ucs


}
