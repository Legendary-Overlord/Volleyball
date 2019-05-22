package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Participant;
import model.Spectator;
import model.Tournament;

public class TournamentController {
	
	Tournament tourn;	
	FileChooser explorer;
	File data;
	
	public void initialize() {
		tourn = new Tournament();
		explorer = new FileChooser();
		explorer.setTitle("Open CSV file");
		explorer.getExtensionFilters().add(new ExtensionFilter("CSV","*.csv") );
		explorer.setInitialDirectory(new File("./res"));
		data=new File("./");
	}

    @FXML
    private TextField exploreText;

    @FXML
    private Label procData;

    @FXML
    private TextField spectatorText;

    @FXML
    private Label specTime;

    @FXML
    private Label procSpec;

    @FXML
    private TextField participantText;

    @FXML
    private Label partTime;

    @FXML
    private Label procPart;

    @FXML
    private Label dataID;

    @FXML
    private Label dataFName;

    @FXML
    private Label dataLName;

    @FXML
    private Label dataEmail;

    @FXML
    private Label dataGender;

    @FXML
    private Label dataCountry;

    @FXML
    private Label dataBirthday;

    @FXML
    private ImageView avatar;
    
    @FXML
    private Canvas canvas;


    @FXML
    void exploreFile(ActionEvent event) {
    	data = explorer.showOpenDialog(null);
    	exploreText.setText(data.toString());
    }

    @FXML
    void loadFile(ActionEvent event) {
    	//fill participants and spectators
    		tourn.load(data);
    }

    @FXML
    void searchParticipant(ActionEvent event) {
    	int partID = Integer.parseInt(participantText.getText());
    	long s1 = System.nanoTime();
    	Participant part=tourn.searchParticipant(partID);
    	long time = System.nanoTime()-s1;
    	loadSearch(part,null,time);
    }

    @FXML
    void searchSpectator(ActionEvent event) {
    	int partID = Integer.parseInt(spectatorText.getText());
    	long s1 = System.nanoTime();
    	Spectator spec =tourn.searchSpectator(partID);
    	long time = System.nanoTime()-s1;
    	loadSearch(null,spec,time);
    }

    @FXML
    void selectParticipant(ActionEvent event) {

    }

    @FXML
    void selectSpectator(ActionEvent event) {

    }
    
    private void loadSearch(Participant a,Spectator b, long time) {
    	if(a!=null) {
    		dataID.setText(Integer.toString(a.getId()));
    		dataFName.setText(a.getFname());
    		dataLName.setText(a.getLname());
    		dataEmail.setText(a.getEmail());
    		dataGender.setText(a.getGender());
    		dataCountry.setText(a.getCountry());
    		dataBirthday.setText(a.getBirthday());
    		try {
				avatar.setImage(new Image(new FileInputStream(a.getAvatar())));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    		specTime.setText("Time "+Long.toString(time));
    		procSpec.setText("Complete");
    		
    	}
    	if(b!=null) {
    		dataID.setText(Integer.toString(b.getId()));
    		dataFName.setText(b.getFname());
    		dataLName.setText(b.getLname());
    		dataEmail.setText(b.getEmail());
    		dataGender.setText(b.getGender());
    		dataCountry.setText(b.getCountry());
    		dataBirthday.setText(b.getBirthday());
    		try {
				avatar.setImage(new Image(new FileInputStream(b.getAvatar())));
			} catch (FileNotFoundException e) {
				// 
				e.printStackTrace();
			}
    		partTime.setText("Time "+Long.toString(time));
    		procPart.setText("Complete");
    		
    	}
    	
    	
    }

}
