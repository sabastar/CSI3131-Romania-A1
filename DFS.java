import java.util.LinkedList;

public class DFS extends A1 {
	
	public DFS(int [][] adjacencyMatrix ){
		super();
	}
	
	public static String dfs(int dep, int dest){  // LIFO queue
		boolean[] expanded = new boolean[20];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] parent = new int[20];
		int pointer;
		int maxCities = 0;
		int x;
		int visited=0;

		System.out.println("*** Depth First Search ***");
		System.out.println("Below is the path");


		for(int i=0; i<20; i++){
			parent[i] = -1;
		}

		expanded[dep] = true;
		queue.add(dep);

		if(dep == dest){ // already at destination city
			return ("Already at destination city");
		}

		while(!queue.isEmpty()){
			pointer = queue.removeLast(); //LIFO
			visited++;

			if(pointer==dest){
				System.out.println("Reached " + A1.getCityName(dest));
				System.out.println("Visited: " + visited);
				return ("Number of cities expanded is (max number of nodes generated): " + maxCities);
			}

			for(x=0; x<20; x++){
				if(adjacencyMatrix[pointer][x] != 0 && expanded[x] == false){

					expanded[x] = true;
					parent[x] = pointer;
					queue.add(x);
				}

			}
			if(queue.size() >0){
				System.out.println(A1.getCityName(pointer));
			}

			if(queue.size()>maxCities){
				maxCities = queue.size();
			}
		}
		return "No cities traversed";
	}// end dfs
	

}
