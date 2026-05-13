# Domains

## Overview

Used to manage your inbound email domains.
<https://docs.novu.co/platform/domains>

### Available Operations

* [list](#list) - List domains for an environment
* [create](#create) - Create a domain
* [retrieve](#retrieve) - Retrieve a domain by name
* [update](#update) - Update a domain
* [delete](#delete) - Delete a domain
* [diagnose](#diagnose) - Diagnose inbound DNS for a domain
* [verify](#verify) - Verify a domain

## list

Returns a paginated list of inbound-email domains in the current environment. Supports cursor pagination and a name contains filter.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_listDomains" method="get" path="/v1/domains" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerListDomainsRequest;
import co.novu.models.operations.DomainsControllerListDomainsResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerListDomainsRequest req = DomainsControllerListDomainsRequest.builder()
                .limit(10d)
                .build();

        DomainsControllerListDomainsResponse res = sdk.domains().list()
                .request(req)
                .call();

        if (res.listDomainsResponseDto().isPresent()) {
            System.out.println(res.listDomainsResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                                                             | Type                                                                                                  | Required                                                                                              | Description                                                                                           |
| ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `request`                                                                                             | [DomainsControllerListDomainsRequest](../../models/operations/DomainsControllerListDomainsRequest.md) | :heavy_check_mark:                                                                                    | The request object to use for the request.                                                            |

### Response

**[DomainsControllerListDomainsResponse](../../models/operations/DomainsControllerListDomainsResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## create

Registers a new inbound-email domain. The response includes the DNS records customers must add at their DNS provider before the domain can receive mail.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_createDomain" method="post" path="/v1/domains" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.CreateDomainDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerCreateDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerCreateDomainResponse res = sdk.domains().create()
                .body(CreateDomainDto.builder()
                    .name("<value>")
                    .build())
                .call();

        if (res.domainResponseDto().isPresent()) {
            System.out.println(res.domainResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `idempotencyKey`                                              | *Optional\<String>*                                           | :heavy_minus_sign:                                            | A header for idempotency purposes                             |
| `body`                                                        | [CreateDomainDto](../../models/components/CreateDomainDto.md) | :heavy_check_mark:                                            | N/A                                                           |

### Response

**[DomainsControllerCreateDomainResponse](../../models/operations/DomainsControllerCreateDomainResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## retrieve

Returns the domain configuration and the DNS records that must be in place. This is a pure read; call `domains.verify` to refresh verification status from DNS.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_getDomain" method="get" path="/v1/domains/{domain}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerGetDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerGetDomainResponse res = sdk.domains().retrieve()
                .domain("foolish-requirement.org")
                .call();

        if (res.domainResponseDto().isPresent()) {
            System.out.println(res.domainResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `domain`                          | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[DomainsControllerGetDomainResponse](../../models/operations/DomainsControllerGetDomainResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## update

Updates optional domain fields. When `data` is provided, it replaces the entire metadata object; omit `data` to leave it unchanged.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_updateDomain" method="patch" path="/v1/domains/{domain}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.components.UpdateDomainDto;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerUpdateDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerUpdateDomainResponse res = sdk.domains().update()
                .domain("ordinary-eternity.org")
                .body(UpdateDomainDto.builder()
                    .build())
                .call();

        if (res.domainResponseDto().isPresent()) {
            System.out.println(res.domainResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                                                     | Type                                                          | Required                                                      | Description                                                   |
| ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- | ------------------------------------------------------------- |
| `domain`                                                      | *String*                                                      | :heavy_check_mark:                                            | N/A                                                           |
| `idempotencyKey`                                              | *Optional\<String>*                                           | :heavy_minus_sign:                                            | A header for idempotency purposes                             |
| `body`                                                        | [UpdateDomainDto](../../models/components/UpdateDomainDto.md) | :heavy_check_mark:                                            | N/A                                                           |

### Response

**[DomainsControllerUpdateDomainResponse](../../models/operations/DomainsControllerUpdateDomainResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## delete

Removes the domain and cascades the deletion to all of its routes. Inbound mail for that domain stops being processed immediately.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_deleteDomain" method="delete" path="/v1/domains/{domain}" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerDeleteDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerDeleteDomainResponse res = sdk.domains().delete()
                .domain("complicated-finer.org")
                .call();

        // handle response
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `domain`                          | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[DomainsControllerDeleteDomainResponse](../../models/operations/DomainsControllerDeleteDomainResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## diagnose

Runs live DNS checks for inbound email readiness (MX correctness, apex CNAME collision, and common DNS blocklists for the Novu mail host). Returns structured issues with plain-language fixes.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_diagnoseDomain" method="post" path="/v1/domains/{domain}/diagnose" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerDiagnoseDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerDiagnoseDomainResponse res = sdk.domains().diagnose()
                .domain("alive-publication.biz")
                .call();

        if (res.diagnoseDomainResponseDto().isPresent()) {
            System.out.println(res.diagnoseDomainResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `domain`                          | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[DomainsControllerDiagnoseDomainResponse](../../models/operations/DomainsControllerDiagnoseDomainResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |

## verify

Performs a live DNS lookup to refresh the MX record status of the domain and updates the verification status accordingly. Returns the latest domain configuration.

### Example Usage

<!-- UsageSnippet language="java" operationID="DomainsController_verifyDomain" method="post" path="/v1/domains/{domain}/verify" -->
```java
package hello.world;

import co.novu.Novu;
import co.novu.models.errors.ErrorDto;
import co.novu.models.errors.ValidationErrorDto;
import co.novu.models.operations.DomainsControllerVerifyDomainResponse;
import java.lang.Exception;

public class Application {

    public static void main(String[] args) throws ErrorDto, ValidationErrorDto, Exception {

        Novu sdk = Novu.builder()
                .secretKey("YOUR_SECRET_KEY_HERE")
            .build();

        DomainsControllerVerifyDomainResponse res = sdk.domains().verify()
                .domain("formal-fork.com")
                .call();

        if (res.domainResponseDto().isPresent()) {
            System.out.println(res.domainResponseDto().get());
        }
    }
}
```

### Parameters

| Parameter                         | Type                              | Required                          | Description                       |
| --------------------------------- | --------------------------------- | --------------------------------- | --------------------------------- |
| `domain`                          | *String*                          | :heavy_check_mark:                | N/A                               |
| `idempotencyKey`                  | *Optional\<String>*               | :heavy_minus_sign:                | A header for idempotency purposes |

### Response

**[DomainsControllerVerifyDomainResponse](../../models/operations/DomainsControllerVerifyDomainResponse.md)**

### Errors

| Error Type                             | Status Code                            | Content Type                           |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| models/errors/ErrorDto                 | 414                                    | application/json                       |
| models/errors/ErrorDto                 | 400, 401, 403, 404, 405, 409, 413, 415 | application/json                       |
| models/errors/ValidationErrorDto       | 422                                    | application/json                       |
| models/errors/ErrorDto                 | 500                                    | application/json                       |
| models/errors/APIException             | 4XX, 5XX                               | \*/\*                                  |