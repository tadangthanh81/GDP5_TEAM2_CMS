package gdp5.team2.cms.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="menu_id", nullable=false)
	private int menu_id;
	
	@Column(name="menu_name", nullable=false, length=225)
	private String menu_name;
	
	@Column(name="menu_desc", nullable=false, length=225)
	private String menu_desc;
	
	@Column(name="controller", nullable=false, length=150)
	private String controller;
	
	@Column(name="functions", nullable=false, length=225)
	private String functions;
	
	@OneToMany
	@JoinColumn(name="menu_id")
	Set<RoleMenu> roleMenus;

	

	public Menu(int menu_id, String menu_name, String menu_desc, String controller, String functions,
			Set<RoleMenu> roleMenus) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_desc = menu_desc;
		this.controller = controller;
		this.functions = functions;
		this.roleMenus = roleMenus;
	}

	public Menu() {
		super();
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_desc() {
		return menu_desc;
	}

	public void setMenu_desc(String menu_desc) {
		this.menu_desc = menu_desc;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getFunctions() {
		return functions;
	}

	public void setFunctions(String functions) {
		this.functions = functions;
	}

	public Set<RoleMenu> getRoleMenus() {
		return roleMenus;
	}

	public void setRoleMenus(Set<RoleMenu> roleMenus) {
		this.roleMenus = roleMenus;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", menu_name=" + menu_name + ", menu_desc=" + menu_desc + ", controller="
				+ controller + ", functions=" + functions + ", roleMenus=" + roleMenus + "]";
	}

}