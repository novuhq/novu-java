package co.novu.api.workflowgroups;

import co.novu.api.workflowgroups.request.WorkflowGroupRequest;
import co.novu.api.workflowgroups.responses.DeleteWorkflowGroup;
import co.novu.api.workflowgroups.responses.GetWorkflowGroupsResponse;
import co.novu.api.workflowgroups.responses.WorkflowGroupResponse;
import co.novu.api.workflowgroups.responses.WorkflowGroupResponseData;
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

import java.util.Collections;

public class WorkflowGroupHandlerTest extends TestCase {
    private WorkflowGroupHandler workflowGroupHandler;

    private RestHandler restHandler;

    @Override
    protected void setUp() {
        restHandler = Mockito.mock(RestHandler.class);
        NovuConfig novuConfig = Mockito.mock(NovuConfig.class);
        workflowGroupHandler = Mockito.spy(new WorkflowGroupHandler(restHandler, novuConfig));
    }

    public void test_createWorkflowGroup() {
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

        Mockito.doReturn(workflowGroupResponse).when(restHandler).handlePost(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());

        WorkflowGroupResponse response = workflowGroupHandler.createWorkflowGroup(workflowGroupRequest);
        assertNotNull(response);
        assertEquals(workflowGroupResponse, response);
    }

    public void test_getWorkflowGroups() {
        GetWorkflowGroupsResponse getWorkflowGroupsResponse = new GetWorkflowGroupsResponse();
        getWorkflowGroupsResponse.setData(Collections.singletonList(new WorkflowGroupResponseData()));
        Mockito.doReturn(getWorkflowGroupsResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        GetWorkflowGroupsResponse response = workflowGroupHandler.getWorkflowGroups();
        assertNotNull(response);
        assertEquals(getWorkflowGroupsResponse, response);
    }

    public void test_getWorkflowGroup() {

        WorkflowGroupResponse workflowGroupResponse = new WorkflowGroupResponse();
        WorkflowGroupResponseData data = new WorkflowGroupResponseData();
        data.set_id("id");
        data.setName("name");
        data.set_organizationId("organizationId");
        data.set_environmentId("environmentId");
        data.set_parentId("parentId");
        workflowGroupResponse.setData(data);
        Mockito.doReturn(workflowGroupResponse).when(restHandler).handleGet(Mockito.any(), Mockito.any(), Mockito.any());

        WorkflowGroupResponse response = workflowGroupHandler.getWorkflowGroup("12");
        assertNotNull(response);
        assertEquals(workflowGroupResponse, response);
    }

    public void test_updateWorkflowGroup() {

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
        Mockito.doReturn(workflowGroupResponse).when(restHandler).handlePatch(Mockito.any(),Mockito.any(), Mockito.any(), Mockito.any());

        WorkflowGroupResponse response = workflowGroupHandler.updateWorkflowGroup("12",workflowGroupRequest);
        assertNotNull(response);
        assertEquals(workflowGroupResponse, response);
    }

    public void test_deleteWorkflowGroup() {
        DeleteWorkflowGroup deleteWorkflowGroup = new DeleteWorkflowGroup();
        deleteWorkflowGroup.setAcknowledged(false);
        deleteWorkflowGroup.setStatus("success");
        Mockito.doReturn(deleteWorkflowGroup).when(restHandler).handleDelete(Mockito.any(), Mockito.any(), Mockito.any());

        DeleteWorkflowGroup response = workflowGroupHandler.deleteWorkflowGroup("12");
        assertNotNull(response);
        assertEquals(deleteWorkflowGroup, response);
    }

}
