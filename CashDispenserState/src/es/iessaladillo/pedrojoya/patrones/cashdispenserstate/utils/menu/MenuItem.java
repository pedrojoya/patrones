package es.iessaladillo.pedrojoya.patrones.cashdispenserstate.utils.menu;

public class MenuItem {

    private final String title;
    private final Runnable action;

    public MenuItem(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    void executeAction() {
        action.run();
    }

}
