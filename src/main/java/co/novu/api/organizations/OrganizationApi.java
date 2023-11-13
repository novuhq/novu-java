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
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.PATCH;



public interface OrganizationApi {

    String ENDPOINT = "organizations";

    @POST(ENDPOINT)
    Call<OrganizationResponse> createOrganization(@Body CreateOrganizationRequest request);

    @GET(ENDPOINT)
    Call<FetchOrganizationResponse> fetchAllOrganizations();

    @PATCH(ENDPOINT)
    Call<UpdateOrganizationNameResponse> updateOrganizationName(@Body UpdateOrganizationNameRequest request);

    @GET(ENDPOINT + "/me")
    Call<OrganizationResponse> fetchCurrentOrganization();

    @DELETE(ENDPOINT + "/members/{memberId}")
    Call<MemberResponse> removeMemberWithId(@Path("memberId") String memberId);

    @PUT(ENDPOINT + "/members/{memberId}/roles")
    Call<MemberResponse> updateMemberRole(@Path("memberId") String memberId , @Body UpdateMemberRoleRequest request);

    @GET(ENDPOINT + "/members")
    Call<FetchMembersResponse> fetchMembersOfOrganization();
    @PUT(ENDPOINT + "/branding")
    Call<UpdateOrganizationBrandResponse> updateOrganizationBrand(@Body UpdateOrganizationBrandRequest request);

}
