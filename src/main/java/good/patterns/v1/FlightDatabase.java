package good.patterns.v1;

import good.patterns.v1.abstraction.IFlightDatabase;

import java.util.HashMap;
import java.util.Map;

public class FlightDatabase implements IFlightDatabase {

    private AbstractFlightRoute flightRoute;

    @Override
    public Map<String, String> flightMap(AbstractFlightRoute flightRoute){
        Map <String, String> map = new HashMap<>();
        map.put(flightRoute.flightFrom, flightRoute.flightTo);
        return map;
    }
}
