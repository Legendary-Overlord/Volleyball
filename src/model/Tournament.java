package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
		return firstPart.searchParticipant(id);
	}
	public Spectator searchSpectator(int id) {
		return rootSpec.searchSpectator(id);
	}
	public void load(File data) {
		try {
			BufferedReader read = new BufferedReader(new FileReader(data));	
			String dat="";
			int count=0;
			int specCount=0;
			while((dat=read.readLine())!=null) {
				String info[] = dat.split(",");
				if(!info[0].equals("id")) {
					//System.out.println(Integer.parseInt(info[0].replace("-", ""))+info[1]+info[2]+info[3]+info[4]+info[5]+info[6]+info[7]);
					Spectator spec = new Spectator(Integer.parseInt(info[0].replace("-", "")),info[1],info[2],info[3],info[4],info[5],info[6],info[7]);
					addSpectator(spec,rootSpec);
					specCount++;
				}
				count++;
			}
			read.close();
			System.out.println("Spec: "+specCount);
			ArrayList<Spectator> partList = specInOrder(rootSpec);
			System.out.println(partList.size());
			for(int i=0;i<partList.size();i++) {
				if(Math.random()<0.5)
					partList.remove(i);
			}
			ArrayList<Participant> thePartList = new ArrayList<Participant>();
			for(Spectator spec:partList) {
				thePartList.add(new Participant(spec.getId(),spec.getFname(),spec.getLname(),spec.getEmail(),spec.getGender(),spec.getCountry(),spec.getAvatar(),spec.getBirthday()));
			}
			for(Participant part:thePartList) {
				addParticipant(part);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addSpectator(Spectator s,Spectator root) {
		if(root==null)
			rootSpec=s;
		else {
				if (root.compareTo(s)==-1){
					if (root.getRight()==null) 
						root.setRight(s);
					else 
						addSpectator(s,root.getRight());
				}else if(root.compareTo(s)==1){
					if(root.getLeft()==null)
						root.setLeft(s);
					else
						addSpectator(s, root.getLeft());;
				}
			}
	}
	
	public void addParticipant(Participant p) {
		if(firstPart==null)
			firstPart=p;
		else {
			p.setNext(firstPart);
			firstPart=p;
			p.getNext().setPrev(p);
		}
	}
	
	private ArrayList<Spectator> specInOrder(Spectator node){
		ArrayList<Spectator> sel= new ArrayList<Spectator>();
		if (node!=null) {
			sel.addAll(specInOrder(node.getLeft()));
			sel.add(node);
			sel.addAll(specInOrder(node.getRight()));
		}
		return sel;
	}
}
