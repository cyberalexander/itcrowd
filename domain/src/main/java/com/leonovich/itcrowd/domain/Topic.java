package com.leonovich.itcrowd.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Domain entity Topic
 * Created by alexanderleonovich on 14.08.15.
 */
@Entity
@Table(name = "T_TOPICS")
public class Topic implements Serializable {

    private static final long serialVersionUID = -3671461721754181991L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "F_TOPIC_ID")
    private Long topicId;

    @Column(name = "F_TOPIC_NAME")
    private String topicName;

    @OneToMany(mappedBy = "topic", fetch = LAZY)
    private Set<Inquiry> inquiries;

    public Topic() {
    }

    public Topic(Long topicId, String topicName) {
        this.topicId = topicId;
        this.topicName = topicName;
    }

    public Topic(String topicName) {
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

    public Set<Inquiry> getInquiries() {
        return inquiries;
    }

    public void setInquiries(Set<Inquiry> inquiries) {
        this.inquiries = inquiries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        if (topicId != null ? !topicId.equals(topic.topicId) : topic.topicId != null) return false;
        return !(topicName != null ? !topicName.equals(topic.topicName) : topic.topicName != null);

    }

    @Override
    public int hashCode() {
        int result = topicId != null ? topicId.hashCode() : 0;
        result = 31 * result + (topicName != null ? topicName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                '}';
    }
}
