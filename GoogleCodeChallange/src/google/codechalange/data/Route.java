package reply.codechalange.data;

import java.util.List;


public class Route
{
	List<Point> coordinateRoute;

	String route;


	public List<Point> getCoordinateRoute()
	{
		return coordinateRoute;
	}

	public void setCoordinateRoute(final List<Point> coordinateRoute)
	{
		this.coordinateRoute = coordinateRoute;
	}

	public String getRoute()
	{
		return route;
	}

	public void setRoute(final String route)
	{
		this.route = route;
	}

	public Route(final List<Point> coordinateRoute, final String route)
	{
		this.coordinateRoute = coordinateRoute;
		this.route = route;
	}

	public List<Point> getCoordinateRoute()
	{
		return coordinateRoute;
	}

	public void setCoordinateRoute(final List<Point> coordinateRoute)
	{
		this.coordinateRoute = coordinateRoute;
	}

	public String getRoute()
	{
		return route;
	}

	public void setRoute(final String route)
	{
		this.route = route;
	}
}
