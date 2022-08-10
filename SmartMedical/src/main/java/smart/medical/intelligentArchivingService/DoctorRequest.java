// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IntelligentArchivingService.proto

package smart.medical.intelligentArchivingService;

/**
 * Protobuf type {@code smart.DoctorRequest}
 */
public  final class DoctorRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:smart.DoctorRequest)
    DoctorRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DoctorRequest.newBuilder() to construct.
  private DoctorRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DoctorRequest() {
    requestPatientsDoctor_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DoctorRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            requestPatientsDoctor_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return smart.medical.intelligentArchivingService.intelligentArchivingServiceImpl.internal_static_smart_DoctorRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return smart.medical.intelligentArchivingService.intelligentArchivingServiceImpl.internal_static_smart_DoctorRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            smart.medical.intelligentArchivingService.DoctorRequest.class, smart.medical.intelligentArchivingService.DoctorRequest.Builder.class);
  }

  public static final int REQUESTPATIENTSDOCTOR_FIELD_NUMBER = 1;
  private volatile java.lang.Object requestPatientsDoctor_;
  /**
   * <code>string requestPatientsDoctor = 1;</code>
   */
  public java.lang.String getRequestPatientsDoctor() {
    java.lang.Object ref = requestPatientsDoctor_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      requestPatientsDoctor_ = s;
      return s;
    }
  }
  /**
   * <code>string requestPatientsDoctor = 1;</code>
   */
  public com.google.protobuf.ByteString
      getRequestPatientsDoctorBytes() {
    java.lang.Object ref = requestPatientsDoctor_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      requestPatientsDoctor_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getRequestPatientsDoctorBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, requestPatientsDoctor_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getRequestPatientsDoctorBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, requestPatientsDoctor_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof smart.medical.intelligentArchivingService.DoctorRequest)) {
      return super.equals(obj);
    }
    smart.medical.intelligentArchivingService.DoctorRequest other = (smart.medical.intelligentArchivingService.DoctorRequest) obj;

    boolean result = true;
    result = result && getRequestPatientsDoctor()
        .equals(other.getRequestPatientsDoctor());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + REQUESTPATIENTSDOCTOR_FIELD_NUMBER;
    hash = (53 * hash) + getRequestPatientsDoctor().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static smart.medical.intelligentArchivingService.DoctorRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static smart.medical.intelligentArchivingService.DoctorRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static smart.medical.intelligentArchivingService.DoctorRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static smart.medical.intelligentArchivingService.DoctorRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static smart.medical.intelligentArchivingService.DoctorRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static smart.medical.intelligentArchivingService.DoctorRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static smart.medical.intelligentArchivingService.DoctorRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static smart.medical.intelligentArchivingService.DoctorRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static smart.medical.intelligentArchivingService.DoctorRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static smart.medical.intelligentArchivingService.DoctorRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static smart.medical.intelligentArchivingService.DoctorRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static smart.medical.intelligentArchivingService.DoctorRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(smart.medical.intelligentArchivingService.DoctorRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code smart.DoctorRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:smart.DoctorRequest)
      smart.medical.intelligentArchivingService.DoctorRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return smart.medical.intelligentArchivingService.intelligentArchivingServiceImpl.internal_static_smart_DoctorRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return smart.medical.intelligentArchivingService.intelligentArchivingServiceImpl.internal_static_smart_DoctorRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              smart.medical.intelligentArchivingService.DoctorRequest.class, smart.medical.intelligentArchivingService.DoctorRequest.Builder.class);
    }

    // Construct using smart.medical.intelligentArchivingService.DoctorRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      requestPatientsDoctor_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return smart.medical.intelligentArchivingService.intelligentArchivingServiceImpl.internal_static_smart_DoctorRequest_descriptor;
    }

    @java.lang.Override
    public smart.medical.intelligentArchivingService.DoctorRequest getDefaultInstanceForType() {
      return smart.medical.intelligentArchivingService.DoctorRequest.getDefaultInstance();
    }

    @java.lang.Override
    public smart.medical.intelligentArchivingService.DoctorRequest build() {
      smart.medical.intelligentArchivingService.DoctorRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public smart.medical.intelligentArchivingService.DoctorRequest buildPartial() {
      smart.medical.intelligentArchivingService.DoctorRequest result = new smart.medical.intelligentArchivingService.DoctorRequest(this);
      result.requestPatientsDoctor_ = requestPatientsDoctor_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof smart.medical.intelligentArchivingService.DoctorRequest) {
        return mergeFrom((smart.medical.intelligentArchivingService.DoctorRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(smart.medical.intelligentArchivingService.DoctorRequest other) {
      if (other == smart.medical.intelligentArchivingService.DoctorRequest.getDefaultInstance()) return this;
      if (!other.getRequestPatientsDoctor().isEmpty()) {
        requestPatientsDoctor_ = other.requestPatientsDoctor_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      smart.medical.intelligentArchivingService.DoctorRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (smart.medical.intelligentArchivingService.DoctorRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object requestPatientsDoctor_ = "";
    /**
     * <code>string requestPatientsDoctor = 1;</code>
     */
    public java.lang.String getRequestPatientsDoctor() {
      java.lang.Object ref = requestPatientsDoctor_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        requestPatientsDoctor_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string requestPatientsDoctor = 1;</code>
     */
    public com.google.protobuf.ByteString
        getRequestPatientsDoctorBytes() {
      java.lang.Object ref = requestPatientsDoctor_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        requestPatientsDoctor_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string requestPatientsDoctor = 1;</code>
     */
    public Builder setRequestPatientsDoctor(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      requestPatientsDoctor_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string requestPatientsDoctor = 1;</code>
     */
    public Builder clearRequestPatientsDoctor() {
      
      requestPatientsDoctor_ = getDefaultInstance().getRequestPatientsDoctor();
      onChanged();
      return this;
    }
    /**
     * <code>string requestPatientsDoctor = 1;</code>
     */
    public Builder setRequestPatientsDoctorBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      requestPatientsDoctor_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:smart.DoctorRequest)
  }

  // @@protoc_insertion_point(class_scope:smart.DoctorRequest)
  private static final smart.medical.intelligentArchivingService.DoctorRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new smart.medical.intelligentArchivingService.DoctorRequest();
  }

  public static smart.medical.intelligentArchivingService.DoctorRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DoctorRequest>
      PARSER = new com.google.protobuf.AbstractParser<DoctorRequest>() {
    @java.lang.Override
    public DoctorRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DoctorRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DoctorRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DoctorRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public smart.medical.intelligentArchivingService.DoctorRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

