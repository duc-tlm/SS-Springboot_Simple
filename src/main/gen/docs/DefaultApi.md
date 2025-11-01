# DefaultApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**listRoles**](DefaultApi.md#listRoles) | **POST** /api/v1/permissionrole/list | Get list of permission roles |


<a id="listRoles"></a>
# **listRoles**
> ApiResponseListRole listRoles(roleRequestDTO)

Get list of permission roles

Returns a list of permission roles filtered by role code.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    RoleRequestDTO roleRequestDTO = new RoleRequestDTO(); // RoleRequestDTO | 
    try {
      ApiResponseListRole result = apiInstance.listRoles(roleRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#listRoles");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **roleRequestDTO** | [**RoleRequestDTO**](RoleRequestDTO.md)|  | |

### Return type

[**ApiResponseListRole**](ApiResponseListRole.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation |  -  |
| **400** | Invalid request |  -  |
| **500** | Internal server error |  -  |

