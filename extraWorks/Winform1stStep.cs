  partial class FrmP
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.menuDocument = new System.Windows.Forms.ToolStripMenuItem();
            this.menuAddNew = new System.Windows.Forms.ToolStripMenuItem();
            this.menuClose = new System.Windows.Forms.ToolStripMenuItem();
            this.menuQuit = new System.Windows.Forms.ToolStripMenuItem();
            this.menuCloseAll = new System.Windows.Forms.ToolStripMenuItem();
            this.windows = new System.Windows.Forms.ToolStripMenuItem();
            this.levelArrange = new System.Windows.Forms.ToolStripMenuItem();
            this.verticalArrange = new System.Windows.Forms.ToolStripMenuItem();
            this.aboveArrange = new System.Windows.Forms.ToolStripMenuItem();
            this.about = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuDocument,
            this.windows,
            this.about});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.MdiWindowListItem = this.windows;
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(800, 25);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // menuDocument
            // 
            this.menuDocument.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuAddNew,
            this.menuClose,
            this.menuQuit});
            this.menuDocument.Name = "menuDocument";
            this.menuDocument.Size = new System.Drawing.Size(44, 21);
            this.menuDocument.Text = "文件";
            // 
            // menuAddNew
            // 
            this.menuAddNew.Name = "menuAddNew";
            this.menuAddNew.Size = new System.Drawing.Size(180, 22);
            this.menuAddNew.Text = "新建";
            this.menuAddNew.Click += new System.EventHandler(this.menuAddNew_Click);
            // 
            // menuClose
            // 
            this.menuClose.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuCloseAll});
            this.menuClose.Name = "menuClose";
            this.menuClose.Size = new System.Drawing.Size(180, 22);
            this.menuClose.Text = "关闭";
            this.menuClose.Click += new System.EventHandler(this.menuClose_Click);
            // 
            // menuQuit
            // 
            this.menuQuit.Name = "menuQuit";
            this.menuQuit.Size = new System.Drawing.Size(180, 22);
            this.menuQuit.Text = "退出";
            this.menuQuit.Click += new System.EventHandler(this.menuQuit_Click);
            // 
            // menuCloseAll
            // 
            this.menuCloseAll.Name = "menuCloseAll";
            this.menuCloseAll.Size = new System.Drawing.Size(180, 22);
            this.menuCloseAll.Text = "关闭全部";
            this.menuCloseAll.Click += new System.EventHandler(this.menuCloseAll_Click);
            // 
            // windows
            // 
            this.windows.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.levelArrange,
            this.verticalArrange,
            this.aboveArrange});
            this.windows.Name = "windows";
            this.windows.Size = new System.Drawing.Size(44, 21);
            this.windows.Text = "窗体";
            // 
            // levelArrange
            // 
            this.levelArrange.Name = "levelArrange";
            this.levelArrange.Size = new System.Drawing.Size(180, 22);
            this.levelArrange.Text = "水平";
            this.levelArrange.Click += new System.EventHandler(this.levelArrange_Click);
            // 
            // verticalArrange
            // 
            this.verticalArrange.Name = "verticalArrange";
            this.verticalArrange.Size = new System.Drawing.Size(180, 22);
            this.verticalArrange.Text = "垂直";
            this.verticalArrange.Click += new System.EventHandler(this.verticalArrange_Click);
            // 
            // aboveArrange
            // 
            this.aboveArrange.Name = "aboveArrange";
            this.aboveArrange.Size = new System.Drawing.Size(180, 22);
            this.aboveArrange.Text = "层叠";
            this.aboveArrange.Click += new System.EventHandler(this.aboveArrange_Click);
            // 
            // about
            // 
            this.about.Name = "about";
            this.about.Size = new System.Drawing.Size(44, 21);
            this.about.Text = "关于";
            this.about.Click += new System.EventHandler(this.about_Click);
            // 
            // FrmP
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.menuStrip1);
            this.Cursor = System.Windows.Forms.Cursors.Default;
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "FrmP";
            this.Text = "父窗体";
            this.Load += new System.EventHandler(this.FrmP_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem menuDocument;
        private System.Windows.Forms.ToolStripMenuItem menuAddNew;
        private System.Windows.Forms.ToolStripMenuItem menuClose;
        private System.Windows.Forms.ToolStripMenuItem menuQuit;
        private System.Windows.Forms.ToolStripMenuItem menuCloseAll;
        private System.Windows.Forms.ToolStripMenuItem windows;
        private System.Windows.Forms.ToolStripMenuItem levelArrange;
        private System.Windows.Forms.ToolStripMenuItem verticalArrange;
        private System.Windows.Forms.ToolStripMenuItem aboveArrange;
        private System.Windows.Forms.ToolStripMenuItem about;
    }
 private void InitializeComponent()
        {
            this.SuspendLayout();
            // 
            // frmC
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Name = "frmC";
            this.Text = "子窗体";
            this.Load += new System.EventHandler(this.frmC_Load);
            this.ResumeLayout(false);

        }
        
        public partial class FrmP : Form
    {
        public FrmP()
        {
            InitializeComponent();
        }

        private void FrmP_Load(object sender, EventArgs e)
        {

        }

        private void menuAddNew_Click(object sender, EventArgs e)
        {
            //需实例化子窗体先
            frmC child = new frmC();
            child.MdiParent = this;
            child.Show();
        }

        private void menuClose_Click(object sender, EventArgs e)
        {
            Form frm = this.ActiveMdiChild;//关闭激活状态的子窗口
            frm.Close();
        }

        private void menuQuit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void menuCloseAll_Click(object sender, EventArgs e)
        {
            foreach(Form frm in this.MdiChildren)
            {
                Form fc = this.ActiveMdiChild;
                fc.Close();
            }
        }

        private void levelArrange_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.TileHorizontal);
        }

        private void verticalArrange_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.TileVertical);
        }

        private void aboveArrange_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.Cascade);
        }

        private void about_Click(object sender, EventArgs e)
        {
            MessageBox.Show("这是关于信息", "关于",MessageBoxButtons.OKCancel, MessageBoxIcon.Information,MessageBoxDefaultButton.Button2);
        }
    }
 
