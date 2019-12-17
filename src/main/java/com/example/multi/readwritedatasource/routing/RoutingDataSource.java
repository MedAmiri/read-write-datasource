package com.example.multi.readwritedatasource.routing;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class RoutingDataSource extends AbstractRoutingDataSource {

	private static final ThreadLocal<Route> routeContext = new ThreadLocal<>();

	public enum Route {
		PRIMARY, REPLICA
	}

	public static void clearRoute() {
		routeContext.remove();
	}
	
	public static void setPrimaryRoute() {
		routeContext.set(Route.PRIMARY);
	}
	
	public static void setReplicaRoute() {
		routeContext.set(Route.REPLICA);
	}

	@Override
	protected Object determineCurrentLookupKey() {
		return routeContext.get();
	}
}
