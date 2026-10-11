/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

/**
 *
 * @author pramo
 */

public class LeadContributor extends TeamMember {

    public LeadContributor(String name, String role) {
        super(name, role);
    }

    @Override
    public String formatMessage(String message) {
        
        return "[LEAD] " + name + " (" + role + "): " + message;
    }
}
