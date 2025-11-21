package com.atacorp.SISEAN.permission;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_user")
public class User  {
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nom;
    private String prenom;
    @NotNull
    private String login;  //Email ou Numéro de téléphone
    @NotNull
    private String motPasse;
    private boolean active;
    private boolean tokenExpire;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) //(mappedBy = "users") 
    @JoinTable(
    		name = "users_roles", 
    		joinColumns = @JoinColumn(
    				name = "User_id", referencedColumnName = "id"),
    		inverseJoinColumns = @JoinColumn(
    				name = "Role_id", referencedColumnName = "id")) 
    private List<Role> roles = new ArrayList<>();
    
    
}
