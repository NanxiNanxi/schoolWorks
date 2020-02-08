<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="UploadPage.aspx.cs" Inherits="GameAPP.UploadPage" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:ObjectDataSource ID="ObjectGameList" runat="server" SelectMethod="getGames" TypeName="GameAPP.MediaUtilities" ></asp:ObjectDataSource>
            <asp:DataList ID="DataList1" runat="server" CellPadding="4" DataSourceID="ObjectGameList" ForeColor="Black" BackColor="White" BorderColor="#DEDFDE" BorderStyle="None" BorderWidth="1px" GridLines="Vertical" AutoPostBack="True" >
                <AlternatingItemStyle BackColor="White" />
                <FooterStyle BackColor="#CCCC99" />
                <HeaderStyle BackColor="#6B696B" Font-Bold="True" ForeColor="White" />
                <ItemStyle BackColor="#F7F7DE" />
                <ItemTemplate>
                    Id:
                    <asp:Label ID="IdLabel" runat="server" Text='<%# Eval("Id") %>' />
                    <br />
                     Title:
                    <asp:LinkButton ID="TitleLink" runat="server" Text='<%# Eval("Title") %>' OnClick="TitleLink_Click"/>
                    <br />
                    TagLine:
                    <asp:Label ID="TagLineLabel" runat="server" Text='<%# Eval("TagLine") %>' />
                    <br />
                    Description:
                    <asp:Label ID="DescriptionLabel" runat="server" Text='<%# Eval("Description") %>' />
                    <br />
                    Year:
                    <asp:Label ID="YearLabel" runat="server" Text='<%# Eval("Year") %>' />
                    <br />
<br />
                </ItemTemplate>
                <SelectedItemStyle BackColor="#CE5D5A" Font-Bold="True" ForeColor="White" />
            </asp:DataList>
            <br />
            <table class="auto-style1">
                <tr>
                    <td>Title:</td>
                    <td>
                        <asp:TextBox ID="txtTitle" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>Tag:</td>
                    <td>
                        <asp:TextBox ID="txtTag" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>Decription:</td>
                    <td>
                        <asp:TextBox ID="txtDescription" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>Year:</td>
                    <td>
                        <asp:TextBox ID="txtYear" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>
                        Upload images:</td>
                    <td>
                        <asp:FileUpload ID="gameImageUpload" runat="server" />
&nbsp;&nbsp;&nbsp;
                        <asp:Button ID="btnUpload" runat="server" Text="Upload" OnClick="btnUpload_Click" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <asp:Button ID="btnInsert" runat="server" OnClick="btnInsert_Click" Text="Insert" />
                    </td>
                    <td>&nbsp;</td>
                </tr>
            </table>
            <br />
        </div>
    </form>
</body>
</html>