<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: alexanderleonovich
  Date: 16.08.15
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper">
    <div>
        <h3 class="inquiry-h3">Editing Inquiry</h3>
        <form:form method="post" modelAttribute="inquiryDTO"
                   action="/customers/${inquiryDTO.customerName}/inquiries/${inquiryDTO.inquiryId}">
            <form:input path="inquiryId" value="${inquiryDTO.inquiryId}" type="hidden"/>
            <table>
                <tr>
                    <td><label for="description">Description: </label></td>
                    <td><form:textarea rows="4" cols="50" name="description" path="description"/><br/></td>
                </tr>
                <tr>
                    <td><label>Topic: </label></td>
                    <td>
                        <form:select path="topic">
                            <form:options items="${topicDTOs}" itemValue="topicId" itemLabel="topicName"/>
                        </form:select>
                    </td>
                </tr>

                <tr>
                    <td><label for="createDate">Creation date: </label></td>
                    <td><form:input path="createDate" id="createDate" value="${inquiryDTO.createDate}"
                                    readonly="true"/></td>
                </tr>
                <tr>
                    <td><label for="modifiedWhen">Date of Last modification: </label></td>
                    <td><form:input path="modifiedWhen" id="modifiedWhen" value="${inquiryDTO.modifiedWhen}"
                                    readonly="true"/></td>
                </tr>
                <tr>
                    <td><label for="customerName">Name of Customer: </label></td>
                    <td><form:input path="customerName" id="customerName" value="${inquiryDTO.customerName}"
                                    readonly="true"/></td>
                </tr>
                <tr>
                    <td colspan="3"><input class="btn" type="submit" value="Edit"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>