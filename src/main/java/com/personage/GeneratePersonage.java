package com.personage;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
@Getter
@Setter
public class GeneratePersonage {
    Scanner scanner = new Scanner(System.in);
    private static final int MAX = 10;
    private static final int MIN = 1;
    private static final String NAME = "Имя";
    private static final String STR = "Сила";
    private static final String PER = "Восприятиеж";
    private static final String END = "Выносливость";
    private static final String CHA = "Харизма";
    private static final String INT = "Интелект";
    private static final String AGL = "Ловкость";
    private static final String LUC = "Удача";
    private static final String HDW = "Рукопашный бой";
    private static final String CLW = "Холодной оружие";
    private static final String TRW = "Метательное оружие";
    private static final String LTW = "Легкое оружие";
    private static final String HVW = "Тяжелое оружие";
    private static final String EXP = "Взрывчатка";
    private static final String MED = "Медицина";

    private String name = null;

    private int atrPoints = 15;
    private int statPoints = 25;

    private int strong = 5;
    private int perception = 5;
    private int endurance = 5;
    private int charisma = 5;
    private int intelligence = 5;
    private int agility = 5;
    private int lucky = 5;

    private int handedWeapon;
    private int coldWeapon;
    private int throwingWeapon;
    private int lightWeapon;
    private int heavyWeapon;
    private int explosives;

    private int medical;

    public void menuGenerate(){
        boolean exit;
        exit = true;
        while (exit) {
            switch (scanner.nextLine()) {
                case "1" -> {
                    while (exit) {
                        System.out.println("Выберите аттрибут: ");
                        switch (scanner.nextLine()) {
                            case "1" -> setStrong(distribution(strong, STR, atrPoints));
                            case "2" -> setPerception(distribution(perception, PER, atrPoints));
                            case "3" -> setEndurance(distribution(endurance, END, atrPoints));
                            case "4" -> setCharisma(distribution(charisma, CHA, atrPoints));
                            case "5" -> setIntelligence(distribution(intelligence, INT, atrPoints));
                            case "6" -> setAgility(distribution(agility, AGL, atrPoints));
                            case "7" -> setLucky(distribution(lucky, LUC, atrPoints));
                            case "0" -> exit = false;
                        }
                    }
                }
                case "2" -> {
                    while (exit){
                      switch (scanner.nextLine()) {
                          case "1" -> setHandedWeapon(distribution(handedWeapon, HDW, statPoints));
                          case "2" -> setColdWeapon(distribution(coldWeapon, CLW, statPoints));
                          case "3" -> setThrowingWeapon(distribution(throwingWeapon, TRW, statPoints));
                          case "4" -> setLightWeapon(distribution(lightWeapon, LTW, statPoints));
                          case "5" -> setHeavyWeapon(distribution(heavyWeapon, HVW, statPoints));
                          case "6" -> setExplosives(distribution(explosives, EXP, statPoints));
                          case "7" -> setMedical(distribution(medical,MED, statPoints));
                          case "0" -> exit = false;
                      }
                    }
                }
            }
        }
    }


    private int distribution(int attr, String nameAttr, int p) {
        boolean exit;
        exit = true;
        System.out.println(nameAttr + ": " + attr);
        while (exit) {
            System.out.println("1 - Прибавить\n2 - Убавить");
            System.out.println("0 - Вернуться к выбору");

            switch (scanner.nextLine()) {
                case "1" -> attr = plusAttrStPoint(attr, p--);
                case "2" -> attr = minusAttrStPoint(attr, p++);
                case "0" -> exit = false;
            }
            System.out.println(nameAttr + " - " + attr);
            System.out.println("Свободные очки " + p);
            System.out.println(getStrong());
        }
        return attr;
    }

    private int plusAttrStPoint(int atr, int p) {
        if (atr == MAX){
            return MAX;
        }
        if (p < MIN){
            System.out.println("Нет свободных очков");
        }
        return atr + 1;
    }

    private int minusAttrStPoint(int atr, int p) {
        if (atr == MIN){
            return MIN;
        }
        return --atr;
    }
    private String nameHiro(){
        name = scanner.nextLine();
        return name;
    }

    private int plus(int p){
        p++;
        return p;
    }

    private int minus(int p){
        p-=1;
        return p;
    }

    public void setStrong(int strong) {
        this.strong = strong;
    }

    public int getStrong() {
        return strong;
    }
}
