package exercise.ex01.codes.before;

public class SecureEmailContent extends BasicEmailContent {

    public SecureEmailContent(String content) {
        super(content);
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
