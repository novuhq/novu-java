package co.novu.api.organizations;

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
import co.novu.common.base.NovuConfig;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrganizationHandler {

    private final RestHandler restHandler;

    private final NovuConfig novuConfig;
    private static final String ENDPOINT = "organizations";


    public OrganizationResponse createOrganization(CreateOrganizationRequest request) {
        return restHandler.handlePost(request, OrganizationResponse.class, novuConfig, ENDPOINT);
    }

    public FetchOrganizationResponse fetchAllOrganizations() {
        return restHandler.handleGet(FetchOrganizationResponse.class, novuConfig, ENDPOINT);
    }

    public UpdateOrganizationNameResponse updateOrganizationName(UpdateOrganizationNameRequest request) {
        return restHandler.handlePatch(request, UpdateOrganizationNameResponse.class, novuConfig, ENDPOINT);
    }

    public OrganizationResponse fetchCurrentOrganization() {
        return restHandler.handleGet(OrganizationResponse.class, novuConfig, ENDPOINT + "/me");
    }

    public MemberResponse removeMemberWithId(String memberId) {
        return restHandler.handleDelete(MemberResponse.class, novuConfig, ENDPOINT + memberId);
    }

    public MemberResponse updateMemberRole(UpdateMemberRoleRequest request, String memberId) {
        return restHandler.handlePut(request, MemberResponse.class, novuConfig, ENDPOINT + "/members/" + memberId + "/roles");
    }

    public FetchMembersResponse fetchMembersOfOrganization() {
        return restHandler.handleGet(FetchMembersResponse.class, novuConfig, ENDPOINT + "/members");
    }

    public UpdateOrganizationBrandResponse updateOrganizationBrand(UpdateOrganizationBrandRequest request) {
        return restHandler.handlePut(request, UpdateOrganizationBrandResponse.class, novuConfig, ENDPOINT + "/branding");
    }


}
