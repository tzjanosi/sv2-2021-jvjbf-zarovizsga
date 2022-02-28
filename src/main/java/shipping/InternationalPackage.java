package shipping;

public class InternationalPackage implements Transportable, Comparable<InternationalPackage>{
    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;
    public static final int BASIC_PRICE=1200;
    public static final int KM_PRICE=10;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    @Override
    public int compareTo(InternationalPackage o) {
        return distance-o.distance;
    }

    @Override
    public int calculateShippingPrice() {
        return (breakable?2*BASIC_PRICE:BASIC_PRICE)+distance*KM_PRICE;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }
}
