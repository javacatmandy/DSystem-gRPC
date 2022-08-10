package smart.medical.intelligentArchivingService;

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
    comments = "Source: IntelligentArchivingService.proto")
public final class IntelligentArchivingServiceGrpc {

  private IntelligentArchivingServiceGrpc() {}

  public static final String SERVICE_NAME = "smart.IntelligentArchivingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<smart.medical.intelligentArchivingService.HealthInfoRequest,
      smart.medical.intelligentArchivingService.ProfileNoReply> getHealthProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "healthProfile",
      requestType = smart.medical.intelligentArchivingService.HealthInfoRequest.class,
      responseType = smart.medical.intelligentArchivingService.ProfileNoReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<smart.medical.intelligentArchivingService.HealthInfoRequest,
      smart.medical.intelligentArchivingService.ProfileNoReply> getHealthProfileMethod() {
    io.grpc.MethodDescriptor<smart.medical.intelligentArchivingService.HealthInfoRequest, smart.medical.intelligentArchivingService.ProfileNoReply> getHealthProfileMethod;
    if ((getHealthProfileMethod = IntelligentArchivingServiceGrpc.getHealthProfileMethod) == null) {
      synchronized (IntelligentArchivingServiceGrpc.class) {
        if ((getHealthProfileMethod = IntelligentArchivingServiceGrpc.getHealthProfileMethod) == null) {
          IntelligentArchivingServiceGrpc.getHealthProfileMethod = getHealthProfileMethod = 
              io.grpc.MethodDescriptor.<smart.medical.intelligentArchivingService.HealthInfoRequest, smart.medical.intelligentArchivingService.ProfileNoReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smart.IntelligentArchivingService", "healthProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.medical.intelligentArchivingService.HealthInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.medical.intelligentArchivingService.ProfileNoReply.getDefaultInstance()))
                  .setSchemaDescriptor(new IntelligentArchivingServiceMethodDescriptorSupplier("healthProfile"))
                  .build();
          }
        }
     }
     return getHealthProfileMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IntelligentArchivingServiceStub newStub(io.grpc.Channel channel) {
    return new IntelligentArchivingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IntelligentArchivingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new IntelligentArchivingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IntelligentArchivingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new IntelligentArchivingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class IntelligentArchivingServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<smart.medical.intelligentArchivingService.HealthInfoRequest> healthProfile(
        io.grpc.stub.StreamObserver<smart.medical.intelligentArchivingService.ProfileNoReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getHealthProfileMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHealthProfileMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                smart.medical.intelligentArchivingService.HealthInfoRequest,
                smart.medical.intelligentArchivingService.ProfileNoReply>(
                  this, METHODID_HEALTH_PROFILE)))
          .build();
    }
  }

  /**
   */
  public static final class IntelligentArchivingServiceStub extends io.grpc.stub.AbstractStub<IntelligentArchivingServiceStub> {
    private IntelligentArchivingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IntelligentArchivingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntelligentArchivingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IntelligentArchivingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Client Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<smart.medical.intelligentArchivingService.HealthInfoRequest> healthProfile(
        io.grpc.stub.StreamObserver<smart.medical.intelligentArchivingService.ProfileNoReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getHealthProfileMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class IntelligentArchivingServiceBlockingStub extends io.grpc.stub.AbstractStub<IntelligentArchivingServiceBlockingStub> {
    private IntelligentArchivingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IntelligentArchivingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntelligentArchivingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IntelligentArchivingServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class IntelligentArchivingServiceFutureStub extends io.grpc.stub.AbstractStub<IntelligentArchivingServiceFutureStub> {
    private IntelligentArchivingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IntelligentArchivingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntelligentArchivingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IntelligentArchivingServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_HEALTH_PROFILE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IntelligentArchivingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IntelligentArchivingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HEALTH_PROFILE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.healthProfile(
              (io.grpc.stub.StreamObserver<smart.medical.intelligentArchivingService.ProfileNoReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class IntelligentArchivingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IntelligentArchivingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smart.medical.intelligentArchivingService.intelligentArchivingServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IntelligentArchivingService");
    }
  }

  private static final class IntelligentArchivingServiceFileDescriptorSupplier
      extends IntelligentArchivingServiceBaseDescriptorSupplier {
    IntelligentArchivingServiceFileDescriptorSupplier() {}
  }

  private static final class IntelligentArchivingServiceMethodDescriptorSupplier
      extends IntelligentArchivingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IntelligentArchivingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (IntelligentArchivingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IntelligentArchivingServiceFileDescriptorSupplier())
              .addMethod(getHealthProfileMethod())
              .build();
        }
      }
    }
    return result;
  }
}
