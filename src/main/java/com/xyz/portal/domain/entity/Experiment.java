package com.xyz.portal.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
@Table(name="experiment")
public class Experiment implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="experiment_id")
    private long experimentId;


    @JsonIgnore
    @Column(name="max_visitor")
    private long maxVisitor;


    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable=false)
    private Status status;


    @JsonIgnore
    @Column(name="created_date", nullable=false)
    private Date createdDate;


    @JsonIgnore
    @Column(name="timeout_date", nullable=false)
    private Date timeoutDate;


    @JsonIgnore
    @Column(name="terminated_date")
    private Date terminatedDate;


    @JsonIgnore
    @Column(name="log")
    private String log;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private Project project ;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="billing_id")
    private Billing billing;


    @OneToMany(mappedBy="experiment", fetch=FetchType.EAGER)
    private List<Variation> variationList;


    public enum Status {
        READY,              // 실험 시작시 디폴트 값
        RUNNING,            // 실험 중
        TIME_EXCEED,        // TIMEOUT Batch에 의해 변경 됨
        VISITOR_EXCEED,     // VISITOR Batch에 의해 변경 됨
        STOP,               // 실험 중지 (어떤 이벤트도 발생시키지 않는다, 상태 변경 가능하다. 유저가 변경 가능)
        TERMINATED,         // 실험 종료 (어떤 상태로도 변경 불가하다. 빌링 대상이된다.)
        DELETE
    }
}
