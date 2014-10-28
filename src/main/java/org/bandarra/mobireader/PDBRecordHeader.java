package org.bandarra.mobireader;

/**
 *
 * @author andreban
 */
public class PDBRecordHeader {
    private long dataOffset;
    private byte recordAttributes;

    public long getDataOffset() {
        return dataOffset;
    }

    public void setDataOffset(long dataOffset) {
        this.dataOffset = dataOffset;
    }

    public byte getRecordAttributes() {
        return recordAttributes;
    }

    public void setRecordAttributes(byte recordAttributes) {
        this.recordAttributes = recordAttributes;
    }

    @Override
    public String toString() {
        return "PDBRecordHeader{" + "dataOffset=" + dataOffset + ", recordAttributes=" + recordAttributes + '}';
    }
    
    
}
