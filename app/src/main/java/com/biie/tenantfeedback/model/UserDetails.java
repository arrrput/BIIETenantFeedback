package com.biie.tenantfeedback.model;

public class UserDetails {

        private int id;
        private String name;
        private int email;
        private int email_verified_at;
        private int created_at;
        private int updated_at;
        private int id_department;
        private int image;
        private int nohp;

        public UserDetails() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getEmail() {
            return email;
        }

        public void setEmail(int email) {
            this.email = email;
        }

        public int getEmail_verified_at() {
            return email_verified_at;
        }

        public void setEmail_verified_at(int email_verified_at) {
            this.email_verified_at = email_verified_at;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        public int getId_department() {
            return id_department;
        }

        public void setId_department(int id_department) {
            this.id_department = id_department;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public int getNohp() {
            return nohp;
        }

        public void setNohp(int nohp) {
            this.nohp = nohp;
        }
}
