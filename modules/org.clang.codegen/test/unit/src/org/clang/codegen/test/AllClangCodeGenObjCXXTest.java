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
 * Collection of all test files from test/CodeGenObjCXX folder
 * @author Vladimir Voskresensky
 */
@Ignore
public class AllClangCodeGenObjCXXTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/";
  public AllClangCodeGenObjCXXTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.codegen/test/unit/src/org/clang/codegen/test/AllClangCodeGenObjCXXTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_2007_10_03_MetadataPointers_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/2007-10-03-MetadataPointers.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/2007-10-03-MetadataPointers.mm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_2010_08_04_Template_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/2010-08-04-Template.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/2010-08-04-Template.mm -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_2010_08_06_X_Y_syntax_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/2010-08-06-X.Y-syntax.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/2010-08-06-X.Y-syntax.mm -o -
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o -");
  }

  @Test
  public void test_address_safety_attr_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/address-safety-attr.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/address-safety-attr.mm | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=WITHOUT ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/address-safety-attr.mm
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s")./*|*/
      I("FileCheck -check-prefix=WITHOUT %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/address-safety-attr.mm -fsanitize=address | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=ASAN ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/address-safety-attr.mm
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - %s -fsanitize=address")./*|*/
      I("FileCheck -check-prefix=ASAN %s");
  }

  @Test
  public void test_arc_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-runtime-has-weak -fblocks -fobjc-arc -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-runtime-has-weak -fblocks -fobjc-arc -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_attrs_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-attrs.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin11 -emit-llvm -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-attrs.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-attrs.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin11 -emit-llvm -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_blocks_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-blocks.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-runtime-has-weak -fblocks -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-blocks.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-blocks.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-runtime-has-weak -fblocks -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_cxx11_init_list_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-cxx11-init-list.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7-ios5.0 -std=c++11 -fobjc-arc -Os -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-cxx11-init-list.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-cxx11-init-list.mm
    RUN(TestState.Failed, "%clang_cc1 -triple armv7-ios5.0 -std=c++11 -fobjc-arc -Os -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_cxx11_member_init_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-cxx11-member-init.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-arc -std=c++11 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-cxx11-member-init.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-cxx11-member-init.mm
    RUN(TestState.Failed, "%clang_cc1  -triple x86_64-apple-darwin10 -fobjc-arc -std=c++11 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_exceptions_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-exceptions.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fexceptions -fobjc-exceptions -fcxx-exceptions -fobjc-runtime-has-weak -o - -fobjc-arc-exceptions ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-exceptions.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-exceptions.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -fexceptions -fobjc-exceptions -fcxx-exceptions -fobjc-runtime-has-weak -o - -fobjc-arc-exceptions %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_globals_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-globals.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-globals.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-globals.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_mangle_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-mangle.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -fobjc-runtime-has-weak -triple i386-pc-solaris2.11 -emit-llvm -fblocks -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-mangle.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-mangle.mm
    RUN(TestState.Failed, "%clang_cc1 -fobjc-arc -fobjc-runtime-has-weak -triple %itanium_abi_triple -emit-llvm -fblocks -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_move_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-move.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -O2 -std=c++11 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-move.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-move.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -O2 -std=c++11 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_new_delete_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-new-delete.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -fobjc-runtime-has-weak -fblocks -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-new-delete.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-new-delete.mm -check-prefix=CHECK -check-prefix=UNOPT
    RUN(TestState.Failed, "%clang_cc1 -fobjc-arc -fobjc-runtime-has-weak -fblocks -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=UNOPT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -fobjc-runtime-has-weak -fblocks -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-new-delete.mm -O -disable-llvm-optzns | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-new-delete.mm -check-prefix=CHECK -check-prefix=OPT
    RUN(TestState.Failed, "%clang_cc1 -fobjc-arc -fobjc-runtime-has-weak -fblocks -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - %s -O -disable-llvm-optzns")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=OPT");
  }

  @Test
  public void test_arc_pseudo_destructors_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-pseudo-destructors.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -fobjc-runtime-has-weak -fblocks -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-pseudo-destructors.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-pseudo-destructors.mm
    RUN(TestState.Failed, "%clang_cc1 -fobjc-arc -fobjc-runtime-has-weak -fblocks -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_references_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-references.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-runtime-has-weak -fblocks -fobjc-arc -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-references.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-references.mm
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-runtime-has-weak -fblocks -fobjc-arc -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_returns_inner_reference_ptr_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-returns-inner-reference-ptr.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-returns-inner-reference-ptr.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-returns-inner-reference-ptr.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_special_member_functions_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-special-member-functions.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-arc -fblocks -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-special-member-functions.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-special-member-functions.mm
    RUN(TestState.Failed, "%clang_cc1 -fobjc-arc -fblocks -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_arc_weak_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-weak.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -std=c++11 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-weak.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/arc-weak.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -std=c++11 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_auto_release_result_assert_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/auto-release-result-assert.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/auto-release-result-assert.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/auto-release-result-assert.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_default_arg_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-default-arg.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-default-arg.mm -std=c++11 -fblocks -fobjc-arc | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-default-arg.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - %s -std=c++11 -fblocks -fobjc-arc")./*|*/
      I("FileCheck  %s");
  }

  @Test
  public void test_block_id_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-id.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fblocks -o - -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-id.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-id.mm
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fblocks -o - -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_in_template_inst_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-in-template-inst.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only -std=c++11 -fblocks -o - -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-in-template-inst.mm
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only -std=c++11 -fblocks -o - -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 %s");
  }

  @Test
  public void test_block_nested_in_lambda_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-nested-in-lambda.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple=x86_64-apple-darwin10 -emit-llvm -std=c++11 -fblocks -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-nested-in-lambda.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-nested-in-lambda.cpp
    RUN(TestState.Failed, "%clang_cc1 -triple=x86_64-apple-darwin10 -emit-llvm -std=c++11 -fblocks -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_block_var_layout_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-var-layout.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -print-ivar-layout -emit-llvm -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-var-layout.mm > ${TEST_TEMP_DIR}/block-var-layout.mm.tmp-64.layout
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -fobjc-gc -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 -print-ivar-layout -emit-llvm -o /dev/null %s > %t-64.layout");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/block-var-layout.mm.tmp-64.layout' ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/block-var-layout.mm
    RUN(TestState.Failed, "FileCheck --input-file=%t-64.layout %s");
  }

  @Test
  public void test_blocks_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/blocks.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -fblocks -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/blocks.mm -verify -std=c++11 -emit-llvm -o ${TEST_TEMP_DIR}/blocks.mm.tmp
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -fblocks -triple x86_64-apple-darwin -fobjc-runtime=macosx-fragile-10.5 %s -verify -std=c++11 -emit-llvm -o %t");
  }

  @Test
  public void test_catch_id_type_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/catch-id-type.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-macosx10.6.6 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fobjc-exceptions -fcxx-exceptions -fexceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/catch-id-type.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/catch-id-type.mm
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-macosx10.6.6 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fobjc-exceptions -fcxx-exceptions -fexceptions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_copy_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/copy.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/copy.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/copy.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_copyable_property_object_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/copyable-property-object.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/copyable-property-object.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/copyable-property-object.mm
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/debug-info.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -debug-info-kind=limited -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/debug-info.mm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -debug-info-kind=limited -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_debug_info_block_capture_this_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/debug-info-block-capture-this.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -std=c++14 -fblocks -debug-info-kind=standalone -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/debug-info-block-capture-this.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/debug-info-block-capture-this.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -std=c++14 -fblocks -debug-info-kind=standalone -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_cyclic_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/debug-info-cyclic.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin -debug-info-kind=standalone -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/debug-info-cyclic.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/debug-info-cyclic.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin -debug-info-kind=standalone -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_debug_info_line_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/debug-info-line.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -debug-info-kind=line-tables-only -fblocks -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/debug-info-line.mm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/debug-info-line.mm
    RUN(TestState.Failed, "%clang_cc1 -fcxx-exceptions -fexceptions -debug-info-kind=line-tables-only -fblocks -emit-llvm %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_designated_initializers_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/designated-initializers.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm64 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/designated-initializers.mm -verify -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/designated-initializers.mm
    RUN(TestState.Failed, "%clang_cc1 -triple arm64 %s -verify -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_destroy_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/destroy.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/destroy.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/destroy.mm
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -triple x86_64-apple-darwin10 -emit-llvm -fobjc-arc -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_encode_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/encode.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/encode.mm -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/encode.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exception_cxx_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/exception-cxx.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/exception-cxx.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/exception-cxx.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exceptions_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/exceptions.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/exceptions.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/exceptions.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exceptions_legacy_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/exceptions-legacy.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fexceptions -fobjc-exceptions -O2 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/exceptions-legacy.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/exceptions-legacy.mm
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -fexceptions -fobjc-exceptions -O2 -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_externally_initialized_selectors_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/externally-initialized-selectors.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-runtime=macosx-fragile-10.5 -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/externally-initialized-selectors.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/externally-initialized-selectors.mm
    RUN(TestState.Failed, "%clang_cc1 -fobjc-runtime=macosx-fragile-10.5 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -o - -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/externally-initialized-selectors.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/externally-initialized-selectors.mm
    RUN(TestState.Failed, "%clang_cc1 -o - -emit-llvm %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_foreach_statement_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/foreach-statement.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/foreach-statement.mm -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/foreach-statement.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_gc_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/gc.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/gc.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/gc.mm
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_implementation_in_extern_c_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/implementation-in-extern-c.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/implementation-in-extern-c.mm -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm %s -o /dev/null");
  }

  @Test
  public void test_implicit_copy_assign_operator_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/implicit-copy-assign-operator.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -emit-llvm -triple x86_64-apple-darwin10.0.0 -fobjc-runtime=macosx-fragile-10.5 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/implicit-copy-assign-operator.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/implicit-copy-assign-operator.mm -check-prefix=CHECK-OBJ
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -emit-llvm -triple x86_64-apple-darwin10.0.0 -fobjc-runtime=macosx-fragile-10.5 -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-OBJ");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x c++ -emit-llvm -triple x86_64-apple-darwin10.0.0 -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/implicit-copy-assign-operator.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/implicit-copy-assign-operator.mm -check-prefix=CHECK-CPP
    RUN(TestState.Failed, "%clang_cc1 -x c++    -emit-llvm -triple x86_64-apple-darwin10.0.0                                    -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK-CPP");
  }

  @Test
  public void test_implicit_copy_constructor_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/implicit-copy-constructor.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/implicit-copy-constructor.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/implicit-copy-constructor.mm
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ivar_objects_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/ivar-objects.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/ivar-objects.mm -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/ivar-objects.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_lambda_expressions_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/lambda-expressions.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/lambda-expressions.mm -fexceptions -std=c++11 -fblocks -fobjc-arc | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=ARC ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/lambda-expressions.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - %s -fexceptions -std=c++11 -fblocks -fobjc-arc")./*|*/
      I("FileCheck -check-prefix=ARC %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/lambda-expressions.mm -fexceptions -std=c++11 -fblocks | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=MRC ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/lambda-expressions.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10.0.0 -emit-llvm -o - %s -fexceptions -std=c++11 -fblocks")./*|*/
      I("FileCheck -check-prefix=MRC %s");
  }

  @Test
  public void test_literals_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/literals.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -I ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/Inputs -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -fexceptions -fobjc-exceptions -fcxx-exceptions -fobjc-arc-exceptions -O2 -disable-llvm-optzns -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/literals.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/literals.mm
    RUN(TestState.Failed, "%clang_cc1 -I %S/Inputs -triple x86_64-apple-darwin10 -emit-llvm -fblocks -fobjc-arc -fobjc-runtime-has-weak -fexceptions -fobjc-exceptions -fcxx-exceptions -fobjc-arc-exceptions -O2 -disable-llvm-optzns -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_lvalue_reference_getter_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/lvalue-reference-getter.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/lvalue-reference-getter.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/lvalue-reference-getter.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/mangle.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/mangle.mm -triple=x86_64-apple-darwin10 -std=c++11 -emit-llvm -fblocks -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/mangle.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -std=c++11 -emit-llvm -fblocks -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mangle_blocks_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/mangle-blocks.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -fblocks -o - -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/mangle-blocks.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/mangle-blocks.mm
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -fblocks -o - -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_message_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/message.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-10.7 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/message.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/message.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-10.7 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_message_reference_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/message-reference.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/message-reference.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/message-reference.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_method_local_extern_mangle_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/method-local-extern-mangle.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/method-local-extern-mangle.mm -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/method-local-extern-mangle.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_microsoft_abi_arc_param_order_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/microsoft-abi-arc-param-order.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -mconstructor-aliases -fobjc-arc -triple i686-pc-win32 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/microsoft-abi-arc-param-order.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/microsoft-abi-arc-param-order.mm
    RUN(TestState.Failed, "%clang_cc1 -mconstructor-aliases -fobjc-arc -triple i686-pc-win32 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_mrc_weak_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/mrc-weak.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-10.10 -emit-llvm -fblocks -fobjc-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/mrc-weak.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/mrc-weak.mm -check-prefix=CHECK -check-prefix=CHECK-MODERN
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-10.10 -emit-llvm -fblocks -fobjc-weak -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-MODERN");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.10 -emit-llvm -fblocks -fobjc-weak -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/mrc-weak.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/mrc-weak.mm -check-prefix=CHECK -check-prefix=CHECK-FRAGILE
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-darwin10 -fobjc-runtime=macosx-fragile-10.10 -emit-llvm -fblocks -fobjc-weak -o - %s")./*|*/
      I("FileCheck %s -check-prefix=CHECK -check-prefix=CHECK-FRAGILE");
  }

  @Test
  public void test_nested_ehlocation_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/nested-ehlocation.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-macosx -emit-llvm -debug-info-kind=limited -stdlib=libc++ -fblocks -fexceptions -x objective-c++ -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/nested-ehlocation.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/nested-ehlocation.mm
    RUN(TestState.Failed, "%clang_cc1  -triple x86_64-apple-macosx -emit-llvm -debug-info-kind=limited -stdlib=libc++ -fblocks -fexceptions -x objective-c++ -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_nrvo_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/nrvo.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -o - -fblocks ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/nrvo.mm -O1 -triple x86_64-apple-darwin10.0.0 -fobjc-runtime=macosx-fragile-10.5 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/nrvo.mm
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -o - -fblocks %s -O1 -triple x86_64-apple-darwin10.0.0 -fobjc-runtime=macosx-fragile-10.5")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_container_subscripting_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/objc-container-subscripting.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/objc-container-subscripting.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/objc-container-subscripting.mm
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_objc_container_subscripting_1_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/objc-container-subscripting-1.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm -triple x86_64-apple-darwin -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/objc-container-subscripting-1.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/objc-container-subscripting-1.mm
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm -triple x86_64-apple-darwin -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_personality_abuse_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/personality-abuse.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -fobjc-exceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/personality-abuse.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/personality-abuse.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ -triple x86_64-apple-darwin10 -emit-llvm -fcxx-exceptions -fexceptions -fobjc-exceptions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_pr14474_gline_tables_only_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/pr14474-gline-tables-only.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-apple-macosx10.6.0 -emit-llvm -debug-info-kind=line-tables-only -x objective-c++ -o /dev/null ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/pr14474-gline-tables-only.mm
    RUN(TestState.Failed, "%clang_cc1 -triple i386-apple-macosx10.6.0 -emit-llvm -debug-info-kind=line-tables-only -x objective-c++ -o /dev/null %s");
  }

  @Test
  public void test_property_derived_to_base_conv_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-derived-to-base-conv.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-derived-to-base-conv.mm
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s");
  }

  @Test
  public void test_property_dot_copy_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-dot-copy.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-dot-copy.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-dot-copy.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_dot_reference_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-dot-reference.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-dot-reference.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-dot-reference.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -fexceptions -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_lvalue_capture_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-lvalue-capture.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-lvalue-capture.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-lvalue-capture.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_object_conditional_exp_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-conditional-exp.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-conditional-exp.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-conditional-exp.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_object_reference_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-reference.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-reference.mm -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-reference.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_object_reference_1_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-reference-1.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x objective-c++ ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-reference-1.mm -triple x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-reference-1.mm
    RUN(TestState.Failed, "%clang_cc1 -x objective-c++ %s -triple x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_object_reference_2_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-reference-2.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-reference-2.mm -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-10.7 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-reference-2.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-10.7 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-reference-2.mm -triple x86_64-unknown-freebsd -fobjc-runtime=gnustep-1.7 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-GNUSTEP ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-object-reference-2.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-unknown-freebsd -fobjc-runtime=gnustep-1.7 -emit-llvm -o -")./*|*/
      I("FileCheck -check-prefix=CHECK-GNUSTEP %s");
  }

  @Test
  public void test_property_objects_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-objects.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-objects.mm -triple=x86_64-apple-darwin10 -std=c++11 -emit-llvm -debug-info-kind=limited -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-objects.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -std=c++11 -emit-llvm -debug-info-kind=limited -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_reference_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-reference.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-reference.mm -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/property-reference.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_refence_assign_write_barrier_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/refence-assign-write-barrier.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/refence-assign-write-barrier.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/refence-assign-write-barrier.mm
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_references_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/references.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/references.mm -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/references.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_rtti_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/rtti.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/rtti.mm -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/rtti.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_selector_expr_lvalue_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/selector-expr-lvalue.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/selector-expr-lvalue.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/selector-expr-lvalue.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5  -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_subst_sel_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/subst-sel.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/subst-sel.mm -triple=x86_64-apple-darwin10 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/subst-sel.mm
    RUN(TestState.Failed, "%clang_cc1 %s -triple=x86_64-apple-darwin10 -emit-llvm -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_unknown_anytype_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/unknown-anytype.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-apple-darwin10 -fdebugger-support -funknown-anytype -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/unknown-anytype.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/unknown-anytype.mm
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-apple-darwin10 -fdebugger-support -funknown-anytype -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_write_barrier_global_assign_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/write-barrier-global-assign.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/write-barrier-global-assign.mm | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/CodeGenObjCXX/write-barrier-global-assign.mm
    RUN(TestState.Failed, "%clang_cc1 -fobjc-gc -triple x86_64-apple-darwin10 -fobjc-runtime=macosx-fragile-10.5 -emit-llvm -o - %s")./*|*/
      I("FileCheck %s");
  }
  
}
