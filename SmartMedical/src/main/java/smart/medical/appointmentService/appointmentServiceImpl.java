// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SmartAppointmentService.proto

package smart.medical.appointmentService;

public final class appointmentServiceImpl {
  private appointmentServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smart_AppointmentInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smart_AppointmentInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smart_AppointmentInfoReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smart_AppointmentInfoReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035SmartAppointmentService.proto\022\005smart\"&" +
      "\n\026AppointmentInfoRequest\022\014\n\004Info\030\001 \001(\t\"\'" +
      "\n\024AppointmentInfoReply\022\017\n\007message\030\001 \001(\t2" +
      "p\n\027SmartAppointmentService\022U\n\021mobileAppo" +
      "intment\022\035.smart.AppointmentInfoRequest\032\033" +
      ".smart.AppointmentInfoReply\"\000(\0010\001B<\n sma" +
      "rt.medical.appointmentServiceB\026appointme" +
      "ntServiceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_smart_AppointmentInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_smart_AppointmentInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smart_AppointmentInfoRequest_descriptor,
        new java.lang.String[] { "Info", });
    internal_static_smart_AppointmentInfoReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_smart_AppointmentInfoReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smart_AppointmentInfoReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
