# soap_webservice
You can learn how to create an Axis2 SOAP web service from this repository.

## Introduction

_SOAP brings it’s own protocol and focuses on exposing pieces of application logic (not data) as services. SOAP exposes operations. SOAP is focused on accessing named operations, each implement some business logic through different interfaces._

If you need extra securiy then SOAP is a good choice for you. Okay Lets start now!

If you are interested to do everything from scratch then go through the following steps:
* As we are going to create an Axis2 SOAP web service, first of all in Eclipse axis2 runtime should be located. Go to https://axis.apache.org/axis2/java/core/download.cgi and downd the war file distribution of latest release. Unzipp it.
* Now in Eclipse go to window->preference->web services and locate the Axis2 war distribution folder that you have downloaded already.
* In this step create a Dynamic Web Project in eclipse. You have to select _Dynamic web module version 2.5_. Click __Modify__ under __Configuration__ and select __Axis2 Web Services__. 
* Download java-json.jar file from http://www.java2s.com/Code/Jar/j/Downloadjavajsonjar.htm. If you download zipped file then unzip it and put java-json.jar file in your project's lib folder. Note that, our web service will send and receive data in Json format and that is why we need this jar file. 
* I have used Apache Tomcat 7.0 as my application server.

## Project Description

The project contains two classes:
* __SOAPWebService:__ This class contains two methods: i) postMethod which accepts String parameter and returns Json String, ii) getMethod which doesn't have any parameter and returns Json String. This class is actually our service class.
* __Utility:__ This class is used to construct JSON data.

## Convert your dynamic web project to a Axis2 web service project

In Eclipse:
* Click on File->New->other->Web service.
* Select your class as "Service implementation"
* Now click on "Web service runtime" under Configuration. and select Apache Axis2 from next window and click OK.
* Make sure that Service project is your project. If it is not your project then you mistakenly did not choose Dynamic Web module Version 2.5 as the while creating your project.
* Finish the rest of the steps by clicking Next.
* Now your project is ready to run on server.

## Run your project

* Right click on your project and Run As> Run On Server. You should see a Welcome! page with three links: _i) Services ii) Validate and iii) administration_. Click on _Services_. You should see _Version_ and your web service class _SOAPWebService_. Under your web service class you should see: 
  - Service Description : Please Type your service description here 
  - Service EPR : http://localhost:8080/soap_webservice/services/SOAPWebService
  - Service Status : Active and 
  - Available Operations. These operations are methods of your webservice class.
  __Note:__ You can see the WSDL file if you click on _SOAPWebService_. 

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
* After log in click on the _Upload Service_ text and upload the .aar file that you have created earlier.
* Now click on the _Available Services_ you should see that your service is running :).
* You can click on your service name and it will show the wsdl file. You can also copy the URL of _Service ERP_ and paste to the browser. As an example: http://localhost:8080/soap_webservice/services/SOAPWebService?wsdl, __NOTE:__ you have to add ?wsdl at the end of the URL. 
* To access the web service from any client just use the URL with ?wsdl at the end. 

