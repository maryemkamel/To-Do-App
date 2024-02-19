package com.example.demo.Entity;

import com.example.demo.Entity.Enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Check if null
    @Column(name = "title",nullable = false)
    private String title;


    @Column(name = "description")
    private String description;

    //Change to enum
    //Check if null
    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private Status status;

    //Check if null
    //Check if date is valid (due date in the futur)
    @NotNull(message = "test")
    @Column(name = "due_date", nullable = false)
    private Date dueDate;


    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
