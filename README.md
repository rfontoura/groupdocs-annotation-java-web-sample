##GroupDocs.Annotation for Java
####Servlet Sample 1.8.0
![Alt text](https://media.licdn.com/media/p/7/005/059/258/39b2da3.png "Optional title")

<br/><br/>

How-to install/run
------

#####Windows/Linux/MacOS
1. Download GroupDocs.Annotation for Java library http://groupdocs.com/java/document-annotation-library
2. Extract GroupDocs.Annotation for Java library archive into any directory.
3. Download sample sources to any directory.
4. If maven repository is available on your server/PC, install GroupDocs.Annotation for Java library into local maven repository http://groupdocs.com/docs/display/annotationjava/GroupDocs.Annotation+for+Java+-+Installation, otherwise skip this step.
5. Open `build.properties` file for editing.
6. Change `project.tomcat.home` property (on line 11) to your tomcat path.
7. This step should be followed **ONLY** if step 4 was skipped. Update `project.m2.home` property (on line 2) and `project.annotation.path` property (on line 3), where `project.m2.home` is the path to GroupDocs.Annotation for Java library and `project.annotation.path` is the name of the file.
<br>*Ex:* `project.m2.home=C:/temp/GroupDocs.Annotation_1.5.0_java/lib/`, `project.annotation.path=GroupDocs.Annotation.jar`.
8. Open `web/WEB-INF/application.properties` file for editing. Edit properties to fill your needs.
9. Open cmd/console/terminal and type and run command `ant war`.
10. Go to `dist` folder created after step 9.
11. Copy war file into your tomcat webapps directory.
12. Run tomcat.
13. Open URL `http://127.0.0.1:8080/document-annotation/` in your browser, make sure that port 8080 is free (you can change port number in your tomcat configuration).
<br/><br/><br/><br/>

How to view/open file documents
-------------------------------
1. Go to http://127.0.0.1:8080/view?file=fileId
2. Go to http://127.0.0.1:8080/view?file=path_to_file_from_root_dir
3. Go to http://127.0.0.1:8080/view?file=url_to_file
4. Go to http://127.0.0.1:8080/view?tokenId=tokenId
<br/><br/><br/><br/>

Description
---------------
A flexible library that lets end users annotate Microsoft Office, PDF and other documents within your Java applications. The library comes with a comprehensive set of markup tools, which allow end users to highlight, strike through, and comment text and images. Annotated documents can be printed out and exported to PDF or Microsoft Word.
