package demo.com.grpc.models;

public class OrderResponse {

    private String id;
    private int quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    public OrderResponse(String id, int quantity, int price){
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }


}
