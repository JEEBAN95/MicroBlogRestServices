package com.mv.api.payload;

/**
 * Custom pay load for display api information as response.
 * @author Jeeban
*/
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {

	private String userName;
	private String userEmail;
	private String messages;

	public Response(String userName, String userEmail, String messages) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "Response [userName=" + userName + ", userEmail=" + userEmail + ", messages=" + messages + "]";
	}

}
