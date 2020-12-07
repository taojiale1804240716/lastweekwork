package vo;

public class school {
 
  private String school_id;
  private String school_name;
  private String school_type;
  private String area_id;
  private String area_name;
  private String display_order;
public String getSchool_id() {
	return school_id;
}
public void setSchool_id(String school_id) {
	this.school_id = school_id;
}
public String getSchool_name() {
	return school_name;
}
public void setSchool_name(String school_name) {
	this.school_name = school_name;
}
public String getSchool_type() {
	return school_type;
}
public void setSchool_type(String school_type) {
	this.school_type = school_type;
}
public String getArea_id() {
	return area_id;
}
public void setArea_id(String area_id) {
	this.area_id = area_id;
}
public String getArea_name() {
	return area_name;
}
public void setArea_name(String area_name) {
	this.area_name = area_name;
}
public String getDisplay_order() {
	return display_order;
}
public void setDisplay_order(String display_order) {
	this.display_order = display_order;
}
public school() {
	super();

}
public school(String school_id, String school_name, String school_type, String area_id, String area_name,
		String display_order) {
	super();
	this.school_id = school_id;
	this.school_name = school_name;
	this.school_type = school_type;
	this.area_id = area_id;
	this.area_name = area_name;
	this.display_order = display_order;
}
@Override
public String toString() {
	return "school [school_id=" + school_id + ", school_name=" + school_name + ", school_type=" + school_type
			+ ", area_id=" + area_id + ", area_name=" + area_name + ", display_order=" + display_order + "]";
}

}
