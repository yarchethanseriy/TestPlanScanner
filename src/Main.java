import java.util.List;

public class Main {

    public static void main(String[] args) {
        int stepNum = 1;
        List<TestStep> testPlan = TestPlanScanner.buildPlan(Checklist.class);

        for (TestStep testStep : testPlan) {
            System.out.println(stepNum + ". " + testStep.id() + " -> " + testStep.methodName());
            stepNum++;
        }
    }
}