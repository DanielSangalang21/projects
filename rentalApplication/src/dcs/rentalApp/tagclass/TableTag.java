package dcs.rentalApp.tagclass;
import java.util.Calendar;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import dcs.rentalApp.ObjectFactory;
import dcs.rentalApp.bean.SoundEquipmentBean;
import dcs.rentalApp.implem.SoundEquipmentImplem;

public class TableTag extends TagSupport{
	
	public String action;
	public String doer;
	public String method;
	private static final long serialVersionUID = 1L;


	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDoer() {
		return doer;
	}

	public void setDoer(String doer) {
		this.doer = doer;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */

	
	@Override
	public int doStartTag() throws JspException {  
	    JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    try{  
	    	//soundEquipmentImplem = (SoundEquipmentImplem) pageContext.getRequest().getAttribute("implem");
	    	if("inquire"==action) {
	    		
	    		
	    		SoundEquipmentImplem implem  = (SoundEquipmentImplem) ObjectFactory.getObject(doer);
	    		@SuppressWarnings("unchecked")
	    		List<SoundEquipmentBean> euipmentList = (List<SoundEquipmentBean>) implem.getClass().getMethod(method, null).invoke(implem, null);
				//List<SoundEquipmentBean> euipmentList = (List<SoundEquipmentBean>) soundEquipmentImplem.getEquipments();
	    
	    		out.write("<table><tr>"
    					+ "<th>Equipment ID</th>"
    					+ "<th>Brand</th>"
    					+ "<th>Model</th>"
    					+ "<th>Available</th>"
    					+ "</tr>");
	    		for(SoundEquipmentBean equipment : euipmentList) {
	    			out.write("<tr>"
	    					+ "<td>"+equipment.getEquipmentId()+"</td>"
	    					+ "<td>"+equipment.getBrand()+"</td>"
	    					+ "<td>"+equipment.getModel()+"</td>"
	    					+ "<td>"+equipment.getAvailable()+"</td>"
	    					+ "</tr>");
	    		}
	    		out.write("</table><br>");
	    		out.write("<h5>Total number of records ("+ euipmentList.size()+")</h5>");
	    		
	    	}else {
	    		out.write("Sorry I don't know the action");
	    	}
	     out.print(Calendar.getInstance().getTime());//printing date and time using JspWriter  
	    }catch(Exception e){System.out.println(e);}  
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}
	
}
