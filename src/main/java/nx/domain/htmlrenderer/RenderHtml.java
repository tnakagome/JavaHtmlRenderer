package nx.domain.htmlrenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.xhtmlrenderer.extend.TextRenderer;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.swing.Java2DRenderer;
import org.xhtmlrenderer.util.FSImageWriter;

public class RenderHtml {
    static void render(File htmlFile) throws IOException {
        File imageFile = new File(htmlFile.getAbsolutePath().replaceFirst("\\.html$", ".png"));
        Java2DRenderer renderer = new Java2DRenderer(htmlFile, 400, 300);
        SharedContext context = renderer.getSharedContext();
        TextRenderer textRenderer = context.getTextRenderer();
        textRenderer.setSmoothingThreshold(8.0f);
        BufferedImage image = renderer.getImage();
        FSImageWriter writer = new FSImageWriter();
        writer.write(image, imageFile.getAbsolutePath());
    }

    public static void main(String[] args) throws IOException {
        RenderHtml.render(new File("src/test/resources/sample.html"));
    }

}
