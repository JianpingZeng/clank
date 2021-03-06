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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::StoreRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/StoreRef.h", line = 30,
 FQN="clang::ento::StoreRef", NM="_ZN5clang4ento8StoreRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento8StoreRefE")
//</editor-fold>
public class StoreRef implements Destructors.ClassWithDestructor, Native.NativeComparable<StoreRef> {
  private /*const*/Object/*void P*/ store;
  private final StoreManager /*&*/ mgr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreRef::StoreRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 250,
   FQN="clang::ento::StoreRef::StoreRef", NM="_ZN5clang4ento8StoreRefC1EPKvRNS0_12StoreManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento8StoreRefC1EPKvRNS0_12StoreManagerE")
  //</editor-fold>
  public /*inline*/ StoreRef(/*const*/Object/*void P*/ store, final StoreManager /*&*/ smgr) {
    // : store(store), mgr(smgr) 
    //START JInit
    this.store = store;
    this./*&*/mgr=/*&*/smgr;
    //END JInit
    if ((store != null)) {
      mgr.incrementReferenceCount(store);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreRef::StoreRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 256,
   FQN="clang::ento::StoreRef::StoreRef", NM="_ZN5clang4ento8StoreRefC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento8StoreRefC1ERKS1_")
  //</editor-fold>
  public /*inline*/ StoreRef(final /*const*/ StoreRef /*&*/ sr) {
    // : store(sr.store), mgr(sr.mgr) 
    //START JInit
    this.store = sr.store;
    this./*&*/mgr=/*&*/sr.mgr;
    //END JInit
    if ((store != null)) {
      mgr.incrementReferenceCount(store);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreRef::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 268,
   FQN="clang::ento::StoreRef::operator=", NM="_ZN5clang4ento8StoreRefaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento8StoreRefaSERKS1_")
  //</editor-fold>
  public /*inline*/ StoreRef /*&*/ $assign(final /*const*/ StoreRef /*&*/ newStore) {
    assert ($AddrOf(newStore.mgr) == $AddrOf(mgr));
    if ($noteq_ptr(store, newStore.store)) {
      mgr.incrementReferenceCount(newStore.store);
      mgr.decrementReferenceCount(store);
      store = newStore.getStore();
    }
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreRef::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/StoreRef.h", line = 38,
   FQN="clang::ento::StoreRef::operator==", NM="_ZNK5clang4ento8StoreRefeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZNK5clang4ento8StoreRefeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ StoreRef /*&*/ x) /*const*/ {
    assert ($AddrOf(mgr) == $AddrOf(x.mgr));
    return $eq_ptr(x.store, store);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreRef::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/StoreRef.h", line = 42,
   FQN="clang::ento::StoreRef::operator!=", NM="_ZNK5clang4ento8StoreRefneERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZNK5clang4ento8StoreRefneERKS1_")
  //</editor-fold>
  public boolean $noteq(final /*const*/ StoreRef /*&*/ x) /*const*/ {
    return !$eq(x);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreRef::~StoreRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/Store.h", line = 263,
   FQN="clang::ento::StoreRef::~StoreRef", NM="_ZN5clang4ento8StoreRefD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZN5clang4ento8StoreRefD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    if ((store != null)) {
      mgr.decrementReferenceCount(store);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreRef::getStore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/StoreRef.h", line = 46,
   FQN="clang::ento::StoreRef::getStore", NM="_ZNK5clang4ento8StoreRef8getStoreEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZNK5clang4ento8StoreRef8getStoreEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getStore() /*const*/ {
    return store;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::StoreRef::getStoreManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/StoreRef.h", line = 47,
   FQN="clang::ento::StoreRef::getStoreManager", NM="_ZNK5clang4ento8StoreRef15getStoreManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Store.cpp -nm=_ZNK5clang4ento8StoreRef15getStoreManagerEv")
  //</editor-fold>
  public /*const*/ StoreManager /*&*/ getStoreManager() /*const*/ {
    return mgr;
  }

  
  @Override public String toString() {
    return "" + "store=" + store // NOI18N
              + ", mgr=" + "[StoreManager]"; // NOI18N
  }
}
