package com.leonovich.itcrowd.model;

import java.io.Serializable;

/**
 * Copy of domain entity Topic
 * Created by alexanderleonovich on 14.08.15.
 */
public class TopicDTO implements Serializable {

    private static final long serialVersionUID = -2042384623065333455L;

    private Long topicId;

    private String topicName;

    public TopicDTO() {
    }

    public TopicDTO(Long topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
    }

    public TopicDTO(String topicName) {
        this.topicName = topicName;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopicDTO topicDTO = (TopicDTO) o;

        if (topicId != null ? !topicId.equals(topicDTO.topicId) : topicDTO.topicId != null) return false;
        return !(topicName != null ? !topicName.equals(topicDTO.topicName) : topicDTO.topicName != null);

    }

    @Override
    public int hashCode() {
        int result = topicId != null ? topicId.hashCode() : 0;
        result = 31 * result + (topicName != null ? topicName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TopicDTO{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                '}';
    }
}
