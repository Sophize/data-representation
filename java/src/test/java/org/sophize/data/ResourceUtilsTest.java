package org.sophize.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.sophize.data.ResourceUtils.toJsonString;

class ResourceUtilsTest {

  @Test
  void readWriteFile() throws Exception {
    Term originalTerm = new Term();
    originalTerm.setPhrase("orange");
    originalTerm.setDefinition("A round fruit");
    User contributor = new User();
    contributor.setHandle("abc");
    originalTerm.setContributor(contributor);

    ResourceUtils.writeJson("orange", originalTerm);

    Term readTerm = (Term)ResourceUtils.readResource("T_orange.json");

    Assertions.assertEquals(toJsonString(readTerm), toJsonString(originalTerm));
  }
}
