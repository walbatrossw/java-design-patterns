package exercise.ex01.codes.after;

public class SecureDecorator extends ContentDecorator {

    public SecureDecorator(EmailContent decoratedContent) {
        super(decoratedContent);
    }

    @Override
    public String getContent() {
        String content = super.getContent();
        return encrypt(content);
    }

    private String encrypt(String content) {
        return content + " Encrypted";
    }

}
