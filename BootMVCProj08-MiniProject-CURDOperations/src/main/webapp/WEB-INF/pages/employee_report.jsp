<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty empsList}">
		<table border="1" bgcolor="cyan" align="center">
			<tr bgcolor="pink">
				<th>ENo</th>
				<th>EName</th>
				<th>Desg</th>
				<th>Salary</th>
				<th>Dept No</th>
				<th>Operations</th>
			</tr>
			<c:forEach var="emp" items="${empsList}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td>${emp.deptno}</td>
					<td>
						<a href="edit_employee?eno=${emp.empno}"> 
							<img class="user-operation" src="images/edit-user.png" />
						</a> &nbsp;&nbsp; 
						<a href="delete_employee?eno=${emp.empno}" onclick="confirm('Do you want to delete?')"> 
							<img class="user-operation" src="images/delete-user.png" />
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center;">Records not Found</h1>
	</c:otherwise>
</c:choose>
<br>
	<h1 class="blink_me" style="color: green; text-align: center;">${resultMsg}</h1>
<br>
<div style="text-align: center;">
	<a href="add_employee"> 
		<img class="user-operation" src="images/add-user.png" />
	</a> 
	&nbsp;&nbsp; 
	<a href="./"> 
		<img class="user-operation" src="images/home.png" />
	</a>
</div>

<style>
.user-operation {
	height: 50px;
	width: 50px;
}

.blink_me {
  animation: blinker 1s linear infinite;
}

@keyframes blinker {
  50% {
    opacity: 0;
  }
}
</style>