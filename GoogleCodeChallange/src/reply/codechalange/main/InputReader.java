package reply.codechalange.main;

import reply.codechalange.data.Customer;
import reply.codechalange.data.Output;
import reply.codechalange.data.Point;
import reply.codechalange.data.RouteIterator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class InputReader
{
	public static Map<Character, Integer> terrainValueMap = new HashMap<>();

	public static void main(final String[] args)
	{
		terrainValueMap = getTerrainMap();
		final File f = new File("resources/1_victoria_lake.txt");
		try
		{
			final FileInputStream inputStream = new FileInputStream(f);
			final Scanner sc = new Scanner(inputStream, "UTF-8");

			System.out.println("Start reading file......");


			final String firstLine = sc.nextLine();
			final String[] firstArr = firstLine.split("\\s");
			int customerOffices = Integer.parseInt(firstArr[2]);

			final int n = Integer.parseInt(firstArr[0]);
			final int m = Integer.parseInt(firstArr[1]);
			final char[][] grid = new char[m][n];
			final int[][] intGrid = new int[m][n];

			final List<Customer> customers = new ArrayList<>();
			int customerId = 1;
			while (customerOffices > 0)
			{
				final String cutomerOffice = sc.nextLine();
				final String[] arrCustOffice = cutomerOffice.split("\\s");

				final Point point = new Point(Integer.parseInt(arrCustOffice[0]), Integer.parseInt(arrCustOffice[1]));
				final Customer customer = new Customer(customerId, point,
						Integer.parseInt(arrCustOffice[2]));
				customers.add(customer);

				customerOffices--;
				customerId++;
			}

			int countRow = 0;

			while (sc.hasNextLine())
			{

				final String line = sc.nextLine();
				for (int i = 0; i < n; i++)
				{


					grid[countRow][i] = line.charAt(i);

					intGrid[countRow][i]= terrainValueMap.get(line.charAt(i));

				}
				countRow++;
			}


			System.out.println("Finished reading file......");
			System.out.println(intGrid);

			final List<RouteIterator> routeIterators = findRoutesBetweenCustomers(grid, customers, terrainValueMap);
			//create Route iterator for each coordinate in the grid

			//Iterate the Route iterator to find the apt offices

			//populate the Output object

			//convert the output object to a file


			final Output student = new Output(1, 2, "uuuddddrrrlll");
			//			WriteObjectToFile(student);
		}
		catch (final FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private static List<RouteIterator> findRoutesBetweenCustomers(final char[][] grid, final List<Customer> customers,
			final Map<Character, Integer> terrainValueMap)
	{
		final List<RouteIterator> routeIterators = new ArrayList<>();
		for (final Customer customer : customers)
		{


			terrainValueMap.get(grid[customer.getPoint().getX()][customer.getPoint().getY()]);





//			final RouteIterator routeIterator = new RouteIterator();
//			routeIterators.add(routeIterator);

		}

		return routeIterators;
	}

	public int maximumMinimumPath(final char[][] A) {
		final int[][] DIRS = {{0,1},{1,0},{0,-1},{-1,0}};
		final Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
		pq.add(new int[] {A[0][0], 0, 0});
		int maxscore = A[0][0];
		A[0][0] = 'v'; // visited
		while(!pq.isEmpty()) {
			final int[] top = pq.poll();
			final int i = top[1], j = top[2], n = A.length, m = A[0].length;
			maxscore = Math.min(maxscore, top[0]);
			if(i == n - 1 && j == m - 1)
				break;
			for(final int[] d : DIRS) {
				final int newi = d[0] + i, newj = d[1] + j;
				if(newi >= 0 && newi < n && newj >= 0 && newj < m && A[newi][newj]>=0){
					pq.add(new int[] {A[newi][newj], newi, newj});
					A[newi][newj] = 'v';
				}
			}
		}
		return maxscore;
	}

	private static Map<Character, Integer> getTerrainMap()
	{
		final Map<Character, Integer> terrainValueMap = new HashMap<>();
		terrainValueMap.put('~', 800);
		terrainValueMap.put('*', 200);
		terrainValueMap.put('+', 150);
		terrainValueMap.put('X', 120);
		terrainValueMap.put('_', 100);
		terrainValueMap.put('H', 70);
		terrainValueMap.put('T', 50);
		terrainValueMap.put('#', 0);

		return terrainValueMap;
	}


	public void WriteObjectToFile(final Output result)
	{
		try
		{
			// approach 1
			final FileOutputStream fileOut = new FileOutputStream("resources/result.txt");
			final ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(result);
			objectOut.close();
			fileOut.close();
			// approach 2
			final PrintWriter out = new PrintWriter(new FileWriter("resources/output.txt", true), true);
			out.write(result.getX() + " " + result.getY() + " " + result.getPath());
			out.close();

			System.out.println("The Object  was succesfully written to a file");

		}
		catch (final Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
