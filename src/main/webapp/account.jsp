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
                	<form id="<%=updateFormId%>" action="updateAccount" method="post">
                		<input type="hidden" name="accId" value="<%= account.getAcc_id() %>">
                	</form>
                	
                	<form id="<%=deleteFormId%>" action="deleteAccount" method="post">
                		<input type="hidden" name="accId"value="<%= account.getAcc_id()%>">
                	</form>
                    <%= account.getAcc_id() %>
                </td>
                <td>
                	<input form="<%=updateFormId%>" class="editable" name="bank"
                	type="text" value="<%=account.getBank()%>" >
                </td>
                <td>
                	<input form="<%=updateFormId%>" class="editable" name="accName"
                	type="text" value="<%=account.getAcc_name()%>">
                </td>
                <td>
                	<input form="<%= updateFormId %>" class="editable" type="number"
                                   name="amount" step="0.01"
                                   value="<%= account.getAmount() %>" readonly required>
                </td>
                <td>
                	<%=account.getUpdate_date() %>
                </td>
                <td>
                	<button type="button" class="edit-update-btn" 
                	data-form="<%=updateFormId%>" 
                	data-mod="edit">
                	修改
                	</button>
                	<button form="<%=deleteFormId%>" type="submit"
                	class="delete-btn">
                		刪除
                	</button>
                </td>
            </tr>
<%
        }
    }
%>
    </table>
    <script>
        const editUpdateButtons = document.querySelectorAll(".edit-update-btn");

        editUpdateButtons.forEach(function(button) {
            button.addEventListener("click", function() {
                const formId = button.dataset.form;
                const mode = button.dataset.mode;

                if (mode === "edit") {
                    const inputs = document.querySelectorAll('[form="' + formId + '"].editable');

                    inputs.forEach(function(input) {
                        input.removeAttribute("readonly");
                    });

                    button.textContent = "更新";
                    button.dataset.mode = "update";
                } else {
                    const updateForm = document.getElementById(formId);

                    if (updateForm.requestSubmit) {
                        updateForm.requestSubmit();
                    } else {
                        updateForm.submit();
                    }
                }
            });
        });

        const deleteButtons = document.querySelectorAll(".delete-btn");

        deleteButtons.forEach(function(button) {
            button.addEventListener("click", function(event) {
                const result = confirm("確定要刪除這筆帳戶資料嗎？");

                if (!result) {
                    event.preventDefault();
                }
            });
        });
    </script>
	</body>
	


</html>

