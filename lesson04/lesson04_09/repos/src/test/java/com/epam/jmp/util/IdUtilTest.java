package com.epam.jmp.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IdUtilTest {

  private IdUtil idUtil;

  @Before
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
