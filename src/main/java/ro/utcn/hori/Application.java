package ro.utcn.hori;

import ro.utcn.hori.UI.Controller;
import ro.utcn.hori.UI.UI;

public class Application {
    public static void main(String[] args) {
        UI ui = new UI();
        ui.show();
        Controller controller = new Controller(ui);
    }
}
