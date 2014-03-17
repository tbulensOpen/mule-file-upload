***********************************************
* Project: Mule File Upload
***********************************************

Objective: To demostrate the following use cases using an ESB called Mule to take advantage of transport adaptors
           that have already been written and proven to work.

    Use Case #1: Batch File Processing
    a) Poll a directory looking for files using MULE ( ESB ) file adaptor.
    b) Call a groovy component from MULE that takes in an input stream.
    c) For each line write it to a queue using MULE JMS adaptor.
    d) Read from a queue usng MULE JMS adaptor and call a groovy component
    e) Have the input file copied to a backup directory including a time stamp using MULE file adaptor.

    Use Case #2: Http Request for single file processing.
    a) Make an http request ( either thru a browser or test code ) passing in the file name.
    b) MULE recieves the http request using the http adaptor and calls a groovy component taking in a map of arguments.
    c) Groovy component opens up the file, parses each line and write each line to the queue using MULE JMS adaptor.
    d) Read from a queue using MULE JMS adaptor and calls a groovy component

    By using MULE, I do not require any tomcat containers and no JMS wiring in my application.
    I am able to accomplish both use cases by creating a mule application ( zip file ).

    The mule config was also wired up to use spring autowiring capabilities.

Key Components:
1) File Upload Module
   a) pom.xml
      a1) Mule dependencies
      a2) <packaging>mule</packaging>
      a3) <plugin>
             <groupId>org.mule.tools</groupId>
             <artifactId>maven-mule-plugin</artifactId>
             <version>1.7</version>
             <extensions>true</extensions>
             <configuration>
             <copyToAppsDirectory>true</copyToAppsDirectory>
             </configuration>
          </plugin>

          This plugin will copy the mule application ( zip file ) to mule apps directory that is set in MULE_HOME.

   b) mule-config.xml
      This is the plumbing for mule to work. Define flows, each flow may contain an inbound, outbound adapter.

 2) Maven -- Due to ISL repository settings in Maven, I had to download my own version of maven and point to that version.
             After that, I had no access to ISL artifacts, so I copied ISL-Web-Service ( SimplePost ) logic into the util
             package of File Upload module.
    Need to get ISL maven settings fixed so that other artifacts can be found.

 3) Need to download mule. I have version 3.3.1 installed.

 4) Need to set MULE_HOME as an environment variable and point it to mule-standalone-3.3.1 directory.

 5) Start up mule: mule-standalone-3.3.1\bin\mule.bat

 6) To invoke the FileParser over HTTP, hit the following URL in your browser:
       http://localhost:8085/fileParser?fileName=SomeFileName

 7) To invoke a file in a directory, mule-config is currently configured to read from:
    c:\temp\mule and put incoming file to: c:\temp\mule\output when done calling FileParserBatch component.

---------------------------------------------------------------------------------------------------------------
Why ESB:
1) ESB is a service container. It can hold many components without additional containers.
    Usages: All web services and batch jobs can be built as a zip file and deployed to a single container.

2) ESB allows multiple versions of the same component to be running side by side.

3) Security can be isolated to the ESB and not the components themselves. Only the ESB can call the components.
   Then, you only need to secure who can call the ESB.

4) Reading/Writing to Queues is only done by the ESB. Therefore, security to the queues is limited to one user/password.
   Upgrading to a different JMS provider or upgrading to a newer version is reduced down to the ESB.

5) What applications calls which versions of components and how frequent can be logged in the ESB,
   and not in the application themselves.

6) Pre-Built Transport Adapters have already been tested and proven by the industry. No need to reinvent the code.

7) Performance monitoring should be provided by the ESB.

8) ESB allows more than one instance if needed for load balancing.

9) ESB provides failover capabilities in case of catastrophic failure.

10) Some ESB may provide a visual representation of how systems interact with each other.
    For example: Mule config is XML based, and it has a visual studio that can display the flow visually.
    How does ISL now manage what systems can call which sub systems and those sub systems calls other sub systems?

11) How easy is it today to deploy a new version of a web service? Such as agreements, branding?
    Using an ESB, deploy a new version ( Database migration is an issue -- and needs its own discussion )
    and start pointing applications to use the new version incrementally.

12) Today, we as developers were told not to break backward compatibility in are code so we did not impact other areas.
    ESB can help solve those issues.




