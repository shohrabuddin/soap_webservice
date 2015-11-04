# soap_webservice
You can learn how to create an Axis2 SOAP web service from this repository.

## Introduction

_SOAP brings it’s own protocol and focuses on exposing pieces of application logic (not data) as services. SOAP exposes operations. SOAP is focused on accessing named operations, each implement some business logic through different interfaces._
If you need extra securiy then SOAP is a good choice for your. Okay Let start now!

If you are interested to do everything from scratch then go through the following steps:
* As we are going to create an Axis2 SOAP web service, first of all in Eclipse axis2 runtime should be located. Got to https://axis.apache.org/axis2/java/core/download.cgi and downd the war file distribution of latest release. Unzipp it.
* Now in Eclipse go to window->preference->web services and locate the Axis2 war distribution folder that you have downloaded alredy.
* In this step create a Dynamic Web Project in eclipse. You have to select _Dynamic web module version 2.5_. Click __Modify__ under __Configuration__ and select __Axis2 Web Services__. 
* I have used Apache Tomcat 7.0 as my application server.

## Project Description

## Making the Dynamic web project to a Web service project

In Eclipse:
* Click on File->New->other->Web service.
* Select your class as "Service implementation"
* Now click on "Web service runtime" under Configuration. and select axis2 from next window.
* Make sure that Service project is your project. If it is not your project then you mistakenly did not choose Dynamic Web module Version 2.5 as the while creating your project.

## Creating .aar file for deployment

* Dowload org.apache.axis2.eclipse.service.plugin_1.6.2.jar or later verion.
* Put the above jar file into eclipse's (preferebly javaee version) dropins folder.
* Now open your eclipse (or restart) and you can find a new option "Axis2 Wizards" in File->New->Other. From there select Axis2 Service Archiver.
* In the next screen browse your class location. You can find it in build folder of your eclipse project. As an example: C:\Users\shohrab.uddin\eclipse\workspace\beeSmartWS\build\classes
* Click on "Inlclude .class files only" and then click next.
* In next screen click on "Skip WSDL" and click next
* In the next screen add necessary external jar files. for example mysql-connector.jar, java-json.jar etc and click next.
* In the next screen click "Generate the service xml automatically" and click next. 
* In the next screen provide the fully qualified path name (e.g. com.soap.WebService) of your class and then click on Load. You should see all the methods of your class. Select only those methods that you want to make available in your web service and unselect the rest.
* Click next and provide an output location of your service. and then click Finish. Thats all :)

You will find a .aar file has been created in the output location you have mentioed above.

## Deploying SOAP web sercvie (.aar file) into tomcat server


* Put axis2.war file ito webapps forlder of apache tomcat server. Note that, you should have already downloaded the axis2.war file if you followed __Introduction__ section.
* Now run/restart apache tomcat server. You should now be able to see the axis2 home page in a browser if your provide localhost:8080/axis2.
* Click on "Administration" of the axis2 home page.
* Now log in using admin and axis2 as username and password repectively. You can change the user name and password from /var/lib/tomcat7/webapps/axis2/WEB-INF/conf/axis2.xml file.
* After log in click on the Upload Service text and upload the .aar file that you have created earlier.
* Now click on the "Available Services" you should see that your service is running :).
* You can click on your service name and it will show the wsdl file. You can also copy the URL of "Service ERP" and paste to the browser. As an example: http://localhost:8080/axis2/services/my_service?wsdl NOTE: you have to add ?wsdl at the end of hte URL. 
* To access the web service from any client just use the URL with ?wsdl at the end. 

