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
package org.clang.codegen.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/CodeGenCXX folder
 * @author Vladimir Voskresensky
 */
@Ignore
public class AllClangCodeGenCXXTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/";
  public AllClangCodeGenCXXTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.codegen/test/unit/src/org/clang/codegen/test/AllClangCodeGenCXXTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_2003_11_02_WeakLinkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-11-02-WeakLinkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-11-02-WeakLinkage.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-11-02-WeakLinkage.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2003_11_18_PtrMemConstantInitializer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-11-18-PtrMemConstantInitializer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-11-18-PtrMemConstantInitializer.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2003_11_27_MultipleInheritanceThunk_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-11-27-MultipleInheritanceThunk.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-11-27-MultipleInheritanceThunk.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-11-27-MultipleInheritanceThunk.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -triple %ms_abi_triple -fno-rtti -emit-llvm %s -o -");
  }

  @Test
  public void test_2003_11_29_DuplicatedCleanupTest_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-11-29-DuplicatedCleanupTest.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-11-29-DuplicatedCleanupTest.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2003_12_08_ArrayOfPtrToMemberFunc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-12-08-ArrayOfPtrToMemberFunc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2003-12-08-ArrayOfPtrToMemberFunc.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2004_01_11_DynamicInitializedConstant_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-01-11-DynamicInitializedConstant.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-01-11-DynamicInitializedConstant.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-01-11-DynamicInitializedConstant.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2004_03_08_ReinterpretCastCopy_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-03-08-ReinterpretCastCopy.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-03-08-ReinterpretCastCopy.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o -");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-03-08-ReinterpretCastCopy.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -triple %ms_abi_triple -fno-rtti -emit-llvm %s -o -");
  }

  @Test
  public void test_2004_03_09_UnmangledBuiltinMethods_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-03-09-UnmangledBuiltinMethods.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-03-09-UnmangledBuiltinMethods.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-03-09-UnmangledBuiltinMethods.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2004_03_15_CleanupsAndGotos_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-03-15-CleanupsAndGotos.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-03-15-CleanupsAndGotos.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2004_06_08_LateTemplateInstantiation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-06-08-LateTemplateInstantiation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-06-08-LateTemplateInstantiation.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2004_09_27_DidntEmitTemplate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-09-27-DidntEmitTemplate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-09-27-DidntEmitTemplate.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-09-27-DidntEmitTemplate.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2004_11_27_ExceptionCleanupAssertion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-11-27-ExceptionCleanupAssertion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-11-27-ExceptionCleanupAssertion.cpp -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2004_11_27_FriendDefaultArgCrash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-11-27-FriendDefaultArgCrash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2004-11-27-FriendDefaultArgCrash.cpp -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2005_01_03_StaticInitializers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-01-03-StaticInitializers.cpp");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-01-03-StaticInitializers.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-01-03-StaticInitializers.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2005_02_11_AnonymousUnion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-02-11-AnonymousUnion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-02-11-AnonymousUnion.cpp -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2005_02_13_BadDynamicInit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-02-13-BadDynamicInit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-02-13-BadDynamicInit.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-02-13-BadDynamicInit.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2005_02_19_BitfieldStructCrash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-02-19-BitfieldStructCrash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-02-19-BitfieldStructCrash.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2005_02_19_UnnamedVirtualThunkArgument_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-02-19-UnnamedVirtualThunkArgument.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-02-19-UnnamedVirtualThunkArgument.cpp -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2005_02_20_BrokenReferenceTest_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-02-20-BrokenReferenceTest.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2005-02-20-BrokenReferenceTest.cpp -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2006_03_01_GimplifyCrash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-03-01-GimplifyCrash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-03-01-GimplifyCrash.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2006_03_06_CxxRecurseCrash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-03-06-C++RecurseCrash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-03-06-C++RecurseCrash.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2006_09_12_OpaqueStructCrash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-09-12-OpaqueStructCrash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-09-12-OpaqueStructCrash.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -fno-rtti -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-09-12-OpaqueStructCrash.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %ms_abi_triple -fno-rtti -emit-llvm -o - %s");
  }

  @Test
  public void test_2006_10_30_ClassBitfield_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-10-30-ClassBitfield.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-10-30-ClassBitfield.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2006_11_20_GlobalSymbols_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-11-20-GlobalSymbols.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-11-20-GlobalSymbols.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-11-20-GlobalSymbols.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2006_11_30_ConstantExprCrash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-11-30-ConstantExprCrash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2006-11-30-ConstantExprCrash.cpp -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_2007_01_02_UnboundedArray_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-01-02-UnboundedArray.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-01-02-UnboundedArray.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -");
  }

  @Test
  public void test_2007_01_06_PtrMethodInit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-01-06-PtrMethodInit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-01-06-PtrMethodInit.cpp -o - -triple i386-apple-macosx10.7.2
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple i386-apple-macosx10.7.2");
  }

  @Test
  public void test_2007_04_05_PackedBitFields_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-05-PackedBitFields-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-05-PackedBitFields-1.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2007_04_05_PackedBitFieldsOverlap_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-05-PackedBitFieldsOverlap.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-05-PackedBitFieldsOverlap.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2007_04_05_PackedBitFieldsOverlap_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-05-PackedBitFieldsOverlap-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-05-PackedBitFieldsOverlap-2.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2007_04_05_PackedBitFieldsSmall_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-05-PackedBitFieldsSmall.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-05-PackedBitFieldsSmall.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2007_04_05_StructPackedFieldUnpacked_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-05-StructPackedFieldUnpacked.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-05-StructPackedFieldUnpacked.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2007_04_10_PackedUnion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-10-PackedUnion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-10-PackedUnion.cpp -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2007_04_14_FNoBuiltin_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-14-FNoBuiltin.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-14-FNoBuiltin.cpp -fno-builtin -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-04-14-FNoBuiltin.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -fno-builtin -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_05_03_VectorInit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-05-03-VectorInit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-05-03-VectorInit.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2007_07_29_RestrictPtrArg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-07-29-RestrictPtrArg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-07-29-RestrictPtrArg.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-07-29-RestrictPtrArg.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_07_29_RestrictRefArg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-07-29-RestrictRefArg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-07-29-RestrictRefArg.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-07-29-RestrictRefArg.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2007_09_10_RecursiveTypeResolution_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-09-10-RecursiveTypeResolution.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-09-10-RecursiveTypeResolution.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2007_10_01_StructResize_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-10-01-StructResize.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2007-10-01-StructResize.cpp -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2008_01_12_VecInit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2008-01-12-VecInit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2008-01-12-VecInit.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2008_05_07_CrazyOffsetOf_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2008-05-07-CrazyOffsetOf.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2008-05-07-CrazyOffsetOf.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2009_03_17_dbg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-03-17-dbg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-03-17-dbg.cpp -o /dev/null -debug-info-kind=limited
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null -debug-info-kind=limited");
  }

  @Test
  public void test_2009_04_23_bool2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-04-23-bool2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-04-23-bool2.cpp -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2009_05_04_PureConstNounwind_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-05-04-PureConstNounwind.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -fexceptions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-05-04-PureConstNounwind.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-05-04-PureConstNounwind.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -fexceptions -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2009_06_16_DebugInfoCrash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-06-16-DebugInfoCrash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-06-16-DebugInfoCrash.cpp -o /dev/null -debug-info-kind=limited
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null -debug-info-kind=limited");
  }

  @Test
  public void test_2009_07_16_Using_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-07-16-Using.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-07-16-Using.cpp -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2009_08_05_ZeroInitWidth_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-08-05-ZeroInitWidth.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-08-05-ZeroInitWidth.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2009_08_11_VectorRetTy_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-08-11-VectorRetTy.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-08-11-VectorRetTy.cpp -emit-llvm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o /dev/null");
  }

  @Test
  public void test_2009_09_09_packed_layout_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-09-09-packed-layout.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-apple-darwin11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-09-09-packed-layout.cpp -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i386-apple-darwin11 %s -o /dev/null");
  }

  @Test
  public void test_2009_10_27_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-10-27-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-10-27-crash.cpp -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2009_12_23_MissingSext_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-12-23-MissingSext.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-12-23-MissingSext.cpp -triple x86_64-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2009-12-23-MissingSext.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-unknown-unknown -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_03_09_AnonAggregate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-03-09-AnonAggregate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -S -o ${TEST_TEMP_DIR}/2010-03-09-AnonAggregate.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-03-09-AnonAggregate.cpp
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -S -o %t %s");
  }

  @Test
  public void test_2010_05_10_Var_DbgInfo_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-05-10-Var-DbgInfo.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-05-10-Var-DbgInfo.cpp -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o /dev/null");
  }

  @Test
  public void test_2010_05_11_alwaysinlineinstantiation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-05-11-alwaysinlineinstantiation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-05-11-alwaysinlineinstantiation.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-05-11-alwaysinlineinstantiation.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_05_12_PtrToMember_Dbg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-05-12-PtrToMember-Dbg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-05-12-PtrToMember-Dbg.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-05-12-PtrToMember-Dbg.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_06_21_LocalVarDbg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-06-21-LocalVarDbg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-06-21-LocalVarDbg.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-06-21-LocalVarDbg.cpp
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2010_06_22_BitfieldInit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-06-22-BitfieldInit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-06-22-BitfieldInit.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -");
  }

  @Test
  public void test_2010_06_22_ZeroBitfield_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-06-22-ZeroBitfield.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-06-22-ZeroBitfield.cpp -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -");
  }

  @Test
  public void test_2010_07_23_DeclLoc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-07-23-DeclLoc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-07-23-DeclLoc.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2010-07-23-DeclLoc.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2011_12_19_init_list_ctor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2011-12-19-init-list-ctor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2011-12-19-init-list-ctor.cpp -emit-llvm -o - -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2011-12-19-init-list-ctor.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2012_02_06_VecInitialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2012-02-06-VecInitialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple i386-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2012-02-06-VecInitialization.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2012-02-06-VecInitialization.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple i386-apple-darwin %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_2012_03_16_StoreAlign_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2012-03-16-StoreAlign.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2012-03-16-StoreAlign.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/2012-03-16-StoreAlign.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple x86_64-apple-darwin %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_DynArrayInit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/DynArrayInit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -O3 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/DynArrayInit.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/DynArrayInit.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -O3 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_PR19955_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR19955.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-extensions -fno-rtti -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR19955.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR19955.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc -fms-extensions -fno-rtti -emit-llvm -std=c++1y -O0 -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -fms-extensions -fno-rtti -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR19955.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR19955.cpp --check-prefix X64
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -fms-extensions -fno-rtti -emit-llvm -std=c++1y -O0 -o - %s")./*|*/
      I("FileCheck %s --check-prefix X64");
  }

  @Test
  public void test_PR20038_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR20038.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -debug-info-kind=limited -mllvm -no-discriminators -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR20038.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR20038.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -debug-info-kind=limited -mllvm -no-discriminators -emit-llvm  %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_PR24289_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR24289.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR24289.cpp -o - -triple=x86_64-pc-linux-gnu -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR24289.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-pc-linux-gnu -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_PR26569_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR26569.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -fms-extensions -emit-llvm -O1 -disable-llvm-optzns ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR26569.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR26569.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-win32 -fms-extensions -emit-llvm -O1 -disable-llvm-optzns %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_PR28220_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR28220.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR28220.cpp -triple i686-pc-win32 -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR28220.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-win32 -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_PR4827_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR4827-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR4827-cast.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s");
  }

  @Test
  public void test_PR4983_constructor_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR4983-constructor-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR4983-constructor-conversion.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_PR5050_constructor_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5050-constructor-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5050-constructor-conversion.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5050-constructor-conversion.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5050-constructor-conversion.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5050-constructor-conversion.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_PR5093_static_member_function_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5093-static-member-function.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5093-static-member-function.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5093-static-member-function.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_PR5834_constructor_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5834-constructor-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5834-constructor-conversion.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s");
  }

  @Test
  public void test_PR5863_unreachable_block_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5863-unreachable-block.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR5863-unreachable-block.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -fcxx-exceptions -fexceptions -emit-llvm-only %s");
  }

  @Test
  public void test_PR6474_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR6474.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/PR6474.cpp -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only");
  }

  @Test
  public void test___null_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/__null.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/__null.cpp -emit-llvm -o ${TEST_TEMP_DIR}/__null.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_aarch64_aapcs_zerolength_bitfield_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-aapcs-zerolength-bitfield.cpp");
    // REQUIRES: aarch64-registered-target
    if (!CHECK_REQUIRES("aarch64-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple aarch64-linux-gnu -x c++ -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-aapcs-zerolength-bitfield.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -triple aarch64-linux-gnu -x c++ -std=c++1z %s -verify");
  }

  @Test
  public void test_aarch64_arguments_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-arguments.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-arguments.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=PCS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-arguments.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux -emit-llvm -w -o - %s")./*|*/
      I("FileCheck -check-prefix=PCS %s");
  }

  @Test
  public void test_aarch64_cxxabi_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-cxxabi.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -emit-llvm -w -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-cxxabi.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-cxxabi.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -emit-llvm -w -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_mangle_neon_vectors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-mangle-neon-vectors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-mangle-neon-vectors.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-mangle-neon-vectors.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_aarch64_neon_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-neon.cpp");
    // REQUIRES: aarch64-registered-target
    if (!CHECK_REQUIRES("aarch64-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-linux-gnu -target-feature +neon -ffp-contract=fast -S -O3 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-neon.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-neon.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-linux-gnu -target-feature +neon -ffp-contract=fast -S -O3 -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-none-netbsd-gnu -target-feature +neon -ffp-contract=fast -S -O3 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-neon.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/aarch64-neon.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-none-netbsd-gnu -target-feature +neon -ffp-contract=fast -S -O3 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_abstract_class_ctors_dtors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/abstract-class-ctors-dtors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/abstract-class-ctors-dtors.cpp -triple x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/abstract-class-ctors-dtors.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_address_of_fntemplate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/address-of-fntemplate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/address-of-fntemplate.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/address-of-fntemplate.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_address_space_ref_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/address-space-ref.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/address-space-ref.cpp -std=c++11 -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/address-space-ref.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_align_avx_complete_objects_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/align-avx-complete-objects.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/align-avx-complete-objects.cpp -O0 -triple=x86_64-apple-darwin -target-feature +avx2 -fmax-type-align=16 -emit-llvm -o - -Werror | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/align-avx-complete-objects.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ %s -O0 -triple=x86_64-apple-darwin -target-feature +avx2 -fmax-type-align=16 -emit-llvm -o - -Werror")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_alignment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/alignment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/alignment.cpp -emit-llvm -o - -triple=x86_64-apple-darwin10 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/alignment.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=x86_64-apple-darwin10")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_alloca_align_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/alloca-align.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/alloca-align.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/alloca-align.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_anonymous_namespaces_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/anonymous-namespaces.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin10 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/anonymous-namespaces.cpp -o - > ${TEST_TEMP_DIR}/anonymous-namespaces.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin10 -emit-llvm %s -o - > %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/anonymous-namespaces.cpp -check-prefix=CHECK-1 < ${TEST_TEMP_DIR}/anonymous-namespaces.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s -check-prefix=CHECK-1 < %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/anonymous-namespaces.cpp -check-prefix=CHECK-2 < ${TEST_TEMP_DIR}/anonymous-namespaces.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s -check-prefix=CHECK-2 < %t");
  }

  @Test
  public void test_anonymous_union_member_initializer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/anonymous-union-member-initializer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/anonymous-union-member-initializer.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/anonymous-union-member-initializer.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_apple_kext_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fno-use-cxa-atexit -fapple-kext -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fno-use-cxa-atexit -fapple-kext -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_apple_kext_guard_variable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-guard-variable.cpp");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-apple-darwin10 -S -o ${TEST_TEMP_DIR}/apple-kext-guard-variable.cpp.tmp.s -mkernel -Xclang -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-guard-variable.cpp
    RUN(TestState.Failed, "%clang -target x86_64-apple-darwin10 -S -o %t.s -mkernel -Xclang -verify %s");
  }

  @Test
  public void test_apple_kext_indirect_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-indirect-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fapple-kext -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-indirect-call.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-indirect-call.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fapple-kext -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_apple_kext_indirect_call_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-indirect-call-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fapple-kext -fno-rtti -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-indirect-call-2.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-indirect-call-2.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fapple-kext -fno-rtti -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_apple_kext_indirect_virtual_dtor_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-indirect-virtual-dtor-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fapple-kext -fno-rtti -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-indirect-virtual-dtor-call.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-indirect-virtual-dtor-call.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fapple-kext -fno-rtti -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_apple_kext_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fapple-kext -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-linkage.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-linkage.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fapple-kext -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_apple_kext_no_staticinit_section_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-no-staticinit-section.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fapple-kext -fno-rtti -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-no-staticinit-section.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/apple-kext-no-staticinit-section.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fapple-kext -fno-rtti -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm.cpp -triple=thumbv7-apple-ios6.0 -fno-use-cxa-atexit -target-abi apcs-gnu -emit-llvm -o - -fexceptions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=thumbv7-apple-ios6.0 -fno-use-cxa-atexit -target-abi apcs-gnu -emit-llvm -o - -fexceptions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_cc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm-cc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm-cc.cpp -triple=arm-unknown-linux-gnueabi -target-abi aapcs -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm-cc.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=arm-unknown-linux-gnueabi -target-abi aapcs -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_swiftcall_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm-swiftcall.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-darwin9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm-swiftcall.cpp -Wno-return-type-c-linkage | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm-swiftcall.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-darwin9 -emit-llvm -o - %s -Wno-return-type-c-linkage")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm_vaarg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm-vaarg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-ios -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm-vaarg.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm-vaarg.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-ios -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64.cpp -triple=arm64-apple-ios -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=arm64-apple-ios -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64.cpp -triple=arm64-apple-ios -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GLOBALS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=arm64-apple-ios -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-GLOBALS %s");
  }

  @Test
  public void test_arm64_constructor_return_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64-constructor-return.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64-constructor-return.cpp -triple=arm64-apple-ios7.0.0 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64-constructor-return.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=arm64-apple-ios7.0.0 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arm64_darwinpcs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64-darwinpcs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64-darwinpcs.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64-darwinpcs.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64-darwinpcs.cpp -target-abi darwinpcs | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64-darwinpcs.cpp --check-prefix=CHECK-DARWIN
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-linux-gnu -emit-llvm -o - %s -target-abi darwinpcs")./*|*/
      I("FileCheck %s --check-prefix=CHECK-DARWIN");
  }

  @Test
  public void test_arm64_empty_struct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64-empty-struct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios -target-abi darwinpcs -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64-empty-struct.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/arm64-empty-struct.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios -target-abi darwinpcs -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_armv7k_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/armv7k.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/armv7k.cpp -triple=thumbv7k-apple-watchos -emit-llvm -o - -target-abi aapcs16 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/armv7k.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=thumbv7k-apple-watchos -emit-llvm -o - -target-abi aapcs16")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/armv7k.cpp -triple=thumbv7k-apple-watchos -emit-llvm -o - -target-abi aapcs16 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GLOBALS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/armv7k.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=thumbv7k-apple-watchos -emit-llvm -o - -target-abi aapcs16")./*|*/
      I("FileCheck -check-prefix=CHECK-GLOBALS %s");
  }

  @Test
  public void test_array_construction_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-construction.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-construction.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-construction.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-construction.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-construction.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_array_operator_delete_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-operator-delete-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-operator-delete-call.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-operator-delete-call.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-operator-delete-call.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-operator-delete-call.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_array_pointer_decay_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-pointer-decay.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-pointer-decay.cpp -emit-llvm -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -");
  }

  @Test
  public void test_array_value_initialize_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-value-initialize.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-value-initialize.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/array-value-initialize.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -emit-llvm -o - %s");
  }

  @Test
  public void test_asm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/asm.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/asm.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/asm.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_assign_construct_memcpy_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/assign-construct-memcpy.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin12 -emit-llvm -o - -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/assign-construct-memcpy.cpp -DPOD | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/assign-construct-memcpy.cpp -check-prefix=CHECK-POD
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin12 -emit-llvm -o - -std=c++11 %s -DPOD")./*|*/
      I("FileCheck %s -check-prefix=CHECK-POD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin12 -emit-llvm -o - -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/assign-construct-memcpy.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/assign-construct-memcpy.cpp -check-prefix=CHECK-NONPOD
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin12 -emit-llvm -o - -std=c++11 %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-NONPOD");
  }

  @Test
  public void test_assign_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/assign-operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/assign-operator.cpp -triple x86_64-apple-darwin10 -emit-llvm -o - -std=c++11 |FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/assign-operator.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -emit-llvm -o - -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_atomic_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/atomic.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/atomic.cpp -emit-llvm -o - -triple=i686-apple-darwin9 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/atomic.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=i686-apple-darwin9")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_atomicinit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/atomicinit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/atomicinit.cpp -emit-llvm -O1 -o - -triple=i686-apple-darwin9 -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/atomicinit.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -O1 -o - -triple=i686-apple-darwin9 -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_cleanup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-cleanup.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-cleanup.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-cleanup.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_disable_tail_calls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-disable-tail-calls.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-disable-tail-calls.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-disable-tail-calls.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin -std=c++11 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_mode_vector_types_tmpl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-mode-vector-types-tmpl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-mode-vector-types-tmpl.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-mode-vector-types-tmpl.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_notail_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-notail.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-notail.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-notail.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin -std=c++11 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_used_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-used.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-used.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-used.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_x86_interrupt_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-x86-interrupt.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-x86-interrupt.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-x86-interrupt.cpp --check-prefix=X86_64_LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X86_64_LINUX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-x86-interrupt.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-x86-interrupt.cpp --check-prefix=X86_LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-linux-gnu %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X86_LINUX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-x86-interrupt.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-x86-interrupt.cpp --check-prefix=X86_64_WIN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-win32 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X86_64_WIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-x86-interrupt.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-x86-interrupt.cpp --check-prefix=X86_WIN
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-win32 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X86_WIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnux32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-x86-interrupt.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attr-x86-interrupt.cpp --check-prefix=X86_64_LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnux32 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=X86_64_LINUX");
  }

  @Test
  public void test_attribute_internal_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attribute_internal_linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attribute_internal_linkage.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/attribute_internal_linkage.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -std=c++11 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_auto_variable_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/auto-variable-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/auto-variable-template.cpp -triple=x86_64-linux -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/auto-variable-template.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++14 %s -triple=x86_64-linux -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_bitfield_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bitfield.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bitfield.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-X86-64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bitfield.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-X86-64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bitfield.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PPC64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bitfield.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-PPC64 %s");
  }

  @Test
  public void test_bitfield_layout_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bitfield-layout.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bitfield-layout.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - -O3 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bitfield-layout.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o - -O3")./*|*/
      I("FileCheck -check-prefix CHECK-LP64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bitfield-layout.cpp -triple=i386-apple-darwin10 -emit-llvm -o - -O3 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bitfield-layout.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i386-apple-darwin10 -emit-llvm -o - -O3")./*|*/
      I("FileCheck -check-prefix CHECK-LP32 %s");
  }

  @Test
  public void test_block_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - -fblocks
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm -o - -fblocks");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block.cpp -triple i386-pc-win32 -fno-rtti -emit-llvm -o - -fblocks
    RUN(TestState.Failed, "%clang_cc1 %s -triple %ms_abi_triple -fno-rtti -emit-llvm -o - -fblocks");
  }

  @Test
  public void test_block_byref_cxx_objc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block-byref-cxx-objc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block-byref-cxx-objc.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - -fblocks | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block-byref-cxx-objc.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o - -fblocks")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_destruct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block-destruct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block-destruct.cpp -fblocks -triple x86_64-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block-destruct.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fblocks -triple x86_64-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_in_ctor_dtor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block-in-ctor-dtor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block-in-ctor-dtor.cpp -fblocks -triple x86_64-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/block-in-ctor-dtor.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fblocks -triple x86_64-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_blocks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/blocks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/blocks.cpp -fblocks -triple x86_64-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/blocks.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fblocks -triple x86_64-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_blocks_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/blocks-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/blocks-cxx11.cpp -fblocks -triple x86_64-apple-darwin -std=c++11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/blocks-cxx11.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fblocks -triple x86_64-apple-darwin -std=c++11 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_bool_bitfield_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bool-bitfield.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bool-bitfield.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/bool-bitfield.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/builtins.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/builtins.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/builtins.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_builtins_systemz_zvector_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/builtins-systemz-zvector.cpp");
    // REQUIRES: systemz-registered-target
    if (!CHECK_REQUIRES("systemz-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -target-cpu z13 -triple s390x-linux-gnu -fzvector -fno-lax-vector-conversions -std=c++11 -Wall -Wno-unused -Werror -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/builtins-systemz-zvector.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/builtins-systemz-zvector.cpp
    RUN(TestState.Failed, "%clang_cc1 -target-cpu z13 -triple s390x-linux-gnu -fzvector -fno-lax-vector-conversions -std=c++11 -Wall -Wno-unused -Werror -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_c_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/c-linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/c-linkage.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/c-linkage.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_c99_variable_length_array_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/c99-variable-length-array.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/c99-variable-length-array.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/c99-variable-length-array.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_call_arg_zero_temp_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/call-arg-zero-temp.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/call-arg-zero-temp.cpp -o ${TEST_TEMP_DIR}/call-arg-zero-temp.cpp.tmp-64.s
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -S %s -o %t-64.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 '--input-file=${TEST_TEMP_DIR}/call-arg-zero-temp.cpp.tmp-64.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/call-arg-zero-temp.cpp
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP64 --input-file=%t-64.s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/call-arg-zero-temp.cpp -o ${TEST_TEMP_DIR}/call-arg-zero-temp.cpp.tmp-32.s
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -S %s -o %t-32.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP32 '--input-file=${TEST_TEMP_DIR}/call-arg-zero-temp.cpp.tmp-32.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/call-arg-zero-temp.cpp
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP32 --input-file=%t-32.s %s");
  }

  @Test
  public void test_call_with_static_chain_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/call-with-static-chain.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/call-with-static-chain.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/call-with-static-chain.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/call-with-static-chain.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/call-with-static-chain.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK64 %s");
  }

  @Test
  public void test_captured_statements_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/captured-statements.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/captured-statements.cpp -o ${TEST_TEMP_DIR}/captured-statements.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -emit-llvm %s -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/captured-statements.cpp '-input-file=${TEST_TEMP_DIR}/captured-statements.cpp.tmp' -check-prefix=CHECK-1
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK-1");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/captured-statements.cpp '-input-file=${TEST_TEMP_DIR}/captured-statements.cpp.tmp' -check-prefix=CHECK-2
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK-2");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/captured-statements.cpp '-input-file=${TEST_TEMP_DIR}/captured-statements.cpp.tmp' -check-prefix=CHECK-3
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK-3");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/captured-statements.cpp '-input-file=${TEST_TEMP_DIR}/captured-statements.cpp.tmp' -check-prefix=CHECK-4
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK-4");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/captured-statements.cpp '-input-file=${TEST_TEMP_DIR}/captured-statements.cpp.tmp' -check-prefix=CHECK-5
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK-5");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/captured-statements.cpp '-input-file=${TEST_TEMP_DIR}/captured-statements.cpp.tmp' -check-prefix=CHECK-6
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK-6");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/captured-statements.cpp '-input-file=${TEST_TEMP_DIR}/captured-statements.cpp.tmp' -check-prefix=CHECK-7
    RUN(TestState.Failed, "FileCheck %s -input-file=%t -check-prefix=CHECK-7");
  }

  @Test
  public void test_cast_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cast-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cast-conversion.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cast-conversion.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cast-conversion.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cast-conversion.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cast_to_ref_bool_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cast-to-ref-bool.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cast-to-ref-bool.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cast-to-ref-bool.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_casts_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/casts.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/casts.cpp -emit-llvm -o ${TEST_TEMP_DIR}/casts.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_catch_undef_behavior_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsanitize=signed-integer-overflow,integer-divide-by-zero,float-divide-by-zero,shift-base,shift-exponent,unreachable,return,vla-bound,alignment,null,vptr,object-size,float-cast-overflow,bool,enum,array-bounds,function -fsanitize-recover=signed-integer-overflow,integer-divide-by-zero,float-divide-by-zero,shift-base,shift-exponent,vla-bound,alignment,null,vptr,object-size,float-cast-overflow,bool,enum,array-bounds,function -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior.cpp -o - -triple x86_64-linux-gnu | opt -instnamer -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fsanitize=signed-integer-overflow,integer-divide-by-zero,float-divide-by-zero,shift-base,shift-exponent,unreachable,return,vla-bound,alignment,null,vptr,object-size,float-cast-overflow,bool,enum,array-bounds,function -fsanitize-recover=signed-integer-overflow,integer-divide-by-zero,float-divide-by-zero,shift-base,shift-exponent,vla-bound,alignment,null,vptr,object-size,float-cast-overflow,bool,enum,array-bounds,function -emit-llvm %s -o - -triple x86_64-linux-gnu")./*|*/
      I("opt -instnamer -S")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsanitize=vptr,address -fsanitize-recover=vptr,address -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior.cpp -o - -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior.cpp --check-prefix=CHECK-ASAN
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fsanitize=vptr,address -fsanitize-recover=vptr,address -emit-llvm %s -o - -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ASAN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsanitize=vptr -fsanitize-recover=vptr -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior.cpp -o - -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior.cpp --check-prefix=DOWNCAST-NULL
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fsanitize=vptr -fsanitize-recover=vptr -emit-llvm %s -o - -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s --check-prefix=DOWNCAST-NULL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsanitize=function -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior.cpp -o - -triple x86_64-linux-gnux32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior.cpp --check-prefix=CHECK-X32
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fsanitize=function -emit-llvm %s -o - -triple x86_64-linux-gnux32")./*|*/
      I("FileCheck %s --check-prefix=CHECK-X32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsanitize=function -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior.cpp -o - -triple i386-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior.cpp --check-prefix=CHECK-X86
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fsanitize=function -emit-llvm %s -o - -triple i386-linux-gnu")./*|*/
      I("FileCheck %s --check-prefix=CHECK-X86");
  }

  @Test
  public void test_catch_undef_behavior2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsanitize=signed-integer-overflow,integer-divide-by-zero,float-divide-by-zero,shift-base,shift-exponent,unreachable,return,vla-bound,alignment,null,vptr,object-size,float-cast-overflow,bool,enum,array-bounds,function -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior2.cpp -o - -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/catch-undef-behavior2.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fsanitize=signed-integer-overflow,integer-divide-by-zero,float-divide-by-zero,shift-base,shift-exponent,unreachable,return,vla-bound,alignment,null,vptr,object-size,float-cast-overflow,bool,enum,array-bounds,function -emit-llvm %s -o - -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cfi_blacklist_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-blacklist.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fvisibility hidden -fms-extensions -fsanitize=cfi-vcall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-blacklist.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=NOBL ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-blacklist.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -fvisibility hidden -fms-extensions -fsanitize=cfi-vcall -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=NOBL %s");
    // echo type:std::* > ${TEST_TEMP_DIR}/cfi-blacklist.cpp.tmp.txt
    RUN(TestState.Failed, "echo \"type:std::*\" > %t.txt");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fvisibility hidden -fms-extensions -fsanitize=cfi-vcall '-fsanitize-blacklist=${TEST_TEMP_DIR}/cfi-blacklist.cpp.tmp.txt' -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-blacklist.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=NOSTD ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-blacklist.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -fvisibility hidden -fms-extensions -fsanitize=cfi-vcall -fsanitize-blacklist=%t.txt -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=NOSTD %s");
  }

  @Test
  public void test_cfi_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -fvisibility hidden -std=c++11 -fsanitize=cfi-derived-cast -fsanitize-trap=cfi-derived-cast -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cast.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-DCAST ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cast.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -fvisibility hidden -std=c++11 -fsanitize=cfi-derived-cast -fsanitize-trap=cfi-derived-cast -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-DCAST %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -fvisibility hidden -std=c++11 -fsanitize=cfi-unrelated-cast -fsanitize-trap=cfi-unrelated-cast -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cast.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-UCAST ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cast.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -fvisibility hidden -std=c++11 -fsanitize=cfi-unrelated-cast -fsanitize-trap=cfi-unrelated-cast -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-UCAST %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -fvisibility hidden -std=c++11 -fsanitize=cfi-unrelated-cast,cfi-cast-strict -fsanitize-trap=cfi-unrelated-cast,cfi-cast-strict -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cast.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-UCAST-STRICT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cast.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -fvisibility hidden -std=c++11 -fsanitize=cfi-unrelated-cast,cfi-cast-strict -fsanitize-trap=cfi-unrelated-cast,cfi-cast-strict -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=CHECK-UCAST-STRICT %s");
  }

  @Test
  public void test_cfi_cross_dso_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cross-dso.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-unknown-linux -fsanitize=cfi-vcall -fsanitize-cfi-cross-dso -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cross-dso.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=ITANIUM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cross-dso.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-unknown-linux -fsanitize=cfi-vcall -fsanitize-cfi-cross-dso -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=ITANIUM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-pc-windows-msvc -fsanitize=cfi-vcall -fsanitize-cfi-cross-dso -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cross-dso.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=MS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-cross-dso.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-pc-windows-msvc -fsanitize=cfi-vcall  -fsanitize-cfi-cross-dso -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=MS %s");
  }

  @Test
  public void test_cfi_icall_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-icall.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -fsanitize=cfi-icall -fsanitize-trap=cfi-icall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-icall.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=ITANIUM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-icall.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -fsanitize=cfi-icall -fsanitize-trap=cfi-icall -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=ITANIUM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-windows-msvc -fsanitize=cfi-icall -fsanitize-trap=cfi-icall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-icall.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=MS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-icall.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-windows-msvc -fsanitize=cfi-icall -fsanitize-trap=cfi-icall -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=MS %s");
  }

  @Test
  public void test_cfi_ms_rtti_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-ms-rtti.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -emit-llvm -o - -triple=x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-ms-rtti.cpp -fsanitize=cfi-vcall | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=RTTI ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-ms-rtti.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -emit-llvm -o - -triple=x86_64-pc-win32 %s -fsanitize=cfi-vcall")./*|*/
      I("FileCheck --check-prefix=RTTI %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -emit-llvm -o - -triple=x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-ms-rtti.cpp -fsanitize=cfi-vcall -fno-rtti-data | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=NO-RTTI ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-ms-rtti.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -emit-llvm -o - -triple=x86_64-pc-win32 %s -fsanitize=cfi-vcall -fno-rtti-data")./*|*/
      I("FileCheck --check-prefix=NO-RTTI %s");
  }

  @Test
  public void test_cfi_nvcall_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-nvcall.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-nvcall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-nvcall.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-nvcall.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-nvcall -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-nvcall,cfi-cast-strict -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-nvcall.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-STRICT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-nvcall.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-nvcall,cfi-cast-strict -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-STRICT %s");
  }

  @Test
  public void test_cfi_speculative_vtable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-speculative-vtable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -O1 -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-speculative-vtable.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-speculative-vtable.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -O1 -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -emit-llvm -o - %s")./*|*/
      I("FileCheck  %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -O1 -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -fsanitize-cfi-cross-dso -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-speculative-vtable.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-speculative-vtable.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -O1 -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -fsanitize-cfi-cross-dso -emit-llvm -o - %s")./*|*/
      I("FileCheck  %s");
  }

  @Test
  public void test_cfi_stats_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-stats.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall,cfi-nvcall,cfi-derived-cast,cfi-unrelated-cast,cfi-icall -fsanitize-stats -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-stats.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-stats.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall,cfi-nvcall,cfi-derived-cast,cfi-unrelated-cast,cfi-icall -fsanitize-stats -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall,cfi-nvcall,cfi-derived-cast,cfi-unrelated-cast,cfi-icall -fsanitize-trap=cfi-vcall -fwhole-program-vtables -fsanitize-stats -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-stats.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cfi-stats.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall,cfi-nvcall,cfi-derived-cast,cfi-unrelated-cast,cfi-icall -fsanitize-trap=cfi-vcall -fwhole-program-vtables -fsanitize-stats -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_class_layout_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/class-layout.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/class-layout.cpp -triple x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/class-layout.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_compound_literals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/compound-literals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple armv7-none-eabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/compound-literals.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/compound-literals.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple armv7-none-eabi -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_condition_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/condition.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/condition.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/condition.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_conditional_expr_lvalue_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conditional-expr-lvalue.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conditional-expr-lvalue.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_conditional_gnu_ext_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conditional-gnu-ext.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conditional-gnu-ext.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conditional-gnu-ext.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_conditional_temporaries_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conditional-temporaries.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conditional-temporaries.cpp -o - -triple=x86_64-apple-darwin9 -O3 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conditional-temporaries.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin9 -O3")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_const_base_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-base-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-base-cast.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-base-cast.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_const_global_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-global-linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-global-linkage.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-global-linkage.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_const_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -std=c++98 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -std=c++98 -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -std=c++11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -std=c++11 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_const_init_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -triple x86_64-elf-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init-cxx11.cpp -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init-cxx11.cpp
    RUN(TestState.Failed, "%clang_cc1 -w -triple x86_64-elf-gnu -emit-llvm -o - %s -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_const_init_cxx1y_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init-cxx1y.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init-cxx1y.cpp -std=c++1y | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/const-init-cxx1y.cpp
    RUN(TestState.Failed, "%clang_cc1 -verify -triple x86_64-apple-darwin -emit-llvm -o - %s -std=c++1y")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_constructor_alias_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-alias.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple mipsel--linux-gnu -mconstructor-aliases -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-alias.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-alias.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple mipsel--linux-gnu -mconstructor-aliases -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_constructor_attr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-attr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-attr.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-attr.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_constructor_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-conversion.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-conversion.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-conversion.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-conversion.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_constructor_convert_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-convert.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-convert.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s");
  }

  @Test
  public void test_constructor_default_arg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-default-arg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-default-arg.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-default-arg.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-default-arg.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-default-arg.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_constructor_destructor_return_this_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-destructor-return-this.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-destructor-return-this.cpp -emit-llvm -o - -triple=i686-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKGEN ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-destructor-return-this.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=i686-unknown-linux")./*|*/
      I("FileCheck --check-prefix=CHECKGEN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-destructor-return-this.cpp -emit-llvm -o - -triple=thumbv7-apple-ios6.0 -target-abi apcs-gnu | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKARM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-destructor-return-this.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=thumbv7-apple-ios6.0 -target-abi apcs-gnu")./*|*/
      I("FileCheck --check-prefix=CHECKARM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-destructor-return-this.cpp -emit-llvm -o - -triple=thumbv7-apple-ios5.0 -target-abi apcs-gnu | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKIOS5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-destructor-return-this.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=thumbv7-apple-ios5.0 -target-abi apcs-gnu")./*|*/
      I("FileCheck --check-prefix=CHECKIOS5 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-destructor-return-this.cpp -emit-llvm -o - -triple=wasm32-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKARM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-destructor-return-this.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=wasm32-unknown-unknown")./*|*/
      I("FileCheck --check-prefix=CHECKARM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-destructor-return-this.cpp -emit-llvm -o - -triple=i386-pc-win32 -fno-rtti | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECKMS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-destructor-return-this.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=i386-pc-win32 -fno-rtti")./*|*/
      I("FileCheck --check-prefix=CHECKMS %s");
  }

  @Test
  public void test_constructor_direct_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-direct-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-mingw32 -fms-extensions -Wmicrosoft ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-direct-call.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-direct-call.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-mingw32 -fms-extensions -Wmicrosoft %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_constructor_for_array_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-for-array-members.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-for-array-members.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-for-array-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-for-array-members.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-for-array-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_constructor_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-init.cpp -emit-llvm -o ${TEST_TEMP_DIR}/constructor-init.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin10 %s -emit-llvm -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-init.cpp < ${TEST_TEMP_DIR}/constructor-init.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-PR10720 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-init.cpp < ${TEST_TEMP_DIR}/constructor-init.cpp.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-PR10720 %s < %t");
  }

  @Test
  public void test_constructor_init_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-init-reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-init-reference.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-init-reference.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_constructor_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-template.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-template.cpp -o ${TEST_TEMP_DIR}/constructor-template.cpp.tmp-64.s
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -S %s -o %t-64.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 '--input-file=${TEST_TEMP_DIR}/constructor-template.cpp.tmp-64.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-template.cpp
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP64 --input-file=%t-64.s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-template.cpp -o ${TEST_TEMP_DIR}/constructor-template.cpp.tmp-32.s
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -S %s -o %t-32.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP32 '--input-file=${TEST_TEMP_DIR}/constructor-template.cpp.tmp-32.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructor-template.cpp
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP32 --input-file=%t-32.s %s");
  }

  @Test
  public void test_constructors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructors.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/constructors.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_conversion_function_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conversion-function.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conversion-function.cpp -o ${TEST_TEMP_DIR}/conversion-function.cpp.tmp-64.s
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -S %s -o %t-64.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 '--input-file=${TEST_TEMP_DIR}/conversion-function.cpp.tmp-64.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conversion-function.cpp
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP64 --input-file=%t-64.s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conversion-function.cpp -o ${TEST_TEMP_DIR}/conversion-function.cpp.tmp-32.s
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -S %s -o %t-32.s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP32 '--input-file=${TEST_TEMP_DIR}/conversion-function.cpp.tmp-32.s' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conversion-function.cpp
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LP32 --input-file=%t-32.s %s");
  }

  @Test
  public void test_conversion_operator_base_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conversion-operator-base.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/conversion-operator-base.cpp -verify
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s -verify");
  }

  @Test
  public void test_convert_to_fptr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/convert-to-fptr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/convert-to-fptr.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/convert-to-fptr.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/convert-to-fptr.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/convert-to-fptr.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_copy_assign_synthesis_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/copy-assign-synthesis.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
    // grep _ZN1XaSERK1X ${TEST_TEMP_DIR}/copy-assign-synthesis.cpp.tmp
    RUN(TestState.Failed, "not grep \"_ZN1XaSERK1X\" %t");
  }

  @Test
  public void test_copy_assign_synthesis_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis-1.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis-1.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis-1.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis-1.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_copy_assign_synthesis_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis-2.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis-2.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_copy_assign_synthesis_3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis-3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-synthesis-3.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -verify %s");
  }

  @Test
  public void test_copy_assign_volatile_synthesis_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-volatile-synthesis.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-volatile-synthesis.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-assign-volatile-synthesis.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_copy_constructor_elim_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-elim.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-elim.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-elim.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-elim.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-elim.cpp -check-prefix MS
    RUN(TestState.Failed, "%clang_cc1 -triple %ms_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix MS");
  }

  @Test
  public void test_copy_constructor_elim_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-elim-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-none-eabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-elim-2.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-elim-2.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-none-eabi -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_copy_constructor_synthesis_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-synthesis.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-synthesis.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-synthesis.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_copy_constructor_synthesis_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-synthesis-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-synthesis-2.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-constructor-synthesis-2.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -std=c++11 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_copy_in_cplus_object_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-in-cplus-object.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-in-cplus-object.cpp -fblocks -triple x86_64-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-in-cplus-object.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fblocks -triple x86_64-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_copy_initialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-initialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-initialization.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/copy-initialization.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_coverage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/coverage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/coverage.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - -test-coverage -femit-coverage-notes | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/coverage.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm -o - -test-coverage -femit-coverage-notes")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cp_blocks_linetables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cp-blocks-linetables.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -debug-info-kind=limited -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cp-blocks-linetables.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cp-blocks-linetables.cpp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -debug-info-kind=limited -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/crash.cpp -std=c++11 -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -emit-llvm-only");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-obj -o ${TEST_TEMP_DIR}/crash.cpp.tmp -debug-info-kind=line-tables-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/crash.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-obj -o %t -debug-info-kind=line-tables-only -std=c++11 %s");
  }

  @Test
  public void test_ctor_dtor_alias_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp -triple i686-linux -emit-llvm -o - -mconstructor-aliases | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=NOOPT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-linux -emit-llvm -o - -mconstructor-aliases")./*|*/
      I("FileCheck --check-prefix=NOOPT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp -triple i686-linux -emit-llvm -o - -mconstructor-aliases -O1 -disable-llvm-optzns > ${TEST_TEMP_DIR}/ctor-dtor-alias.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-linux -emit-llvm -o - -mconstructor-aliases -O1 -disable-llvm-optzns > %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK1 '--input-file=${TEST_TEMP_DIR}/ctor-dtor-alias.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK1 --input-file=%t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK2 '--input-file=${TEST_TEMP_DIR}/ctor-dtor-alias.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK2 --input-file=%t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK3 '--input-file=${TEST_TEMP_DIR}/ctor-dtor-alias.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK3 --input-file=%t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK4 '--input-file=${TEST_TEMP_DIR}/ctor-dtor-alias.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK4 --input-file=%t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK5 '--input-file=${TEST_TEMP_DIR}/ctor-dtor-alias.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK5 --input-file=%t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK6 '--input-file=${TEST_TEMP_DIR}/ctor-dtor-alias.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK6 --input-file=%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp -triple i686-pc-windows-gnu -emit-llvm -o - -mconstructor-aliases -O1 -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=COFF ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-dtor-alias.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-windows-gnu -emit-llvm -o - -mconstructor-aliases -O1 -disable-llvm-optzns")./*|*/
      I("FileCheck --check-prefix=COFF %s");
  }

  @Test
  public void test_ctor_globalopt_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-globalopt.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-globalopt.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-globalopt.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-globalopt.cpp -O2 | opt - -S -globalopt -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-globalopt.cpp --check-prefix=O1
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s -O2")./*|*/
      I("opt - -S -globalopt -o -")./*|*/
      I("FileCheck %s --check-prefix=O1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-globalopt.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-globalopt.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %ms_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-globalopt.cpp -O2 | opt - -S -globalopt -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ctor-globalopt.cpp --check-prefix=O1
    RUN(TestState.Failed, "%clang_cc1 -triple %ms_abi_triple -emit-llvm -o - %s -O2")./*|*/
      I("opt - -S -globalopt -o -")./*|*/
      I("FileCheck %s --check-prefix=O1");
  }

  @Test
  public void test_cxx_apple_kext_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx-apple-kext.cpp");
    // ${LLVM_SRC}/build/bin/clang --driver-mode=g++ -target x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx-apple-kext.cpp -flto -S -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NO-KEXT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx-apple-kext.cpp
    RUN(TestState.Failed, "%clangxx -target x86_64-apple-darwin10 %s -flto -S -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-NO-KEXT %s");
    // ${LLVM_SRC}/build/bin/clang --driver-mode=g++ -target x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx-apple-kext.cpp -fapple-kext -flto -S -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-KEXT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx-apple-kext.cpp
    RUN(TestState.Failed, "%clangxx -target x86_64-apple-darwin10 %s -fapple-kext -flto -S -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-KEXT %s");
  }

  @Test
  public void test_cxx_block_objects_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx-block-objects.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx-block-objects.cpp -fblocks -triple x86_64-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx-block-objects.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fblocks -triple x86_64-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx0x_defaulted_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-defaulted-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-defaulted-templates.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-defaulted-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx0x_delegating_ctors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-delegating-ctors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -fexceptions -fcxx-exceptions -std=c++11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-delegating-ctors.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-delegating-ctors.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -fexceptions -fcxx-exceptions -std=c++11 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx0x_initializer_array_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-array.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -std=c++11 -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-array.cpp -Wno-address-of-temporary | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-array.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -std=c++11 -S -emit-llvm -o - %s -Wno-address-of-temporary")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx0x_initializer_constructors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-constructors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -S -triple x86_64-none-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-constructors.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-constructors.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -S -triple x86_64-none-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx0x_initializer_references_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-references.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -S -triple armv7-none-eabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-references.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-references.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -S -triple armv7-none-eabi -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx0x_initializer_scalars_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-scalars.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-scalars.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-scalars.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx0x_initializer_stdinitializerlist_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-none-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-none-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx0x_initializer_stdinitializerlist_pr12086_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-pr12086.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-pr12086.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-pr12086.cpp --check-prefix=CHECK-STATIC-BL
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -std=c++11 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-STATIC-BL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-pr12086.cpp -Dconstexpr= | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-pr12086.cpp --check-prefix=CHECK-DYNAMIC-BL
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -std=c++11 -emit-llvm -o - %s -Dconstexpr=")./*|*/
      I("FileCheck %s --check-prefix=CHECK-DYNAMIC-BL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-pr12086.cpp -DUSE_END | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-pr12086.cpp --check-prefix=CHECK-STATIC-BE
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -std=c++11 -emit-llvm -o - %s -DUSE_END")./*|*/
      I("FileCheck %s --check-prefix=CHECK-STATIC-BE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-pr12086.cpp -DUSE_END -Dconstexpr= | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-pr12086.cpp --check-prefix=CHECK-DYNAMIC-BE
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -std=c++11 -emit-llvm -o - %s -DUSE_END -Dconstexpr=")./*|*/
      I("FileCheck %s --check-prefix=CHECK-DYNAMIC-BE");
  }

  @Test
  public void test_cxx0x_initializer_stdinitializerlist_startend_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-startend.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -S -triple x86_64-none-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-startend.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx0x-initializer-stdinitializerlist-startend.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -S -triple x86_64-none-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx11_exception_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-exception-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-exception-spec.cpp -o - -verify -fexceptions -fcxx-exceptions -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-exception-spec.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -verify -fexceptions -fcxx-exceptions -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx11_initializer_aggregate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-initializer-aggregate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-initializer-aggregate.cpp -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-initializer-aggregate.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -S -emit-llvm -o - %s -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx11_initializer_array_new_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-initializer-array-new.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-initializer-array-new.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-initializer-array-new.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -std=c++11 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx11_noreturn_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-noreturn.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-noreturn.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-noreturn.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -std=c++11 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx11_special_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-special-members.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-special-members.cpp -std=c++11 -emit-llvm -o - -triple=i686-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-special-members.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -emit-llvm -o - -triple=i686-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx11_thread_local_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local.cpp -o - -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=LINUX ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -triple x86_64-linux-gnu")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=LINUX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -femulated-tls -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local.cpp -o - -triple x86_64-linux-gnu 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=LINUX ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -femulated-tls -emit-llvm %s -o - -triple x86_64-linux-gnu 2>&1")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=LINUX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local.cpp -o - -triple x86_64-apple-darwin12 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=DARWIN ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -triple x86_64-apple-darwin12")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=DARWIN %s");
  }

  @Test
  public void test_cxx11_thread_local_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local-reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local-reference.cpp -o - -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=LINUX ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local-reference.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -triple x86_64-linux-gnu")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=LINUX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local-reference.cpp -o - -triple x86_64-apple-darwin12 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK --check-prefix=DARWIN ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-thread-local-reference.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -triple x86_64-apple-darwin12")./*|*/
      I("FileCheck --check-prefix=CHECK --check-prefix=DARWIN %s");
  }

  @Test
  public void test_cxx11_trivial_initializer_struct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-trivial-initializer-struct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -S -emit-llvm -o ${TEST_TEMP_DIR}/cxx11-trivial-initializer-struct.cpp.tmp-c++11.ll ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-trivial-initializer-struct.cpp -triple x86_64-apple-darwin10
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -S -emit-llvm -o %t-c++11.ll %s -triple x86_64-apple-darwin10");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-trivial-initializer-struct.cpp < ${TEST_TEMP_DIR}/cxx11-trivial-initializer-struct.cpp.tmp-c++11.ll
    RUN(TestState.Failed, "FileCheck %s < %t-c++11.ll");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -S -emit-llvm -o ${TEST_TEMP_DIR}/cxx11-trivial-initializer-struct.cpp.tmp.ll ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-trivial-initializer-struct.cpp -triple x86_64-apple-darwin10
    RUN(TestState.Failed, "%clang_cc1  -std=c++98 -S -emit-llvm -o %t.ll %s -triple x86_64-apple-darwin10");
    // diff ${TEST_TEMP_DIR}/cxx11-trivial-initializer-struct.cpp.tmp.ll ${TEST_TEMP_DIR}/cxx11-trivial-initializer-struct.cpp.tmp-c++11.ll
    RUN(TestState.Failed, "diff %t.ll  %t-c++11.ll");
  }

  @Test
  public void test_cxx11_unrestricted_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-unrestricted-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-unrestricted-union.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-unrestricted-union.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx11_user_defined_literal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-user-defined-literal.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-user-defined-literal.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-user-defined-literal.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx11_vtable_key_function_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-vtable-key-function.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-vtable-key-function.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx11-vtable-key-function.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o - -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx1y_deduced_return_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-deduced-return-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -triple x86_64-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-deduced-return-type.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-deduced-return-type.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++1y -triple x86_64-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx1y_generic_lambdas_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-generic-lambdas.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-generic-lambdas.cpp -std=c++14 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-generic-lambdas.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux-gnu -emit-llvm -o - %s -std=c++14")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx1y_init_captures_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-init-captures.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -triple x86_64-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-init-captures.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-init-captures.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++1y -triple x86_64-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx1y_initializer_aggregate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-initializer-aggregate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-initializer-aggregate.cpp -triple x86_64-linux-gnu -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-initializer-aggregate.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++1y %s -triple x86_64-linux-gnu -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx1y_sized_deallocation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-sized-deallocation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsized-deallocation ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-sized-deallocation.cpp -emit-llvm -triple x86_64-linux-gnu -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-sized-deallocation.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fsized-deallocation %s -emit-llvm -triple x86_64-linux-gnu -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 -fsized-deallocation ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-sized-deallocation.cpp -emit-llvm -triple x86_64-linux-gnu -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-sized-deallocation.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++14 -fsized-deallocation %s -emit-llvm -triple x86_64-linux-gnu -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-sized-deallocation.cpp -emit-llvm -triple x86_64-linux-gnu -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-sized-deallocation.cpp --check-prefix=CHECK-UNSIZED
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 %s -emit-llvm -triple x86_64-linux-gnu -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-UNSIZED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-sized-deallocation.cpp -emit-llvm -triple x86_64-linux-gnu -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-sized-deallocation.cpp --check-prefix=CHECK-UNSIZED
    RUN(TestState.Failed, "%clang_cc1 -std=c++14 %s -emit-llvm -triple x86_64-linux-gnu -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-UNSIZED");
  }

  @Test
  public void test_cxx1y_variable_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-variable-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -triple x86_64-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-variable-template.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-variable-template.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++1y -triple x86_64-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx1y_variable_template_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-variable-template-linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -emit-llvm -std=c++1y -O1 -disable-llvm-optzns ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-variable-template-linkage.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-variable-template-linkage.cpp -check-prefix=CHECKA -check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -emit-llvm -std=c++1y -O1 -disable-llvm-optzns %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECKA -check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -emit-llvm -std=c++1y -O1 -disable-llvm-optzns -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-variable-template-linkage.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1y-variable-template-linkage.cpp -check-prefix=CHECKB -check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -emit-llvm -std=c++1y -O1 -disable-llvm-optzns -fcxx-exceptions %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECKB -check-prefix=CHECK");
  }

  @Test
  public void test_cxx1z_constexpr_if_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-constexpr-if.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-constexpr-if.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-constexpr-if.cpp --implicit-check-not=should_not_be_used
    RUN(TestState.Failed, "%clang_cc1 -std=c++1z %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --implicit-check-not=should_not_be_used");
  }

  @Test
  public void test_cxx1z_fold_expression_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-fold-expression.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-fold-expression.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-fold-expression.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++1z -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx1z_init_statement_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-init-statement.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -triple x86_64-apple-macosx10.7.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-init-statement.cpp -w | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-init-statement.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++1z -triple x86_64-apple-macosx10.7.0 -emit-llvm -o - %s -w")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx1z_initializer_aggregate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-initializer-aggregate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-initializer-aggregate.cpp -triple x86_64-linux-gnu -fexceptions -fcxx-exceptions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-initializer-aggregate.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++1z %s -triple x86_64-linux-gnu -fexceptions -fcxx-exceptions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx1z_inline_variables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-inline-variables.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-inline-variables.cpp -emit-llvm -o - -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-inline-variables.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++1z %s -emit-llvm -o - -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_cxx1z_lambda_star_this_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-lambda-star-this.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -triple i686-pc-windows-msvc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-lambda-star-this.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/cxx1z-lambda-star-this.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++1y -triple i686-pc-windows-msvc -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info.cpp --check-prefix=CHECK --check-prefix=BOTH
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=BOTH");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-windows-msvc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info.cpp --check-prefix=MSVC --check-prefix=BOTH
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-windows-msvc -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s --check-prefix=MSVC --check-prefix=BOTH");
  }

  @Test
  public void test_debug_info_access_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-access.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-access.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-access.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple %itanium_abi_triple %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_alias_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-alias.cpp");
    // ${LLVM_SRC}/build/bin/clang -g -std=c++11 -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-alias.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-alias.cpp
    RUN(TestState.Failed, "%clang -g -std=c++11 -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_anon_namespace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-anon-namespace.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-scei-ps4 -O0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-anon-namespace.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=PS4 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-anon-namespace.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-scei-ps4 -O0 %s -o -")./*|*/
      I("FileCheck --check-prefix=PS4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-unknown-linux-gnu -O0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-anon-namespace.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=NON-PS4 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-anon-namespace.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-unknown-linux-gnu -O0 %s -o -")./*|*/
      I("FileCheck --check-prefix=NON-PS4 %s");
  }

  @Test
  public void test_debug_info_anon_union_vars_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-anon-union-vars.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-anon-union-vars.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-anon-union-vars.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-linux-gnu %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_artificial_arg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-artificial-arg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-artificial-arg.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-artificial-arg.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_blocks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-blocks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-blocks.cpp -debug-info-kind=line-tables-only -fblocks -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-blocks.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -debug-info-kind=line-tables-only -fblocks -S -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_byval_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-byval.cpp");
    // ${LLVM_SRC}/build/bin/clang -Xclang -triple=i386-pc-solaris2.11 -g -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-byval.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-byval.cpp
    RUN(TestState.Failed, "%clang -Xclang -triple=%itanium_abi_triple -g -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_calling_conventions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-calling-conventions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-calling-conventions.cpp -triple=i686-pc-windows-msvc -debug-info-kind=limited -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-calling-conventions.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i686-pc-windows-msvc -debug-info-kind=limited -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_char16_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-char16.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -std=c++11 -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-char16.cpp -o -| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-char16.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -std=c++11 -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown_unknown -emit-llvm -debug-info-kind=limited -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown_unknown -emit-llvm -debug-info-kind=limited -fexceptions %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-cygwin -emit-llvm -debug-info-kind=limited -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-cygwin -emit-llvm -debug-info-kind=limited -fexceptions %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7l-unknown-linux-gnueabihf -emit-llvm -debug-info-kind=limited -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple armv7l-unknown-linux-gnueabihf -emit-llvm -debug-info-kind=limited -fexceptions %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_class_nolimit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class-nolimit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unk-unk -debug-info-kind=standalone -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class-nolimit.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class-nolimit.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unk-unk -debug-info-kind=standalone -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -debug-info-kind=standalone -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class-nolimit.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-class-nolimit.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -debug-info-kind=standalone -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_codeview_display_name_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-codeview-display-name.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -debug-info-kind=limited -gcodeview -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-codeview-display-name.cpp -o - -triple=x86_64-pc-win32 -std=c++98 | grep DISubprogram | sed -e 's/.*name: "\([^"]*\)".*/"\1"/' | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-codeview-display-name.cpp --check-prefix=CHECK --check-prefix=UNQUAL
    RUN(TestState.Failed, "%clang_cc1 -fblocks -debug-info-kind=limited -gcodeview -emit-llvm %s -o - -triple=x86_64-pc-win32 -std=c++98")./*|*/
      I("grep 'DISubprogram'")./*|*/
      I("sed -e 's/.*name: \"\\([^\"]*\\)\".*/\"\\1\"/'")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=UNQUAL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -debug-info-kind=line-tables-only -gcodeview -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-codeview-display-name.cpp -o - -triple=x86_64-pc-win32 -std=c++98 | grep DISubprogram | sed -e 's/.*name: "\([^"]*\)".*/"\1"/' | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-codeview-display-name.cpp --check-prefix=CHECK --check-prefix=QUAL
    RUN(TestState.Failed, "%clang_cc1 -fblocks -debug-info-kind=line-tables-only -gcodeview -emit-llvm %s -o - -triple=x86_64-pc-win32 -std=c++98")./*|*/
      I("grep 'DISubprogram'")./*|*/
      I("sed -e 's/.*name: \"\\([^\"]*\\)\".*/\"\\1\"/'")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=QUAL");
  }

  @Test
  public void test_debug_info_context_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-context.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-context.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-context.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_ctor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ctor.cpp");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -g -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ctor.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ctor.cpp
    RUN(TestState.Failed, "%clang -emit-llvm -g -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_ctor2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ctor2.cpp");
    // ${LLVM_SRC}/build/bin/clang -Xclang -triple=i386-pc-solaris2.11 -fverbose-asm -g -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ctor2.cpp -o - | grep AT_explicit
    RUN(TestState.Failed, "%clang -Xclang -triple=%itanium_abi_triple -fverbose-asm -g -S %s -o -")./*|*/
      I("grep AT_explicit");
  }

  @Test
  public void test_debug_info_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -std=c++11 -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-cxx0x.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -std=c++11 -debug-info-kind=limited %s");
  }

  @Test
  public void test_debug_info_cxx1y_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-cxx1y.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm-only -std=c++14 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-cxx1y.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-cxx1y.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm-only -std=c++14 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_decl_nested_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-decl-nested.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -debug-info-kind=standalone -emit-llvm -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-decl-nested.cpp -o ${TEST_TEMP_DIR}/debug-info-decl-nested.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -debug-info-kind=standalone -emit-llvm -triple x86_64-apple-darwin %s -o %t");
    // cat ${TEST_TEMP_DIR}/debug-info-decl-nested.cpp.tmp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-decl-nested.cpp -check-prefix=CHECK0
    RUN(TestState.Failed, "cat %t")./*|*/
      I("FileCheck %s -check-prefix=CHECK0");
    // cat ${TEST_TEMP_DIR}/debug-info-decl-nested.cpp.tmp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-decl-nested.cpp -check-prefix=CHECK1
    RUN(TestState.Failed, "cat %t")./*|*/
      I("FileCheck %s -check-prefix=CHECK1");
    // cat ${TEST_TEMP_DIR}/debug-info-decl-nested.cpp.tmp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-decl-nested.cpp -check-prefix=CHECK2
    RUN(TestState.Failed, "cat %t")./*|*/
      I("FileCheck %s -check-prefix=CHECK2");
  }

  @Test
  public void test_debug_info_determinism_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-determinism.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -emit-llvm -debug-info-kind=limited -o ${TEST_TEMP_DIR}/debug-info-determinism.cpp.tmp1.ll ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-determinism.cpp
    RUN(TestState.Failed, "%clang_cc1 -S -emit-llvm -debug-info-kind=limited -o %t1.ll %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -emit-llvm -debug-info-kind=limited -o ${TEST_TEMP_DIR}/debug-info-determinism.cpp.tmp2.ll ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-determinism.cpp
    RUN(TestState.Failed, "%clang_cc1 -S -emit-llvm -debug-info-kind=limited -o %t2.ll %s");
    // diff ${TEST_TEMP_DIR}/debug-info-determinism.cpp.tmp1.ll ${TEST_TEMP_DIR}/debug-info-determinism.cpp.tmp2.ll
    RUN(TestState.Failed, "diff %t1.ll %t2.ll");
  }

  @Test
  public void test_debug_info_dup_fwd_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-dup-fwd-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=standalone -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-dup-fwd-decl.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-dup-fwd-decl.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=standalone -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_enum_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-enum.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-enum.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-enum.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_enum_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-enum-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-enum-class.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-enum-class.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin -std=c++11 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_explicit_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-explicit-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang --driver-mode=g++ -c -target i386-pc-solaris2.11 -g ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-explicit-cast.cpp -emit-llvm -S -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-explicit-cast.cpp
    RUN(TestState.Failed, "%clangxx -c -target %itanium_abi_triple -g %s -emit-llvm -S -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang --driver-mode=g++ -c -target i386-pc-win32 -g ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-explicit-cast.cpp -emit-llvm -S -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-explicit-cast.cpp
    RUN(TestState.Failed, "%clangxx -c -target %ms_abi_triple -g %s -emit-llvm -S -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_flex_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-flex-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-flex-member.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-flex-member.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_fn_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-fn-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -g -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-fn-template.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-fn-template.cpp
    RUN(TestState.Failed, "%clang -emit-llvm -g -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_friend_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-friend.cpp");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -g ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-friend.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-friend.cpp
    RUN(TestState.Failed, "%clang -emit-llvm -S -g %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_function_context_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-function-context.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-function-context.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-function-context.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-pc-linux-gnu %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_fwd_ref_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-fwd-ref.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-fwd-ref.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-fwd-ref.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_gline_tables_only_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-gline-tables-only.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-gline-tables-only.cpp -fno-rtti -debug-info-kind=line-tables-only -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-gline-tables-only.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -debug-info-kind=line-tables-only -S -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_global_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-global.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-global.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-global.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-none-linux-gnu -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_global_ctor_dtor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-global-ctor-dtor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-global-ctor-dtor.cpp -debug-info-kind=limited -triple i386-pc-solaris2.11 -fno-use-cxa-atexit -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-global-ctor-dtor.cpp --check-prefix=CHECK-NOKEXT
    RUN(TestState.Failed, "%clang_cc1 %s -debug-info-kind=limited -triple %itanium_abi_triple -fno-use-cxa-atexit -S -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-NOKEXT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-global-ctor-dtor.cpp -debug-info-kind=limited -triple i386-pc-solaris2.11 -fno-use-cxa-atexit -fapple-kext -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-global-ctor-dtor.cpp --check-prefix=CHECK-KEXT
    RUN(TestState.Failed, "%clang_cc1 %s -debug-info-kind=limited -triple %itanium_abi_triple -fno-use-cxa-atexit -fapple-kext -S -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-KEXT");
  }

  @Test
  public void test_debug_info_globalinit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-globalinit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-globalinit.cpp -std=c++11 -debug-info-kind=limited | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-globalinit.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - %s -std=c++11 -debug-info-kind=limited")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_indirect_field_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-indirect-field-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-indirect-field-decl.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-indirect-field-decl.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_large_constant_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-large-constant.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -triple=x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-large-constant.cpp -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -triple=x86_64-apple-darwin %s -o /dev/null");
  }

  @Test
  public void test_debug_info_limited_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-limited.cpp");
    // ${LLVM_SRC}/build/bin/clang -flimit-debug-info -emit-llvm -g -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-limited.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-limited.cpp
    RUN(TestState.Failed, "%clang -flimit-debug-info -emit-llvm -g -S %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -flimit-debug-info -emit-llvm -g -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-limited.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-C ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-limited.cpp
    RUN(TestState.Failed, "%clang -flimit-debug-info -emit-llvm -g -S %s -o -")./*|*/
      I("FileCheck --check-prefix=CHECK-C %s");
  }

  @Test
  public void test_debug_info_line_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-line.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -debug-info-kind=line-tables-only -std=c++11 -fexceptions -fcxx-exceptions -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-line.cpp -o - -triple i386-pc-solaris2.11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-line.cpp
    RUN(TestState.Failed, "%clang_cc1 -w -debug-info-kind=line-tables-only -std=c++11 -fexceptions -fcxx-exceptions -S -emit-llvm %s -o - -triple %itanium_abi_triple")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -debug-info-kind=line-tables-only -std=c++11 -fexceptions -fcxx-exceptions -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-line.cpp -o - -triple i686-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-line.cpp
    RUN(TestState.Failed, "%clang_cc1 -w -debug-info-kind=line-tables-only -std=c++11 -fexceptions -fcxx-exceptions -S -emit-llvm %s -o - -triple i686-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_line_if_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-line-if.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -std=c++11 -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-line-if.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-line-if.cpp
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -std=c++11 -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -Xclang -triple=i386-pc-solaris2.11 -fverbose-asm -g -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-member.cpp -o - | grep DW_ACCESS_public
    RUN(TestState.Failed, "%clang -Xclang -triple=%itanium_abi_triple -fverbose-asm -g -S %s -o -")./*|*/
      I("grep DW_ACCESS_public");
  }

  @Test
  public void test_debug_info_member_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-member-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown_unknown -emit-llvm -debug-info-kind=standalone -dwarf-column-info ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-member-call.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-member-call.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown_unknown -emit-llvm -debug-info-kind=standalone -dwarf-column-info %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_method_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-method.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -std=c++11 -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-method.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-method.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -std=c++11 -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_method_nodebug_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-method-nodebug.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-method-nodebug.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-method-nodebug.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_method_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-method-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -Xclang -triple=i386-pc-solaris2.11 -fverbose-asm -g -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-method-spec.cpp -o - | grep DW_AT_specification
    RUN(TestState.Failed, "%clang -Xclang -triple=%itanium_abi_triple -fverbose-asm -g -S %s -o -")./*|*/
      I("grep DW_AT_specification");
  }

  @Test
  public void test_debug_info_method2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-method2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -debug-info-kind=limited -S -emit-llvm < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-method2.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-method2.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -debug-info-kind=limited -S -emit-llvm < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_ms_abi_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-abi.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-abi.cpp -triple=i686-pc-windows-msvc -debug-info-kind=limited -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-abi.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i686-pc-windows-msvc -debug-info-kind=limited -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_ms_anonymous_tag_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-anonymous-tag.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-win32 -debug-info-kind=limited -gcodeview ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-anonymous-tag.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-anonymous-tag.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-win32 -debug-info-kind=limited -gcodeview %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_ms_bitfields_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-bitfields.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-win32 -debug-info-kind=limited -gcodeview ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-bitfields.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-bitfields.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-win32 -debug-info-kind=limited -gcodeview %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_ms_ptr_to_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-ptr-to-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows -debug-info-kind=limited -gcodeview ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-ptr-to-member.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ms-ptr-to-member.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows -debug-info-kind=limited -gcodeview %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_namespace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-namespace.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-namespace.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-namespace.cpp
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=line-tables-only -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-namespace.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GMLT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-namespace.cpp
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=line-tables-only -S -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-GMLT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=standalone -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-namespace.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NOLIMIT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-namespace.cpp
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=standalone -S -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-NOLIMIT %s");
  }

  @Test
  public void test_debug_info_nodebug_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-nodebug.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DSETNODEBUG=0 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-nodebug.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-nodebug.cpp --check-prefix=YESINFO
    RUN(TestState.Failed, "%clang_cc1 -DSETNODEBUG=0 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s --check-prefix=YESINFO");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DSETNODEBUG=1 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-nodebug.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-nodebug.cpp --check-prefix=NOINFO
    RUN(TestState.Failed, "%clang_cc1 -DSETNODEBUG=1 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s --check-prefix=NOINFO");
  }

  @Test
  public void test_debug_info_nullptr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-nullptr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -std=c++11 -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-nullptr.cpp -o -| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-nullptr.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -std=c++11 -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_ptr_to_member_function_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ptr-to-member-function.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ptr-to-member-function.cpp -triple x86_64-apple-darwin -debug-info-kind=limited -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK -check-prefix=DARWIN-X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ptr-to-member-function.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin -debug-info-kind=limited -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK -check-prefix=DARWIN-X64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ptr-to-member-function.cpp -triple x86_64-pc-win32 -debug-info-kind=limited -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK -check-prefix=WIN32-X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-ptr-to-member-function.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-pc-win32     -debug-info-kind=limited -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK -check-prefix=WIN32-X64 %s");
  }

  @Test
  public void test_debug_info_qualifiers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-qualifiers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-qualifiers.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-qualifiers.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_rvalue_ref_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-rvalue-ref.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-rvalue-ref.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-rvalue-ref.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_scope_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-scope.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-scope.cpp -o -| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-scope.cpp
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_scoped_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-scoped-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=standalone -std=c++11 -triple thumbv7-apple-ios ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-scoped-class.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-scoped-class.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=standalone -std=c++11 -triple thumbv7-apple-ios %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_static_fns_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-static-fns.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-static-fns.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-static-fns.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_static_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-static-member.cpp");
    // ${LLVM_SRC}/build/bin/clang --driver-mode=g++ -target x86_64-unknown-unknown -g ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-static-member.cpp -emit-llvm -S -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-static-member.cpp
    RUN(TestState.Failed, "%clangxx -target x86_64-unknown-unknown -g %s -emit-llvm -S -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang --driver-mode=g++ -target x86_64-unknown-unknown -g -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-static-member.cpp -emit-llvm -S -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-static-member.cpp
    RUN(TestState.Failed, "%clangxx -target x86_64-unknown-unknown -g -std=c++98 %s -emit-llvm -S -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang --driver-mode=g++ -target x86_64-unknown-unknown -g -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-static-member.cpp -emit-llvm -S -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-static-member.cpp
    RUN(TestState.Failed, "%clangxx -target x86_64-unknown-unknown -g -std=c++11 %s -emit-llvm -S -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -S -emit-llvm -target x86_64-unknown_unknown -g ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template.cpp -o - -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template.cpp
    RUN(TestState.Failed, "%clang -S -emit-llvm -target x86_64-unknown_unknown -g %s -o - -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_template_array_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-array.cpp");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -g -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-array.cpp -o -
    RUN(TestState.Failed, "%clang -emit-llvm -g -S %s -o -");
  }

  @Test
  public void test_debug_info_template_explicit_specialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-explicit-specialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-explicit-specialization.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-explicit-specialization.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -debug-info-kind=line-tables-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-explicit-specialization.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-explicit-specialization.cpp -check-prefix LINES-ONLY
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -debug-info-kind=line-tables-only %s -o -")./*|*/
      I("FileCheck %s -check-prefix LINES-ONLY");
  }

  @Test
  public void test_debug_info_template_fwd_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-fwd.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-fwd.cpp -triple=x86_64-apple-darwin -debug-info-kind=limited -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-fwd.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin -debug-info-kind=limited -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_template_limit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-limit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-limit.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-limit.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple %itanium_abi_triple %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_template_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-member.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-member.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_template_partial_specialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-partial-specialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-partial-specialization.cpp -o - -debug-info-kind=standalone | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-partial-specialization.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple %s -o - -debug-info-kind=standalone")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_template_quals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-quals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-quals.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-quals.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_template_recursive_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-recursive.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-recursive.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-template-recursive.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_this_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-this.cpp");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -g -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-this.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-this.cpp
    RUN(TestState.Failed, "%clang -emit-llvm -g -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_thunk_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-thunk.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-thunk.cpp -triple i386-pc-solaris2.11 -debug-info-kind=limited -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-thunk.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -debug-info-kind=limited -S -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-union.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-union.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin -std=c++11 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_union_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-union-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-union-template.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-union-template.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-linux-gnu  %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_use_after_free_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-use-after-free.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -triple i386-pc-solaris2.11 -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-use-after-free.cpp
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -triple %itanium_abi_triple -emit-llvm-only %s");
  }

  @Test
  public void test_debug_info_uuid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-uuid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fms-extensions -triple=x86_64-pc-win32 -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-uuid.cpp -o - -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-uuid.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fms-extensions -triple=x86_64-pc-win32 -debug-info-kind=limited %s -o - -std=c++11")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fms-extensions -triple=x86_64-unknown-unknown -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-uuid.cpp -o - -std=c++11 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-uuid.cpp --check-prefix=CHECK-ITANIUM
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fms-extensions -triple=x86_64-unknown-unknown -debug-info-kind=limited %s -o - -std=c++11 2>&1")./*|*/
      I("FileCheck %s --check-prefix=CHECK-ITANIUM");
  }

  @Test
  public void test_debug_info_varargs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-varargs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-varargs.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-varargs.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_vtable_optzn_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-vtable-optzn.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=standalone -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-vtable-optzn.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-vtable-optzn.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=standalone -triple x86_64-apple-darwin %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=standalone -triple amd64-unknown-freebsd ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-vtable-optzn.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-vtable-optzn.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=standalone -triple amd64-unknown-freebsd %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_wchar_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-wchar.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-wchar.cpp -o -| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-wchar.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_windows_dtor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-windows-dtor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-windows-msvc -std=c++11 -emit-llvm -debug-info-kind=line-tables-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-windows-dtor.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-windows-dtor.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-windows-msvc -std=c++11 -emit-llvm -debug-info-kind=line-tables-only %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_zero_length_arrays_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-zero-length-arrays.cpp");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-unknown-unknown -fverbose-asm -g -O0 -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-zero-length-arrays.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-info-zero-length-arrays.cpp
    RUN(TestState.Failed, "%clang -target x86_64-unknown-unknown -fverbose-asm -g -O0 -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_lambda_expressions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-lambda-expressions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-lambda-expressions.cpp -fexceptions -std=c++11 -debug-info-kind=limited | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-lambda-expressions.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - %s -fexceptions -std=c++11 -debug-info-kind=limited")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_lambda_this_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-lambda-this.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-lambda-this.cpp -fexceptions -std=c++11 -debug-info-kind=limited | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/debug-lambda-this.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - %s -fexceptions -std=c++11 -debug-info-kind=limited")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_decl_ref_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/decl-ref-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/decl-ref-init.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/decl-ref-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/decl-ref-init.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/decl-ref-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_default_arg_temps_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-arg-temps.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-arg-temps.cpp -o - -triple=x86_64-apple-darwin9 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-arg-temps.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin9")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_default_arguments_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-arguments.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-arguments.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-arguments.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_default_constructor_default_argument_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-constructor-default-argument.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-constructor-default-argument.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-constructor-default-argument.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_default_constructor_for_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-constructor-for-members.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-constructor-for-members.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-constructor-for-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-constructor-for-members.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-constructor-for-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_default_constructor_template_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-constructor-template-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-constructor-template-member.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-constructor-template-member.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_default_destructor_nested_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-destructor-nested.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default-destructor-nested.cpp -triple i386-pc-solaris2.11 -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm-only");
  }

  @Test
  public void test_default_calling_conv_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default_calling_conv.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-linux-gnu -fdefault-calling-conv=cdecl -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default_calling_conv.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default_calling_conv.cpp --check-prefix=CDECL --check-prefix=ALL
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-linux-gnu -fdefault-calling-conv=cdecl -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CDECL --check-prefix=ALL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i786-unknown-linux-gnu -target-feature +sse4.2 -fdefault-calling-conv=fastcall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default_calling_conv.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default_calling_conv.cpp --check-prefix=FASTCALL --check-prefix=ALL
    RUN(TestState.Failed, "%clang_cc1 -triple i786-unknown-linux-gnu -target-feature +sse4.2 -fdefault-calling-conv=fastcall -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=FASTCALL --check-prefix=ALL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i486-unknown-linux-gnu -fdefault-calling-conv=stdcall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default_calling_conv.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default_calling_conv.cpp --check-prefix=STDCALL --check-prefix=ALL
    RUN(TestState.Failed, "%clang_cc1 -triple i486-unknown-linux-gnu -fdefault-calling-conv=stdcall -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=STDCALL --check-prefix=ALL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i486-unknown-linux-gnu -mrtd -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default_calling_conv.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default_calling_conv.cpp --check-prefix=STDCALL --check-prefix=ALL
    RUN(TestState.Failed, "%clang_cc1 -triple i486-unknown-linux-gnu -mrtd -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=STDCALL --check-prefix=ALL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i986-unknown-linux-gnu -fdefault-calling-conv=vectorcall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default_calling_conv.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/default_calling_conv.cpp --check-prefix=VECTORCALL --check-prefix=ALL
    RUN(TestState.Failed, "%clang_cc1 -triple i986-unknown-linux-gnu -fdefault-calling-conv=vectorcall -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=VECTORCALL --check-prefix=ALL");
  }

  @Test
  public void test_deferred_global_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/deferred-global-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/deferred-global-init.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/deferred-global-init.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_delayed_template_parsing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/delayed-template-parsing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/delayed-template-parsing.cpp -o - -fms-extensions -fdelayed-template-parsing -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/delayed-template-parsing.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -fms-extensions -fdelayed-template-parsing -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/delayed-template-parsing.cpp -o - -fms-extensions -fdelayed-template-parsing -triple=x86_64-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/delayed-template-parsing.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -fms-extensions -fdelayed-template-parsing -triple=x86_64-pc-win32")./*|*/
      I("FileCheck -check-prefix X64 %s");
  }

  @Test
  public void test_delete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/delete.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/delete.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/delete.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_delete_two_arg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/delete-two-arg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/delete-two-arg.cpp -o - -emit-llvm -verify | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/delete-two-arg.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-linux-gnu %s -o - -emit-llvm -verify")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dependent_type_member_pointer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dependent-type-member-pointer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dependent-type-member-pointer.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-windows-msvc -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dependent-type-member-pointer.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-windows-msvc -emit-llvm-only -verify %s");
  }

  @Test
  public void test_derived_to_base_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/derived-to-base.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/derived-to-base.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/derived-to-base.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_derived_to_base_conv_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/derived-to-base-conv.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/derived-to-base-conv.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/derived-to-base-conv.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_derived_to_virtual_base_class_calls_final_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/derived-to-virtual-base-class-calls-final.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/derived-to-virtual-base-class-calls-final.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/derived-to-virtual-base-class-calls-final.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_destructor_calls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructor-calls.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructor-calls.cpp -emit-llvm -o ${TEST_TEMP_DIR}/destructor-calls.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_destructor_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructor-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructor-crash.cpp -emit-llvm -std=c++11 -o ${TEST_TEMP_DIR}/destructor-crash.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -std=c++11 -o %t");
  }

  @Test
  public void test_destructor_debug_info_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructor-debug-info.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -debug-info-kind=limited -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructor-debug-info.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructor-debug-info.cpp
    RUN(TestState.Failed, "%clang_cc1 -debug-info-kind=limited -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_destructor_exception_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructor-exception-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructor-exception-spec.cpp -std=c++11
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm-only %s -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm-only -fno-use-cxa-atexit ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructor-exception-spec.cpp -std=c++11
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm-only -fno-use-cxa-atexit %s -std=c++11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -fno-rtti -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructor-exception-spec.cpp -std=c++11
    RUN(TestState.Failed, "%clang_cc1 -triple %ms_abi_triple -fno-rtti -emit-llvm-only %s -std=c++11");
  }

  @Test
  public void test_destructors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructors.cpp");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructors.cpp -triple x86_64-apple-darwin10 -emit-llvm -o - -mconstructor-aliases -fcxx-exceptions -fexceptions -O1 -disable-llvm-optzns > ${TEST_TEMP_DIR}/destructors.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -emit-llvm -o - -mconstructor-aliases -fcxx-exceptions -fexceptions -O1 -disable-llvm-optzns > %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK1 '--input-file=${TEST_TEMP_DIR}/destructors.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructors.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK1 --input-file=%t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK2 '--input-file=${TEST_TEMP_DIR}/destructors.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructors.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK2 --input-file=%t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK3 '--input-file=${TEST_TEMP_DIR}/destructors.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructors.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK3 --input-file=%t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK4 '--input-file=${TEST_TEMP_DIR}/destructors.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructors.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK4 --input-file=%t %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK5 '--input-file=${TEST_TEMP_DIR}/destructors.cpp.tmp' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructors.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK5 --input-file=%t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructors.cpp -triple x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions -O1 -disable-llvm-optzns -std=c++11 > ${TEST_TEMP_DIR}/destructors.cpp.tmp2
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions -O1 -disable-llvm-optzns -std=c++11 > %t2");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK6 '--input-file=${TEST_TEMP_DIR}/destructors.cpp.tmp2' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/destructors.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK6 --input-file=%t2 %s");
  }

  @Test
  public void test_devirtualize_virtual_function_calls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/devirtualize-virtual-function-calls.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/devirtualize-virtual-function-calls.cpp -triple armv7-none-eabi -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/devirtualize-virtual-function-calls.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple armv7-none-eabi -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_devirtualize_virtual_function_calls_final_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/devirtualize-virtual-function-calls-final.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/devirtualize-virtual-function-calls-final.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/devirtualize-virtual-function-calls-final.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -std=c++11 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_discard_name_values_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/discard-name-values.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=armv7-apple-darwin -emit-llvm -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/discard-name-values.cpp -o - -O1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/discard-name-values.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm  -triple=armv7-apple-darwin -emit-llvm -std=c++11 %s -o - -O1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=armv7-apple-darwin -emit-llvm -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/discard-name-values.cpp -o - -O1 -discard-value-names | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/discard-name-values.cpp --check-prefix=DISCARDVALUE
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm  -triple=armv7-apple-darwin -emit-llvm -std=c++11 %s -o - -O1 -discard-value-names")./*|*/
      I("FileCheck %s --check-prefix=DISCARDVALUE");
  }

  @Test
  public void test_dllexport_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O1 -mconstructor-aliases -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp -w -fms-compatibility-version=19.00 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MSC --check-prefix=M32 -check-prefix=MSVC2015 -check-prefix=M32MSVC2015 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc   -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O1 -mconstructor-aliases -disable-llvm-optzns -o - %s -w -fms-compatibility-version=19.00")./*|*/
      I("FileCheck --check-prefix=MSC --check-prefix=M32 -check-prefix=MSVC2015 -check-prefix=M32MSVC2015 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O1 -mconstructor-aliases -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp -w -fms-compatibility-version=18.00 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MSC --check-prefix=M32 -check-prefix=MSVC2013 -check-prefix=M32MSVC2013 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc   -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O1 -mconstructor-aliases -disable-llvm-optzns -o - %s -w -fms-compatibility-version=18.00")./*|*/
      I("FileCheck --check-prefix=MSC --check-prefix=M32 -check-prefix=MSVC2013 -check-prefix=M32MSVC2013 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp -w -fms-compatibility-version=19.00 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MSC --check-prefix=M64 -check-prefix=MSVC2015 -check-prefix=M64MSVC2015 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O0 -o - %s -w -fms-compatibility-version=19.00")./*|*/
      I("FileCheck --check-prefix=MSC --check-prefix=M64 -check-prefix=MSVC2015 -check-prefix=M64MSVC2015 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp -w -fms-compatibility-version=18.00 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MSC --check-prefix=M64 -check-prefix=MSVC2013 -check-prefix=M64MSVC2013 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O0 -o - %s -w -fms-compatibility-version=18.00")./*|*/
      I("FileCheck --check-prefix=MSC --check-prefix=M64 -check-prefix=MSVC2013 -check-prefix=M64MSVC2013 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp -w | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU --check-prefix=G32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu    -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O0 -o - %s -w")./*|*/
      I("FileCheck --check-prefix=GNU --check-prefix=G32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-gnu -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp -w | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU --check-prefix=G64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-gnu  -emit-llvm -std=c++1y -fno-threadsafe-statics -fms-extensions -O0 -o - %s -w")./*|*/
      I("FileCheck --check-prefix=GNU --check-prefix=G64 %s");
  }

  @Test
  public void test_dllexport_alias_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-alias.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-gnu -mconstructor-aliases ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-alias.cpp -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-alias.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-gnu -mconstructor-aliases %s -S -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dllexport_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-compatibility -fms-compatibility-version=18 -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MSC --check-prefix=M32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc   -fms-compatibility -fms-compatibility-version=18 -emit-llvm -std=c++1y -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=MSC --check-prefix=M32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -fms-compatibility -fms-compatibility-version=18 -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MSC --check-prefix=M64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -fms-compatibility -fms-compatibility-version=18 -emit-llvm -std=c++1y -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=MSC --check-prefix=M64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-compatibility -fms-compatibility-version=19 -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=M32VS2015 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc   -fms-compatibility -fms-compatibility-version=19 -emit-llvm -std=c++1y -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=M32VS2015 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -fms-compatibility -fms-compatibility-version=19 -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=M64VS2015 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -fms-compatibility -fms-compatibility-version=19 -emit-llvm -std=c++1y -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=M64VS2015 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU --check-prefix=G32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu                       -emit-llvm -std=c++1y -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=GNU --check-prefix=G32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-gnu -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU --check-prefix=G64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-gnu                     -emit-llvm -std=c++1y -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=GNU --check-prefix=G64 %s");
  }

  @Test
  public void test_dllexport_ms_friend_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-ms-friend.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -fms-extensions -emit-llvm -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-ms-friend.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-ms-friend.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %ms_abi_triple -fms-extensions -emit-llvm -O0 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dllexport_pr26549_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-pr26549.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-pr26549.cpp -fms-extensions -triple x86_64-windows-msvc -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllexport-pr26549.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fms-extensions -triple x86_64-windows-msvc -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dllimport_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp -DMSABI -w | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MSC --check-prefix=M32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc   -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - %s -DMSABI -w")./*|*/
      I("FileCheck --check-prefix=MSC --check-prefix=M32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp -DMSABI -w | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MSC --check-prefix=M64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - %s -DMSABI -w")./*|*/
      I("FileCheck --check-prefix=MSC --check-prefix=M64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp -w | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU --check-prefix=G32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu    -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - %s         -w")./*|*/
      I("FileCheck --check-prefix=GNU --check-prefix=G32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-gnu -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp -w | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU --check-prefix=G64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-gnu  -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - %s         -w")./*|*/
      I("FileCheck --check-prefix=GNU --check-prefix=G64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fno-rtti -fno-threadsafe-statics -fms-extensions -fms-compatibility-version=18.00 -emit-llvm -std=c++1y -O1 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp -DMSABI -w | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MO1 --check-prefix=M18 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc   -fno-rtti -fno-threadsafe-statics -fms-extensions -fms-compatibility-version=18.00 -emit-llvm -std=c++1y -O1 -disable-llvm-optzns -o - %s -DMSABI -w")./*|*/
      I("FileCheck --check-prefix=MO1 --check-prefix=M18 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fno-rtti -fno-threadsafe-statics -fms-extensions -fms-compatibility-version=19.00 -emit-llvm -std=c++1y -O1 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp -DMSABI -w | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MO1 --check-prefix=M19 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc   -fno-rtti -fno-threadsafe-statics -fms-extensions -fms-compatibility-version=19.00 -emit-llvm -std=c++1y -O1 -disable-llvm-optzns -o - %s -DMSABI -w")./*|*/
      I("FileCheck --check-prefix=MO1 --check-prefix=M19 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O1 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp -w | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GO1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu    -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O1 -o - %s         -w")./*|*/
      I("FileCheck --check-prefix=GO1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp -DMSABI -w | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MSC2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc   -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - %s -DMSABI -w")./*|*/
      I("FileCheck --check-prefix=MSC2 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp -w | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu    -fno-rtti -fno-threadsafe-statics -fms-extensions -emit-llvm -std=c++1y -O0 -o - %s         -w")./*|*/
      I("FileCheck --check-prefix=GNU2 %s");
  }

  @Test
  public void test_dllimport_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-compatibility -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp -DMSABI | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MSC --check-prefix=M32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc -fms-compatibility   -emit-llvm -std=c++1y -O0 -o - %s -DMSABI")./*|*/
      I("FileCheck --check-prefix=MSC --check-prefix=M32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-msvc -fms-compatibility -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp -DMSABI | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MSC --check-prefix=M64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-msvc -fms-compatibility -emit-llvm -std=c++1y -O0 -o - %s -DMSABI")./*|*/
      I("FileCheck --check-prefix=MSC --check-prefix=M64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU --check-prefix=G32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu                       -emit-llvm -std=c++1y -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=GNU --check-prefix=G32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-windows-gnu -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GNU --check-prefix=G64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-windows-gnu                     -emit-llvm -std=c++1y -O0 -o - %s")./*|*/
      I("FileCheck --check-prefix=GNU --check-prefix=G64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-compatibility -emit-llvm -std=c++1y -O1 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp -DMSABI | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MO1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc -fms-compatibility   -emit-llvm -std=c++1y -O1 -o - %s -DMSABI")./*|*/
      I("FileCheck --check-prefix=MO1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -emit-llvm -std=c++1y -O1 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GO1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu                       -emit-llvm -std=c++1y -O1 -o - %s")./*|*/
      I("FileCheck --check-prefix=GO1 %s");
  }

  @Test
  public void test_dllimport_rtti_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-rtti.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -emit-llvm -std=c++1y -fms-extensions -O1 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-rtti.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-rtti.cpp --check-prefix=MSVC
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc -emit-llvm -std=c++1y -fms-extensions -O1 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s --check-prefix=MSVC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-gnu -emit-llvm -std=c++1y -fms-extensions -O1 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-rtti.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dllimport-rtti.cpp --check-prefix=GNU
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-gnu  -emit-llvm -std=c++1y -fms-extensions -O1 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s --check-prefix=GNU");
  }

  @Test
  public void test_duplicate_mangled_name_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/duplicate-mangled-name.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/duplicate-mangled-name.cpp -verify -DTEST1
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm-only %s -verify -DTEST1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/duplicate-mangled-name.cpp -verify -DTEST2 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/duplicate-mangled-name.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm-only %s -verify -DTEST2 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/duplicate-mangled-name.cpp -verify -DTEST3
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm-only %s -verify -DTEST3");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/duplicate-mangled-name.cpp -verify -DTEST4
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm-only %s -verify -DTEST4");
  }

  @Test
  public void test_dynamic_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic-cast.cpp -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic-cast.cpp
    RUN(TestState.Failed, "%clang_cc1 -I%S %s -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dynamic_cast_always_null_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic-cast-always-null.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic-cast-always-null.cpp -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -std=c++11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic-cast-always-null.cpp
    RUN(TestState.Failed, "%clang_cc1 -I%S %s -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -std=c++11 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dynamic_cast_hint_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic-cast-hint.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin12 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic-cast-hint.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic-cast-hint.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin12 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_dynamic_cast_no_rtti_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic_cast-no-rtti.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic_cast-no-rtti.cpp -verify -fno-rtti -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/dynamic_cast-no-rtti.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -verify -fno-rtti -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_eh_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh.cpp -o ${TEST_TEMP_DIR}/eh.cpp.tmp.ll
    RUN(TestState.Failed, "%clang_cc1 -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/eh.cpp.tmp.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh.cpp
    RUN(TestState.Failed, "FileCheck --input-file=%t.ll %s");
  }

  @Test
  public void test_eh_aggregate_copy_destroy_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh-aggregate-copy-destroy.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fexceptions -fcxx-exceptions -O0 -fno-elide-constructors -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh-aggregate-copy-destroy.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh-aggregate-copy-destroy.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fexceptions -fcxx-exceptions -O0 -fno-elide-constructors -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_eh_aggregated_inits_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh-aggregated-inits.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fexceptions -fcxx-exceptions -O0 -fno-elide-constructors -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh-aggregated-inits.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh-aggregated-inits.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -fexceptions -fcxx-exceptions -O0 -fno-elide-constructors -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_eh_aggregated_inits_unwind_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh-aggregated-inits-unwind.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fexceptions -fcxx-exceptions -O0 -fno-elide-constructors -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh-aggregated-inits-unwind.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eh-aggregated-inits-unwind.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -fexceptions -fcxx-exceptions -O0 -fno-elide-constructors -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_elide_call_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/elide-call-reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/elide-call-reference.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/elide-call-reference.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_empty_classes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/empty-classes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/empty-classes.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -triple=x86_64-apple-darwin10 -emit-llvm -O3 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/empty-classes.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -I%S -triple=x86_64-apple-darwin10 -emit-llvm -O3 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_empty_nontrivially_copyable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/empty-nontrivially-copyable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-ios -x c++ -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/empty-nontrivially-copyable.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/empty-nontrivially-copyable.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-ios -x c++ -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios -x c++ -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/empty-nontrivially-copyable.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/empty-nontrivially-copyable.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios -x c++ -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_empty_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/empty-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/empty-union.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s");
  }

  @Test
  public void test_enable_if_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/enable_if.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/enable_if.cpp -o - -triple=x86_64-pc-linux-gnu| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/enable_if.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-pc-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_enum_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/enum.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/enum.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -verify %s");
  }

  @Test
  public void test_eval_recursive_constant_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eval-recursive-constant.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/eval-recursive-constant.cpp -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only");
  }

  @Test
  public void test_exception_spec_decay_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exception-spec-decay.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exception-spec-decay.cpp -triple=i686-unknown-linux -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exception-spec-decay.cpp
    RUN(TestState.Failed, "%clang_cc1 -fcxx-exceptions -fexceptions %s -triple=i686-unknown-linux -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions.cpp -triple=x86_64-linux-gnu -emit-llvm -o - -fcxx-exceptions -fexceptions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-linux-gnu -emit-llvm -o - -fcxx-exceptions -fexceptions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exceptions_cxx_ehsc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-cxx-ehsc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-cxx-ehsc.cpp -o - -triple=i386-pc-win32 -fexceptions -fcxx-exceptions -fexternc-nounwind | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-cxx-ehsc.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32 -fexceptions -fcxx-exceptions -fexternc-nounwind")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exceptions_cxx_new_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-cxx-new.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-cxx-new.cpp -triple i686-pc-win32 -fms-extensions -fexceptions -fcxx-exceptions -emit-llvm -o - -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-cxx-new.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-win32 -fms-extensions -fexceptions -fcxx-exceptions -emit-llvm -o - -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exceptions_no_rtti_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-no-rtti.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-no-rtti.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-no-rtti.cpp
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -fcxx-exceptions -fexceptions %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exceptions_seh_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-seh.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fblocks -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-seh.cpp -triple=x86_64-windows-msvc -emit-llvm -o - -mconstructor-aliases -fcxx-exceptions -fexceptions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-seh.cpp --check-prefix=CHECK --check-prefix=CXXEH
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fblocks -fms-extensions %s -triple=x86_64-windows-msvc -emit-llvm -o - -mconstructor-aliases -fcxx-exceptions -fexceptions")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CXXEH");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fblocks -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-seh.cpp -triple=x86_64-windows-msvc -emit-llvm -o - -mconstructor-aliases -O1 -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-seh.cpp --check-prefix=CHECK --check-prefix=NOCXX
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fblocks -fms-extensions %s -triple=x86_64-windows-msvc -emit-llvm -o - -mconstructor-aliases -O1 -disable-llvm-optzns")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=NOCXX");
  }

  @Test
  public void test_exceptions_seh_filter_captures_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-seh-filter-captures.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fblocks -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-seh-filter-captures.cpp -triple=x86_64-windows-msvc -emit-llvm -o - -mconstructor-aliases -fcxx-exceptions -fexceptions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/exceptions-seh-filter-captures.cpp --check-prefix=CHECK --check-prefix=CXXEH
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fblocks -fms-extensions %s -triple=x86_64-windows-msvc -emit-llvm -o - -mconstructor-aliases -fcxx-exceptions -fexceptions")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CXXEH");
  }

  @Test
  public void test_explicit_instantiation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/explicit-instantiation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i686-pc-linux-gnu -std=c++1y -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/explicit-instantiation.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/explicit-instantiation.cpp --check-prefix=CHECK --check-prefix=CHECK-NO-OPT
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i686-pc-linux-gnu -std=c++1y -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-NO-OPT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i686-pc-linux-gnu -std=c++1y -O3 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/explicit-instantiation.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/explicit-instantiation.cpp --check-prefix=CHECK --check-prefix=CHECK-OPT
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i686-pc-linux-gnu -std=c++1y -O3 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-OPT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i686-pc-win32 -std=c++1y -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/explicit-instantiation.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/explicit-instantiation.cpp --check-prefix=CHECK-MS
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i686-pc-win32 -std=c++1y -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-MS");
  }

  @Test
  public void test_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -x c++ < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/expr.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -x c++ < %s");
  }

  @Test
  public void test_extern_c_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/extern-c.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/extern-c.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/extern-c.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fastcall_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/fastcall.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/fastcall.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/fastcall.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_field_access_debug_info_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/field-access-debug-info.cpp");
    // ${LLVM_SRC}/build/bin/clang -g -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/field-access-debug-info.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/field-access-debug-info.cpp
    RUN(TestState.Failed, "%clang -g -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_flatten_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/flatten.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-linux-gnu -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/flatten.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/flatten.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-linux-gnu -std=c++11 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_float128_declarations_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/float128-declarations.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple powerpc64-unknown-unknown -target-feature +float128 -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/float128-declarations.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/float128-declarations.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple powerpc64-unknown-unknown -target-feature +float128 -std=c++11 %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple powerpc64le-unknown-unknown -target-feature +float128 -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/float128-declarations.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/float128-declarations.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple powerpc64le-unknown-unknown -target-feature +float128 -std=c++11 %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-unknown-linux-gnu -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/float128-declarations.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/float128-declarations.cpp -check-prefix=CHECK-X86
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i386-unknown-linux-gnu -std=c++11 %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-X86");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-unknown-linux-gnu -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/float128-declarations.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/float128-declarations.cpp -check-prefix=CHECK-X86
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-unknown-linux-gnu -std=c++11 %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-X86");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple systemz-unknown-linux-gnu -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/float128-declarations.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/float128-declarations.cpp -check-prefix=CHECK-SYSZ
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple systemz-unknown-linux-gnu -std=c++11 %s -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-SYSZ");
  }

  @Test
  public void test_for_range_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range.cpp | opt -instnamer -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - %s")./*|*/
      I("opt -instnamer -S")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_for_range_temporaries_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -UDESUGAR ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp | opt -instnamer -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -UDESUGAR %s")./*|*/
      I("opt -instnamer -S")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -DDESUGAR ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp | opt -instnamer -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -DDESUGAR %s")./*|*/
      I("opt -instnamer -S")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -UDESUGAR -DTEMPLATE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp | opt -instnamer -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -UDESUGAR -DTEMPLATE %s")./*|*/
      I("opt -instnamer -S")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -DDESUGAR -DTEMPLATE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp | opt -instnamer -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -DDESUGAR -DTEMPLATE %s")./*|*/
      I("opt -instnamer -S")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -UDESUGAR -DTEMPLATE -DDEPENDENT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp | opt -instnamer -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -UDESUGAR -DTEMPLATE -DDEPENDENT %s")./*|*/
      I("opt -instnamer -S")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -DDESUGAR -DTEMPLATE -DDEPENDENT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp | opt -instnamer -S | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/for-range-temporaries.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - -DDESUGAR -DTEMPLATE -DDEPENDENT %s")./*|*/
      I("opt -instnamer -S")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_forward_enum_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/forward-enum.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin11.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/forward-enum.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/forward-enum.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin11.0.0 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fp16_mangle_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/fp16-mangle.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple arm-none-linux-gnueabi ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/fp16-mangle.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/fp16-mangle.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple arm-none-linux-gnueabi %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_fp16_overload_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/fp16-overload.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple arm-none-linux-gnueabi ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/fp16-overload.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/fp16-overload.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple arm-none-linux-gnueabi %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_friend_redecl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/friend-redecl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/friend-redecl.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/friend-redecl.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_funcattrs_global_ctor_dtor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/funcattrs-global-ctor-dtor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/funcattrs-global-ctor-dtor.cpp -triple x86_64-apple-darwin -S -stack-protector 2 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/funcattrs-global-ctor-dtor.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin -S -stack-protector 2 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_funcsig_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/funcsig.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i686-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/funcsig.cpp -fms-extensions -fno-rtti -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/funcsig.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple i686-pc-win32 %s -fms-extensions -fno-rtti -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_function_template_explicit_specialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/function-template-explicit-specialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/function-template-explicit-specialization.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/function-template-explicit-specialization.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_function_template_specialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/function-template-specialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/function-template-specialization.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/function-template-specialization.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_global_array_destruction_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-array-destruction.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-array-destruction.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-array-destruction.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_global_block_literal_helpers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-block-literal-helpers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm -fblocks -o - -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-block-literal-helpers.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-block-literal-helpers.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm -fblocks -o - -triple x86_64-apple-darwin10 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_global_dtor_no_atexit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-dtor-no-atexit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-dtor-no-atexit.cpp -fno-use-cxa-atexit -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-dtor-no-atexit.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64 %s -fno-use-cxa-atexit -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-dtor-no-atexit.cpp -fno-use-cxa-atexit -mconstructor-aliases -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-dtor-no-atexit.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64 %s -fno-use-cxa-atexit -mconstructor-aliases -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_global_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin10 -emit-llvm -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-init.cpp -o - |FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin10 -emit-llvm -fexceptions %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin10 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-init.cpp -o - |FileCheck -check-prefix CHECK-NOEXC ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin10 -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-NOEXC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin10 -emit-llvm -momit-leaf-frame-pointer -mdisable-fp-elim ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-init.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-FP ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin10 -emit-llvm -momit-leaf-frame-pointer -mdisable-fp-elim %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-FP %s");
  }

  @Test
  public void test_global_init_darwin_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-init-darwin.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin10 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-init-darwin.cpp -o - |FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-init-darwin.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin10 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_global_llvm_constant_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-llvm-constant.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-llvm-constant.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/global-llvm-constant.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_globalinit_loc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/globalinit-loc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/globalinit-loc.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/globalinit-loc.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_goto_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/goto.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/goto.cpp -triple=x86_64-apple-darwin10 -fcxx-exceptions -fexceptions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/goto.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -fcxx-exceptions -fexceptions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_homogeneous_aggregates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/homogeneous-aggregates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/homogeneous-aggregates.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/homogeneous-aggregates.cpp --check-prefix=PPC
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64le-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=PPC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -mfloat-abi hard -triple armv7-unknown-linux-gnueabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/homogeneous-aggregates.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/homogeneous-aggregates.cpp --check-prefix=ARM32
    RUN(TestState.Failed, "%clang_cc1 -mfloat-abi hard -triple armv7-unknown-linux-gnueabi -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=ARM32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -mfloat-abi hard -triple aarch64-unknown-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/homogeneous-aggregates.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/homogeneous-aggregates.cpp --check-prefix=ARM64
    RUN(TestState.Failed, "%clang_cc1 -mfloat-abi hard -triple aarch64-unknown-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=ARM64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -mfloat-abi hard -triple x86_64-unknown-windows-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/homogeneous-aggregates.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/homogeneous-aggregates.cpp --check-prefix=X64
    RUN(TestState.Failed, "%clang_cc1 -mfloat-abi hard -triple x86_64-unknown-windows-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=X64");
  }

  @Test
  public void test_implicit_copy_assign_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/implicit-copy-assign-operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin10.0.0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/implicit-copy-assign-operator.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/implicit-copy-assign-operator.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin10.0.0 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_implicit_copy_constructor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/implicit-copy-constructor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/implicit-copy-constructor.cpp -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/implicit-copy-constructor.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_implicit_instantiation_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/implicit-instantiation-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/implicit-instantiation-1.cpp -o ${TEST_TEMP_DIR}/implicit-instantiation-1.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple %s -o %t");
    // grep linkonce_odr.*_ZN1XIiE1fEi ${TEST_TEMP_DIR}/implicit-instantiation-1.cpp.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep \"linkonce_odr.*_ZN1XIiE1fEi\" %t")./*|*/
      I("count 1");
    // grep linkonce_odr.*_ZN1XIiE1gEi ${TEST_TEMP_DIR}/implicit-instantiation-1.cpp.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep \"linkonce_odr.*_ZN1XIiE1gEi\" %t")./*|*/
      I("count 1");
    // grep linkonce_odr.*_ZN1XIfE1fEf ${TEST_TEMP_DIR}/implicit-instantiation-1.cpp.tmp | ${LLVM_SRC}/build/bin/count 1
    RUN(TestState.Failed, "grep \"linkonce_odr.*_ZN1XIfE1fEf\" %t")./*|*/
      I("count 1");
    // grep linkonce_odr.*_ZN1XIfE1hEf ${TEST_TEMP_DIR}/implicit-instantiation-1.cpp.tmp
    RUN(TestState.Failed, "not grep \"linkonce_odr.*_ZN1XIfE1hEf\" %t");
  }

  @Test
  public void test_implicit_record_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/implicit-record-visibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/implicit-record-visibility.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -fvisibility hidden -triple x86_64-linux-gnu -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/implicit-record-visibility.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -I%S -fvisibility hidden -triple x86_64-linux-gnu -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_incomplete_member_function_pointer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/incomplete-member-function-pointer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/incomplete-member-function-pointer.cpp -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only");
  }

  @Test
  public void test_incomplete_types_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/incomplete-types.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/incomplete-types.cpp -emit-llvm-only -verify
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only -verify");
  }

  @Test
  public void test_inheriting_constructor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inheriting-constructor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inheriting-constructor.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inheriting-constructor.cpp --check-prefix=CHECK --check-prefix=ITANIUM
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple i386-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=ITANIUM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inheriting-constructor.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inheriting-constructor.cpp --check-prefix=CHECK --check-prefix=ITANIUM
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=ITANIUM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple arm64-ehabi -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inheriting-constructor.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inheriting-constructor.cpp --check-prefix=CHECK --check-prefix=ITANIUM
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple arm64-ehabi -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=ITANIUM");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-windows -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inheriting-constructor.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inheriting-constructor.cpp --check-prefix=CHECK --check-prefix=MSABI --check-prefix=WIN32
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple i386-windows -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=MSABI --check-prefix=WIN32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-windows -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inheriting-constructor.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inheriting-constructor.cpp --check-prefix=CHECK --check-prefix=MSABI --check-prefix=WIN64
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-windows -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=MSABI --check-prefix=WIN64");
  }

  @Test
  public void test_init_invariant_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/init-invariant.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/init-invariant.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/init-invariant.cpp --check-prefix=CHECK-O0
    RUN(TestState.Failed, "%clang_cc1 -triple i686-linux-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-O0");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/init-invariant.cpp -O1 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/init-invariant.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-linux-gnu -emit-llvm %s -O1 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_init_priority_attr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/init-priority-attr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/init-priority-attr.cpp -triple x86_64-apple-darwin10 -O2 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/init-priority-attr.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -O2 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_inline_dllexport_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-dllexport-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-win32 -fms-extensions -debug-info-kind=limited -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-dllexport-member.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-dllexport-member.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-win32 -fms-extensions -debug-info-kind=limited -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_inline_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-functions.cpp -std=c++11 -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-functions.cpp --check-prefix=CHECK --check-prefix=NORMAL
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=NORMAL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-functions.cpp -std=c++11 -fms-compatibility -triple=x86_64-pc-win32 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-functions.cpp --check-prefix=CHECK --check-prefix=MSVCCOMPAT
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -fms-compatibility -triple=x86_64-pc-win32 -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=MSVCCOMPAT");
  }

  @Test
  public void test_inline_hint_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-hint.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-hint.cpp -std=c++11 -triple=x86_64-linux -finline-functions -emit-llvm -disable-llvm-optzns -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-hint.cpp --check-prefix=CHECK --check-prefix=SUITABLE
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-linux -finline-functions -emit-llvm -disable-llvm-optzns -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=SUITABLE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-hint.cpp -std=c++11 -triple=x86_64-linux -finline-hint-functions -emit-llvm -disable-llvm-optzns -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-hint.cpp --check-prefix=CHECK --check-prefix=HINTED
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-linux -finline-hint-functions -emit-llvm -disable-llvm-optzns -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=HINTED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-hint.cpp -std=c++11 -triple=x86_64-linux -fno-inline -emit-llvm -disable-llvm-optzns -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/inline-hint.cpp --check-prefix=CHECK --check-prefix=NOINLINE
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-linux -fno-inline -emit-llvm -disable-llvm-optzns -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=NOINLINE");
  }

  @Test
  public void test_instantiate_blocks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/instantiate-blocks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/instantiate-blocks.cpp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -emit-llvm -o - %s");
  }

  @Test
  public void test_instantiate_init_list_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/instantiate-init-list.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/instantiate-init-list.cpp -emit-llvm-only -verify
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only -verify");
  }

  @Test
  public void test_instantiate_temporaries_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/instantiate-temporaries.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.7.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/instantiate-temporaries.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/instantiate-temporaries.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.7.0 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_instrument_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/instrument-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -S -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/instrument-functions.cpp -finstrument-functions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/instrument-functions.cpp
    RUN(TestState.Failed, "%clang_cc1 -S -emit-llvm -triple %itanium_abi_triple -o - %s -finstrument-functions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_int64_uint64_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/int64_uint64.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-linux-guneabi -target-cpu cortex-a8 -emit-llvm -w -O1 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/int64_uint64.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-ARM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/int64_uint64.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm-linux-guneabi -target-cpu cortex-a8 -emit-llvm -w -O1 -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-ARM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-linux-gnueabi -target-feature +neon -emit-llvm -w -O1 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/int64_uint64.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-AARCH64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/int64_uint64.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-linux-gnueabi -target-feature +neon -emit-llvm -w -O1 -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-AARCH64 %s");
  }

  @Test
  public void test_internal_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/internal-linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/internal-linkage.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/internal-linkage.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_invalid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/invalid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -g -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/invalid.cpp
    RUN(TestState.Failed, "not %clang_cc1 -g -emit-llvm %s");
  }

  @Test
  public void test_invariant_group_for_vptrs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/invariant.group-for-vptrs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-pc-linux-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/invariant.group-for-vptrs.cpp -fstrict-vtable-pointers -O1 -o - -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/invariant.group-for-vptrs.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-pc-linux-gnu -emit-llvm %s -fstrict-vtable-pointers -O1 -o - -disable-llvm-optzns")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_key_function_vtable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/key-function-vtable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-none-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/key-function-vtable.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/key-function-vtable.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-none-linux-gnu %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/key-function-vtable.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/key-function-vtable.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_lambda_expressions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lambda-expressions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lambda-expressions.cpp -fexceptions -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lambda-expressions.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10.0.0 -fblocks -emit-llvm -o - %s -fexceptions -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_lambda_expressions_inside_auto_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lambda-expressions-inside-auto-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lambda-expressions-inside-auto-functions.cpp -fexceptions -std=c++1y | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lambda-expressions-inside-auto-functions.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10.0.0 -fblocks -emit-llvm -o - %s -fexceptions -std=c++1y")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_lambda_expressions_nested_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lambda-expressions-nested-linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lambda-expressions-nested-linkage.cpp -fexceptions -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lambda-expressions-nested-linkage.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10.0.0 -fblocks -emit-llvm -o - %s -fexceptions -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_linetable_cleanup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-cleanup.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-cleanup.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-cleanup.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin10 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_linetable_eh_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-eh.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited -triple x86_64-apple-macosx10.9.0 -munwind-tables -std=c++11 -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-eh.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-eh.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited -triple x86_64-apple-macosx10.9.0 -munwind-tables -std=c++11 -fcxx-exceptions -fexceptions %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_linetable_fnbegin_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-fnbegin.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -debug-info-kind=limited ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-fnbegin.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-fnbegin.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -debug-info-kind=limited %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_linetable_virtual_variadic_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-virtual-variadic.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -debug-info-kind=line-tables-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-virtual-variadic.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linetable-virtual-variadic.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -debug-info-kind=line-tables-only %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -std=c++11 -O1 -disable-llvm-optzns ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linkage.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/linkage.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -std=c++11 -O1 -disable-llvm-optzns %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_lpad_linetable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lpad-linetable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lpad-linetable.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lpad-linetable.cpp
    RUN(TestState.Failed, "%clang_cc1  -fcxx-exceptions -fexceptions -emit-llvm -debug-info-kind=limited -triple x86_64-apple-darwin10 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_lto_visibility_inference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lto-visibility-inference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-unknown-linux -std=c++11 -fms-extensions -fvisibility hidden -fwhole-program-vtables -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lto-visibility-inference.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=ITANIUM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lto-visibility-inference.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-unknown-linux -std=c++11 -fms-extensions -fvisibility hidden -fwhole-program-vtables -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=ITANIUM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-pc-windows-msvc -std=c++11 -fms-extensions -fwhole-program-vtables -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lto-visibility-inference.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MS --check-prefix=MS-STD ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lto-visibility-inference.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-pc-windows-msvc -std=c++11 -fms-extensions -fwhole-program-vtables -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=MS --check-prefix=MS-STD %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-pc-windows-msvc -std=c++11 -fms-extensions -fwhole-program-vtables -flto-visibility-public-std -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lto-visibility-inference.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MS --check-prefix=MS-NOSTD ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lto-visibility-inference.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-pc-windows-msvc -std=c++11 -fms-extensions -fwhole-program-vtables -flto-visibility-public-std -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=MS --check-prefix=MS-NOSTD %s");
  }

  @Test
  public void test_lvalue_bitcasts_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lvalue-bitcasts.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lvalue-bitcasts.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/lvalue-bitcasts.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_m64_ptr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/m64-ptr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/m64-ptr.cpp -emit-llvm -triple x86_64-apple-darwin -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/m64-ptr.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple x86_64-apple-darwin -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_main_norecurse_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/main-norecurse.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/main-norecurse.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/main-norecurse.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle.cpp -o - -triple=x86_64-apple-darwin9 -fblocks -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin9 -fblocks -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_98_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-98.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-98.cpp -o - -triple=x86_64-apple-darwin9 -std=c++98 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-98.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin9 -std=c++98")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_abi_examples_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-examples.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-examples.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-examples.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_abi_tag_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-tag.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-tag.cpp -emit-llvm -triple i386-pc-solaris2.11 -std=c++11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-tag.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -std=c++11 -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-tag.cpp -emit-llvm -triple i686-linux-gnu -std=c++11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-tag.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple i686-linux-gnu -std=c++11 -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-tag.cpp -emit-llvm -triple x86_64-linux-gnu -std=c++11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-tag.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple x86_64-linux-gnu -std=c++11 -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-tag.cpp -emit-llvm -triple powerpc64le-unknown-linux-gnu -std=c++11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-abi-tag.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple powerpc64le-unknown-linux-gnu -std=c++11 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_address_space_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-address-space.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-address-space.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-address-space.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_alias_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-alias-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-alias-template.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-alias-template.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_exprs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-exprs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-exprs.cpp -o - -triple=x86_64-apple-darwin9 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-exprs.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -triple=x86_64-apple-darwin9")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_extern_local_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-extern-local.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-extern-local.cpp -triple i386-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-extern-local.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_extreme_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-extreme.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-extreme.cpp -o - -triple=x86_64-apple-darwin9 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-extreme.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin9")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_fail_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-fail.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -x c++ -std=c++11 -triple i386-pc-solaris2.11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-fail.cpp -DN=1
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -x c++ -std=c++11 -triple %itanium_abi_triple -verify %s -DN=1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -x c++ -std=c++11 -triple i386-pc-solaris2.11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-fail.cpp -DN=2
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -x c++ -std=c++11 -triple %itanium_abi_triple -verify %s -DN=2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -x c++ -std=c++11 -triple i386-pc-solaris2.11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-fail.cpp -DN=3
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -x c++ -std=c++11 -triple %itanium_abi_triple -verify %s -DN=3");
  }

  @Test
  public void test_mangle_lambdas_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-lambdas.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-macosx10.7.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-lambdas.cpp -w | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-lambdas.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-macosx10.7.0 -emit-llvm -o - %s -w")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_literal_suffix_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-literal-suffix.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mips-none-none -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-literal-suffix.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-literal-suffix.cpp -check-prefix=CHECK -check-prefix=FP64
    RUN(TestState.Failed, "%clang_cc1 -triple mips-none-none -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=FP64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-none-none -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-literal-suffix.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-literal-suffix.cpp -check-prefix=CHECK -check-prefix=FP128
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-none-none -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=FP128");
  }

  @Test
  public void test_mangle_local_anonymous_unions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-anonymous-unions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-anonymous-unions.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-anonymous-unions.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_local_class_names_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-class-names.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-class-names.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-class-names.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_local_class_vtables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-class-vtables.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-class-vtables.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-class-vtables.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_local_classes_nested_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-classes-nested.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-classes-nested.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-local-classes-nested.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_long_double_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-long-double.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-unknown-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-long-double.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-long-double.cpp --check-prefix=POWER64-LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-unknown-linux-gnu %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=POWER64-LINUX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-unknown-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-long-double.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-long-double.cpp --check-prefix=POWER-LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-unknown-linux-gnu   %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=POWER-LINUX");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-long-double.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-long-double.cpp --check-prefix=POWER64-DARWIN
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc64-apple-darwin9     %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=POWER64-DARWIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc-apple-darwin9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-long-double.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-long-double.cpp --check-prefix=POWER-DARWIN
    RUN(TestState.Failed, "%clang_cc1 -triple powerpc-apple-darwin9       %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=POWER-DARWIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple s390x-unknown-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-long-double.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-long-double.cpp --check-prefix=S390X-LINUX
    RUN(TestState.Failed, "%clang_cc1 -triple s390x-unknown-linux-gnu     %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=S390X-LINUX");
  }

  @Test
  public void test_mangle_ms_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms.cpp -o - -triple=i386-pc-win32 -std=c++98 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms.cpp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -emit-llvm %s -o - -triple=i386-pc-win32 -std=c++98")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms.cpp -o - -triple=x86_64-pc-win32 -std=c++98| ${LLVM_SRC}/build/bin/FileCheck -check-prefix X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms.cpp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -emit-llvm %s -o - -triple=x86_64-pc-win32 -std=c++98")./*|*/
      I("FileCheck -check-prefix X64 %s");
  }

  @Test
  public void test_mangle_ms_abi_examples_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-abi-examples.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-abi-examples.cpp -o - -triple=i386-pc-win32 -fms-compatibility-version=19.00 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-abi-examples.cpp --check-prefix=CHECK --check-prefix=MSVC2015
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -fno-rtti -emit-llvm %s -o - -triple=i386-pc-win32 -fms-compatibility-version=19.00")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=MSVC2015");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-abi-examples.cpp -o - -triple=i386-pc-win32 -fms-compatibility-version=18.00 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-abi-examples.cpp --check-prefix=CHECK --check-prefix=MSVC2013
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -fno-rtti -emit-llvm %s -o - -triple=i386-pc-win32 -fms-compatibility-version=18.00")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=MSVC2013");
  }

  @Test
  public void test_mangle_ms_arg_qualifiers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-arg-qualifiers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-arg-qualifiers.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-arg-qualifiers.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-arg-qualifiers.cpp -o - -triple=x86_64-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-arg-qualifiers.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-pc-win32")./*|*/
      I("FileCheck -check-prefix=X64 %s");
  }

  @Test
  public void test_mangle_ms_back_references_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-back-references.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-back-references.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-back-references.cpp
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -fblocks -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_ms_back_references_pr13207_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-back-references-pr13207.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-back-references-pr13207.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-back-references-pr13207.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_ms_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fms-extensions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-cxx11.cpp -o - -triple=i386-pc-win32 -fms-compatibility-version=19.00 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-cxx11.cpp --check-prefix=CHECK --check-prefix=MSVC2015
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fms-extensions -emit-llvm %s -o - -triple=i386-pc-win32 -fms-compatibility-version=19.00")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=MSVC2015");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fms-extensions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-cxx11.cpp -o - -triple=i386-pc-win32 -fms-compatibility-version=18.00 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-cxx11.cpp --check-prefix=CHECK --check-prefix=MSVC2013
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fms-extensions -emit-llvm %s -o - -triple=i386-pc-win32 -fms-compatibility-version=18.00")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=MSVC2013");
  }

  @Test
  public void test_mangle_ms_cxx14_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-cxx14.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -fms-extensions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-cxx14.cpp -o - -triple=i386-pc-win32 -fms-compatibility-version=19.00 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-cxx14.cpp --check-prefix=CHECK --check-prefix=MSVC2015
    RUN(TestState.Failed, "%clang_cc1 -std=c++1y -fms-extensions -emit-llvm %s -o - -triple=i386-pc-win32 -fms-compatibility-version=19.00")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=MSVC2015");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -fms-extensions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-cxx14.cpp -o - -triple=i386-pc-win32 -fms-compatibility-version=18.00 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-cxx14.cpp --check-prefix=CHECK --check-prefix=MSVC2013
    RUN(TestState.Failed, "%clang_cc1 -std=c++1y -fms-extensions -emit-llvm %s -o - -triple=i386-pc-win32 -fms-compatibility-version=18.00")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=MSVC2013");
  }

  @Test
  public void test_mangle_ms_md5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-md5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple i686-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-md5.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-md5.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple i686-pc-win32 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_ms_return_qualifiers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-return-qualifiers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-return-qualifiers.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-return-qualifiers.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_ms_string_literals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-string-literals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-string-literals.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-string-literals.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-string-literals.cpp -o - -triple=x86_64-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-string-literals.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++11 -emit-llvm %s -o - -triple=x86_64-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_ms_template_callback_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-template-callback.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-template-callback.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-template-callback.cpp
    RUN(TestState.Failed, "%clang_cc1 -fblocks -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_ms_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-templates.cpp -o - -fms-extensions -fdelayed-template-parsing -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -fms-extensions -fdelayed-template-parsing -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-templates.cpp -o - -fms-extensions -fdelayed-template-parsing -triple=x86_64-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -fms-extensions -fdelayed-template-parsing -triple=x86_64-pc-win32")./*|*/
      I("FileCheck -check-prefix X64 %s");
  }

  @Test
  public void test_mangle_ms_templates_memptrs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-templates-memptrs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-microsoft -fno-rtti -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-templates-memptrs.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-templates-memptrs.cpp
    RUN(TestState.Failed, "%clang_cc1 -Wno-microsoft -fno-rtti -std=c++11 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_ms_templates_memptrs_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-templates-memptrs-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-microsoft -fms-extensions -fno-rtti -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-templates-memptrs-2.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-templates-memptrs-2.cpp
    RUN(TestState.Failed, "%clang_cc1 -Wno-microsoft -fms-extensions -fno-rtti -std=c++11 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_ms_vector_types_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-vector-types.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -ffreestanding -target-feature +avx -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-vector-types.cpp -o - -triple=i686-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ms-vector-types.cpp
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -ffreestanding -target-feature +avx -emit-llvm %s -o - -triple=i686-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_neon_vectors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-neon-vectors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-ios -target-feature +neon ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-neon-vectors.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-neon-vectors.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-ios -target-feature +neon  %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios -target-feature +neon ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-neon-vectors.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-neon-vectors.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios -target-feature +neon %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-linux-gnu -target-feature +neon ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-neon-vectors.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-neon-vectors.cpp --check-prefix=CHECK-AARCH64
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-linux-gnu -target-feature +neon %s -emit-llvm -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-AARCH64");
  }

  @Test
  public void test_mangle_nullptr_arg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-nullptr-arg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-nullptr-arg.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-nullptr-arg.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_ref_qualifiers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ref-qualifiers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ref-qualifiers.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-ref-qualifiers.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_std_externc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-std-externc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-std-externc.cpp -DNS=std -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-std-externc.cpp --check-prefix=CHECK-STD
    RUN(TestState.Failed, "%clang_cc1 %s -DNS=std -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-STD");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-std-externc.cpp -DNS=n -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-std-externc.cpp --check-prefix=CHECK-N
    RUN(TestState.Failed, "%clang_cc1 %s -DNS=n -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK-N");
  }

  @Test
  public void test_mangle_subst_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-subst.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-subst.cpp -o - -triple=x86_64-apple-darwin9 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-subst.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin9")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_subst_std_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-subst-std.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-subst-std.cpp -o - -triple=x86_64-apple-darwin9 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-subst-std.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin9")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_system_header_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-system-header.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-system-header.cpp -o - -triple=x86_64-apple-darwin9 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-system-header.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin9")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -Wno-return-type -Wno-main -std=c++11 -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-template.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-template.cpp
    RUN(TestState.Failed, "%clang_cc1 -verify -Wno-return-type -Wno-main -std=c++11 -emit-llvm -triple %itanium_abi_triple -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_this_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-this-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-this-cxx11.cpp -o - -triple=x86_64-apple-darwin9 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-this-cxx11.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -triple=x86_64-apple-darwin9")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_unnameable_conversions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-unnameable-conversions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-unnameable-conversions.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-unnameable-conversions.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_unnamed_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-unnamed.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-unnamed.cpp -o - -triple=x86_64-apple-darwin10 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-unnamed.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin10")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_valist_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-valist.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-valist.cpp -emit-llvm -o - -triple armv7-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MANGLE-ARM-AAPCS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-valist.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple armv7-unknown-linux")./*|*/
      I("FileCheck -check-prefix=CHECK-MANGLE-ARM-AAPCS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-valist.cpp -emit-llvm -o - -triple armv7-unknown-linux -target-abi apcs-gnu | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MANGLE-ARM-APCS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-valist.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple armv7-unknown-linux -target-abi apcs-gnu")./*|*/
      I("FileCheck -check-prefix=CHECK-MANGLE-ARM-APCS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-valist.cpp -emit-llvm -o - -triple mipsel-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MANGLE-MIPSEL ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-valist.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple mipsel-unknown-linux")./*|*/
      I("FileCheck -check-prefix=CHECK-MANGLE-MIPSEL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-valist.cpp -emit-llvm -o - -triple i686-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MANGLE-X86 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-valist.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple i686-unknown-linux")./*|*/
      I("FileCheck -check-prefix=CHECK-MANGLE-X86 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-valist.cpp -emit-llvm -o - -triple x86_64-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MANGLE-X86-64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-valist.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple x86_64-unknown-linux")./*|*/
      I("FileCheck -check-prefix=CHECK-MANGLE-X86-64 %s");
  }

  @Test
  public void test_mangle_variadic_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-variadic-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm -triple=x86_64-apple-darwin9 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-variadic-templates.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-variadic-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm -triple=x86_64-apple-darwin9 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_windows_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-windows.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-windows.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=WIN ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-windows.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck --check-prefix=WIN %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-windows.cpp -o - -triple=i386-mingw32 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=ITANIUM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mangle-windows.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-mingw32")./*|*/
      I("FileCheck --check-prefix=ITANIUM %s");
  }

  @Test
  public void test_member_alignment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-alignment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-alignment.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-ITANIUM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-alignment.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-ITANIUM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple wasm32-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-alignment.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-WEBASSEMBLY32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-alignment.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple wasm32-unknown-unknown %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-WEBASSEMBLY32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple wasm64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-alignment.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-WEBASSEMBLY64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-alignment.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple wasm64-unknown-unknown %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-WEBASSEMBLY64 %s");
  }

  @Test
  public void test_member_call_parens_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-call-parens.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-call-parens.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -verify %s");
  }

  @Test
  public void test_member_data_pointers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-data-pointers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-data-pointers.cpp -emit-llvm -o - -triple=x86_64-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix GLOBAL-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-data-pointers.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=x86_64-unknown-unknown")./*|*/
      I("FileCheck -check-prefix GLOBAL-LP64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-data-pointers.cpp -emit-llvm -o - -triple=armv7-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix GLOBAL-LP32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-data-pointers.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=armv7-unknown-unknown")./*|*/
      I("FileCheck -check-prefix GLOBAL-LP32 %s");
  }

  @Test
  public void test_member_expressions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-expressions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-expressions.cpp -o - -triple=x86_64-apple-darwin10 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-expressions.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin10")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_member_function_pointer_calls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointer-calls.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointer-calls.cpp -triple=x86_64-apple-darwin10 -emit-llvm -O3 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointer-calls.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -O3 -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointer-calls.cpp -triple=x86_64-windows-gnu -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointer-calls.cpp -check-prefix MINGW64
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-windows-gnu -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix MINGW64");
  }

  @Test
  public void test_member_function_pointers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp -emit-llvm -o - -triple=x86_64-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CODE-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=x86_64-unknown-unknown")./*|*/
      I("FileCheck -check-prefix CODE-LP64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp -emit-llvm -o - -triple=i386-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CODE-LP32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=i386-unknown-unknown")./*|*/
      I("FileCheck -check-prefix CODE-LP32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp -emit-llvm -o - -triple=x86_64-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix GLOBAL-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=x86_64-unknown-unknown")./*|*/
      I("FileCheck -check-prefix GLOBAL-LP64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp -emit-llvm -o - -triple=i386-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix GLOBAL-LP32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=i386-unknown-unknown")./*|*/
      I("FileCheck -check-prefix GLOBAL-LP32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp -emit-llvm -o - -triple=armv7-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix GLOBAL-ARM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=armv7-unknown-unknown")./*|*/
      I("FileCheck -check-prefix GLOBAL-ARM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp -emit-llvm -o - -triple=le32-unknown-nacl | ${LLVM_SRC}/build/bin/FileCheck -check-prefix GLOBAL-ARM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=le32-unknown-nacl")./*|*/
      I("FileCheck -check-prefix GLOBAL-ARM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp -emit-llvm -o - -triple=mips-unknown-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck -check-prefix GLOBAL-ARM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=mips-unknown-linux-gnu")./*|*/
      I("FileCheck -check-prefix GLOBAL-ARM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp -emit-llvm -o - -triple=wasm32-unknown-unknown | ${LLVM_SRC}/build/bin/FileCheck -check-prefix GLOBAL-ARM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-function-pointers.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple=wasm32-unknown-unknown")./*|*/
      I("FileCheck -check-prefix GLOBAL-ARM %s");
  }

  @Test
  public void test_member_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin9 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-functions.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-functions.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin9 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_member_init_anon_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-init-anon-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-init-anon-union.cpp -std=c++11 -triple x86_64-linux-gnu -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-init-anon-union.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple x86_64-linux-gnu -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_member_init_assignment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-init-assignment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-init-assignment.cpp -triple i386-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-init-assignment.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_member_init_struct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-init-struct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-init-struct.cpp -emit-llvm-only -verify
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only -verify");
  }

  @Test
  public void test_member_init_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-init-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-init-union.cpp -emit-llvm-only -verify
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only -verify");
  }

  @Test
  public void test_member_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-templates.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/member-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_merge_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/merge-functions.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux-gnu -O1 -fmerge-functions -emit-llvm -o - -x c++ < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/merge-functions.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/merge-functions.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux-gnu -O1 -fmerge-functions -emit-llvm -o - -x c++ < %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_alignment_fail_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-alignment-fail.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm -triple=i686-pc-win32 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-alignment-fail.cpp 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-alignment-fail.cpp
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -emit-llvm -triple=i686-pc-win32 -o - %s  2>/dev/null")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm -triple=x86_64-pc-win32 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-alignment-fail.cpp 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-alignment-fail.cpp -check-prefix CHECK-X64
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -emit-llvm -triple=x86_64-pc-win32 -o - %s  2>/dev/null")./*|*/
      I("FileCheck %s -check-prefix CHECK-X64");
  }

  @Test
  public void test_microsoft_abi_arg_order_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-arg-order.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -mconstructor-aliases -std=c++11 -fexceptions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-arg-order.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-arg-order.cpp -check-prefix=X86
    RUN(TestState.Failed, "%clang_cc1 -mconstructor-aliases -std=c++11 -fexceptions -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s -check-prefix=X86");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -mconstructor-aliases -std=c++11 -fexceptions -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-arg-order.cpp -o - -triple=x86_64-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-arg-order.cpp -check-prefix=X64
    RUN(TestState.Failed, "%clang_cc1 -mconstructor-aliases -std=c++11 -fexceptions -emit-llvm %s -o - -triple=x86_64-pc-win32")./*|*/
      I("FileCheck %s -check-prefix=X64");
  }

  @Test
  public void test_microsoft_abi_array_cookies_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-array-cookies.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-array-cookies.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-array-cookies.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_byval_sret_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-byval-sret.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-byval-sret.cpp -o - -triple=i686-pc-win32 -mconstructor-aliases -fno-rtti | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-byval-sret.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i686-pc-win32 -mconstructor-aliases -fno-rtti")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_byval_thunks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-byval-thunks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-byval-thunks.cpp -fno-rtti -triple=i686-pc-win32 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-byval-thunks.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=i686-pc-win32 -emit-llvm -o -")./*|*/
      I("FileCheck --check-prefix=CHECK32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-byval-thunks.cpp -fno-rtti -triple=x86_64-pc-win32 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-byval-thunks.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=x86_64-pc-win32 -emit-llvm -o -")./*|*/
      I("FileCheck --check-prefix=CHECK64 %s");
  }

  @Test
  public void test_microsoft_abi_byval_vararg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-byval-vararg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-non-pod-varargs -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-byval-vararg.cpp -o - -triple=i686-pc-win32 -mconstructor-aliases -fno-rtti | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-byval-vararg.cpp
    RUN(TestState.Failed, "%clang_cc1 -Wno-non-pod-varargs -emit-llvm %s -o - -triple=i686-pc-win32 -mconstructor-aliases -fno-rtti")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_cdecl_method_sret_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-cdecl-method-sret.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-cdecl-method-sret.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-cdecl-method-sret.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-win32 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_constexpr_vs_inheritance_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-constexpr-vs-inheritance.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-constexpr-vs-inheritance.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-constexpr-vs-inheritance.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fno-rtti -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_default_cc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-default-cc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-linux -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-default-cc.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix GCABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-default-cc.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-linux -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix GCABI %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-default-cc.cpp -o - -DMS_ABI -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix MSABI ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-default-cc.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -DMS_ABI -triple=i386-pc-win32")./*|*/
      I("FileCheck -check-prefix MSABI %s");
  }

  @Test
  public void test_microsoft_abi_dynamic_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-dynamic-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -O1 -o - -fexceptions -triple=i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-dynamic-cast.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-dynamic-cast.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -O1 -o - -fexceptions -triple=i386-pc-win32 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_eh_catch_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-catch.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-catch.cpp -o - -triple=x86_64-pc-windows-msvc -mconstructor-aliases -fexceptions -fcxx-exceptions -O1 -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck -check-prefix WIN64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-catch.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -triple=x86_64-pc-windows-msvc -mconstructor-aliases -fexceptions -fcxx-exceptions -O1 -disable-llvm-optzns")./*|*/
      I("FileCheck -check-prefix WIN64 %s");
  }

  @Test
  public void test_microsoft_abi_eh_cleanups_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-cleanups.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-cleanups.cpp -o - -triple=i386-pc-win32 -mconstructor-aliases -fexceptions -fcxx-exceptions -fno-rtti | ${LLVM_SRC}/build/bin/FileCheck -check-prefix WIN32 -check-prefix WIN32-O0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-cleanups.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -triple=i386-pc-win32 -mconstructor-aliases -fexceptions -fcxx-exceptions -fno-rtti")./*|*/
      I("FileCheck -check-prefix WIN32 -check-prefix WIN32-O0 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm -O3 -disable-llvm-optzns ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-cleanups.cpp -o - -triple=i386-pc-win32 -mconstructor-aliases -fexceptions -fcxx-exceptions -fno-rtti | ${LLVM_SRC}/build/bin/FileCheck -check-prefix WIN32 -check-prefix WIN32-O3 -check-prefix WIN32-LIFETIME ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-cleanups.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm -O3 -disable-llvm-optzns %s -o - -triple=i386-pc-win32 -mconstructor-aliases -fexceptions -fcxx-exceptions -fno-rtti")./*|*/
      I("FileCheck -check-prefix WIN32 -check-prefix WIN32-O3 -check-prefix WIN32-LIFETIME %s");
  }

  @Test
  public void test_microsoft_abi_eh_terminate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-terminate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-terminate.cpp -o - -triple=x86_64-pc-windows-msvc -mconstructor-aliases -fexceptions -fcxx-exceptions -fms-compatibility-version=18.00 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=MSVC2013 -check-prefix=CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-terminate.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -triple=x86_64-pc-windows-msvc -mconstructor-aliases -fexceptions -fcxx-exceptions -fms-compatibility-version=18.00")./*|*/
      I("FileCheck -check-prefix=MSVC2013 -check-prefix=CHECK %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-terminate.cpp -o - -triple=x86_64-pc-windows-msvc -mconstructor-aliases -fexceptions -fcxx-exceptions -fms-compatibility-version=19.00 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=MSVC2015 -check-prefix=CHECK ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-eh-terminate.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm %s -o - -triple=x86_64-pc-windows-msvc -mconstructor-aliases -fexceptions -fcxx-exceptions -fms-compatibility-version=19.00")./*|*/
      I("FileCheck -check-prefix=MSVC2015 -check-prefix=CHECK %s");
  }

  @Test
  public void test_microsoft_abi_extern_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-extern-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti-data -O1 -disable-llvm-optzns ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-extern-template.cpp -emit-llvm -o - -triple x86_64-windows-msvc | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-extern-template.cpp
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti-data -O1 -disable-llvm-optzns %s -emit-llvm -o - -triple x86_64-windows-msvc")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_member_pointers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-member-pointers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -Wno-uninitialized -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-member-pointers.cpp -o - -triple=i386-pc-win32 -fms-extensions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-member-pointers.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -Wno-uninitialized -fno-rtti -emit-llvm %s -o - -triple=i386-pc-win32 -fms-extensions")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -Wno-uninitialized -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-member-pointers.cpp -o - -triple=x86_64-pc-win32 -fms-extensions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-member-pointers.cpp -check-prefix=X64
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -Wno-uninitialized -fno-rtti -emit-llvm %s -o - -triple=x86_64-pc-win32 -fms-extensions")./*|*/
      I("FileCheck %s -check-prefix=X64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -Wno-uninitialized -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-member-pointers.cpp -o - -triple=i386-pc-win32 -DINCOMPLETE_VIRTUAL -fms-extensions -verify
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -Wno-uninitialized -fno-rtti -emit-llvm %s -o - -triple=i386-pc-win32 -DINCOMPLETE_VIRTUAL -fms-extensions -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -Wno-uninitialized -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-member-pointers.cpp -o - -triple=i386-pc-win32 -DINCOMPLETE_VIRTUAL -DMEMFUN -fms-extensions -verify
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -Wno-uninitialized -fno-rtti -emit-llvm %s -o - -triple=i386-pc-win32 -DINCOMPLETE_VIRTUAL -DMEMFUN -fms-extensions -verify");
  }

  @Test
  public void test_microsoft_abi_methods_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-methods.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-methods.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-methods.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_multiple_nonvirtual_inheritance_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-multiple-nonvirtual-inheritance.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-multiple-nonvirtual-inheritance.cpp -o - -mconstructor-aliases -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-multiple-nonvirtual-inheritance.cpp
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -emit-llvm %s -o - -mconstructor-aliases -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_non_virtual_base_ordering_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-non-virtual-base-ordering.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm -triple=i686-pc-win32 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-non-virtual-base-ordering.cpp 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-non-virtual-base-ordering.cpp
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -emit-llvm -triple=i686-pc-win32 -o - %s  2>/dev/null")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm -triple=x86_64-pc-win32 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-non-virtual-base-ordering.cpp 2>/dev/null | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-non-virtual-base-ordering.cpp
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -emit-llvm -triple=x86_64-pc-win32 -o - %s  2>/dev/null")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_nontrivial_covariant_thunk_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-nontrivial-covariant-thunk.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-nontrivial-covariant-thunk.cpp -fno-rtti -emit-llvm-only -o - -triple=i386-pc-win32 -verify
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -emit-llvm-only -o - -triple=i386-pc-win32 -verify");
  }

  @Test
  public void test_microsoft_abi_rtti_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-rtti.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple=i386-pc-win32 2>/dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-rtti.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-rtti.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple=i386-pc-win32 2>/dev/null %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple=x86_64-pc-win32 2>/dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-rtti.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-rtti.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple=x86_64-pc-win32 2>/dev/null %s")./*|*/
      I("FileCheck --check-prefix=X64 %s");
  }

  @Test
  public void test_microsoft_abi_sret_and_byval_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-sret-and-byval.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-sret-and-byval.cpp -o - -triple=i386-pc-linux | ${LLVM_SRC}/build/bin/FileCheck -check-prefix LINUX ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-sret-and-byval.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-linux")./*|*/
      I("FileCheck -check-prefix LINUX %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-sret-and-byval.cpp -o - -triple=i386-pc-win32 -mconstructor-aliases -fno-rtti | ${LLVM_SRC}/build/bin/FileCheck -check-prefix WIN32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-sret-and-byval.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32 -mconstructor-aliases -fno-rtti")./*|*/
      I("FileCheck -check-prefix WIN32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-sret-and-byval.cpp -o - -triple=x86_64-pc-win32 -mconstructor-aliases -fno-rtti | ${LLVM_SRC}/build/bin/FileCheck -check-prefix WIN64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-sret-and-byval.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-pc-win32 -mconstructor-aliases -fno-rtti")./*|*/
      I("FileCheck -check-prefix WIN64 %s");
  }

  @Test
  public void test_microsoft_abi_static_initializers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-static-initializers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -fno-threadsafe-statics -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-static-initializers.cpp -o - -mconstructor-aliases -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-static-initializers.cpp
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -fno-threadsafe-statics -emit-llvm %s -o - -mconstructor-aliases -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_structors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fno-rtti ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors.cpp -std=c++11 -o - -mconstructor-aliases -triple=i386-pc-win32 -fno-rtti > ${TEST_TEMP_DIR}/microsoft-abi-structors.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fno-rtti %s -std=c++11 -o - -mconstructor-aliases -triple=i386-pc-win32 -fno-rtti > %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors.cpp < ${TEST_TEMP_DIR}/microsoft-abi-structors.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix DTORS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors.cpp < ${TEST_TEMP_DIR}/microsoft-abi-structors.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix DTORS %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix DTORS2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors.cpp < ${TEST_TEMP_DIR}/microsoft-abi-structors.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix DTORS2 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix DTORS3 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors.cpp < ${TEST_TEMP_DIR}/microsoft-abi-structors.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix DTORS3 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix DTORS4 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors.cpp < ${TEST_TEMP_DIR}/microsoft-abi-structors.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix DTORS4 %s < %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors.cpp -o - -mconstructor-aliases -triple=x86_64-pc-win32 -fno-rtti -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix DTORS-X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -mconstructor-aliases -triple=x86_64-pc-win32 -fno-rtti -std=c++11")./*|*/
      I("FileCheck --check-prefix DTORS-X64 %s");
  }

  @Test
  public void test_microsoft_abi_structors_alias_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors-alias.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors-alias.cpp -o - -triple=i386-pc-win32 -fno-rtti -mconstructor-aliases -O1 -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors-alias.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32 -fno-rtti -mconstructor-aliases -O1 -disable-llvm-optzns")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_structors_delayed_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors-delayed-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fdelayed-template-parsing -std=c++11 -o - -triple=i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors-delayed-template.cpp > ${TEST_TEMP_DIR}/microsoft-abi-structors-delayed-template.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fdelayed-template-parsing -std=c++11 -o - -triple=i386-pc-win32 %s > %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-structors-delayed-template.cpp < ${TEST_TEMP_DIR}/microsoft-abi-structors-delayed-template.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
  }

  @Test
  public void test_microsoft_abi_thread_safe_statics_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-thread-safe-statics.cpp");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fexceptions -fcxx-exceptions -fms-extensions -fms-compatibility -fms-compatibility-version=19 -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-thread-safe-statics.cpp -o - -triple=i386-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-thread-safe-statics.cpp
    RUN(TestState.Failed, "%clang_cc1 -fexceptions -fcxx-exceptions -fms-extensions -fms-compatibility -fms-compatibility-version=19 -std=c++11 -emit-llvm %s -o - -triple=i386-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_throw_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-throw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple=i386-pc-win32 -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-throw.cpp -fcxx-exceptions -fms-extensions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-throw.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple=i386-pc-win32 -std=c++11 %s -fcxx-exceptions -fms-extensions")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -triple=i386-pc-win32 -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-throw.cpp -fcxx-exceptions -fms-extensions -DSTD | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-throw.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -triple=i386-pc-win32 -std=c++11 %s -fcxx-exceptions -fms-extensions -DSTD")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_thunks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-thunks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-thunks.cpp -o - -triple=i386-pc-win32 '>${TEST_TEMP_DIR}/microsoft-abi-thunks.cpp.tmp' 2>&1
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -emit-llvm %s -o - -triple=i386-pc-win32 >%t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MANGLING ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-thunks.cpp < ${TEST_TEMP_DIR}/microsoft-abi-thunks.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=MANGLING %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=XMANGLING ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-thunks.cpp < ${TEST_TEMP_DIR}/microsoft-abi-thunks.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=XMANGLING %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CODEGEN ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-thunks.cpp < ${TEST_TEMP_DIR}/microsoft-abi-thunks.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CODEGEN %s < %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-thunks.cpp -o - -triple=x86_64-pc-win32 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MANGLING-X64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-thunks.cpp
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -emit-llvm %s -o - -triple=x86_64-pc-win32 2>&1")./*|*/
      I("FileCheck --check-prefix=MANGLING-X64 %s");
  }

  @Test
  public void test_microsoft_abi_try_throw_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-try-throw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-try-throw.cpp -o - -triple=i386-pc-win32 -mconstructor-aliases -fcxx-exceptions -fexceptions -fno-rtti -DTRY | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-try-throw.cpp -check-prefix=TRY
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32 -mconstructor-aliases -fcxx-exceptions -fexceptions -fno-rtti -DTRY")./*|*/
      I("FileCheck %s -check-prefix=TRY");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-try-throw.cpp -o - -triple=i386-pc-win32 -mconstructor-aliases -fcxx-exceptions -fexceptions -fno-rtti -DTHROW | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-try-throw.cpp -check-prefix=THROW
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-win32 -mconstructor-aliases -fcxx-exceptions -fexceptions -fno-rtti -DTHROW")./*|*/
      I("FileCheck %s -check-prefix=THROW");
  }

  @Test
  public void test_microsoft_abi_typeid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-typeid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -O1 -o - -triple=i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-typeid.cpp -fexceptions -fcxx-exceptions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-typeid.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -O1 -o - -triple=i386-pc-win32 %s -fexceptions -fcxx-exceptions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_vbtables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vbtables.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vbtables.cpp -fno-rtti -triple=i386-pc-win32 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vbtables.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=i386-pc-win32 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_vftables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vftables.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vftables.cpp -fno-rtti -triple=i386-pc-win32 -fms-extensions -emit-llvm -o - -O1 -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vftables.cpp -check-prefix=NO-RTTI
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=i386-pc-win32 -fms-extensions -emit-llvm -o - -O1 -disable-llvm-optzns")./*|*/
      I("FileCheck %s -check-prefix=NO-RTTI");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vftables.cpp -triple=i386-pc-win32 -fms-extensions -emit-llvm -o - -O1 -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vftables.cpp -check-prefix=RTTI
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i386-pc-win32 -fms-extensions -emit-llvm -o - -O1 -disable-llvm-optzns")./*|*/
      I("FileCheck %s -check-prefix=RTTI");
  }

  @Test
  public void test_microsoft_abi_virtual_inheritance_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-inheritance.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-inheritance.cpp -fno-rtti -triple=i386-pc-win32 -emit-llvm -o ${TEST_TEMP_DIR}/microsoft-abi-virtual-inheritance.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=i386-pc-win32 -emit-llvm -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-inheritance.cpp < ${TEST_TEMP_DIR}/microsoft-abi-virtual-inheritance.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-inheritance.cpp < ${TEST_TEMP_DIR}/microsoft-abi-virtual-inheritance.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK2 %s < %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-inheritance.cpp -fno-rtti -triple=x86_64-pc-win32 -emit-llvm -o ${TEST_TEMP_DIR}/microsoft-abi-virtual-inheritance.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=x86_64-pc-win32 -emit-llvm -o %t");
  }

  @Test
  public void test_microsoft_abi_virtual_inheritance_vtordisps_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-inheritance-vtordisps.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-inheritance-vtordisps.cpp -fno-rtti -triple=i386-pc-win32 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-inheritance-vtordisps.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=i386-pc-win32 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-inheritance-vtordisps.cpp -fno-rtti -triple=x86_64-pc-win32 -emit-llvm -o ${TEST_TEMP_DIR}/microsoft-abi-virtual-inheritance-vtordisps.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=x86_64-pc-win32 -emit-llvm -o %t");
  }

  @Test
  public void test_microsoft_abi_virtual_member_pointers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-member-pointers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fno-rtti -emit-llvm -triple=i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-member-pointers.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-member-pointers.cpp --check-prefix=CHECK32
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fno-rtti -emit-llvm -triple=i386-pc-win32 %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fno-rtti -emit-llvm -triple=x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-member-pointers.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-virtual-member-pointers.cpp --check-prefix=CHECK64
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fno-rtti -emit-llvm -triple=x86_64-pc-win32 %s -o -")./*|*/
      I("FileCheck %s --check-prefix=CHECK64");
  }

  @Test
  public void test_microsoft_abi_vmemptr_conflicts_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vmemptr-conflicts.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm -triple=i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vmemptr-conflicts.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vmemptr-conflicts.cpp
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -emit-llvm -triple=i386-pc-win32 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_vmemptr_fastcall_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vmemptr-fastcall.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -triple i686-pc-windows-msvc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vmemptr-fastcall.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vmemptr-fastcall.cpp
    RUN(TestState.Failed, "%clang_cc1 -fms-extensions -triple i686-pc-windows-msvc %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_vmemptr_vbase_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vmemptr-vbase.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm -triple=i386-pc-win32 -fms-extensions -fms-compatibility -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vmemptr-vbase.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vmemptr-vbase.cpp
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -emit-llvm -triple=i386-pc-win32 -fms-extensions -fms-compatibility -std=c++11 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_vtables_ambiguous_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-ambiguous.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-ambiguous.cpp -emit-llvm-only -triple=i386-pc-win32 -verify -DTEST1
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only -triple=i386-pc-win32 -verify -DTEST1");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-ambiguous.cpp -emit-llvm-only -triple=i386-pc-win32 -verify -DTEST2
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only -triple=i386-pc-win32 -verify -DTEST2");
  }

  @Test
  public void test_microsoft_abi_vtables_multiple_nonvirtual_inheritance_no_thunks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-no-thunks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-no-thunks.cpp -fno-rtti -triple=i386-pc-win32 -emit-llvm -o ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-no-thunks.cpp.tmp.ll -fdump-vtable-layouts '>${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-no-thunks.cpp.tmp'
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=i386-pc-win32 -emit-llvm -o %t.ll -fdump-vtable-layouts >%t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-no-thunks.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-no-thunks.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MANGLING ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-no-thunks.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-no-thunks.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=MANGLING %s < %t.ll");
  }

  @Test
  public void test_microsoft_abi_vtables_multiple_nonvirtual_inheritance_pure_virtual_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-pure-virtual.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-pure-virtual.cpp -fno-rtti -triple=i386-pc-win32 -emit-llvm -o ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-pure-virtual.cpp.tmp.ll -fdump-vtable-layouts '>${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-pure-virtual.cpp.tmp'
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=i386-pc-win32 -emit-llvm -o %t.ll -fdump-vtable-layouts >%t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-pure-virtual.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-pure-virtual.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MANGLING ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-pure-virtual.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-pure-virtual.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=MANGLING %s < %t.ll");
  }

  @Test
  public void test_microsoft_abi_vtables_multiple_nonvirtual_inheritance_return_adjustment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-return-adjustment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-return-adjustment.cpp -fno-rtti -triple=i386-pc-win32 -emit-llvm -o ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-return-adjustment.cpp.tmp.ll -fdump-vtable-layouts '>${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-return-adjustment.cpp.tmp'
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=i386-pc-win32 -emit-llvm -o %t.ll -fdump-vtable-layouts >%t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-return-adjustment.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-return-adjustment.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MANGLING ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-return-adjustment.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-return-adjustment.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=MANGLING %s < %t.ll");
  }

  @Test
  public void test_microsoft_abi_vtables_multiple_nonvirtual_inheritance_this_adjustment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-this-adjustment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-this-adjustment.cpp -fno-rtti -triple=i386-pc-win32 -emit-llvm -o ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-this-adjustment.cpp.tmp.ll -fdump-vtable-layouts '>${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-this-adjustment.cpp.tmp'
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=i386-pc-win32 -emit-llvm -o %t.ll -fdump-vtable-layouts >%t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-this-adjustment.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-this-adjustment.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=BITCODE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-this-adjustment.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-this-adjustment.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=BITCODE %s < %t.ll");
  }

  @Test
  public void test_microsoft_abi_vtables_multiple_nonvirtual_inheritance_vdtors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-vdtors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-vdtors.cpp -fno-rtti -triple=i386-pc-win32 -emit-llvm -o ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-vdtors.cpp.tmp.ll -fdump-vtable-layouts '>${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-vdtors.cpp.tmp'
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=i386-pc-win32 -emit-llvm -o %t.ll -fdump-vtable-layouts >%t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-multiple-nonvirtual-inheritance-vdtors.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-multiple-nonvirtual-inheritance-vdtors.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
  }

  @Test
  public void test_microsoft_abi_vtables_return_thunks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-return-thunks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-return-thunks.cpp -emit-llvm -o ${TEST_TEMP_DIR}/microsoft-abi-vtables-return-thunks.cpp.tmp -triple=i386-pc-win32 -fdump-vtable-layouts 2>&1 | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=VFTABLES ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-return-thunks.cpp
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti %s -emit-llvm -o %t -triple=i386-pc-win32 -fdump-vtable-layouts 2>&1")./*|*/
      I("FileCheck --check-prefix=VFTABLES %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=GLOBALS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-return-thunks.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-return-thunks.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=GLOBALS %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CODEGEN ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-return-thunks.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-return-thunks.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CODEGEN %s < %t");
  }

  @Test
  public void test_microsoft_abi_vtables_single_inheritance_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-single-inheritance.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-single-inheritance.cpp -fno-rtti -triple=i386-pc-win32 -emit-llvm -fdump-vtable-layouts -o ${TEST_TEMP_DIR}/microsoft-abi-vtables-single-inheritance.cpp.tmp.ll > ${TEST_TEMP_DIR}/microsoft-abi-vtables-single-inheritance.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti -triple=i386-pc-win32 -emit-llvm -fdump-vtable-layouts -o %t.ll > %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=EMITS-VFTABLE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-single-inheritance.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-single-inheritance.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=EMITS-VFTABLE %s < %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=NO-VFTABLE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-single-inheritance.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-single-inheritance.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=NO-VFTABLE %s < %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-single-inheritance.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-single-inheritance.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
  }

  @Test
  public void test_microsoft_abi_vtables_virtual_inheritance_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-virtual-inheritance.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fms-extensions -fno-rtti -emit-llvm -o ${TEST_TEMP_DIR}/microsoft-abi-vtables-virtual-inheritance.cpp.tmp.ll -fdump-vtable-layouts ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-virtual-inheritance.cpp -triple=i386-pc-win32 '>${TEST_TEMP_DIR}/microsoft-abi-vtables-virtual-inheritance.cpp.tmp'
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fms-extensions -fno-rtti -emit-llvm -o %t.ll -fdump-vtable-layouts %s -triple=i386-pc-win32 >%t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-virtual-inheritance.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-virtual-inheritance.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MANGLING ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-virtual-inheritance.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-virtual-inheritance.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=MANGLING %s < %t.ll");
  }

  @Test
  public void test_microsoft_abi_vtables_virtual_inheritance_vtordisps_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-virtual-inheritance-vtordisps.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm -fdump-vtable-layouts ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-virtual-inheritance-vtordisps.cpp -o ${TEST_TEMP_DIR}/microsoft-abi-vtables-virtual-inheritance-vtordisps.cpp.tmp.ll -triple=i386-pc-win32 > ${TEST_TEMP_DIR}/microsoft-abi-vtables-virtual-inheritance-vtordisps.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -emit-llvm -fdump-vtable-layouts %s -o %t.ll -triple=i386-pc-win32 > %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-virtual-inheritance-vtordisps.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-virtual-inheritance-vtordisps.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MANGLING ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-virtual-inheritance-vtordisps.cpp < ${TEST_TEMP_DIR}/microsoft-abi-vtables-virtual-inheritance-vtordisps.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=MANGLING %s < %t.ll");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fno-rtti -emit-llvm-only -fdump-vtable-layouts ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-abi-vtables-virtual-inheritance-vtordisps.cpp -triple=x86_64-pc-win32 > /dev/null
    RUN(TestState.Failed, "%clang_cc1 -fno-rtti -emit-llvm-only -fdump-vtable-layouts %s -triple=x86_64-pc-win32 > /dev/null");
  }

  @Test
  public void test_microsoft_compatibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-compatibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-compatibility.cpp -triple i686-pc-win32 -std=c++11 -fms-compatibility -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-compatibility.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-win32 -std=c++11 -fms-compatibility -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_interface_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-interface.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fms-extensions -Wno-microsoft -triple=i386-pc-windows-gnu -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-interface.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-interface.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fms-extensions -Wno-microsoft -triple=i386-pc-windows-gnu -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_new_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-new.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-new.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-new.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-win32 -fms-compatibility %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_no_rtti_data_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-no-rtti-data.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-no-rtti-data.cpp -fno-rtti-data -triple=i386-pc-win32 -o - -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-no-rtti-data.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fno-rtti-data -triple=i386-pc-win32 -o - -emit-llvm")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_templ_uuidof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-templ-uuidof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-templ-uuidof.cpp -o - -DDEFINE_GUID -triple=i386-pc-win32 -fms-extensions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-templ-uuidof.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -DDEFINE_GUID -triple=i386-pc-win32 -fms-extensions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_uuidof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof.cpp -o - -DDEFINE_GUID -triple=i386-pc-linux -fms-extensions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof.cpp --check-prefix=CHECK-DEFINE-GUID
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -DDEFINE_GUID -triple=i386-pc-linux -fms-extensions")./*|*/
      I("FileCheck %s --check-prefix=CHECK-DEFINE-GUID");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof.cpp -o - -triple=i386-pc-linux -fms-extensions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=i386-pc-linux -fms-extensions")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof.cpp -o - -triple=x86_64-pc-linux -fms-extensions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof.cpp --check-prefix=CHECK-64
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-pc-linux -fms-extensions")./*|*/
      I("FileCheck %s --check-prefix=CHECK-64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof.cpp -o - -DDEFINE_GUID -DWRONG_GUID -triple=i386-pc-linux -fms-extensions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof.cpp --check-prefix=CHECK-DEFINE-WRONG-GUID
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -DDEFINE_GUID -DWRONG_GUID -triple=i386-pc-linux -fms-extensions")./*|*/
      I("FileCheck %s --check-prefix=CHECK-DEFINE-WRONG-GUID");
  }

  @Test
  public void test_microsoft_uuidof_mangling_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof-mangling.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof-mangling.cpp -o - -triple x86_64-unknown-unknown -fms-extensions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/microsoft-uuidof-mangling.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple x86_64-unknown-unknown -fms-extensions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mingw_new_abi_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mingw-new-abi.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-mingw32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mingw-new-abi.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MINGW ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mingw-new-abi.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i386-pc-mingw32 %s -o -")./*|*/
      I("FileCheck --check-prefix=MINGW %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-cygwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mingw-new-abi.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CYGWIN ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mingw-new-abi.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i386-pc-cygwin %s -o -")./*|*/
      I("FileCheck --check-prefix=CYGWIN %s");
  }

  @Test
  public void test_mingw_w64_seh_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mingw-w64-seh-exceptions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mingw-w64-seh-exceptions.cpp -fexceptions -emit-llvm -triple x86_64-w64-windows-gnu -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mingw-w64-seh-exceptions.cpp --check-prefix=X64
    RUN(TestState.Failed, "%clang_cc1 %s -fexceptions -emit-llvm -triple x86_64-w64-windows-gnu -o -")./*|*/
      I("FileCheck %s --check-prefix=X64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mingw-w64-seh-exceptions.cpp -fexceptions -emit-llvm -triple i686-w64-windows-gnu -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mingw-w64-seh-exceptions.cpp --check-prefix=X86
    RUN(TestState.Failed, "%clang_cc1 %s -fexceptions -emit-llvm -triple i686-w64-windows-gnu -o -")./*|*/
      I("FileCheck %s --check-prefix=X86");
  }

  @Test
  public void test_mips_size_t_ptrdiff_t_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mips-size_t-ptrdiff_t.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -emit-llvm -triple=mips-unknown-linux-gnu < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mips-size_t-ptrdiff_t.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=O32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mips-size_t-ptrdiff_t.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -emit-llvm -triple=mips-unknown-linux-gnu < %s")./*|*/
      I("FileCheck --check-prefix=O32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -emit-llvm -triple=mips64-unknown-linux-gnu -target-abi n32 < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mips-size_t-ptrdiff_t.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=N32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mips-size_t-ptrdiff_t.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -emit-llvm -triple=mips64-unknown-linux-gnu -target-abi n32 < %s")./*|*/
      I("FileCheck --check-prefix=N32 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -emit-llvm -triple=mips64-unknown-linux-gnu -target-abi n64 < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mips-size_t-ptrdiff_t.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=N64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/mips-size_t-ptrdiff_t.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -emit-llvm -triple=mips64-unknown-linux-gnu -target-abi n64 < %s")./*|*/
      I("FileCheck --check-prefix=N64 %s");
  }

  @Test
  public void test_move_assignment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/move-assignment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -std=c++11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/move-assignment.cpp -triple x86_64-pc-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/move-assignment.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -std=c++11 -o - %s -triple x86_64-pc-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_inline_asm_fields_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-inline-asm-fields.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-inline-asm-fields.cpp -triple i386-apple-darwin10 -fasm-blocks -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-inline-asm-fields.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-apple-darwin10 -fasm-blocks -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_inline_asm_return_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-inline-asm-return.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-inline-asm-return.cpp -triple i686-pc-windows-msvc -emit-llvm -o - -fasm-blocks | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-inline-asm-return.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-windows-msvc -emit-llvm -o - -fasm-blocks")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_integer_static_data_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-integer-static-data-members.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=i386-pc-win32 -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-integer-static-data-members.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-integer-static-data-members.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=i386-pc-win32 -fms-compatibility %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_integer_static_data_members_exported_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-integer-static-data-members-exported.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=i386-pc-win32 -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-integer-static-data-members-exported.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-integer-static-data-members-exported.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=i386-pc-win32 -fms-compatibility %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_novtable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-novtable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-novtable.cpp -emit-llvm -fms-extensions -fms-compatibility -fno-rtti -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-novtable.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-pc-win32 %s -emit-llvm -fms-extensions -fms-compatibility -fno-rtti -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_property_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-property.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=x86_64-pc-win32 -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-property.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-property.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=x86_64-pc-win32 -fms-compatibility %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-pc-win32 -fms-compatibility -emit-pch -o ${TEST_TEMP_DIR}/ms-property.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-property.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-pc-win32 -fms-compatibility -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=x86_64-pc-win32 -fms-compatibility -include-pch ${TEST_TEMP_DIR}/ms-property.cpp.tmp -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-property.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-property.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=x86_64-pc-win32 -fms-compatibility -include-pch %t -verify %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_thread_local_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-thread_local.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-thread_local.cpp -std=c++1y -triple=i686-pc-win32 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms-thread_local.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++1y -triple=i686-pc-win32 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_struct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms_struct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms_struct.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms_struct.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ms_wide_predefined_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms_wide_predefined_expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms_wide_predefined_expr.cpp -fms-extensions -triple i686-pc-win32 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ms_wide_predefined_expr.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fms-extensions -triple i686-pc-win32 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_multi_dim_operator_new_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/multi-dim-operator-new.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/multi-dim-operator-new.cpp -triple x86_64-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/multi-dim-operator-new.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-unknown-unknown -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_namespace_aliases_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/namespace-aliases.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/namespace-aliases.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_nested_base_member_access_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nested-base-member-access.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nested-base-member-access.cpp -emit-llvm -o ${TEST_TEMP_DIR}/nested-base-member-access.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t");
  }

  @Test
  public void test_new_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_new_alias_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-alias.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-linux-gnu -std=c++11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-alias.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-alias.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-linux-gnu -std=c++11 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_new_array_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-array-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-array-init.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-array-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_new_array_init_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-array-init-exceptions.cpp");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-unknown-unknown -fexceptions -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-array-init-exceptions.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-array-init-exceptions.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple i386-unknown-unknown -fexceptions -fcxx-exceptions %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_new_operator_phi_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-operator-phi.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-operator-phi.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -verify %s");
  }

  @Test
  public void test_new_overflow_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-overflow.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-overflow.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-overflow.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_new_with_default_arg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-with-default-arg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/new-with-default-arg.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s");
  }

  @Test
  public void test_no_elide_constructors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-elide-constructors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -triple i386-unknown-unknown -fno-elide-constructors -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-elide-constructors.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-elide-constructors.cpp --check-prefix=CHECK --check-prefix=CHECK-CXX98
    RUN(TestState.Failed, "%clang_cc1 -std=c++98 -triple i386-unknown-unknown -fno-elide-constructors -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-CXX98");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-unknown-unknown -fno-elide-constructors -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-elide-constructors.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-elide-constructors.cpp --check-prefix=CHECK --check-prefix=CHECK-CXX11
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple i386-unknown-unknown -fno-elide-constructors -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-CXX11");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-elide-constructors.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-elide-constructors.cpp --check-prefix=CHECK --check-prefix=CHECK-CXX98-ELIDE
    RUN(TestState.Failed, "%clang_cc1 -std=c++98 -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-CXX98-ELIDE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-elide-constructors.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-elide-constructors.cpp --check-prefix=CHECK --check-prefix=CHECK-CXX11-ELIDE
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK --check-prefix=CHECK-CXX11-ELIDE");
  }

  @Test
  public void test_no_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-exceptions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-exceptions.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-exceptions.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_no_opt_volatile_memcpy_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-opt-volatile-memcpy.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-opt-volatile-memcpy.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/no-opt-volatile-memcpy.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_noexcept_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/noexcept.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/noexcept.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/noexcept.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_noinline_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/noinline-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/noinline-template.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/noinline-template.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nonconst_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nonconst-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nonconst-init.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nonconst-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nrvo_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nrvo.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -O1 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nrvo.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nrvo.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -O1 -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -O1 -fcxx-exceptions -fexceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nrvo.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-EH ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nrvo.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -O1 -fcxx-exceptions -fexceptions -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-EH %s");
  }

  @Test
  public void test_nrvo_noreturn_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nrvo-noreturn.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nrvo-noreturn.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_nullptr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nullptr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin10 '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nullptr.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/nullptr.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin10 -I%S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_observe_noexcept_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/observe-noexcept.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple powerpc64le-unknown-unknown -std=c++11 -fopenmp -fexceptions -fcxx-exceptions -O0 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/observe-noexcept.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/observe-noexcept.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple  powerpc64le-unknown-unknown -std=c++11 -fopenmp -fexceptions -fcxx-exceptions -O0 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_operator_new_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/operator-new.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -emit-llvm -o ${TEST_TEMP_DIR}/operator-new.cpp.tmp-1.ll ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/operator-new.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-linux-gnu -emit-llvm -o %t-1.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix SANE '--input-file=${TEST_TEMP_DIR}/operator-new.cpp.tmp-1.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/operator-new.cpp
    RUN(TestState.Failed, "FileCheck -check-prefix SANE --input-file=%t-1.ll %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu -emit-llvm -fno-assume-sane-operator-new -o ${TEST_TEMP_DIR}/operator-new.cpp.tmp-2.ll ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/operator-new.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-linux-gnu -emit-llvm -fno-assume-sane-operator-new -o %t-2.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix SANENOT '--input-file=${TEST_TEMP_DIR}/operator-new.cpp.tmp-2.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/operator-new.cpp
    RUN(TestState.Failed, "FileCheck -check-prefix SANENOT --input-file=%t-2.ll %s");
  }

  @Test
  public void test_optnone_and_attributes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-and-attributes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-and-attributes.cpp -triple i386-mingw32 -fms-extensions -emit-llvm -x c++ | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-and-attributes.cpp
    RUN(TestState.Failed, "%clang_cc1 < %s -triple i386-mingw32 -fms-extensions -emit-llvm -x c++")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_optnone_class_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-class-members.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc < ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-class-members.cpp -triple i386-pc-solaris2.11 -fms-extensions -emit-llvm -x c++ | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-class-members.cpp
    RUN(TestState.Failed, "%clang_cc1 < %s -triple %itanium_abi_triple -fms-extensions -emit-llvm -x c++")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_optnone_def_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-def-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-def-decl.cpp -triple i386-pc-solaris2.11 -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-def-decl.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_optnone_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-templates.cpp -triple i386-pc-solaris2.11 -std=c++11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/optnone-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -std=c++11 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_overload_binop_implicitconvert_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/overload-binop-implicitconvert.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/overload-binop-implicitconvert.cpp -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only");
  }

  @Test
  public void test_override_layout_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/override-layout.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -fdump-record-layouts-simple ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/override-layout.cpp > ${TEST_TEMP_DIR}/override-layout.cpp.tmp.layouts
    RUN(TestState.Failed, "%clang_cc1 -w -fdump-record-layouts-simple %s > %t.layouts");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -fdump-record-layouts-simple ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/override-layout.cpp > ${TEST_TEMP_DIR}/override-layout.cpp.tmp.before
    RUN(TestState.Failed, "%clang_cc1 -w -fdump-record-layouts-simple %s > %t.before");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -w -DPACKED= -DALIGNED16= -fdump-record-layouts-simple '-foverride-record-layout=${TEST_TEMP_DIR}/override-layout.cpp.tmp.layouts' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/override-layout.cpp > ${TEST_TEMP_DIR}/override-layout.cpp.tmp.after
    RUN(TestState.Failed, "%clang_cc1 -w -DPACKED= -DALIGNED16= -fdump-record-layouts-simple -foverride-record-layout=%t.layouts %s > %t.after");
    // diff -u ${TEST_TEMP_DIR}/override-layout.cpp.tmp.before ${TEST_TEMP_DIR}/override-layout.cpp.tmp.after
    RUN(TestState.Failed, "diff -u %t.before %t.after");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/override-layout.cpp < ${TEST_TEMP_DIR}/override-layout.cpp.tmp.after
    RUN(TestState.Failed, "FileCheck %s < %t.after");
  }

  @Test
  public void test_partial_destruction_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/partial-destruction.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/partial-destruction.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/partial-destruction.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_partial_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/partial-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -std=c++11 -fcxx-exceptions -fexceptions -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/partial-init.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/partial-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -std=c++11 -fcxx-exceptions -fexceptions -S -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pass_object_size_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pass-object-size.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -O0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pass-object-size.cpp -o - 2>&1 -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pass-object-size.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -O0 %s -o - 2>&1 -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pod_member_memcpys_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pod-member-memcpys.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -std=c++03 -fexceptions -fcxx-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pod-member-memcpys.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pod-member-memcpys.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -std=c++03 -fexceptions -fcxx-exceptions -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -emit-llvm -std=c++03 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pod-member-memcpys.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pod-member-memcpys.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -emit-llvm -std=c++03 -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-2 %s");
  }

  @Test
  public void test_pointers_to_data_members_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pointers-to-data-members.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pointers-to-data-members.cpp -emit-llvm -o ${TEST_TEMP_DIR}/pointers-to-data-members.cpp.tmp.ll -triple=x86_64-apple-darwin10
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o %t.ll -triple=x86_64-apple-darwin10");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pointers-to-data-members.cpp < ${TEST_TEMP_DIR}/pointers-to-data-members.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck %s < %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GLOBAL ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pointers-to-data-members.cpp < ${TEST_TEMP_DIR}/pointers-to-data-members.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-GLOBAL %s < %t.ll");
  }

  @Test
  public void test_poly_unsigned_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/poly-unsigned.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-apple-ios -target-feature +neon -ffreestanding -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/poly-unsigned.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-UNSIGNED-POLY ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/poly-unsigned.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-apple-ios -target-feature +neon -ffreestanding -S -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-UNSIGNED-POLY %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64-linux-gnu -target-feature +neon -ffreestanding -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/poly-unsigned.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-UNSIGNED-POLY ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/poly-unsigned.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple arm64-linux-gnu -target-feature +neon -ffreestanding -S -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-UNSIGNED-POLY %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-apple-ios -ffreestanding -target-cpu cortex-a8 -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/poly-unsigned.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-SIGNED-POLY ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/poly-unsigned.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-apple-ios -ffreestanding -target-cpu cortex-a8 -S -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CHECK-SIGNED-POLY %s");
  }

  @Test
  public void test_powerpc_byval_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/powerpc-byval.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/powerpc-byval.cpp -o - -triple=powerpc-unknown-linux | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/powerpc-byval.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=powerpc-unknown-linux")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr11797_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr11797.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr11797.cpp -fvisibility hidden -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr11797.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -fvisibility hidden -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr12104_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12104.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12104.h ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12104.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12104.cpp
    RUN(TestState.Failed, "%clang_cc1 -include %S/pr12104.h %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -triple i386-pc-solaris2.11 -emit-pch -o ${TEST_TEMP_DIR}/pr12104.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12104.h
    RUN(TestState.Failed, "%clang_cc1 -x c++ -triple %itanium_abi_triple -emit-pch -o %t %S/pr12104.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include-pch ${TEST_TEMP_DIR}/pr12104.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12104.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12104.cpp
    RUN(TestState.Failed, "%clang_cc1 -include-pch %t %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr12251_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12251.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12251.cpp -triple i386-unknown-unknown -emit-llvm -O1 -relaxed-aliasing -fstrict-enums -std=c++11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12251.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -emit-llvm -O1 -relaxed-aliasing -fstrict-enums -std=c++11 -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12251.cpp -triple i386-unknown-unknown -emit-llvm -O1 -relaxed-aliasing -std=c++11 -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=NO-STRICT-ENUMS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr12251.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -emit-llvm -O1 -relaxed-aliasing -std=c++11 -o -")./*|*/
      I("FileCheck --check-prefix=NO-STRICT-ENUMS %s");
  }

  @Test
  public void test_pr13396_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr13396.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr13396.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr13396.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-pc-linux-gnu %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr15753_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr15753.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr15753.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr15753.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr18635_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr18635.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -std=c++11 -triple x86_64-pc-linux-gnu -o- ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr18635.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr18635.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -std=c++11 -triple x86_64-pc-linux-gnu -o- %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr18661_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr18661.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr18661.cpp -triple i386-pc-solaris2.11 -fcxx-exceptions -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr18661.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -fcxx-exceptions -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr18962_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr18962.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-linux-gnu ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr18962.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr18962.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-linux-gnu %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr20719_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr20719.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -emit-llvm -std=c++11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr20719.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr20719.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc -emit-llvm -std=c++11 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr20897_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr20897.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-windows-msvc -fms-extensions -emit-llvm -std=c++1y -O0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr20897.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr20897.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i686-windows-msvc -fms-extensions -emit-llvm -std=c++1y -O0 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr21989_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr21989.cpp");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr21989.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr21989.cpp
    RUN(TestState.Failed, "not %clang_cc1 -emit-llvm -triple %itanium_abi_triple -o - %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr24097_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr24097.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr24097.cpp -triple=x86_64-pc-linux -fvisibility hidden -emit-llvm -O1 -disable-llvm-optzns -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr24097.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-pc-linux -fvisibility hidden -emit-llvm -O1 -disable-llvm-optzns -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr27030_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr27030.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=i386-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr27030.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr27030.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=i386-pc-win32 %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr28360_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr28360.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr28360.cpp -emit-llvm -o - -triple i686-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr28360.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -triple i686-pc-win32")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr9130_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr9130.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr9130.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr9130.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr9965_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr9965.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr9965.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pr9965.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_init_seg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-init_seg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-init_seg.cpp -triple=i686-pc-win32 -fms-extensions -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-init_seg.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i686-pc-win32 -fms-extensions -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_loop_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-loop.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-loop.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-loop.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_loop_safety_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-loop-safety.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-loop-safety.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-loop-safety.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_pack_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-pack.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-pack.cpp -triple=i686-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-pack.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i686-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_pack_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-pack-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.7.2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-pack-2.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-pack-2.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.7.2 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_pack_3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-pack-3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-pack-3.cpp -triple=i686-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-pack-3.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i686-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_unroll_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-unroll.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-unroll.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-unroll.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-visibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-visibility.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-visibility.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pragma_weak_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-weak.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-weak.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/pragma-weak.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_predefined_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fblocks ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fblocks %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_predefined_expr_cxx14_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr-cxx14.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++14 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr-cxx14.cpp -triple i386-pc-solaris2.11 -fblocks -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr-cxx14.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++14 %s -triple %itanium_abi_triple -fblocks -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -std=c++14 -triple i386-pc-solaris2.11 -fblocks -emit-pch -o ${TEST_TEMP_DIR}/predefined-expr-cxx14.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr-cxx14.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -std=c++14 -triple %itanium_abi_triple -fblocks -emit-pch -o %t %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -triple i386-pc-solaris2.11 -std=c++14 -fblocks -include-pch ${TEST_TEMP_DIR}/predefined-expr-cxx14.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr-cxx14.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr-cxx14.cpp
    RUN(TestState.Failed, "%clang_cc1 -x c++ -triple %itanium_abi_triple -std=c++14 -fblocks -include-pch %t %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_predefined_expr_sizeof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr-sizeof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr-sizeof.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/predefined-expr-sizeof.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ptr_to_datamember_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ptr-to-datamember.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ptr-to-datamember.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s");
  }

  @Test
  public void test_ptr_to_member_function_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ptr-to-member-function.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ptr-to-member-function.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ptr-to-member-function.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-LP64 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ptr-to-member-function.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LP32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/ptr-to-member-function.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin -std=c++11 -emit-llvm %s -o -")./*|*/
      I("FileCheck -check-prefix CHECK-LP32 %s");
  }

  @Test
  public void test_redefine_extname_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/redefine_extname.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=i386-pc-solaris2.11 -w -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/redefine_extname.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/redefine_extname.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=i386-pc-solaris2.11 -w -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_reference_bind_default_argument_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-bind-default-argument.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-bind-default-argument.cpp -emit-llvm-only -verify
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only -verify");
  }

  @Test
  public void test_reference_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin10 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-cast.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-cast.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin10 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_reference_field_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-field.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-field.cpp -O2 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-field.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -o - %s -O2")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_reference_in_block_args_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-in-block-args.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-in-block-args.cpp -emit-llvm -o ${TEST_TEMP_DIR}/reference-in-block-args.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -fblocks %s -emit-llvm -o %t");
  }

  @Test
  public void test_reference_in_blocks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-in-blocks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fblocks ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-in-blocks.cpp -emit-llvm -o ${TEST_TEMP_DIR}/reference-in-blocks.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -fblocks %s -emit-llvm -o %t");
  }

  @Test
  public void test_reference_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -triple i386-pc-solaris2.11 -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reference-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -triple %itanium_abi_triple -verify %s");
  }

  @Test
  public void test_references_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/references.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -verify -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/references.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/references.cpp
    RUN(TestState.Failed, "not %clang_cc1 -triple x86_64-apple-darwin -verify -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_regparm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/regparm.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/regparm.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/regparm.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_reinterpret_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reinterpret-cast.cpp");
    // REQUIRES: LP64
    if (!CHECK_REQUIRES("LP64")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/reinterpret-cast.cpp -std=c++11
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -std=c++11");
  }

  @Test
  public void test_return_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/return.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/return.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/return.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i386-pc-solaris2.11 -O -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/return.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/return.cpp --check-prefix=CHECK-OPT
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple %itanium_abi_triple -O -o - %s")./*|*/
      I("FileCheck %s --check-prefix=CHECK-OPT");
  }

  @Test
  public void test_rtti_fundamental_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-fundamental.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-fundamental.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-fundamental.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -I%S -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rtti_layout_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-layout.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-layout.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -triple=x86_64-apple-darwin10 -emit-llvm -O3 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-layout.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -I%S -triple=x86_64-apple-darwin10 -emit-llvm -O3 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rtti_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-linkage.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-linkage.cpp -check-prefix=CHECK -check-prefix=CHECK-BOTH
    RUN(TestState.Failed, "%clang_cc1 %s -I%S -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-BOTH");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-linkage.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -triple=x86_64-apple-darwin10 -fvisibility hidden -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-WITH-HIDDEN -check-prefix=CHECK-BOTH ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-linkage.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -I%S -triple=x86_64-apple-darwin10 -fvisibility hidden -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-WITH-HIDDEN -check-prefix=CHECK-BOTH %s");
  }

  @Test
  public void test_rtti_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-visibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-visibility.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -triple=x86_64-apple-darwin10 -emit-llvm -o ${TEST_TEMP_DIR}/rtti-visibility.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -I%S -triple=x86_64-apple-darwin10 -emit-llvm -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-visibility.cpp < ${TEST_TEMP_DIR}/rtti-visibility.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST1 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rtti-visibility.cpp < ${TEST_TEMP_DIR}/rtti-visibility.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST2 %s < %t");
  }

  @Test
  public void test_runtimecc_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/runtimecc.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/runtimecc.cpp -triple=armv7-apple-darwin10 -emit-llvm -o - -fexceptions -fcxx-exceptions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/runtimecc.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=armv7-apple-darwin10 -emit-llvm -o - -fexceptions -fcxx-exceptions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rvalue_references_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rvalue-references.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rvalue-references.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/rvalue-references.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sanitize_dtor_bit_field_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-bit-field.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O0 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-bit-field.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-bit-field.cpp
    RUN(TestState.Failed, "%clang_cc1 -O0 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-bit-field.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-bit-field.cpp
    RUN(TestState.Failed, "%clang_cc1 -O1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sanitize_dtor_callback_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-callback.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=memory -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-callback.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-callback.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=memory -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sanitize_dtor_derived_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-derived-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-derived-class.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-derived-class.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-derived-class.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-derived-class.cpp
    RUN(TestState.Failed, "%clang_cc1 -O1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sanitize_dtor_fn_attribute_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-fn-attribute.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=memory -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-fn-attribute.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-fn-attribute.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=memory -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sanitize_dtor_nontrivial_virtual_base_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-nontrivial-virtual-base.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=memory -O0 -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-nontrivial-virtual-base.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-nontrivial-virtual-base.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=memory -O0 -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=memory -O1 -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-nontrivial-virtual-base.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-nontrivial-virtual-base.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=memory -O1 -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sanitize_dtor_repress_aliasing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-repress-aliasing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=memory -O1 -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-repress-aliasing.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-repress-aliasing.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=memory -O1 -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=memory -O2 -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-repress-aliasing.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-repress-aliasing.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=memory -O2 -fsanitize-memory-use-after-dtor -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sanitize_dtor_tail_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-tail-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-tail-call.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-tail-call.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-tail-call.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-tail-call.cpp
    RUN(TestState.Failed, "%clang_cc1 -O1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sanitize_dtor_trivial_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-trivial.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O0 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-trivial.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-trivial.cpp
    RUN(TestState.Failed, "%clang_cc1 -O0 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-trivial.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-trivial.cpp
    RUN(TestState.Failed, "%clang_cc1 -O1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sanitize_dtor_vtable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-vtable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O0 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-vtable.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-vtable.cpp
    RUN(TestState.Failed, "%clang_cc1 -O0 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-vtable.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-dtor-vtable.cpp
    RUN(TestState.Failed, "%clang_cc1 -O1 -fsanitize=memory -fsanitize-memory-use-after-dtor -disable-llvm-optzns -std=c++11 -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sanitize_no_dtor_callback_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-no-dtor-callback.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsanitize=memory -triple=x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-no-dtor-callback.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sanitize-no-dtor-callback.cpp
    RUN(TestState.Failed, "%clang_cc1 -fsanitize=memory -triple=x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_scoped_enums_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/scoped-enums.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/scoped-enums.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/scoped-enums.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_scoped_enums_debug_info_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/scoped-enums-debug-info.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm -debug-info-kind=limited -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/scoped-enums-debug-info.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/scoped-enums-debug-info.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm -debug-info-kind=limited -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sections_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sections.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i686-pc-win32 -fms-extensions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sections.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sections.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i686-pc-win32 -fms-extensions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sizeof_unwind_exception_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sizeof-unwind-exception.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sizeof-unwind-exception.cpp -O2 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sizeof-unwind-exception.cpp --check-prefix=X86-64
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions %s -O2 -o -")./*|*/
      I("FileCheck %s --check-prefix=X86-64");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sizeof-unwind-exception.cpp -O2 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sizeof-unwind-exception.cpp --check-prefix=X86-32
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions %s -O2 -o -")./*|*/
      I("FileCheck %s --check-prefix=X86-32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sizeof-unwind-exception.cpp -O2 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sizeof-unwind-exception.cpp --check-prefix=ARM-DARWIN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions %s -O2 -o -")./*|*/
      I("FileCheck %s --check-prefix=ARM-DARWIN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-unknown-gnueabi -emit-llvm -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sizeof-unwind-exception.cpp -O2 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sizeof-unwind-exception.cpp --check-prefix=ARM-EABI
    RUN(TestState.Failed, "%clang_cc1 -triple arm-unknown-gnueabi -emit-llvm -fcxx-exceptions -fexceptions %s -O2 -o -")./*|*/
      I("FileCheck %s --check-prefix=ARM-EABI");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple mipsel-unknown-unknown -emit-llvm -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sizeof-unwind-exception.cpp -O2 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sizeof-unwind-exception.cpp --check-prefix=MIPS
    RUN(TestState.Failed, "%clang_cc1 -triple mipsel-unknown-unknown -emit-llvm -fcxx-exceptions -fexceptions %s -O2 -o -")./*|*/
      I("FileCheck %s --check-prefix=MIPS");
  }

  @Test
  public void test_skip_vtable_pointer_initialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/skip-vtable-pointer-initialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/skip-vtable-pointer-initialization.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/skip-vtable-pointer-initialization.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_sparcv9_abi_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sparcv9-abi.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple sparcv9-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sparcv9-abi.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/sparcv9-abi.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple sparcv9-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_specialized_static_data_mem_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/specialized-static-data-mem-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/specialized-static-data-mem-init.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/specialized-static-data-mem-init.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_split_stacks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/split-stacks.cpp");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -fsplit-stack -S -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/split-stacks.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-SEGSTK ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/split-stacks.cpp
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -fsplit-stack -S -std=c++11 %s -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-SEGSTK %s");
    // ${LLVM_SRC}/build/bin/clang -target x86_64-linux-gnu -S -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/split-stacks.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NOSEGSTK ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/split-stacks.cpp
    RUN(TestState.Failed, "%clang -target x86_64-linux-gnu -S -std=c++11 %s -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-NOSEGSTK %s");
  }

  @Test
  public void test_stack_reuse_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/stack-reuse.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-unknown-linux-gnueabihf ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/stack-reuse.cpp -o - -emit-llvm -O1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/stack-reuse.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-unknown-linux-gnueabihf %s -o - -emit-llvm -O1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_stack_reuse_miscompile_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/stack-reuse-miscompile.cpp");
    // ${LLVM_SRC}/build/bin/clang -S -target armv7l-unknown-linux-gnueabihf -emit-llvm -O1 -mllvm -disable-llvm-optzns -S ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/stack-reuse-miscompile.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/stack-reuse-miscompile.cpp
    RUN(TestState.Failed, "%clang -S -target armv7l-unknown-linux-gnueabihf -emit-llvm -O1 -mllvm -disable-llvm-optzns -S %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_static_assert_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-assert.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-assert.cpp -emit-llvm -o - -std=c++11 -verify
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o - -std=c++11 -verify");
  }

  @Test
  public void test_static_data_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-data-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-data-member.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-data-member.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-pc-linux -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-data-member.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MACHO ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-data-member.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=MACHO %s");
  }

  @Test
  public void test_static_data_member_single_emission_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-data-member-single-emission.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-data-member-single-emission.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-data-member-single-emission.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_static_destructor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-destructor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-destructor.cpp -triple=x86_64-pc-linux -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=X86 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-destructor.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-pc-linux -emit-llvm -o -")./*|*/
      I("FileCheck --check-prefix=X86 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-destructor.cpp -triple=wasm32 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=WASM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-destructor.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=wasm32 -emit-llvm -o -")./*|*/
      I("FileCheck --check-prefix=WASM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-destructor.cpp -triple=armv7-apple-darwin9 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=ARM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-destructor.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=armv7-apple-darwin9 -emit-llvm -o -")./*|*/
      I("FileCheck --check-prefix=ARM %s");
  }

  @Test
  public void test_static_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init.cpp -triple=x86_64-pc-linuxs -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-pc-linuxs -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_static_init_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin9 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-1.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-1.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin9 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_static_init_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-2.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -verify %s");
  }

  @Test
  public void test_static_init_3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin10.0.0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-3.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-3.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin10.0.0 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_static_init_4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -S -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-4.cpp -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-4.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -S -emit-llvm -o - %s -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_static_init_pnacl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-pnacl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=le32-unknown-nacl -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-pnacl.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-pnacl.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=le32-unknown-nacl -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_static_init_wasm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-wasm.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=wasm32-unknown-unknown -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-wasm.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-wasm.cpp -check-prefix=WEBASSEMBLY32
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=wasm32-unknown-unknown -o - %s")./*|*/
      I("FileCheck %s -check-prefix=WEBASSEMBLY32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=wasm64-unknown-unknown -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-wasm.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-init-wasm.cpp -check-prefix=WEBASSEMBLY64
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=wasm64-unknown-unknown -o - %s")./*|*/
      I("FileCheck %s -check-prefix=WEBASSEMBLY64");
  }

  @Test
  public void test_static_local_in_local_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-local-in-local-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux -fblocks -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-local-in-local-class.cpp -std=c++1y | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-local-in-local-class.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-linux -fblocks -emit-llvm -o - %s -std=c++1y")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_static_member_variable_explicit_specialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-member-variable-explicit-specialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-member-variable-explicit-specialization.cpp -std=c++1y -triple=x86_64-pc-linux -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=ELF --check-prefix=ALL ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-member-variable-explicit-specialization.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++1y -triple=x86_64-pc-linux -emit-llvm -o -")./*|*/
      I("FileCheck --check-prefix=ELF --check-prefix=ALL %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-member-variable-explicit-specialization.cpp -std=c++1y -triple=x86_64-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=MACHO --check-prefix=ALL ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-member-variable-explicit-specialization.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++1y -triple=x86_64-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck --check-prefix=MACHO --check-prefix=ALL %s");
  }

  @Test
  public void test_static_mutable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-mutable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-mutable.cpp -triple=i686-linux-gnu -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/static-mutable.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i686-linux-gnu -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_stmtexpr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/stmtexpr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-unused-value -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/stmtexpr.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/stmtexpr.cpp
    RUN(TestState.Failed, "%clang_cc1 -Wno-unused-value -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_strict_vtable_pointers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/strict-vtable-pointers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/strict-vtable-pointers.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -triple=x86_64-apple-darwin10 -fstrict-vtable-pointers -disable-llvm-optzns -O2 -emit-llvm -o ${TEST_TEMP_DIR}/strict-vtable-pointers.cpp.tmp.ll
    RUN(TestState.Failed, "%clang_cc1 %s -I%S -triple=x86_64-apple-darwin10 -fstrict-vtable-pointers -disable-llvm-optzns -O2 -emit-llvm -o %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-CTORS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/strict-vtable-pointers.cpp < ${TEST_TEMP_DIR}/strict-vtable-pointers.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-CTORS %s < %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NEW ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/strict-vtable-pointers.cpp < ${TEST_TEMP_DIR}/strict-vtable-pointers.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-NEW %s < %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-DTORS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/strict-vtable-pointers.cpp < ${TEST_TEMP_DIR}/strict-vtable-pointers.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-DTORS %s < %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-LINK-REQ ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/strict-vtable-pointers.cpp < ${TEST_TEMP_DIR}/strict-vtable-pointers.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-LINK-REQ %s < %t.ll");
  }

  @Test
  public void test_switch_case_folding_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/switch-case-folding.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/switch-case-folding.cpp -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only");
  }

  @Test
  public void test_switch_case_folding_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/switch-case-folding-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/switch-case-folding-1.cpp -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only");
  }

  @Test
  public void test_switch_case_folding_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/switch-case-folding-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/switch-case-folding-2.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/switch-case-folding-2.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_temp_order_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/temp-order.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -mllvm -inline-threshold=1024 -O3 -emit-llvm -o ${TEST_TEMP_DIR}/temp-order.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/temp-order.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -mllvm -inline-threshold=1024 -O3 -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/temp-order.cpp < ${TEST_TEMP_DIR}/temp-order.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
  }

  @Test
  public void test_template_anonymous_types_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-anonymous-types.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-anonymous-types.cpp -triple x86_64-unknown-linux-gnu -emit-llvm -w -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-anonymous-types.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-unknown-linux-gnu -emit-llvm -w -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_template_anonymous_union_member_initializer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-anonymous-union-member-initializer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o ${TEST_TEMP_DIR}/template-anonymous-union-member-initializer.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-anonymous-union-member-initializer.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o %t %s");
  }

  @Test
  public void test_template_dependent_bind_temporary_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-dependent-bind-temporary.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-dependent-bind-temporary.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-dependent-bind-temporary.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_template_inner_struct_visibility_hidden_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-inner-struct-visibility-hidden.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fvisibility hidden -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-inner-struct-visibility-hidden.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-inner-struct-visibility-hidden.cpp
    RUN(TestState.Failed, "%clang_cc1 -fvisibility hidden -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_template_instantiation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-instantiation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-instantiation.cpp -O1 -disable-llvm-optzns -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-instantiation.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -O1 -disable-llvm-optzns -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_template_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-linkage.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-linkage.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_template_static_var_defer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-static-var-defer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/template-static-var-defer.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | not grep define
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("not grep define");
  }

  @Test
  public void test_temporaries_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/temporaries.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/temporaries.cpp -o - -triple=x86_64-apple-darwin9 -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/temporaries.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin9 -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_thiscall_struct_return_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thiscall-struct-return.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-PC-Win32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thiscall-struct-return.cpp -fms-compatibility -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thiscall-struct-return.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-PC-Win32 %s -fms-compatibility -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_threadsafe_statics_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/threadsafe-statics.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=x86_64-apple-darwin10 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/threadsafe-statics.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=WITH-TSS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/threadsafe-statics.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=x86_64-apple-darwin10 -o - %s")./*|*/
      I("FileCheck -check-prefix=WITH-TSS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple=x86_64-apple-darwin10 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/threadsafe-statics.cpp -fno-threadsafe-statics | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=NO-TSS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/threadsafe-statics.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple=x86_64-apple-darwin10 -o - %s -fno-threadsafe-statics")./*|*/
      I("FileCheck -check-prefix=NO-TSS %s");
  }

  @Test
  public void test_threadsafe_statics_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/threadsafe-statics-exceptions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/threadsafe-statics-exceptions.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/threadsafe-statics-exceptions.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -fcxx-exceptions -fexceptions -triple x86_64-apple-darwin10 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_throw_expression_cleanup_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/throw-expression-cleanup.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/throw-expression-cleanup.cpp -triple x86_64-none-linux-gnu -emit-llvm -fcxx-exceptions -fexceptions -std=c++11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/throw-expression-cleanup.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-none-linux-gnu -emit-llvm -fcxx-exceptions -fexceptions -std=c++11 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_throw_expression_dtor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/throw-expression-dtor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/throw-expression-dtor.cpp -emit-llvm-only -verify -triple i386-pc-solaris2.11 -fcxx-exceptions -fexceptions
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only -verify -triple %itanium_abi_triple -fcxx-exceptions -fexceptions");
  }

  @Test
  public void test_throw_expressions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/throw-expressions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -Wno-unreachable-code -Werror -triple x86_64-linux-gnu -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/throw-expressions.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/throw-expressions.cpp
    RUN(TestState.Failed, "%clang_cc1 -fcxx-exceptions -fexceptions -Wno-unreachable-code -Werror -triple x86_64-linux-gnu -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_thunk_linkonce_odr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunk-linkonce-odr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunk-linkonce-odr.cpp -triple i386-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunk-linkonce-odr.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_thunk_use_after_free_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunk-use-after-free.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -triple i386-pc-solaris2.11 -O1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunk-use-after-free.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -triple %itanium_abi_triple -O1 %s");
  }

  @Test
  public void test_thunks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunks.cpp -triple=x86_64-pc-linux-gnu -munwind-tables -emit-llvm -o ${TEST_TEMP_DIR}/thunks.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-pc-linux-gnu -munwind-tables -emit-llvm -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunks.cpp -triple=x86_64-pc-linux-gnu -munwind-tables -emit-llvm -o ${TEST_TEMP_DIR}/thunks.cpp.tmp.opt -O1 -disable-llvm-optzns
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-pc-linux-gnu -munwind-tables -emit-llvm -o %t.opt -O1 -disable-llvm-optzns");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunks.cpp < ${TEST_TEMP_DIR}/thunks.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunks.cpp < ${TEST_TEMP_DIR}/thunks.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck %s < %t.opt");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-NONOPT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunks.cpp < ${TEST_TEMP_DIR}/thunks.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-NONOPT %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-OPT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunks.cpp < ${TEST_TEMP_DIR}/thunks.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-OPT %s < %t.opt");
  }

  @Test
  public void test_thunks_available_externally_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunks-available-externally.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/thunks-available-externally.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -triple=x86_64-apple-darwin10 -emit-llvm-only -O3
    RUN(TestState.Failed, "%clang_cc1 %s -I%S -triple=x86_64-apple-darwin10 -emit-llvm-only -O3");
  }

  @Test
  public void test_tls_init_funcs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/tls-init-funcs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx10.8 -std=c++1y -S -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/tls-init-funcs.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/tls-init-funcs.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-macosx10.8 -std=c++1y -S -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_trap_fnattr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/trap-fnattr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O0 -emit-llvm -ftrapv -ftrap-function=mytrap ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/trap-fnattr.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/trap-fnattr.cpp -check-prefix=TRAPFUNC
    RUN(TestState.Failed, "%clang_cc1 -O0 -emit-llvm -ftrapv -ftrap-function=mytrap %s -o -")./*|*/
      I("FileCheck %s -check-prefix=TRAPFUNC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O0 -emit-llvm -ftrapv ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/trap-fnattr.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/trap-fnattr.cpp -check-prefix=NOOPTION
    RUN(TestState.Failed, "%clang_cc1 -O0 -emit-llvm -ftrapv %s -o -")./*|*/
      I("FileCheck %s -check-prefix=NOOPTION");
  }

  @Test
  public void test_trivial_constructor_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/trivial-constructor-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/trivial-constructor-init.cpp -o - -std=c++11 -triple i386-pc-solaris2.11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/trivial-constructor-init.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -std=c++11 -triple %itanium_abi_triple")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_try_catch_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/try-catch.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/try-catch.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/try-catch.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o - -fcxx-exceptions -fexceptions")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_type_metadata_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CFI --check-prefix=CFI-NVT --check-prefix=ITANIUM --check-prefix=TT-ITANIUM --check-prefix=NDIAG ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CFI --check-prefix=CFI-NVT --check-prefix=ITANIUM --check-prefix=TT-ITANIUM --check-prefix=NDIAG %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CFI --check-prefix=CFI-NVT --check-prefix=ITANIUM --check-prefix=TT-ITANIUM --check-prefix=ITANIUM-DIAG --check-prefix=DIAG --check-prefix=DIAG-ABORT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CFI --check-prefix=CFI-NVT --check-prefix=ITANIUM --check-prefix=TT-ITANIUM --check-prefix=ITANIUM-DIAG --check-prefix=DIAG --check-prefix=DIAG-ABORT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall -fsanitize-recover=cfi-vcall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CFI --check-prefix=CFI-NVT --check-prefix=ITANIUM --check-prefix=TT-ITANIUM --check-prefix=ITANIUM-DIAG --check-prefix=DIAG --check-prefix=DIAG-RECOVER ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall -fsanitize-recover=cfi-vcall -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CFI --check-prefix=CFI-NVT --check-prefix=ITANIUM --check-prefix=TT-ITANIUM --check-prefix=ITANIUM-DIAG --check-prefix=DIAG --check-prefix=DIAG-RECOVER %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-pc-windows-msvc -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CFI --check-prefix=CFI-NVT --check-prefix=MS --check-prefix=TT-MS --check-prefix=NDIAG ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-pc-windows-msvc -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CFI --check-prefix=CFI-NVT --check-prefix=MS --check-prefix=TT-MS --check-prefix=NDIAG %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-unknown-linux -fvisibility hidden -fwhole-program-vtables -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=VTABLE-OPT --check-prefix=ITANIUM --check-prefix=TT-ITANIUM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-unknown-linux -fvisibility hidden -fwhole-program-vtables -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=VTABLE-OPT --check-prefix=ITANIUM --check-prefix=TT-ITANIUM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-pc-windows-msvc -fwhole-program-vtables -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=VTABLE-OPT --check-prefix=MS --check-prefix=TT-MS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-pc-windows-msvc -fwhole-program-vtables -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=VTABLE-OPT --check-prefix=MS --check-prefix=TT-MS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -fwhole-program-vtables -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CFI --check-prefix=CFI-VT --check-prefix=ITANIUM --check-prefix=TC-ITANIUM ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-unknown-linux -fvisibility hidden -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -fwhole-program-vtables -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CFI --check-prefix=CFI-VT --check-prefix=ITANIUM --check-prefix=TC-ITANIUM %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto -triple x86_64-pc-windows-msvc -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -fwhole-program-vtables -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CFI --check-prefix=CFI-VT --check-prefix=MS --check-prefix=TC-MS ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-metadata.cpp
    RUN(TestState.Failed, "%clang_cc1 -flto -triple x86_64-pc-windows-msvc -fsanitize=cfi-vcall -fsanitize-trap=cfi-vcall -fwhole-program-vtables -emit-llvm -o - %s")./*|*/
      I("FileCheck --check-prefix=CFI --check-prefix=CFI-VT --check-prefix=MS --check-prefix=TC-MS %s");
  }

  @Test
  public void test_type_traits_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-traits.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type-traits.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -verify %s");
  }

  @Test
  public void test_type_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type_visibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type_visibility.cpp -std=c++11 -triple=x86_64-apple-darwin10 -emit-llvm -o ${TEST_TEMP_DIR}/type_visibility.cpp.tmp.ll
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-apple-darwin10 -emit-llvm -o %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type_visibility.cpp -check-prefix=FUNS < ${TEST_TEMP_DIR}/type_visibility.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck %s -check-prefix=FUNS < %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type_visibility.cpp -check-prefix=VARS < ${TEST_TEMP_DIR}/type_visibility.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck %s -check-prefix=VARS < %t.ll");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type_visibility.cpp -std=c++11 -triple=x86_64-apple-darwin10 -fvisibility hidden -emit-llvm -o ${TEST_TEMP_DIR}/type_visibility.cpp.tmp.ll
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-apple-darwin10 -fvisibility hidden -emit-llvm -o %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type_visibility.cpp -check-prefix=FUNS-HIDDEN < ${TEST_TEMP_DIR}/type_visibility.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck %s -check-prefix=FUNS-HIDDEN < %t.ll");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/type_visibility.cpp -check-prefix=VARS-HIDDEN < ${TEST_TEMP_DIR}/type_visibility.cpp.tmp.ll
    RUN(TestState.Failed, "FileCheck %s -check-prefix=VARS-HIDDEN < %t.ll");
  }

  @Test
  public void test_typeid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/typeid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/typeid.cpp -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/typeid.cpp
    RUN(TestState.Failed, "%clang_cc1 -I%S %s -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_typeid_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/typeid-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/typeid-cxx11.cpp -triple x86_64-apple-darwin10 -emit-llvm -std=c++11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/typeid-cxx11.cpp
    RUN(TestState.Failed, "%clang_cc1 -I%S %s -triple x86_64-apple-darwin10 -emit-llvm -std=c++11 -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_typeid_should_throw_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/typeid-should-throw.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/typeid-should-throw.cpp -triple i386-pc-solaris2.11 -Wno-unused-value -emit-llvm -o - -std=c++11 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/typeid-should-throw.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -Wno-unused-value -emit-llvm -o - -std=c++11")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_uncode_string_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/uncode-string.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/uncode-string.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/uncode-string.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_uncopyable_args_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/uncopyable-args.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/uncopyable-args.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/uncopyable-args.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-windows-msvc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/uncopyable-args.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/uncopyable-args.cpp -check-prefix=WIN64
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-windows-msvc -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=WIN64");
  }

  @Test
  public void test_union_dtor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/union-dtor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/union-dtor.cpp -S -o - -emit-llvm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/union-dtor.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 %s -S -o - -emit-llvm")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_unknown_anytype_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/unknown-anytype.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -funknown-anytype -emit-llvm -o ${TEST_TEMP_DIR}/unknown-anytype.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/unknown-anytype.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -funknown-anytype -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix COMMON ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/unknown-anytype.cpp < ${TEST_TEMP_DIR}/unknown-anytype.cpp.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix COMMON %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix X86_64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/unknown-anytype.cpp < ${TEST_TEMP_DIR}/unknown-anytype.cpp.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix X86_64 %s < %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -funknown-anytype -emit-llvm -o ${TEST_TEMP_DIR}/unknown-anytype.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/unknown-anytype.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -funknown-anytype -emit-llvm -o %t %s");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix COMMON ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/unknown-anytype.cpp < ${TEST_TEMP_DIR}/unknown-anytype.cpp.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix COMMON %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix I386 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/unknown-anytype.cpp < ${TEST_TEMP_DIR}/unknown-anytype.cpp.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix I386 %s < %t");
  }

  @Test
  public void test_value_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/value-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/value-init.cpp -triple x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/value-init.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vararg_conversion_ctor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vararg-conversion-ctor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vararg-conversion-ctor.cpp -o ${TEST_TEMP_DIR}/vararg-conversion-ctor.cpp.tmp-64.ll
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++11 -emit-llvm %s -o %t-64.ll");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-LPLL64 '--input-file=${TEST_TEMP_DIR}/vararg-conversion-ctor.cpp.tmp-64.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vararg-conversion-ctor.cpp
    RUN(TestState.Failed, "FileCheck -check-prefix CHECK-LPLL64 --input-file=%t-64.ll %s");
  }

  @Test
  public void test_vararg_non_pod_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vararg-non-pod.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-error=non-pod-varargs -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vararg-non-pod.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vararg-non-pod.cpp
    RUN(TestState.Failed, "%clang_cc1 -Wno-error=non-pod-varargs -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vararg_non_pod_ms_compat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vararg-non-pod-ms-compat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-error=non-pod-varargs -triple i686-pc-win32 -fms-compatibility -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vararg-non-pod-ms-compat.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vararg-non-pod-ms-compat.cpp -check-prefix=X86 -check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -Wno-error=non-pod-varargs -triple i686-pc-win32 -fms-compatibility -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=X86 -check-prefix=CHECK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-error=non-pod-varargs -triple x86_64-pc-win32 -fms-compatibility -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vararg-non-pod-ms-compat.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vararg-non-pod-ms-compat.cpp -check-prefix=X64 -check-prefix=CHECK
    RUN(TestState.Failed, "%clang_cc1 -Wno-error=non-pod-varargs -triple x86_64-pc-win32 -fms-compatibility -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=X64 -check-prefix=CHECK");
  }

  @Test
  public void test_varargs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/varargs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/varargs.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/varargs.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_variadic_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/variadic-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/variadic-templates.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/variadic-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vector_splat_conversion_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vector-splat-conversion.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vector-splat-conversion.cpp -triple arm64-apple-ios8.1.0 -std=c++11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vector-splat-conversion.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple arm64-apple-ios8.1.0 -std=c++11 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virt_canonical_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-canonical-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-canonical-decl.cpp -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm-only");
  }

  @Test
  public void test_virt_dtor_gen_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-dtor-gen.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -o - -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-dtor-gen.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-dtor-gen.cpp
    RUN(TestState.Failed, "%clang_cc1 -o - -triple %itanium_abi_triple -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virt_dtor_key_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-dtor-key.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-dtor-key.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-dtor-key.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virt_template_vtable_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-template-vtable.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-template-vtable.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-template-vtable.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virt_thunk_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-thunk-reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virt-thunk-reference.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_virtual_base_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-base-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-base-cast.cpp -o - -triple i686-pc-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-base-cast.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple i686-pc-linux-gnu")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-base-cast.cpp -o - -triple i686-pc-win32 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix MSVC ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-base-cast.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple i686-pc-win32")./*|*/
      I("FileCheck -check-prefix MSVC %s");
  }

  @Test
  public void test_virtual_base_ctor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-base-ctor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-base-ctor.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - -O2 | opt - -S -globalopt -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-base-ctor.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o - -O2")./*|*/
      I("opt - -S -globalopt -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virtual_base_destructor_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-base-destructor-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-base-destructor-call.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-base-destructor-call.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virtual_bases_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-bases.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-bases.cpp -o - -triple=x86_64-apple-darwin10 -mconstructor-aliases | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-bases.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin10 -mconstructor-aliases")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virtual_destructor_calls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-destructor-calls.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-destructor-calls.cpp -o - -triple=x86_64-apple-darwin10 -mconstructor-aliases -O1 -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-destructor-calls.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o - -triple=x86_64-apple-darwin10 -mconstructor-aliases -O1 -disable-llvm-optzns")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virtual_destructor_synthesis_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-destructor-synthesis.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-destructor-synthesis.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-destructor-synthesis.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virtual_function_attrs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-function-attrs.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-function-attrs.cpp -triple i386-pc-solaris2.11 -std=c++11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-function-attrs.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -std=c++11 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virtual_function_calls_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-function-calls.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-function-calls.cpp -triple i386-pc-solaris2.11 -std=c++11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-function-calls.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -std=c++11 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virtual_functions_incomplete_types_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-functions-incomplete-types.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-functions-incomplete-types.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-functions-incomplete-types.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virtual_implicit_copy_assignment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-implicit-copy-assignment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-implicit-copy-assignment.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-implicit-copy-assignment.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virtual_implicit_move_assignment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-implicit-move-assignment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-llvm -std=c++11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-implicit-move-assignment.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-implicit-move-assignment.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple %itanium_abi_triple -emit-llvm -std=c++11 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virtual_inherited_destructor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-inherited-destructor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-inherited-destructor.cpp -triple i386-pc-solaris2.11 -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm-only");
  }

  @Test
  public void test_virtual_operator_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-operator-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-operator-call.cpp -triple i386-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-operator-call.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple i386-unknown-unknown -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_virtual_pseudo_destructor_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-pseudo-destructor-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-pseudo-destructor-call.cpp -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/virtual-pseudo-destructor-call.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_visibility_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility.cpp -std=c++11 -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility.cpp -std=c++11 -triple=x86_64-apple-darwin10 -fvisibility hidden -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility.cpp -check-prefix=CHECK-HIDDEN
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-apple-darwin10 -fvisibility hidden -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-HIDDEN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility.cpp -std=c++11 -triple=x86_64-apple-darwin10 -fvisibility internal -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility.cpp -check-prefix=CHECK-HIDDEN
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-apple-darwin10 -fvisibility internal -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-HIDDEN");
  }

  @Test
  public void test_visibility_hidden_extern_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility-hidden-extern-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -triple i386-pc-solaris2.11 -emit-llvm -o - -fvisibility hidden ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility-hidden-extern-templates.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility-hidden-extern-templates.cpp
    RUN(TestState.Failed, "%clang_cc1 -O1 -triple %itanium_abi_triple -emit-llvm -o - -fvisibility hidden %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_visibility_inlines_hidden_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility-inlines-hidden.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -std=c++11 -fvisibility-inlines-hidden -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility-inlines-hidden.cpp -O2 -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility-inlines-hidden.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-unknown-unknown -std=c++11 -fvisibility-inlines-hidden -emit-llvm -o - %s -O2 -disable-llvm-optzns")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_visibility_ms_compat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility-ms-compat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility-ms-compat.cpp -std=c++11 -triple=x86_64-apple-darwin10 -fvisibility hidden -ftype-visibility default -emit-llvm -o ${TEST_TEMP_DIR}/visibility-ms-compat.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -triple=x86_64-apple-darwin10 -fvisibility hidden -ftype-visibility default -emit-llvm -o %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility-ms-compat.cpp < ${TEST_TEMP_DIR}/visibility-ms-compat.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GLOBAL ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/visibility-ms-compat.cpp < ${TEST_TEMP_DIR}/visibility-ms-compat.cpp.tmp
    RUN(TestState.Failed, "FileCheck -check-prefix=CHECK-GLOBAL %s < %t");
  }

  @Test
  public void test_vla_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vla_consruct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla-consruct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fcxx-exceptions -fexceptions -O0 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla-consruct.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla-consruct.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-linux-gnu -fcxx-exceptions -fexceptions -O0 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vla_lambda_capturing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla-lambda-capturing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla-lambda-capturing.cpp -std=c++11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla-lambda-capturing.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla-lambda-capturing.cpp -std=c++11 -emit-pch -o ${TEST_TEMP_DIR}/vla-lambda-capturing.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -emit-pch -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla-lambda-capturing.cpp -std=c++11 -include-pch ${TEST_TEMP_DIR}/vla-lambda-capturing.cpp.tmp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vla-lambda-capturing.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++11 -include-pch %t -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vlt_to_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vlt_to_reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vlt_to_reference.cpp -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vlt_to_reference.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_volatile_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/volatile.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/volatile.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/volatile.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_volatile_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/volatile-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-unused-value -triple i386-pc-solaris2.11 -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/volatile-1.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/volatile-1.cpp
    RUN(TestState.Failed, "%clang_cc1 -Wno-unused-value -triple %itanium_abi_triple -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vtable_align_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-align.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-align.cpp -triple=i386-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-align.cpp -check-prefix=CHECK-32
    RUN(TestState.Failed, "%clang_cc1 %s -triple=i386-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-32");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-align.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-align.cpp -check-prefix=CHECK-64
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s -check-prefix=CHECK-64");
  }

  @Test
  public void test_vtable_assume_load_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp -triple x86_64-apple-darwin10 -emit-llvm -o ${TEST_TEMP_DIR}/vtable-assume-load.cpp.tmp.ll -O1 -disable-llvm-optzns -fms-extensions -fstrict-vtable-pointers
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -emit-llvm -o %t.ll -O1 -disable-llvm-optzns -fms-extensions -fstrict-vtable-pointers");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp -triple i686-pc-win32 -emit-llvm -o ${TEST_TEMP_DIR}/vtable-assume-load.cpp.tmp.ms.ll -O1 -disable-llvm-optzns -fms-extensions -fstrict-vtable-pointers
    RUN(TestState.Failed, "%clang_cc1 %s -triple i686-pc-win32 -emit-llvm -o %t.ms.ll -O1 -disable-llvm-optzns -fms-extensions -fstrict-vtable-pointers");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK1 '--input-file=${TEST_TEMP_DIR}/vtable-assume-load.cpp.tmp.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK1 --input-file=%t.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK2 '--input-file=${TEST_TEMP_DIR}/vtable-assume-load.cpp.tmp.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK2 --input-file=%t.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK3 '--input-file=${TEST_TEMP_DIR}/vtable-assume-load.cpp.tmp.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK3 --input-file=%t.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK4 '--input-file=${TEST_TEMP_DIR}/vtable-assume-load.cpp.tmp.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK4 --input-file=%t.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-MS '--input-file=${TEST_TEMP_DIR}/vtable-assume-load.cpp.tmp.ms.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-MS --input-file=%t.ms.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK6 '--input-file=${TEST_TEMP_DIR}/vtable-assume-load.cpp.tmp.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK6 --input-file=%t.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK7 '--input-file=${TEST_TEMP_DIR}/vtable-assume-load.cpp.tmp.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK7 --input-file=%t.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK8 '--input-file=${TEST_TEMP_DIR}/vtable-assume-load.cpp.tmp.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK8 --input-file=%t.ll %s");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK9 '--input-file=${TEST_TEMP_DIR}/vtable-assume-load.cpp.tmp.ll' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-assume-load.cpp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK9 --input-file=%t.ll %s");
  }

  @Test
  public void test_vtable_available_externally_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -triple=x86_64-apple-darwin10 -emit-llvm -o ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -I%S -triple=x86_64-apple-darwin10 -emit-llvm -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp '-I${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX' -triple=x86_64-apple-darwin10 -O2 -disable-llvm-optzns -emit-llvm -o ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp.opt
    RUN(TestState.Failed, "%clang_cc1 %s -I%S -triple=x86_64-apple-darwin10 -O2 -disable-llvm-optzns -emit-llvm -o %t.opt");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST1 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST2 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST5 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST8 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST8 %s < %t.opt");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST9 %s < %t.opt");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST10 %s < %t.opt");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST11 %s < %t.opt");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST12 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST12 %s < %t.opt");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST13 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST13 %s < %t.opt");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST14 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST14 %s < %t.opt");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST15 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST15 %s < %t.opt");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-TEST16 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-available-externally.cpp < ${TEST_TEMP_DIR}/vtable-available-externally.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-TEST16 %s < %t.opt");
  }

  @Test
  public void test_vtable_cast_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-cast-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-cast-crash.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -triple %itanium_abi_triple %s");
  }

  @Test
  public void test_vtable_debug_info_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-debug-info.cpp");
    // ${LLVM_SRC}/build/bin/clang -emit-llvm -S -g ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-debug-info.cpp -o /dev/null
    RUN(TestState.Failed, "%clang -emit-llvm -S -g %s -o /dev/null");
  }

  @Test
  public void test_vtable_holder_self_reference_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-holder-self-reference.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -dwarf-version=2 -debug-info-kind=limited -x c++ -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-holder-self-reference.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-holder-self-reference.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -dwarf-version=2 -debug-info-kind=limited -x c++ -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vtable_key_function_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vtable_key_function_arm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-arm.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-arm.cpp -triple=armv7-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-arm.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=armv7-unknown-unknown -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-arm.cpp -triple=armv7-unknown-unknown -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-LATE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-arm.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=armv7-unknown-unknown -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-LATE %s");
  }

  @Test
  public void test_vtable_key_function_ios_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-ios.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-ios.cpp -triple=armv7-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-ios.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=armv7-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-ios.cpp -triple=armv7-apple-darwin -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-LATE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-ios.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=armv7-apple-darwin -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-LATE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-ios.cpp -triple=x86_64-pc-windows-gnu -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-ios.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-pc-windows-gnu -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-ios.cpp -triple=x86_64-pc-windows-gnu -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-LATE ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-ios.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-pc-windows-gnu -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-LATE %s");
  }

  @Test
  public void test_vtable_key_function_win_comdat_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-win-comdat.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-win-comdat.cpp -triple=x86_64-pc-windows-gnu -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-key-function-win-comdat.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-pc-windows-gnu -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vtable_layout_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp -triple=x86_64-apple-darwin10 -emit-llvm-only -fdump-vtable-layouts > ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm-only -fdump-vtable-layouts > %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-1 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-2 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-3 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-3 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-4 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-4 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-5 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-6 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-6 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-7 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-7 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-8 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-8 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-9 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-10 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-11 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-12 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-12 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-13 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-13 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-14 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-14 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-15 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-15 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-16 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-16 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-17 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-17 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-18 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-18 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-19 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-19 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-20 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-20 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-21 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-21 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-22 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-22 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-23 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-23 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-24 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-24 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-25 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-25 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-26 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-26 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-27 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-27 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-28 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-28 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-29 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-29 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-30 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-30 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-31 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-31 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-32 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-32 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-33 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-33 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-34 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-34 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-35 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-35 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-36 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-36 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-37 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-37 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-38 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-38 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-39 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-39 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-40 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-40 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-41 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-41 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-42 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-42 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-43 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-43 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-44 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-44 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-45 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-45 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-46 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout.cpp < ${TEST_TEMP_DIR}/vtable-layout.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-46 %s < %t");
  }

  @Test
  public void test_vtable_layout_abi_examples_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp -triple=x86_64-apple-darwin10 -emit-llvm-only -fdump-vtable-layouts > ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp 2>/dev/null
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm-only -fdump-vtable-layouts > %t 2>/dev/null");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-1 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp < ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-1 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-2 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp < ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-2 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-3 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp < ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-3 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-4 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp < ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-4 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp < ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-5 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-6 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp < ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-6 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-7 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp < ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-7 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-8 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp < ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-8 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-9 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp < ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-9 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-10 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp < ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-10 %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-abi-examples.cpp < ${TEST_TEMP_DIR}/vtable-layout-abi-examples.cpp.tmp
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-11 %s < %t");
  }

  @Test
  public void test_vtable_layout_extreme_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-extreme.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-extreme.cpp -triple=x86_64-apple-darwin10 -emit-llvm-only -fdump-vtable-layouts 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-layout-extreme.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm-only -fdump-vtable-layouts 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vtable_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-linkage.cpp -triple=x86_64-pc-linux -emit-llvm -o ${TEST_TEMP_DIR}/vtable-linkage.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-pc-linux -emit-llvm -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-linkage.cpp -triple=x86_64-apple-darwin10 -disable-llvm-optzns -O3 -emit-llvm -o ${TEST_TEMP_DIR}/vtable-linkage.cpp.tmp.opt
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -disable-llvm-optzns -O3 -emit-llvm -o %t.opt");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-linkage.cpp < ${TEST_TEMP_DIR}/vtable-linkage.cpp.tmp
    RUN(TestState.Failed, "FileCheck %s < %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-OPT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-linkage.cpp < ${TEST_TEMP_DIR}/vtable-linkage.cpp.tmp.opt
    RUN(TestState.Failed, "FileCheck --check-prefix=CHECK-OPT %s < %t.opt");
  }

  @Test
  public void test_vtable_pointer_initialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-pointer-initialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-pointer-initialization.cpp -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtable-pointer-initialization.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_vtt_layout_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtt-layout.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtt-layout.cpp -triple=x86_64-apple-darwin10 -std=c++11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/vtt-layout.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -std=c++11 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_warn_padded_packed_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/warn-padded-packed.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-none-none -Wpadded -Wpacked -verify ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/warn-padded-packed.cpp -emit-llvm-only
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-none-none -Wpadded -Wpacked -verify %s -emit-llvm-only");
  }

  @Test
  public void test_wasm_args_returns_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/wasm-args-returns.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -triple wasm32-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/wasm-args-returns.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/wasm-args-returns.cpp
    RUN(TestState.Failed, "%clang_cc1 -O1 -triple wasm32-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -O1 -triple wasm64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/wasm-args-returns.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/wasm-args-returns.cpp
    RUN(TestState.Failed, "%clang_cc1 -O1 -triple wasm64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_weak_extern_typeinfo_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/weak-extern-typeinfo.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/weak-extern-typeinfo.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/weak-extern-typeinfo.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_weak_external_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/weak-external.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -triple i386-pc-solaris2.11 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/weak-external.cpp -S -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/weak-external.cpp
    RUN(TestState.Failed, "%clang_cc1 -fcxx-exceptions -fexceptions -triple %itanium_abi_triple %s -S -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_windows_itanium_exceptions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/windows-itanium-exceptions.cpp");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple thumbv7-windows-itanium -fexceptions -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/windows-itanium-exceptions.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/windows-itanium-exceptions.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple thumbv7-windows-itanium -fexceptions -fcxx-exceptions %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple i686-windows-itanium -fexceptions -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/windows-itanium-exceptions.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/windows-itanium-exceptions.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple i686-windows-itanium -fexceptions -fcxx-exceptions %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_windows_on_arm_stack_probe_size_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/windows-on-arm-stack-probe-size.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7--windows-msvc -S -emit-llvm -o - -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/windows-on-arm-stack-probe-size.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/windows-on-arm-stack-probe-size.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7--windows-msvc -S -emit-llvm -o - -x c++ %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple thumbv7--windows-itanium -fno-use-cxa-atexit -S -emit-llvm -o - -x c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/windows-on-arm-stack-probe-size.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/windows-on-arm-stack-probe-size.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple thumbv7--windows-itanium -fno-use-cxa-atexit -S -emit-llvm -o - -x c++ %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_32_arguments_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_32-arguments.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin9 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_32-arguments.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_32-arguments.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin9 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_64_arguments_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_64-arguments.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_64-arguments.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_64-arguments.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_64_arguments_avx_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_64-arguments-avx.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_64-arguments-avx.cpp -target-feature +avx | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_64-arguments-avx.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown -emit-llvm -o - %s -target-feature +avx")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_x86_64_arguments_nacl_x32_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_64-arguments-nacl-x32.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-unknown-nacl -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_64-arguments-nacl-x32.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_64-arguments-nacl-x32.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-unknown-nacl -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple=x86_64-unknown-linux-gnux32 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_64-arguments-nacl-x32.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenCXX/x86_64-arguments-nacl-x32.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple=x86_64-unknown-linux-gnux32 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }
  
}
