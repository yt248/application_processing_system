package eugene.com.application.processing.system.model;

public enum StatusApplication {

    ToDo("К исполненю"),
    In_Progress("В процессе"),
    Done("Выполнено"),
    Closed("Отклонено");

    private final String title;

    StatusApplication(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    

}
