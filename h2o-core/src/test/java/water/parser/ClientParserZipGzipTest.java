package water.parser;

import org.junit.BeforeClass;
import org.junit.Test;
import water.TestUtil;
import water.fvec.Frame;

import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class ClientParserZipGzipTest extends TestUtil {
  //
  // BIG WARNING: this test is not executed in client mode if it is run
  // under regular H2O test infrastructure. See [PUBDEV-2643]
  //
  @BeforeClass
  static public void setup() {
    stall_till_cloudsize(1);
  }

  @Test
  public void testBasic() throws IOException {
    Frame one_zip_directory = parse_test_file("bigdata/laptop/parser/hexdev_497/milsongs_csv.zip");
    Frame one_csv_directory = parse_test_folder("bigdata/laptop/parser/hexdev_497/milsongs_csv_gzip");


    assertTrue(TestUtil.isBitIdentical(one_zip_directory, one_csv_directory));
  }
}
