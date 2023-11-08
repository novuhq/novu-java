package co.novu.common.base;

import co.novu.api.blueprints.BlueprintsHandler;
import co.novu.api.blueprints.pojos.Blueprint;
import co.novu.api.blueprints.responses.BlueprintsByCategoryResponse;
import co.novu.api.changes.ChangeHandler;
import co.novu.api.changes.request.ApplyChangesRequest;
import co.novu.api.changes.request.GetChangesRequest;
import co.novu.api.changes.responses.ApplyChangesResponse;
import co.novu.api.changes.responses.ChangeCountResponse;
import co.novu.api.changes.responses.GetChangesResponse;
import co.novu.api.environments.EnvironmentHandler;
import co.novu.api.environments.requests.CreateEnvironmentRequest;
import co.novu.api.environments.requests.UpdateEnvironmentRequest;
import co.novu.api.environments.responses.ApiKeyResponse;
import co.novu.api.environments.responses.BulkEnvironmentResponse;
import co.novu.api.environments.responses.SingleEnvironmentResponse;
import co.novu.api.events.EventsHandler;
import co.novu.api.events.pojos.BulkTriggerEventRequest;
import co.novu.api.events.requests.TriggerEventRequest;
import co.novu.api.events.responses.BulkTriggerEventResponse;
import co.novu.api.events.responses.CancelEventResponse;
import co.novu.api.events.responses.TriggerEventResponse;
import co.novu.api.executivedetails.ExecutiveDetailsHandler;
import co.novu.api.executivedetails.responses.ExecutiveDetailsResponse;
import co.novu.api.feeds.FeedsHandler;
import co.novu.api.feeds.request.FeedRequest;
import co.novu.api.feeds.response.FeedResponse;
import co.novu.api.feeds.response.BulkFeedsResponse;
import co.novu.api.inboundparse.InboundParseHandler;
import co.novu.api.inboundparse.responses.ValidateMxRecordResponse;
import co.novu.api.integrations.IntegrationsHandler;
import co.novu.api.integrations.requests.IntegrationRequest;
import co.novu.api.integrations.responses.BulkIntegrationResponse;
import co.novu.api.integrations.responses.ProviderWebhookStatusResponse;
import co.novu.api.integrations.responses.SingleIntegrationResponse;
import co.novu.api.layouts.LayoutHandler;
import co.novu.api.layouts.requests.FilterLayoutRequest;
import co.novu.api.layouts.requests.LayoutRequest;
import co.novu.api.layouts.responses.DeleteLayoutResponse;
import co.novu.api.layouts.responses.FilterLayoutResponse;
import co.novu.api.layouts.responses.GetLayoutResponse;
import co.novu.api.layouts.responses.CreateLayoutResponse;
import co.novu.api.layouts.responses.SetDefaultLayoutResponse;
import co.novu.api.messages.MessageHandler;
import co.novu.api.messages.requests.MessageRequest;
import co.novu.api.messages.responses.DeleteMessageResponse;
import co.novu.api.messages.responses.MessageResponse;
import co.novu.api.notifications.NotificationHandler;
import co.novu.api.notifications.requests.NotificationRequest;
import co.novu.api.notifications.responses.NotificationGraphStatsResponse;
import co.novu.api.notifications.responses.NotificationResponse;
import co.novu.api.notifications.responses.NotificationStatsResponse;
import co.novu.api.notifications.responses.NotificationsResponse;
import co.novu.api.organizations.OrganizationHandler;
import co.novu.api.organizations.requests.CreateOrganizationRequest;
import co.novu.api.organizations.requests.UpdateMemberRoleRequest;
import co.novu.api.organizations.requests.UpdateOrganizationBrandRequest;
import co.novu.api.organizations.requests.UpdateOrganizationNameRequest;
import co.novu.api.organizations.responses.FetchMembersResponse;
import co.novu.api.organizations.responses.UpdateOrganizationBrandResponse;
import co.novu.api.organizations.responses.MemberResponse;
import co.novu.api.organizations.responses.OrganizationResponse;
import co.novu.api.organizations.responses.FetchOrganizationResponse;
import co.novu.api.organizations.responses.UpdateOrganizationNameResponse;
import co.novu.api.subscribers.requests.BulkSubscriberRequest;
import co.novu.api.subscribers.requests.MarkAllMessagesRequest;
import co.novu.api.subscribers.responses.CreateBulkSubscriberResponse;
import co.novu.api.subscribers.responses.DeleteCredentialsResponse;
import co.novu.api.subscribers.responses.SingleSubscriberPrefResponse;
import co.novu.api.tenants.TenantsHandler;
import co.novu.api.tenants.requests.GetTenantRequest;
import co.novu.api.tenants.requests.TenantRequest;
import co.novu.api.tenants.responses.BulkTenantResponse;
import co.novu.api.tenants.responses.DeleteTenantResponse;
import co.novu.api.tenants.responses.TenantResponse;
import co.novu.api.topics.TopicHandler;
import co.novu.api.topics.requests.FilterTopicsRequest;
import co.novu.api.topics.requests.RenameTopicRequest;
import co.novu.api.topics.requests.SubscriberAdditionRequest;
import co.novu.api.topics.requests.TopicRequest;
import co.novu.api.topics.responses.CheckTopicSubscriberResponse;
import co.novu.api.topics.responses.DeleteTopicResponse;
import co.novu.api.topics.responses.SubscriberRemovalResponse;
import co.novu.api.topics.responses.TopicResponse;
import co.novu.api.topics.responses.SubscriberAdditionResponse;
import co.novu.api.topics.responses.FilterTopicsResponse;
import co.novu.api.subscribers.SubscribersHandler;
import co.novu.api.subscribers.requests.MarkMessageActionAsSeenRequest;
import co.novu.api.subscribers.requests.MarkSubscriberFeedAsRequest;
import co.novu.api.subscribers.responses.SubscriberNotificationResponse;
import co.novu.api.common.SubscriberRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberCredentialsRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberOnlineStatusRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberPreferenceRequest;
import co.novu.api.subscribers.requests.UpdateSubscriberRequest;
import co.novu.api.subscribers.responses.BulkSubscriberResponse;
import co.novu.api.subscribers.responses.CreateSubscriberResponse;
import co.novu.api.subscribers.responses.SingleSubscriberResponse;
import co.novu.api.subscribers.responses.SubscriberDeleteResponse;
import co.novu.api.subscribers.responses.SubscriberPreferenceResponse;
import co.novu.api.subscribers.responses.UnseenNotificationsCountResponse;
import co.novu.api.workflowgroups.WorkflowGroupHandler;
import co.novu.api.workflowgroups.request.WorkflowGroupRequest;
import co.novu.api.workflowgroups.responses.DeleteWorkflowGroup;
import co.novu.api.workflowgroups.responses.GetWorkflowGroupsResponse;
import co.novu.api.workflowgroups.responses.WorkflowGroupResponse;
import co.novu.api.workflows.WorkflowHandler;
import co.novu.api.workflows.requests.UpdateWorkflowRequest;
import co.novu.api.workflows.requests.UpdateWorkflowStatusRequest;
import co.novu.api.workflows.requests.WorkflowRequest;
import co.novu.api.workflows.responses.BulkWorkflowResponse;
import co.novu.api.workflows.responses.DeleteWorkflowResponse;
import co.novu.api.workflows.responses.SingleWorkflowResponse;
import co.novu.common.rest.RestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

@Slf4j
public class Novu {

    private final EventsHandler eventsHandler;
    private final NotificationHandler notificationHandler;

    private final TopicHandler topicHandler;

    private final SubscribersHandler subscribersHandler;

    private final IntegrationsHandler integrationsHandler;

    private final LayoutHandler layoutHandler;

    private final WorkflowHandler workflowHandler;

    private final WorkflowGroupHandler workflowGroupHandler;

    private final ChangeHandler changeHandler;

    private final EnvironmentHandler environmentHandler;

    private final InboundParseHandler inboundParseHandler;

    private final FeedsHandler feedsHandler;

    private final MessageHandler messageHandler;

    private final ExecutiveDetailsHandler executiveDetailsHandler;

    private final BlueprintsHandler blueprintsHandler;

    private final TenantsHandler tenantsHandler;

    private final OrganizationHandler organizationHandler;

    public Novu(String apiKey) {
        this(new NovuConfig(apiKey));
    }

    public Novu(NovuConfig novuConfig) {
        RestHandler restHandler = new RestHandler();
        this.eventsHandler = new EventsHandler(restHandler, novuConfig);
        this.notificationHandler = new NotificationHandler(restHandler, novuConfig);
        this.subscribersHandler = new SubscribersHandler(restHandler, novuConfig);
        this.topicHandler = new TopicHandler(restHandler, novuConfig);
        this.integrationsHandler = new IntegrationsHandler(restHandler, novuConfig);
        this.layoutHandler = new LayoutHandler(restHandler, novuConfig);
        this.workflowHandler = new WorkflowHandler(restHandler, novuConfig);
        this.workflowGroupHandler = new WorkflowGroupHandler(restHandler, novuConfig);
        this.changeHandler = new ChangeHandler(restHandler, novuConfig);
        this.environmentHandler = new EnvironmentHandler(restHandler, novuConfig);
        this.inboundParseHandler = new InboundParseHandler(restHandler, novuConfig);
        this.feedsHandler = new FeedsHandler(restHandler, novuConfig);
        this.messageHandler = new MessageHandler(restHandler, novuConfig);
        this.executiveDetailsHandler = new ExecutiveDetailsHandler(restHandler, novuConfig);
        this.blueprintsHandler = new BlueprintsHandler(restHandler, novuConfig);
        this.tenantsHandler = new TenantsHandler(restHandler, novuConfig);
        this.organizationHandler = new OrganizationHandler(restHandler, novuConfig);
    }

    public TriggerEventResponse triggerEvent(TriggerEventRequest request) {
        try {
            return eventsHandler.triggerEvent(request);
        }catch (Exception e){
            log.error("Error triggering event", e);
            throw e;
        }
    }

    public BulkTriggerEventResponse bulkTriggerEvent(BulkTriggerEventRequest request) {
        try {
            return eventsHandler.bulkTriggerEvent(request);
        } catch (Exception e) {
            log.error("Error Triggering Event", e);
            throw e;
        }
    }

    public TriggerEventResponse broadcastEvent(TriggerEventRequest request) {
        try {
            return eventsHandler.broadcastEvent(request);
        } catch (Exception e) {
            log.error("Error BroadCasting Event", e);
            throw e;
        }
    }

    public CancelEventResponse cancelTriggeredEvent(String transactionId) {
        try {
            return eventsHandler.cancelTriggeredEvent(transactionId);
        } catch (Exception e) {
            log.error("Error Canceling Event", e);
            throw e;
        }
    }

    public NotificationsResponse getNotifications(NotificationRequest request) {
        try {
            return notificationHandler.getNotifications(request);
        } catch (Exception e) {
            log.error("Error Getting Notification", e);
            throw e;
        }
    }

    public NotificationStatsResponse getNotificationsStats() {
        try {
            return notificationHandler.getNotificationsStats();
        } catch (Exception e) {
            log.error("Error Getting Notifications Stats", e);
            throw e;
        }
    }

    public NotificationGraphStatsResponse getNotificationGraphStats() {
        try {
            return notificationHandler.getNotificationGraphStats();
        } catch (Exception e) {
            log.error("Error Getting Notifications Graph Stats", e);
            throw e;
        }
    }

    public NotificationResponse getNotification(String notificationId) {
        try {
            return notificationHandler.getNotification(notificationId);
        } catch (Exception e) {
            log.error("Error Getting Notification", e);
            throw e;
        }
    }

    public BulkSubscriberResponse getSubscribers(@Nullable Integer page, @Nullable Integer limit) {
        try {
            return subscribersHandler.getSubscribers(page, limit);
        } catch (Exception e) {
            log.error("Error getting Subscribers", e);
            throw e;
        }
    }

    public CreateSubscriberResponse createSubscriber(SubscriberRequest request) {
        try {
            return subscribersHandler.createSubscriber(request);
        } catch (Exception e) {
            log.error("Error creating Subscriber", e);
            throw e;
        }
    }

    public CreateBulkSubscriberResponse createSubscriberBulk(BulkSubscriberRequest request) {
        try {
            return subscribersHandler.createSubscriberBulk(request);
        } catch (Exception e) {
            log.error("Error creating bulk Subscribers", e);
            throw e;
        }
    }

    public SingleSubscriberResponse getSubscriber(String subscriberId) {
        try {
            return subscribersHandler.getSubscriber(subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber", e);
            throw e;
        }
    }

    public SingleSubscriberResponse updateSubscriber(UpdateSubscriberRequest request, String subscriberId) {
        try {
            return subscribersHandler.updateSubscriber(request, subscriberId);
        } catch (Exception e) {
            log.error("Error updating Subscriber", e);
            throw e;
        }
    }

    public SubscriberDeleteResponse deleteSubscriber(String subscriberId) {
        try {
            return subscribersHandler.deleteSubscriber(subscriberId);
        } catch (Exception e) {
            log.error("Error deleting Subscriber", e);
            throw e;
        }
    }

    public SingleSubscriberResponse updateSubscriberCredentials(UpdateSubscriberCredentialsRequest request, String subscriberId) {
        try {
            return subscribersHandler.updateSubscriberCredentials(request, subscriberId);
        } catch (Exception e) {
            log.error("Error updating Subscriber Credentials", e);
            throw e;
        }
    }

    public DeleteCredentialsResponse deleteSubscriberCredentials(String subscriberId, String providerId) {
        try {
            return subscribersHandler.deleteSubscriberCredentials(subscriberId, providerId);
        } catch (Exception e) {
            log.error("Error deleting Subscriber Credentials", e);
            throw e;
        }
    }

    public SingleSubscriberResponse updateSubscriberOnlineStatus(UpdateSubscriberOnlineStatusRequest request, String subscriberId) {
        try {
            return subscribersHandler.updateSubscriberOnlineStatus(request, subscriberId);
        } catch (Exception e) {
            log.error("Error updating Subscriber Online Status", e);
            throw e;
        }
    }

    public SubscriberPreferenceResponse getSubscriberPreferences(String subscriberId) {
        try {
            return subscribersHandler.getSubscriberPreferences(subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber Preferences", e);
            throw e;
        }
    }

    public SingleSubscriberPrefResponse updateSubscriberPreferences(UpdateSubscriberPreferenceRequest request, String subscriberId, String templateId) {
        try {
            return subscribersHandler.updateSubscriberPreferences(request, subscriberId, templateId);
        } catch (Exception e) {
            log.error("Error updating Subscriber Preferences", e);
            throw e;
        }
    }

    public SubscriberNotificationResponse getSubscriberNotificationsFeed(String subscriberId) {
        try {
            return subscribersHandler.getSubscriberNotificationsFeed(subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber Notifications Feed", e);
            throw e;
        }
    }

    public UnseenNotificationsCountResponse getSubscriberUnseenNotificationsCount(String subscriberId) {
        try {
            return subscribersHandler.getSubscriberUnseenNotificationsCount(subscriberId);
        } catch (Exception e) {
            log.error("Error getting Subscriber unseen Notifications Count", e);
            throw e;
        }
    }

    public SubscriberNotificationResponse markSubscriberMessageFeedAs(MarkSubscriberFeedAsRequest request, String subscriberId) {
        try {
            return subscribersHandler.markSubscriberMessageFeedAs(request, subscriberId);
        } catch (Exception e) {
            log.error("Error marking Subscriber Message Feed", e);
            throw e;
        }
    }

    public Long markAllSubscriberMessagesFeedAs(MarkAllMessagesRequest request, String subscriberId) {
        try {
            return subscribersHandler.markAllSubscriberMessagesFeedAs(request, subscriberId);
        } catch (Exception e) {
            log.error("Error marking all Subscriber Messages Feed", e);
            throw e;
        }
    }

    public SubscriberNotificationResponse markMessageActionAsSeen(MarkMessageActionAsSeenRequest request, String subscriberId, String messageId, String type) {
        try {
            return subscribersHandler.markMessageActionAsSeen(request, subscriberId, messageId, type);
        } catch (Exception e) {
            log.error("Error marking Message Action as seen", e);
            throw e;
        }
    }

    public TopicResponse createTopic(TopicRequest request) {
        try {
            return topicHandler.createTopic(request);
        } catch (Exception e) {
            log.error("Error Creating Topic", e);
            throw e;
        }
    }

    public FilterTopicsResponse filterTopics(FilterTopicsRequest request) {
        try {
            return topicHandler.filterTopics(request);
        } catch (Exception e) {
            log.error("Error filtering Topic", e);
            throw e;
        }
    }

    public SubscriberAdditionResponse addSubscriberToTopic(SubscriberAdditionRequest request, String topicKey) {
        try {
            return topicHandler.addSubscriberToTopic(request, topicKey);
        } catch (Exception e) {
            log.error("Error adding subscriber to Topic", e);
            throw e;
        }
    }

    public CheckTopicSubscriberResponse checkTopicSubscriber(String topicKey, String externalSubscriberId) {
        try {
            return topicHandler.checkTopicSubscriber(topicKey, externalSubscriberId);
        } catch (Exception e) {
            log.error("Error checking topic subscriber", e);
            throw e;
        }
    }

    public SubscriberRemovalResponse removeSubscriberFromTopic(SubscriberAdditionRequest request, String topicKey) {
        try {
            return topicHandler.removeSubscriberFromTopic(request, topicKey);
        } catch (Exception e) {
            log.error("Error removing subscriber from Topic", e);
            throw e;
        }
    }

    public DeleteTopicResponse deleteTopic(String topicKey) {
        try {
            return topicHandler.deleteTopic(topicKey);
        } catch (Exception e) {
            log.error("Error Deleting Topic", e);
            throw e;
        }
    }

    public TopicResponse getTopic(String topicKey) {
        try {
            return topicHandler.getTopic(topicKey);
        } catch (Exception e) {
            log.error("Error Getting Topic", e);
            throw e;
        }
    }

    public TopicResponse renameTopic(RenameTopicRequest request, String topicKey) {
        try {
            return topicHandler.renameTopic(request, topicKey);
        } catch (Exception e) {
            log.error("Error renaming Topic", e);
            throw e;
        }
    }

    public BulkIntegrationResponse getIntegrations() {
        try {
            return integrationsHandler.getIntegrations();
        } catch (Exception e) {
            log.error("Error getting Integrations", e);
            throw e;
        }
    }

    public SingleIntegrationResponse createIntegration(IntegrationRequest request) {
        try {
            return integrationsHandler.createIntegration(request);
        } catch (Exception e) {
            log.error("Error creating Integrations", e);
            throw e;
        }
    }

    public BulkIntegrationResponse getActiveIntegrations() {
        try {
            return integrationsHandler.getActiveIntegrations();
        } catch (Exception e) {
            log.error("Error getting active Integrations", e);
            throw e;
        }
    }

    public ProviderWebhookStatusResponse getProviderWebhookStatus(String providerId) {
        try {
            return integrationsHandler.getProviderWebhookStatus(providerId);
        } catch (Exception e) {
            log.error("Error getting Provider Webhook Status", e);
            throw e;
        }
    }

    public SingleIntegrationResponse updateIntegration(String integrationId, IntegrationRequest request) {
        try {
            return integrationsHandler.updateIntegration(integrationId, request);
        } catch (Exception e) {
            log.error("Error updating Integration", e);
            throw e;
        }
    }

    public BulkIntegrationResponse deleteIntegration(String integrationId) {
        try {
            return integrationsHandler.deleteIntegration(integrationId);
        } catch (Exception e) {
            log.error("Error deleting Integration", e);
            throw e;
        }
    }

    public SingleIntegrationResponse setIntegrationAsPrimary(String integrationId) {
        try {
            return integrationsHandler.setIntegrationAsPrimary(integrationId);
        } catch (Exception e) {
            log.error("Error setting Integration as primary", e);
            throw e;
        }
    }

    public CreateLayoutResponse createLayout(LayoutRequest request) {
        try {
            return layoutHandler.createLayout(request);
        } catch (Exception e) {
            log.error("Error creating Layout", e);
            throw e;
        }
    }

    public FilterLayoutResponse filterLayout(FilterLayoutRequest request) {
        try {
            return layoutHandler.filterLayouts(request);
        } catch (Exception e) {
            log.error("Error filtering Layout", e);
            throw e;
        }
    }

    public GetLayoutResponse getLayout(String layoutId) {
        try {
            return layoutHandler.getLayout(layoutId);
        } catch (Exception e) {
            log.error("Error getting Layouts", e);
            throw e;
        }
    }

    public DeleteLayoutResponse deleteLayout(String layoutId) {
        try {
            return layoutHandler.deleteLayout(layoutId);
        } catch (Exception e) {
            log.error("Error Deleting Layout", e);
            throw e;
        }
    }

    public GetLayoutResponse updateIntegration(String layoutId, LayoutRequest request) {
        try {
            return layoutHandler.updateLayout(layoutId, request);
        } catch (Exception e) {
            log.error("Error updating Layout", e);
            throw e;
        }
    }

    public SetDefaultLayoutResponse setDefaultLayout(String layoutId) {
        try {
            return layoutHandler.setDefaultLayout(layoutId);
        } catch (Exception e) {
            log.error("Error Setting Default Layout", e);
            throw e;
        }
    }

    public BulkWorkflowResponse getWorkflows(Integer page, Integer limit) {
        try {
            return workflowHandler.getWorkflows(page, limit);
        } catch (Exception e) {
            log.error("Error getting Workflows", e);
            throw e;
        }
    }

    public SingleWorkflowResponse createWorkflow(WorkflowRequest request) {
        try {
            return workflowHandler.createWorkflow(request);
        } catch (Exception e) {
            log.error("Error creating Workflow", e);
            throw e;
        }
    }

    public SingleWorkflowResponse updateWorkflow(String workflowId, UpdateWorkflowRequest request) {
        try {
            return workflowHandler.updateWorkflow(workflowId, request);
        } catch (Exception e) {
            log.error("Error updating Workflow", e);
            throw e;
        }
    }

    public DeleteWorkflowResponse deleteWorkflow(String workflowId) {
        try {
            return workflowHandler.deleteWorkflow(workflowId);
        } catch (Exception e) {
            log.error("Error deleting Workflow", e);
            throw e;
        }
    }

    public SingleWorkflowResponse getWorkflow(String workflowId) {
        try {
            return workflowHandler.getWorkflow(workflowId);
        } catch (Exception e) {
            log.error("Error getting Workflow", e);
            throw e;
        }
    }

    public SingleWorkflowResponse updateWorkflowStatus(String workflowId, UpdateWorkflowStatusRequest request) {
        try {
            return workflowHandler.updateWorkflowStatus(workflowId, request);
        } catch (Exception e) {
            log.error("Error updating Workflow status", e);
            throw e;
        }
    }

    public WorkflowGroupResponse createWorkflowGroup(WorkflowGroupRequest request) {
        try {
            return workflowGroupHandler.createWorkflowGroup(request);
        } catch (Exception e) {
            log.error("Error creating workflow group", e);
            throw e;
        }
    }

    public GetWorkflowGroupsResponse getWorkflowGroups() {
        try {
            return workflowGroupHandler.getWorkflowGroups();
        } catch (Exception e) {
            log.error("Error getting workflow groups", e);
            throw e;
        }
    }

    public WorkflowGroupResponse getWorkflowGroup(String id) {
        try {
            return workflowGroupHandler.getWorkflowGroup(id);
        } catch (Exception e) {
            log.error("Error getting workflow group", e);
            throw e;
        }
    }

    public WorkflowGroupResponse updateWorkflowGroup(String id, WorkflowGroupRequest request) {
        try {
            return workflowGroupHandler.updateWorkflowGroup(id,request);
        } catch (Exception e) {
            log.error("Error updating workflow group", e);
            throw e;
        }
    }

    public DeleteWorkflowGroup deleteWorkflowGroup(String id) {
        try {
            return workflowGroupHandler.deleteWorkflowGroup(id);
        } catch (Exception e) {
            log.error("Error deleting workflow group", e);
            throw e;
        }
    }

    public GetChangesResponse getChanges(GetChangesRequest request) {
        try {
            return changeHandler.getChanges(request);
        } catch (Exception e) {
            log.error("Error getting changes", e);
            throw e;
        }
    }

    public ChangeCountResponse getChangesCount() {
        try {
            return changeHandler.getChangesCount();
        } catch (Exception e) {
            log.error("Error getting changes count", e);
            throw e;
        }
    }


    public ApplyChangesResponse applyChanges(ApplyChangesRequest request) {
        try {
            return changeHandler.applyChanges(request);
        } catch (Exception e) {
            log.error("Error applying changes", e);
            throw e;
        }
    }

    public ApplyChangesResponse applyChange(String changeId) {
        try {
            return changeHandler.applyChange(changeId);
        } catch (Exception e) {
            log.error("Error applying change", e);
            throw e;
        }
    }

    public SingleEnvironmentResponse getCurrentEnvironment() {
        try {
            return environmentHandler.getCurrentEnvironment();
        } catch (Exception e) {
            log.error("Error getting current Environment", e);
            throw e;
        }
    }

    public SingleEnvironmentResponse createEnvironment(CreateEnvironmentRequest request) {
        try {
            return environmentHandler.createEnvironment(request);
        } catch (Exception e) {
            log.error("Error creating Environment", e);
            throw e;
        }
    }

    public BulkEnvironmentResponse getEnvironments() {
        try {
            return environmentHandler.getEnvironments();
        } catch (Exception e) {
            log.error("Error getting Environments", e);
            throw e;
        }
    }

    public SingleEnvironmentResponse updateEnvironmentById(String environmentId, UpdateEnvironmentRequest request) {
        try {
            return environmentHandler.updateEnvironmentById(environmentId, request);
        } catch (Exception e) {
            log.error("Error updating Environment by ID", e);
            throw e;
        }
    }

    public ApiKeyResponse getApiKeys() {
        try {
            return environmentHandler.getApiKeys();
        } catch (Exception e) {
            log.error("Error getting Api Keys", e);
            throw e;
        }
    }

    public ApiKeyResponse regenerateApiKeys() {
        try {
            return environmentHandler.regenerateApiKeys();
        } catch (Exception e) {
            log.error("Error regenerating Api Keys", e);
            throw e;
        }
    }

    public ValidateMxRecordResponse validateMxRecordSetupForInboundParse() {
        try {
            return inboundParseHandler.validateMxRecordSetupForInboundParse();
        } catch (Exception e) {
            log.error("Error validating Mx record setup", e);
            throw e;
        }
    }

    public FeedResponse createFeed(FeedRequest request) {
        try {
            return feedsHandler.createFeed(request);
        } catch (Exception e) {
            log.error("Error creating feed", e);
            throw e;
        }
    }

    public BulkFeedsResponse getFeeds() {
        try {
            return feedsHandler.getFeeds();
        } catch (Exception e) {
            log.error("Error getting feed", e);
            throw e;
        }
    }

    public BulkFeedsResponse deleteFeed(String feedId) {
        try {
            return feedsHandler.deleteFeed(feedId);
        } catch (Exception e) {
            log.error("Error deleting feed", e);
            throw e;
        }
    }

    public MessageResponse getMessages(MessageRequest request) {
        try {
            return messageHandler.getMessages(request);
        } catch (Exception e) {
            log.error("Error getting Messages", e);
            throw e;
        }
    }

    public DeleteMessageResponse deleteMessage(String messageId) {
        try {
            return messageHandler.deleteMessage(messageId);
        } catch (Exception e) {
            log.error("Error deleting Message", e);
            throw e;
        }
    }

    public ExecutiveDetailsResponse getExecutionDetails(String notificationId, String subscriberId) {
        try {
            return executiveDetailsHandler.getExecutionDetails(notificationId, subscriberId);
        } catch (Exception e) {
            log.error("Error getting Execution Details", e);
            throw e;
        }
    }

    public BlueprintsByCategoryResponse getBlueprintsByCategory() {
        try {
            return blueprintsHandler.getBlueprintsByCategory();
        } catch (Exception e) {
            log.error("Error getting Blueprints by Category", e);
            throw e;
        }
    }

    public Blueprint getBlueprint(String templateId) {
        try {
            return blueprintsHandler.getBlueprint(templateId);
        } catch (Exception e) {
            log.error("Error getting Blueprint", e);
            throw e;
        }
    }

    public BulkTenantResponse getTenants(GetTenantRequest request) {
        try {
            return tenantsHandler.getTenants(request);
        } catch (Exception e) {
            log.error("Error getting Tenants", e);
            throw e;
        }
    }

    public TenantResponse createTenant(TenantRequest request) {
        try {
            return tenantsHandler.createTenant(request);
        } catch (Exception e) {
            log.error("Error creating Tenant", e);
            throw e;
        }
    }

    public TenantResponse getTenant(String identifier) {
        try {
            return tenantsHandler.getTenant(identifier);
        } catch (Exception e) {
            log.error("Error getting Tenant", e);
            throw e;
        }
    }

    public TenantResponse updateTenant(TenantRequest request, String identifier) {
        try {
            return tenantsHandler.updateTenant(request, identifier);
        } catch (Exception e) {
            log.error("Error updating Tenant", e);
            throw e;
        }
    }

    public DeleteTenantResponse deleteTenant(String identifier) {
        try {
            return tenantsHandler.deleteTenant(identifier);
        } catch (Exception e) {
            log.error("Error deleting Tenant", e);
            throw e;
        }
    }

    public OrganizationResponse createOrganization(CreateOrganizationRequest request) {
        try {
            return organizationHandler.createOrganization(request);
        } catch (Exception e) {
            log.error("Error creating Organization", e);
            throw e;
        }
    }

    public FetchOrganizationResponse fetchAllOrganizations() {
        try {
            return organizationHandler.fetchAllOrganizations();
        } catch (Exception e) {
            log.error("Error fetching Organizations", e);
            throw e;
        }
    }

    public UpdateOrganizationNameResponse updateOrganizationName(UpdateOrganizationNameRequest request) {
        try {
            return organizationHandler.updateOrganizationName(request);
        } catch (Exception e) {
            log.error("Error Updating Organization Name", e);
            throw e;
        }
    }

    public OrganizationResponse fetchCurrentOrganization() {
        try {
            return organizationHandler.fetchCurrentOrganization();
        } catch (Exception e) {
            log.error("Error Fetching Current Organization", e);
            throw e;
        }
    }

    public MemberResponse removeMemberWithId(String memberId) {
        try {
            return organizationHandler.removeMemberWithId(memberId);
        } catch (Exception e) {
            log.error("Error Removing Member With MemberId", e);
            throw e;
        }
    }

    public MemberResponse updateMemberRole(UpdateMemberRoleRequest request,String memberId) {
        try {
            return organizationHandler.updateMemberRole(request,memberId);
        } catch (Exception e) {
            log.error("Error Updating Member Role", e);
            throw e;
        }
    }

    public FetchMembersResponse fetchMembersOfOrganization() {
        try {
            return organizationHandler.fetchMembersOfOrganization();
        } catch (Exception e) {
            log.error("Error Fetching Organization Members", e);
            throw e;
        }
    }

    public UpdateOrganizationBrandResponse UpdateOrganizationBrand(UpdateOrganizationBrandRequest request) {
        try {
            return organizationHandler.updateOrganizationBrand(request);
        } catch (Exception e) {
            log.error("Error Updating Organization Brand", e);
            throw e;
        }
    }




}