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

public class CharacterTest {
    public static void main(String[] args) {
      	Character kingKnife = new King(new KnifeBehavior());
	Character kingBowAndArrow = new King(new BowAndArrowBehavior());
        Character kingSword = new King(new SwordBehavior());
        Character kingAxe = new King(new AxeBehavior());
		
        System.out.println("King fiercely raises his weapon:");
		
        kingKnife.fight();
	kingBowAndArrow.fight();
        kingSword.fight();
	kingAxe.fight();
        System.out.println();

	Character queenKnife = new Queen(new KnifeBehavior());
        Character queenBowAndArrow = new Queen(new BowAndArrowBehavior());
	Character queenSword = new Queen(new SwordBehavior());
        Character queenAxe = new Queen(new AxeBehavior());
                
	System.out.println("Queen graciously readies her weapon:");
		
        queenKnife.fight();
	queenBowAndArrow.fight();
        queenSword.fight();
	queenAxe.fight();
        System.out.println();
		
	Character knightKnife = new Knight(new KnifeBehavior());
        Character knightBowAndArrow = new Knight(new BowAndArrowBehavior());
	Character knightSword = new Knight(new SwordBehavior());
        Character knightAxe = new Knight(new AxeBehavior());
                
	System.out.println("Knight charges with his weapon:");
		
        knightKnife.fight();
	knightBowAndArrow.fight();
        knightSword.fight();
	knightAxe.fight();
        System.out.println();
        
	Character trollKnife = new Troll(new KnifeBehavior());
        Character trollBowAndArrow = new Troll(new BowAndArrowBehavior());
	Character trollSword = new Troll(new SwordBehavior());
        Character trollAxe = new Troll(new AxeBehavior());
		
        System.out.println("Troll groans while waving its weapon:");
        trollKnife.fight();
	trollBowAndArrow.fight();
        trollSword.fight();
	trollAxe.fight();
        System.out.println();
	
        System.out.println("King using setWeapon method:");
        Character king = new King(new KnifeBehavior());
	king.fight();
        king.setWeapon(new BowAndArrowBehavior());
	king.fight();
        king.setWeapon(new SwordBehavior());
	king.fight();
        king.setWeapon(new AxeBehavior());
	king.fight();
        System.out.println();
		
	System.out.println("Queen using setWeapon method:");
        Character queen = new Queen(new KnifeBehavior());
	queen.fight();
        queen.setWeapon(new BowAndArrowBehavior());
	queen.fight();
        queen.setWeapon(new SwordBehavior());
	queen.fight();
        queen.setWeapon(new AxeBehavior());
	queen.fight();
	System.out.println();
		
        System.out.println("Knight using setWeapon method:");
        Character knight = new Knight(new KnifeBehavior());
        knight.fight();
	knight.setWeapon(new BowAndArrowBehavior());
        knight.fight();
	knight.setWeapon(new SwordBehavior());
        knight.fight();
	knight.setWeapon(new AxeBehavior());
        knight.fight();
	System.out.println();
		
        System.out.println("Troll using setWeapon method :");
	Character troll = new Troll(new KnifeBehavior());
        troll.fight();
	troll.setWeapon(new BowAndArrowBehavior());
        troll.fight();
	troll.setWeapon(new SwordBehavior());
        troll.fight();
	troll.setWeapon(new AxeBehavior());
        troll.fight();
	System.out.println();
    }
}