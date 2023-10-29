package good.patterns.v2.abstraction;

import good.patterns.v2.AbstractFlightRoute;

import java.util.Map;

public interface IFlightDatabase {
    Map<String, String> flightMap(AbstractFlightRoute flightRoute);
}
