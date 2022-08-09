package smart.medical.realTimeMonitoringService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: RealTimeMonitoringService.proto")
public final class RealTimeMonitoringServiceGrpc {

  private RealTimeMonitoringServiceGrpc() {}

  public static final String SERVICE_NAME = "smart.RealTimeMonitoringService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<smart.medical.realTimeMonitoringService.HeartbeatRequest,
      smart.medical.realTimeMonitoringService.HeartbeatReply> getRealTimeHeartbeatDetectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "realTimeHeartbeatDetection",
      requestType = smart.medical.realTimeMonitoringService.HeartbeatRequest.class,
      responseType = smart.medical.realTimeMonitoringService.HeartbeatReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<smart.medical.realTimeMonitoringService.HeartbeatRequest,
      smart.medical.realTimeMonitoringService.HeartbeatReply> getRealTimeHeartbeatDetectionMethod() {
    io.grpc.MethodDescriptor<smart.medical.realTimeMonitoringService.HeartbeatRequest, smart.medical.realTimeMonitoringService.HeartbeatReply> getRealTimeHeartbeatDetectionMethod;
    if ((getRealTimeHeartbeatDetectionMethod = RealTimeMonitoringServiceGrpc.getRealTimeHeartbeatDetectionMethod) == null) {
      synchronized (RealTimeMonitoringServiceGrpc.class) {
        if ((getRealTimeHeartbeatDetectionMethod = RealTimeMonitoringServiceGrpc.getRealTimeHeartbeatDetectionMethod) == null) {
          RealTimeMonitoringServiceGrpc.getRealTimeHeartbeatDetectionMethod = getRealTimeHeartbeatDetectionMethod = 
              io.grpc.MethodDescriptor.<smart.medical.realTimeMonitoringService.HeartbeatRequest, smart.medical.realTimeMonitoringService.HeartbeatReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smart.RealTimeMonitoringService", "realTimeHeartbeatDetection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.medical.realTimeMonitoringService.HeartbeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.medical.realTimeMonitoringService.HeartbeatReply.getDefaultInstance()))
                  .setSchemaDescriptor(new RealTimeMonitoringServiceMethodDescriptorSupplier("realTimeHeartbeatDetection"))
                  .build();
          }
        }
     }
     return getRealTimeHeartbeatDetectionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RealTimeMonitoringServiceStub newStub(io.grpc.Channel channel) {
    return new RealTimeMonitoringServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RealTimeMonitoringServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RealTimeMonitoringServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RealTimeMonitoringServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RealTimeMonitoringServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RealTimeMonitoringServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public void realTimeHeartbeatDetection(smart.medical.realTimeMonitoringService.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<smart.medical.realTimeMonitoringService.HeartbeatReply> responseObserver) {
      asyncUnimplementedUnaryCall(getRealTimeHeartbeatDetectionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRealTimeHeartbeatDetectionMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                smart.medical.realTimeMonitoringService.HeartbeatRequest,
                smart.medical.realTimeMonitoringService.HeartbeatReply>(
                  this, METHODID_REAL_TIME_HEARTBEAT_DETECTION)))
          .build();
    }
  }

  /**
   */
  public static final class RealTimeMonitoringServiceStub extends io.grpc.stub.AbstractStub<RealTimeMonitoringServiceStub> {
    private RealTimeMonitoringServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RealTimeMonitoringServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RealTimeMonitoringServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RealTimeMonitoringServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public void realTimeHeartbeatDetection(smart.medical.realTimeMonitoringService.HeartbeatRequest request,
        io.grpc.stub.StreamObserver<smart.medical.realTimeMonitoringService.HeartbeatReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getRealTimeHeartbeatDetectionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RealTimeMonitoringServiceBlockingStub extends io.grpc.stub.AbstractStub<RealTimeMonitoringServiceBlockingStub> {
    private RealTimeMonitoringServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RealTimeMonitoringServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RealTimeMonitoringServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RealTimeMonitoringServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Server Streaming
     * </pre>
     */
    public java.util.Iterator<smart.medical.realTimeMonitoringService.HeartbeatReply> realTimeHeartbeatDetection(
        smart.medical.realTimeMonitoringService.HeartbeatRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getRealTimeHeartbeatDetectionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RealTimeMonitoringServiceFutureStub extends io.grpc.stub.AbstractStub<RealTimeMonitoringServiceFutureStub> {
    private RealTimeMonitoringServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RealTimeMonitoringServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RealTimeMonitoringServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RealTimeMonitoringServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_REAL_TIME_HEARTBEAT_DETECTION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RealTimeMonitoringServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RealTimeMonitoringServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REAL_TIME_HEARTBEAT_DETECTION:
          serviceImpl.realTimeHeartbeatDetection((smart.medical.realTimeMonitoringService.HeartbeatRequest) request,
              (io.grpc.stub.StreamObserver<smart.medical.realTimeMonitoringService.HeartbeatReply>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RealTimeMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RealTimeMonitoringServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smart.medical.realTimeMonitoringService.realTimeMonitoringServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RealTimeMonitoringService");
    }
  }

  private static final class RealTimeMonitoringServiceFileDescriptorSupplier
      extends RealTimeMonitoringServiceBaseDescriptorSupplier {
    RealTimeMonitoringServiceFileDescriptorSupplier() {}
  }

  private static final class RealTimeMonitoringServiceMethodDescriptorSupplier
      extends RealTimeMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RealTimeMonitoringServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RealTimeMonitoringServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RealTimeMonitoringServiceFileDescriptorSupplier())
              .addMethod(getRealTimeHeartbeatDetectionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
