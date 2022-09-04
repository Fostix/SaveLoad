package Example00.Core.MVP;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(View view) {
        this.model = new Model();
        this.view = view;
    }
}
