# Java gRPC with Spring-Boot

gRPC is a RPC framework. It allows to call functions in a remote server as if they were local. It uses *protobuf* (protocol buffer)
to define the message format exchange between the client and the server.
On the server side, there is a gRPC server running an application that implements the interfaces defined in a *protobuf*.
On the client side, there is a *stub* (client) that provides the same functions and comunicates with the server.
The gRPC is independent of a language. It's possible to use diferent languages for implement the server application and
the client application. It's only necessary that every application knows the *protobuf*.