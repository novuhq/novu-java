package co.novu.api.workflowoverride;

import co.novu.api.common.PreferenceSettings;
import co.novu.api.workflowgroups.WorkflowGroupHandler;
import co.novu.api.workflowoverrides.WorkflowOverrideHandler;
import co.novu.api.workflowoverrides.pojos.WorkflowOverride;
import co.novu.api.workflowoverrides.request.CreateWorkflowOverrideRequest;
import co.novu.api.workflowoverrides.request.GetWorkflowOverrideRequest;
import co.novu.api.workflowoverrides.request.UpdateWorkflowOverrideRequest;
import co.novu.api.workflowoverrides.response.BulkWorkflowOverridesResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

import com.google.gson.Gson;

public class WorkflowOverrideHandlerTest extends TestCase {

    private WorkflowOverrideHandler workflowOverrideHandler;

    private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
        mockWebServer = new MockWebServer();
        NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        workflowOverrideHandler = new WorkflowOverrideHandler(restHandler);
    }

    public void test_createWorkflowOverrideHandler() throws IOException, NovuNetworkException, InterruptedException {
        WorkflowOverride workflowOverrideResponse = getWorkflowOverride();

        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(201).setBody(gson.toJson(workflowOverrideResponse)));

        CreateWorkflowOverrideRequest createWorkflowOverrideRequest = getCreateWorkflowOverrideRequest();

        WorkflowOverride response = workflowOverrideHandler.createWorkflowOverride(createWorkflowOverrideRequest);
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/workflow-overrides", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(workflowOverrideResponse), gson.toJson(response));
    }

    public void test_getWorkflowOverrides() throws IOException, NovuNetworkException, InterruptedException {
        BulkWorkflowOverridesResponse bulkWorkflowOverridesResponse = getBulkWorkflowOverridesResponse();
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(bulkWorkflowOverridesResponse)));
        GetWorkflowOverrideRequest getWorkflowOverrideRequest = new GetWorkflowOverrideRequest();
        getWorkflowOverrideRequest.setPage(1);
        getWorkflowOverrideRequest.setLimit(10);
        BulkWorkflowOverridesResponse response = workflowOverrideHandler.getWorkflowOverrides(getWorkflowOverrideRequest);
        assertNotNull(response);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/workflow-overrides?limit=10&page=1", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(bulkWorkflowOverridesResponse), gson.toJson(response));
    }

    public void test_getWorkflowOverrideById() throws IOException, NovuNetworkException, InterruptedException {
        WorkflowOverride workflowOverrideResponse = getWorkflowOverride();
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(workflowOverrideResponse)));
        WorkflowOverride response = workflowOverrideHandler.getWorkflowOverrideById("8329rufivdsnvs9u334");
        assertNotNull(response);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/workflow-overrides/8329rufivdsnvs9u334", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(workflowOverrideResponse), gson.toJson(response));
    }

    public void test_getWorkflowOverride() throws IOException, NovuNetworkException, InterruptedException {
        WorkflowOverride workflowOverrideResponse = getWorkflowOverride();
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(workflowOverrideResponse)));
        WorkflowOverride response = workflowOverrideHandler.getWorkflowOverride("8329rufivdsnvs9u334", "wvnq340i2jfwqv392");
        assertNotNull(response);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/workflow-overrides/workflows/8329rufivdsnvs9u334/tenants/wvnq340i2jfwqv392", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(workflowOverrideResponse), gson.toJson(response));
    }

    public void test_updateWorkflowOverrideById() throws IOException, NovuNetworkException, InterruptedException {
        WorkflowOverride workflowOverrideResponse = getWorkflowOverride();
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(workflowOverrideResponse)));
        UpdateWorkflowOverrideRequest updateRequest = getUpdateWorkflowOverrideRequest();
        WorkflowOverride response = workflowOverrideHandler.updateWorkflowOverrideById("8329rufivdsnvs9u334", updateRequest);
        assertNotNull(response);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/workflow-overrides/8329rufivdsnvs9u334", request.getPath());
        assertEquals("PUT", request.getMethod());
        assertEquals(gson.toJson(workflowOverrideResponse), gson.toJson(response));
    }

    public void test_updateWorkflowOverride() throws IOException, NovuNetworkException, InterruptedException {
        WorkflowOverride workflowOverrideResponse = getWorkflowOverride();
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(workflowOverrideResponse)));
        UpdateWorkflowOverrideRequest updateRequest = getUpdateWorkflowOverrideRequest();
        WorkflowOverride response = workflowOverrideHandler.updateWorkflowOverride("8329rufivdsnvs9u334", "wvnq340i2jfwqv392",
            updateRequest);
        assertNotNull(response);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/workflow-overrides/workflows/8329rufivdsnvs9u334/tenants/wvnq340i2jfwqv392", request.getPath());
        assertEquals("PUT", request.getMethod());
        assertEquals(gson.toJson(workflowOverrideResponse), gson.toJson(response));
    }

    public void test_deleteWorkflowOverride() throws IOException, NovuNetworkException, InterruptedException {
        WorkflowOverride workflowOverrideResponse = getWorkflowOverride();
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(workflowOverrideResponse)));
        WorkflowOverride response = workflowOverrideHandler.deleteWorkflowOverride("8329rufivdsnvs9u334");
        assertNotNull(response);
        RecordedRequest request = mockWebServer.takeRequest();
        assertEquals("/workflow-overrides/8329rufivdsnvs9u334", request.getPath());
        assertEquals("DELETE", request.getMethod());
        assertEquals(gson.toJson(workflowOverrideResponse), gson.toJson(response));
    }

    private PreferenceSettings getPreferenceSettings() {
        PreferenceSettings preferenceSettings = new PreferenceSettings();
        preferenceSettings.setChat(true);
        preferenceSettings.setSms(true);
        preferenceSettings.setPush(true);
        preferenceSettings.setEmail(true);
        preferenceSettings.setIn_app(true);
        return preferenceSettings;
    }

    private WorkflowOverride getWorkflowOverride() {
        WorkflowOverride workflowOverride = new WorkflowOverride();
        workflowOverride.set_id("_id");
        workflowOverride.set_workflowId("workflowId(_id");
        workflowOverride.set_environmentId("environmentId_id");
        workflowOverride.set_tenantId("tenantId_id");
        workflowOverride.set_tenantId("tenantId_id");
        workflowOverride.setPreferenceSettings(getPreferenceSettings());
        return workflowOverride;
    }

    private CreateWorkflowOverrideRequest getCreateWorkflowOverrideRequest(){
        CreateWorkflowOverrideRequest createWorkflowOverrideRequest = new CreateWorkflowOverrideRequest();
        createWorkflowOverrideRequest.setPreferenceSettings(getPreferenceSettings());
        createWorkflowOverrideRequest.setActive(true);
        createWorkflowOverrideRequest.setTenantId("8329rufivdsnvs9u334");
        createWorkflowOverrideRequest.setWorkflowId("wvnq340i2jfwqv392");
        return createWorkflowOverrideRequest;
    }

    private BulkWorkflowOverridesResponse getBulkWorkflowOverridesResponse(){
        BulkWorkflowOverridesResponse bulkWorkflowOverridesResponse = new BulkWorkflowOverridesResponse();
        bulkWorkflowOverridesResponse.setData(List.of(getWorkflowOverride(), getWorkflowOverride()));
        bulkWorkflowOverridesResponse.setHasMore(true);
        bulkWorkflowOverridesResponse.setPageSize(10L);
        bulkWorkflowOverridesResponse.setPage(1L);
        return bulkWorkflowOverridesResponse;
    }

    private UpdateWorkflowOverrideRequest getUpdateWorkflowOverrideRequest(){
        UpdateWorkflowOverrideRequest updateWorkflowOverrideRequest = new UpdateWorkflowOverrideRequest();
        updateWorkflowOverrideRequest.setActive(true);
        updateWorkflowOverrideRequest.setData(getPreferenceSettings());
        return updateWorkflowOverrideRequest;
    }

}
