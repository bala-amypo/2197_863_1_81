package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.*;


@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false)
private String fullName;


@Column(nullable = false, unique = true)
private String email;


@Column(nullable = false)
private String department;


@Column(nullable = false)
private String role;


@Column(nullable = false)
private String password;


private LocalDateTime createdAt;


public User() {}


public User(Long id, String fullName, String email, String department, String role, String password) {
this.id = id;
this.fullName = fullName;
this.email = email;
this.department = department;
this.role = role;
this.password = password;
}


@PrePersist
public void prePersist() {
if (role == null) role = "USER";
if (createdAt == null) createdAt = LocalDateTime.now();
}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public String getFullName() { return fullName; }
public void setFullName(String fullName) { this.fullName = fullName; }


public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }


public String getDepartment() { return department; }
public void setDepartment(String department) { this.department = department; }


public String getRole() { return role; }
public void setRole(String role) { this.role = role; }


public String getPassword() { return password; }
}