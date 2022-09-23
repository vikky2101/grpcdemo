package demo.com.grpc.service;
import demo.com.grpc.contract.OrderManagementServiceGrpc;
import demo.com.grpc.contract.Order;
import demo.com.grpc.contract.OrderId;
import demo.com.grpc.contract.SearchTerm;
import demo.com.grpc.contract.Cart;
import demo.com.grpc.contract.Item;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import java.util.HashMap;
import java.util.Map;



@GrpcService
public class OrderManagementServiceImpl extends OrderManagementServiceGrpc.OrderManagementServiceImplBase{

    @Override
    public void getOrder(OrderId request,
                                StreamObserver<Order> responseObserver){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String id = request.getId();
        Map<String, String[]> orderMap = new HashMap<>();
        orderMap.put("100", new String[]{"100", "1000", "10"});
        orderMap.put("101", new String[]{"101", "1001", "11"});
        String[] order = orderMap.get(id);
        Order response = Order.newBuilder()
                .setId(id)
                .setPrice(Integer.valueOf(order[1]))
                .setItemQuantity(Integer.valueOf(order[2]))
                .build();
        System.out.println("Sending order response to client DateTime: "+ java.time.LocalDateTime.now());
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void searchOrders(SearchTerm searchTerm,
                             StreamObserver<Order> responseObserver) {
        Map<String, String[]> orderMap = new HashMap<>();
        orderMap.put("milk", new String[]{"100", "1000", "10"});
        orderMap.put("bread", new String[]{"101", "1001", "11"});
        orderMap.put("milk1", new String[]{"102", "1000", "10"});
        orderMap.put("bread1", new String[]{"103", "1001", "11"});
        orderMap.put("milk2", new String[]{"104", "1000", "10"});
        orderMap.put("bread2", new String[]{"105", "1001", "11"});
        orderMap.put("milk3", new String[]{"106", "1000", "10"});
        orderMap.put("bread3", new String[]{"107", "1001", "11"});
        orderMap.put("milk2", new String[]{"100", "1000", "10"});
        orderMap.put("bread5", new String[]{"101", "1001", "11"});
        orderMap.put("milk15", new String[]{"102", "1000", "10"});
        orderMap.put("bread15", new String[]{"103", "1001", "11"});
        orderMap.put("milk23", new String[]{"104", "1000", "10"});
        orderMap.put("bread25", new String[]{"105", "1001", "11"});
        orderMap.put("milk35", new String[]{"106", "1000", "10"});
        orderMap.put("bread35", new String[]{"107", "1001", "11"});
        String key = searchTerm.getTerm();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        orderMap.forEach(((term, order) -> {
            if(term.contains(key)){
                Order response = Order.newBuilder()
                        .setId(order[0])
                        .setPrice(Integer.valueOf(order[1]))
                        .setItemQuantity(Integer.valueOf(order[2]))
                        .build();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Found order:" + order[0] + " sending to client  DateTime: "+ java.time.LocalDateTime.now());
                responseObserver.onNext(response);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
        responseObserver.onCompleted();
        System.out.println("All response sent by server  DateTime: "+ java.time.LocalDateTime.now());
    }

    @Override
    public StreamObserver<Item> getTotalCartValue(StreamObserver<Cart> responseObserver){
        return new StreamObserver<Item>() {
            int count = 0;
            @Override
            public void onNext(Item item) {
                System.out.println("Processing item name: "+ item.getName() +" Price: "+ item.getPrice() +  " DateTime: "+ java.time.LocalDateTime.now());
                count++;
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Server processed all requests now sending final cart value DateTime: "+ java.time.LocalDateTime.now());
                   responseObserver.onNext(Cart.newBuilder()
                           .setQuantity(count)
                           .setPrice(100*count)
                           .build());
                   responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<Item> getLiveCartValue(StreamObserver<Cart> responseObserver){
        return new StreamObserver<Item>() {
            int count = 0;
            @Override
            public void onNext(Item item) {
                System.out.println("Sending updated cart item name: "+ item.getName() +" Price: "+ item.getPrice() +  " DateTime: "+ java.time.LocalDateTime.now());
                responseObserver.onNext(Cart.newBuilder()
                        .setQuantity(count++)
                        .setPrice(count*100)
                        .build());
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
                System.out.println("Server processed all requests DateTime: "+ java.time.LocalDateTime.now());
                responseObserver.onCompleted();
            }
        };
    }
}
