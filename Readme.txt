Trace ids are not logged.
Steps to reproduce:

 1) Start the application
 
 2) curl --request GET   --url http://localhost:8080/api/get   --header 'B3: 6ca651329a7d693a-5f034638765deb09-0'
 
Context is propagated to the target service, but trace ids are missing in the logs:

[2m2023-05-04T10:42:42.575+02:00[0;39m [32mDEBUG [tracing-sample-gateway,,][0;39m [35m18460[0;39m [2m---[0;39m [2m[ctor-http-nio-4][0;39m [36mr.n.http.server.HttpServerOperations    [0;39m [2m:[0;39m [379d815a, L:/127.0.0.1:8080 - R:/127.0.0.1:55050] New http connection, requesting read
[2m2023-05-04T10:42:42.576+02:00[0;39m [32mDEBUG [tracing-sample-gateway,,][0;39m [35m18460[0;39m [2m---[0;39m [2m[ctor-http-nio-4][0;39m [36mr.n.http.server.HttpServerOperations    [0;39m [2m:[0;39m [379d815a, L:/127.0.0.1:8080 - R:/127.0.0.1:55050] Increasing pending responses, now 1
[2m2023-05-04T10:42:42.577+02:00[0;39m [32mDEBUG [tracing-sample-gateway,,][0;39m [35m18460[0;39m [2m---[0;39m [2m[ctor-http-nio-4][0;39m [36mreactor.netty.http.server.HttpServer    [0;39m [2m:[0;39m [379d815a-1, L:/127.0.0.1:8080 - R:/127.0.0.1:55050] Handler is being applied: org.springframework.http.server.reactive.ReactorHttpHandlerAdapter@149d9b5
[2m2023-05-04T10:42:43.265+02:00[0;39m [32mDEBUG [tracing-sample-gateway,,][0;39m [35m18460[0;39m [2m---[0;39m [2m[ctor-http-nio-4][0;39m [36mr.netty.http.client.HttpClientConnect   [0;39m [2m:[0;39m [84bcba0e-1, L:/10.1.82.125:55051 - R:httpbin.org/52.86.68.46:443] Handler is being applied: {uri=https://httpbin.org/get, method=GET}
[2m2023-05-04T10:42:45.392+02:00[0;39m [32mDEBUG [tracing-sample-gateway,,][0;39m [35m18460[0;39m [2m---[0;39m [2m[ctor-http-nio-4][0;39m [36mr.n.http.client.HttpClientOperations    [0;39m [2m:[0;39m [84bcba0e-1, L:/10.1.82.125:55051 - R:httpbin.org/52.86.68.46:443] Received response (auto-read:false) : RESPONSE(decodeResult: success, version: HTTP/1.1)
HTTP/1.1 200 OK
Date: <filtered>
Content-Type: <filtered>
Content-Length: <filtered>
Connection: <filtered>
Server: <filtered>
Access-Control-Allow-Origin: <filtered>
Access-Control-Allow-Credentials: <filtered>
[2m2023-05-04T10:42:45.395+02:00[0;39m [32mDEBUG [tracing-sample-gateway,,][0;39m [35m18460[0;39m [2m---[0;39m [2m[ctor-http-nio-4][0;39m [36mr.n.http.client.HttpClientOperations    [0;39m [2m:[0;39m [84bcba0e-1, L:/10.1.82.125:55051 - R:httpbin.org/52.86.68.46:443] Received last HTTP packet
[2m2023-05-04T10:42:45.399+02:00[0;39m [32mDEBUG [tracing-sample-gateway,,][0;39m [35m18460[0;39m [2m---[0;39m [2m[ctor-http-nio-4][0;39m [36mr.n.http.server.HttpServerOperations    [0;39m [2m:[0;39m [379d815a-1, L:/127.0.0.1:8080 - R:/127.0.0.1:55050] Last HTTP response frame
[2m2023-05-04T10:42:45.400+02:00[0;39m [32mDEBUG [tracing-sample-gateway,,][0;39m [35m18460[0;39m [2m---[0;39m [2m[ctor-http-nio-4][0;39m [36mr.n.http.server.HttpServerOperations    [0;39m [2m:[0;39m [379d815a-1, L:/127.0.0.1:8080 - R:/127.0.0.1:55050] Decreasing pending responses, now 0
[2m2023-05-04T10:42:45.401+02:00[0;39m [32mDEBUG [tracing-sample-gateway,,][0;39m [35m18460[0;39m [2m---[0;39m [2m[ctor-http-nio-4][0;39m [36mr.n.http.server.HttpServerOperations    [0;39m [2m:[0;39m [379d815a-1, L:/127.0.0.1:8080 - R:/127.0.0.1:55050] Last HTTP packet was sent, terminating the channel
 