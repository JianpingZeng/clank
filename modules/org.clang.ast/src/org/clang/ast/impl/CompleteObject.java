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

package org.clang.ast.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;

/// A handle to a complete object (an object that is not a subobject of
/// another object).
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompleteObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2329,
 FQN="(anonymous namespace)::CompleteObject", NM="_ZN12_GLOBAL__N_114CompleteObjectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_114CompleteObjectE")
//</editor-fold>
public class/*struct*/ CompleteObject implements Native.Native$Bool {
  /// The value of the complete object.
  public APValue /*P*/ Value;
  /// The type of the complete object.
  public QualType Type;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompleteObject::CompleteObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2335,
   FQN="(anonymous namespace)::CompleteObject::CompleteObject", NM="_ZN12_GLOBAL__N_114CompleteObjectC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_114CompleteObjectC1Ev")
  //</editor-fold>
  public CompleteObject() {
    // : Value(null), Type() 
    //START JInit
    this.Value = null;
    this.Type = new QualType();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompleteObject::CompleteObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2336,
   FQN="(anonymous namespace)::CompleteObject::CompleteObject", NM="_ZN12_GLOBAL__N_114CompleteObjectC1EPN5clang7APValueENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_114CompleteObjectC1EPN5clang7APValueENS1_8QualTypeE")
  //</editor-fold>
  public CompleteObject(APValue /*P*/ Value, QualType Type) {
    // : Value(Value), Type(Type) 
    //START JInit
    this.Value = Value;
    this.Type = new QualType(Type);
    //END JInit
    assert ((Value != null)) : "missing value for complete object";
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompleteObject::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2341,
   FQN="(anonymous namespace)::CompleteObject::operator bool", NM="_ZNK12_GLOBAL__N_114CompleteObjectcvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZNK12_GLOBAL__N_114CompleteObjectcvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return (Value != null);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CompleteObject::CompleteObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 2329,
   FQN="(anonymous namespace)::CompleteObject::CompleteObject", NM="_ZN12_GLOBAL__N_114CompleteObjectC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_114CompleteObjectC1EOS0_")
  //</editor-fold>
  public /*inline*/ CompleteObject(JD$Move _dparam, final CompleteObject /*&&*/$Prm0) {
    // : Value(static_cast<CompleteObject &&>().Value), Type(static_cast<CompleteObject &&>().Type) 
    //START JInit
    this.Value = $Prm0.Value;
    this.Type = new QualType(JD$Move.INSTANCE, $Prm0.Type);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + ", Type=" + Type; // NOI18N
  }
}
