package com.listview.namandoshi;

/**
 * Created by Naman Doshi on 1/20/2017.
 */

public class learnLanguages {

        private String nameOfLang;
        private int imageID;
        private int tutorialNumber;

        public learnLanguages(String nameOfLang, int imageID, int tutorialNumber) {
            this.nameOfLang = nameOfLang;
            this.imageID = imageID;
            this.tutorialNumber = tutorialNumber;
        }

        public String getNameOfLang() {
            return nameOfLang;
        }

        public int getImageID() {
            return imageID;
        }

        public int getTutorialNumber() {
            return tutorialNumber;
        }


    }

