package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import javax.imageio.ImageIO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.StringConverter;
import model.Participant;
import model.Spectator;
import model.Tournament;

public class TournamentController {
	
	Tournament tourn;	
	FileChooser explorer;
	File data;
	
	public void initialize() {
		explorer = new FileChooser();
		explorer.setTitle("Open CSV file");
		explorer.getExtensionFilters().add(new ExtensionFilter("CSV","*.csv") );
		explorer.setInitialDirectory(new File("./"));
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
    private TreeView<?> treeViewTab;

    @FXML
    void exploreFile(ActionEvent event) {
    	data = explorer.showOpenDialog(null);
    }

    @FXML
    void loadFile(ActionEvent event) {
    	//fill participants and spectators
    }

    @FXML
    void searchParticipant(ActionEvent event) {
    	int partID = Integer.parseInt(participantText.getText());
    	tourn.searchParticipant(partID);

    }

    @FXML
    void searchSpectator(ActionEvent event) {

    }

    @FXML
    void selectParticipant(ActionEvent event) {

    }

    @FXML
    void selectSpectator(ActionEvent event) {

    }
    public void loadSearch(Participant a,Spectator b) {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    	
    }

}
