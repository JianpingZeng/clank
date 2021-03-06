/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clang.ast.comments;

import org.clank.support.*;


//<editor-fold defaultstate="collapsed" desc="static type tok">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments3tok9TokenKindE; -static-type=tok -package=org.clang.ast.comments")
//</editor-fold>
public final class tok {

//<editor-fold defaultstate="collapsed" desc="clang::comments::tok::TokenKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CommentLexer.h", line = 34,
 FQN="clang::comments::tok::TokenKind", NM="_ZN5clang8comments3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments3tok9TokenKindE")
//</editor-fold>
public enum TokenKind implements Native.ComparableLower, Native.NativeUIntEnum {
  eof(0),
  newline(eof.getValue() + 1),
  text(newline.getValue() + 1),
  unknown_command(text.getValue() + 1), // Command that does not have an ID.
  backslash_command(unknown_command.getValue() + 1), // Command with an ID, that used backslash marker.
  at_command(backslash_command.getValue() + 1), // Command with an ID, that used 'at' marker.
  verbatim_block_begin(at_command.getValue() + 1),
  verbatim_block_line(verbatim_block_begin.getValue() + 1),
  verbatim_block_end(verbatim_block_line.getValue() + 1),
  verbatim_line_name(verbatim_block_end.getValue() + 1),
  verbatim_line_text(verbatim_line_name.getValue() + 1),
  html_start_tag(verbatim_line_text.getValue() + 1), // <tag
  html_ident(html_start_tag.getValue() + 1), // attr
  html_equals(html_ident.getValue() + 1), // =
  html_quoted_string(html_equals.getValue() + 1), // "blah\"blah" or 'blah\'blah'
  html_greater(html_quoted_string.getValue() + 1), // >
  html_slash_greater(html_greater.getValue() + 1), // />
  html_end_tag(html_slash_greater.getValue() + 1); // </tag

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static TokenKind valueOf(int val) {
    TokenKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final TokenKind[] VALUES;
    private static final TokenKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (TokenKind kind : TokenKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new TokenKind[min < 0 ? (1-min) : 0];
      VALUES = new TokenKind[max >= 0 ? (1+max) : 0];
      for (TokenKind kind : TokenKind.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private TokenKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((TokenKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((TokenKind)obj).value);}
  //</editor-fold>
}
} // END OF class tok
