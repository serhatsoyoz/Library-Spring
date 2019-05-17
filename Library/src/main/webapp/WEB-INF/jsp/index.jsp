<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
  <title>Library</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="index.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="">Library</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/show/booktypes">Book Types</a></li>
      <li><a href="/show/books">Books</a></li>
    </ul>
  </div>
</nav>
  
<div class="container">
</div>
	<c:if test="${status == 'showbooktypes'}">
		<table class="table table-striped table-hover table-bordered" width=50%>
		    <thead>
		      <tr>
		        <th>Name</th>
		        <th>Edit</th>
		        <th>Delete</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="bookType" items="${bookTypes}">
		      	<tr>
		      		<td class="col-md-3">${bookType.name}</td>
		      		<td class="col-md-1"><a href="/edit/booktype?id=${bookType.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
		      		<td class="col-md-1"><a href="/del/booktype?id=${bookType.id}"><div class="glyphicon glyphicon-minus"></div></a></td>
		      	</tr>
		      </c:forEach>
		    </tbody>
	    </table>
	    <br/>
	    <a href="/new/booktype"><div class="glyphicon glyphicon-plus"> Add</div></a>
	</c:if>
	<c:if test="${status == 'showbooks'}">
		<table class="table table-striped table-hover table-bordered" width=50%>
		    <thead>
		      <tr>
		        <th>Name</th>
		        <th>ISBN</th>
		        <th>Type</th>
		        <th>Edit</th>
		        <th>Delete</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="book" items="${books}">
		      	<tr>
		      		<td class="col-md-3">${book.name}</td>
		      		<td class="col-md-3">${book.isbn}</td>
		      		<td class="col-md-3">${book.bookType}</td>
		      		<td class="col-md-1"><a href="/edit/book?id=${book.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
		      		<td class="col-md-1"><a href="/del/book?id=${book.id}"><div class="glyphicon glyphicon-minus"></div></a></td>
		      	</tr>
		      </c:forEach>
		    </tbody>
	    </table>
	    <br/>
	    <a href="/new/book" ><div class="glyphicon glyphicon-plus"> Add</div></a>
	</c:if>
	<c:if test="${status == 'editbooktype'}">
		<form action="/save/booktype" method="post">
		 	<input type="hidden" class="form-control" value="${bookType.id}" name="id" id="id">
		 	<div class="form-group">
		 		<label for="name">Name:</label>
		 		<input type="text" class="form-control" value="${bookType.name}" name="name" id="name">
		 	</div>
		 	<button type="submit" class="btn btn-default">Submit</button>
		 </form>
	</c:if>
	<c:if test="${status == 'editbook'}">
		<form action="/save/book" method="post">
		 	<input type="hidden" class="form-control" value="${book.id}" name="id" id="id">
		 	<div class="form-group">
		 		<label for="name">Name:</label>
		 		<input type="text" class="form-control" value="${book.name}" name="name" id="name">
		 		<label for="isbn">ISBN:</label>
		 		<input type="text" class="form-control" value="${book.isbn}" name="isbn" id="isbn">
		 		<label for="book">Book Type:</label>
		 		<select class="form-control" name="bookType" id= "bookType">
		 			<c:forEach items="${bookTypes}" var="booktype">
		 				<c:choose>
							<c:when test="${book.bookType == booktype.name}">
								<option value="${booktype.name}" selected>${booktype.name}</option>
							</c:when>
							<c:otherwise>
								<option value="${booktype.name}">${booktype.name}</option>
						    </c:otherwise>
						</c:choose>
		 			</c:forEach>
		 		</select>
		 	</div>
		 	<button type="submit" class="btn btn-default">Submit</button>
		 </form>
	</c:if>
	<c:if test="${status == 'newbooktype'}">
		<form action="/save/booktype" method="post">
		 	<input type="hidden" class="form-control" value="${bookType.id}" name="id" id="id">
		 	<div class="form-group">
		 		<label for="name">Name:</label>
		 		<input type="text" class="form-control" value="${bookType.name}" name="name" id="name">
		 	</div>
		 	<button type="submit" class="btn btn-default">Submit</button>
		 </form>
	</c:if>
	<c:if test="${status == 'newbook'}">
		<form action="/save/book" method="post">
		 	<input type="hidden" class="form-control" value="${book.id}" name="id" id="id">
		 	<div class="form-group">
		 		<label for="name">Name:</label>
		 		<input type="text" class="form-control" value="${book.name}" name="name" id="name">
		 		<label for="isbn">ISBN:</label>
		 		<input type="text" class="form-control" value="${book.isbn}" name="isbn" id="isbn">
		 		<label for="book">Book Type: </label>
		 		<select class="form-control" name="bookType" id= "bookType">
		 			<c:forEach items="${bookTypes}" var="booktype">
		 				<option value="${booktype.name}">${booktype.name}</option>
		 			</c:forEach>
		 		</select>
		 	</div>
		 	<button type="submit" class="btn btn-default">Submit</button>
		 </form>
	</c:if>
</body>
</html>
