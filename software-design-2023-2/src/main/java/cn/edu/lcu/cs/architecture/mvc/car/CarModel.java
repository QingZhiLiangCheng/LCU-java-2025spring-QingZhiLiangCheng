package cn.edu.lcu.cs.architecture.mvc.car;

import java.net.URL;
import javax.swing.*;
import java.util.*;

public class CarModel implements Observable {
    private Vector<Observer> observers;
    private ImageIcon imgIcon;
    private URL url;

    private String[] carNameList;
    private String carSelected;
    private String bitPrice;
    private boolean isBitBtnClicked = false;
    private boolean isSearchBtnClicked = false;
    static final String CAR_FILES = "/car/CarFiles/";
    static final String CAR_IMAGES = "/car/CarImages/";

    public CarModel() {
        observers = new Vector<Observer>();
        carNameList = new String[200];
    }

    public void setCarList(String[] cars) {
        carNameList = cars;
    }

    public String[] getCarList() {
        return carNameList;
    }

    public void setSelectedCar(String sCar) {
        carSelected = sCar;
    }

    public String getSelectedCar() {
        return carSelected;
    }

    public void setBitPrice(String bPrice) {
        bitPrice = "";
        bitPrice = bitPrice + bPrice;
    }

    public String getBitPrice() {
        return bitPrice;
    }

    public void setCarFileUrl() {
        String fileURLStr = CAR_FILES + carSelected + ".html";
        url = getClass().getResource(fileURLStr);
    }

    public URL getCarFileURL() {
        return url;
    }

    public void setupImageIcon() {
        String iconStr = CAR_IMAGES + carSelected + ".jpg";
        imgIcon = createImageIcon(iconStr);
    }

    public ImageIcon getImageIcon() {
        return imgIcon;
    }

    public void setBitBtnClickInfo(boolean opt) {
        isBitBtnClicked = opt;
    }

    public boolean isBitBtnClicked() {
        return isBitBtnClicked;
    }

    public void setSearchBtnClickInfo(boolean opt) {
        isSearchBtnClicked = opt;
    }

    public boolean isSearchBtnClicked() {
        return isSearchBtnClicked;
    }

    @Override
    public void register(Observer obs) {
        observers.addElement(obs);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }

    protected ImageIcon createImageIcon(String path) {
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
} // End of class


