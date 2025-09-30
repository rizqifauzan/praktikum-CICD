package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class TestRailClient {
    private String baseUrl;
    private String username;
    private String password;

    public TestRailClient() {
        this.baseUrl = "https://rizqi32.testrail.io"; // Ganti dengan URL TestRail Anda
        this.username = "sipena.id@gmail.com"; // Ganti dengan username email Anda
        this.password = "Coba@123"; // Ganti dengan API Key atau password
    }

    public Response addResult(int runId, int caseId, int statusId, String comment) {
        String endpoint = String.format("%s/index.php?/api/v2/add_result_for_case/%d/%d",
                baseUrl, runId, caseId);

        Map<String, Object> body = new HashMap<>();
        body.put("status_id", statusId);
        body.put("comment", comment);

        return RestAssured.given()
                .auth()
                .preemptive()
                .basic(username, password) // username + API Key atau password
                .header("Content-Type", "application/json")
                .body(body)
                .post(endpoint);
    }
}
