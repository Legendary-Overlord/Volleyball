package model;

public class Spectator implements Comparable<Spectator>{

	//tree
	Spectator left;
	Spectator right;
	
	int id;
	String fname;
	String lname;
	String email;
	String gender;
	String country;
	String avatar;
	String birthday;
	public Spectator(int id, String fname, String lname, String email, String gender,
			String country, String avatar, String birthday) {
		left = null;
		right = null;
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.avatar = avatar;
		this.birthday = birthday;
	}
	public Spectator getLeft() {
		return left;
	}
	public void setLeft(Spectator prev) {
		this.left = prev;
	}
	public Spectator getRight() {
		return right;
	}
	public void setRight(Spectator next) {
		this.right = next;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Spectator searchSpectator(int ID) {
		if( id==ID ){
            return this;
        }
        else{
        	Spectator temp1 = left.searchSpectator(ID);
        	Spectator temp2 = right.searchSpectator(ID);
        	if(temp1!=null)
        		return temp1;
        	else if(temp2 !=  null)
        		return temp2;
        	else
        		return null;
        }
	}
	
	@Override
	public int compareTo(Spectator o) {
		int a = id;
		int b = o.getId();
		return (a<b)?-1:(a>b)?1:0;
	}
	
}
