package demo.com.grpc.api;

import demo.com.grpc.contract.Order;
import demo.com.grpc.models.OrderResponse;
import demo.com.grpc.models.AddItem;
import demo.com.grpc.service.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderClientService orderClientService;

    @GetMapping("/getOrder/{orderId}")
    public OrderResponse getOrderSummary(@PathVariable("orderId") String orderId){
        try{
            Order order = orderClientService.getOrder(orderId);
            OrderResponse orderResponse = new OrderResponse(order.getId(), order.getItemQuantity(), order.getPrice());
            return orderResponse;
        }
        catch(Exception e) {
            System.out.println("##########################################################################");
            System.out.println("ERROR: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/search/{key}")
    public List<OrderResponse> searchOrders(@PathVariable("key") String key){
        try{
            Iterator<Order> orderSummaryList = orderClientService.searchOrders(key);
            List<OrderResponse> orderResponseList = new ArrayList<>();
            while(orderSummaryList.hasNext()) {
                Order Order = orderSummaryList.next();
                OrderResponse order = new OrderResponse(Order.getId(), Order.getItemQuantity(), Order.getPrice());
                orderResponseList.add(order);
            }
            return orderResponseList;
        }
        catch(Exception e) {
            System.out.println("##########################################################################");
            System.out.println("ERROR: " + e.getMessage());
        }
        return null;
    }

    @PutMapping("/add")
    public void addOrders(@RequestBody List<AddItem> itemList){
        try{
            orderClientService.addOrders(itemList);
        }
        catch(Exception e) {
            System.out.println("##########################################################################");
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    @PostMapping("/add/V2")
    public void addOrdersV2(@RequestBody List<AddItem> itemList){
        try{
            orderClientService.addOrdersV2(itemList);
        }
        catch(Exception e) {
            System.out.println("##########################################################################");
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
