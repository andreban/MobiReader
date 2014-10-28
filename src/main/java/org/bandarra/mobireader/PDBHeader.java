package org.bandarra.mobireader;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andreban
 */
public class PDBHeader {
    private String databaseName;
    private int attributes;
    private int version;
    private long creationDate;
    private long modificationDate;
    private long lastBackupDate;
    private long modificationNumber;
    private long appInfoId;
    private long sortInfoId;
    private String type;
    private String creator;
    private long uniqueSeedID;
    private long nextRecordListID;
    private int numberOfRecords;
    private List<PDBRecordHeader> records = new ArrayList<>(numberOfRecords);

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public int getAttributes() {
        return attributes;
    }

    public void setAttributes(int attributes) {
        this.attributes = attributes;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public long getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(long modificationDate) {
        this.modificationDate = modificationDate;
    }

    public long getLastBackupDate() {
        return lastBackupDate;
    }

    public void setLastBackupDate(long lastBackupDate) {
        this.lastBackupDate = lastBackupDate;
    }

    public long getModificationNumber() {
        return modificationNumber;
    }

    public void setModificationNumber(long modificationNumber) {
        this.modificationNumber = modificationNumber;
    }

    public long getAppInfoId() {
        return appInfoId;
    }

    public void setAppInfoId(long appInfoId) {
        this.appInfoId = appInfoId;
    }

    public long getSortInfoId() {
        return sortInfoId;
    }

    public void setSortInfoId(long sortInfoId) {
        this.sortInfoId = sortInfoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public long getUniqueSeedID() {
        return uniqueSeedID;
    }

    public void setUniqueSeedID(long uniqueSeedID) {
        this.uniqueSeedID = uniqueSeedID;
    }

    public int getNumberOfRecords() {
        return numberOfRecords;
    }

    public void setNumberOfRecords(int numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }

    public long getNextRecordListID() {
        return nextRecordListID;
    }

    public void setNextRecordListID(long nextRecordListID) {
        this.nextRecordListID = nextRecordListID;
    }
        
    public void addPDBRecordHeader(PDBRecordHeader pdbRecordHeader) {
        records.add(pdbRecordHeader);
    }
    
    public PDBRecordHeader getPDBRecordHeader(int pos) {
        return records.get(pos);
    }

    @Override
    public String toString() {
        return "PDBHeader{" + "databaseName=" + databaseName + ", attributes=" + attributes + ", version=" + version + ", creationDate=" + creationDate + ", modificationDate=" + modificationDate + ", lastBackupDate=" + lastBackupDate + ", modificationNumber=" + modificationNumber + ", appInfoId=" + appInfoId + ", sortInfoId=" + sortInfoId + ", type=" + type + ", creator=" + creator + ", uniqueSeedID=" + uniqueSeedID + ", nextRecordListID=" + nextRecordListID + ", numberOfRecords=" + numberOfRecords + ", records=" + records + '}';
    }
    
    
}
