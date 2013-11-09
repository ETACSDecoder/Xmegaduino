package processing.app.preproc;

import org.junit.Test;
import processing.app.helpers.FileUtils;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class PdePreprocessorTest {

  @Test
  public void testSourceWithQuoteAndDoubleQuotesEscapedAndFinalQuoteShouldNotRaiseException() throws Exception {
    String s = FileUtils.readFileToString(new File(PdePreprocessorTest.class.getResource("RemoteCallLogger_v1e0.ino").getFile()));

    String actualOutput = new PdePreprocessor().strip(s);
    String expectedOutput = FileUtils.readFileToString(new File(PdePreprocessorTest.class.getResource("RemoteCallLogger_v1e0.stripped.ino").getFile()));

    assertEquals(actualOutput, expectedOutput);
  }
}
