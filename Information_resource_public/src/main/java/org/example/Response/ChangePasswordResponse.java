package org.example.Response;

public class ChangePasswordResponse {
        private boolean success;
        private String message;

        // Getter and Setter methods

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
}


