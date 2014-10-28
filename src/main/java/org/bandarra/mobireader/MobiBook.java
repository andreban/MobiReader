package org.bandarra.mobireader;

/**
 *
 * @author andreban
 */
public class MobiBook {
    private String title;
    private PDBHeader pdbHeader;
    private MobiHeader mobiHeader;
    private ExthHeader exthHeader;
    private PalmDocHeader palmDocHeader;

    public PDBHeader getPdbHeader() {
        return pdbHeader;
    }

    public void setPdbHeader(PDBHeader pdbHeader) {
        this.pdbHeader = pdbHeader;
    }

    public MobiHeader getMobiHeader() {
        return mobiHeader;
    }

    public void setMobiHeader(MobiHeader mobiHeader) {
        this.mobiHeader = mobiHeader;
    }

    public ExthHeader getExthHeader() {
        return exthHeader;
    }

    public void setExthHeader(ExthHeader exthHeader) {
        this.exthHeader = exthHeader;
    }

    public PalmDocHeader getPalmDocHeader() {
        return palmDocHeader;
    }

    public void setPalmDocHeader(PalmDocHeader palmDocHeader) {
        this.palmDocHeader = palmDocHeader;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MobiBook{" + "title=" + title + ", pdbHeader=" + pdbHeader + ", mobiHeader=" + mobiHeader + ", exthHeader=" + exthHeader + ", palmDocHeader=" + palmDocHeader + '}';
    }
        
}
