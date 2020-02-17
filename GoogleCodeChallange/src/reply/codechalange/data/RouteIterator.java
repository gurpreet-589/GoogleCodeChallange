package reply.codechalange.data;

public class RouteIterator
{
	Point office;

	Route route;

	int cost;

	Customer customer;

	public Point getOffice()
	{
		return office;
	}

	public void setOffice(final Point office)
	{
		this.office = office;
	}

	public Route getRoute()
	{
		return route;
	}

	public void setRoute(final Route route)
	{
		this.route = route;
	}

	public int getCost()
	{
		return cost;
	}

	public void setCost(final int cost)
	{
		this.cost = cost;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(final Customer customer)
	{
		this.customer = customer;
	}

	public RouteIterator(final Point office, final Route route, final int cost, final Customer customer)
	{
		this.office = office;
		this.route = route;
		this.cost = cost;
		this.customer = customer;
	}
}
