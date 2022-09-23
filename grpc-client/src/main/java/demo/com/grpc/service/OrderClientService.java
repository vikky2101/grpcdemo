package demo.com.grpc.service;

import demo.com.grpc.models.AddItem;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import demo.com.grpc.contract.OrderManagementServiceGrpc;
import demo.com.grpc.contract.Order;
import demo.com.grpc.contract.Item;
import demo.com.grpc.contract.Cart;
import demo.com.grpc.contract.OrderId;
import demo.com.grpc.contract.SearchTerm;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderClientService {

    private ManagedChannel managedChannel;

    public OrderClientService(){
        this.managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090).
                usePlaintext().build();
    }


    public Order getOrder(String orderId){
        OrderManagementServiceGrpc.OrderManagementServiceBlockingStub stub = OrderManagementServiceGrpc.newBlockingStub(managedChannel);
        Order order = null;
        try {
            System.out.println("Sending requested order id: " + orderId + " DateTime: " + java.time.LocalDateTime.now());
            order = stub.getOrder(OrderId.newBuilder()
                    .setId(orderId)
                    .build());
            Thread.sleep(1500);
            System.out.println("Received Order: " + order.getId() + " DateTime: " + java.time.LocalDateTime.now());
        }
        catch (StatusRuntimeException | InterruptedException e)
        {
            System.out.println("RPC failed: "+ e);
        }
        return order;
    }

    public Iterator<Order> searchOrders(String term){
        OrderManagementServiceGrpc.OrderManagementServiceBlockingStub stub = OrderManagementServiceGrpc.newBlockingStub(this.managedChannel);
        System.out.println("sending search query: "+ term);
        Iterator<Order> orders = null;
        try {
            orders = stub.searchOrders(SearchTerm.newBuilder()
                    .setTerm(term)
                    .build());
            while(orders.hasNext()) {
                System.out.println("Order: " + orders.next().getId()+ " DateTime: "+ java.time.LocalDateTime.now());
            }
        }
        catch (StatusRuntimeException e)
        {
            System.out.println("RPC failed: "+ e.getStatus());
        }
        return orders;
    }

    public void addOrders(List<AddItem> itemList) throws InterruptedException {
        StreamObserver<Cart> responseStreamObserver = new StreamObserver<Cart>() {
            @Override
            public void onNext(Cart cart) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Received Cart Value Quantity: " + cart.getQuantity() + " Price: "+ cart.getPrice() + " DateTime: "+ java.time.LocalDateTime.now());
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
               // System.out.println("Client side streaming finished DateTime: "+ java.time.LocalDateTime.now());
            }
        };

        OrderManagementServiceGrpc.OrderManagementServiceStub stub = OrderManagementServiceGrpc.newStub(this.managedChannel);
        try{
            StreamObserver<Item> requestObserver  = stub.getTotalCartValue(responseStreamObserver);
            for(AddItem item: itemList){
                System.out.println("Sending item name: "+ item.getId()+" Price: "+ item.getPrice() +  " DateTime: "+ java.time.LocalDateTime.now());
                requestObserver.onNext(Item.newBuilder().
                        setName(item.getId()).
                        setPrice(item.getPrice()).setQuantity(item.getQuantity()).build());
                Thread.sleep(1500);
            }
            requestObserver.onCompleted();
            System.out.println("All items sent DateTime: "+ java.time.LocalDateTime.now());
        }
        catch (StatusRuntimeException e)
        {
            System.out.println("RPC failed: "+ e.getStatus());
        }

    }

    public void addOrdersV2(List<AddItem> itemList) throws InterruptedException {
        StreamObserver<Cart> responseStreamObserver = new StreamObserver<Cart>() {
            @Override
            public void onNext(Cart cart) {
                System.out.println("Received Live Cart Value Quantity: " + cart.getQuantity() + " Price: "+ cart.getPrice() + "  DateTime: "+ java.time.LocalDateTime.now());
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
                System.out.println("Client Finished bidirectional streaming DateTime: "+ java.time.LocalDateTime.now());
            }
        };

        OrderManagementServiceGrpc.OrderManagementServiceStub stub = OrderManagementServiceGrpc.newStub(this.managedChannel);
        StreamObserver<Item> requestObserver  = stub.getLiveCartValue(responseStreamObserver);
        try{
            for(AddItem item: itemList){
                System.out.println("Sending item name: "+ item.getId()+" Price: "+ item.getPrice() +  " DateTime: "+ java.time.LocalDateTime.now());
                requestObserver.onNext(Item.newBuilder().
                        setName(item.getId()).
                        setPrice(item.getPrice()).setQuantity(item.getQuantity()).build());
                Thread.sleep(1500);
            }
            requestObserver.onCompleted();
            System.out.println("All items sent DateTime: "+ java.time.LocalDateTime.now());
        }
        catch (StatusRuntimeException e)
        {
            System.out.println("RPC failed: "+ e.getStatus());
        }
    }

}
