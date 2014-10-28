package org.bandarra.mobireader;

import java.nio.ByteBuffer;

/**
 *
 * @author andreban
 */
public class ExthHeaderRecord {
    private long recordType;
    private long recordLength;
    private byte[] rawRecordData;
    
    public String getString() {
        return new String(rawRecordData);
    }
    
    public int getInt() {
        ByteBuffer buff = ByteBuffer.wrap(rawRecordData);
        return buff.getInt();        
    }
    
    public long getUnsignedInt() {        
        return getInt() &  0xFFFFFFFFL;
    }
    
    public int getUnsignedShort() {
        return getShort() & 0xffff;        
    }
    
    public short getShort() {
        if (rawRecordData.length != 4) {
            throw new IllegalArgumentException("Cannot convert to unsigned short. rawRecordData length != 2" );
        }
        ByteBuffer buff = ByteBuffer.wrap(rawRecordData);      
        return buff.getShort();
    }

    public long getRecordType() {
        return recordType;
    }

    public void setRecordType(long recordType) {
        this.recordType = recordType;
    }

    public long getRecordLength() {
        return recordLength;
    }

    public void setRecordLength(long recordLength) {
        this.recordLength = recordLength;
    }

    public byte[] getRawRecordData() {
        return rawRecordData;
    }

    public void setRawRecordData(byte[] rawRecordData) {
        this.rawRecordData = rawRecordData;
    }

    @Override
    public String toString() {
        return "ExthHeaderRecord{" + "recordType=" + recordType + ", recordLength=" + recordLength + ", rawRecordData=" + rawRecordData + '}';
    }                
}
