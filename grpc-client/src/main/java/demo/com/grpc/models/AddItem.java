package demo.com.grpc.models;

public class AddItem {

    private String id;
    private String quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;

    public AddItem(String id, String quantity, String price){
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public AddItem() {
    }
}
