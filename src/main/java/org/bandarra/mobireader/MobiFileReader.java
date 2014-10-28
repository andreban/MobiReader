
package org.bandarra.mobireader;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author andreban
 */
public class MobiFileReader {
    public MobiFileReader() {
        
    }
    
    public MobiBook readFile(String fileName) throws IOException {
        try (RandomAccessFile din = new RandomAccessFile(fileName, "r")) {        
            MobiBook book = new MobiBook();            
            PDBHeader header = new PDBHeader();            
            book.setPdbHeader(header);
            
            byte[] buffer = new byte[1024];
            din.read(buffer, 0, 32);
            String databaseName = new String(buffer, 0, 32).trim();
            header.setDatabaseName(databaseName);
            header.setAttributes(din.readUnsignedShort());
            header.setVersion(din.readUnsignedShort());

            header.setCreationDate(din.readInt() & 0xFFFFFFFFL);
            header.setModificationDate(din.readInt() & 0xFFFFFFFFL);
            header.setLastBackupDate(din.readInt() & 0xFFFFFFFFL);
            header.setModificationNumber(din.readInt() & 0xFFFFFFFFL);
            header.setAppInfoId(din.readInt() & 0xFFFFFFFFL);
            header.setSortInfoId(din.readInt() & 0xFFFFFFFFL);

            din.read(buffer, 0, 4);
            header.setType(new String(buffer, 0, 4));

            din.read(buffer, 0, 4);
            header.setCreator(new String(buffer, 0, 4));

            header.setUniqueSeedID(din.readInt() & 0xFFFFFFFFL);
            header.setNextRecordListID(din.readInt() & 0xFFFFFFFFL);
            header.setNumberOfRecords(din.readUnsignedShort());

            for (int i = 0; i < header.getNumberOfRecords(); i++) {
                PDBRecordHeader recordHeader = new PDBRecordHeader();
                recordHeader.setDataOffset(din.readInt() & 0xFFFFFFFFL);
                recordHeader.setRecordAttributes(din.readByte());
                din.skipBytes(3);                
                header.addPDBRecordHeader(recordHeader);
            }

           
            //Read PalmDOC Header            
            din.seek(header.getPDBRecordHeader(0).getDataOffset()); //seek to the first PDB Record
            
            PalmDocHeader palmDocHeader = new PalmDocHeader();
            book.setPalmDocHeader(palmDocHeader);            
            palmDocHeader.setCompression(din.readUnsignedShort());

            din.skipBytes(2);  //Unused Short (should be 0)
            palmDocHeader.setTextLength(din.readInt() & 0xFFFFFFFFL);

            palmDocHeader.setRecordCount(din.readUnsignedShort());
            palmDocHeader.setRecordSize(din.readUnsignedShort());
            palmDocHeader.setEncryption(din.readUnsignedShort());            
            din.skipBytes(2);

            MobiHeader mobiHeader = new MobiHeader();
            book.setMobiHeader(mobiHeader);            
            din.read(buffer, 0, 4);
            String identifier = new String(buffer, 0, 4);
            if (!"MOBI".equals(identifier)) {
                throw new IOException("Invalid Mobi File. Identifier != MOBI");
            }
            mobiHeader.setLength(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setType(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setEncodingId(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setUniqueId(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setFileVersion(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setOrthographicIndex(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setInflectionIndex(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setIndexNames(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setIndexKeys(din.readInt() & 0xFFFFFFFFL);
                                                        
            for (int i = 0; i < 6; i++){
                mobiHeader.setExtraIndex(i, din.readInt() & 0xFFFFFFFFL);
            }
            mobiHeader.setFirstNonBookIndex(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setFullNameOffset(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setFullNameLength(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setLocaleId(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setInputLanguageId(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setOutputLanguageId(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setMinVersion(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setFirstImageIndex(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setHuffmanRecordOffset(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setHuffmanRecordCount(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setHuffmanTableOffset(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setHuffmanTableLength(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setExthFlags(din.readInt() & 0xFFFFFFFFL);

            din.skipBytes(32);//32 unknown bytes, if MOBI is long enough
            din.skipBytes(4);//Unknown Int

            mobiHeader.setDrmOffset(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setDrmCount(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setDrmSize(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setDrmFlags(din.readInt() & 0xFFFFFFFFL);

                            
            din.skipBytes(8);
            mobiHeader.setFirstContentRecord(din.readUnsignedShort());
            mobiHeader.setLastContentRecord(din.readUnsignedShort());

            din.skipBytes(4);//unknown int 

            mobiHeader.setFcisRecordNumber(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setFcisRecordCount(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setFlisRecordNumber(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setFlisRecordCount(din.readInt() & 0xFFFFFFFFL);

            din.skipBytes(8);  
            din.skipBytes(4);//Unknown Int
            
            mobiHeader.setFirstCompilationDataSectionCount(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setNumCompilationDataSections(din.readInt() & 0xFFFFFFFFL);

            din.skipBytes(4);//Unknown int
            
            mobiHeader.setExtraRecordDataFlags(din.readInt() & 0xFFFFFFFFL);
            mobiHeader.setIndxRecordOffset(din.readInt() & 0xFFFFFFFFL);

            boolean hasEXTH = (mobiHeader.getExthFlags() & 0x40) > 0;       
            if (hasEXTH) {                                
                din.read(buffer, 0, 4);     
                String exthIdentifier = new String(buffer, 0, 4);
                if (!exthIdentifier.equals("EXTH")) {
                    din.skipBytes(12);//Undocumented Bytes                  
                    din.read(buffer, 0, 4);     
                    exthIdentifier = new String(buffer, 0, 4);  
                    if (!exthIdentifier.equals("EXTH")) {     
                        din.skipBytes(4);
                        din.read(buffer, 0, 4);     
                        exthIdentifier = new String(buffer, 0, 4);  
                        if (!exthIdentifier.equals("EXTH")) {                             
                            throw new IOException("Invalid EXTH Identifier: " + exthIdentifier);
                        }
                    }
                }
                
                
                ExthHeader exthHeader = new ExthHeader();
                book.setExthHeader(exthHeader);
                exthHeader.setHeaderLength(din.readInt() & 0xFFFFFFFFL);
                exthHeader.setRecordCount(din.readInt() & 0xFFFFFFFFL);

                for (int i = 0; i < exthHeader.getRecordCount(); i++) {
                    ExthHeaderRecord record = new ExthHeaderRecord();
                    record.setRecordType(din.readInt() & 0xFFFFFFFFL);
                    record.setRecordLength(din.readInt() & 0xFFFFFFFFL);

                    int bytesToRead = (int)record.getRecordLength() - 8;
                    byte[] content = new byte[bytesToRead];
                    din.read(content, 0, bytesToRead);
                    record.setRawRecordData(content);  
                    exthHeader.addRecord(record);
                }

                din.seek(header.getPDBRecordHeader(0).getDataOffset() + mobiHeader.getFullNameOffset());
                din.read(buffer, 0, (int)mobiHeader.getFullNameLength());

            }
            book.setTitle(new String(buffer, 0, (int)mobiHeader.getFullNameLength()));
            return book;            
        }
        
    }
    
    public static void main(String[] args) throws Exception {
        MobiFileReader reader = new MobiFileReader();
        Path p = Paths.get(args[0]);
        SimpleFileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(".mobi")) {
                    System.out.println("");
                    System.out.println(file);                    
                    MobiBook book = new MobiFileReader().readFile(file.toString());                        
                    System.out.println("Title: " + book.getTitle());
                    if (book.getExthHeader().getRecord(ExthHeader.RecordType.AUTHOR)  != null) {
                        System.out.println("Author: " + book.getExthHeader().getRecord(ExthHeader.RecordType.AUTHOR).getString());
                    }
                    if (book.getExthHeader().getRecord(ExthHeader.RecordType.PUBLISHER) != null) {
                        System.out.println("Publisher: " + book.getExthHeader().getRecord(ExthHeader.RecordType.PUBLISHER).getString());                        
                    }
                    if (book.getExthHeader().getRecord(ExthHeader.RecordType.ISBN) != null) {
                        System.out.println("ISBN: " + book.getExthHeader().getRecord(ExthHeader.RecordType.ISBN).getString());                        
                    }                    
                    
                }
                return FileVisitResult.CONTINUE;
            }            
        };
        
        Files.walkFileTree(p, fileVisitor);
    }
}
