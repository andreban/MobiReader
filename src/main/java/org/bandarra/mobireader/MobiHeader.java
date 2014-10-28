package org.bandarra.mobireader;

/**
 *
 * @author andreban
 */
public class MobiHeader {
    private long length;
    private long type;
    private long encodingId;
    private long uniqueId;
    private long fileVersion;
    private long orthographicIndex;
    private long inflectionIndex;
    private long indexNames;
    private long indexKeys;
    private long[] extraIndexes = new long[6];
    private long firstNonBookIndex;
    private long fullNameOffset;
    private long fullNameLength;
    private long localeId;
    private long inputLanguageId;
    private long outputLanguageId;
    private long minVersion;
    private long firstImageIndex;
    private long huffmanRecordOffset;
    private long huffmanRecordCount;
    private long huffmanTableOffset;
    private long huffmanTableLength;
    private long exthFlags;
    private long drmOffset;
    private long drmCount;
    private long drmSize;
    private long drmFlags;
    private long firstContentRecord;
    private long lastContentRecord;
    private long fcisRecordNumber;
    private long fcisRecordCount;
    private long flisRecordNumber;
    private long flisRecordCount;
    private long firstCompilationDataSectionCount;
    private long numCompilationDataSections;
    private long extraRecordDataFlags;
    private long indxRecordOffset;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getEncodingId() {
        return encodingId;
    }

    public void setEncodingId(long encodingId) {
        this.encodingId = encodingId;
    }

    public long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public long getFileVersion() {
        return fileVersion;
    }

    public void setFileVersion(long fileVersion) {
        this.fileVersion = fileVersion;
    }

    public long getOrthographicIndex() {
        return orthographicIndex;
    }

    public void setOrthographicIndex(long orthographicIndex) {
        this.orthographicIndex = orthographicIndex;
    }

    public long getInflectionIndex() {
        return inflectionIndex;
    }

    public void setInflectionIndex(long inflectionIndex) {
        this.inflectionIndex = inflectionIndex;
    }

    public long getIndexNames() {
        return indexNames;
    }

    public void setIndexNames(long indexNames) {
        this.indexNames = indexNames;
    }

    public long getIndexKeys() {
        return indexKeys;
    }

    public void setIndexKeys(long indexKeys) {
        this.indexKeys = indexKeys;
    }

    public long[] getExtraIndexes() {
        return extraIndexes;
    }

    public void setExtraIndexes(long[] extraIndexes) {
        this.extraIndexes = extraIndexes;
    }

    public void setExtraIndex(int postion, long value) {
        this.extraIndexes[postion] = value;
    }
    
    public long getFirstNonBookIndex() {
        return firstNonBookIndex;
    }

    public void setFirstNonBookIndex(long firstNonBookIndex) {
        this.firstNonBookIndex = firstNonBookIndex;
    }

    public long getFullNameOffset() {
        return fullNameOffset;
    }

    public void setFullNameOffset(long fullNameOffset) {
        this.fullNameOffset = fullNameOffset;
    }

    public long getFullNameLength() {
        return fullNameLength;
    }

    public void setFullNameLength(long fullNameLength) {
        this.fullNameLength = fullNameLength;
    }

    public long getLocaleId() {
        return localeId;
    }

    public void setLocaleId(long localeId) {
        this.localeId = localeId;
    }

    public long getInputLanguageId() {
        return inputLanguageId;
    }

    public void setInputLanguageId(long inputLanguageId) {
        this.inputLanguageId = inputLanguageId;
    }

    public long getOutputLanguageId() {
        return outputLanguageId;
    }

    public void setOutputLanguageId(long outputLanguageId) {
        this.outputLanguageId = outputLanguageId;
    }

    public long getMinVersion() {
        return minVersion;
    }

    public void setMinVersion(long minVersion) {
        this.minVersion = minVersion;
    }

    public long getFirstImageIndex() {
        return firstImageIndex;
    }

    public void setFirstImageIndex(long firstImageIndex) {
        this.firstImageIndex = firstImageIndex;
    }

    public long getHuffmanRecordOffset() {
        return huffmanRecordOffset;
    }

    public void setHuffmanRecordOffset(long huffmanRecordOffset) {
        this.huffmanRecordOffset = huffmanRecordOffset;
    }

    public long getHuffmanRecordCount() {
        return huffmanRecordCount;
    }

    public void setHuffmanRecordCount(long huffmanRecordCount) {
        this.huffmanRecordCount = huffmanRecordCount;
    }

    public long getHuffmanTableOffset() {
        return huffmanTableOffset;
    }

    public void setHuffmanTableOffset(long huffmanTableOffset) {
        this.huffmanTableOffset = huffmanTableOffset;
    }

    public long getHuffmanTableLength() {
        return huffmanTableLength;
    }

    public void setHuffmanTableLength(long huffmanTableLength) {
        this.huffmanTableLength = huffmanTableLength;
    }

    public long getExthFlags() {
        return exthFlags;
    }

    public void setExthFlags(long exthFlags) {
        this.exthFlags = exthFlags;
    }

    public long getDrmOffset() {
        return drmOffset;
    }

    public void setDrmOffset(long drmOffset) {
        this.drmOffset = drmOffset;
    }

    public long getDrmCount() {
        return drmCount;
    }

    public void setDrmCount(long drmCount) {
        this.drmCount = drmCount;
    }

    public long getDrmSize() {
        return drmSize;
    }

    public void setDrmSize(long drmSize) {
        this.drmSize = drmSize;
    }

    public long getDrmFlags() {
        return drmFlags;
    }

    public void setDrmFlags(long drmFlags) {
        this.drmFlags = drmFlags;
    }

    public long getFirstContentRecord() {
        return firstContentRecord;
    }

    public void setFirstContentRecord(long firstContentRecord) {
        this.firstContentRecord = firstContentRecord;
    }

    public long getLastContentRecord() {
        return lastContentRecord;
    }

    public void setLastContentRecord(long lastContentRecord) {
        this.lastContentRecord = lastContentRecord;
    }

    public long getFcisRecordNumber() {
        return fcisRecordNumber;
    }

    public void setFcisRecordNumber(long fcisRecordNumber) {
        this.fcisRecordNumber = fcisRecordNumber;
    }

    public long getFcisRecordCount() {
        return fcisRecordCount;
    }

    public void setFcisRecordCount(long fcisRecordCount) {
        this.fcisRecordCount = fcisRecordCount;
    }

    public long getFlisRecordNumber() {
        return flisRecordNumber;
    }

    public void setFlisRecordNumber(long flisRecordNumber) {
        this.flisRecordNumber = flisRecordNumber;
    }

    public long getFlisRecordCount() {
        return flisRecordCount;
    }

    public void setFlisRecordCount(long flisRecordCount) {
        this.flisRecordCount = flisRecordCount;
    }

    public long getFirstCompilationDataSectionCount() {
        return firstCompilationDataSectionCount;
    }

    public void setFirstCompilationDataSectionCount(long firstCompilationDataSectionCount) {
        this.firstCompilationDataSectionCount = firstCompilationDataSectionCount;
    }

    public long getNumCompilationDataSections() {
        return numCompilationDataSections;
    }

    public void setNumCompilationDataSections(long numCompilationDataSections) {
        this.numCompilationDataSections = numCompilationDataSections;
    }

    public long getExtraRecordDataFlags() {
        return extraRecordDataFlags;
    }

    public void setExtraRecordDataFlags(long extraRecordDataFlags) {
        this.extraRecordDataFlags = extraRecordDataFlags;
    }

    public long getIndxRecordOffset() {
        return indxRecordOffset;
    }

    public void setIndxRecordOffset(long indxRecordOffset) {
        this.indxRecordOffset = indxRecordOffset;
    }             

    @Override
    public String toString() {
        return "MobiHeader{" + "length=" + length + ", type=" + type + ", encodingId=" + encodingId + ", uniqueId=" + uniqueId + ", fileVersion=" + fileVersion + ", orthographicIndex=" + orthographicIndex + ", inflectionIndex=" + inflectionIndex + ", indexNames=" + indexNames + ", indexKeys=" + indexKeys + ", extraIndexes=" + extraIndexes + ", firstNonBookIndex=" + firstNonBookIndex + ", fullNameOffset=" + fullNameOffset + ", fullNameLength=" + fullNameLength + ", localeId=" + localeId + ", inputLanguageId=" + inputLanguageId + ", outputLanguageId=" + outputLanguageId + ", minVersion=" + minVersion + ", firstImageIndex=" + firstImageIndex + ", huffmanRecordOffset=" + huffmanRecordOffset + ", huffmanRecordCount=" + huffmanRecordCount + ", huffmanTableOffset=" + huffmanTableOffset + ", huffmanTableLength=" + huffmanTableLength + ", exthFlags=" + exthFlags + ", drmOffset=" + drmOffset + ", drmCount=" + drmCount + ", drmSize=" + drmSize + ", drmFlags=" + drmFlags + ", firstContentRecord=" + firstContentRecord + ", lastContentRecord=" + lastContentRecord + ", fcisRecordNumber=" + fcisRecordNumber + ", fcisRecordCount=" + fcisRecordCount + ", flisRecordNumber=" + flisRecordNumber + ", flisRecordCount=" + flisRecordCount + ", firstCompilationDataSectionCount=" + firstCompilationDataSectionCount + ", numCompilationDataSections=" + numCompilationDataSections + ", extraRecordDataFlags=" + extraRecordDataFlags + ", indxRecordOffset=" + indxRecordOffset + '}';
    }
    
    
}
