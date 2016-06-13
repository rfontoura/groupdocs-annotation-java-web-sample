## GroupDocs.Annotation for Java
#### **Modified** Servlet Sample 2.1.0 **to run with Apache Maven**
![Alt text](https://media.licdn.com/media/p/7/005/059/258/39b2da3.png "Optional title")

How-to install/run
------

##### Windows/Linux/MacOS
1. You **must** have Apache Maven installed. If not, install it [from the website](http://maven.apache.org/install.html)
1. Install GroupDocs.Annotation for Java library into local maven repository http://groupdocs.com/docs/display/annotationjava/GroupDocs.Annotation+for+Java+-+Installation
1. Open `src/main/webapp/WEB-INF/application.properties` file for editing. Edit properties to fill your needs
1. Open cmd/console/terminal and type and run command `mvn package`
1. Go to `target` folder
1. Copy `document-viewer.war` file into your tomcat webapps directory
1. Run tomcat.
1. Open URL `http://127.0.0.1:8080/document-viewer` in your browser, make sure that port 8080 is free (you can change port number in your tomcat configuration)

How to view/open file documents
-------------------------------
1. Go to http://127.0.0.1:8080/document-viewer/?file=fileId
2. Go to http://127.0.0.1:8080/document-viewer/?file=path_to_file_from_root_dir
3. Go to http://127.0.0.1:8080/document-viewer/?file=url_to_file
4. Go to http://127.0.0.1:8080/document-viewer/?tokenId=tokenId