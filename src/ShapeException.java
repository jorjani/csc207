public class ShapeException extends ClassCastException {
    private String customMessage;

    @Override
    public String getMessage() {
        return customMessage + super.getMessage();
    }

    public ShapeException(String customMessage){
        this.customMessage = customMessage;
    }
}
