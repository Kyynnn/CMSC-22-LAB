/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kyn Mark N. Trongcao
 */

public class StudentNumberAlreadyExistsException extends Exception {
    String studentNumber;
    
    public StudentNumberAlreadyExistsException(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    String getInfo() {
        return "Student number " + studentNumber + " already exists.";
    }
}

