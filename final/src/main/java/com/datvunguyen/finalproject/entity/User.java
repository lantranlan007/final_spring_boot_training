package com.datvunguyen.finalproject.entity;

import java.io.Serializable;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table
public class User implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid", strategy = "uuid2")
	private String id;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column(unique = true, name = "display_name")
	private String displayName;

	@Column(unique = true)
	private String email;
	
	@Column
	private String status;
	
	@OneToOne
	@JoinColumn(name = "created_by")
	private User createdBy;
	
	@Column(name = "created_date", nullable = false, insertable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	private String createDate;
	
	@Column(name = "modified_date")
	@Temporal(TemporalType.DATE)
	private String modifiedDate;
	
	@Column(name = "first_logged_in_date", nullable = false, insertable = false, updatable = false)
	@Temporal(TemporalType.DATE)
	private String firstLoggedInDate;
	
	
}
