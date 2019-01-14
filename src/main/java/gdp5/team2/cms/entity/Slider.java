/**
 * 
 */
package gdp5.team2.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author User
 *
 */
@Entity
@Table(name = "slider")
public class Slider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "slider_id", nullable = false)
	private int slider_id;
	
	@Column(name = "slider_name")
	private String slider_name;

	public Slider() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Slider(int slider_id, String slider_name) {
		super();
		this.slider_id = slider_id;
		this.slider_name = slider_name;
	}

	public int getSlider_id() {
		return slider_id;
	}

	public void setSlider_id(int slider_id) {
		this.slider_id = slider_id;
	}

	public String getSlider_name() {
		return slider_name;
	}

	public void setSlider_name(String slider_name) {
		this.slider_name = slider_name;
	}
}
