<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DataAccessDemo.aspx.cs" Inherits="COMP235WebSite.DataAccessDemo" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>

            <asp:SqlDataSource ID="sqlMovieCats" runat="server" ConnectionString="<%$ ConnectionStrings:dbMovies00ConnectionString %>" SelectCommand="SELECT [Id], [Name] FROM [MovieCategories]"></asp:SqlDataSource>

            <asp:SqlDataSource ID="SqlMovies" 
                runat="server" 
                ConnectionString="<%$ ConnectionStrings:dbMovies00ConnectionString %>" 
                SelectCommand="SELECT [Id], [Title], [Director], [Description] FROM [Movies] WHERE ([CategoryId] = @CategoryId)">
                <SelectParameters>
                    <asp:QueryStringParameter DefaultValue="0" 
                        Name="CategoryId" 
                        QueryStringField="catId" 
                        Type="Int32" />
                </SelectParameters>
            </asp:SqlDataSource>
           
            <asp:Repeater ID="rptMovieCats" DataSourceID="sqlMovieCats" runat="server">
                <ItemTemplate>
                    <a href="DataAccessDemo.aspx?catId=<%#Eval("Id") %>">
                        <%#Eval("Name") %>
                    </a>|
                </ItemTemplate>

            </asp:Repeater>

            <asp:Repeater ID="rptMovies" runat="server" DataSourceID="SqlMovies">
                <ItemTemplate>
                    <div style="border:solid 1px blue; width:500px">
                    ID:<%#Eval("ID") %>Title: <%#Eval("Title") %><br />
                    Director: <%#Eval("Director") %><br />
                    Description:<br />
                        <%#Eval("Description") %><br />
                    </div>
                </ItemTemplate>
            </asp:Repeater>
        </div>
    </form>
</body>
</html>
