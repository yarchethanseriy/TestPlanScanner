import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestPlanScanner {

    public static List<TestStep> buildPlan(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        List<TestStep> testSteps = new ArrayList<>();
        for (Method m : methods) {

            if (m.isAnnotationPresent(TestId.class)) {
                TestId annotation = m.getAnnotation(TestId.class);
                TestStep step = new TestStep(
                        annotation.value(),
                        m.getName(),
                        annotation.order()

                );
                testSteps.add(step);
            }
        }
        testSteps.sort(Comparator.comparingInt(TestStep::order));

        if (testSteps.isEmpty()) {
            System.out.println("Кейсов нет.");
        }

        return testSteps;
    }

}
