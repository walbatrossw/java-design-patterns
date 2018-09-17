package exercise.ex01.codes.after;

public class ContentDecorator extends EmailContent {

    private EmailContent decoratedContent;

    public ContentDecorator(EmailContent decoratedContent) {
        this.decoratedContent = decoratedContent;
    }

    @Override
    public String getContent() {
        return decoratedContent.getContent();
    }
}
