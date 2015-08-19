<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 16.08.15
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="inquiryBean" class="com.leonovich.itcrowd.model.InquiryDTO" scope="session"/>
<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav">
            <li><a href="/customers/inquiries">MAIN</a></li>
            <li>
                <a href="#">Create new Topic</a>
            </li>
            <li><a class="btn-link" href="/topics" role="button">All Topics</a></li>
            <li>
                <div class="searchform">
                    <form class="navbar-search" method="GET" action="<c:url value='#' />" accept-charset="utf-8">
                      <input class="input-long search-query" placeholder="Search.." type="text" name="customerNam" id="customerNam"/>
                      <button type="submit" class="btn btn-small"><i class="icon-search"></i></button>
                    </form>
                </div>
            </li>
            <li>
                <c:if test="${customer ne null}">
                    <form method="post" action="/customers/${customer}/inquiries">
                        <button type="submit" class="btn btn-small">CREATE INQUIRY FOR ${customer}</button>
                    </form>
                </c:if>
            </li>
        </ul>
    </div>
</div>
