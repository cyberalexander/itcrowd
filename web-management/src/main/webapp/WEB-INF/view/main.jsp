<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 16.08.15
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrapper">
    <div>
        <c:if test="${customer ne null}">
            <h3 class="inquiry-h3">INQUIRIES OF ${customer}</h3>
        </c:if>
        <c:if test="${customer eq null}">
            <h3 class="inquiry-h3">ALL INQUIRIES</h3>
        </c:if>
        <h4 class="inform">${success}</h4>

        <div>
            <table class="table table-striped table-condensed table-bordered">
                <thead class="main-tr">
                <tr>
                    <td>Inquiry ID</td>
                    <td>Description</td>
                    <td>Create date</td>
                    <td>Customer name<br/><em style="font-size: 8pt;">(Tap to get all inquiries of Customer)</em></td>
                    <td>Topic</td>
                    <td>Open</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${inquiryDTOs}" var="inquiryDTO">
                    <tr>
                        <td>${inquiryDTO.inquiryId}</td>
                        <td>${inquiryDTO.description}</td>
                        <td>${inquiryDTO.createDate}</td>
                        <td>
                            <a href="<c:url value='/customers/${inquiryDTO.customerName}/inquiries'/>">
                            ${inquiryDTO.customerName}</a>
                        </td>
                        <td>${inquiryDTO.topic}</td>
                        <td  style="text-align: center">
                            <a class="btn btn-small btn-info"
                               href="<c:url value='/customers/${inquiryDTO.customerName}/inquiries/${inquiryDTO.inquiryId}' />">
                                open inquiry</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
