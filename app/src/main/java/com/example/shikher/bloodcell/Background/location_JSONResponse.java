package com.example.shikher.bloodcell.Background;

/**
 * Created by shikher on 12/7/17.
 */
public class location_JSONResponse {
    private AndroidVersion[] location;

    public AndroidVersion[] getAndroid() {
        return location;
    }

    public static class AndroidVersion {
        private String bankName;
        private String coordinateX;
        private String coordinateY;

        public String getBankName() {
            return bankName;
        }

        public String getCoordinateX() {
            return coordinateX;
        }

        public String getCoordinateY() {
            return coordinateY;
        }
    }
}

