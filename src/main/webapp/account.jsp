<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="account_practise.Account" %>
<!DOCTYPE html>
<html lang="zh-Hant" dir="ltr">
	<head>
		<meta charset="UTF-8">
		<title>銀行帳戶管理</title>
	</head>
	<body>
		<p>
			<a href="addAccount">
				<button type="button"></button>
			</a>
		</p>
		<hr>

    <h2>帳戶列表</h2>

    <table border="1">
        <tr>
            <th>編號</th>
            <th>銀行</th>
            <th>帳戶名稱</th>
            <th>金額</th>
            <th>更新時間</th>
            <th>功能</th>
        </tr>
        
        <%
    List<Account> accounts = (List<Account>) request.getAttribute("accounts");

    if (accounts != null) {
        for (Account account : accounts) {
            String updateFormId = "updateForm" + account.getAcc_id();
            String deleteFormId = "deleteForm" + account.getAcc_id();
%>
            <tr>
                <td>
                    <%= account.getAcc_id() %>
                </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
<%
        }
    }
%>
    </table>
	</body>
	


</html>

