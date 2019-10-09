package ap.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IdUtilTest {

  private IdUtil idUtil;

  @BeforeEach
  public void init() {
    idUtil = new IdUtil();
  }

  @Test
  public void getFirstAvailableId1() {
    idUtil.getFirstAvailableId();
    Integer tempId = idUtil.getFirstAvailableId();
    idUtil.getFirstAvailableId();
    idUtil.releaseId(tempId);
    Integer id = idUtil.getFirstAvailableId();

    assertEquals(tempId, id);
  }
}
