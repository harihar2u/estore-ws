package com.online.estore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntityResponse {
    @JsonProperty("Entity")
    private Entity response;

    @JsonProperty("Metadata")
    private List<Metadata> metadatas;

    public Entity getResponse() {
        return response;
    }

    public void setResponse(Entity response) {
        this.response = response;
    }

    public List<Metadata> getMetadatas() {
        return metadatas;
    }

    public void setMetadatas(List<Metadata> metadatas) {
        this.metadatas = metadatas;
    }


    public static class Entity implements Serializable {
        @JsonProperty("ApprovalCode")
        private String approvalCode;

        @JsonProperty("ResponseCode")
        private String responseCode;

        public String getApprovalCode() {
            return approvalCode;
        }

        public void setApprovalCode(String approvalCode) {
            this.approvalCode = approvalCode;
        }

        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "approvalCode='" + approvalCode + '\'' +
                    ", responseCode='" + responseCode + '\'' +
                    '}';
        }
    }

    public static class Metadata implements Serializable {
        @JsonProperty("Text")
        private String text;

        @JsonProperty("Type")
        private String code;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return "Metadata{" +
                    "text='" + text + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "EntityResponse{" +
                "response=" + response +
                ", metadatas=" + metadatas +
                '}';
    }
}
