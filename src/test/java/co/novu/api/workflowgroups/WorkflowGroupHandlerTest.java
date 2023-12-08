package co.novu.api.workflowgroups;

import java.io.IOException;
import java.util.Collections;

import com.google.gson.Gson;

import co.novu.api.workflowgroups.request.WorkflowGroupRequest;
import co.novu.api.workflowgroups.responses.DeleteWorkflowGroup;
import co.novu.api.workflowgroups.responses.GetWorkflowGroupsResponse;
import co.novu.api.workflowgroups.responses.WorkflowGroupResponse;
import co.novu.api.workflowgroups.responses.WorkflowGroupResponseData;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class WorkflowGroupHandlerTest extends TestCase {
    private WorkflowGroupHandler workflowGroupHandler;

    private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
        mockWebServer = new MockWebServer();
        NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        workflowGroupHandler = new WorkflowGroupHandler(restHandler);
    }

    public void test_createWorkflowGroup() throws InterruptedException, NovuNetworkException, IOException {
        WorkflowGroupRequest workflowGroupRequest = new WorkflowGroupRequest();
        workflowGroupRequest.setName("fname");

        WorkflowGroupResponse workflowGroupResponse = new WorkflowGroupResponse();
        WorkflowGroupResponseData data = new WorkflowGroupResponseData();
        data.set_id("id");
        data.setName("name");
        data.set_organizationId("organizationId");
        data.set_environmentId("environmentId");
        data.set_parentId("parentId");
        workflowGroupResponse.setData(data);

         Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(workflowGroupResponse)));

        WorkflowGroupResponse response = workflowGroupHandler.createWorkflowGroup(workflowGroupRequest);
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/notification-groups", request.getPath());
        assertEquals("POST", request.getMethod());
        assertEquals(gson.toJson(workflowGroupResponse), gson.toJson(response));
    }

    public void test_getWorkflowGroups() throws InterruptedException, NovuNetworkException, IOException {
        GetWorkflowGroupsResponse getWorkflowGroupsResponse = new GetWorkflowGroupsResponse();
        getWorkflowGroupsResponse.setData(Collections.singletonList(new WorkflowGroupResponseData()));
        
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(getWorkflowGroupsResponse)));

        GetWorkflowGroupsResponse response = workflowGroupHandler.getWorkflowGroups();
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/notification-groups", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(getWorkflowGroupsResponse), gson.toJson(response));
    }

    public void test_getWorkflowGroup() throws NovuNetworkException, IOException, InterruptedException {

        WorkflowGroupResponse workflowGroupResponse = new WorkflowGroupResponse();
        WorkflowGroupResponseData data = new WorkflowGroupResponseData();
        data.set_id("id");
        data.setName("name");
        data.set_organizationId("organizationId");
        data.set_environmentId("environmentId");
        data.set_parentId("parentId");
        workflowGroupResponse.setData(data);
       
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(workflowGroupResponse)));

        WorkflowGroupResponse response = workflowGroupHandler.getWorkflowGroup(data.get_id());
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/notification-groups/id", request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(workflowGroupResponse), gson.toJson(response));
    }

    public void test_updateWorkflowGroup() throws NovuNetworkException, IOException, InterruptedException {

        WorkflowGroupRequest workflowGroupRequest = new WorkflowGroupRequest();
        workflowGroupRequest.setName("fname");

        WorkflowGroupResponse workflowGroupResponse = new WorkflowGroupResponse();
        WorkflowGroupResponseData data = new WorkflowGroupResponseData();
        data.set_id("id");
        data.setName("name");
        data.set_organizationId("organizationId");
        data.set_environmentId("environmentId");
        data.set_parentId("parentId");
        workflowGroupResponse.setData(data);
        
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(workflowGroupResponse)));

        WorkflowGroupResponse response = workflowGroupHandler.updateWorkflowGroup(data.get_id(), workflowGroupRequest);
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/notification-groups/id", request.getPath());
        assertEquals("PUT", request.getMethod());
        assertEquals(gson.toJson(workflowGroupResponse), gson.toJson(response));
    }

    public void test_deleteWorkflowGroup() throws NovuNetworkException, IOException, InterruptedException {
        DeleteWorkflowGroup deleteWorkflowGroup = new DeleteWorkflowGroup();
        deleteWorkflowGroup.setAcknowledged(false);
        deleteWorkflowGroup.setStatus("success");
        
        Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(deleteWorkflowGroup)));

        DeleteWorkflowGroup response = workflowGroupHandler.deleteWorkflowGroup("id");
        RecordedRequest request = mockWebServer.takeRequest();

        assertEquals("/notification-groups/id", request.getPath());
        assertEquals("DELETE", request.getMethod());
        assertEquals(gson.toJson(deleteWorkflowGroup), gson.toJson(response));
    }

}
