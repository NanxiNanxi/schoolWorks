<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GuestBookLogin.aspx.cs" Inherits="COMP235WebSite.GuestBookLogin" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            User: <asp:TextBox ID="txtUser" runat="server"></asp:TextBox>
            <asp:LinkButton ID="lnkLogin" runat="server" OnClick="lnkLogin_Click">Login</asp:LinkButton>
           </div>
    </form>
</body>
</html>
