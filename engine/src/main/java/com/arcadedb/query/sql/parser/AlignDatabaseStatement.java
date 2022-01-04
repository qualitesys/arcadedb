/*
 * Copyright © 2021-present Arcade Data Ltd (info@arcadedata.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* Generated by: JJTree: Do not edit this line. AlignDatabaseStatement.java Version 1.1 */
/* ParserGeneratorCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.arcadedb.query.sql.parser;

import com.arcadedb.database.DatabaseInternal;
import com.arcadedb.query.sql.executor.CommandContext;
import com.arcadedb.query.sql.executor.InternalResultSet;
import com.arcadedb.query.sql.executor.ResultInternal;
import com.arcadedb.query.sql.executor.ResultSet;

import java.util.*;

public class AlignDatabaseStatement extends SimpleExecStatement {
  public AlignDatabaseStatement(final int id) {
    super(id);
  }

  public AlignDatabaseStatement(final SqlParser p, final int id) {
    super(p, id);
  }

  @Override
  public ResultSet executeSimple(final CommandContext ctx) {
    final ResultInternal result = new ResultInternal();
    result.setProperty("operation", "align database");

    if (ctx.getDatabase().isTransactionActive())
      ctx.getDatabase().rollback();

    final DatabaseInternal database = ctx.getDatabase().getWrappedDatabaseInstance();

    final Map<String, Object> commandResult = database.alignToReplicas();

    result.setPropertiesFromMap(commandResult);

    final InternalResultSet rs = new InternalResultSet();
    rs.add(result);
    return rs;
  }

  @Override
  public void toString(final Map<String, Object> params, final StringBuilder builder) {
    builder.append("ALIGN DATABASE");
  }
}
/* ParserGeneratorCC - OriginalChecksum=1fdf26fbfd4b324c2953b99f2dc55ff8 (do not edit this line) */
