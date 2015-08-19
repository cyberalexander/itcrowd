package com.leonovich.itcrowd.web.configuration;

import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;

import java.util.HashMap;
import java.util.Map;

/**
 * Configure tiles definitions on application.
 * Created by alexanderleonovich on 16.08.15.
 */
public class TilesConfig implements DefinitionsFactory {

    private static final Map<String, Definition> tilesDefinitions = new HashMap<>();
    private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/view/layout/default.jsp");


    /**
     * @param name  <code>Name of the view</code>
     * @param title <code>Page title</code>
     * @param body  <code>Body JSP file path</code>
     *              <p/>
     *              <code>Adds default layout definitions</code>
     */
    private static void addDefaultLayout(String name, String title, String body) {
        Map<String, Attribute> attributes = new HashMap<>();

        attributes.put("title", new Attribute(title));
        attributes.put("header", new Attribute("/WEB-INF/view/layout/header.jsp"));
        attributes.put("body", new Attribute(body));
        attributes.put("footer", new Attribute("/WEB-INF/view/layout/footer.jsp"));

        tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
    }

    /**
     * Registration of tiles views pages
     */
    public static void addDefinitions() {
        addDefaultLayout("main", "Main", "/WEB-INF/view/main.jsp");
        addDefaultLayout("topics", "Topics list", "/WEB-INF/view/topics.jsp");
        addDefaultLayout("inquiry", "Inquiry", "/WEB-INF/view/inquiry.jsp");
        addDefaultLayout("edit_inquiry", "Edit Inquiry info", "/WEB-INF/view/edit_inquiry.jsp");
        addDefaultLayout("add_inquiry", "Add Inquiry", "/WEB-INF/view/add_inquiry.jsp");
        addDefaultLayout("add_attribute", "Adding Attributes", "/WEB-INF/view/add_attribute.jsp");
        addDefaultLayout("error", "Error", "/WEB-INF/view/error.jsp");
    }

    /**
     * Add Apache tiles definitions
     */
    @Override
    public Definition getDefinition(String name, Request request) {
        return tilesDefinitions.get(name);
    }
}
