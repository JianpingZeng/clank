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

package org.llvm.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;
import org.llvm.analysis.bfi_detail.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<RegionInfo * >">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 61,
 FQN="llvm::DOTGraphTraits<RegionInfo * >", NM="_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEEE")
//</editor-fold>
public class/*struct*/ DOTGraphTraitsRegionInfo$P extends /*public*/ DOTGraphTraitsRegionNode$P {
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<RegionInfo * >::DOTGraphTraits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 64,
   FQN="llvm::DOTGraphTraits<RegionInfo * >::DOTGraphTraits", NM="_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEEC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEEC1Eb")
  //</editor-fold>
  public DOTGraphTraitsRegionInfo$P() {
    this(false);
  }
  public DOTGraphTraitsRegionInfo$P(boolean isSimple/*= false*/) {
    // : DOTGraphTraits<RegionNode * >(isSimple) 
    super(isSimple);
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<RegionInfo * >::getGraphName">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 67,
   FQN="llvm::DOTGraphTraits<RegionInfo * >::getGraphName", NM="_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEE12getGraphNameEPKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEE12getGraphNameEPKS1_")
  //</editor-fold>
  public static std.string getGraphName(/*const*/ RegionInfo /*P*/ $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<RegionInfo * >::getNodeLabel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 69,
   FQN="llvm::DOTGraphTraits<RegionInfo * >::getNodeLabel", NM="_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEE12getNodeLabelEPNS_10RegionNodeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEE12getNodeLabelEPNS_10RegionNodeES2_")
  //</editor-fold>
  public std.string getNodeLabel(RegionNode /*P*/ Node, RegionInfo /*P*/ G) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<RegionInfo * >::getEdgeAttributes">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 74,
   FQN="llvm::DOTGraphTraits<RegionInfo * >::getEdgeAttributes", NM="_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEE17getEdgeAttributesEPNS_10RegionNodeENS_14RNSuccIteratorINS_6FlatItIS4_EENS_10BasicBlockENS_6RegionEEES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEE17getEdgeAttributesEPNS_10RegionNodeENS_14RNSuccIteratorINS_6FlatItIS4_EENS_10BasicBlockENS_6RegionEEES2_")
  //</editor-fold>
  public std.string getEdgeAttributes(RegionNode /*P*/ srcNode, 
                   RNSuccIteratorFlatIt$TT1T2<RegionNode, BasicBlock, Region> CI, 
                   RegionInfo /*P*/ G) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Print the cluster of the subregions. This groups the single basic blocks
  // and adds a different background color for each group.
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<RegionInfo * >::printRegionCluster">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 102,
   FQN="llvm::DOTGraphTraits<RegionInfo * >::printRegionCluster", NM="_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEE18printRegionClusterERKNS_6RegionERNS_11GraphWriterIS2_EEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEE18printRegionClusterERKNS_6RegionERNS_11GraphWriterIS2_EEj")
  //</editor-fold>
  public static void printRegionCluster(final /*const*/ Region /*&*/ R, final GraphWriter<RegionInfo /*P*/, RegionNode, RNSuccIteratorFlatIt$TT1T2<RegionNode, BasicBlock, Region> > /*&*/ GW) {
    printRegionCluster(R, GW, 
                    0);
  }
  public static void printRegionCluster(final /*const*/ Region /*&*/ R, final GraphWriter<RegionInfo /*P*/, RegionNode,RNSuccIteratorFlatIt$TT1T2<RegionNode, BasicBlock, Region>  > /*&*/ GW, 
                    /*uint*/int depth/*= 0*/) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<RegionInfo * >::addCustomGraphFeatures">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 134,
   FQN="llvm::DOTGraphTraits<RegionInfo * >::addCustomGraphFeatures", NM="_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEE22addCustomGraphFeaturesEPKS1_RNS_11GraphWriterIS2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEE22addCustomGraphFeaturesEPKS1_RNS_11GraphWriterIS2_EE")
  //</editor-fold>
  public static void addCustomGraphFeatures(/*const*/ RegionInfo /*P*/ G, 
                        final GraphWriter<RegionInfo /*P*/, RegionNode, RNSuccIteratorFlatIt$TT1T2<RegionNode, BasicBlock, Region>  > /*&*/ GW) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<RegionInfo * >::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 62,
   FQN="llvm::DOTGraphTraits<RegionInfo * >::operator=", NM="_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEEaSEOS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm14DOTGraphTraitsIPNS_10RegionInfoEEaSEOS3_")
  //</editor-fold>
  public /*inline*/ DOTGraphTraitsRegionInfo$P /*&*/ $assignMove(final DOTGraphTraitsRegionInfo$P /*&&*/$Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
