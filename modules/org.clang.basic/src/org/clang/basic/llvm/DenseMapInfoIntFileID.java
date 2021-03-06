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

package org.clang.basic.llvm;

import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.FileID;

/// Define DenseMapInfo so that FileID's can be used as int-keys in DenseMapInt* and
/// DenseSetInt.
//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 400,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 399,
 FQN = "llvm::DenseMapInfo<clang::FileID>", NM = "_ZN4llvm12DenseMapInfoIN5clang6FileIDEEE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang6FileIDEEE")
//</editor-fold>
/*friend*/public class/*struct*/ DenseMapInfoIntFileID extends DenseMapInfoInt/*<FileID>*/ {

  public DenseMapInfoIntFileID() {
    super(FileID.getInvalidID(), FileID.getSentinelID());
  }

//  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang.FileID>::getEmptyKey">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 402,
//   FQN="llvm::DenseMapInfo<clang::FileID>::getEmptyKey", NM="_ZN4llvm12DenseMapInfoIN5clang6FileIDEE11getEmptyKeyEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang6FileIDEE11getEmptyKeyEv")
//  //</editor-fold>
//  @Override public /*inline*/ int getEmptyKey() {
//    return FileID.getInvalidID();
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang.FileID>::getTombstoneKey">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 405,
//   FQN="llvm::DenseMapInfo<clang::FileID>::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoIN5clang6FileIDEE15getTombstoneKeyEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang6FileIDEE15getTombstoneKeyEv")
//  //</editor-fold>
//  @Override public /*inline*/ int getTombstoneKey() {
//    return FileID.getSentinelID();
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang.FileID>::getHashValue">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 409,
//   FQN="llvm::DenseMapInfo<clang::FileID>::getHashValue", NM="_ZN4llvm12DenseMapInfoIN5clang6FileIDEE12getHashValueES2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang6FileIDEE12getHashValueES2_")
//  //</editor-fold>
//  @Override public /*uint*/int getHashValueAlt(Object S) {
//    throw new UnsupportedOperationException();
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang.FileID>::isEqual">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 413,
//   FQN="llvm::DenseMapInfo<clang::FileID>::isEqual", NM="_ZN4llvm12DenseMapInfoIN5clang6FileIDEE7isEqualES2_S2_",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang6FileIDEE7isEqualES2_S2_")
//  //</editor-fold>
//  @Override public boolean isEqualAlt(Object LHS, Object RHS) {
//    throw new UnsupportedOperationException();
//  }
//
//  @Override
//  public int getHashValue(/*FileID*/int Val) {
//    return Val;
//  }
//
//  @Override
//  public boolean isEqual(/*FileID*/int LHS, /*FileID*/int RHS) {
//    return LHS == RHS;
//  }
//
//  @Override
//  public boolean isKeyPointerLike() {
//    // never copy integrals
//    return true;
//  }
}
