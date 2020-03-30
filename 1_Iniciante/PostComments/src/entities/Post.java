package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	
	private Date momento;
	private String title;
	private String content;
	private Integer likes;
	
	private List<Comment> comments = new ArrayList<>();
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Post() {
	}

	public Post(Date momento, String title, String content, Integer likes) {
		this.momento = momento;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	/*public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	*/
	/*public void setLikes(Integer likes) {
		this.likes = likes;
	}*/
	
	public void addComments(Comment comment) {
		comments.add(comment);
	}
	
	public void removeComments(Comment comment) {
		comments.remove(comment);
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(title + "\n");
		sb.append(likes + " Likes - ");
		sb.append(sdf.format(momento) + "\n");
		sb.append(content + "\n");
		sb.append("Comments: \n");
		for (Comment comment : comments) {
			sb.append(comment.getText() + "\n");
		}
		return sb.toString();
	}
}
