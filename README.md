# spring-mvc-security-jwt-jpa

**Spring Security: **

Spring Security is a powerful and highly customizable authentication and access-control framework. Spring Security is a framework that focuses on providing both authentication and authorization to Java applications. Like all Spring projects, the real power of Spring Security is found in how easily it can be extended to meet custom requirements. It overcomes all the problems that come during creating non spring security applications and manage new server environment for the application. The main goal of Spring Security is to make it easy to add security features to your applications. It follows a modular design, allowing you to choose and configure various components according to your specific requirements. Some of the key features of Spring Security include:
Authentication: Spring Security supports multiple authentication mechanisms, such as form-based, HTTP Basic, HTTP Digest, and more. It integrates seamlessly with various authentication providers, including in-memory, JDBC, LDAP, and OAuth.
Authorization: Spring Security enables fine-grained authorization control based on roles, permissions, and other attributes. It provides declarative and programmatic approaches for securing application resources, such as URLs, methods, and domain objects.
Session Management: Spring Security offers session management capabilities, including session fixation protection, session concurrency control, and session timeout handling. It allows you to configure session-related properties and customize session management behaviour.
Security Filters: Spring Security leverages servlet filters to intercept and process incoming requests. It includes a set of predefined filters for common security tasks, such as authentication, authorization, and request/response manipulation. You can easily configure and extend these filters to meet your specific needs.
Integration with Spring Framework: Spring Security seamlessly integrates with the Spring ecosystem. It can leverage dependency injection and aspect-oriented programming features provided by the Spring Framework to enhance security functionality.
Customization and Extension: Spring Security is highly customizable, allowing you to override default configurations, implement custom authentication/authorization logic, and integrate with third-party libraries or existing security infrastructure.
Overall, Spring Security simplifies the process of implementing robust security features in Java applications. It provides a flexible and modular framework that addresses common security concerns and allows developers to focus on building secure applications.

This module targets two major areas of application are authentication and authorization. 

**What is Authentication? **
Authentication in Spring refers to the process of verifying the identity of a user or client accessing a system or application. It is a crucial aspect of building secure applications to ensure that only authorized individuals can access protected resources.
In the context of Spring Security, authentication involves validating the credentials provided by the user and establishing their identity. Spring Security offers various authentication mechanisms and supports integration with different authentication providers.
Here's a high-level overview of how authentication works in Spring Security:
User provides credentials: The user typically provides credentials, such as a username and password, in order to authenticate themselves.
Authentication request: The application receives the user's credentials and creates an authentication request object.
Authentication manager: The authentication request is passed to the authentication manager, which is responsible for validating the credentials and performing the authentication process.
Authentication provider: The authentication manager delegates the actual authentication process to one or more authentication providers. An authentication provider is responsible for verifying the user's credentials against a specific authentication mechanism, such as a user database, LDAP server, or OAuth provider.
Authentication result: The authentication provider returns an authentication result, indicating whether the user's credentials were successfully authenticated or not. If successful, the result typically contains the authenticated user details, such as the username and granted authorities.
Security context: If the authentication is successful, Spring Security establishes a security context for the authenticated user. The security context holds the user's authentication details and is associated with the current thread.
Access control: With the user authenticated, Spring Security can enforce access control policies based on the user's granted authorities or other attributes. This allows the application to restrict access to certain resources or operations based on the user's role or permissions.
Spring Security provides several authentication mechanisms out-of-the-box, including form-based authentication, HTTP Basic/Digest authentication, JWT token, OAuth-based authentication. Spring also supports customization and extension, allowing you to integrate with your own authentication providers or implement custom authentication logic to meet your specific requirements.

By integrating Spring Security's authentication capabilities into your application, you can ensure that only authenticated and authorized users have access to your protected resources, helping to safeguard your application against unauthorized access.

**What is Authorization? **
Authorization, also known as access control, is the process of determining what actions or resources a user or client is allowed to access within a system or application. It involves enforcing permissions and restrictions based on the user's identity, role, or other attributes. Once a user is authenticated, authorization is used to control their access to different parts of the application and its resources.
Here are the key concepts related to authorization in Spring Security:
Roles: Roles represent a set of permissions or privileges granted to a user. They define the user's high-level responsibilities or functional areas within the application. For example, an application may have roles such as "admin," "user," or "manager."
Permissions: Permissions are specific actions or operations that a user is allowed to perform. They define the granular level of access control within the application. For example, a user with the "admin" role may have permissions to create, update, and delete resources, while a user with the "user" role may only have read permissions.
Security Interceptors: Spring Security uses security interceptors to enforce authorization rules. These interceptors are responsible for intercepting requests and checking whether the user has the required permissions to access the requested resource. They can be configured to protect URLs, methods, or other parts of the application.
Role-Based Access Control (RBAC): RBAC is a common authorization model in which access control is based on roles. Users are assigned roles, and permissions are associated with those roles. Spring Security supports RBAC by allowing you to define roles and assign them to users.
By implementing authorization in your Spring application using Spring Security, you can ensure that users have appropriate access privileges based on their roles and permissions. This helps protect sensitive resources and data from unauthorized access and maintain the overall security and integrity of your application.
Stateless and Stateful Protocols: 
In the context of the protocol, "stateless" and "stateful" refer to different approaches in handling client-server interactions and maintaining session information. Let's explore each concept:
                      
**Stateless: **
In a stateless protocol, such as HTTP, the server does not maintain any information about the client's previous interactions or session state. Each request from the client to the server is considered independent and self-contained. The server treats each request as if it is the first request from the client.
       
Stateless protocols have the following characteristics:
•	No client session information is stored on the server.
•	Each request from the client must contain all the necessary information for the server to process the request.
•	The server responds to each request independently, without relying on any prior request context.
HTTP is primarily designed as a stateless protocol. When a client makes an HTTP request, the server processes the request and sends back a response. However, the server does not maintain any information about the client after the response is sent. This approach simplifies the server's implementation and scalability but presents challenges for handling user sessions and maintaining continuity between multiple requests.
 
**Stateful: **
In contrast, a stateful protocol maintains information about the client's interactions and session state between requests. The server stores client-specific information and uses it to provide personalized responses and maintain continuity across multiple requests.
However, the major feature of stateful is that it maintains the state of all its sessions, be it an authentication session, or a client’s request for information. Stateful are those that may be used repeatedly, such as online banking or email. They’re carried out in the context of prior transactions in which the states are stored, and what happened in previous transactions may have an impact on the current transaction. Because of this, stateful apps use the same servers every time they perform a user request. An example of stateful is FTP (File Transfer Protocol) i.e. File transferring between servers. For FTP session, which often includes many data transfers, the client establishes a Control Connection. After this, the data transfer takes place.
 

Stateful protocols have the following characteristics:
•	The server keeps track of client session information, typically using a session identifier 
•	The session information is stored on the server.
•	The server uses the session information to maintain context between requests and responses.
While HTTP itself is stateless, developers often implement mechanisms to introduce statefulness. For example, web applications often use cookies or tokens to maintain session state. These cookies or tokens contain session identifiers that the server can use to retrieve or store client-specific data.
By introducing statefulness, web applications can provide a more personalized and interactive experience for users. However, it adds complexity to the server-side implementation and may require additional considerations for scalability and session management.

It's important to note that even when stateful mechanisms are introduced, each individual HTTP request-response cycle is still stateless in nature. The statefulness is achieved by maintaining session information outside the core HTTP protocol, typically through additional mechanisms like cookies, tokens, or server-side session stores.
Q&A:
What is the difference between stateful and stateless?
          	The major difference between stateful and stateless is whether or not they store data regarding their sessions, and how they respond to requests. Stateful services keep track of sessions or transactions and respond to the same inputs in different ways depending on their history. Clients maintain sessions for stateless services, which are focused on activities that manipulate resources rather than the state.

Is stateless better than stateful?
In most cases, stateless is a better option when compared with stateful. However, in the end, it all comes down to your requirements. If you only require information in a transient, rapid, and temporary manner, stateless is the way to go. Stateful, on the other hand, might be the way to go if your app requires more memory of what happens from one session to the next. 

Is HTTP stateful or stateless?
HTTP is stateless because it doesn’t keep track of any state information. In HTTP, each order or request is carried out in its own right, with no awareness of the demands that came before it.

Is REST API stateless or stateful?
 	REST APIs are stateless because, rather than relying on the server remembering previous requests, REST applications require each request to contain all of the information necessary for the server to understand it. Storing session state on the server violates the REST architecture’s stateless requirement. As a result, the client must handle the complete session state. 



**Security Implementation: **
Stateless Security and Stateful Security are two approaches to handling security in systems, particularly in the context of web applications. Let's explore the differences between these two approaches:
Stateless Security:
Stateless security refers to a security approach where the server does not maintain any session state or client-specific information between requests. It is often associated with stateless protocols, such as HTTP, where each request is independent and self-contained. Stateless security is designed to provide security measures without relying on server-side session state.
In the context of web applications and APIs, stateless security is commonly implemented using mechanisms such as JSON Web Tokens (JWT) or OAuth 2.0 authentication scheme. These mechanisms allow authentication and authorization to be performed without the need for server-side session storage.
Here are the key characteristics and advantages of stateless security:
•	No server-side session storage: With stateless security, the server does not need to maintain any session-specific information for each client. This eliminates the need for server-side session storage, reducing the overall complexity and resource requirements on the server side.
•	Scalability: Stateless security simplifies server-side scaling as there is no need to replicate session state across multiple instances of application deployed to multiple servers. Each server can process any request independently, which makes it easier to distribute the load and scale horizontally.
•	Decentralized authentication: Stateless security allows for decentralized authentication, where the client sends authentication credentials (such as a JWT token) with each request. The server can then validate the token's authenticity and extract necessary information to authorize the request.
•	Improved performance: Without the need to perform expensive operations like session lookups or database queries for session data, stateless security can lead to improved performance. Each request carries the necessary authentication and authorization information, reducing the need for additional server-side operations.
It's important to note that while stateless security simplifies server-side architecture and offers advantages in terms of scalability and performance, it also places additional responsibilities on the client-side. The client must securely store and transmit the authentication token and include it in each request.
Stateless security is widely adopted in modern web application development, especially in distributed systems and microservices architectures, where scalability, performance, and decentralized authentication are important considerations.
**In stateless security:**
•	Authentication: The client provides credentials (e.g., username and password or a token) with each request to prove its identity. The server verifies the credentials and grants access based on the provided information. 
•	Authorization: The server evaluates each request independently, checking if the user has the necessary permissions to access the requested resource.
Cons of Stateless Security:
•	Increased overhead: The client needs to send authentication information with each request, which can increase network overhead, especially when the authentication mechanism involves expensive cryptographic operations.
Stateful Security:
Stateful security involves maintaining session state on the server. Once the client is authenticated, the server stores session information and associates it with the client. The server refers to the session state to validate subsequent requests and provide appropriate authorization.
In stateful security:
•	Authentication: The client typically authenticates itself once using its credentials (e.g., username and password or token). After successful authentication, the server generates a session identifier or token and stores it on the server.
Session Management: The server maintains session-specific data, such as user roles, permissions, and other contextual information. The session state is referenced for subsequent requests to determine the user's authorization level.
Pros of Stateful Security:
•	Enhanced session management: Session state allows the server to maintain user context, which can be beneficial for handling complex interactions and personalized experiences.
•	Reduced overhead: Since the client doesn't need to send authentication information with each request, there is a reduction in network overhead.
Cons of Stateful Security:
•	Scalability challenges: The server needs to manage session state, which can be a scalability bottleneck. Sharing session states across multiple servers or implementing session replication techniques becomes necessary.
•	Complexity: Implementing stateful security requires additional effort to manage session state and ensure consistency across requests.
The choice between stateless security and stateful security depends on various factors, including the specific requirements of the application, performance considerations, and the desired level of session management and personalization. Stateless security is often preferred for its simplicity and scalability advantages, while stateful security is suitable for scenarios requiring more advanced session management capabilities.
JWT Authentication & Authorization:
JWTs or JSON Web Tokens are most commonly used to identify an authenticated user. They are issued by an authentication server and are consumed by the client-server (to secure its APIs).

What is a JWT? 
JSON Web Token is an open industry standard used to share information between two entities, usually a client (like your app’s frontend) and a server (your app’s backend). They contain JSON objects which have the information that needs to be shared. Each JWT is also signed using cryptography (hashing) to ensure that the JSON contents (also known as JWT claims) cannot be altered by the client or a malicious party.

A token is a string that contains some information that can be verified securely. It could be a random set of alphanumeric characters that point to an ID in the database, or it could be an encoded JSON that can be self-verified by the client (known as JWTs).

**Structure of a JWT:**

**A JWT contains three parts:**
•	Header: 
o	The signing algorithm that’s being used.
•	Payload: The payload contains the claims or the JSON object of clients.
•	Signature: A string that is generated via a cryptographic algorithm that can be used to verify the integrity of the JSON payload.
In general, whenever we generate a token with JWT, the token is generated in the format of  <header>.<payload>.<signature>  in side JWT.

**Example: **

eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaWxpcEBnbWFpbC5jb20iLCJleHAiOjE2ODk1MjI5OTcsImlhdCI6MTY4OTUyMjY5N30.bjFnipeNqiZ5dyrXZHk0qTPciChw0Z0eNoX5fu5uAmj6SE9mLIGD4Ll_3QeGfXjZqvv8KlJe2pmTseT4g8ZSIA



