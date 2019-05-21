package model;



public class Tournament {
	//tree
	Participant firstPart;
	//list
	Spectator rootSpec;
	public Tournament() {
		firstPart =null;
		rootSpec = null;
	}
	public Participant getRootPart() {
		return firstPart;
	}
	public void setRootPart(Participant rootPart) {
		this.firstPart = rootPart;
	}
	public Spectator getFirstSpec() {
		return rootSpec;
	}
	public void setFirstSpec(Spectator firstSpec) {
		this.rootSpec = firstSpec;
	}
	
	
	public Participant searchParticipant(int id) {
		// TODO Auto-generated method stub
		return firstPart.searchParticipant(id);
	}
	public Spectator searchSpectator(int id) {
		return rootSpec.searchSpectator(id);
	}
}
