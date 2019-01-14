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
	private int menuID;
	
	@Column(name="menu_name", nullable=false, length=225)
	private String menuName;
	
	@Column(name="menu_desc", nullable=false, length=225)
	private String descrpition;
	
	@Column(name="controller", nullable=false, length=150)
	private String controller;
	
	@Column(name="functions", nullable=false, length=225)
	private String functions;
	
	@OneToMany
	@JoinColumn(name="menu_id")
	Set<RoleMenu> roleMenus;

	public Menu(int menuID, String menuName, String descrpition, String controller, String functions,
			Set<RoleMenu> roleMenus) {
		super();
		this.menuID = menuID;
		this.menuName = menuName;
		this.descrpition = descrpition;
		this.controller = controller;
		this.functions = functions;
		this.roleMenus = roleMenus;
	}

	public Menu() {
		super();
	}

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getDescrpition() {
		return descrpition;
	}

	public void setDescrpition(String descrpition) {
		this.descrpition = descrpition;
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
	
	
	
}
