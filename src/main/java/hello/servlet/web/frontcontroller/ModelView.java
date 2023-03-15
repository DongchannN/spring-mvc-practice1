package hello.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ModelView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    public String getViewName() {
        return viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public ModelView(String viewName) {
        this.viewName = viewName;
    }
}
