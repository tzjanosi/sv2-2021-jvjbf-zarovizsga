package shipping;

public class NationalPackage implements Transportable{
    private int weight;
    private boolean breakable;
    public static final int BASIC_PRICE=1000;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    @Override
    public int calculateShippingPrice() {
        return breakable?2*BASIC_PRICE:BASIC_PRICE;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }
}
