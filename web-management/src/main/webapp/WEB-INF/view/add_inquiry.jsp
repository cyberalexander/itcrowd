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
        <h3 class="inquiry-h3">Adding Inquiry</h3>
        <form:form method="post" modelAttribute="inquiryDTO"
                   action="/customers/save/inquiries">
            <table>
                <tr>
                    <td><label for="description">Description: </label></td>
                    <td colspan="2"><form:textarea rows="4" cols="50" name="description" path="description"/><br/></td>
                </tr>
                <tr>
                    <td><label>Topic: </label></td>
                    <td colspan="2">
                        <form:select path="topic">
                            <form:options items="${topicDTOs}" itemValue="topicId" itemLabel="topicName"/>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td><label for="customerName">Name of Customer: </label></td>
                    <td><form:input path="customerName" id="customerName" value="${inquiryDTO.customerName}"/></td>
                    <td><form:errors path="customerName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="3"><input class="btn" type="submit" value="Add inquiry"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>