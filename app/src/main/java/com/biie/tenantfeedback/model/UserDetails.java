package com.biie.tenantfeedback.model;

public class UserDetails {

        private int id;
        private String name;
        private String email;
        private String email_verified_at;
        private String created_at;
        private String updated_at;
        private int id_department;
        private String image;
        private String nohp;

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail_verified_at() {
            return email_verified_at;
        }

        public void setEmail_verified_at(String email_verified_at) {
            this.email_verified_at = email_verified_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public int getId_department() {
            return id_department;
        }

        public void setId_department(int id_department) {
            this.id_department = id_department;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getNohp() {
            return nohp;
        }

        public void setNohp(String nohp) {
            this.nohp = nohp;
        }
}
