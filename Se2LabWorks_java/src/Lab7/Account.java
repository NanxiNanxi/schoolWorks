/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab7;

/**
 *
 * @author nancy
 */
public class Account {
    private String accountName;
    private String conStr;
    private String passWord ;

    public Account() {
        this.passWord = "bekind";
    }

    public Account(String accountName, String conStr, String passWord) {
        this.accountName = accountName;
        this.conStr = conStr;
        this.passWord = "bekind";
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getConStr() {
        return conStr;
    }

    public void setConStr(String conStr) {
        this.conStr = conStr;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
}
