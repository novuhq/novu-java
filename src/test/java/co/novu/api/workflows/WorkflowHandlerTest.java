package co.novu.api.workflows;

import co.novu.api.common.Trigger;
import co.novu.api.blueprints.pojos.Blueprint;
import co.novu.api.common.NotificationGroup;
import co.novu.api.common.PreferenceSettings;
import co.novu.api.workflows.requests.UpdateWorkflowRequest;
import co.novu.api.workflows.requests.UpdateWorkflowStatusRequest;
import co.novu.api.workflows.requests.WorkflowRequest;
import co.novu.api.workflows.responses.BulkWorkflowResponse;
import co.novu.api.workflows.responses.DeleteWorkflowResponse;
import co.novu.api.workflows.responses.SingleWorkflowResponse;
import co.novu.api.workflows.responses.WorkflowResponse;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import co.novu.common.rest.NovuNetworkException;
import com.google.gson.Gson;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.mockito.Mockito;

public class WorkflowHandlerTest extends TestCase {
    private WorkflowHandler workflowHandler;

 private MockWebServer mockWebServer;

    @Override
    protected void setUp() {
        mockWebServer = new MockWebServer();
        NovuConfig novuConfig = new NovuConfig("1234");
        novuConfig.setBaseUrl(mockWebServer.url("").toString());
        RestHandler restHandler = new RestHandler(novuConfig);
        workflowHandler = new WorkflowHandler(restHandler);
    }

    public void test_getWorkflows() {
        BulkWorkflowResponse workflowResponse = new BulkWorkflowResponse();
        workflowResponse.setPage(2L);
        workflowResponse.setPageSize(20L);
        workflowResponse.setTotalCount(200L);
        workflowResponse.setData(Collections.singletonList(new WorkflowResponse()));
        Mockito.doReturn(workflowResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());


        BulkWorkflowResponse response = workflowHandler.getWorkflows(12,13);
        assertNotNull(response);
        assertEquals(workflowResponse, response);
        Mockito.verify(restHandler, Mockito.never()).handleGet(Mockito.any(), Mockito.any(), Mockito.any());
    }


    public void test_createWorkflow() {
        WorkflowRequest workflowRequest = new WorkflowRequest();
        workflowRequest.setDescription("Desc");
        workflowRequest.setActive(false);
        workflowRequest.setName("name");
        workflowRequest.setDraft(false);
        PreferenceSettings preferenceSettings = new PreferenceSettings();
        preferenceSettings.setEmail(true);
        preferenceSettings.setSms(true);
        preferenceSettings.setIn_app(true);
        preferenceSettings.setPush(true);
        preferenceSettings.setChat(true);
        workflowRequest.setPreferenceSettings(preferenceSettings);
        workflowRequest.setCritical(false);
        workflowRequest.setTags(List.of());
        workflowRequest.setSteps(List.of());
        workflowRequest.setNotificationGroupId("notificationId");
        NotificationGroup notificationGroup1 = new NotificationGroup();
        notificationGroup1.set_id("id");
        notificationGroup1.setName("name");
        notificationGroup1.set_environmentId("environmentId");
        notificationGroup1.set_organizationId("organizationId");
        notificationGroup1.set_parentId("parentId");



        SingleWorkflowResponse singleWorkflowResponse = new SingleWorkflowResponse();
        WorkflowResponse data = new WorkflowResponse();
        data.set_id("id");
        data.setDescription("Desc");
        data.setActive(false);
        data.setName("name");
        data.setDraft(false);
        PreferenceSettings preferenceSettings1 = new PreferenceSettings();
        preferenceSettings1.setEmail(true);
        preferenceSettings1.setSms(true);
        preferenceSettings1.setIn_app(true);
        preferenceSettings1.setPush(true);
        preferenceSettings1.setChat(true);
        data.setPreferenceSettings(preferenceSettings1);
        data.setCritical(false);
        data.setTags(List.of());
        data.setSteps(List.of());
        data.set_organizationId("organizationId");
        data.set_creatorId("creatorId");
        data.set_environmentId("environmentId");
        data.setTriggers(Collections.singletonList(new Trigger()));
        data.setNotificationGroupId("notificationId");
        data.setDeleted(false);
        data.setDeletedAt("deletedAt");
        data.setDeletedBy("deletedBy");
        NotificationGroup notificationGroup2 = new NotificationGroup();
        notificationGroup2.set_id("id");
        notificationGroup2.setName("name");
        notificationGroup2.set_environmentId("environmentId");
        notificationGroup2.set_organizationId("organizationId");
        notificationGroup2.set_parentId("parentId");
        data.setNotificationGroup(notificationGroup2);
        data.setIsBlueprint(false);
        singleWorkflowResponse.setData(data);

        Mockito.doReturn(singleWorkflowResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        SingleWorkflowResponse response = workflowHandler.createWorkflow(workflowRequest);
        assertNotNull(response);
        assertEquals(singleWorkflowResponse, response);
    }

    public void test_updateWorkflow() {
        UpdateWorkflowRequest workflowRequest = new UpdateWorkflowRequest();
        workflowRequest.setDescription("Desc");
        workflowRequest.setActive(false);
        workflowRequest.setName("name");
        workflowRequest.setDraft(false);
        PreferenceSettings preferenceSettings = new PreferenceSettings();
        preferenceSettings.setEmail(true);
        preferenceSettings.setSms(true);
        preferenceSettings.setIn_app(true);
        preferenceSettings.setPush(true);
        preferenceSettings.setChat(true);
        workflowRequest.setPreferenceSettings(preferenceSettings);
        workflowRequest.setCritical(false);
        workflowRequest.setTags(List.of());
        workflowRequest.setSteps(List.of());
        workflowRequest.setNotificationGroupId("notificationId");
        NotificationGroup notificationGroup1 = new NotificationGroup();
        notificationGroup1.set_id("id");
        notificationGroup1.setName("name");
        notificationGroup1.set_environmentId("environmentId");
        notificationGroup1.set_organizationId("organizationId");
        notificationGroup1.set_parentId("parentId");

        SingleWorkflowResponse singleWorkflowResponse = new SingleWorkflowResponse();
        WorkflowResponse data = new WorkflowResponse();
        data.set_id("id");
        data.setDescription("Desc");
        data.setActive(false);
        data.setName("name");
        data.setDraft(false);
        PreferenceSettings preferenceSettings1 = new PreferenceSettings();
        preferenceSettings1.setEmail(true);
        preferenceSettings1.setSms(true);
        preferenceSettings1.setIn_app(true);
        preferenceSettings1.setPush(true);
        preferenceSettings1.setChat(true);
        data.setPreferenceSettings(preferenceSettings1);
        data.setCritical(false);
        data.setTags(List.of());
        data.setSteps(List.of());
        data.set_organizationId("organizationId");
        data.set_creatorId("creatorId");
        data.set_environmentId("environmentId");
        data.setTriggers(Collections.singletonList(new Trigger()));
        data.setNotificationGroupId("notificationId");
        data.setDeleted(false);
        data.setDeletedAt("deletedAt");
        data.setDeletedBy("deletedBy");
        NotificationGroup notificationGroup2 = new NotificationGroup();
        notificationGroup2.set_id("id");
        notificationGroup2.setName("name");
        notificationGroup2.set_environmentId("environmentId");
        notificationGroup2.set_organizationId("organizationId");
        notificationGroup2.set_parentId("parentId");
        data.setNotificationGroup(notificationGroup2);
        data.setIsBlueprint(false);
        singleWorkflowResponse.setData(data);

        Mockito.doReturn(singleWorkflowResponse).when(restHandler).handlePut(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        SingleWorkflowResponse response = workflowHandler.updateWorkflow("workflowid",workflowRequest);
        assertNotNull(response);
        assertEquals(singleWorkflowResponse, response);
    }

    public void test_deleteWorkflow() {
        DeleteWorkflowResponse deleteWorkflowResponse = new DeleteWorkflowResponse();
        deleteWorkflowResponse.setData(false);

        Mockito.doReturn(deleteWorkflowResponse).when(restHandler).handleDelete(Mockito.any(), Mockito.any(), Mockito.any());

        DeleteWorkflowResponse response = workflowHandler.deleteWorkflow("workflowId");
        assertNotNull(response);
        assertEquals(deleteWorkflowResponse, response);
    }

    public void test_getWorkflow()throws IOException, NovuNetworkException, InterruptedException {
        SingleWorkflowResponse singleWorkflowResponse = new SingleWorkflowResponse();
        WorkflowResponse data = new WorkflowResponse();
        data.set_id("id");
        data.setDescription("Desc");
        data.setActive(false);
        data.setName("name");
        data.setDraft(false);
        PreferenceSettings preferenceSettings1 = new PreferenceSettings();
        preferenceSettings1.setEmail(true);
        preferenceSettings1.setSms(true);
        preferenceSettings1.setIn_app(true);
        preferenceSettings1.setPush(true);
        preferenceSettings1.setChat(true);
        data.setPreferenceSettings(preferenceSettings1);
        data.setCritical(false);
        data.setTags(List.of());
        data.setSteps(List.of());
        data.set_organizationId("organizationId");
        data.set_creatorId("creatorId");
        data.set_environmentId("environmentId");
        data.setTriggers(Collections.singletonList(new Trigger()));
        data.setNotificationGroupId("notificationId");
        data.setDeleted(false);
        data.setDeletedAt("deletedAt");
        data.setDeletedBy("deletedBy");
        NotificationGroup notificationGroup2 = new NotificationGroup();
        notificationGroup2.set_id("id");
        notificationGroup2.setName("name");
        notificationGroup2.set_environmentId("environmentId");
        notificationGroup2.set_organizationId("organizationId");
        notificationGroup2.set_parentId("parentId");
        data.setNotificationGroup(notificationGroup2);
        data.setIsBlueprint(false);
        singleWorkflowResponse.setData(data);

       Gson gson = new Gson();
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(gson.toJson(blueprint)));

        String templateId = "tId";
        Workflow response = blueprintsHandler.getBlueprint(templateId);
        RecordedRequest request = mockWebServer.takeRequest();

        // SingleWorkflowResponse response = workflowHandler.getWorkflow("workflowId");
        // assertNotNull(response);
        // assertEquals(singleWorkflowResponse, response);
        assertEquals("/workflows/" + templateId, request.getPath());
        assertEquals("GET", request.getMethod());
        assertEquals(gson.toJson(blueprint), gson.toJson(response));
    }

    public void test_updateWorkflowStatus() {
        SingleWorkflowResponse singleWorkflowResponse = new SingleWorkflowResponse();
        WorkflowResponse data = new WorkflowResponse();
        data.set_id("id");
        data.setDescription("Desc");
        data.setActive(false);
        data.setName("name");
        data.setDraft(false);
        PreferenceSettings preferenceSettings1 = new PreferenceSettings();
        preferenceSettings1.setEmail(true);
        preferenceSettings1.setSms(true);
        preferenceSettings1.setIn_app(true);
        preferenceSettings1.setPush(true);
        preferenceSettings1.setChat(true);
        data.setPreferenceSettings(preferenceSettings1);
        data.setCritical(false);
        data.setTags(List.of());
        data.setSteps(List.of());
        data.set_organizationId("organizationId");
        data.set_creatorId("creatorId");
        data.set_environmentId("environmentId");
        data.setTriggers(Collections.singletonList(new Trigger()));
        data.setNotificationGroupId("notificationId");
        data.setDeleted(false);
        data.setDeletedAt("deletedAt");
        data.setDeletedBy("deletedBy");
        NotificationGroup notificationGroup2 = new NotificationGroup();
        notificationGroup2.set_id("id");
        notificationGroup2.setName("name");
        notificationGroup2.set_environmentId("environmentId");
        notificationGroup2.set_organizationId("organizationId");
        notificationGroup2.set_parentId("parentId");
        data.setNotificationGroup(notificationGroup2);
        data.setIsBlueprint(false);
        singleWorkflowResponse.setData(data);

        Mockito.doReturn(singleWorkflowResponse).when(restHandler).handlePut(Mockito.any(),Mockito.any(), Mockito.any(), Mockito.any());
        UpdateWorkflowStatusRequest updateWorkflowStatusRequest = new UpdateWorkflowStatusRequest();
        updateWorkflowStatusRequest.setActive(false);

        SingleWorkflowResponse response = workflowHandler.updateWorkflowStatus("workflowId",updateWorkflowStatusRequest);
        assertNotNull(response);
        assertEquals(singleWorkflowResponse, response);
    }


}
