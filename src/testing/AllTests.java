package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	JUnitTest.class,
	JUnitTest1.class,
	JUnitTest2.class
	})
public class AllTests {

}
