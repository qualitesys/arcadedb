/*
 * Copyright 2021 Arcade Data Ltd
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.arcadedb.importer;

import com.arcadedb.importer.format.FormatImporter;

import java.util.HashMap;
import java.util.Map;

public class SourceSchema {
  private final FormatImporter      formatImporter;
  private final Source              source;
  private final AnalyzedSchema      schema;
  private final Map<String, String> options = new HashMap<>();

  public SourceSchema(final FormatImporter formatImporter, final Source source, final AnalyzedSchema schema) {
    this.formatImporter = formatImporter;
    this.source = source;
    this.schema = schema;
  }

  public SourceSchema set(final String option, final String value) {
    options.put(option, value);
    return this;
  }

  public AnalyzedSchema getSchema() {
    return schema;
  }

  public Source getSource() {
    return source;
  }

  public Map<String, String> getOptions() {
    return options;
  }

  public FormatImporter getContentImporter() {
    return formatImporter;
  }
}
