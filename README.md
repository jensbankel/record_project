# record_project

General
This is a simple web service that can echo back a JSON object.
This project represents a server for a database of music records using JPA, Derby and Wildfly. 
The project lets the client use GET, POST, PUT anf DELETE.


Running
Build the project using ANT or Maven deploying JAR or WAR to Wildfly with a derby databse connected.


The release contains a sample data so run the server, run main and visit: http://localhost:8080/RecordManagement/webservice/records

API
The API is very simple and endpoints that return JSON data depending on the parameters.

http://localhost:8080/RecordManagement/webservice/records/<id>

http://localhost:8080/RecordManagement/webservice/records?artist=<parameter>

http://localhost:8080/RecordManagement/webservice/records?title=<parameter>

http://localhost:8080/RecordManagement/webservice/records?genre=<parameter>

http://localhost:8080/RecordManagement/webservice/records?barCode=<parameter>

# To run the project with our test client application clone and use this project:

https://github.com/jensbankel/client_record_project



2021-05-26
Alexander Gabay, Naoya Irikura & Jens Bankel