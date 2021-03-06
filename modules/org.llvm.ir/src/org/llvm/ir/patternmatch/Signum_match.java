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

package org.llvm.ir.patternmatch;

import org.clank.support.*;
import static org.clank.support.Native.$Clone;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;
import org.llvm.ir.java.*;

/*template <typename Opnd_t> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::Signum_match">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1275,
 FQN="llvm::PatternMatch::Signum_match", NM="_ZN4llvm12PatternMatch12Signum_matchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch12Signum_matchE")
//</editor-fold>
public class/*struct*/ Signum_match</*typename*/ Opnd_t extends match<Opnd_t>>  implements match<Signum_match> {
  public Opnd_t Val;
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::Signum_match::Signum_match<Opnd_t>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1277,
   FQN="llvm::PatternMatch::Signum_match::Signum_match<Opnd_t>", NM="_ZN4llvm12PatternMatch12Signum_matchC1ERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm12PatternMatch12Signum_matchC1ERKT_")
  //</editor-fold>
  public Signum_match(final /*const*/ Opnd_t /*&*/ V) {
    // : Val(V) 
    //START JInit
    this.Val = /*ParenListExpr*/$Clone(V);
    //END JInit
  }

  
  /*template <typename OpTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PatternMatch::Signum_match::match">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PatternMatch.h", line = 1279,
   FQN="llvm::PatternMatch::Signum_match::match", NM="Tpl__ZN4llvm12PatternMatch12Signum_match5matchEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=Tpl__ZN4llvm12PatternMatch12Signum_match5matchEPT_")
  //</editor-fold>
  public </*typename*/ OpTy extends Value> boolean match(OpTy /*P*/ V) {
    /*uint*/int TypeSize = V.getType().getScalarSizeInBits();
    if (TypeSize == 0) {
      return false;
    }
    
    /*uint*/int ShiftWidth = TypeSize - 1;
    type$ref<Value /*P*/ > OpL = create_type$null$ref(null);
    type$ref<Value /*P*/ > OpR = create_type$null$ref(null);
    
    // This is the representation of signum we match:
    //
    //  signum(x) == (x >> 63) | (-x >>u 63)
    //
    // An i1 value is its own signum, so it's correct to match
    //
    //  signum(x) == (x >> 0)  | (-x >>u 0)
    //
    // for i1 values.
    BinaryOp_match LHS = PatternMatchGlobals.m_AShr(PatternMatchGlobals.m_Value(OpL), PatternMatchGlobals.m_SpecificInt($uint2ulong(ShiftWidth)));
    BinaryOp_match RHS = PatternMatchGlobals.m_LShr(PatternMatchGlobals.m_Neg(PatternMatchGlobals.m_Value(OpR)), PatternMatchGlobals.m_SpecificInt($uint2ulong(ShiftWidth)));
    BinaryOp_match Signum = PatternMatchGlobals.m_Or(LHS, RHS);
    
    return Native.$bool(Native.$bool(Signum.match(V)) && OpL.$deref() == OpR.$deref()) && Native.$bool(Val.match(OpL.$deref()));
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public Signum_match clone() {
    return new Signum_match(this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Val=" + Val; // NOI18N
  }
}
