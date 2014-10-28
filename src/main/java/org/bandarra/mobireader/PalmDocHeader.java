package org.bandarra.mobireader;

/**
 *
 * @author andreban
 */
public class PalmDocHeader {
    public enum CompressionType {
        NO_COMPRESSION(1),
        PALMDOC_COMPRESSION(2),
        HUFF_CDIC_COMPRESSION(17480),
        UNKNOWN(-1);
        private int id;
        private CompressionType(int id) {
            this.id = id;
        }
        
        public int getId() {
            return id;
        }
        
        public static CompressionType getById(int id) {
            for (CompressionType type: CompressionType.values()) {
                if (type.getId() == id) return type;
            }
            return CompressionType.UNKNOWN;
        }
    }
    
    public enum EncryptionType {
        NO_ENCRYPTION(0),
        OLD_MOBIPOCKET_ENCRYPTION(1),
        MOBIPOCKET_ENCRYPTION(2),
        UNKNOWN(-1);
        
        private int id;
        private EncryptionType(int id) {
            this.id = id;
        }
        
        public int getId() {
            return this.id;
        }
        public static EncryptionType getById(int id) {
            for (EncryptionType type: EncryptionType.values()) {
                if (type.getId() == id) {
                    return type;
                }
            }
            return EncryptionType.UNKNOWN;
        }
    }
    
    private long textLength = 0;
    private int recordCount = 0;
    private int recordSize = 0;
    private long currentPosition = 0;
    private int compression = -1;    
    private int encryption = -1;
    private CompressionType compressionType = CompressionType.UNKNOWN;
    private EncryptionType encriptionType = EncryptionType.UNKNOWN;

    public long getTextLength() {
        return textLength;
    }

    public void setTextLength(long textLength) {
        this.textLength = textLength;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getRecordSize() {
        return recordSize;
    }

    public void setRecordSize(int recordSize) {
        this.recordSize = recordSize;
    }

    public long getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(long currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getCompression() {
        return compression;
    }

    public void setCompression(int compression) {
        this.compression = compression;
        this.compressionType = CompressionType.getById(compression);
    }

    public int getEncryption() {
        return encryption;
    }

    public void setEncryption(int encryption) {
        this.encryption = encryption;
        this.encriptionType = EncryptionType.getById(encryption);
    }

    public CompressionType getCompressionType() {
        return compressionType;
    }

    public void setCompressionType(CompressionType compressionType) {
        this.compressionType = compressionType;
        this.compression = compressionType.getId();
    }

    public EncryptionType getEncriptionType() {
        return encriptionType;
    }

    public void setEncriptionType(EncryptionType encriptionType) {
        this.encriptionType = encriptionType;
        this.encryption = encriptionType.getId();
    }

    @Override
    public String toString() {
        return "PalmDocHeader{" + "textLength=" + textLength + ", recordCount=" + recordCount + ", recordSize=" + recordSize + ", currentPosition=" + currentPosition + ", compression=" + compression + ", encryption=" + encryption + ", compressionType=" + compressionType + ", encriptionType=" + encriptionType + '}';
    }                   
    
}
