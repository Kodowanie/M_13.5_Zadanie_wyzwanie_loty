package good.patterns.v1;

public abstract class AbstractFlightRoute  {
    String flightFrom;
    String flightTo;

    public AbstractFlightRoute(String flightFrom, String flightTo) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
    }

    public abstract String getFlightFrom();

    public abstract String getFlightTo();

    public abstract boolean equals(Object o);

    public abstract int hashCode();

    public abstract String toString();
}
