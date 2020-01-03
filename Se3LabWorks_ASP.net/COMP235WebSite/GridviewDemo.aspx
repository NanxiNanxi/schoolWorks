<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="GridviewDemo.aspx.cs" Inherits="COMP235WebSite.GridviewDemo" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 35%;
        }
        .auto-style2 {
            height: 23px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:SqlDataSource ID="sqlMovies" runat="server" 
                ConnectionString="<%$ ConnectionStrings:dbMovies00ConnectionString %>" 
                UpdateCommand="UPDATE Movies SET Title = @Title, Director = @Director, InTheaters = @InTheaters, Description = @Description, CategoryId=@CategoryId WHERE (Id = @Id)" 
                InsertCommand="INSERT INTO Movies(Title, Director, InTheaters, Description, CategoryId) VALUES (@Title, @Director, @InTheaters, @Description, @CategoryId)"
                DeleteCommand="DELETE FROM Movies where Id=@Id" SelectCommand="SELECT Movies.Id, Movies.Title, Movies.Director, Movies.InTheaters, Movies.Description, Movies.CategoryId, MovieCategories.Name FROM MovieCategories INNER JOIN Movies ON MovieCategories.Id = Movies.CategoryId">
                <DeleteParameters>
                    <asp:Parameter Name="Id" />
                </DeleteParameters>
                <InsertParameters>
                    <asp:ControlParameter Name="Title" ControlID="txtTitle" />
                    <asp:ControlParameter Name="Director" ControlID="txtDirector" />
                    <asp:ControlParameter Name="InTheaters" ControlID="chkInTheaters" />
                    <asp:ControlParameter Name="Description" ControlID="txtDescription" />
                    <asp:ControlParameter Name="CategoryId" ControlID="ddlMovieCats" 
                        PropertyName="SelectedValue" />
                </InsertParameters>
                <UpdateParameters>                   
                    <asp:Parameter Name="Title" />
                    <asp:Parameter Name="Director" />
                    <asp:Parameter Name="InTheaters" />
                    <asp:Parameter Name="Description" />
                    <asp:Parameter Name="CategoryId"  />
                    <asp:Parameter Name="Id" />
                </UpdateParameters>


            </asp:SqlDataSource>

            <asp:GridView ID="grdMovies" AutoGenerateColumns="False" DataKeyNames="Id" DataSourceID="sqlMovies" runat="server">
                <AlternatingRowStyle BackColor="#CCCCCC" Font-Names="Arial" ForeColor="#9933FF" />
                <Columns>
                    <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" />
                    <asp:BoundField DataField="Id" HeaderText="Id" InsertVisible="False" ReadOnly="True" SortExpression="Id" />
                    <asp:BoundField DataField="Title" HeaderText="Title" SortExpression="Title" />
                    <asp:BoundField DataField="Director" HeaderText="Director" SortExpression="Director" />
                    <asp:CheckBoxField DataField="InTheaters" HeaderText="InTheaters" SortExpression="InTheaters" />
                    <asp:BoundField DataField="Description" HeaderText="Description" SortExpression="Description" />
                    <asp:BoundField DataField="CategoryId" HeaderText="CategoryId" SortExpression="CategoryId" />
                    <asp:TemplateField HeaderText="Da-Cat-a-GORY">
                        <ItemTemplate>
                            
                            <asp:Label Id="lblMovieCategory" runat="server" Text='<%#Eval("Name")%>' /> 
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
                <HeaderStyle Font-Bold="True" Font-Names="Arial Black" Font-Size="Large" />
                <RowStyle BorderColor="#666666" Font-Names="Arial" ForeColor="#9900FF" />
            </asp:GridView>
            <hr />
           
            <strong>Add a movie&nbsp; </strong><br />
            <table class="auto-style1">
                <tr>
                    <td>Title:</td>
                    <td><asp:TextBox ID="txtTitle" runat="server"></asp:TextBox>
                    </td>
                </tr>
                <tr>
                    <td>Director:</td>
                    <td>  <asp:TextBox ID="txtDirector" runat="server"></asp:TextBox></td>
                </tr>
                <tr>
                    <td>In Theaters: </td>
                    <td> <asp:CheckBox ID="chkInTheaters" runat="server" /></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td> <asp:TextBox ID="txtDescription" TextMode="MultiLine" runat="server"></asp:TextBox></td>
                </tr>
                <tr>
                    <td class="auto-style2">Movie Category: </td>
                    <td class="auto-style2"> <asp:DropDownList ID="ddlMovieCats" runat="server" DataSourceID="sqlMovieCats" DataTextField="Name" DataValueField="Id"></asp:DropDownList></td>
                </tr>
            </table>
            <asp:Button ID="btnAddMovie" runat="server" OnClick="btnAddMovie_Click" Text="Add Movie" />
            <br />
        <hr />
            <table><tr><td>Add a category:</td>
            <td>
                <asp:TextBox id="txtName" runat="server" /></td>
            </tr>
            <tr><td colspan="2"> 
                <asp:Button ID="btnAddCategory" runat="server" Text="Add Movie Category" OnClick="btnAddCategory_Click" />
               </td>
                </tr>
            </table>
        </div>
        
        <asp:SqlDataSource ID="sqlMovieCats" runat="server" ConnectionString="<%$ ConnectionStrings:dbMovies00ConnectionString %>" 
            SelectCommand="SELECT [Id], [Name] FROM [MovieCategories]"
            InsertCommand="Insert Into MovieCategories (Name) Values (@Name)"
            >
        <InsertParameters>
            <asp:ControlParameter Name="Name" ControlID="txtName" />
                   
        </InsertParameters>
        </asp:SqlDataSource>
    </form>
</body>
</html>
