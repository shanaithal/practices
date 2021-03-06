package hackerearth.util;

import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.DetailedDiff;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.*;

public final class FileUtil {

  private FileUtil() {

    throw new UnsupportedOperationException();
  }

  public static String fetchFileContentAsString(String filePath) throws IOException {

    return IOUtils.toString(fetchFileContentAsStream(filePath), FileType.UTF_8.value());
  }

  public static InputStream fetchFileContentAsStream(String filePath) throws IOException {

    File file = new File(filePath);

    return new FileInputStream(file);
  }

  public static boolean isXMLsSame(String inputFile, String generate) throws IOException {

    XMLUnit.setIgnoreWhitespace(true);

    // expected -> control
    InputSource myExpectedXml = fetchFileContent(inputFile);

    XMLUnit.setIgnoreWhitespace(true);
    // test -> generated
    InputSource test = new InputSource(new ByteArrayInputStream(generate.getBytes(FileType.UTF_8.value())));
    Diff diff;
    try {
      diff = XMLUnit.compareXML(myExpectedXml, test);

      boolean identical = diff.identical();

      if (!identical) {

        DetailedDiff detailedDiff = new DetailedDiff(diff);
        System.err.println(detailedDiff.getAllDifferences());
      }

      return identical;
    } catch (SAXException e) {
      return false;
    }
  }

  public static InputSource fetchFileContent(String inXmlPath) throws IOException {

    InputSource inputSource =
        new InputSource(new InputStreamReader(fetchFileContentAsStream(inXmlPath), FileType.UTF_8.value()));
    inputSource.setEncoding(FileType.UTF_8.value());

    return inputSource;
  }
}
