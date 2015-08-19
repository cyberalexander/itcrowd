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
        <h3 class="inquiry-h3">Adding Attribute of Inquiry</h3>
        <form:form method="post" modelAttribute="attributeOfInquiryDTO"
                   action="/customers/save/attribute/inquiries">
            <form:input path="id" value="${attributeOfInquiryDTO.id}" type="hidden"/>
            <table>
                <tr>
                    <td><label for="name">Name: </label></td>
                    <td colspan="2"><form:textarea rows="2" cols="50" name="name" path="name"/><br/></td>
                </tr>
                <tr>
                <tr>
                    <td><label for="value">Value: </label></td>
                    <td colspan="2"><form:textarea rows="4" cols="50" name="value" path="value"/><br/></td>
                </tr>
                </tr>
                <tr>
                    <td colspan="3"><input class="btn" type="submit" value="Add attribute"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>