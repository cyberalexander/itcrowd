<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 16.08.15
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
  <link rel="stylesheet" href="<c:url value="/assests/css/common.css"/>">
</head>
<body style="background-color: #FFF">
<div class="container">

  <tiles:insertAttribute name="header"/>
  <tiles:insertAttribute name="body"/>

  <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
