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

package org.clang.basic.target.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import static org.clang.basic.target.impl.TargetsStatics.*;


// Bitrig Target
/*template <typename Target> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitrigTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 559,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 513,
 FQN="(anonymous namespace)::BitrigTargetInfo", NM="_ZN12_GLOBAL__N_116BitrigTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116BitrigTargetInfoE")
//</editor-fold>
public class BitrigTargetInfo</*typename*/ Target extends TargetInfo>  extends /*public*/ OSTargetInfo<Target> {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitrigTargetInfo::getOSDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 562,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 516,
   FQN="(anonymous namespace)::BitrigTargetInfo::getOSDefines", NM="_ZNK12_GLOBAL__N_116BitrigTargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_116BitrigTargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE")
  //</editor-fold>
  protected void getOSDefines(/*const*/ LangOptions /*&*/ Opts, /*const*/ Triple /*&*/ Triple, 
              MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    // Bitrig defines; list based off of gcc output
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__Bitrig__"));
    DefineStd(Builder, new StringRef(/*KEEP_STR*/"unix"), Opts);
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ELF__"));
    if (Opts.POSIXThreads) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_REENTRANT"));
    }
    switch (Triple.getArch()) {
     default:
      break;
     case arm:
     case armeb:
     case thumb:
     case thumbeb:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_DWARF_EH__"));
      break;
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BitrigTargetInfo::BitrigTargetInfo<Target>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 584,
   FQN="(anonymous namespace)::BitrigTargetInfo::BitrigTargetInfo<Target>", NM="_ZN12_GLOBAL__N_116BitrigTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_116BitrigTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public BitrigTargetInfo(Target T, /*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : OSTargetInfo<Target>(Triple, Opts)*/ 
    //START JInit
    /*ParenListExpr*/super(T, Triple, Opts);
    //END JInit
    super.tgt.MCountName = $("__mcount");
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
