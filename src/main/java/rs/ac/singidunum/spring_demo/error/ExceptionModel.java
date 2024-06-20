package rs.ac.singidunum.spring_demo.error;

public class ExceptionModel {
    private ExceptionModel exceptionModel;
    private String Name;
    private String Message;
    private String Path;

    public ExceptionModel(ExceptionModel exceptionModel, String name, String message, String path) {
        this.exceptionModel = exceptionModel;
        Name = name;
        Message = message;
        Path = path;
    }

    public ExceptionModel getExceptionModel() {
        return exceptionModel;
    }

    public void setExceptionModel(ExceptionModel exceptionModel) {
        this.exceptionModel = exceptionModel;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }
}
