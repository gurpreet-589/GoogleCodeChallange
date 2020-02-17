package reply.codechalange.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import reply.codechalange.data.Customer;
import reply.codechalange.data.Point;
import reply.codechalange.data.Route;
import reply.codechalange.data.RouteIterator;


public class GraphTraversal
{
	final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public void traverseGraph(final int[][] grid, final Map<Character, Integer> costMap, final List<Customer> customerList)
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				for (final Customer customer: customerList)
				{
					maximumPath(grid, customer, new Point(i, j));
				}
			}
		}

	}


	public RouteIterator maximumPath(final int[][] A, final Customer customer, final Point office)
	{
		final int n = A.length, m = A[0].length;

		final Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
		pq.add(new int[] { A[office.getX()][office.getY()], office.getX(), office.getY() });

		final boolean[][] visited = new boolean[n][m];
		visited[office.getX()][office.getY()] = true; // visited

		final List<Point> routeCoordinates = new ArrayList<>();

		RouteIterator routeIterator = null;
		final StringBuilder stringBuilder = new StringBuilder();

		while (!pq.isEmpty())
		{
			final int[] top = pq.poll();
			final int i = top[1], j = top[2];

			if (null != customer.getPoint() && i == customer.getPoint().getX() && j == customer.getPoint().getY())
			{
				final Route route = new Route(routeCoordinates, stringBuilder.toString());
				routeIterator = new RouteIterator(office, route, 0 , customer);
			}
			for (final int[] d : DIRS)
			{
				final int newi = d[0] + i, newj = d[1] + j;
				if (newi >= 0 && newi < n && newj >= 0 && newj < m && !visited[newi][newj])
				{
					stringBuilder.append(getPath(d[0], d[1]));
					routeCoordinates.add(new Point(newi, newj));
					pq.add(new int[] { A[newi][newj], newi, newj });
					visited[newi][newj] = true;
				}
			}
		}
		return routeIterator;
	}

	private String getPath(final int dirX, final int dirY)
	{
		if(dirX == 1 && dirY == 0)
			return "D";
		else if(dirX == -1 && dirY == 0)
			return "U";
		else if(dirX == 0 && dirY == 1)
			return "R";
		else if(dirX == 0 && dirY == -1)
			return "L";
		return null;
	}


}
