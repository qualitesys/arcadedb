/* Generated by: JJTree: Do not edit this line. UnionMembers.java Version 1.1 */
/* ParserGeneratorCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.arcadedb.graphql.parser;

import java.util.ArrayList;
import java.util.List;

public
class UnionMembers extends SimpleNode {
  protected List<TypeName> typeNames = new ArrayList<>();

  public UnionMembers(int id) {
    super(id);
  }

  public UnionMembers(GraphQLParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(GraphQLParserVisitor visitor, Object data) {
    return
    visitor.visit(this, data);
  }
}
/* ParserGeneratorCC - OriginalChecksum=f97c07f2fcabe34be203e80b7dda6297 (do not edit this line) */