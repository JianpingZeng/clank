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

package org.clang.ast;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;


/// \brief This represents '#pragma omp distribute parallel for' composite
///  directive.
///
/// \code
/// #pragma omp distribute parallel for private(a,b)
/// \endcode
/// In this example directive '#pragma omp distribute parallel for' has clause
/// 'private' with the variables 'a' and 'b'
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPDistributeParallelForDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2827,
 FQN="clang::OMPDistributeParallelForDirective", NM="_ZN5clang33OMPDistributeParallelForDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang33OMPDistributeParallelForDirectiveE")
//</editor-fold>
public class OMPDistributeParallelForDirective extends /*public*/ OMPLoopDirective {
  /*friend  class ASTStmtReader*/
  
  /// \brief Build directive with the given start and end location.
  ///
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending location of the directive.
  /// \param CollapsedNum Number of collapsed nested loops.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistributeParallelForDirective::OMPDistributeParallelForDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2837,
   FQN="clang::OMPDistributeParallelForDirective::OMPDistributeParallelForDirective", NM="_ZN5clang33OMPDistributeParallelForDirectiveC1ENS_14SourceLocationES1_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang33OMPDistributeParallelForDirectiveC1ENS_14SourceLocationES1_jj")
  //</editor-fold>
  private OMPDistributeParallelForDirective(SourceLocation StartLoc, 
      SourceLocation EndLoc, 
      /*uint*/int CollapsedNum, /*uint*/int NumClauses) {
    // : OMPLoopDirective(this, OMPDistributeParallelForDirectiveClass, OMPD_distribute_parallel_for, StartLoc, EndLoc, CollapsedNum, NumClauses) 
    //START JInit
    $OMPLoopDirective(this, StmtClass.OMPDistributeParallelForDirectiveClass, 
        OpenMPDirectiveKind.OMPD_distribute_parallel_for, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
        CollapsedNum, NumClauses);
    //END JInit
  }

  
  /// \brief Build an empty directive.
  ///
  /// \param CollapsedNum Number of collapsed nested loops.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistributeParallelForDirective::OMPDistributeParallelForDirective">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2849,
   FQN="clang::OMPDistributeParallelForDirective::OMPDistributeParallelForDirective", NM="_ZN5clang33OMPDistributeParallelForDirectiveC1Ejj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang33OMPDistributeParallelForDirectiveC1Ejj")
  //</editor-fold>
  private /*explicit*/ OMPDistributeParallelForDirective(/*uint*/int CollapsedNum, 
      /*uint*/int NumClauses) {
    // : OMPLoopDirective(this, OMPDistributeParallelForDirectiveClass, OMPD_distribute_parallel_for, SourceLocation(), SourceLocation(), CollapsedNum, NumClauses) 
    //START JInit
    $OMPLoopDirective(this, StmtClass.OMPDistributeParallelForDirectiveClass, 
        OpenMPDirectiveKind.OMPD_distribute_parallel_for, new SourceLocation(), 
        new SourceLocation(), CollapsedNum, NumClauses);
    //END JInit
  }

/*public:*/
  /// \brief Creates directive with a list of \a Clauses.
  ///
  /// \param C AST context.
  /// \param StartLoc Starting location of the directive kind.
  /// \param EndLoc Ending Location of the directive.
  /// \param CollapsedNum Number of collapsed loops.
  /// \param Clauses List of clauses.
  /// \param AssociatedStmt Statement, associated with the directive.
  /// \param Exprs Helper expressions for CodeGen.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistributeParallelForDirective::Create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 1054,
   FQN="clang::OMPDistributeParallelForDirective::Create", NM="_ZN5clang33OMPDistributeParallelForDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_jN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtERKNS_16OMPLoopDirective11HelperExprsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang33OMPDistributeParallelForDirective6CreateERKNS_10ASTContextENS_14SourceLocationES4_jN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtERKNS_16OMPLoopDirective11HelperExprsE")
  //</editor-fold>
  public static OMPDistributeParallelForDirective /*P*/ Create(final /*const*/ ASTContext /*&*/ C, SourceLocation StartLoc, SourceLocation EndLoc, 
        /*uint*/int CollapsedNum, ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AssociatedStmt, 
        final /*const*/ HelperExprs /*&*/ Exprs) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPDistributeParallelForDirective()), 
        $uint2ulong(alignOf(OMPClause.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*OMPClause  */) * Clauses.size()
           + $sizeof_ptr(/*Stmt  */)
           * numLoopChildren(CollapsedNum, OpenMPDirectiveKind.OMPD_distribute_parallel_for));
    OMPDistributeParallelForDirective /*P*/ Dir = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPDistributeParallelForDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
                CollapsedNum, Clauses.size());
     });
    Dir.setClauses(new ArrayRef<OMPClause /*P*/ >(Clauses));
    Dir.setAssociatedStmt(AssociatedStmt);
    Dir.setIterationVariable(Exprs.IterationVarRef);
    Dir.setLastIteration(Exprs.LastIteration);
    Dir.setCalcLastIteration(Exprs.CalcLastIteration);
    Dir.setPreCond(Exprs.PreCond);
    Dir.setCond(Exprs.Cond);
    Dir.setInit(Exprs.Init);
    Dir.setInc(Exprs.Inc);
    Dir.setIsLastIterVariable(Exprs.IL);
    Dir.setLowerBoundVariable(Exprs.LB);
    Dir.setUpperBoundVariable(Exprs.UB);
    Dir.setStrideVariable(Exprs.ST);
    Dir.setEnsureUpperBound(Exprs.EUB);
    Dir.setNextLowerBound(Exprs.NLB);
    Dir.setNextUpperBound(Exprs.NUB);
    Dir.setNumIterations(Exprs.NumIterations);
    Dir.setPrevLowerBoundVariable(Exprs.PrevLB);
    Dir.setPrevUpperBoundVariable(Exprs.PrevUB);
    Dir.setCounters(new ArrayRef<Expr /*P*/ >(Exprs.Counters, true));
    Dir.setPrivateCounters(new ArrayRef<Expr /*P*/ >(Exprs.PrivateCounters, true));
    Dir.setInits(new ArrayRef<Expr /*P*/ >(Exprs.Inits, true));
    Dir.setUpdates(new ArrayRef<Expr /*P*/ >(Exprs.Updates, true));
    Dir.setFinals(new ArrayRef<Expr /*P*/ >(Exprs.Finals, true));
    Dir.setPreInits(Exprs.PreInits);
    return Dir;
  }

  
  /// \brief Creates an empty directive with the place
  /// for \a NumClauses clauses.
  ///
  /// \param C AST context.
  /// \param CollapsedNum Number of collapsed nested loops.
  /// \param NumClauses Number of clauses.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistributeParallelForDirective::CreateEmpty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 1095,
   FQN="clang::OMPDistributeParallelForDirective::CreateEmpty", NM="_ZN5clang33OMPDistributeParallelForDirective11CreateEmptyERKNS_10ASTContextEjjNS_4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang33OMPDistributeParallelForDirective11CreateEmptyERKNS_10ASTContextEjjNS_4Stmt10EmptyShellE")
  //</editor-fold>
  public static OMPDistributeParallelForDirective /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumClauses, 
             /*uint*/int CollapsedNum, 
             EmptyShell $Prm3) {
    /*uint*/int Size = $ulong2uint(llvm.alignTo($uint2ulong($sizeof_OMPDistributeParallelForDirective()), 
        $uint2ulong(alignOf(OMPClause.class))));
    Object/*void P*/ Mem = C.Allocate(Size + $sizeof_ptr(/*OMPClause  */) * NumClauses
           + $sizeof_ptr(/*Stmt  */)
           * numLoopChildren(CollapsedNum, OpenMPDirectiveKind.OMPD_distribute_parallel_for));
    return /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new OMPDistributeParallelForDirective(CollapsedNum, NumClauses);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistributeParallelForDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 2883,
   FQN="clang::OMPDistributeParallelForDirective::classof", NM="_ZN5clang33OMPDistributeParallelForDirective7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang33OMPDistributeParallelForDirective7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OMPDistributeParallelForDirectiveClass;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
