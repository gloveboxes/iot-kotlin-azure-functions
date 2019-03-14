# Azure Functions with Kotlin

## Storage Emulation

### Linux Azurite

A lightweight server clone of Azure Blob, Queue, and Table Storage that simulates most of the commands supported by it with minimal dependencies.

```bash
mkdir ~/azurite-storage

docker run -d --restart always -t -p 10000:10000 -p 10001:10001 -p 10002:10002 -v ~/azurite-storage:/opt/azurite/folder arafato/azurite
```

## local.settings.json

```json
{
  "IsEncrypted": false,
  "Values": {
    "FUNCTIONS_WORKER_RUNTIME": "java",
    "AzureWebJobsStorage": "UseDevelopmentStorage=true",
    "gloveboxau": "UseDevelopmentStorage=true"
  }
}
```

### Java pom.xml

https://docs.microsoft.com/en-us/java/api/overview/azure/maven/azure-functions-maven-plugin/readme?view=azure-java-stable#common-configuration

https://docs.microsoft.com/en-us/azure/azure-functions/functions-create-maven-intellij

https://docs.microsoft.com/en-us/java/api/overview/azure/maven/azure-functions-maven-plugin/readme?view=azure-java-stable

https://github.com/Azure/azure-functions-java-library


## Set up your development environment

1. Java SDK  (https://www.azul.com/downloads/azure-only/zulu/)
1. Maven
1. Azure Functions Tools

## Install IntelliJ

[Install community Edition](https://www.jetbrains.com/idea/download/#section=linux)

## Create your first Azure Function

```bash
mvn archetype:generate \
    -DarchetypeGroupId=com.microsoft.azure \
    -DarchetypeArtifactId=azure-functions-archetype
```

1. 'groupId': com.glovebox.functions
2. 'artifactId' : glovebox-functions


Adding Service Bus Library Support



## Adding a Global Library to local project

File -> Project Settings -> Global Librraries

Right Mouse Click the Library and "Add to Modules"



## Build and Run

mvn clean package
mvn azure-functions:run


## Service Bus

https://github.com/Azure/azure-service-bus-java

```xml
<dependency> 
  <groupId>com.microsoft.azure</groupId> 
  <artifactId>azure-servicebus</artifactId> 
  <version>1.2.8</version>
</dependency>
```


## Extension Version

note on how to determine the latest version of the extensions

https://docs.microsoft.com/en-us/azure/azure-functions/functions-bindings-register#local-development-azure-functions-core-tools

pom.xml

        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.5</version>
        </dependency>

## Event HUb

https://github.com/Azure/azure-event-hubs-java





https://github.com/Azure/azure-service-bus/tree/master/samples/Java

https://github.com/Azure/azure-service-bus/tree/master/samples/Java/azure-servicebus

https://github.com/Azure/azure-service-bus-java

https://www.jetbrains.com/help/idea/library.html

https://github.com/Azure/azure-docs-sdk-java/blob/master/docs-ref-conceptual/intellij/azure-toolkit-for-intellij-installation.md

https://docs.microsoft.com/en-us/java/azure/intellij/azure-toolkit-for-intellij?view=azure-java-stable

https://docs.microsoft.com/en-au/java/azure/java-supported-jdk-runtime?view=azure-java-stable

[Azure Toolkit for IntelliJ](https://docs.microsoft.com/en-us/java/azure/intellij/azure-toolkit-for-intellij?view=azure-java-stable)

File -> Settings -> Plugins -> Browse (for Azure)

//import com.google.gson.reflect.TypeToken;
import com.microsoft.azure.servicebus.*;
//import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
//import com.google.gson.Gson;

## References

[Azure Functions Java developer guide](https://docs.microsoft.com/en-us/azure/azure-functions/functions-reference-java)
[Create your first Azure function with Java and IntelliJ (preview)](https://docs.microsoft.com/en-us/azure/azure-functions/functions-create-maven-intellij)
[Create your first function with Java and Maven](https://docs.microsoft.com/en-us/azure/azure-functions/functions-create-first-java-maven)



Things Network Data

016701420273271603684B04020186



# top commands

top

shift+o

filter by command

COMMAND=func

filter by cpu
%CPU>0.0



func extensions install -p Microsoft.Azure.WebJobs.Extensions.Storage -v 3.0.4

https://www.nuget.org/packages/Microsoft.Azure.WebJobs.Extensions.Storage


https://docs.microsoft.com/en-us/azure/azure-functions/functions-bindings-storage-table
