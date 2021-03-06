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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockEdge">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 43,
 FQN="llvm::BasicBlockEdge", NM="_ZN4llvm14BasicBlockEdgeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm14BasicBlockEdgeE")
//</editor-fold>
public class BasicBlockEdge {
  private /*const*/ BasicBlock /*P*/ Start;
  private /*const*/ BasicBlock /*P*/ End;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockEdge::BasicBlockEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 47,
   FQN="llvm::BasicBlockEdge::BasicBlockEdge", NM="_ZN4llvm14BasicBlockEdgeC1EPKNS_10BasicBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm14BasicBlockEdgeC1EPKNS_10BasicBlockES3_")
  //</editor-fold>
  public BasicBlockEdge(/*const*/ BasicBlock /*P*/ Start_, /*const*/ BasicBlock /*P*/ End_) {
    // : Start(Start_), End(End_)
    //START JInit
    this.Start = Start_;
    this.End = End_;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockEdge::getStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 49,
   FQN="llvm::BasicBlockEdge::getStart", NM="_ZNK4llvm14BasicBlockEdge8getStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm14BasicBlockEdge8getStartEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ getStart() /*const*/ {
    return Start;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockEdge::getEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 52,
   FQN="llvm::BasicBlockEdge::getEnd", NM="_ZNK4llvm14BasicBlockEdge6getEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm14BasicBlockEdge6getEndEv")
  //</editor-fold>
  public /*const*/ BasicBlock /*P*/ getEnd() /*const*/ {
    return End;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockEdge::isSingleEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Dominators.cpp", line = 40,
   FQN="llvm::BasicBlockEdge::isSingleEdge", NM="_ZNK4llvm14BasicBlockEdge12isSingleEdgeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZNK4llvm14BasicBlockEdge12isSingleEdgeEv")
  //</editor-fold>
  public boolean isSingleEdge() /*const*/ {
    /*const*/ TerminatorInst /*P*/ TI = Start.getTerminator$Const();
    /*uint*/int NumEdgesToEnd = 0;
    for (/*uint*/int i = 0, n = TI.getNumSuccessors(); $less_uint(i, n); ++i) {
      if (TI.getSuccessor(i) == End) {
        ++NumEdgesToEnd;
      }
      if ($greatereq_uint(NumEdgesToEnd, 2)) {
        return false;
      }
    }
    assert (NumEdgesToEnd == 1);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::BasicBlockEdge::BasicBlockEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Dominators.h", line = 43,
   FQN="llvm::BasicBlockEdge::BasicBlockEdge", NM="_ZN4llvm14BasicBlockEdgeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Dominators.cpp -nm=_ZN4llvm14BasicBlockEdgeC1EOS0_")
  //</editor-fold>
  public /*inline*/ BasicBlockEdge(JD$Move _dparam, final BasicBlockEdge /*&&*/$Prm0) {
    // : Start(static_cast<BasicBlockEdge &&>().Start), End(static_cast<BasicBlockEdge &&>().End)
    //START JInit
    this.Start = $Prm0.Start;
    this.End = $Prm0.End;
    //END JInit
  }


  @Override public String toString() {
    return "" + "Start=" + Start // NOI18N
              + ", End=" + End; // NOI18N
  }
}
