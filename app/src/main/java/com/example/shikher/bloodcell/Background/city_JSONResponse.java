package com.example.shikher.bloodcell.Background;

public class city_JSONResponse {
    private AndroidVersion[] city;

    public AndroidVersion[] getAndroid() {
        return city;
    }

    public static class AndroidVersion {
        private String bankName;
        private String phone;
        private String city;

        public String getBankName() {
            return bankName;
        }

        public String getPhone() {
            return phone;
        }

        public String getCity() {
            return city;
        }
    }
}
