<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GuestBookPage.aspx.cs" Inherits="COMP235WebSite.GuestBookPage" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>


            <asp:SqlDataSource ID="SqlGuestBook" runat="server" 
                ConnectionString="<%$ ConnectionStrings:GuestBookConnectionString %>" 
                SelectCommand="SELECT [id], [Poster], [Message], [Date] FROM [Messages]" 
                InsertCommand="INSERT INTO Messages(Poster, Message, Date) VALUES (@Poster, @Message, @Date)"
                DeleteCommand="Delete from Messages where id=@id">
                <InsertParameters>
                   
                    <asp:SessionParameter Name="Poster" SessionField="user" DefaultValue="Anon" />
                    <asp:ControlParameter Name="Message" ControlID="txtMessage" />
                    <asp:Parameter Name="Date" />
                </InsertParameters>
                <DeleteParameters>
                    <asp:QueryStringParameter Name="id" QueryStringField="id" />
                </DeleteParameters>     
            </asp:SqlDataSource>
            <br />
            <br />
            Poster Handle:
            <asp:TextBox ID="txtPoster" runat="server" Width="248px"></asp:TextBox>
            <br />
            Message<br />
            <asp:TextBox ID="txtMessage" runat="server" Height="117px" TextMode="MultiLine" Width="350px"></asp:TextBox>
            <br />
            <br />
            <asp:Button ID="btnSave" runat="server" OnClick="btnSave_Click" Text="Save" Width="83px" />
            <br />
            <br />
            <asp:DataList ID="datPosts" DataSourceID="SqlGuestBook" runat="server" style="margin-right: 77px">
                <ItemTemplate>
                    Poster:
                    <asp:Label ID="PosterLabel" runat="server" Text='<%# Eval("Poster") %>' />
                    <br />
                    Message:
                    <asp:Label ID="MessageLabel" runat="server" Text='<%# Eval("Message") %>' />
                    <br />
                    Date:
                    <asp:Label ID="DateLabel" runat="server" Text='<%# Eval("Date") %>' />
                    <br />
<br />              <a href="GuestBookPage.aspx?id=<%# Eval("id") %>">Delete</a>     
                    <hr />
                </ItemTemplate>
                
            </asp:DataList>

            <br />

        </div>
    </form>
    <p>
        &nbsp;</p>
</body>
</html>
