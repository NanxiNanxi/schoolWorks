<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="FlagQuiz.aspx.cs" Inherits="COMP235WebSite.FlagQuiz" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            
            <asp:RadioButtonList ID="radFlags" runat="server" 
                AutoPostBack="true" OnSelectedIndexChanged="radFlags_SelectedIndexChanged">
                <asp:ListItem>Australia</asp:ListItem>
                <asp:ListItem>Brazil</asp:ListItem>
                <asp:ListItem>China</asp:ListItem>
                <asp:ListItem>Italy</asp:ListItem>
                <asp:ListItem>Russia</asp:ListItem>
                <asp:ListItem Value="SouthAfrica">South Africa</asp:ListItem>
                <asp:ListItem>Spain</asp:ListItem>
                <asp:ListItem Value="UnitedStates">United States</asp:ListItem>
            </asp:RadioButtonList>

            <asp:Image ID="imgFlag" runat="server" /><br />

            <asp:Button ID="Button1" runat="server" Text="Button" />

        </div>
    </form>
</body>
</html>
