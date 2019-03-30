# A-Simplified-Remote-Invocation-Framework

Part 1: Java TCP Networking, Multi-threading and Object Serialization Programming

The framework consists of a compute-server, a compute-client and a codebase repository, which are depicted in the following diagram. The framework is a generic computing architecture because the compute-client and compute-server just need to know the Task and CSMessage
interface or class in advance before the framework can start to run.

2. The compute-client and compute-server

The compute-server is used as a generic compute-engine. When running, the server is continuously waiting for the compute-tasks. A compute-task is created by a compute-client and sent as a serialized object to the compute-server. Once the compute-server receives a task, it will cast (be deserialized) it into the Task interface type and call its executeTask() method. After executing the task, the compute-server will send the same object back to the computeclient. The compute-client is continuously accepting a user’s requests. Every request specifies a compute-problem and its corresponding parameters. For a request, the compute-client creates a compute-task and sends it as a serialized object to the compute-server. Once receiving the compute-task object back from the server, the compute-client will call the getResult() method of the object to display the result.
