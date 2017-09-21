/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package GrafoThrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-09-20")
public class Identificador implements org.apache.thrift.TBase<Identificador, Identificador._Fields>, java.io.Serializable, Cloneable, Comparable<Identificador> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Identificador");

  private static final org.apache.thrift.protocol.TField V1_FIELD_DESC = new org.apache.thrift.protocol.TField("v1", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField V2_FIELD_DESC = new org.apache.thrift.protocol.TField("v2", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new IdentificadorStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new IdentificadorTupleSchemeFactory();

  public int v1; // required
  public int v2; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    V1((short)1, "v1"),
    V2((short)2, "v2");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // V1
          return V1;
        case 2: // V2
          return V2;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __V1_ISSET_ID = 0;
  private static final int __V2_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.V1, new org.apache.thrift.meta_data.FieldMetaData("v1", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    tmpMap.put(_Fields.V2, new org.apache.thrift.meta_data.FieldMetaData("v2", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "int")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Identificador.class, metaDataMap);
  }

  public Identificador() {
  }

  public Identificador(
    int v1,
    int v2)
  {
    this();
    this.v1 = v1;
    setV1IsSet(true);
    this.v2 = v2;
    setV2IsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Identificador(Identificador other) {
    __isset_bitfield = other.__isset_bitfield;
    this.v1 = other.v1;
    this.v2 = other.v2;
  }

  public Identificador deepCopy() {
    return new Identificador(this);
  }

  @Override
  public void clear() {
    setV1IsSet(false);
    this.v1 = 0;
    setV2IsSet(false);
    this.v2 = 0;
  }

  public int getV1() {
    return this.v1;
  }

  public Identificador setV1(int v1) {
    this.v1 = v1;
    setV1IsSet(true);
    return this;
  }

  public void unsetV1() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __V1_ISSET_ID);
  }

  /** Returns true if field v1 is set (has been assigned a value) and false otherwise */
  public boolean isSetV1() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __V1_ISSET_ID);
  }

  public void setV1IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __V1_ISSET_ID, value);
  }

  public int getV2() {
    return this.v2;
  }

  public Identificador setV2(int v2) {
    this.v2 = v2;
    setV2IsSet(true);
    return this;
  }

  public void unsetV2() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __V2_ISSET_ID);
  }

  /** Returns true if field v2 is set (has been assigned a value) and false otherwise */
  public boolean isSetV2() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __V2_ISSET_ID);
  }

  public void setV2IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __V2_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case V1:
      if (value == null) {
        unsetV1();
      } else {
        setV1((java.lang.Integer)value);
      }
      break;

    case V2:
      if (value == null) {
        unsetV2();
      } else {
        setV2((java.lang.Integer)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case V1:
      return getV1();

    case V2:
      return getV2();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case V1:
      return isSetV1();
    case V2:
      return isSetV2();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Identificador)
      return this.equals((Identificador)that);
    return false;
  }

  public boolean equals(Identificador that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_v1 = true;
    boolean that_present_v1 = true;
    if (this_present_v1 || that_present_v1) {
      if (!(this_present_v1 && that_present_v1))
        return false;
      if (this.v1 != that.v1)
        return false;
    }

    boolean this_present_v2 = true;
    boolean that_present_v2 = true;
    if (this_present_v2 || that_present_v2) {
      if (!(this_present_v2 && that_present_v2))
        return false;
      if (this.v2 != that.v2)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + v1;

    hashCode = hashCode * 8191 + v2;

    return hashCode;
  }

  @Override
  public int compareTo(Identificador other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetV1()).compareTo(other.isSetV1());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetV1()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.v1, other.v1);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetV2()).compareTo(other.isSetV2());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetV2()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.v2, other.v2);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Identificador(");
    boolean first = true;

    sb.append("v1:");
    sb.append(this.v1);
    first = false;
    if (!first) sb.append(", ");
    sb.append("v2:");
    sb.append(this.v2);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class IdentificadorStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public IdentificadorStandardScheme getScheme() {
      return new IdentificadorStandardScheme();
    }
  }

  private static class IdentificadorStandardScheme extends org.apache.thrift.scheme.StandardScheme<Identificador> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Identificador struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // V1
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.v1 = iprot.readI32();
              struct.setV1IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // V2
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.v2 = iprot.readI32();
              struct.setV2IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Identificador struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(V1_FIELD_DESC);
      oprot.writeI32(struct.v1);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(V2_FIELD_DESC);
      oprot.writeI32(struct.v2);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class IdentificadorTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public IdentificadorTupleScheme getScheme() {
      return new IdentificadorTupleScheme();
    }
  }

  private static class IdentificadorTupleScheme extends org.apache.thrift.scheme.TupleScheme<Identificador> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Identificador struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetV1()) {
        optionals.set(0);
      }
      if (struct.isSetV2()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetV1()) {
        oprot.writeI32(struct.v1);
      }
      if (struct.isSetV2()) {
        oprot.writeI32(struct.v2);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Identificador struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.v1 = iprot.readI32();
        struct.setV1IsSet(true);
      }
      if (incoming.get(1)) {
        struct.v2 = iprot.readI32();
        struct.setV2IsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
