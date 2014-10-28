package org.bandarra.mobireader;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author andreban
 */
public class ExthHeader {
    public enum RecordType {
        DRM_SERVER_ID(1, "drm_server_id"),
        DRM_COMMERCE_ID(2, "drm_commerce_id"),
        DRM_EBOOKBASE_BOOK_ID(3, "drm_ebookbase_book_id"),
        AUTHOR(100, "Author"),
        PUBLISHER(101, "Publisher"),
        IMPRINT(102, "Imprint"),
        DESCRIPTION(103, "Description"),
        ISBN(104, "ISBN"),
        SUBJECT(105, "Subject"),
        PUBLISHING_DATE(106, "Publishing Date"),
        REVIEW(107, "Review"),
        CONTRIBUTOR(108, "Contributor"),
        RIGHTS(109, "Rights"),
        SUBJECT_CODE(110, "Subject Code"),
        TYPE(111, "Type"),
        SOURCE(112, "Source"),
        ASIN(113, "asin"),
        VERSION_NUMBER(114, "Version Number"),
        SAMPLE(115, "0x0001 if the book content is only a sample of the full book"),
        START_READING(116, "Position (4-byte offset) in file at which to open when first opened"),
        ADULT(117, "Mobipocket Creator adds this if Adult only is checked on its GUI; contents: \"yes\""),
        RETAIL_PRICE(118, "As text, e.g. \"4.99\""),
        RETAIL_PRICE_CURRENCY(119, "As text, e.g. \"USD\""),
        DICTIONARY_SHORT_NAME(200, "As text"),
        COVER_OFFSET(201, "Add to first image field in Mobi Header to find PDB record containing the cover image"),
        THUMB_OFFSET(202, "Add to first image field in Mobi Header to find PDB record containing the thumbnail cover image"),
        HAS_FAKE_COVER(203, "hasfakecover"),
        CREATOR_SOFTWARE(204, "Known Values: 1=mobigen, 2=Mobipocket Creator, 200=kindlegen (Windows), 201=kindlegen (Linux), 202=kindlegen (Mac).\n Warning: Calibre creates fake creator entries, pretending to be a Linux kindlegen 1.2 (201, 1, 2, 33307) for normal ebooks and a non-public Linux kindlegen 2.0 (201, 2, 0, 101) for periodicals."),
        CREATOR_MAJOR_VERSION(205, "Creator Major Version"),
        CREATOR_MINOR_VERSION(206, "Creator Minor Version"),
        CREATOR_BUILD_NUMBER(207, "Creator Build Number"),
        WATERMARK(208, "Watermark"),
        TAMPER_PROOF_KEYS(209, "Used by the Kindle (and Android app) for generating book-specific PIDs."),
        FONT_SIGNATURE(300, "font signature"),
        CLIPPING_LIMIT(401, "Integer percentage of the text allowed to be clipped. Usually 10."),
        PUBLISHER_LIMIT(402, "publisher limit"),
        TTS_FLAG(404, "1 - Text to Speech disabled; 0 - Text to Speech enabled"),
        CDE_TYPE(501, "PDOC - Personal Doc; EBOK - ebook; EBSP - ebook sample;"),
        LAST_UPDATE_TIME(502, "last update time"),
        UPDATED_TITLE(503, "updated title"),
        ASIN_2(504, "a copy of ASIN in this record."),
        LANGUAGE(524, "language");                                                                        

        private int id;
        private String description;        
        private RecordType(int id, String description) {
            this.id = id;
            this.description = description;
        }
                
        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }
        
        
    }
    private long headerLength;
    private long recordCount;
    private Map<Long, ExthHeaderRecord> records = new HashMap<>();

    public long getHeaderLength() {
        return headerLength;
    }

    public void setHeaderLength(long headerLength) {
        this.headerLength = headerLength;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }
    
    public void addRecord(ExthHeaderRecord record) {
        records.put(record.getRecordType(), record);
    }
    
    public ExthHeaderRecord getRecord(RecordType type) {    
        return getRecord(type.getId());
    }
    
    public ExthHeaderRecord getRecord(long type) {
        return records.get(type);
    }
    
    public Collection<ExthHeaderRecord> getRecords() {
        return records.values();
    }

    @Override
    public String toString() {
        return "ExthHeader{" + "headerLength=" + headerLength + ", recordCount=" + recordCount + ", records=" + records + '}';
    }
        
}
