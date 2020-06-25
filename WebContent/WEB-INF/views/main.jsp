<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Welcome

<a href="list" > Click to view the Customers</a>


</div>
<button id="button1">load all users</button> 
<br><br>

<h1>Users </h1>
<div id="users"></div>
<br><br>
<script>
document.getElementById('button1').addEventListener('click',loadUsers);

function loadUsers()
{ 
  var xhr=new XMLHttpRequest();
  xhr.open('GET','${pageContext.request.contextPath}/users',true);
  xhr.onload=function(){
   if(this.status==200){
   
    var users=JSON.parse(this.responseText);
    console.log(users);
     
    var em=users.email;
    //var res=em.replace("\\n"," ");
    
    var sp=em.split("\\n");
    console.log("split "+sp);
    var result='';
    for(var i in sp)
   	{
    	result+='<div class="users">' +
        '<p>Email '+sp[i]+ '<br>';
   	}
   /*  var result='<div class="users">' +
    '<p>Email '+res+ '<br> '
    */ /* for(var i in users)
  	{
  		//var spl=users[i].email.split("\\n");
  		var res=users[i].email.replace("\n"," ")
  		var result='<div class="users">' +
        '<p>Email '+res+ '<br> ';
  	} */
   // console.log("spl "+spl);
    //console.log("res "+res);
    console.log("result "+result)
   /*  var output='<div class="users">' +
    '<p>Email '+result +'<br> '+
    'LNAME: ' +users.lastName +'</p>'+
    '</div>'; */
     /* var output='';
     for(var i in users)
     {
     	output +=
        '<div class="users">' +
        '<p>Email '+users[i].email+ '<br> '+
        'LNAME: ' +users[i].lastName +'</p>'+
        '</div>';
     } */
     
     document.getElementById('users').innerHTML=result;
    }
  }
xhr.send();
}

function jsonEscape(str)
{
	return str.replace()
	}

</script>

<button onclick="window.location.href='addCustomerForm'">add customer</button>
</body>
</html>