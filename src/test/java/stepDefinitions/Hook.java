package stepDefinitions;

import helper.TestRailClient;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hook {

    private final int runId = 17; // ID Test Run di TestRail

    @After
    public void afterScenario(Scenario scenario) {
        try {
            // Cari tag @C1234 (Case ID)
            String caseIdTag = scenario.getSourceTagNames()
                    .stream()
                    .filter(tag -> tag.startsWith("@C"))
                    .findFirst()
                    .orElse(null);

            if (caseIdTag != null) {
                int caseId = Integer.parseInt(caseIdTag.substring(2));
                int statusId = scenario.isFailed() ? 5 : 1; // 1=Passed, 5=Failed

                TestRailClient client = new TestRailClient();
                client.addResult(runId, caseId, statusId,
                        "Executed via Cucumber. Status: " + scenario.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
