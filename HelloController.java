package com.example.cookieclicker;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

public class HelloController {
    public Label cookieCount;
    public Button btnCookieClick;
    public ListView<upgrade> upgradeList;
    public Label warningText;
    public Label upgName;
    public Label upgCost;
    public Label upgQuantity;
    public Label upgDescription;
    public Label cookiesPerSecond;
    public Label cookiesPerSecondAmt;
    public ListView clickUpgradesList;
    public Label clickUpgradeName;
    public Label clickUpgradeCost;
    public Label clickUpgradeDescription;
    public Label clickUpgradeCpc;
    public Label cookiesPerClickAmt;
    public Label achievementName;
    public Label achievementRequirement;
    public Label achievementOwned;
    public ListView achievementsList;
    int timesClicked = 0;
    Timer timer = new Timer();

    public void initialize(){
        //creates timer for 1 second to apply cookies per second to your total
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                int cps = Integer.parseInt(cookiesPerSecondAmt.getText());
                int c = Integer.parseInt(cookieCount.getText());
                Platform.runLater(() -> cookieCount.setText(String.valueOf(cps+c)));
            }
        }, 0, 1000);
    }


    public void cookieClick(MouseEvent mouseEvent) {
        if(timesClicked==0){
            //"starts" the game after 1 click: adds all upgrades
            timesClicked+=1;
            cookieCount.setText(String.valueOf(1));
            cookiesPerClickAmt.setText(String.valueOf(1));
            warningText.setText("");
            upgrade Grandma = new upgrade("Grandma",10,0,"A helpful grandma to help you bake cookies.",1);
            upgrade Garden = new upgrade("Garden",100,0,"Everyone knows cookies grow in the ground.",10);
            upgrade Bakery = new upgrade("Bakery",750,0,"Why does it only sell cookies?",75);
            upgrade Mine = new upgrade("Mine",2500,0,"Trading valuable ores for cookies always results in profit.",250);
            upgrade Bank = new upgrade("Bank",16000,0,"Free cookies with 0% interest!",1600);
            upgrade Temple = new upgrade("Temple",100000,0,"how does this work?",10000);
            upgrade Rocket = new upgrade("Rocket",500000,0,"Colonizing alien planets for baked goods.",50000);
            upgradeList.getItems().add(Grandma);
            upgradeList.getItems().add(Garden);
            upgradeList.getItems().add(Bakery);
            upgradeList.getItems().add(Mine);
            upgradeList.getItems().add(Bank);
            upgradeList.getItems().add(Temple);
            upgradeList.getItems().add(Rocket);
            clickUpgrade BetterCursor = new clickUpgrade("Better Cursor",50,0,"A better cursor for your clicking needs.",2,false);
            clickUpgrade EvenBetterCursor = new clickUpgrade("Even Better Cursor",500,0,"An even better cursor for your advanced clicking needs.",10,false);
            clickUpgrade GreatCursor = new clickUpgrade("Great Cursor",1000,0,"A great cursor for your highly advanced clicking needs.",50,false);
            clickUpgrade SuperCursor = new clickUpgrade("Super Cursor",5000,0,"A very fast cursor.",250,false);
            clickUpgrade MegaCursor = new clickUpgrade("Mega Cursor",50000,0,"The best cursor.",1000,false);
            clickUpgradesList.getItems().add(BetterCursor);
            clickUpgradesList.getItems().add(EvenBetterCursor);
            clickUpgradesList.getItems().add(GreatCursor);
            clickUpgradesList.getItems().add(SuperCursor);
            clickUpgradesList.getItems().add(MegaCursor);
            achievements HundredCookies = new achievements("100 Cookies",100,false);
            achievements ThousandCookies = new achievements("1K Cookies",1000,false);
            achievements TenThousandCookies = new achievements("10K Cookies",10000,false);
            achievements HundredThousandCookies = new achievements("100K Cookies",100000,false);
            achievements Millionaire = new achievements("Millionaire",1000000,false);
            achievementsList.getItems().add(HundredCookies);
            achievementsList.getItems().add(ThousandCookies);
            achievementsList.getItems().add(TenThousandCookies);
            achievementsList.getItems().add(HundredThousandCookies);
            achievementsList.getItems().add(Millionaire);
        }
        else {
            timesClicked+=1;
            cookieCount.setText(String.valueOf(Integer.parseInt(cookieCount.getText()) + Integer.parseInt(cookiesPerClickAmt.getText())));
        }

    }

    public void viewUpgrade(MouseEvent mouseEvent) {
        upgrade temp = (com.example.cookieclicker.upgrade) upgradeList.getSelectionModel().getSelectedItem();
        upgName.setText(temp.name);
        upgCost.setText(String.valueOf(temp.getCost()));
        upgQuantity.setText(String.valueOf(temp.quantity));
        upgDescription.setText(temp.description);
        cookiesPerSecond.setText(String.valueOf(temp.cps));

    }

    public void viewAchievement(MouseEvent mouseEvent){
        achievements temp = (com.example.cookieclicker.achievements) achievementsList.getSelectionModel().getSelectedItem();
        achievementName.setText(temp.name);
        achievementRequirement.setText("Requirement:" + String.valueOf(temp.cookieRequirement));
        achievementOwned.setText("Owned:" + String.valueOf(temp.achieved));
        if(Integer.valueOf(cookieCount.getText())>=temp.cookieRequirement){
            temp.achieved = true;
        }

    }

    public void buyOne(ActionEvent actionEvent) {
        upgrade temp = (com.example.cookieclicker.upgrade) upgradeList.getSelectionModel().getSelectedItem();
        if(temp.getCost()<=Integer.parseInt(cookieCount.getText())) {
            cookieCount.setText(String.valueOf(Integer.parseInt(cookieCount.getText()) - temp.getCost()));
            cookiesPerSecondAmt.setText(String.valueOf(Integer.parseInt(cookiesPerSecondAmt.getText())+temp.cps));
            upgQuantity.setText(String.valueOf(Integer.parseInt(upgQuantity.getText())+1));
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not enough cookies!");
            alert.setContentText("You do not have enough cookies to purchase this upgrade.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    public void buyTen(ActionEvent actionEvent) {
        upgrade temp = (com.example.cookieclicker.upgrade) upgradeList.getSelectionModel().getSelectedItem();
        if(temp.getCost()*10<=Integer.parseInt(cookieCount.getText())) {
            cookieCount.setText(String.valueOf(Integer.parseInt(cookieCount.getText()) - temp.getCost()*10));
            cookiesPerSecondAmt.setText(String.valueOf(Integer.parseInt(cookiesPerSecondAmt.getText())+temp.cps*10));
            upgQuantity.setText(String.valueOf(Integer.parseInt(upgQuantity.getText())+10));
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not enough cookies!");
            alert.setContentText("You do not have enough cookies to purchase this upgrade.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    public void viewClickUpgrade(MouseEvent mouseEvent) {
        clickUpgrade temp = (com.example.cookieclicker.clickUpgrade) clickUpgradesList.getSelectionModel().getSelectedItem();
        clickUpgradeName.setText(temp.name);
        clickUpgradeCost.setText(String.valueOf(temp.getCost()));
        clickUpgradeCpc.setText(String.valueOf(temp.cpc));
        clickUpgradeDescription.setText(temp.description);
    }

    public void buyClickerUpgrade(ActionEvent actionEvent) {
        //creates variable named temp to view properties of upgrade in gui
        clickUpgrade temp = (com.example.cookieclicker.clickUpgrade) clickUpgradesList.getSelectionModel().getSelectedItem();
        if (temp.getCost() <= Integer.parseInt( cookieCount.getText())){
            cookieCount.setText(String.valueOf(Integer.parseInt(cookieCount.getText()) - temp.getCost()));
            cookiesPerClickAmt.setText(String.valueOf(temp.cpc));
            temp.owned = true;
        }
        else if(temp.owned){
            //creates alert to notify if you own upgrade
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("You already own this upgrade!");
            alert.setContentText("You already have purchased this upgrade!");
            Optional<ButtonType> result = alert.showAndWait();
        }
        else {
            //creates alert to notify if you cannot afford upgrade
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not enough cookies!");
            alert.setContentText("You do not have enough cookies to purchase this upgrade.");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
}