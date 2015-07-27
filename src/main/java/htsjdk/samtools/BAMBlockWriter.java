package htsjdk.samtools;

import htsjdk.samtools.BAMFileWriter;
import htsjdk.samtools.SAMFileHeader;
import htsjdk.samtools.SAMTextHeaderCodec;

import java.io.File;
import java.io.OutputStream;
import java.io.StringWriter;

/**
 * TODO: Insert description here. (generated by tjredekopp)
 */
public class BAMBlockWriter extends BAMFileWriter {
  public BAMBlockWriter(final OutputStream os, final File file, final boolean writeEndBlock) {
    super(os, file);
    //this.blockCompressedOutputStream.setWriteEndBlock(writeEndBlock);
  }
  
  protected void writeHeader(String textHeader) {
    // Deliberately empty.
  }
  
  public void writeHeader(final SAMFileHeader header) {
    final StringWriter headerTextBuffer = new StringWriter();
    new SAMTextHeaderCodec().encode(headerTextBuffer, header);
    final String headerText = headerTextBuffer.toString();
    super.writeHeader(headerText);
  }
}