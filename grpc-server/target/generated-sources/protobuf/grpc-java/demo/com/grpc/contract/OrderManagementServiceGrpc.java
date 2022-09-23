package demo.com.grpc.contract;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: OrderManagementService.proto")
public final class OrderManagementServiceGrpc {

  private OrderManagementServiceGrpc() {}

  public static final String SERVICE_NAME = "demo.com.grpc.contract.OrderManagementService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<demo.com.grpc.contract.OrderId,
      demo.com.grpc.contract.Order> METHOD_GET_ORDER =
      io.grpc.MethodDescriptor.<demo.com.grpc.contract.OrderId, demo.com.grpc.contract.Order>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "demo.com.grpc.contract.OrderManagementService", "getOrder"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.com.grpc.contract.OrderId.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.com.grpc.contract.Order.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<demo.com.grpc.contract.SearchTerm,
      demo.com.grpc.contract.Order> METHOD_SEARCH_ORDERS =
      io.grpc.MethodDescriptor.<demo.com.grpc.contract.SearchTerm, demo.com.grpc.contract.Order>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "demo.com.grpc.contract.OrderManagementService", "searchOrders"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.com.grpc.contract.SearchTerm.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.com.grpc.contract.Order.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<demo.com.grpc.contract.Item,
      demo.com.grpc.contract.Cart> METHOD_GET_TOTAL_CART_VALUE =
      io.grpc.MethodDescriptor.<demo.com.grpc.contract.Item, demo.com.grpc.contract.Cart>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "demo.com.grpc.contract.OrderManagementService", "getTotalCartValue"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.com.grpc.contract.Item.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.com.grpc.contract.Cart.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<demo.com.grpc.contract.Item,
      demo.com.grpc.contract.Cart> METHOD_GET_LIVE_CART_VALUE =
      io.grpc.MethodDescriptor.<demo.com.grpc.contract.Item, demo.com.grpc.contract.Cart>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "demo.com.grpc.contract.OrderManagementService", "getLiveCartValue"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.com.grpc.contract.Item.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              demo.com.grpc.contract.Cart.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderManagementServiceStub newStub(io.grpc.Channel channel) {
    return new OrderManagementServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OrderManagementServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OrderManagementServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class OrderManagementServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * single rpc
     * </pre>
     */
    public void getOrder(demo.com.grpc.contract.OrderId request,
        io.grpc.stub.StreamObserver<demo.com.grpc.contract.Order> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_ORDER, responseObserver);
    }

    /**
     * <pre>
     * server streaming
     * </pre>
     */
    public void searchOrders(demo.com.grpc.contract.SearchTerm request,
        io.grpc.stub.StreamObserver<demo.com.grpc.contract.Order> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SEARCH_ORDERS, responseObserver);
    }

    /**
     * <pre>
     * client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<demo.com.grpc.contract.Item> getTotalCartValue(
        io.grpc.stub.StreamObserver<demo.com.grpc.contract.Cart> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_TOTAL_CART_VALUE, responseObserver);
    }

    /**
     * <pre>
     * bidirectional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<demo.com.grpc.contract.Item> getLiveCartValue(
        io.grpc.stub.StreamObserver<demo.com.grpc.contract.Cart> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_LIVE_CART_VALUE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_ORDER,
            asyncUnaryCall(
              new MethodHandlers<
                demo.com.grpc.contract.OrderId,
                demo.com.grpc.contract.Order>(
                  this, METHODID_GET_ORDER)))
          .addMethod(
            METHOD_SEARCH_ORDERS,
            asyncServerStreamingCall(
              new MethodHandlers<
                demo.com.grpc.contract.SearchTerm,
                demo.com.grpc.contract.Order>(
                  this, METHODID_SEARCH_ORDERS)))
          .addMethod(
            METHOD_GET_TOTAL_CART_VALUE,
            asyncClientStreamingCall(
              new MethodHandlers<
                demo.com.grpc.contract.Item,
                demo.com.grpc.contract.Cart>(
                  this, METHODID_GET_TOTAL_CART_VALUE)))
          .addMethod(
            METHOD_GET_LIVE_CART_VALUE,
            asyncBidiStreamingCall(
              new MethodHandlers<
                demo.com.grpc.contract.Item,
                demo.com.grpc.contract.Cart>(
                  this, METHODID_GET_LIVE_CART_VALUE)))
          .build();
    }
  }

  /**
   */
  public static final class OrderManagementServiceStub extends io.grpc.stub.AbstractStub<OrderManagementServiceStub> {
    private OrderManagementServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderManagementServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderManagementServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * single rpc
     * </pre>
     */
    public void getOrder(demo.com.grpc.contract.OrderId request,
        io.grpc.stub.StreamObserver<demo.com.grpc.contract.Order> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_ORDER, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * server streaming
     * </pre>
     */
    public void searchOrders(demo.com.grpc.contract.SearchTerm request,
        io.grpc.stub.StreamObserver<demo.com.grpc.contract.Order> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_SEARCH_ORDERS, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * client streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<demo.com.grpc.contract.Item> getTotalCartValue(
        io.grpc.stub.StreamObserver<demo.com.grpc.contract.Cart> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_GET_TOTAL_CART_VALUE, getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * bidirectional streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<demo.com.grpc.contract.Item> getLiveCartValue(
        io.grpc.stub.StreamObserver<demo.com.grpc.contract.Cart> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_LIVE_CART_VALUE, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class OrderManagementServiceBlockingStub extends io.grpc.stub.AbstractStub<OrderManagementServiceBlockingStub> {
    private OrderManagementServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderManagementServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * single rpc
     * </pre>
     */
    public demo.com.grpc.contract.Order getOrder(demo.com.grpc.contract.OrderId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_ORDER, getCallOptions(), request);
    }

    /**
     * <pre>
     * server streaming
     * </pre>
     */
    public java.util.Iterator<demo.com.grpc.contract.Order> searchOrders(
        demo.com.grpc.contract.SearchTerm request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_SEARCH_ORDERS, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class OrderManagementServiceFutureStub extends io.grpc.stub.AbstractStub<OrderManagementServiceFutureStub> {
    private OrderManagementServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderManagementServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderManagementServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * single rpc
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<demo.com.grpc.contract.Order> getOrder(
        demo.com.grpc.contract.OrderId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_ORDER, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ORDER = 0;
  private static final int METHODID_SEARCH_ORDERS = 1;
  private static final int METHODID_GET_TOTAL_CART_VALUE = 2;
  private static final int METHODID_GET_LIVE_CART_VALUE = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OrderManagementServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OrderManagementServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ORDER:
          serviceImpl.getOrder((demo.com.grpc.contract.OrderId) request,
              (io.grpc.stub.StreamObserver<demo.com.grpc.contract.Order>) responseObserver);
          break;
        case METHODID_SEARCH_ORDERS:
          serviceImpl.searchOrders((demo.com.grpc.contract.SearchTerm) request,
              (io.grpc.stub.StreamObserver<demo.com.grpc.contract.Order>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TOTAL_CART_VALUE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getTotalCartValue(
              (io.grpc.stub.StreamObserver<demo.com.grpc.contract.Cart>) responseObserver);
        case METHODID_GET_LIVE_CART_VALUE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getLiveCartValue(
              (io.grpc.stub.StreamObserver<demo.com.grpc.contract.Cart>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class OrderManagementServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return demo.com.grpc.contract.OrderManagementServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (OrderManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderManagementServiceDescriptorSupplier())
              .addMethod(METHOD_GET_ORDER)
              .addMethod(METHOD_SEARCH_ORDERS)
              .addMethod(METHOD_GET_TOTAL_CART_VALUE)
              .addMethod(METHOD_GET_LIVE_CART_VALUE)
              .build();
        }
      }
    }
    return result;
  }
}
