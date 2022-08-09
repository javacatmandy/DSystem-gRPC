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
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smart_OneClickCancellationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smart_OneClickCancellationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smart_CancellationStatusReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smart_CancellationStatusReply_fieldAccessorTable;

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
      "\n\024AppointmentInfoReply\022\017\n\007message\030\001 \001(\t\"" +
      "3\n\033OneClickCancellationRequest\022\024\n\014cancel" +
      "lation\030\001 \001(\t\"*\n\027CancellationStatusReply\022" +
      "\017\n\007message\030\001 \001(\t2\316\001\n\027SmartAppointmentSer" +
      "vice\022U\n\021mobileAppointment\022\035.smart.Appoin" +
      "tmentInfoRequest\032\033.smart.AppointmentInfo" +
      "Reply\"\000(\0010\001\022\\\n\024oneClickCancellation\022\".sm" +
      "art.OneClickCancellationRequest\032\036.smart." +
      "CancellationStatusReply\"\000B<\n smart.medic" +
      "al.appointmentServiceB\026appointmentServic" +
      "eImplP\001b\006proto3"
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
    internal_static_smart_OneClickCancellationRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_smart_OneClickCancellationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smart_OneClickCancellationRequest_descriptor,
        new java.lang.String[] { "Cancellation", });
    internal_static_smart_CancellationStatusReply_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_smart_CancellationStatusReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smart_CancellationStatusReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
