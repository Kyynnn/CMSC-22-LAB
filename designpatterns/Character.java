/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

/**
 *
 * @author Kyn Mark N. Trongcao
 */
public class Character {
    WeaponBehavior weapon;
    
    public Character(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
    
    public void fight() {
        weapon.useWeapon();
    }
    
    public void setWeapon(WeaponBehavior w) {
        this.weapon = w;
    }
}
