package ro.utcn.hori.UI;

import ro.utcn.hori.UI.UI;
import ro.utcn.hori.model.Polynomial;
import ro.utcn.hori.operations.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    public Controller(UI ui) {
//        ui.addComputeButtonActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
        ui.addAddButtonActionListener(e -> {
            BinaryOperation add = new AddOperation();
            Polynomial result = add.perform(new Polynomial(ui.getField1Value()), new Polynomial(ui.getField2Value()));
            ui.setResult(result.toString());
        });
        ui.addSubtractButtonActionListener(e -> {
            BinaryOperation subtract = new SubtractionOperation();
            Polynomial result = subtract.perform(new Polynomial(ui.getField1Value()), new Polynomial(ui.getField2Value()));
            ui.setResult(result.toString());
        });
        ui.addMultiplicationButtonActionListener(e -> {
            BinaryOperation multiplication = new MultiplicationOperation();
            Polynomial result = multiplication.perform(new Polynomial(ui.getField1Value()), new Polynomial(ui.getField2Value()));
            ui.setResult(result.toString());
        });
        ui.addDivisionButtonActionListener(e -> {
            BinaryOperation division = new DivisionOperation();
            try {
                Polynomial result = division.perform(new Polynomial(ui.getField1Value()), new Polynomial(ui.getField2Value()));
                ui.setResult(result.toString());
            } catch(ArithmeticException ex) {
                System.out.println(ex);
                ui.setResult("Cannot divide by 0!");
            }
        });
        ui.addIntegrationButtonActionListener(e -> {
            UnaryOperation integration = new IntegrationOperation();
            String polyString = "";
            if(ui.getField1Value().length() == 0) {
                polyString = ui.getField2Value();
            } else {
                polyString = ui.getField1Value();
            }
            Polynomial result = integration.perform(new Polynomial(polyString));
            ui.setResult(result.toString());
        });
        ui.addDerivativeButtonActionListener(e -> {
            UnaryOperation derivative = new DerivativeOperation();
            String polyString = "";
            if(ui.getField1Value().length() == 0) {
                polyString = ui.getField2Value();
            } else {
                polyString = ui.getField1Value();
            }
            Polynomial result = derivative.perform(new Polynomial(polyString));
//            Polynomial result = derivative.perform(new Polynomial(ui.getField1Value()));
            ui.setResult(result.toString());
        });
    }
}
