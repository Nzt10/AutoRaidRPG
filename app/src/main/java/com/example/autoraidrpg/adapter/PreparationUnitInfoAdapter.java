package com.example.autoraidrpg.adapter;

import com.example.autoraidrpg.model.Position;
import com.example.autoraidrpg.model.Role;
import com.example.autoraidrpg.model.RoleCollection;

import java.io.Serializable;

public class PreparationUnitInfoAdapter implements Serializable {

    private Role role;
    private RoleCollection roleCollection;
    private Position position;

    public PreparationUnitInfoAdapter(Role role, RoleCollection roleCollection, Position position) {
        this.role = role;
        this.roleCollection = roleCollection;
        this.position = position;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public RoleCollection getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(RoleCollection roleCollection) {
        this.roleCollection = roleCollection;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "PreparationUnitInfoAdapter{" +
                "role=" + role +
                ", roleCollection=" + roleCollection +
                ", position=" + position +
                '}';
    }

}
