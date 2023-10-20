package com.example.tests;

import com.example.model.*;
import com.example.service.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceClientTest {

    private UserServiceClient userServiceClient;
    private Endpoint mockEndpoint;
    private final String githubApiUrl = "https://api.github.com/users/testuser";

    @Test
    public void getUserUnitTest() throws URISyntaxException, IOException, InterruptedException {
        userServiceClient = new UserServiceClient();
        mockEndpoint = mock(Endpoint.class);// create a mock for the endpoint
        userServiceClient.setEndpoint(mockEndpoint);
        String mockResponseBody = "{\"login\":\"testuser\",\"id\":1,\"node_id\":\"nodeid123\",\"avatar_url\":\"avatarurl\",\"type\":\"User\",\"name\":\"Test User\",\"company\":\"Test Company\",\"blog\":\"testblog.com\",\"location\":\"Test Location\",\"email\":\"test@test.com\",\"hireable\":true,\"bio\":\"Test Bio\",\"public_repos\":5,\"public_gists\":0,\"followers\":2,\"following\":1,\"created_at\":\"2023-10-01T12:00:00Z\",\"updated_at\":\"2023-10-10T12:00:00Z\"}";
        HttpResponse<String> mockResponse = mock(HttpResponse.class); // ctreat an HttpsResponse mock
        when(mockResponse.body()).thenReturn(mockResponseBody);
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockEndpoint.getResponse(githubApiUrl)).thenReturn(mockResponse);

        GitHubResponse expectedResponse = new GitHubResponse();
        GitHubUser expectedUser = new GitHubUser();
        expectedUser.setLogin("Login");
        expectedUser.setId(1);
        expectedUser.setNodeId("nodeid123");
        expectedUser.setAvatarUrl("avatarurl");
        expectedUser.setType("User");
        expectedUser.setName("Test User");
        expectedUser.setCompany("Test Company");
        expectedUser.setBlog("testblog.com");
        expectedUser.setLocation("Test Location");
        expectedUser.setEmail("test@test.com");
        expectedUser.setHireable(true);
        expectedUser.setBio("Test Bio");
        expectedUser.setPublicRepos(5);
        expectedUser.setPublicGists(0);
        expectedUser.setFollowers(2);
        expectedUser.setFollowing(1);
        expectedUser.setCreatedAt("2023-10-17");
        expectedUser.setUpdatedAt("2023-10-19");

        expectedResponse.setStatusCode(200);
        expectedResponse.setGitHubUser(expectedUser);

        GitHubResponse actualResponse = userServiceClient.getUser("https://api.github.com/users/testuser");

        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getGitHubUser().getName(), actualResponse.getGitHubUser().getName());

    }

    @Test
    public void getUserIntegrationTest() throws URISyntaxException, IOException, InterruptedException {

        userServiceClient = new UserServiceClient();
        Endpoint endpoint = new Endpoint(); // integration = on a pas besoin des mocks
        userServiceClient.setEndpoint(endpoint);
        String validGitHubUserUrl = "https://api.github.com/users/etudiant";
        GitHubResponse response = userServiceClient.getUser(validGitHubUserUrl);

        assertNotNull(response);
        assertNotNull(response.getGitHubUser());
        assertEquals(200, response.getStatusCode());
    }
}
