package exercise.ex01.codes.after;

public class ExternalDecorator extends ContentDecorator {

    public ExternalDecorator(EmailContent decoratedContent) {
        super(decoratedContent);
    }

    @Override
    public String getContent() {
        String content = super.getContent();
        return addDisclaimer(content);
    }

    private String addDisclaimer(String content) {
        return content + " Company Disclaimer";
    }

}
