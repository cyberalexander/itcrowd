<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 16.08.15
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrapper">
  <div>
    <h3 class="topic-h3">TOPICS</h3>
    <h4 class="information">${success}</h4>

    <div>
      <table class="table table-striped table-condensed table-bordered">
        <thead  class="topic-tr">
        <tr>
          <td>TOPIC ID</td>
          <td>TOPIC NAME</td>
          <td>Edit</td>
          <td>Delete</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${topicDTOs}" var="topicDTO">
          <tr>
            <td>${topicDTO.topicId}</td>
            <td>${topicDTO.topicName}</td>
            <td><a href="<c:url value='/edit-${topicDTO.topicId}-topic' />"><i class="icon-pencil"></i></a></td>
            <td><a href="<c:url value='/delete-${topicDTO.topicId}-topic' />"><i class="icon-remove"></i></a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
