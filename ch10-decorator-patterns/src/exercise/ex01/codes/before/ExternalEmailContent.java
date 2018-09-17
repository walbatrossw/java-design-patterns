package exercise.ex01.codes.before;

public class ExternalEmailContent extends BasicEmailContent {

    public ExternalEmailContent(String content) {
        super(content);
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
