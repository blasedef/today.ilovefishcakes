<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I love fish cakes!</title>
<style>
#overlay1 {
    background-color: #FFFFFE;
    z-index:100;
}
#overlay2 {
    background-color: #FFFFFE;
    z-index:1;
}
#overlay3 {
    background-color: #FFFFFE;
    z-index:100;
}
</style>
</head>
<body>

<%
	String text = (String) request.getAttribute("text");
	String ascii = (String) request.getAttribute("ascii");
	String pre = "<pre style='font: 10px/5px monospace;' align='center'>";
	String post = "</pre>";
	String h2 = "<h2 align='center'>" + text + "</h2>";
	String title = "<div id='overlay1'>"  + h2 + "</div>";
	String bulk = "<div id='overlay2'>"  + pre + ascii + post + "</div>";
	String refresh = "<div id='overlay3'> <h2 align='center'><a href='www.ilovefishcakes.today'>refresh the page for more fish cake news!</a> </h2></div>";
	out.print(title);
	out.print(bulk);
	out.print(refresh);
%>

</body>
</html>