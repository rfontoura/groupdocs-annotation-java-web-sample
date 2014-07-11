<%-- 
    Document   : index
    Created on : May 19, 2014, 12:35:58 AM
    Author     : Aleksey Pemyakov
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>GroupDocs Annotation for Java Sample</title>
    <%=(String) request.getAttribute("annotation_head")%>
</head>
<body>
<div id="annotation-widget"
     style="width:<%=(String) request.getAttribute("width")%>px;height:<%=(String) request.getAttribute("height")%>px;overflow:hidden;position:relative;margin-bottom:20px;background-color:gray;border:1px solid #ccc;"></div>
<%=(String) request.getAttribute("annotation_scripts")%>
</body>
</html>