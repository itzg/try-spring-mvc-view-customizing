package me.itzg.tryspringmvcviewcustomizing;

import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

@Component
public class PlainTextViewResolver implements ViewResolver {

  @Override
  public View resolveViewName(String viewName, Locale locale) throws Exception {
    return new PlainTextView(viewName);
  }

  public static class PlainTextView implements View {

    private final String viewName;

    public PlainTextView(String viewName) {
      this.viewName = viewName;
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", PlainTextView.class.getSimpleName() + "[", "]")
          .add("viewName='" + viewName + "'")
          .toString();
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest req,
                       HttpServletResponse resp) throws Exception {
      resp.getWriter().printf("Some plain text for the request view '%s'", viewName);
    }

    @Override
    public String getContentType() {
      return MediaType.TEXT_PLAIN_VALUE;
    }
  }
}
