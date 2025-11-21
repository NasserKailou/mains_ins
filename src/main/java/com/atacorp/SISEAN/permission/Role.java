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
@Table(name = "t_role")
public class Role {
	 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String libelle;
    @ManyToMany (mappedBy = "roles")
    private List<User> users = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "roles_privileges", 
        joinColumns = @JoinColumn(
          name = "Role_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "Privilege_id", referencedColumnName = "id"))
    private List<Privilege> privileges = new ArrayList<>();
}