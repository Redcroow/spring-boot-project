package com.cogenio.springbootproject.model.json;

import com.cogenio.springbootproject.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

public class UserResponse {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo {
        private String username;
        private String email;

        public UserInfo(User user) {
            this.username = user.getUsername();
            this.email = user.getEmail();
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserGetAllResponse {
        private String status;
        private String message;
        private int statusCode;
        private List<UserInfo> data;

        public UserGetAllResponse(HttpStatus httpStatus, String message, List<UserInfo> data) {
            this.status = httpStatus.is2xxSuccessful() ? "success" : "error";
            this.statusCode = httpStatus.value();
            this.message = message;
            this.data = data;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserCreateResponse {
        private String status;
        private String message;
        private int statusCode;
        private Object data;

        public UserCreateResponse(HttpStatus httpStatus, String message, Object data) {
            this.status = httpStatus.is2xxSuccessful() ? "success" : "error";
            this.statusCode = httpStatus.value();
            this.message = message;
            this.data = data;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserDeleteResponse {
        private String status;
        private String message;
        private int statusCode;

        public UserDeleteResponse(HttpStatus httpStatus, String message) {
            this.status = httpStatus.is2xxSuccessful() ? "success" : "error";
            this.statusCode = httpStatus.value();
            this.message = message;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserUpdateResponse {
        private String status;
        private String message;
        private int statusCode;
        private User beforeUpdate;
        private User afterUpdate;

        public UserUpdateResponse(HttpStatus httpStatus, String message, User beforeUpdate, User afterUpdate) {
            this.status = httpStatus.is2xxSuccessful() ? "success" : "error";
            this.statusCode = httpStatus.value();
            this.message = message;
            this.beforeUpdate = beforeUpdate;
            this.afterUpdate = afterUpdate;
        }
    }

}
