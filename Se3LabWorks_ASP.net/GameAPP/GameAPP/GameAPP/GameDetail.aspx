<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GameDetail.aspx.cs" Inherits="GameAPP.GameDetail" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:ObjectDataSource ID="ObjectGameDetail" runat="server" SelectMethod="getGameByName" TypeName="GameAPP.MediaUtilities" DeleteMethod="DeleteGame">
                <DeleteParameters>
                    <asp:Parameter Name="id" Type="Int32" />
                </DeleteParameters>
                <SelectParameters>
                    <asp:SessionParameter Name="name" SessionField="GameName" Type="String" />
                </SelectParameters>
            </asp:ObjectDataSource>
            <br />
            <asp:ObjectDataSource ID="ObjectGameImages" runat="server" SelectMethod="getImagesByName" TypeName="GameAPP.MediaUtilities">
                <SelectParameters>
                    <asp:SessionParameter Name="gameName" SessionField="GameName" Type="String" />
                </SelectParameters>
            </asp:ObjectDataSource>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataSourceID="ObjectGameDetail"   DataKeyNames="Id">
                <Columns>
                    <asp:CommandField ShowDeleteButton="True" />
                    <asp:BoundField DataField="Id" HeaderText="Id" SortExpression="Id" />
                    <asp:BoundField DataField="Title" HeaderText="Title" SortExpression="Title" />
                    <asp:BoundField DataField="TagLine" HeaderText="TagLine" SortExpression="TagLine" />
                    <asp:BoundField DataField="Description" HeaderText="Description" SortExpression="Description" />
                    <asp:BoundField DataField="Year" HeaderText="Year" SortExpression="Year" />
                </Columns>
            </asp:GridView>
            <br />
            <asp:DataList ID="DataListImages" runat="server" RepeatColumns="3" RepeatDirection="Horizontal">
                <ItemTemplate>
                    <asp:Image ID="Image1" runat="server" Style="width: 200px"
                        ImageUrl='<%# Eval("Name", "~/UploadedImages/{0}") %>' /><br />
                    <%# Eval("Name") %><br />
                    <a href='GameDetail.aspx?fileToDelete=<%# Eval("Name")%>'>Delete</a>
                </ItemTemplate>
            </asp:DataList>
            <br />
            <asp:LinkButton ID="btnDeteleAll" runat="server" OnClick="btnDeteleAll_Click">Delete All Images</asp:LinkButton>
            <br />
            <br />
            Upload more images:<br />
            <asp:FileUpload ID="fileUpInDetail" runat="server" />
&nbsp;
            <asp:Button ID="btnUploadInDetail" runat="server" OnClick="btnUploadInDetail_Click" Text="upload" />
            <br />
            <br />
            <asp:Button ID="btnBack" runat="server" OnClick="btnBack_Click" Text="Back" />
            
        </div>
    </form>
</body>
</html>
