package com.xyz.portal.domain.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="event_id")
    private long eventId;


}
