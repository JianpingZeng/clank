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

package org.clang.analysis.analyses.threadSafety.til;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;


/// Opcode for cast operations.
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::TIL_CastOpcode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyTIL.h", line = 100,
 FQN="clang::threadSafety::til::TIL_CastOpcode", NM="_ZN5clang12threadSafety3til14TIL_CastOpcodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyTIL.cpp -nm=_ZN5clang12threadSafety3til14TIL_CastOpcodeE")
//</editor-fold>
public enum TIL_CastOpcode/* : unsigned char*/ implements Native.ComparableLower {
  CAST_none($int2uchar(0)),
  CAST_extendNum(CAST_none.getValue() + 1), // extend precision of numeric type
  CAST_truncNum(CAST_extendNum.getValue() + 1), // truncate precision of numeric type
  CAST_toFloat(CAST_truncNum.getValue() + 1), // convert to floating point type
  CAST_toInt(CAST_toFloat.getValue() + 1), // convert to integer type
  CAST_objToPtr(CAST_toInt.getValue() + 1); // convert smart pointer to pointer  (C++ only)

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static TIL_CastOpcode valueOf(/*uchar*/byte val) {
    TIL_CastOpcode out = valueOf((int)val);
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
    return out;
  }
  public static TIL_CastOpcode valueOf(int val) {
    TIL_CastOpcode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final TIL_CastOpcode[] VALUES;
    private static final TIL_CastOpcode[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (TIL_CastOpcode kind : TIL_CastOpcode.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new TIL_CastOpcode[min < 0 ? (1-min) : 0];
      VALUES = new TIL_CastOpcode[max >= 0 ? (1+max) : 0];
      for (TIL_CastOpcode kind : TIL_CastOpcode.values()) {
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

  private final /*uchar*/byte value;
  private TIL_CastOpcode(int val) { this.value = (/*uchar*/byte)val;}
  public /*uchar*/byte getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uchar(value, ((TIL_CastOpcode)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uchar(value, ((TIL_CastOpcode)obj).value);}
  //</editor-fold>
}
