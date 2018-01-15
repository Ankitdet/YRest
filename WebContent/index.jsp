<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome to rest application....

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File Test</title>
</head>
<body>
	<h2>Upload file</h2>
	<form action="/YuvaRest/rest/restful/uploadData" enctype="multipart/form-data" method="post">
		<label>Select File</label><input type= "file" name="file" /> <br/><br/>
		<label>Tags</label> <input name="tags" maxlength="10"/> <br/><br/>
		<input type="submit" title="Save"/>
	</form>
</body>
</html>
</body>
</html>