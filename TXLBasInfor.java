
package contact;

/**
 *
 * @author g7512
 */
public class TXLBasInfor implements java.io.Serializable
{
	String xlnumber,name,phnumber,email,danwei,zhiwu;
	public void setXlnumber(String xlnumber)
	{
		this.xlnumber=xlnumber;
	}
	public String getXlnumber()
	{
		return xlnumber;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setPhnumber(String phnumber)
	{
		this.phnumber=phnumber;
	}
	public String getPhnumber()
	{
		return phnumber;
	}
	
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
	}
	
	public void setDanwei(String danwei)
	{
		this.danwei=danwei;
	}
	public String getDanwei()
	{
		return danwei;
	}
	
	public void setZhiwu(String zhiwu)
	{
		this.zhiwu=zhiwu;
	}
	public String getZhiwu()
	{
		return zhiwu;
	}
}