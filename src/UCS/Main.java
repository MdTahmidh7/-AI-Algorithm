package UCS;

import java.util.Scanner;

public class Main {

    public static void ucs(int [][] adjacencyMatrix){
        int v = adjacencyMatrix.length;
        boolean visited [] = new boolean[v];
        int distance [] = new int[v];
        distance[0] =0;
        for (int i = 1; i <v ; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < v-1; i++) {
            //find vertex with min dist
           int minVertex =  findMinVertex(distance,visited);
           visited[minVertex] = true;
           // Explore neighbour
            for (int j = 0; j <v ; j++) {
                if(adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE){
                    int newDistance = distance[minVertex] + adjacencyMatrix[minVertex][j];
                    if(newDistance < distance[j]){
                        distance[j] = newDistance;
                    }
                }
            }

        }
        for (int i = 0; i <v ; i++) {
            System.out.println("i = "+ i + "   "+ distance[i]+ "");
        }
    }

    private static int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < distance.length ; i++) {
                if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex]) ){
                        minVertex =i;
                }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        int adjacencyMatrix [] []= new int[v][v];
        for (int i = 0; i <e ; i++) {
            int v1 = scanner.nextInt();
            int v2= scanner.nextInt();
            int weight = scanner.nextInt();
            adjacencyMatrix [v1][v2] = weight;
            adjacencyMatrix [v2][v1] = weight;
        }
        ucs(adjacencyMatrix);
    }
}
