// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RealTimeMonitoringService.proto

package smart.medical.realTimeMonitoringService;

/**
 * Protobuf type {@code smart.LowBloodOxygenAlertRequest}
 */
public  final class LowBloodOxygenAlertRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:smart.LowBloodOxygenAlertRequest)
    LowBloodOxygenAlertRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LowBloodOxygenAlertRequest.newBuilder() to construct.
  private LowBloodOxygenAlertRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LowBloodOxygenAlertRequest() {
    num_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private LowBloodOxygenAlertRequest(
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
          case 13: {

            num_ = input.readFloat();
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
    return smart.medical.realTimeMonitoringService.realTimeMonitoringServiceImpl.internal_static_smart_LowBloodOxygenAlertRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return smart.medical.realTimeMonitoringService.realTimeMonitoringServiceImpl.internal_static_smart_LowBloodOxygenAlertRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest.class, smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest.Builder.class);
  }

  public static final int NUM_FIELD_NUMBER = 1;
  private float num_;
  /**
   * <code>float num = 1;</code>
   */
  public float getNum() {
    return num_;
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
    if (num_ != 0F) {
      output.writeFloat(1, num_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (num_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(1, num_);
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
    if (!(obj instanceof smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest)) {
      return super.equals(obj);
    }
    smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest other = (smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest) obj;

    boolean result = true;
    result = result && (
        java.lang.Float.floatToIntBits(getNum())
        == java.lang.Float.floatToIntBits(
            other.getNum()));
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
    hash = (37 * hash) + NUM_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getNum());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parseFrom(
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
  public static Builder newBuilder(smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest prototype) {
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
   * Protobuf type {@code smart.LowBloodOxygenAlertRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:smart.LowBloodOxygenAlertRequest)
      smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return smart.medical.realTimeMonitoringService.realTimeMonitoringServiceImpl.internal_static_smart_LowBloodOxygenAlertRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return smart.medical.realTimeMonitoringService.realTimeMonitoringServiceImpl.internal_static_smart_LowBloodOxygenAlertRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest.class, smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest.Builder.class);
    }

    // Construct using smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest.newBuilder()
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
      num_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return smart.medical.realTimeMonitoringService.realTimeMonitoringServiceImpl.internal_static_smart_LowBloodOxygenAlertRequest_descriptor;
    }

    @java.lang.Override
    public smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest getDefaultInstanceForType() {
      return smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest.getDefaultInstance();
    }

    @java.lang.Override
    public smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest build() {
      smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest buildPartial() {
      smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest result = new smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest(this);
      result.num_ = num_;
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
      if (other instanceof smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest) {
        return mergeFrom((smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest other) {
      if (other == smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest.getDefaultInstance()) return this;
      if (other.getNum() != 0F) {
        setNum(other.getNum());
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
      smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private float num_ ;
    /**
     * <code>float num = 1;</code>
     */
    public float getNum() {
      return num_;
    }
    /**
     * <code>float num = 1;</code>
     */
    public Builder setNum(float value) {
      
      num_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float num = 1;</code>
     */
    public Builder clearNum() {
      
      num_ = 0F;
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


    // @@protoc_insertion_point(builder_scope:smart.LowBloodOxygenAlertRequest)
  }

  // @@protoc_insertion_point(class_scope:smart.LowBloodOxygenAlertRequest)
  private static final smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest();
  }

  public static smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LowBloodOxygenAlertRequest>
      PARSER = new com.google.protobuf.AbstractParser<LowBloodOxygenAlertRequest>() {
    @java.lang.Override
    public LowBloodOxygenAlertRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new LowBloodOxygenAlertRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<LowBloodOxygenAlertRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LowBloodOxygenAlertRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public smart.medical.realTimeMonitoringService.LowBloodOxygenAlertRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
