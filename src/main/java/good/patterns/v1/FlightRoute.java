package good.patterns.v1;

public class FlightRoute extends AbstractFlightRoute {

    public FlightRoute(String flightFrom, String flightTo) {
        super(flightFrom, flightTo);
    }

    @Override
    public String getFlightFrom() {
        return flightFrom;
    }

    @Override
    public String getFlightTo() {
        return flightTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightRoute that)) return false;

        if (!flightFrom.equals(that.flightFrom)) return false;
        return flightTo.equals(that.flightTo);
    }

    @Override
    public int hashCode() {
        int result = flightFrom.hashCode();
        result = 31 * result + flightTo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FlightRoute{" +
                "flightFrom='" + flightFrom + '\'' +
                ", flightTo='" + flightTo + '\'' +
                '}';
    }
}
