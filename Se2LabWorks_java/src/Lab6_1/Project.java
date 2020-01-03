/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6_1;

/**
 *
 * @author zhou6718
 */
public class Project implements Comparable{
    private int projectNo;
    private String projectName;
    
    public Project(int projectNo, String projectName)
    {
        this.projectName = projectName;
        this.projectNo = projectNo;
    }
    public Project(){
        
    }

    public int getProjectNo() {
        return projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String toString(){
        return projectNo + ": " + projectName;
    }
    public int compareTo(Object o){
        Project p = (Project)o;
        if (p.getProjectNo() > this.getProjectNo() ) {
            return 1;
        }
        if(p.getProjectNo() == this.getProjectNo()){
            return 0;
        }
            return -1;
    }
}
