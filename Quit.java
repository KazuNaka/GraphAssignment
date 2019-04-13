public class Quit implements Command {
    private String response;
    public Quit(String res) {
        response = res;
    }
    @Override
    public void execute() {
        response = "quit";
    }
}