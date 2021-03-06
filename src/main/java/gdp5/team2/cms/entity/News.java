package gdp5.team2.cms.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "news_id", nullable=false)
	private int new_id;

	@Column(name = "url", nullable=false, length=225)
	private String url;

	@Column(name = "title", nullable=false, length=225)
	private String title;

	@Column(name = "news_desc", nullable=false, length=150)
	private String description;

	@Column(name = "content", nullable=false)
	private String content;

	@Column(name = "news_status", nullable=false, length=50)
	private String newsStatus;

	@Column(name = "is_hot", nullable=false, length=50)
	private String isHot;

	@OneToOne
	@JoinColumn(name = "user_id")
	private Users user;

	@Column(name = "approver_id", nullable=false)
	private int approverID;

	@Column(name = "created_at", nullable=false, length=50)
	private String createdAt;

	@Column(name = "updated_at", nullable=false, length=50)
	private String updatedAt;

	@Column(name = "approved_at", nullable=false, length=50)
	private String approvedAt;

	public News(int new_id, String url, String title, String description, String content, String newsStatus,
			String isHot, Users user, int approverID, String createdAt, String updatedAt, String approvedAt) {
		super();
		this.new_id = new_id;
		this.url = url;
		this.title = title;
		this.description = description;
		this.content = content;
		this.newsStatus = newsStatus;
		this.isHot = isHot;
		this.user = user;
		this.approverID = approverID;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.approvedAt = approvedAt;
	}

	public News() {
		super();
	}

	public int getNewsID() {
		return new_id;
	}

	public void setNewsID(int newsID) {
		this.new_id = newsID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNewsStatus() {
		return newsStatus;
	}

	public void setNewsStatus(String newsStatus) {
		this.newsStatus = newsStatus;
	}

	public String getIsHot() {
		return isHot;
	}

	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public int getApproverID() {
		return approverID;
	}

	public void setApproverID(int approverID) {
		this.approverID = approverID;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(String approvedAt) {
		this.approvedAt = approvedAt;
	}
}
