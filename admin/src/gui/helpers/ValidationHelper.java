/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.helpers;

import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

/**
 * A helper for input validation, ensuring the decimal format of a given 
 * textField.
 * 
 * @author adath325
 * @version 4.0
 */
public class ValidationHelper {

    public void addTypeFormatter(JFormattedTextField textField, 
            String format, Class<? extends Number> type) {
        DecimalFormat df = new DecimalFormat(format);
        NumberFormatter formatter = new NumberFormatter(df);
        formatter.setValueClass(type);
        formatter.setAllowsInvalid(false);
        DefaultFormatterFactory factory = new DefaultFormatterFactory(
                formatter);
        textField.setFormatterFactory(factory);
    }

    public boolean isObjectValid(Object domain) {
        Validator validator = new Validator();
        List<ConstraintViolation> violations = validator.validate(domain);
        if (violations.isEmpty()) {
            return true;
        } else {
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation violation : violations) {
                message.append(violation.getMessage()).append("\n");
            }
            JOptionPane.showMessageDialog(null, message.toString(),
                    "Input Problem", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
