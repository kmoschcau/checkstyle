/*xml
<module name="Checker">
  <module name="TreeWalker">
    <module name="CyclomaticComplexity"/>
  </module>
</module>
*/
package com.puppycrawl.tools.checkstyle.checks.metrics.cyclomaticcomplexity;

// xdoc section -- start
class Example1 {
  int a, b, c, d, e, n;

  public void testMethod1() {
    while (a < b && a > c) {
      fun1();
    }
    if (a == b) {
      do {
        fun1();
      } while (d==a);
    } else if (c == d) {
      while (c > 0) {
        fun1();
      }
      do {
        fun1();
      } while (a==d);
    }
  }
  // violation below, 'Cyclomatic Complexity is 13 (max allowed is 10)'
  public void testMethod2() { // 1, function declaration
    if (a == b) { // 2, if
      fun1();
    } else if (a == 0 // 3, if
      && b == c) { // 4, && operator
      if (c == -1) { // 5, if
        fun1();
      }
    } else if (a == c // 6, if
      || a == d) { // 7, || operator
      fun1();
    } else if (d == e) { //8, if
      try {
        fun1();
      } catch (Exception e) { // 9, catch
      }
    } else {
      switch(n) {
        case 1: // 10, case
          fun1();
          break;
        case 2: // 11, case
          fun1();
          break;
        case 3: // 12, case
          fun1();
          break;
        default:
          break;
      }
    }
    a = a > 0 ? b : c; // 13, ternary operator
  }
  private void fun1() {}
}
// xdoc section -- end