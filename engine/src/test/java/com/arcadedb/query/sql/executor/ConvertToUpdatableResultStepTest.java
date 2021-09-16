package com.arcadedb.query.sql.executor;

import com.arcadedb.TestHelper;
import com.arcadedb.database.Document;
import com.arcadedb.database.MutableDocument;
import com.arcadedb.exception.TimeoutException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ConvertToUpdatableResultStepTest {

  private static final String         STRING_PROPERTY  = "stringPropertyName";
  private static final String         INTEGER_PROPERTY = "integerPropertyName";
  private final        List<Document> documents        = new ArrayList<>();

  @Test
  public void shouldConvertUpdatableResult() throws Exception {
    TestHelper.executeInNewDatabase((database) -> {
      String type = TestHelper.createRandomType(database).getName();

      CommandContext context = new BasicCommandContext();
      ConvertToUpdatableResultStep step = new ConvertToUpdatableResultStep(context, false);
      AbstractExecutionStep previous = new AbstractExecutionStep(context, false) {
        boolean done = false;

        @Override
        public ResultSet syncPull(CommandContext ctx, int nRecords) throws TimeoutException {
          InternalResultSet result = new InternalResultSet();
          if (!done) {
            for (int i = 0; i < 10; i++) {
              ResultInternal item = new ResultInternal();
              MutableDocument document = database.newDocument(type);
              document.set(STRING_PROPERTY, UUID.randomUUID().toString());
              document.set(INTEGER_PROPERTY, new Random().nextInt());
              documents.add(document);
              item.setElement(document);
              result.add(item);
            }
            done = true;
          }
          return result;
        }
      };

      step.setPrevious(previous);
      ResultSet result = step.syncPull(context, 10);

      int counter = 0;
      while (result.hasNext()) {
        Result currentItem = result.next();
        if (!(currentItem.getClass().equals(UpdatableResult.class))) {
          Assertions.fail("There is an item in result set that is not an instance of OUpdatableResult");
        }
        if (!currentItem.getElement().get().get(STRING_PROPERTY).equals(documents.get(counter).get(STRING_PROPERTY))) {
          Assertions.fail("String Document property inside Result instance is not preserved");
        }
        if (!currentItem.getElement().get().get(INTEGER_PROPERTY).equals(documents.get(counter).get(INTEGER_PROPERTY))) {
          Assertions.fail("Integer Document property inside Result instance is not preserved");
        }
        counter++;
      }
    });
  }
}
