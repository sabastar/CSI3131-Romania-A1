# CSI4106-Romania-A1

Purpose of the assignment is to allow you to experiment with multiple uninformed search algorithms, which will include a representation of Romania, an algorithm for search, and the observation of some metrics associated with the search algorithms you're using.

(Given) The undirected weighted graph represents the connectivity between various cities in Romania. Each edge means that there's is a bidirectional path between the connecting nodes. The number on the edges represents the cost to travel from one city to another. 

Represent the map using an adjacency matrix.
Implement the uninformed search algorithms:
BFS, DFS, UCS

Output: cumulative number of nodes generated (to represent time, including the frontier nodes)
The max number of nodes that existed in memory for any given run (to represented space)
The path (from city to another) that will lead you from source to destination using the algorithm you decided to use

* Assumptions: user knows all the cities already