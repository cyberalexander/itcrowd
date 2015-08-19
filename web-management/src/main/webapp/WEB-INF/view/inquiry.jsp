<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 16.08.15
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper">
    <div>
        <h3 class="inquiry-h3">INQUIRY INFORMATION</h3>
        <h4 class="inform">${success}</h4>

        <div>
            <table class="table table-striped table-condensed table-bordered">
                <thead class="main-tr">
                <tr>
                    <td>Inquiry ID</td>
                    <td>Description</td>
                    <td>Attributes</td>
                    <td>Create date</td>
                    <td>Last modified date</td>
                    <td>Customer name<br/><em style="font-size: 8pt;">(Tap to get all inquiries of Customer)</em></td>
                    <td>Topic</td>
                    <td>Add attribute</td>
                    <td>Edit Inquiry</td>
                    <td>Delete Inquiry</td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${inquiryDTO.inquiryId}</td>
                    <td>${inquiryDTO.description}</td>
                    <td>
                        <c:forEach items="${attributes}" var="attribute">
                            <p>${attribute.name} : ${attribute.value}</p>
                            <hr/>
                        </c:forEach>
                    </td>
                    <td>${inquiryDTO.createDate}</td>
                    <td>${inquiryDTO.modifiedWhen}</td>
                    <td>
                        <a href="<c:url value='/customers/${inquiryDTO.customerName}/inquiries'/>">
                            ${inquiryDTO.customerName}
                        </a>
                    </td>
                    <td>${inquiryDTO.topic}</td>
                    <td>
                        <a class="btn btn-small btn-primary"
                           href="<c:url value='/customers/add/${inquiryDTO.inquiryId}/attribute/inquiries'/>">add attribute</a></td>
                    <td>
                        <a class="btn btn-small btn-warning" href="<c:url value='/customers/edit/${inquiryDTO.inquiryId}/inquiry'/>">Edit</a>
                    </td>
                    <td>
                        <form method="post" action="<c:url value='/customers/delete/${inquiryDTO.inquiryId}/inquiry' />">
                            <button class="btn btn-small btn-danger">Remove</button>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>