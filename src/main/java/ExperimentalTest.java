import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

public class ExperimentalTest {
    public static void main(String[] args) {
        //JUnitCore.runClasses(new Class[] {TaskUtil.class });
        Result result = new JUnitCore().run(Request.method(RealTest.class,"test_experimental"));
        System.out.println(result.wasSuccessful());
        System.out.println(result.getFailures());
        System.out.println(result.getRunCount());
    }
}