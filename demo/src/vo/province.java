package vo;

public class province {
    private int display_order;
    private String area_id;
    private String area_name;
	public province(int display_order, String area_id, String area_name) {
		super();
		this.display_order = display_order;
		this.area_id = area_id;
		this.area_name = area_name;
	}
	public int getDisplay_order() {
		return display_order;
	}
	public void setDisplay_order(int display_order) {
		this.display_order = display_order;
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
	@Override
	public String toString() {
		return "province [display_order=" + display_order + ", area_id=" + area_id + ", area_name=" + area_name + "]";
	}
	public province() {
		// TODO Auto-generated constructor stub
	}

}
