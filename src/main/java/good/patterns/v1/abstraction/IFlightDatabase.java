package good.patterns.v1.abstraction;

import good.patterns.v1.AbstractFlightRoute;
import good.patterns.v1.FlightRoute;

import java.util.Map;

public interface IFlightDatabase {
    Map<String, String> flightMap(AbstractFlightRoute flightRoute);
}
