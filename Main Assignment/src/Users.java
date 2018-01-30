
public class Users {
	
		private String id;
		private String fName;
		private String lName;
		private String role;
		private String phoneNum;
		private String userType;
		
		
		public Users(String id, String fName, String lName, String role, String phoneNum, String userType) {
			super();
			this.id = id;
			this.fName = fName;
			this.lName = lName;
			this.role = role;
			this.phoneNum = phoneNum;
			this.userType = userType;
		}

		public String getId() {
			return id;
		}


		public String getfName() {
			return fName;
		}


		public String getlName() {
			return lName;
		}


		public String getRole() {
			return role;
		}


		public String getPhoneNum() {
			return phoneNum;
		}


		public String getUserType() {
			return userType;
		}


		public void setId(String id) {
			this.id = id;
		}


		public void setfName(String fName) {
			this.fName = fName;
		}


		public void setlName(String lName) {
			this.lName = lName;
		}


		public void setRole(String role) {
			this.role = role;
		}


		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}


		public void setUserType(String userType) {
			this.userType = userType;
		}

		public String toString() {
			return "User Id:" + id + ", First Name:" + fName + ", Last Name:" + lName + ", Role:" + role + ", Phone Number:"
					+ phoneNum + ", UserType:" + userType;
		}

		
		
}



