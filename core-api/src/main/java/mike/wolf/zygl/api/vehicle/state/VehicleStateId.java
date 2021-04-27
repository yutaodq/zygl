package mike.wolf.zygl.api.vehicle.state;

public final class VehicleStateId extends AbstractAggregateIdentifier {

    private ProductId() {
        super();
        log.info("新建：ProductId");
    }

    private ProductId(String identifier) {
        super(identifier);
        log.info("新建：ProductId");
    }

    public static ProductId create() {
        return new ProductId();
    }

    public static ProductId create(String identifier) {
        return new ProductId(identifier);
    }

    @Override
    public String toString() {
        return "ProductId{" + "identifier='" + getIdentifier() + '\'' + '}';
    }
}
