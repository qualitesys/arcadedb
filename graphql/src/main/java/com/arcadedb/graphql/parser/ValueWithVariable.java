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
/* Generated by: JJTree: Do not edit this line. ValueWithVariable.java Version 1.1 */
/* ParserGeneratorCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.arcadedb.graphql.parser;

public class ValueWithVariable extends SimpleNode {

  protected VariableLiteral         variableLiteral;
  protected IntValue                intValue;
  protected FloatValue              floatValue;
  protected StringValue             stringValue;
  protected BooleanValue            booleanValue;
  protected EnumValue               enumValue;
  protected ListValueWithVariable   listValueWithVariable;
  protected ObjectValueWithVariable objectValueWithVariable;

  public ValueWithVariable(int id) {
    super(id);
  }

  public ValueWithVariable(GraphQLParser p, int id) {
    super(p, id);
  }

  /**
   * Accept the visitor.
   **/
  public Object jjtAccept(GraphQLParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  public AbstractValue getValue() {
    if (variableLiteral != null)
      return variableLiteral;
    else if (intValue != null)
      return intValue;
    else if (floatValue != null)
      return floatValue;
    else if (stringValue != null)
      return stringValue;
    else if (booleanValue != null)
      return booleanValue;
    else if (enumValue != null)
      return enumValue;
    else if (listValueWithVariable != null)
      return listValueWithVariable;
    else if (objectValueWithVariable != null)
      return objectValueWithVariable;

    return null;
  }

  @Override
  public String toString() {
    return "" + getValue();
  }
}
/* ParserGeneratorCC - OriginalChecksum=7d715420456ed7cdb3c0875b52f6a13a (do not edit this line) */
