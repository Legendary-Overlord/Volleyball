package model;

public class Participant implements Comparable<Participant>{

	
	//list
	Participant prev;
	Participant next;
	
	int id;
	String fname;
	String lname;
	String email;
	String gender;
	String country;
	String avatar;
	String birthday;
	
	public Participant(int id, String fname, String lname, String email,
			String gender, String country, String avatar, String birthday) {
		prev = null;
		next = null;
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.avatar = avatar;
		this.birthday = birthday;
	}

	public Participant getLeft() {
		return prev;
	}

	public void setLeft(Participant left) {
		this.prev = left;
	}

	public Participant getRight() {
		return next;
	}

	public void setRight(Participant right) {
		this.next = right;
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
	public Participant searchParticipant(int ID) {
		return null;
	}

	@Override
	public int compareTo(Participant o) {
		int a = id;
		int b = o.getId();
		return (a<b)?-1:(a>b)?1:0;
	}
}
