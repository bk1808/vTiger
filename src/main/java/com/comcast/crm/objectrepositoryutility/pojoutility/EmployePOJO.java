package com.comcast.crm.objectrepositoryutility.pojoutility;

public class EmployePOJO {
	
	    public String designation;
	    public String dob;
	    public String email;
	    public String empName;
	    public double experience;
	    public String mobileNo;
	    public String project;
	    public String role;
	    public String username;
	    
	    private EmployePOJO(){}
	    
	    
	    
		public EmployePOJO(String designation, String dob, String email, String empName, double experience,
				String mobileNo, String project, String role, String username) {
			super();
			this.designation = designation;
			this.dob = dob;
			this.email = email;
			this.empName = empName;
			this.experience = experience;
			this.mobileNo = mobileNo;
			this.project = project;
			this.role = role;
			this.username = username;
		}



		public String getDesignation() {
			return designation;
		}
		public String getDob() {
			return dob;
		}
		public String getEmail() {
			return email;
		}
		public String getEmpName() {
			return empName;
		}
		public double getExperience() {
			return experience;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public String getProject() {
			return project;
		}
		public String getRole() {
			return role;
		}
		public String getUsername() {
			return username;
		}
	    
	    

}
