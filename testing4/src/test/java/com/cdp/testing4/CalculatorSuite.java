package com.cdp.testing4;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {CalculatorPositiveTest.class, CalculatorNegativeTest.class})
public class CalculatorSuite {

}
