package smart.medical.appointmentService;

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
    comments = "Source: SmartAppointmentService.proto")
public final class SmartAppointmentServiceGrpc {

  private SmartAppointmentServiceGrpc() {}

  public static final String SERVICE_NAME = "smart.SmartAppointmentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<smart.medical.appointmentService.AppointmentInfoRequest,
      smart.medical.appointmentService.AppointmentInfoReply> getMobileAppointmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "mobileAppointment",
      requestType = smart.medical.appointmentService.AppointmentInfoRequest.class,
      responseType = smart.medical.appointmentService.AppointmentInfoReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<smart.medical.appointmentService.AppointmentInfoRequest,
      smart.medical.appointmentService.AppointmentInfoReply> getMobileAppointmentMethod() {
    io.grpc.MethodDescriptor<smart.medical.appointmentService.AppointmentInfoRequest, smart.medical.appointmentService.AppointmentInfoReply> getMobileAppointmentMethod;
    if ((getMobileAppointmentMethod = SmartAppointmentServiceGrpc.getMobileAppointmentMethod) == null) {
      synchronized (SmartAppointmentServiceGrpc.class) {
        if ((getMobileAppointmentMethod = SmartAppointmentServiceGrpc.getMobileAppointmentMethod) == null) {
          SmartAppointmentServiceGrpc.getMobileAppointmentMethod = getMobileAppointmentMethod = 
              io.grpc.MethodDescriptor.<smart.medical.appointmentService.AppointmentInfoRequest, smart.medical.appointmentService.AppointmentInfoReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smart.SmartAppointmentService", "mobileAppointment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.medical.appointmentService.AppointmentInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smart.medical.appointmentService.AppointmentInfoReply.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartAppointmentServiceMethodDescriptorSupplier("mobileAppointment"))
                  .build();
          }
        }
     }
     return getMobileAppointmentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartAppointmentServiceStub newStub(io.grpc.Channel channel) {
    return new SmartAppointmentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartAppointmentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartAppointmentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartAppointmentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartAppointmentServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SmartAppointmentServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Bi-Directional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<smart.medical.appointmentService.AppointmentInfoRequest> mobileAppointment(
        io.grpc.stub.StreamObserver<smart.medical.appointmentService.AppointmentInfoReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getMobileAppointmentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMobileAppointmentMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                smart.medical.appointmentService.AppointmentInfoRequest,
                smart.medical.appointmentService.AppointmentInfoReply>(
                  this, METHODID_MOBILE_APPOINTMENT)))
          .build();
    }
  }

  /**
   */
  public static final class SmartAppointmentServiceStub extends io.grpc.stub.AbstractStub<SmartAppointmentServiceStub> {
    private SmartAppointmentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartAppointmentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartAppointmentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartAppointmentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Bi-Directional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<smart.medical.appointmentService.AppointmentInfoRequest> mobileAppointment(
        io.grpc.stub.StreamObserver<smart.medical.appointmentService.AppointmentInfoReply> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getMobileAppointmentMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class SmartAppointmentServiceBlockingStub extends io.grpc.stub.AbstractStub<SmartAppointmentServiceBlockingStub> {
    private SmartAppointmentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartAppointmentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartAppointmentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartAppointmentServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class SmartAppointmentServiceFutureStub extends io.grpc.stub.AbstractStub<SmartAppointmentServiceFutureStub> {
    private SmartAppointmentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartAppointmentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartAppointmentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartAppointmentServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MOBILE_APPOINTMENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartAppointmentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartAppointmentServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_MOBILE_APPOINTMENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.mobileAppointment(
              (io.grpc.stub.StreamObserver<smart.medical.appointmentService.AppointmentInfoReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SmartAppointmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartAppointmentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smart.medical.appointmentService.appointmentServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartAppointmentService");
    }
  }

  private static final class SmartAppointmentServiceFileDescriptorSupplier
      extends SmartAppointmentServiceBaseDescriptorSupplier {
    SmartAppointmentServiceFileDescriptorSupplier() {}
  }

  private static final class SmartAppointmentServiceMethodDescriptorSupplier
      extends SmartAppointmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartAppointmentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartAppointmentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartAppointmentServiceFileDescriptorSupplier())
              .addMethod(getMobileAppointmentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
