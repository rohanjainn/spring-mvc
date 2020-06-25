<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM</h2>
		</div>
	</div> 

<div id="container">
	
	<div id="content">
	
	
	<table>
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
		</tr>
		
		<c:forEach var="temp" items="${customers}">
		<tr>
			<td>${temp.firstName}</td>
			<td>${temp.lastName }</td>
			<td>${temp.email}</td>
		</tr>
		
		</c:forEach>
		
	</table>

	</div>


</div>
<button id="button1">load github users</button> 
<br><br>

<h1>Github Users </h1>
<div id="users"></div>

<script>
document.getElementById('button1').addEventListener('click',loadUsers);

function loadUsers()
{ 
  var xhr=new XMLHttpRequest();
  xhr.open('GET','/users',true);
  xhr.onload=function(){
   if(this.status==200){
   
    var users=JSON.parse(this.responseText);
    
     
     var output='';
     for(var i in users)
     {
     	output +=
        '<div class="users">' +
        '<img src="'+users[i].avatar_url+'" width="70" height="70">'+
        '<p>ID: '+users[i].id+ '<br> '+
        'LoginID: ' +users[i].login +'</p>'+
        '</div>';
     }
     
     document.getElementById('users').innerHTML=output;
    }
  }
xhr.send();
}


</script>
</body>
</html>