// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IntelligentArchivingService.proto

package smart.medical.intelligentArchivingService;

public final class intelligentArchivingServiceImpl {
  private intelligentArchivingServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smart_HealthInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smart_HealthInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smart_ProfileNoReply_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smart_ProfileNoReply_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n!IntelligentArchivingService.proto\022\005sma" +
      "rt\"C\n\021HealthInfoRequest\022\014\n\004name\030\001 \001(\t\022\016\n" +
      "\006gender\030\002 \001(\t\022\020\n\010diagnose\030\003 \001(\t\"!\n\016Profi" +
      "leNoReply\022\017\n\007message\030\001 \001(\t2c\n\033Intelligen" +
      "tArchivingService\022D\n\rhealthProfile\022\030.sma" +
      "rt.HealthInfoRequest\032\025.smart.ProfileNoRe" +
      "ply\"\000(\001BN\n)smart.medical.intelligentArch" +
      "ivingServiceB\037intelligentArchivingServic" +
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
    internal_static_smart_HealthInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_smart_HealthInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smart_HealthInfoRequest_descriptor,
        new java.lang.String[] { "Name", "Gender", "Diagnose", });
    internal_static_smart_ProfileNoReply_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_smart_ProfileNoReply_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smart_ProfileNoReply_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
