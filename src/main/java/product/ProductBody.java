package product;

public class ProductBody {

    private int id;
    private final String name;
    private final String description;
    private final double price;
    private final int category_id;

    // Update created body
    public ProductBody(int id, String name, String descrption, double price,
                       int category_id) {
        this(name, descrption, price, category_id);
        this.id = id;
    }

    // Body creation
    public ProductBody(String name, String descrption, double price,
                       int category_id) {
        this.name = name;
        this.description = descrption;
        this.price = price;
        this.category_id = category_id;
    }

    // Getter methods
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public int getCategory_id() {
        return this.category_id;
    }
}
