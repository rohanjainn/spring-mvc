<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add customer</title>
</head>
<body>
<h2>add new customer</h2>

<form  id="formid" >


FirstName <input type="text" name="firstname" id="firstname"/><br>
Last Name <input type="text" name="lastname" id="lastname"/><br>
Email <input type="text" name="email"  id="email"/><br>

<input type="button" value="save" id="savebtn"/>

</form>

<script>

/*
$("#formid").submit(function(event) {
	 event.preventDefault();
	 
	// var $form = $( this ),
     //url = $form.attr( 'action' );
	 var url="${pageContext.request.contextPath}/saveCustomer";
	 console.log(url)
	 var posting = $.post( url, { firstName: $('#firstname').val(), lastName: $('#lastname').val() ,email: $('#email').val() } );
	 
	 posting.done(function( data ) {
	        alert('success');
	      });
});
*/

$(function () {
	$("#savebtn").click(function (e) {
		
	    var dataToPost = $("#formid").serialize()
	    $.ajax(
	    {
	        type: "POST",
	        data: dataToPost,
	        url: "${pageContext.request.contextPath}/saveCustomer"
	    })
	  })
	 
	})
</script>
</body>
</html>